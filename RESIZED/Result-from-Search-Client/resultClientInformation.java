

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSet;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
	public class resultClientInformation {

	private JFrame frame;
	private JTextField clientID_Field;
	private JTable table;
	private JTextField firstName_Field;
	private JTextField lastName_Field;
	private JTextField address_Field;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField petID_Field;
	private JTextField petName_Field;
	private JTextField species_Field;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField breed_Field;
	private JTextField textField_2;
	private JTextField colorMarkings_Field;




	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBackground(new Color(255, 228, 225));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClientInformation = new JLabel("CLIENT INFORMATION");
		lblClientInformation.setForeground(Color.WHITE);
		lblClientInformation.setFont(new Font("Verdana", Font.BOLD, 60));
		lblClientInformation.setBounds(56, 28, 779, 75);
		frame.getContentPane().add(lblClientInformation);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(56, 198, 358, 303);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 12, 86, 14);
		panel.add(lblNewLabel);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setBounds(128, 11, 207, 20);
		panel.add(clientID_Field);
		clientID_Field.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName.setBounds(10, 40, 111, 14);
		panel.add(lblFirstName);
		
		JLabel lblFirstName_1 = new JLabel("Last Name:");
		lblFirstName_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1.setBounds(10, 65, 111, 14);
		panel.add(lblFirstName_1);
		
		firstName_Field = new JTextField();
		firstName_Field.setEditable(false);
		firstName_Field.setColumns(10);
		firstName_Field.setBounds(128, 39, 207, 20);
		panel.add(firstName_Field);
		
		lastName_Field = new JTextField();
		lastName_Field.setEditable(false);
		lastName_Field.setColumns(10);
		lastName_Field.setBounds(128, 65, 207, 20);
		panel.add(lastName_Field);
		
		JLabel lblFirstName_1_1 = new JLabel("Address:");
		lblFirstName_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1.setBounds(10, 90, 111, 14);
		panel.add(lblFirstName_1_1);
		
		address_Field = new JTextField();
		address_Field.setEditable(false);
		address_Field.setColumns(10);
		address_Field.setBounds(128, 90, 207, 54);
		panel.add(address_Field);
		
		JLabel lblFirstName_1_1_1 = new JLabel("Contact No.:");
		lblFirstName_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1.setBounds(10, 155, 111, 14);
		panel.add(lblFirstName_1_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(128, 155, 207, 20);
		panel.add(textField);
		
		JLabel lblFirstName_1_1_1_1 = new JLabel("Email Address:");
		lblFirstName_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1.setBounds(10, 182, 111, 14);
		panel.add(lblFirstName_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(128, 181, 207, 20);
		panel.add(textField_1);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(128, 234, 89, 23);
		panel.add(btnEdit);
		btnEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		JButton btnAddPet = new JButton("ADD PET");
		btnAddPet.setBounds(128, 268, 89, 23);
		panel.add(btnAddPet);
		btnAddPet.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		
	
		
		
		btnAddPet.addActionListener(e -> {
			frame.dispose();
			new createPetInformation();
		});
		
		table = new JTable();
		table.setBounds(76, 303, 0, 0);
		frame.getContentPane().add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(0, 0, 884, 153);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClientInformation_1 = new JLabel("(Result)");
		lblClientInformation_1.setBounds(360, 78, 140, 75);
		panel_1.add(lblClientInformation_1);
		lblClientInformation_1.setForeground(Color.WHITE);
		lblClientInformation_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 28));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setBounds(455, 198, 358, 303);
		frame.getContentPane().add(panel_2);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetId.setBounds(10, 12, 86, 14);
		panel_2.add(lblPetId);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setColumns(10);
		petID_Field.setBounds(128, 11, 207, 20);
		panel_2.add(petID_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetName.setBounds(10, 40, 111, 14);
		panel_2.add(lblPetName);
		
		JLabel lblFirstName_1_2 = new JLabel("Species: ");
		lblFirstName_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_2.setBounds(10, 65, 111, 14);
		panel_2.add(lblFirstName_1_2);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(128, 39, 207, 20);
		panel_2.add(petName_Field);
		
		species_Field = new JTextField();
		species_Field.setEditable(false);
		species_Field.setColumns(10);
		species_Field.setBounds(128, 65, 207, 20);
		panel_2.add(species_Field);
		
		JLabel lblFirstName_1_1_2 = new JLabel("Breed:");
		lblFirstName_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_2.setBounds(10, 90, 111, 14);
		panel_2.add(lblFirstName_1_1_2);
		
		JLabel lblFirstName_1_1_1_2 = new JLabel("Weight:");
		lblFirstName_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_2.setBounds(10, 115, 111, 19);
		panel_2.add(lblFirstName_1_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(128, 114, 207, 20);
		panel_2.add(textField_6);
		
		JLabel lblFirstName_1_1_1_1_1 = new JLabel("Age:");
		lblFirstName_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1_1.setBounds(10, 139, 111, 19);
		panel_2.add(lblFirstName_1_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(128, 138, 207, 20);
		panel_2.add(textField_7);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEdit_1.setBounds(147, 241, 89, 23);
		panel_2.add(btnEdit_1);
		
		breed_Field = new JTextField();
		breed_Field.setEditable(false);
		breed_Field.setColumns(10);
		breed_Field.setBounds(128, 89, 207, 20);
		panel_2.add(breed_Field);
		
		JLabel lblFirstName_1_1_1_1_1_1 = new JLabel("Gender:");
		lblFirstName_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1_1_1.setBounds(10, 165, 111, 19);
		panel_2.add(lblFirstName_1_1_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(128, 166, 207, 20);
		panel_2.add(textField_2);
		
		JLabel lblFirstName_1_1_1_1_1_1_1 = new JLabel("Color Markings:");
		lblFirstName_1_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1_1_1_1.setBounds(10, 188, 130, 19);
		panel_2.add(lblFirstName_1_1_1_1_1_1_1);
		
		colorMarkings_Field = new JTextField();
		colorMarkings_Field.setEditable(false);
		colorMarkings_Field.setColumns(10);
		colorMarkings_Field.setBounds(128, 189, 207, 20);
		panel_2.add(colorMarkings_Field);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(170, 269, 50, 23);
		panel_2.add(scrollBar);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new resultClientInformation();
		});
	}

	public resultClientInformation() {
		initialize();
		frame.setVisible(true);
	}
		private static class __Tmp {
			private static void __tmp() {
				  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
			}
		}
}
