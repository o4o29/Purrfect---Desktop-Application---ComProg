import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class reportPetInfo extends JFrame {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;


	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setTitle("Pet Infomation Report");
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel title_1 = new JLabel("PURRFECT");
		title_1.setForeground(new Color(255, 20, 147));
		title_1.setFont(new Font("Century Gothic", Font.BOLD, 55));
		title_1.setBackground(new Color(255, 240, 245));
		title_1.setBounds(300, -15, 262, 100);
		getContentPane().add(title_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Veterinary Clinic Management System\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1.setBounds(170, 57, 479, 40);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pet Information Report");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1_1.setBounds(322, 108, 233, 40);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton print_BTN = new JButton("PRINT");
		print_BTN.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\print.png"));
		print_BTN.setFont(new Font("Century Gothic", Font.BOLD, 15));
		print_BTN.setBounds(377, 527, 106, 23);
		getContentPane().add(print_BTN);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 148, 864, 360);
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

        tableModel.addColumn("Pet ID");
        tableModel.addColumn("Client ID");
        tableModel.addColumn("Client Name");
        tableModel.addColumn("Pet Name");
        tableModel.addColumn("Type");
        tableModel.addColumn("Breed");
        tableModel.addColumn("Weight (kg)");
        tableModel.addColumn("Birthdate");
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Color");
        table.setModel(tableModel);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(7).setPreferredWidth(170);
        table.getColumnModel().getColumn(8).setPreferredWidth(40);

        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer() {
			private static final long serialVersionUID = 1L;

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
            ResultSet resultSet = dbManager.getAllPets();
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("petID"));
                row.add(resultSet.getInt("clientID"));
                row.add(resultSet.getString("clientName"));
                row.add(resultSet.getString("petName"));
                row.add(resultSet.getString("petType"));
                row.add(resultSet.getString("petBreed"));
                row.add(resultSet.getInt("petWeight"));
                
                java.sql.Date date = resultSet.getDate("petBirthdate");
                java.util.Date utilDate = new java.util.Date(date.getTime());
                String formattedDate = new SimpleDateFormat("MMMM d, yyyy").format(utilDate);
                
                row.add(formattedDate);
                
                row.add(resultSet.getInt("petAge"));
                row.add(resultSet.getString("petGender"));
                row.add(resultSet.getString("petColor"));
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	// CREATE THE PDF
    public void createPDF() throws DocumentException, IOException {
        Document document = new Document(PageSize.LEGAL);
        File file = new File("PetInformationReport.pdf");
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        // Add title
        document.add(new Paragraph("Pet Information Report", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, new com.itextpdf.text.BaseColor(255, 0, 0))));
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
	public reportPetInfo() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new reportPetInfo();
		});
	}
}
