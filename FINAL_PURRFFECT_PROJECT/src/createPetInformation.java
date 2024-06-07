import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

public class createPetInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField petname_field;
	private JTextField breed_field;
	private JTextField weight_field;
	private JTextField age_field;
	private JTextField color_field;
	private static int clientId;
	private static JTextField clientId_field;
	private JTextField lastname_field;
	private JTextField firstname_field;
	private JComboBox<String> type_dropdown;
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(500, 550);
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseProvideAll = new JLabel("Please provide all required details.");
		lblPleaseProvideAll.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		lblPleaseProvideAll.setBounds(131, 132, 229, 19);
		contentPane.add(lblPleaseProvideAll);
		
		JLabel lblPetRegistration = new JLabel("Pet Registration");
		lblPetRegistration.setForeground(new Color(255, 20, 147));
		lblPetRegistration.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPetRegistration.setBounds(168, 89, 176, 56);
		contentPane.add(lblPetRegistration);
		
		JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
		lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel_2_2.setBounds(151, -11, 193, 75);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblClientInformationresult = new JLabel("Veterinary Clinic Management System");
		lblClientInformationresult.setForeground(new Color(255, 20, 147));
		lblClientInformationresult.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblClientInformationresult.setBounds(10, 29, 464, 75);
		contentPane.add(lblClientInformationresult);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 484, 90);
		contentPane.add(textArea);
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(43, 162, 391, 338);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser birthdate_Chooser = new JDateChooser();
		birthdate_Chooser.setBounds(124, 163, 238, 20);
		panel.add(birthdate_Chooser);
		
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblBirthdate.setBounds(32, 164, 85, 19);
		panel.add(lblBirthdate);
		
		JLabel clientId_label = new JLabel("Client ID:");
		clientId_label.setBounds(30, 11, 85, 19);
		panel.add(clientId_label);
		clientId_label.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		clientId_field = new JTextField();
		clientId_field.setEditable(false);
		clientId_field.setBounds(122, 12, 69, 20);
		panel.add(clientId_field);
		clientId_field.setColumns(10);
		
		JLabel petname_label = new JLabel("Pet Name:");
		petname_label.setBounds(32, 79, 106, 19);
		panel.add(petname_label);
		petname_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		petname_field = new JTextField();
		petname_field.setColumns(10);
		petname_field.setBounds(124, 80, 238, 20);
		panel.add(petname_field);
		
		JLabel pettype_label = new JLabel("Type:");
		pettype_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		pettype_label.setBounds(32, 109, 106, 19);
		panel.add(pettype_label);

		type_dropdown = new JComboBox<>(new String[] {"Dog", "Cat", "Bird", "Fish", "Rabbit", "Hamster"});
		type_dropdown.setBounds(124, 109, 238, 20);
		type_dropdown.setSelectedIndex(-1);
		panel.add(type_dropdown);

		
		JLabel breed_label = new JLabel("Breed:");
		breed_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		breed_label.setBounds(32, 139, 106, 14);
		panel.add(breed_label);
		
		breed_field = new JTextField();
		breed_field.setColumns(10);
		breed_field.setBounds(124, 139, 238, 20);
		panel.add(breed_field);
		
		JLabel gender_label = new JLabel("Gender:");
		gender_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		gender_label.setBounds(32, 245, 106, 14);
		panel.add(gender_label);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		rdbtnMale.setBackground(new Color(255, 182, 193));
		rdbtnMale.setBounds(127, 241, 64, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female\r\n");
		rdbtnFemale.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		rdbtnFemale.setBackground(new Color(255, 182, 193));
		rdbtnFemale.setBounds(193, 241, 85, 23);
		panel.add(rdbtnFemale);
		
		JLabel weight_label = new JLabel("Weight (kg):");
		weight_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		weight_label.setBounds(32, 215, 109, 19);
		panel.add(weight_label);
		
		weight_field = new JTextField();
		weight_field.setColumns(10);
		weight_field.setBounds(124, 216, 238, 20);
		panel.add(weight_field);
		
		JLabel age_label = new JLabel("Age:");
		age_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		age_label.setBounds(32, 189, 85, 19);
		panel.add(age_label);
		
		age_field = new JTextField();
		age_field.setEditable(false);
		age_field.setColumns(10);
		age_field.setBounds(124, 190, 238, 20);
		panel.add(age_field);
		
		JLabel color_label = new JLabel("Color/ Markings:");
		color_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		color_label.setBounds(32, 270, 139, 19);
		panel.add(color_label);
		
		color_field = new JTextField();
		color_field.setColumns(10);
		color_field.setBounds(160, 271, 202, 20);
		panel.add(color_field);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(27, 302, 106, 25);
		panel.add(btnCancel);
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCancel.setBackground(new Color(255, 240, 245));
		
		JButton btnSavePet = new JButton("SAVE");
		btnSavePet.setBounds(143, 302, 99, 25);
		panel.add(btnSavePet);
		btnSavePet.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSavePet.setBackground(new Color(255, 240, 245));
		
		JButton btnClearAll = new JButton("CLEAR ALL");
		btnClearAll.setBounds(252, 302, 108, 25);
		panel.add(btnClearAll);
		btnClearAll.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnClearAll.setBackground(new Color(255, 240, 245));
		
		
		// LISTENERS
		btnSavePet.addActionListener(new ActionListener() { // create pet
            public void actionPerformed(ActionEvent e) {
                try {
                    String petName = petname_field.getText();
                    String clientName = "Null";
                    String species = (String) type_dropdown.getSelectedItem();
                    String breed = breed_field.getText();
                    String weight = weight_field.getText();
                    java.util.Date utilDate = birthdate_Chooser.getDate();
                    String age = age_field.getText();
                    String gender = rdbtnMale.isSelected() ? "Male" : rdbtnFemale.isSelected() ? "Female" : "";
                    String color = color_field.getText();
                    
                    if (petName.isEmpty() || species == null || breed.isEmpty() || weight.isEmpty() || utilDate == null || age.isEmpty() || color.isEmpty() || gender.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (!weight.matches("[0-9]+") || !age.matches("[0-9]+")) {
    		            JOptionPane.showMessageDialog(null, "Weight and age must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
    		            return;
    		        }
                    
                    DatabaseManager dbManager = DatabaseManager.getInstance();
                    java.sql.Date birthdate = new java.sql.Date(utilDate.getTime());
                    ResultSet clientSet = dbManager.getClientById(clientId);
                    
                    if(clientSet.next()) {
                    	String firstName = clientSet.getString("firstName");;
                    	String lastName = clientSet.getString("lastName");
                    	
                    	clientName = firstName + " " + lastName;
                    }
                    
                    int petID = dbManager.insertPet(clientId, petName, species, breed, weight, birthdate, age, gender, color, clientName);
                    
                    if (petID != -1) {
		                String formattedPetId = String.format("%04d", petID);
		                JOptionPane.showMessageDialog(null,"Pet added successfully! Pet ID: " + formattedPetId);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to retrieve pet ID.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
                    
                    dispose();
                    resultClientInformation.showPetInformation(petID);
                    resultClientInformation.updateScrollMax();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error saving pet information", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
     	});
		
		btnClearAll.addActionListener(e -> {
			petname_field.setText("");
			type_dropdown.setSelectedIndex(-1);
			breed_field.setText("");
			weight_field.setText("");
			birthdate_Chooser.setDate(null);
			age_field.setText("");
			rdbtnMale.setSelected(false);
			rdbtnFemale.setSelected(false);
			color_field.setText("");
		});
		
		btnCancel.addActionListener(e -> {
			dispose();
		});
		
		
		birthdate_Chooser.setMaxSelectableDate(new java.util.Date());

		birthdate_Chooser.getDateEditor().addPropertyChangeListener(e -> {
		    if ("date".equals(e.getPropertyName())) {
		    	java.util.Date birthdate = birthdate_Chooser.getDate();
		    	java.util.Date currentDate = new java.util.Date();
		        
		        if (birthdate != null && birthdate.after(currentDate)) {
		            birthdate_Chooser.setDate(currentDate);
		        }
		        if (birthdate != null) {
		            java.util.Calendar cal = java.util.Calendar.getInstance();
		            cal.setTime(birthdate);
		            java.util.Calendar now = java.util.Calendar.getInstance();
		            int age = now.get(java.util.Calendar.YEAR) - cal.get(java.util.Calendar.YEAR);
		            if (now.get(java.util.Calendar.DAY_OF_YEAR) < cal.get(java.util.Calendar.DAY_OF_YEAR)) {
		                age--;
		            }
		            age_field.setText(String.valueOf(age));
		            
		            JLabel petname_label_1 = new JLabel("Client Name:");
		            petname_label_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		            petname_label_1.setBounds(30, 41, 106, 19);
		            panel.add(petname_label_1);
		            
		            lastname_field = new JTextField();
		            lastname_field.setText("");
		            lastname_field.setColumns(10);
		            lastname_field.setBounds(124, 43, 109, 20);
		            panel.add(lastname_field);
		            
		            firstname_field = new JTextField();
		            firstname_field.setText("");
		            firstname_field.setColumns(10);
		            firstname_field.setBounds(243, 42, 119, 20);
		            panel.add(firstname_field);
		        }
		    }
		});


	}
	// ----------------------------------------------------------------------------------------------------------------------------------

	
	public static void getOwnerId(String clientId) {
		new createPetInformation();
		createPetInformation.clientId = Integer.parseInt(clientId);
		clientId_field.setText(clientId);
	}
	
	public createPetInformation() {
		setTitle("Pet Registration");
		initialize();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new createPetInformation();
		});
	}
}