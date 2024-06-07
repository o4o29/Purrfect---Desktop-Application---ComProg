import java.awt.*;
import java.awt.Font;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.*;

public class reportClientInfo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;


	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setTitle("Client Information Report");
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Veterinary Clinic Management System\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1.setBounds(202, 57, 479, 40);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton print_BTN = new JButton("PRINT");
		print_BTN.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\print.png"));
		print_BTN.setFont(new Font("Century Gothic", Font.BOLD, 15));
		print_BTN.setBounds(361, 513, 106, 23);
		getContentPane().add(print_BTN);
		
		JLabel title_1 = new JLabel("PURRFECT");
		title_1.setForeground(new Color(255, 20, 147));
		title_1.setFont(new Font("Century Gothic", Font.BOLD, 55));
		title_1.setBackground(new Color(255, 240, 245));
		title_1.setBounds(304, -11, 262, 100);
		getContentPane().add(title_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Client Information Report");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1_1.setBounds(314, 100, 248, 40);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 142, 864, 360);
		getContentPane().add(scrollPane);
		
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(table);

        tableModel = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableModel.addColumn("Client ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Address");
        tableModel.addColumn("Contact Number");
        tableModel.addColumn("Email Address");
        tableModel.addColumn("Date Created");
        table.setModel(tableModel);
        
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(240);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);

        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int fontSize = table.getFont().getSize();
                table.setRowHeight(row, fontSize + 6);
                return cellComponent;
            }
        });
        
        
        populateTable();
        
        
        // LISTENERS
        print_BTN.addActionListener(e -> {
            try {
                createPDF();
                dispose();
            } catch (DocumentException | IOException ex) {
                ex.printStackTrace();
            }
        });
    }

	// POPULATE TABLE
	public void populateTable() {
        try {
            DatabaseManager dbManager = DatabaseManager.getInstance();
            ResultSet resultSet = dbManager.getAllClients();
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("clientID"));
                row.add(resultSet.getString("firstName"));
                row.add(resultSet.getString("lastName"));
                row.add(resultSet.getString("address"));
                row.add(resultSet.getString("contactNumber"));
                row.add(resultSet.getString("emailAddress"));
                java.sql.Date date = resultSet.getDate("dateCreated");
                java.util.Date utilDate = new java.util.Date(date.getTime());
                String formattedDate = new SimpleDateFormat("MMMM d, yyyy").format(utilDate);
                
                row.add(formattedDate);
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	// CREATE THE PDF
    public void createPDF() throws DocumentException, IOException {
        Document document = new Document(PageSize.LEGAL);
        File file = new File("ClientInformationReport.pdf");
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        // Add title
        document.add(new Paragraph("Client Information Report", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, new com.itextpdf.text.BaseColor(255, 0, 0))));
        document.add(new Paragraph("\n"));

        PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
        pdfTable.setWidthPercentage(100);

        // table headers
        for (int i = 0; i < table.getColumnCount(); i++) {
            PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(new com.itextpdf.text.BaseColor(255, 228, 225));
            pdfTable.addCell(cell);
        }

        // table rows
        for (int rows = 0; rows < table.getRowCount(); rows++) {
            for (int cols = 0; cols < table.getColumnCount(); cols++) {
                pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
            }
        }

        document.add(pdfTable);
        document.close();

        // open the file
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }
    }
    
    // TOOLTIP
    class CustomTableCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (cellComponent instanceof JLabel) {
                JLabel label = (JLabel) cellComponent;
                label.setToolTipText(value.toString());
                
                Font tooltipFont = new Font("Arial", Font.BOLD, 18);
                ToolTipManager.sharedInstance().setInitialDelay(0);
                ToolTipManager.sharedInstance().setDismissDelay(10000);
                UIManager.put("ToolTip.font", tooltipFont);
                UIManager.put("ToolTip.background", new Color(255, 255, 204));
                UIManager.put("ToolTip.foreground", Color.BLACK);
            }

            return cellComponent;
        }
    }
    
    
    // ---------------------------------------
	public reportClientInfo() {
		initialize();
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new reportClientInfo();
		});
	}
}
