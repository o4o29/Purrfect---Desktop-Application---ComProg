

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class createPetInformation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField clientId_field;
	private JTextField petname_field;
	private JTextField species_field;
	private JTextField breed_field;
	private JTextField weight_field;
	private JTextField age_field;
	private JTextField color_field;



	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(713, 436); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE PET");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblNewLabel.setBounds(193, 0, 304, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMATION\r\n");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(216, 54, 304, 61);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 697, 115);
		contentPane.add(textArea);
		
		JButton backBtn = new JButton("BACK");
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backBtn.setBackground(new Color(255, 240, 245));
		backBtn.setBounds(10, 361, 101, 25);
		contentPane.add(backBtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(62, 136, 569, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel clientId_label = new JLabel("Client ID:");
		clientId_label.setBounds(38, 24, 85, 19);
		panel.add(clientId_label);
		clientId_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		clientId_field = new JTextField();
		clientId_field.setBounds(130, 25, 145, 20);
		panel.add(clientId_field);
		clientId_field.setColumns(10);
		
		JLabel petname_label = new JLabel("Pet Name:");
		petname_label.setBounds(38, 59, 96, 14);
		panel.add(petname_label);
		petname_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		petname_field = new JTextField();
		petname_field.setColumns(10);
		petname_field.setBounds(130, 58, 145, 20);
		panel.add(petname_field);
		
		JLabel petspecies_label = new JLabel("Species:");
		petspecies_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petspecies_label.setBounds(38, 91, 106, 14);
		panel.add(petspecies_label);
		
		species_field = new JTextField();
		species_field.setColumns(10);
		species_field.setBounds(130, 90, 145, 20);
		panel.add(species_field);
		
		JLabel breed_label = new JLabel("Breed:");
		breed_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		breed_label.setBounds(38, 125, 106, 14);
		panel.add(breed_label);
		
		breed_field = new JTextField();
		breed_field.setColumns(10);
		breed_field.setBounds(129, 124, 145, 20);
		panel.add(breed_field);
		
		JLabel gender_label = new JLabel("Gender:");
		gender_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gender_label.setBounds(304, 91, 106, 14);
		panel.add(gender_label);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBackground(new Color(255, 182, 193));
		rdbtnNewRadioButton.setBounds(382, 88, 64, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female\r\n");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFemale.setBackground(new Color(255, 182, 193));
		rdbtnFemale.setBounds(441, 88, 109, 23);
		panel.add(rdbtnFemale);
		
		JLabel weight_label = new JLabel("Weight:");
		weight_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		weight_label.setBounds(304, 24, 85, 19);
		panel.add(weight_label);
		
		weight_field = new JTextField();
		weight_field.setColumns(10);
		weight_field.setBounds(382, 25, 145, 20);
		panel.add(weight_field);
		
		JLabel age_label = new JLabel("Age:");
		age_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		age_label.setBounds(304, 58, 85, 19);
		panel.add(age_label);
		
		age_field = new JTextField();
		age_field.setColumns(10);
		age_field.setBounds(382, 58, 145, 20);
		panel.add(age_field);
		
		JLabel color_label = new JLabel("Color/ Markings:");
		color_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		color_label.setBounds(304, 123, 109, 19);
		panel.add(color_label);
		
		color_field = new JTextField();
		color_field.setColumns(10);
		color_field.setBounds(418, 124, 109, 20);
		panel.add(color_field);
		
		JButton btnNewButton_2_1_1_1 = new JButton("CREATE CLIENT\r\n");
		btnNewButton_2_1_1_1.setBounds(537, 361, 150, 25);
		contentPane.add(btnNewButton_2_1_1_1);
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1_1_1.setBackground(new Color(255, 240, 245));
		
		
		// BUTTONS
		backBtn.addActionListener(e -> {
			this.dispose();
			new searchClientAndPet();
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new createPetInformation();
		});
	}

	public createPetInformation() {
		initialize();
		this.setVisible(true);
	}
}
