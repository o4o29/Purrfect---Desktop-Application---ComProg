import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class editPetInformation {

	private JFrame frmEditPetInformation;
	private JTextField textField;
	private JTextField petName_Field;
	private JTextField age_Field;
	private JTextField colorMarkings_Field;
	private JTextField textField_4;
	private JTextField weight_Field;
	private JTextField breed_Field;
	private JTextField species_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editPetInformation window = new editPetInformation();
					window.frmEditPetInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editPetInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditPetInformation = new JFrame();
		frmEditPetInformation.getContentPane().setBackground(new Color(255, 228, 225));
		frmEditPetInformation.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255, 182, 193));
		headerPanel.setBounds(0, 0, 884, 150);
		frmEditPetInformation.getContentPane().add(headerPanel);
		
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
		frmEditPetInformation.getContentPane().add(mainPanel);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 43, 248, 20);
		mainPanel.add(textField);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 12, 248, 20);
		mainPanel.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Gender:");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_2.setBounds(31, 217, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1_2);
		
		JRadioButton rdobtnMale = new JRadioButton("Male");
		rdobtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdobtnMale.setBackground(new Color(255, 182, 193));
		rdobtnMale.setBounds(133, 213, 64, 23);
		mainPanel.add(rdobtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
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
		frmEditPetInformation.setTitle("Edit Pet Information");
		frmEditPetInformation.setBounds(100, 100, 900, 600);
		frmEditPetInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
