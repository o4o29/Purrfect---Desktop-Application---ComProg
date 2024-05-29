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

public class editClientInformation extends JFrame{
	private static final long serialVersionUID = 1L;
	private static JTextField FName_Field;
	private static JTextField LName_Field;
	private static JTextField contact_Field;
	private static JTextField emailAdd_Field;
	private static JTextField clientID_Field;
	private static int clientId;
	private static JTextField address_Field;

	
	public static editClientInformation getClientIdEdit(int clientId) {
		new editClientInformation();
		
		editClientInformation.clientId = clientId;
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getClientById(clientId);
		     
		     if (resultSet.next()) {
	                clientID_Field.setText(String.valueOf(resultSet.getInt("clientID")));
					FName_Field.setText(resultSet.getString("firstName"));
					LName_Field.setText(resultSet.getString("lastName"));
					address_Field.setText(resultSet.getString("address"));
					contact_Field.setText(resultSet.getString("contactNumber"));
					emailAdd_Field.setText(resultSet.getString("emailAddress"));
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	        
		return null;
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setTitle("Edit Client Information");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255, 182, 193));
		headerPanel.setBounds(0, 0, 884, 150);
		getContentPane().add(headerPanel);
		
		JLabel lblClientInformation = new JLabel("CLIENT INFORMATION");
		lblClientInformation.setForeground(Color.WHITE);
		lblClientInformation.setFont(new Font("Verdana", Font.BOLD, 55));
		lblClientInformation.setBounds(85, 29, 717, 50);
		headerPanel.add(lblClientInformation);
		
		JLabel lblEdit = new JLabel("EDIT");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Verdana", Font.BOLD, 25));
		lblEdit.setBounds(373, 90, 69, 50);
		headerPanel.add(lblEdit);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(215, 184, 411, 328);
		getContentPane().add(mainPanel);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(31, 47, 76, 19);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(31, 80, 96, 14);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(31, 113, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Contact No.:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(31, 187, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Email Address:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(31, 213, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1_1);
		
		FName_Field = new JTextField();
		FName_Field.setColumns(10);
		FName_Field.setBounds(133, 48, 248, 20);
		mainPanel.add(FName_Field);
		
		LName_Field = new JTextField();
		LName_Field.setColumns(10);
		LName_Field.setBounds(133, 79, 248, 20);
		mainPanel.add(LName_Field);
		
		contact_Field = new JTextField();
		contact_Field.setColumns(10);
		contact_Field.setBounds(133, 186, 248, 20);
		mainPanel.add(contact_Field);
		
		emailAdd_Field = new JTextField();
		emailAdd_Field.setColumns(10);
		emailAdd_Field.setBounds(133, 212, 248, 20);
		mainPanel.add(emailAdd_Field);
		
		JButton submitChanges_Btn = new JButton("SUBMIT CHANGES");
		submitChanges_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		submitChanges_Btn.setBackground(new Color(255, 240, 245));
		submitChanges_Btn.setBounds(133, 273, 150, 25);
		mainPanel.add(submitChanges_Btn);
		
		JLabel lblNewLabel_2_2 = new JLabel("CLIENT ID:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(31, 11, 96, 19);
		mainPanel.add(lblNewLabel_2_2);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(133, 12, 248, 20);
		mainPanel.add(clientID_Field);
		
		address_Field = new JTextField();
		address_Field.setColumns(10);
		address_Field.setBounds(133, 110, 248, 66);
		mainPanel.add(address_Field);
		
		
		submitChanges_Btn.addActionListener(new ActionListener() { // submit button
		    public void actionPerformed(ActionEvent e) {
		        String firstName = FName_Field.getText();
		        String lastName = LName_Field.getText();
		        String address = address_Field.getText();
		        String contact = contact_Field.getText();
		        String email = emailAdd_Field.getText();

		        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty()) {
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
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
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