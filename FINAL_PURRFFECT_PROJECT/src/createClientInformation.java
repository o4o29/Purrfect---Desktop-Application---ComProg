import javax.swing.border.EmptyBorder;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createClientInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstname_field;
	private JTextField lastname_field;
	private JTextField contact_field;
	private JTextField email_field;
	private JTextField street_field;
	private JTextField city_field;
	private JTextField barangay_field;
	private JTextField blockLot_field;
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		setSize(500, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
		lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel_2_2.setBounds(150, -12, 193, 75);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblPleaseProvideAll = new JLabel("Please provide all required details.");
		lblPleaseProvideAll.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		lblPleaseProvideAll.setBounds(129, 146, 229, 19);
		contentPane.add(lblPleaseProvideAll);
		
		JLabel lblClientRegistration = new JLabel("Client Registration");
		lblClientRegistration.setForeground(new Color(255, 20, 147));
		lblClientRegistration.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblClientRegistration.setBounds(148, 101, 176, 56);
		contentPane.add(lblClientRegistration);
		
		JLabel lblClientInformationresult = new JLabel("Veterinary Clinic Management System");
		lblClientInformationresult.setForeground(new Color(255, 20, 147));
		lblClientInformationresult.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblClientInformationresult.setBounds(20, 28, 464, 75);
		contentPane.add(lblClientInformationresult);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 484, 90);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(29, 191, 424, 296);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBlockLotNo = new JLabel("Block & Lot No.:");
		lblBlockLotNo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblBlockLotNo.setBounds(22, 102, 128, 14);
		panel.add(lblBlockLotNo);
		
		blockLot_field = new JTextField();
		blockLot_field.setText("");
		blockLot_field.setColumns(10);
		blockLot_field.setBounds(150, 100, 248, 20);
		panel.add(blockLot_field);
		
		JLabel lblCompleteAddress = new JLabel("COMPLETE ADDRESS:");
		lblCompleteAddress.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblCompleteAddress.setBounds(22, 77, 197, 14);
		panel.add(lblCompleteAddress);
		
		barangay_field = new JTextField();
		barangay_field.setText("");
		barangay_field.setColumns(10);
		barangay_field.setBounds(150, 148, 248, 20);
		panel.add(barangay_field);
		
		JLabel lblContact = new JLabel("Contact No.:");
		lblContact.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblContact.setBounds(22, 197, 118, 14);
		panel.add(lblContact);
		
		JLabel lblState = new JLabel("City:");
		lblState.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblState.setBounds(22, 167, 106, 25);
		panel.add(lblState);
		
		contact_field = new JTextField();
		contact_field.setColumns(10);
		contact_field.setBounds(150, 195, 248, 20);
		panel.add(contact_field);
		contact_field.setText("");
		
		street_field = new JTextField();
		street_field.setText("");
		street_field.setColumns(10);
		street_field.setBounds(150, 123, 248, 20);
		panel.add(street_field);
		
		JLabel lblCity = new JLabel("Barangay:");
		lblCity.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCity.setBounds(22, 148, 106, 20);
		panel.add(lblCity);
		
		city_field = new JTextField();
		city_field.setText("");
		city_field.setColumns(10);
		city_field.setBounds(150, 171, 248, 20);
		panel.add(city_field);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(22, 11, 118, 19);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		firstname_field = new JTextField();
		firstname_field.setBounds(150, 12, 248, 20);
		panel.add(firstname_field);
		firstname_field.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(22, 36, 96, 14);
		panel.add(lblLastName);
		lblLastName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		lastname_field = new JTextField();
		lastname_field.setColumns(10);
		lastname_field.setBounds(150, 35, 248, 20);
		panel.add(lastname_field);
		
		JLabel lblStreetAddress = new JLabel("Street:");
		lblStreetAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStreetAddress.setBounds(22, 125, 128, 14);
		panel.add(lblStreetAddress);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmailAddress.setBounds(22, 222, 106, 14);
		panel.add(lblEmailAddress);
		
		email_field = new JTextField();
		email_field.setColumns(10);
		email_field.setBounds(150, 220, 248, 20);
		panel.add(email_field);
		
		JButton btnCreateClient = new JButton("SAVE");
		btnCreateClient.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCreateClient.setBackground(new Color(255, 240, 245));
		btnCreateClient.setBounds(150, 263, 111, 25);
		panel.add(btnCreateClient);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCancel.setBackground(new Color(255, 240, 245));
		btnCancel.setBounds(34, 263, 106, 25);
		panel.add(btnCancel);
		
		JButton btnClearAll = new JButton("CLEAR ALL");
		btnClearAll.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnClearAll.setBackground(new Color(255, 240, 245));
		btnClearAll.setBounds(271, 263, 117, 25);
		panel.add(btnClearAll);
		
		
		// BUTTON LISTENERS
		btnCreateClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String firstName = firstname_field.getText();
		        String lastName = lastname_field.getText();
		        
		        String blockLot = blockLot_field.getText();
		        String street = street_field.getText();
		        String barangay = barangay_field.getText();
		        String city = city_field.getText();
		        String address = blockLot + ", " + street + ", " + barangay + ", " + city;
		        
		        String contact = contact_field.getText();
		        String email = email_field.getText();
		        
		        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		        Matcher emailMatcher = emailPattern.matcher(email);
		        
		        Date currentDate = new Date();
		        java.sql.Date dateCreated = new java.sql.Date(currentDate.getTime());
		        
		        if (firstName.isEmpty() || lastName.isEmpty() || blockLot.isEmpty() || street.isEmpty() || barangay.isEmpty() || city.isEmpty() || contact.isEmpty() || email.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (!contact.matches("[0-9]+")) {
		            JOptionPane.showMessageDialog(null, "Contact number must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (!emailMatcher.matches()) {
		            JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        
		        try {
		            DatabaseManager dbManager = DatabaseManager.getInstance();
		            int clientId = dbManager.insertClient(firstName, lastName, address, contact, email, dateCreated);
		            
		            if (clientId != -1) {
		                JOptionPane.showMessageDialog(null,"Record successfully added!\n\n Client ID: " + clientId);
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


		btnClearAll.addActionListener(e -> {
			firstname_field.setText("");
			lastname_field.setText("");
			street_field.setText("");
			city_field.setText("");
			barangay_field.setText("");
			contact_field.setText("");
			email_field.setText("");
		});
		
		btnCancel.addActionListener(e -> {
			dispose();
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	public createClientInformation() {
		setTitle("Client Registration");
		initialize();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new createClientInformation();
		});
	}
}