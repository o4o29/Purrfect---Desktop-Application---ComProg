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
import javax.swing.JTextArea;

public class editClientInformation extends JFrame{
	private static final long serialVersionUID = 1L;
	private static int clientId;
	private static JTextField firstName_Field;
	private static JTextField lastName_Field;

	private static JTextField blockLot_Field;
	private static JTextField street_Field;
	private static JTextField barangay_Field;
	private static JTextField city_Field;

	private static JTextField clientId_Field;
	private static JTextField contact_Field;
	private static JTextField email_field;

	
	public static void getClientIdEdit(int clientId) {
		editClientInformation.clientId = clientId;
		
		SwingUtilities.invokeLater(() -> new editClientInformation().populateFields());
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setTitle("Edit Client Information");
		setSize(500, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblEditClientInformation = new JLabel("Edit Client Information");
		lblEditClientInformation.setForeground(new Color(255, 20, 147));
		lblEditClientInformation.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEditClientInformation.setBounds(135, 99, 244, 56);
		getContentPane().add(lblEditClientInformation);
		
		JLabel lblClientInformationresult = new JLabel("Veterinary Clinic Management System");
		lblClientInformationresult.setForeground(new Color(255, 20, 147));
		lblClientInformationresult.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblClientInformationresult.setBounds(20, 26, 464, 75);
		getContentPane().add(lblClientInformationresult);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("PURRFECT");
		lblNewLabel_2_2_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2_1.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel_2_2_1.setBounds(151, -13, 193, 75);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 484, 90);
		getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(20, 154, 442, 331);
		getContentPane().add(panel);
		
		clientId_Field = new JTextField();
		clientId_Field.setBounds(148, 8, 86, 20);
		panel.add(clientId_Field);
		clientId_Field.setEditable(false);
		clientId_Field.setText("");
		clientId_Field.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("CLIENT ID:");
		lblNewLabel_2_2.setBounds(21, 11, 96, 19);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblStreet = new JLabel("Street:\r\n");
		lblStreet.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStreet.setBounds(21, 154, 106, 14);
		panel.add(lblStreet);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFirstName.setBounds(21, 40, 83, 19);
		panel.add(lblFirstName);
		
		firstName_Field = new JTextField();
		firstName_Field.setText("");
		firstName_Field.setColumns(10);
		firstName_Field.setBounds(148, 39, 263, 20);
		panel.add(firstName_Field);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblLastName.setBounds(21, 65, 96, 14);
		panel.add(lblLastName);
		
		lastName_Field = new JTextField();
		lastName_Field.setText("");
		lastName_Field.setColumns(10);
		lastName_Field.setBounds(148, 64, 263, 20);
		panel.add(lastName_Field);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("COMPLETE ADDRESS:");
		lblNewLabel_2_2_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_2_2_2.setBounds(21, 99, 192, 19);
		panel.add(lblNewLabel_2_2_2);
		

		
		JLabel lblStreetAddress = new JLabel("Block & Lot No.:");
		lblStreetAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStreetAddress.setBounds(21, 129, 129, 14);
		panel.add(lblStreetAddress);
		
		JLabel lblContact = new JLabel("Contact No.:");
		lblContact.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblContact.setBounds(21, 228, 106, 14);
		panel.add(lblContact);
		
		contact_Field = new JTextField();
		contact_Field.setText("");
		contact_Field.setColumns(10);
		contact_Field.setBounds(148, 227, 263, 20);
		panel.add(contact_Field);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmailAddress.setBounds(21, 253, 106, 14);
		panel.add(lblEmailAddress);
		
		email_field = new JTextField();
		email_field.setText("");
		email_field.setColumns(10);
		email_field.setBounds(148, 252, 263, 20);
		panel.add(email_field);
		

		JButton btnSaveClient = new JButton("SAVE");
		btnSaveClient.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSaveClient.setBackground(new Color(255, 218, 185));
		btnSaveClient.setBounds(154, 295, 111, 25);
		panel.add(btnSaveClient);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCancel.setBackground(new Color(255, 218, 185));
		btnCancel.setBounds(38, 295, 106, 25);
		panel.add(btnCancel);
		
		JButton btnClearAll = new JButton("CLEAR ALL");
		btnClearAll.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnClearAll.setBackground(new Color(255, 218, 185));
		btnClearAll.setBounds(275, 295, 117, 25);
		panel.add(btnClearAll);

		blockLot_Field = new JTextField();
		blockLot_Field.setColumns(10);
		blockLot_Field.setBounds(148, 128, 263, 20);
		panel.add(blockLot_Field);
		
		street_Field = new JTextField();
		street_Field.setText("");
		street_Field.setColumns(10);
		street_Field.setBounds(148, 154, 263, 20);
		panel.add(street_Field);
		
		city_Field = new JTextField();
		city_Field.setText("");
		city_Field.setColumns(10);
		city_Field.setBounds(148, 202, 263, 20);
		panel.add(city_Field);
		
		barangay_Field = new JTextField();
		barangay_Field.setText("");
		barangay_Field.setColumns(10);
		barangay_Field.setBounds(148, 176, 263, 20);
		panel.add(barangay_Field);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCity.setBounds(21, 203, 106, 14);
		panel.add(lblCity);
		
		JLabel lblState = new JLabel("Barangay:");
		lblState.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblState.setBounds(21, 174, 106, 20);
		panel.add(lblState);
		
		
		btnSaveClient.addActionListener(new ActionListener() { // submit button
		    public void actionPerformed(ActionEvent e) {
		        String firstName = firstName_Field.getText();
		        String lastName = lastName_Field.getText();
		        
		        String blockLot = blockLot_Field.getText();
		        String street = street_Field.getText();
		        String barangay = barangay_Field.getText();
		        String city = city_Field.getText();
		        String address = blockLot + ", " + street + ", " + barangay + ", " + city;
		        
		        String contact = contact_Field.getText();
		        String email = blockLot_Field.getText();

		        
		        if (firstName.isEmpty() || lastName.isEmpty() || blockLot.isEmpty() || street.isEmpty() || barangay.isEmpty() || city.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (!contact.matches("[0-9]+")) {
		            JOptionPane.showMessageDialog(null, "Contact number must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            DatabaseManager dbManager = DatabaseManager.getInstance();
		            dbManager.updateClient(clientId, firstName, lastName, address, contact, email);
		            
	                JOptionPane.showMessageDialog(null,"Client updated successfully! Client ID: " + clientId);
	                
	                dispose();
	                resultClientInformation.updateClientInformation(clientId);
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
			firstName_Field.setText("");
			lastName_Field.setText("");
			street_Field.setText("");
			city_Field.setText("");
			barangay_Field.setText("");
			contact_Field.setText("");
			blockLot_Field.setText("");
		});
		
		btnCancel.addActionListener(e -> {
			dispose();
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	public void populateFields() {
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getClientById(clientId);
		     
		     if (resultSet.next()) {
		    	 String[] address = resultSet.getString("address").split(",", 4);
		    	 String blockLot = address[0].trim();
	             String street = address[1].trim();
	             String barangay = address[2].trim();
	             String city = address[3].trim();
	             
	             clientId_Field.setText(String.valueOf(resultSet.getInt("clientID")));
			   	 firstName_Field.setText(resultSet.getString("firstName").trim());
				 lastName_Field.setText(resultSet.getString("lastName").trim());
				 blockLot_Field.setText(blockLot);
				 street_Field.setText(street);
				 barangay_Field.setText(barangay);
				 city_Field.setText(city);
				 contact_Field.setText(resultSet.getString("contactNumber"));
				 email_field.setText(resultSet.getString("emailAddress"));
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public editClientInformation() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new editClientInformation();
		});
	}
}