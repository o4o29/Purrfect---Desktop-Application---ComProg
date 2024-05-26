import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class createClientInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstname_field;
	private JTextField lastname_field;
	private JTextArea address_field;
	private JTextField contact_field;
	private JTextField email_field;
	
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(900, 599); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE CLIENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel.setBounds(195, 0, 505, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMATION\r\n");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(290, 54, 314, 61);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 115);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(174, 142, 538, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(69, 29, 76, 19);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		firstname_field = new JTextField();
		firstname_field.setBounds(185, 30, 248, 20);
		panel.add(firstname_field);
		firstname_field.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(69, 62, 96, 14);
		panel.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lastname_field = new JTextField();
		lastname_field.setColumns(10);
		lastname_field.setBounds(185, 61, 248, 20);
		panel.add(lastname_field);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(69, 95, 106, 14);
		panel.add(lblAddress);
		
		address_field = new JTextArea();	
		address_field.setBounds(185, 92, 248, 51);
		panel.add(address_field);
		
		JLabel lblContact = new JLabel("Contact No.:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContact.setBounds(69, 155, 106, 14);
		panel.add(lblContact);
		
		contact_field = new JTextField();
		contact_field.setColumns(10);
		contact_field.setBounds(185, 154, 248, 20);
		panel.add(contact_field);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailAddress.setBounds(69, 186, 106, 14);
		panel.add(lblEmailAddress);
		
		email_field = new JTextField();
		email_field.setColumns(10);
		email_field.setBounds(185, 185, 248, 20);
		panel.add(email_field);
		
		JButton btnCreateClient = new JButton("CREATE CLIENT\r\n");
		btnCreateClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreateClient.setBackground(new Color(255, 240, 245));
		btnCreateClient.setBounds(227, 229, 150, 25);
		panel.add(btnCreateClient);
		
		
		// BUTTON LISTENERS
		btnCreateClient.addActionListener(e -> {
            String firstname = firstname_field.getText();
            String lastname = lastname_field.getText();
            String address = address_field.getText();
            String contact = contact_field.getText();
            String email = email_field.getText();

            try {
                DatabaseManager dbManager = DatabaseManager.getInstance();
                dbManager.insertClient(firstname, lastname, address, contact, email);
                JOptionPane.showMessageDialog(this, "Client created successfully!");
                
                SwingUtilities.invokeLater(() -> {
                	this.dispose();
                    new searchClientAndPet();
                });
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error creating client: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
		}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new createClientInformation();
		});
	}
	
	public createClientInformation() {
		initialize();
		this.setVisible(true);
	}
}
