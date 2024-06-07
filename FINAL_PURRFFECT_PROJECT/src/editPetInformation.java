import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

public class editPetInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField petName_Field;
	private static JTextField colorMarkings_Field;
	private static JTextField petId_Field;
	private static JTextField weight_Field;
	private static JTextField breed_Field;
	private static JRadioButton rdbtnMale;
	private static JRadioButton rdbtnFemale;
	private static String whereFrom;
	private static JDateChooser dateChooser;
	private static int petId;
	@SuppressWarnings("unused")
	private static int clientId;
	private static JTextField clientId_Field;
	private static JTextField age_Field;
	private JTextField firstname_field;
	private JComboBox<String> type_dropdown;
	private JTextField lastname_field;
	
	public static void getPetIdEdit(int petId, int clientId, String whereFrom) {
		editPetInformation.petId = petId;
		editPetInformation.clientId = clientId;
		editPetInformation.whereFrom = whereFrom;
		
		SwingUtilities.invokeLater(() -> new editPetInformation().populateFields());
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		setTitle("Edit Pet Information");
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setLayout(null);
		setSize(500, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("PURRFECT");
		lblNewLabel_2_2_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2_1.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel_2_2_1.setBounds(148, -15, 193, 75);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblClientInformationresult = new JLabel("Veterinary Clinic Management System");
		lblClientInformationresult.setForeground(new Color(255, 20, 147));
		lblClientInformationresult.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblClientInformationresult.setBounds(20, 27, 464, 75);
		getContentPane().add(lblClientInformationresult);
		
		JLabel lblNewLabel_2_2 = new JLabel("CLIENT ID:");
		lblNewLabel_2_2.setBounds(40, 152, 96, 19);
		getContentPane().add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("PET ID:");
		lblNewLabel_2.setBounds(40, 133, 76, 19);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		lastname_field = new JTextField();
		lastname_field.setEditable(false);
		lastname_field.setText("");
		lastname_field.setColumns(10);
		lastname_field.setBounds(295, 181, 163, 20);
		getContentPane().add(lastname_field);
		
		firstname_field = new JTextField();
		firstname_field.setEditable(false);
		firstname_field.setText("");
		firstname_field.setColumns(10);
		firstname_field.setBounds(148, 181, 137, 20);
		getContentPane().add(firstname_field);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Client Name:");
		lblNewLabel_2_1_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_4.setBounds(40, 182, 96, 14);
		getContentPane().add(lblNewLabel_2_1_4);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(30, 207, 428, 292);
		getContentPane().add(mainPanel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pet Name:");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(30, 22, 96, 14);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Weight:");
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(30, 96, 106, 20);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Color/ Markings:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(30, 215, 121, 19);
		mainPanel.add(lblNewLabel_2_1_1_1_1);
		
		petName_Field = new JTextField();
		petName_Field.setColumns(10);
		petName_Field.setBounds(153, 21, 189, 20);
		mainPanel.add(petName_Field);
		
		colorMarkings_Field = new JTextField();
		colorMarkings_Field.setColumns(10);
		colorMarkings_Field.setBounds(153, 216, 189, 20);
		mainPanel.add(colorMarkings_Field);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Gender:");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_2.setBounds(30, 127, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1_2);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		rdbtnMale.setBackground(new Color(255, 182, 193));
		rdbtnMale.setBounds(153, 123, 64, 23);
		mainPanel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		rdbtnFemale.setBackground(new Color(255, 182, 193));
		rdbtnFemale.setBounds(219, 123, 135, 23);
		mainPanel.add(rdbtnFemale);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Breed:");
		lblNewLabel_2_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(30, 71, 96, 14);
		mainPanel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Type:");
		lblNewLabel_2_1_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1.setBounds(30, 47, 96, 14);
		mainPanel.add(lblNewLabel_2_1_2_1);
		
		weight_Field = new JTextField();
		weight_Field.setColumns(10);
		weight_Field.setBounds(153, 96, 189, 20);
		mainPanel.add(weight_Field);
		
		breed_Field = new JTextField();
		breed_Field.setColumns(10);
		breed_Field.setBounds(153, 70, 189, 20);
		mainPanel.add(breed_Field);
		
		type_dropdown = new JComboBox<>();
		type_dropdown.setBounds(153, 46, 189, 20);
		mainPanel.add(type_dropdown);
		type_dropdown.addItem("Dog");
		type_dropdown.addItem("Cat");
		type_dropdown.addItem("Bird");
		type_dropdown.addItem("Fish");
		type_dropdown.addItem("Rabbit");
		type_dropdown.addItem("Hamster");
		
		JButton btnSavePet = new JButton("SAVE");
		btnSavePet.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSavePet.setBackground(new Color(255, 218, 185));
		btnSavePet.setBounds(136, 247, 96, 25);
		mainPanel.add(btnSavePet);
		
		JButton btnClearAll = new JButton("CLEAR ALL");
		btnClearAll.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnClearAll.setBackground(new Color(255, 218, 185));
		btnClearAll.setBounds(242, 247, 100, 25);
		mainPanel.add(btnClearAll);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCancel.setBackground(new Color(255, 218, 185));
		btnCancel.setBounds(30, 247, 96, 25);
		mainPanel.add(btnCancel);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Birthdate:");
		lblNewLabel_2_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_3.setBounds(30, 155, 96, 14);
		mainPanel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Age:");
		lblNewLabel_2_1_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2_1_3_1.setBounds(30, 180, 96, 20);
		mainPanel.add(lblNewLabel_2_1_3_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(153, 153, 189, 20);
		mainPanel.add(dateChooser);
		
		age_Field = new JTextField();
		age_Field.setEditable(false);
		age_Field.setColumns(10);
		age_Field.setBounds(153, 182, 189, 20);
		mainPanel.add(age_Field);
		
		petId_Field = new JTextField();
		petId_Field.setBounds(148, 134, 86, 20);
		getContentPane().add(petId_Field);
		petId_Field.setEditable(false);
		petId_Field.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 484, 90);
		getContentPane().add(textArea);
		
		clientId_Field = new JTextField();
		clientId_Field.setEditable(false);
		clientId_Field.setColumns(10);
		clientId_Field.setBounds(148, 153, 86, 20);
		getContentPane().add(clientId_Field);
		
		
		// LISTENERS
        btnSavePet.addActionListener(new ActionListener() { // submit button
            public void actionPerformed(ActionEvent e) {
                String petName = petName_Field.getText();
                String type = (String) type_dropdown.getSelectedItem();
                String breed = breed_Field.getText();
                String weight = weight_Field.getText();
                String age = age_Field.getText();
                String gender = rdbtnMale.isSelected() ? "Male" : rdbtnFemale.isSelected() ? "Female" : "";
                String color = colorMarkings_Field.getText();
                java.util.Date utilDate = dateChooser.getDate();

                // Check if any required field is empty
                if (petName.isEmpty() || type.isEmpty() || breed.isEmpty() || weight.isEmpty() || color.isEmpty() || utilDate == null || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate numeric fields
                if (!weight.matches("\\d+\\.?\\d*") || !age.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Weight and age must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                java.sql.Date birthdate = new java.sql.Date(utilDate.getTime());

                try {
                    DatabaseManager dbManager = DatabaseManager.getInstance();
                    dbManager.updatePet(petId, petName, type, breed, weight, birthdate, age, gender, color);

                    JOptionPane.showMessageDialog(null, "Pet updated successfully! Pet ID: " + petId);
                    dispose();

                    if (whereFrom.equals("clientPanel")) {
                        resultClientInformation.updateScrollMax();
                    } else if (whereFrom.equals("petPanel")) {
                        resultPetInformation.updatePetInformation(petId);
                    }

                } catch (SQLException ex) {
                    if (ex instanceof MysqlDataTruncation) {
                        MysqlDataTruncation truncationEx = (MysqlDataTruncation) ex;
                        JOptionPane.showMessageDialog(null, truncationEx.getErrorCode() + "; Truncation error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error occurred while editing pet: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
		
		btnClearAll.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        petName_Field.setText("");
		        type_dropdown.setSelectedIndex(-1);
		        breed_Field.setText("");
		        weight_Field.setText("");
		        age_Field.setText("0");
		        colorMarkings_Field.setText("");
		        rdbtnMale.setSelected(false);
		        rdbtnFemale.setSelected(false);
		        dateChooser.setDate(null);
		    }
		});
		
		btnCancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		    }
		});
		
		dateChooser.setMaxSelectableDate(new java.util.Date());

		dateChooser.getDateEditor().addPropertyChangeListener(e -> {
		    if ("date".equals(e.getPropertyName())) {
		    	java.util.Date birthdate = dateChooser.getDate();
		    	java.util.Date currentDate = new java.util.Date();
		        
		        if (birthdate != null && birthdate.after(currentDate)) {
		        	dateChooser.setDate(currentDate);
		        }
		        if (birthdate != null) {
		            java.util.Calendar cal = java.util.Calendar.getInstance();
		            cal.setTime(birthdate);
		            java.util.Calendar now = java.util.Calendar.getInstance();
		            int age = now.get(java.util.Calendar.YEAR) - cal.get(java.util.Calendar.YEAR);
		            if (now.get(java.util.Calendar.DAY_OF_YEAR) < cal.get(java.util.Calendar.DAY_OF_YEAR)) {
		                age--;
		            }
		            age_Field.setText(String.valueOf(age));
		            
		            JLabel lblEditPetInformation = new JLabel("Edit Pet Information");
		            lblEditPetInformation.setForeground(new Color(255, 20, 147));
		            lblEditPetInformation.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		            lblEditPetInformation.setBounds(142, 81, 244, 56);
		            getContentPane().add(lblEditPetInformation);
		        }
		    }
		});
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	private void populateFields() {
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getPetById(petId);
		     
		     
		     if (resultSet.next()) {
		    	 	ResultSet clientSet = dbManager.getClientById(resultSet.getInt("clientID"));
		    	 	if (clientSet.next()) {
		    	 		firstname_field.setText(clientSet.getString("firstName").trim());
		    	 		lastname_field.setText(clientSet.getString("lastName").trim());
		    	 	}
		    	 	
		    	 	String petGender = resultSet.getString("petGender");
		    	 	String petType = resultSet.getString("petName");
		    	 	
	                clientId_Field.setText(String.valueOf(resultSet.getInt("clientID")));
	                petId_Field.setText(String.valueOf(resultSet.getInt("petID")));
					petName_Field.setText(petType);
					type_dropdown.setSelectedItem(resultSet.getString("petType"));
					breed_Field.setText(resultSet.getString("petBreed"));
					weight_Field.setText(String.valueOf(resultSet.getFloat("petWeight")));
					
					if (petGender != null) {
					    switch (petGender.toLowerCase()) {
					        case "male":
					            rdbtnMale.setSelected(true);
					            rdbtnFemale.setSelected(false);
					            break;
					        case "female":
					        	rdbtnMale.setSelected(false);
					            rdbtnFemale.setSelected(true);
					            break;
					        default:
					        	rdbtnMale.setSelected(false);
					            rdbtnFemale.setSelected(false);
					            break;
					    }
					}
					colorMarkings_Field.setText(resultSet.getString("petColor"));
					dateChooser.setDate(resultSet.getDate("petBirthdate"));
					
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

	
	
	public editPetInformation() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new editPetInformation();
		});
	}
}