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
import javax.swing.JRadioButton;

public class editPetInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField clientId_Field;
	private static JTextField petName_Field;
	private static JTextField age_Field;
	private static JTextField colorMarkings_Field;
	private static JTextField petId_Field;
	private static JTextField weight_Field;
	private static JTextField breed_Field;
	private static JTextField species_Field;
	private static JRadioButton rdbtnMale;
	private static JRadioButton rdbtnFemale;
	private static String whereFrom;
	
	private static int petId;
	@SuppressWarnings("unused")
	private static int clientId;
	
	
	public static editPetInformation getPetIdEdit(int petId, int clientId, String whereFrom) {
		new editPetInformation();
		System.out.println(petId);
		System.out.println(clientId);
		editPetInformation.petId = petId;
		editPetInformation.clientId = clientId; 
		editPetInformation.whereFrom = whereFrom;
		
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getPetById(petId);
		     
		     if (resultSet.next()) {
		    	 	String petGender = resultSet.getString("petGender");

	                clientId_Field.setText(String.valueOf(resultSet.getInt("clientID")));
	                petId_Field.setText(String.valueOf(resultSet.getInt("petID")));
					petName_Field.setText(resultSet.getString("petName"));
					species_Field.setText(resultSet.getString("petSpecies"));
					breed_Field.setText(resultSet.getString("petBreed"));
					weight_Field.setText(String.valueOf(resultSet.getFloat("petWeight")));
					age_Field.setText(String.valueOf(resultSet.getInt("petAge")));
					
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
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	        
		return null;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		setTitle("Edit Pet Information");
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setLayout(null);
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255, 182, 193));
		headerPanel.setBounds(0, 0, 884, 150);
		getContentPane().add(headerPanel);
		
		JLabel lblPetInformation = new JLabel("PET INFORMATION");
		lblPetInformation.setForeground(Color.WHITE);
		lblPetInformation.setFont(new Font("Verdana", Font.BOLD, 55));
		lblPetInformation.setBounds(147, 37, 663, 50);
		headerPanel.add(lblPetInformation);
		
		JLabel lblEdit = new JLabel("EDIT");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Verdana", Font.BOLD, 25));
		lblEdit.setBounds(385, 89, 69, 50);
		headerPanel.add(lblEdit);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(251, 185, 411, 328);
		getContentPane().add(mainPanel);
		
		JLabel lblNewLabel_2 = new JLabel("PET ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(31, 13, 76, 19);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pet Name:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(31, 80, 96, 14);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Weight:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(31, 156, 106, 20);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Age:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(31, 187, 106, 19);
		mainPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Color/ Markings:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(31, 251, 106, 19);
		mainPanel.add(lblNewLabel_2_1_1_1_1);
		
		clientId_Field = new JTextField();
		clientId_Field.setEditable(false);
		clientId_Field.setColumns(10);
		clientId_Field.setBounds(133, 43, 248, 20);
		mainPanel.add(clientId_Field);
		
		petName_Field = new JTextField();
		petName_Field.setColumns(10);
		petName_Field.setBounds(133, 74, 248, 20);
		mainPanel.add(petName_Field);
		
		age_Field = new JTextField();
		age_Field.setColumns(10);
		age_Field.setBounds(133, 186, 248, 20);
		mainPanel.add(age_Field);
		
		colorMarkings_Field = new JTextField();
		colorMarkings_Field.setColumns(10);
		colorMarkings_Field.setBounds(133, 250, 248, 20);
		mainPanel.add(colorMarkings_Field);
		
		JButton submitChanges_Btn = new JButton("SUBMIT CHANGES");
		submitChanges_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		submitChanges_Btn.setBackground(new Color(255, 240, 245));
		submitChanges_Btn.setBounds(133, 292, 150, 25);
		mainPanel.add(submitChanges_Btn);
		
		JLabel lblNewLabel_2_2 = new JLabel("CLIENT ID:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(31, 43, 96, 19);
		mainPanel.add(lblNewLabel_2_2);
		
		petId_Field = new JTextField();
		petId_Field.setEditable(false);
		petId_Field.setColumns(10);
		petId_Field.setBounds(133, 12, 248, 20);
		mainPanel.add(petId_Field);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Gender:");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_2.setBounds(31, 217, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1_2);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBackground(new Color(255, 182, 193));
		rdbtnMale.setBounds(133, 213, 64, 23);
		mainPanel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBackground(new Color(255, 182, 193));
		rdbtnFemale.setBounds(228, 213, 135, 23);
		mainPanel.add(rdbtnFemale);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Breed:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(31, 130, 96, 14);
		mainPanel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Species:");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1.setBounds(31, 105, 96, 14);
		mainPanel.add(lblNewLabel_2_1_2_1);
		
		weight_Field = new JTextField();
		weight_Field.setColumns(10);
		weight_Field.setBounds(133, 156, 248, 20);
		mainPanel.add(weight_Field);
		
		breed_Field = new JTextField();
		breed_Field.setColumns(10);
		breed_Field.setBounds(133, 124, 248, 20);
		mainPanel.add(breed_Field);
		
		species_Field = new JTextField();
		species_Field.setColumns(10);
		species_Field.setBounds(133, 99, 248, 20);
		mainPanel.add(species_Field);
		
		
		// LISTENERS
		submitChanges_Btn.addActionListener(new ActionListener() { // submit button
		    public void actionPerformed(ActionEvent e) {
		        String petName = petName_Field.getText();
		        String species = species_Field.getText();
		        String breed = breed_Field.getText();
		        String weight = weight_Field.getText();
		        String age = age_Field.getText();
		        String gender = rdbtnMale.isSelected() ? "Male" : "Female";
		        String color = colorMarkings_Field.getText();

		        if (petName.isEmpty() || species.isEmpty() || breed.isEmpty() || weight.isEmpty() || age.isEmpty() || color.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (!weight.matches("[0-9]+") || !age.matches("[0-9]+")) {
		            JOptionPane.showMessageDialog(null, "Weight and age must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            DatabaseManager dbManager = DatabaseManager.getInstance();
		            dbManager.updatePet(petId, petName, species, breed, weight, age, gender, color);
		            
	                JOptionPane.showMessageDialog(null,"Pet updated successfully! Pet ID: " + petId);
	                
	                dispose();
	                
	                if(whereFrom == "clientPanel") {
	                	resultClientInformation.updateScrollMax();
	                } else if(whereFrom == "petPanel") {
	                	resultPetInformation.updatePetInformation(petId);
	                }
	                
		        } catch (SQLException ex) {
		            if (ex instanceof MysqlDataTruncation) {
		                MysqlDataTruncation truncationEx = (MysqlDataTruncation) ex;
		                
		                JOptionPane.showMessageDialog(null, truncationEx.getErrorCode() + "; Truncation error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
		            } else {
		                JOptionPane.showMessageDialog(null, "Error occurred while editting pet: " + ex.getMessage());
		            }
		        }
		    }
		});


	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
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