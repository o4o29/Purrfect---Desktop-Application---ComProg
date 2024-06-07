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
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class clientAndPetRecords extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField searchRecord_Field;
	private DefaultTableModel tableModel;
	private JTable table;
	private Set<String> uniqueIdentifiers;
	private JFrame dashboardFrame;
	
	private void initialize() {
		uniqueIdentifiers = new HashSet<>();
		
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblClientAndPet = new JLabel("CLIENT AND PET RECORDS");
		lblClientAndPet.setForeground(Color.WHITE);
		lblClientAndPet.setFont(new Font("Verdana", Font.BOLD, 35));
		lblClientAndPet.setBounds(159, 0, 532, 75);
		getContentPane().add(lblClientAndPet);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 75);
		getContentPane().add(textArea);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(255, 182, 193));
		searchPanel.setBounds(273, 86, 282, 62);
		getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		searchRecord_Field = new JTextField();
		searchRecord_Field.setBounds(21, 11, 237, 20);
		searchPanel.add(searchRecord_Field);
		searchRecord_Field.setColumns(10);
		
		JLabel lblInputSearchKeywords = new JLabel("Input search keywords");
		lblInputSearchKeywords.setBounds(59, 17, 161, 45);
		searchPanel.add(lblInputSearchKeywords);
		lblInputSearchKeywords.setForeground(new Color(0, 0, 0));
		lblInputSearchKeywords.setFont(new Font("Verdana", Font.ITALIC, 13));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBackground(new Color(255, 182, 193));
		tablePanel.setBounds(10, 177, 864, 373);
		getContentPane().add(tablePanel);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 844, 340);
        tablePanel.add(scrollPane);
        
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
        tableModel.addColumn("Pet ID");
        tableModel.addColumn("Pet Name");
        tableModel.addColumn("Client ID");
        tableModel.addColumn("Client Name");
        tableModel.addColumn("Client Contact");
        table.setModel(tableModel);
        
        JButton btnAppointmentRecords = new JButton("Appointment Records");
        btnAppointmentRecords.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAppointmentRecords.setBackground(new Color(255, 240, 245));
        btnAppointmentRecords.setBounds(688, 112, 186, 25);
        getContentPane().add(btnAppointmentRecords);
        
        
        // LISTENERS
        addWindowListener(new WindowAdapter() { // exiting window
            public void windowClosing(WindowEvent e) {
                if (dashboardFrame != null) {
                    dashboardFrame.setEnabled(true);
                }
                dispose();
            }
        });
        
        searchRecord_Field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = searchRecord_Field.getText();
                
                if (keyword.isEmpty() | keyword == String.valueOf(0)) {
                    tableModel.setRowCount(0);
                    uniqueIdentifiers.clear();
                } else {
                    searchRecords(keyword);
                }
            }
        });
        
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
        
        btnAppointmentRecords.addActionListener(e -> {
        	appointmentRecords appointmentRecordsFrame = new appointmentRecords();
        	appointmentRecordsFrame.setDashboardFrame(dashboardFrame);
        	
        	this.dispose();
        	
        });
	}
	
    
	private void searchRecords(String keyword) {
	    tableModel.setRowCount(0);
	    uniqueIdentifiers.clear();
	    
	    try {
	        DatabaseManager dbManager = DatabaseManager.getInstance();

	        ResultSet clientResultSet = dbManager.searchClientByKeyword(keyword);
	        while (clientResultSet.next()) {
	            String clientID = clientResultSet.getString("clientID");
	            String firstName = clientResultSet.getString("firstName");
	            String lastName = clientResultSet.getString("lastName");
	            String contactNumber = clientResultSet.getString("contactNumber");

	            if (!uniqueIdentifiers.contains(clientID)) {
	                uniqueIdentifiers.add(clientID);
	                ResultSet petInfoResultSet = dbManager.getPetByClientId(Integer.parseInt(clientID));
	                boolean hasPet = false;
	                
	                while (petInfoResultSet.next()) {
	                	hasPet = true;
	                    String petID = petInfoResultSet.getString("petID");
	                    String petName = petInfoResultSet.getString("petName");
	                    String identifier = petID + petName + clientID + firstName + " " + lastName + contactNumber;

	                    if (!uniqueIdentifiers.contains(identifier)) {
	                        uniqueIdentifiers.add(identifier);
	                        tableModel.addRow(new String[]{petID, petName, clientID, firstName + " " + lastName, contactNumber});
	                    }
	                }
	                
	                if(!hasPet) {
	                	String identifier = "" + "" + clientID + firstName + " " + lastName + contactNumber;

	                    if (!uniqueIdentifiers.contains(identifier)) {
	                        uniqueIdentifiers.add(identifier);
	                        tableModel.addRow(new String[]{"", "", clientID, firstName + " " + lastName, contactNumber});
	                    }
	                }
	            }
	        }

	        ResultSet petResultSet = dbManager.searchPetByKeyword(keyword);
	        while (petResultSet.next()) {
	            String petID = petResultSet.getString("petID");
	            String petName = petResultSet.getString("petName");
	            String clientID = petResultSet.getString("clientID");

	            ResultSet clientInfoResultSet = dbManager.getClientById(Integer.parseInt(clientID));
	            while (clientInfoResultSet.next()) {
	                String clientFirstName = clientInfoResultSet.getString("firstName");
	                String clientLastName = clientInfoResultSet.getString("lastName");
	                String clientContactNumber = clientInfoResultSet.getString("contactNumber");
	                String identifier = petID + petName + clientID + clientFirstName + " " + clientLastName + clientContactNumber;
	                
	                if (!uniqueIdentifiers.contains(identifier)) {
	                    uniqueIdentifiers.add(identifier);
	                    tableModel.addRow(new String[]{petID, petName, clientID, clientFirstName + " " + clientLastName, clientContactNumber});
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }
	public clientAndPetRecords() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new clientAndPetRecords();
		});
	}
}