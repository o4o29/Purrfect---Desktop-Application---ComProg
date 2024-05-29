import javax.swing.border.EmptyBorder;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
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
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
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
		textArea.setEditable(false);
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
		btnCreateClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String firstName = firstname_field.getText();
		        String lastName = lastname_field.getText();
		        String address = address_field.getText();
		        String contact = contact_field.getText();
		        String email = email_field.getText();
	
		        // Check if any of the fields are empty
		        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        // Check if contact number contains only numeric characters
		        if (!contact.matches("[0-9]+")) {
		            JOptionPane.showMessageDialog(null, "Contact number must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
	
		        // Insert client information into the database
		        try {
		            DatabaseManager dbManager = DatabaseManager.getInstance();
		            int clientId = dbManager.insertClient(firstName, lastName, address, contact, email);
		            if (clientId != -1) {
		                JOptionPane.showMessageDialog(null,"Client created successfully! Client ID: " + clientId);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to retrieve client ID.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException ex) {
		            if (ex instanceof MysqlDataTruncation) {
		                MysqlDataTruncation truncationEx = (MysqlDataTruncation) ex;
		                
		                if(truncationEx.getErrorCode() == 1406) {
		                    JOptionPane.showMessageDialog(null, "The contact number must only contain 11 numbers!", "Error", JOptionPane.ERROR_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(null, truncationEx.getErrorCode() + "; Truncation error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		                }   
		            } else {
		                JOptionPane.showMessageDialog(null, "Error occurred while creating client: " + ex.getMessage());
		            }
		        }
		    }
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	public createClientInformation() {
		initialize();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new createClientInformation();
		});
	}
}