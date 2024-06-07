import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class resultPetInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField petID_Field;
	private static JTextField clientID_Field;
	private static JTextField petName_Field;
	private static JTextField type_Field;
	private static JTextField breed_Field;
	private static JTextField weight_Field;
	private static JTextField age_Field;
	private static JTextField gender_Field;
	private static JTextField colorMarkings_Field;
	private static JDateChooser birthdate_Field;
	private static int petId;
	private static int clientId;
	private static JTextField clientName_Field;
	private static JTable history_Table;
	private static DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	
	public static void getPetId(int petId) {
		resultPetInformation.petId = petId;
		
		SwingUtilities.invokeLater(() -> {
			new resultPetInformation();
			populateFields();
			populateTable();
		});
	}
	
	public static void updatePetInformation(int petId) {
	    try {	
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        ResultSet petResult = dbManager.getPetById(petId);
	        
	        if (petResult.next()) {
	        	petID_Field.setText(String.valueOf(petResult.getInt("petID")));
				clientID_Field.setText(String.valueOf(petResult.getInt("clientID")));
				
				petName_Field.setText(petResult.getString("petName"));
				type_Field.setText(petResult.getString("petType"));
				breed_Field.setText(petResult.getString("petBreed"));
				weight_Field.setText(String.valueOf(petResult.getInt("petWeight")));
				age_Field.setText(String.valueOf(petResult.getInt("petAge")));
				gender_Field.setText(petResult.getString("petGender"));
				colorMarkings_Field.setText(petResult.getString("petColor"));
	        }
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(780,530);
		getContentPane().setLayout(null);
		setResizable(false);
        setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(19, 130, 325, 350);
		getContentPane().add(mainPanel);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblPetId.setBounds(10, 17, 86, 14);
		mainPanel.add(lblPetId);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setColumns(10);
		petID_Field.setBounds(98, 11, 204, 20);
		mainPanel.add(petID_Field);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblClientId.setBounds(10, 42, 86, 14);
		mainPanel.add(lblClientId);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(98, 36, 204, 20);
		mainPanel.add(clientID_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblPetName.setBounds(10, 96, 86, 14);
		mainPanel.add(lblPetName);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(98, 95, 204, 20);
		mainPanel.add(petName_Field);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblType.setBounds(10, 121, 86, 20);
		mainPanel.add(lblType);
		
		type_Field = new JTextField();
		type_Field.setEditable(false);
		type_Field.setColumns(10);
		type_Field.setBounds(98, 121, 204, 20);
		mainPanel.add(type_Field);
		
		JLabel lblClientId_1_1 = new JLabel("Breed:\r\n");
		lblClientId_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblClientId_1_1.setBounds(10, 145, 86, 14);
		mainPanel.add(lblClientId_1_1);
		
		JLabel lblClientId_1_1_1 = new JLabel("Weight:");
		lblClientId_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblClientId_1_1_1.setBounds(10, 170, 86, 19);
		mainPanel.add(lblClientId_1_1_1);
		
		JLabel lblClientId_1_1_1_1 = new JLabel("Age:");
		lblClientId_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblClientId_1_1_1_1.setBounds(10, 220, 86, 14);
		mainPanel.add(lblClientId_1_1_1_1);
		
		JLabel lblClientId_1_1_1_1_1 = new JLabel("Gender:");
		lblClientId_1_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblClientId_1_1_1_1_1.setBounds(10, 245, 86, 14);
		mainPanel.add(lblClientId_1_1_1_1_1);
		
		breed_Field = new JTextField();
		breed_Field.setEditable(false);
		breed_Field.setColumns(10);
		breed_Field.setBounds(98, 144, 203, 20);
		mainPanel.add(breed_Field);
		
		weight_Field = new JTextField();
		weight_Field.setEditable(false);
		weight_Field.setColumns(10);
		weight_Field.setBounds(98, 169, 204, 20);
		mainPanel.add(weight_Field);
		
		age_Field = new JTextField();
		age_Field.setEditable(false);
		age_Field.setColumns(10);
		age_Field.setBounds(98, 219, 204, 20);
		mainPanel.add(age_Field);
		
		JLabel lblClientId_1_1_1_1_1_1 = new JLabel("Color Markings:");
		lblClientId_1_1_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblClientId_1_1_1_1_1_1.setBounds(10, 270, 141, 20);
		mainPanel.add(lblClientId_1_1_1_1_1_1);
		
		gender_Field = new JTextField();
		gender_Field.setEditable(false);
		gender_Field.setColumns(10);
		gender_Field.setBounds(98, 244, 204, 20);
		mainPanel.add(gender_Field);
		
		colorMarkings_Field = new JTextField();
		colorMarkings_Field.setEditable(false);
		colorMarkings_Field.setColumns(10);
		colorMarkings_Field.setBounds(136, 269, 166, 20);
		mainPanel.add(colorMarkings_Field);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(255, 218, 185));
		btnEdit.setBounds(10, 316, 100, 23);
		mainPanel.add(btnEdit);
		btnEdit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		JButton btnCreateAppointment = new JButton("Create Appointment");
		btnCreateAppointment.setBackground(new Color(255, 218, 185));
		btnCreateAppointment.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCreateAppointment.setBounds(120, 316, 182, 23);
		mainPanel.add(btnCreateAppointment);
		
		JLabel lblClientId_1_1_1_2 = new JLabel("Birthdate:");
		lblClientId_1_1_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblClientId_1_1_1_2.setBounds(10, 195, 86, 14);
		mainPanel.add(lblClientId_1_1_1_2);
		
		birthdate_Field = new JDateChooser();
		birthdate_Field.setBounds(98, 195, 204, 20);
		birthdate_Field.setEnabled(false);
		mainPanel.add(birthdate_Field);
		
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblClientName.setBounds(10, 67, 108, 14);
		mainPanel.add(lblClientName);
		
		clientName_Field = new JTextField();
		clientName_Field.setEditable(false);
		clientName_Field.setColumns(10);
		clientName_Field.setBounds(110, 67, 192, 20);
		mainPanel.add(clientName_Field);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(0, 0, 780, 90);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
		lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel_2_2.setBounds(289, -11, 246, 75);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblClientInformationresult = new JLabel("Veterinary Clinic Management System");
		lblClientInformationresult.setForeground(new Color(255, 20, 147));
		lblClientInformationresult.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblClientInformationresult.setBounds(139, 25, 505, 75);
		panel_1.add(lblClientInformationresult);
		
		JPanel mainPanel_1 = new JPanel();
		mainPanel_1.setLayout(null);
		mainPanel_1.setBackground(new Color(255, 182, 193));
		mainPanel_1.setBounds(354, 130, 400, 350);
		getContentPane().add(mainPanel_1);


        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 380, 328);
		mainPanel_1.add(scrollPane);
		
		history_Table = new JTable();
		history_Table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		history_Table.getTableHeader().setReorderingAllowed(false);
		history_Table.getTableHeader().setResizingAllowed(false);
		
		scrollPane.setViewportView(history_Table);
		
        tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 1 || columnIndex == 2 ? String.class : super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableModel.addColumn("Date");
        tableModel.addColumn("Description");
        tableModel.addColumn("Remarks");
        history_Table.setModel(tableModel);
        history_Table.getColumnModel().getColumn(1).setCellRenderer(new MultiLineTableCellRenderer());
        history_Table.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());

		
		JLabel lblPetInformation = new JLabel("Pet Information");
		lblPetInformation.setForeground(new Color(255, 20, 147));
		lblPetInformation.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblPetInformation.setBounds(109, 83, 155, 56);
		getContentPane().add(lblPetInformation);
		
		JLabel lblCheckupHistory = new JLabel("Check-Up History");
		lblCheckupHistory.setForeground(new Color(255, 20, 147));
		lblCheckupHistory.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblCheckupHistory.setBounds(485, 83, 155, 56);
		getContentPane().add(lblCheckupHistory);
		
		
		// LISTENERS
		btnEdit.addActionListener(e -> { // edit pet
			editPetInformation.getPetIdEdit(petId, clientId, "petPanel");
		});
		
		btnCreateAppointment.addActionListener(e -> {
			appointmentCreate.getPetInformation(petId);
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	private static class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {
		private static final long serialVersionUID = 1L;

		MultiLineTableCellRenderer() {
	        setLineWrap(true);
	        setWrapStyleWord(true);
	        setOpaque(true);
	        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Add some padding to the text
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        String text = value != null ? value.toString().trim() : ""; // Check for null value

	        if (text.isEmpty() && !getText().isEmpty()) {
	            setText("");
	        } else {
	            setText(text);
	        }

	        // Calculate preferred height based on the number of lines of text
	        int lineHeight = table.getFontMetrics(table.getFont()).getHeight();
	        int numLines = getText().split("\n").length;
	        int preferredHeight = 0;
	        
        	preferredHeight = (lineHeight * (numLines)) + 4;
        	
	        if(column == 1) {
	        	preferredHeight = (lineHeight * (numLines - 1)) + 4; // Add some padding
	        }
	    
	        // Set the row height based on the maximum height required for either column in this row
	        int maxColumnHeight = Math.max(preferredHeight, table.getRowHeight(row));
	        table.setRowHeight(row, maxColumnHeight);

	        setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
	        setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
	        return this;
	    }
	}


    
    public static void populateTable() {
        try {
            DatabaseManager dbManager = DatabaseManager.getInstance();
            ResultSet resultSet = dbManager.getTreatmentByPetId(petId);

            tableModel.setRowCount(0);

            SimpleDateFormat newDateFormat = new SimpleDateFormat("MMMM d, yyyy");

            while (resultSet.next()) {
                java.sql.Date sqlDate = resultSet.getDate("date");
                String formattedDate = sqlDate != null ? newDateFormat.format(sqlDate) : "";

                String serviceIdsStr = resultSet.getString("services");
                String[] serviceIds = serviceIdsStr.substring(1, serviceIdsStr.length() - 1).split(", ");

                StringBuilder serviceNames = new StringBuilder();
                for (String serviceId : serviceIds) {
                    String serviceName = dbManager.getServiceNameById(Integer.parseInt(serviceId.trim()));
                    serviceNames.append(serviceName).append("\n");
                }

                String diagnosis = resultSet.getString("diagnosis");

                Object[] rowData = {formattedDate, serviceNames.toString(), diagnosis};
                tableModel.addRow(rowData);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

	
	public static void populateFields() {
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getPetById(petId);
		     
		     if (resultSet.next()) {
		    	 ResultSet clientSet = dbManager.getClientById(resultSet.getInt("clientID"));
		    	 
		    	 if(clientSet.next()) {
		    		 String firstName = clientSet.getString("firstName").trim();
		    		 String lastName = clientSet.getString("lastName").trim();
		    		 
		    		 clientName_Field.setText(firstName + " " + lastName);
		    	 }
		    	 
		    	 clientId = resultSet.getInt("clientID");

				 petID_Field.setText(String.valueOf(resultSet.getInt("petID")));
				 clientID_Field.setText(String.valueOf(resultSet.getInt("clientID")));
				
				 petName_Field.setText(resultSet.getString("petName"));
				 type_Field.setText(resultSet.getString("petType"));
				 breed_Field.setText(resultSet.getString("petBreed"));
				 weight_Field.setText(String.valueOf(resultSet.getFloat("petWeight")));
				 gender_Field.setText(resultSet.getString("petGender"));
				 colorMarkings_Field.setText(resultSet.getString("petColor"));
				 birthdate_Field.setDate(resultSet.getDate("petBirthdate"));
					
				 java.util.Date birthdate = resultSet.getDate("petBirthdate");
			 	 java.util.Calendar cal = java.util.Calendar.getInstance();
			 	 java.util.Calendar now = java.util.Calendar.getInstance();
			 	 
				 cal.setTime(birthdate);
				 
				 int age = now.get(java.util.Calendar.YEAR) - cal.get(java.util.Calendar.YEAR);
				 
				 if (now.get(java.util.Calendar.DAY_OF_YEAR) < cal.get(java.util.Calendar.DAY_OF_YEAR)) {
				    age--;
				}
				 
				age_Field.setText(String.valueOf(age));
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public resultPetInformation() {
		setTitle("Pet Information and History");
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new resultPetInformation();
		});
	}
}