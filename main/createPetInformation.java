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
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class createPetInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField petname_field;
	private JTextField species_field;
	private JTextField breed_field;
	private JTextField weight_field;
	private JTextField age_field;
	private JTextField color_field;
	private static int clientId;
	private static JTextField clientId_field;

	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(900, 533);
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE PET");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel.setBounds(258, 0, 391, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMATION\r\n");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(300, 54, 292, 61);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 115);
		contentPane.add(textArea);
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(150, 153, 620, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel clientId_label = new JLabel("Client ID:");
		clientId_label.setBounds(38, 24, 85, 19);
		panel.add(clientId_label);
		clientId_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		clientId_field = new JTextField();
		clientId_field.setEditable(false);
		clientId_field.setBounds(130, 25, 145, 20);
		panel.add(clientId_field);
		clientId_field.setColumns(10);
		
		JLabel petname_label = new JLabel("Pet Name:");
		petname_label.setBounds(38, 61, 106, 19);
		panel.add(petname_label);
		petname_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		petname_field = new JTextField();
		petname_field.setColumns(10);
		petname_field.setBounds(130, 62, 145, 20);
		panel.add(petname_field);
		
		JLabel petspecies_label = new JLabel("Species:");
		petspecies_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petspecies_label.setBounds(38, 97, 106, 14);
		panel.add(petspecies_label);
		
		species_field = new JTextField();
		species_field.setColumns(10);
		species_field.setBounds(130, 96, 145, 20);
		panel.add(species_field);
		
		JLabel breed_label = new JLabel("Breed:");
		breed_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		breed_label.setBounds(38, 132, 106, 14);
		panel.add(breed_label);
		
		breed_field = new JTextField();
		breed_field.setColumns(10);
		breed_field.setBounds(130, 131, 145, 20);
		panel.add(breed_field);
		
		JLabel gender_label = new JLabel("Gender:");
		gender_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gender_label.setBounds(304, 91, 106, 14);
		panel.add(gender_label);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMale.setBackground(new Color(255, 182, 193));
		rdbtnMale.setBounds(405, 88, 64, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female\r\n");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFemale.setBackground(new Color(255, 182, 193));
		rdbtnFemale.setBounds(471, 88, 85, 23);
		panel.add(rdbtnFemale);
		
		JLabel weight_label = new JLabel("Weight:");
		weight_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		weight_label.setBounds(304, 24, 85, 19);
		panel.add(weight_label);
		
		weight_field = new JTextField();
		weight_field.setColumns(10);
		weight_field.setBounds(415, 25, 165, 20);
		panel.add(weight_field);
		
		JLabel age_label = new JLabel("Age:");
		age_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		age_label.setBounds(304, 58, 85, 19);
		panel.add(age_label);
		
		age_field = new JTextField();
		age_field.setColumns(10);
		age_field.setBounds(415, 58, 165, 20);
		panel.add(age_field);
		
		JLabel color_label = new JLabel("Color/ Markings:");
		color_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		color_label.setBounds(304, 130, 109, 19);
		panel.add(color_label);
		
		color_field = new JTextField();
		color_field.setColumns(10);
		color_field.setBounds(415, 131, 165, 20);
		panel.add(color_field);
		
		JButton btnCreatePet = new JButton("ADD PET\r\n");
		btnCreatePet.setBounds(706, 434, 150, 25);
		contentPane.add(btnCreatePet);
		btnCreatePet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreatePet.setBackground(new Color(255, 240, 245));
		
		
		// BUTTON LISTENERS
		btnCreatePet.addActionListener(new ActionListener() { // create pet
            public void actionPerformed(ActionEvent e) {
                try {
                    String petName = petname_field.getText();
                    String species = species_field.getText();
                    String breed = breed_field.getText();
                    String weight = weight_field.getText();
                    String age = age_field.getText();
                    String gender = rdbtnMale.isSelected() ? "Male" : rdbtnFemale.isSelected() ? "Female" : "";
                    String color = color_field.getText();
                    
                    if (petName.isEmpty() || species.isEmpty() || breed.isEmpty() || weight.isEmpty() || age.isEmpty() || color.isEmpty() || gender.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (!weight.matches("[0-9]+") || !age.matches("[0-9]+")) {
    		            JOptionPane.showMessageDialog(null, "Weight and age must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
    		            return;
    		        }
                    
                    DatabaseManager dbManager = DatabaseManager.getInstance();
                    int petID = dbManager.insertPet(clientId, petName, species, breed, weight, age, gender, color);
                    
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
	}
	// ----------------------------------------------------------------------------------------------------------------------------------

	
	public static void getOwnerId(String clientId) {
		new createPetInformation();
		createPetInformation.clientId = Integer.parseInt(clientId);
		clientId_field.setText(clientId);
	}
	
	public createPetInformation() {
		initialize();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new createPetInformation();
		});
	}
}