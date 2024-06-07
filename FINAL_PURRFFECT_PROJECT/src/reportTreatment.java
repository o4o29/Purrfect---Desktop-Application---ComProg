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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class reportTreatment extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;

	private void initialize() {
		setTitle("Treatment Report\r\n");
		getContentPane().setBackground(new Color(255, 228, 225));
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		setResizable(true);
		setLocationRelativeTo(null);
		JLabel title_1 = new JLabel("PURRFECT");
		title_1.setForeground(new Color(255, 20, 147));
		title_1.setFont(new Font("Century Gothic", Font.BOLD, 55));
		title_1.setBackground(new Color(255, 240, 245));
		title_1.setBounds(321, -17, 262, 100);
		getContentPane().add(title_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Veterinary Clinic Management System\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1.setBounds(216, 55, 479, 40);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Treatment Management Report");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1_1.setBounds(292, 106, 367, 40);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton print_BTN = new JButton("PRINT");
		print_BTN.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\print.png"));
		print_BTN.setFont(new Font("Century Gothic", Font.BOLD, 15));
		print_BTN.setBounds(403, 527, 106, 23);
		getContentPane().add(print_BTN);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 154, 864, 360);
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

        tableModel.addColumn("Treatment ID");
        tableModel.addColumn("Appointment ID");
        tableModel.addColumn("Pet ID");
        tableModel.addColumn("Pet Name");
        tableModel.addColumn("Services");
        tableModel.addColumn("Vital Temp.");
        tableModel.addColumn("Heart Rate");
        tableModel.addColumn("Resp. Rate");
        tableModel.addColumn("Vaccined?");
        tableModel.addColumn("Name");
        tableModel.addColumn("Against");
        tableModel.addColumn("Others");
        tableModel.addColumn("Treatment Plans");
        tableModel.addColumn("Medical Procedure");
        tableModel.addColumn("Diagnosis");
        tableModel.addColumn("DeWorming");
        tableModel.addColumn("Follow Up");
        tableModel.addColumn("Date");
        tableModel.addColumn("Time");

        table.setModel(tableModel);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        
        table.getColumnModel().getColumn(4).setPreferredWidth(170);
        
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        table.getColumnModel().getColumn(8).setPreferredWidth(80);
        
        table.getColumnModel().getColumn(12).setPreferredWidth(120);
        table.getColumnModel().getColumn(13).setPreferredWidth(120);
        table.getColumnModel().getColumn(17).setPreferredWidth(170);
        table.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());

        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        
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
            ResultSet resultSet = dbManager.getAllTreatments();
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("treatmentID"));
                row.add(resultSet.getInt("appointmentID"));
                row.add(resultSet.getInt("petID"));
                row.add(resultSet.getString("petName"));
                
                String serviceIdsStr = resultSet.getString("services");
                String[] serviceIds = serviceIdsStr.substring(1, serviceIdsStr.length() - 1).split(", ");

                StringBuilder serviceNames = new StringBuilder();
                for (String serviceId : serviceIds) {
                    String serviceName = dbManager.getServiceNameById(Integer.parseInt(serviceId.trim()));
                    serviceNames.append(serviceName).append("\n");
                }
                row.add(serviceNames.toString());
                
                row.add(resultSet.getInt("vitalTemp"));
                row.add(resultSet.getInt("vitalHeartRate"));
                row.add(resultSet.getInt("vitalRespRate"));
                row.add(resultSet.getString("hasVaccine"));
                row.add(resultSet.getString("vaccineName"));
                row.add(resultSet.getString("vaccineAgainst"));
                row.add(resultSet.getString("vaccineOthers"));
                row.add(resultSet.getString("treatmentPlans"));
                row.add(resultSet.getString("medicalProcedure"));
                row.add(resultSet.getString("diagnosis"));
                row.add(resultSet.getString("deworming"));
                row.add(resultSet.getString("followUpCheckUp"));
                
                java.sql.Date date = resultSet.getDate("date");
                java.util.Date utilDate = new java.util.Date(date.getTime());
                String formattedDate = new SimpleDateFormat("MMMM d, yyyy").format(utilDate);
                
                row.add(formattedDate);
                
                row.add(resultSet.getTime("time"));

                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	// CREATE THE PDF
	public void createPDF() throws DocumentException, IOException {
	    Document document = new Document(PageSize.LEGAL.rotate()); // landscape
	    File file = new File("TreatmentInformationReport.pdf");
	    PdfWriter.getInstance(document, new FileOutputStream(file));
	    document.open();

	    // title
	    document.add(new Paragraph("Treatment Information Report", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, new com.itextpdf.text.BaseColor(255, 0, 0))));
	    document.add(new Paragraph("\n"));

	    PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
	    pdfTable.setWidthPercentage(100);

	    // table headers (rotated)
	    for (int i = 0; i < table.getColumnCount(); i++) {
	        PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i)));
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell.setRotation(90);
	        cell.setBackgroundColor(new com.itextpdf.text.BaseColor(255, 228, 225));
	        pdfTable.addCell(cell);
	    }

	    // table rows
	    for (int rows = 0; rows < table.getRowCount(); rows++) {
	        for (int cols = 0; cols < table.getColumnCount(); cols++) {
	            PdfPCell cell = new PdfPCell(new Phrase(table.getModel().getValueAt(rows, cols).toString()));
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            pdfTable.addCell(cell);
	        }
	    }

	    document.add(pdfTable);
	    document.close();

	    // open the file
	    if (Desktop.isDesktopSupported()) {
	        Desktop.getDesktop().open(file);
	    }
	}

    // WRAP TEXT
	private static class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {
		private static final long serialVersionUID = 1L;

		MultiLineTableCellRenderer() {
	        setLineWrap(true);
	        setWrapStyleWord(true);
	        setOpaque(true);
	        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        String text = value != null ? value.toString().trim() : "";

	        if (text.isEmpty() && !getText().isEmpty()) {
	            setText("");
	        } else {
	            setText(text);
	        }

	        // calculate preferred height
	        int lineHeight = table.getFontMetrics(table.getFont()).getHeight();
	        int numLines = getText().split("\n").length;
	        int preferredHeight = (lineHeight * (numLines-1)) + 18;

	        // set row height
	        table.setRowHeight(row, Math.max(preferredHeight, table.getRowHeight(row)));

	        setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
	        setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
	        return this;
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
	public reportTreatment() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new reportTreatment();
		});
	}
}
