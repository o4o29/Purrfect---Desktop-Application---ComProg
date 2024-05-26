

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class resultPetInformation {

	private JFrame frame;
	private JTextField petID_Field;
	private JTextField petName_Field;
	private JTextField clientID_Field;
	private JTextField species_Field;
	private JTextField breed_Field;
	private JTextField weight_Field;
	private JTextField age_Field;
	private JTextField gender_Field;
	private JTextField colorMarkings_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultPetInformation window = new resultPetInformation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public resultPetInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(10, 200, 325, 333);
		frame.getContentPane().add(mainPanel);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetId.setBounds(10, 12, 86, 14);
		mainPanel.add(lblPetId);
		
		petID_Field = new JTextField();
		petID_Field.setColumns(10);
		petID_Field.setBounds(98, 11, 204, 20);
		mainPanel.add(petID_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetName.setBounds(10, 37, 86, 14);
		mainPanel.add(lblPetName);
		
		petName_Field = new JTextField();
		petName_Field.setColumns(10);
		petName_Field.setBounds(98, 36, 204, 20);
		mainPanel.add(petName_Field);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblClientId.setBounds(10, 65, 86, 14);
		mainPanel.add(lblClientId);
		
		clientID_Field = new JTextField();
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(98, 64, 204, 20);
		mainPanel.add(clientID_Field);
		
		JLabel lblSpecies = new JLabel("Species:");
		lblSpecies.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSpecies.setBounds(10, 94, 86, 14);
		mainPanel.add(lblSpecies);
		
		species_Field = new JTextField();
		species_Field.setColumns(10);
		species_Field.setBounds(98, 90, 204, 20);
		mainPanel.add(species_Field);
		
		JLabel lblClientId_1_1 = new JLabel("Breed:\r\n");
		lblClientId_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblClientId_1_1.setBounds(10, 120, 86, 14);
		mainPanel.add(lblClientId_1_1);
		
		JLabel lblClientId_1_1_1 = new JLabel("Weight:");
		lblClientId_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblClientId_1_1_1.setBounds(10, 142, 86, 14);
		mainPanel.add(lblClientId_1_1_1);
		
		JLabel lblClientId_1_1_1_1 = new JLabel("Age:");
		lblClientId_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblClientId_1_1_1_1.setBounds(10, 167, 86, 14);
		mainPanel.add(lblClientId_1_1_1_1);
		
		JLabel lblClientId_1_1_1_1_1 = new JLabel("Gender:");
		lblClientId_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblClientId_1_1_1_1_1.setBounds(10, 192, 86, 14);
		mainPanel.add(lblClientId_1_1_1_1_1);
		
		breed_Field = new JTextField();
		breed_Field.setColumns(10);
		breed_Field.setBounds(98, 119, 204, 20);
		mainPanel.add(breed_Field);
		
		weight_Field = new JTextField();
		weight_Field.setColumns(10);
		weight_Field.setBounds(98, 141, 204, 20);
		mainPanel.add(weight_Field);
		
		age_Field = new JTextField();
		age_Field.setColumns(10);
		age_Field.setBounds(98, 166, 204, 20);
		mainPanel.add(age_Field);
		
		JLabel lblClientId_1_1_1_1_1_1 = new JLabel("Color Markings:");
		lblClientId_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblClientId_1_1_1_1_1_1.setBounds(10, 217, 141, 14);
		mainPanel.add(lblClientId_1_1_1_1_1_1);
		
		gender_Field = new JTextField();
		gender_Field.setColumns(10);
		gender_Field.setBounds(98, 192, 204, 20);
		mainPanel.add(gender_Field);
		
		colorMarkings_Field = new JTextField();
		colorMarkings_Field.setColumns(10);
		colorMarkings_Field.setBounds(136, 216, 166, 20);
		mainPanel.add(colorMarkings_Field);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(108, 270, 89, 23);
		mainPanel.add(btnEdit);
		btnEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		JButton btnCreateAppointment = new JButton("Create Appointment");
		btnCreateAppointment.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCreateAppointment.setBounds(64, 299, 166, 23);
		mainPanel.add(btnCreateAppointment);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(0, 0, 884, 153);
		frame.getContentPane().add(panel_1);
		
		JLabel lblClientInformation_1 = new JLabel("(Result)");
		lblClientInformation_1.setForeground(Color.WHITE);
		lblClientInformation_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 28));
		lblClientInformation_1.setBounds(356, 78, 140, 75);
		panel_1.add(lblClientInformation_1);
		
		JLabel lblPetInformation = new JLabel("PET INFORMATION");
		lblPetInformation.setBounds(108, 21, 722, 75);
		panel_1.add(lblPetInformation);
		lblPetInformation.setForeground(Color.WHITE);
		lblPetInformation.setFont(new Font("Verdana", Font.BOLD, 60));
		
		JLabel lblOtherInformation = new JLabel("Other Information");
		lblOtherInformation.setForeground(new Color(255, 105, 180));
		lblOtherInformation.setFont(new Font("Verdana", Font.BOLD, 20));
		lblOtherInformation.setBounds(521, 144, 205, 61);
		frame.getContentPane().add(lblOtherInformation);
		
		JLabel lblPetInformation_1 = new JLabel("Pet Information");
		lblPetInformation_1.setForeground(new Color(255, 105, 180));
		lblPetInformation_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPetInformation_1.setBounds(80, 153, 205, 42);
		frame.getContentPane().add(lblPetInformation_1);
		
		JPanel mainPanel_1 = new JPanel();
		mainPanel_1.setLayout(null);
		mainPanel_1.setBackground(new Color(255, 182, 193));
		mainPanel_1.setBounds(354, 200, 520, 333);
		frame.getContentPane().add(mainPanel_1);
	}
}
