import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class appointmentRecords extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField search_Field;
	private JTable table;
	private DefaultTableModel tableModel;
	private Set<String> uniqueIdentifiers;
	private JFrame dashboardFrame;
	
	private void initialize() {
		uniqueIdentifiers = new HashSet<>();
		
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblPetAppointmentRecords = new JLabel("PET APPOINTMENT RECORDS");
		lblPetAppointmentRecords.setForeground(Color.WHITE);
		lblPetAppointmentRecords.setFont(new Font("Verdana", Font.BOLD, 35));
		lblPetAppointmentRecords.setBounds(150, 0, 578, 75);
		getContentPane().add(lblPetAppointmentRecords);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 75);
		getContentPane().add(textArea);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBackground(new Color(255, 182, 193));
		searchPanel.setBounds(279, 86, 282, 62);
		getContentPane().add(searchPanel);
		
		search_Field = new JTextField();
		search_Field.setColumns(10);
		search_Field.setBounds(21, 11, 237, 20);
		searchPanel.add(search_Field);
		
		JLabel lblInputSearchKeywords = new JLabel("Input search keywords");
		lblInputSearchKeywords.setForeground(Color.BLACK);
		lblInputSearchKeywords.setFont(new Font("Verdana", Font.ITALIC, 13));
		lblInputSearchKeywords.setBounds(59, 21, 161, 41);
		searchPanel.add(lblInputSearchKeywords);
		
		JPanel tableAppointmentRecordPanel = new JPanel();
		tableAppointmentRecordPanel.setLayout(null);
		tableAppointmentRecordPanel.setBackground(new Color(255, 182, 193));
		tableAppointmentRecordPanel.setBounds(10, 170, 864, 363);
		getContentPane().add(tableAppointmentRecordPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 844, 341);
		tableAppointmentRecordPanel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);
        
        tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        
        tableModel.addColumn("Appointment ID");
        tableModel.addColumn("Date");
        tableModel.addColumn("Time");
        tableModel.addColumn("Pet ID");
        tableModel.addColumn("Pet Name");
        tableModel.addColumn("Client ID");
        tableModel.addColumn("Client Name");
        table.setModel(tableModel);
        
        
       
        JButton btnClientAndPet = new JButton("Client and Pet Records");
        btnClientAndPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnClientAndPet.setBackground(new Color(255, 240, 245));
        btnClientAndPet.setBounds(688, 108, 186, 25);
        getContentPane().add(btnClientAndPet);
        
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int fontSize = table.getFont().getSize();
                table.setRowHeight(row, fontSize + 6);
                return cellComponent;
            }
        });
        
        // LISTENERS
        addWindowListener(new WindowAdapter() { // exiting window
            public void windowClosing(WindowEvent e) {
                if (dashboardFrame != null) {
                    dashboardFrame.setEnabled(true);
                }
                dispose();
            }
        });
        
        search_Field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = search_Field.getText();
                
                if (keyword.isEmpty() | keyword == String.valueOf(0)) {
                    tableModel.setRowCount(0);
                    uniqueIdentifiers.clear();
                } else {
                    searchRecords(keyword);
                }
            }
        });
        
        btnClientAndPet.addActionListener(e -> {
        	clientAndPetRecords clientAndPetRecordsFrame = new clientAndPetRecords();
	        clientAndPetRecordsFrame.setDashboardFrame(dashboardFrame);
	        
	        this.dispose();
        });
	}
	
	
	private void searchRecords(String keyword) {
	    tableModel.setRowCount(0);
	    uniqueIdentifiers.clear();
	    
	    try {
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        ResultSet appointmentResultSet = dbManager.searchAppointmentByKeyword(keyword);
	        
	        while (appointmentResultSet.next()) {
	            String appointmentID = appointmentResultSet.getString("appointmentID");
	            Date date = appointmentResultSet.getDate("Date");
	            Time time = appointmentResultSet.getTime("Time");
	            String petID = appointmentResultSet.getString("petID");
	            String petName = appointmentResultSet.getString("petName");
	            String clientID = appointmentResultSet.getString("clientID");
	            String clientName = appointmentResultSet.getString("clientName");
	            String identifier = appointmentID + date + time + petID + petName + clientID + clientName;
	            
	            if (!uniqueIdentifiers.contains(identifier)) {
	                uniqueIdentifiers.add(identifier);
	                
	                SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm a");
	                String formattedTime = sdfTime.format(time);
	                
	                SimpleDateFormat sdfDate = new SimpleDateFormat("MMMM d, yyyy");
	                String formattedDate = sdfDate.format(date);
	                
	                uniqueIdentifiers.add(identifier);
	                tableModel.addRow(new String[]{appointmentID, formattedDate, formattedTime, petID, petName, clientID, clientName});
	        }
	        }
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }
	public appointmentRecords() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new appointmentRecords();
		});
	}
}