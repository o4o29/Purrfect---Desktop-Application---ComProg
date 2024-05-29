import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class resultClientInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField clientID_Field;
	private static JTextField firstName_Field;
	private static JTextField lastName_Field;
	private static JTextField address_Field;
	private static JTextField contact_Field;
	private static JTextField emailAddress_Field;
	private static JTextField petID_Field;
	private static JTextField petName_Field;
	private static JTextField species_Field;
	private static JTextField weight_Field;
	private static JTextField age_Field;
	private static JTextField breed_Field;
	private static JTextField gender_Field;
	private static JTextField colorMarkings_Field;
	private static int clientId;
	private static int petId;
	private JTable table;
	private static JScrollBar scrollBar;
	
	
	public static resultClientInformation getClientID(int clientId) {
		resultClientInformation.clientId = clientId;
		
		new resultClientInformation();		
		
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getClientById(clientId);
		     
		     if (resultSet.next()) {
	                clientID_Field.setText(String.valueOf(resultSet.getInt("clientID")));
					firstName_Field.setText(resultSet.getString("firstName"));
					lastName_Field.setText(resultSet.getString("lastName"));
					address_Field.setText(resultSet.getString("address"));
					contact_Field.setText(resultSet.getString("contactNumber"));
					emailAddress_Field.setText(resultSet.getString("emailAddress"));
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	        
		return null;
	}
	
	public static void updateClientInformation(int clientID) {
	    try {	
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        
	        ResultSet clientResult = dbManager.getClientById(clientID);
	        if (clientResult.next()) {
	        	clientID_Field.setText(String.valueOf(clientResult.getInt("clientID")));
				firstName_Field.setText(clientResult.getString("firstName"));
				lastName_Field.setText(clientResult.getString("lastName"));
				address_Field.setText(clientResult.getString("address"));
				contact_Field.setText(clientResult.getString("contactNumber"));
				emailAddress_Field.setText(clientResult.getString("emailAddress"));
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static void showPetInformation(int petID) {
	    try {	
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        
	        ResultSet petResult = dbManager.getPetById(petID);
	        if (petResult.next()) {
	            petID_Field.setText(String.valueOf(petResult.getInt("petID")));
	            petName_Field.setText(petResult.getString("petName"));
	            species_Field.setText(petResult.getString("petSpecies"));
	            breed_Field.setText(petResult.getString("petBreed"));
	            weight_Field.setText(petResult.getString("petWeight"));
	            age_Field.setText(petResult.getString("petAge"));
	            gender_Field.setText(petResult.getString("petGender"));
	            colorMarkings_Field.setText(petResult.getString("petColor"));
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static void scrollBarPetInfo(int clientID, int petIndex) {
	    try {
	        ResultSet resultSet = DatabaseManager.getInstance().getPetByClientAndIndex(clientID, petIndex);

	        if (resultSet.next()) {
	        	petId = resultSet.getInt("petID");
	        	
	            petID_Field.setText(String.valueOf(resultSet.getInt("petID")));
	            petName_Field.setText(resultSet.getString("petName"));
	            species_Field.setText(resultSet.getString("petSpecies"));
	            breed_Field.setText(resultSet.getString("petBreed"));
	            weight_Field.setText(resultSet.getString("petWeight"));
	            age_Field.setText(resultSet.getString("petAge"));
	            gender_Field.setText(resultSet.getString("petGender"));
	            colorMarkings_Field.setText(resultSet.getString("petColor"));
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setBackground(new Color(255, 228, 225));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().setLayout(null);
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblClientInformation = new JLabel("CLIENT INFORMATION");
		lblClientInformation.setForeground(Color.WHITE);
		lblClientInformation.setFont(new Font("Verdana", Font.BOLD, 60));
		lblClientInformation.setBounds(56, 28, 779, 75);
		getContentPane().add(lblClientInformation);
		
		JPanel clientPanel = new JPanel();
		clientPanel.setBackground(new Color(255, 182, 193));
		clientPanel.setBounds(56, 198, 358, 303);
		getContentPane().add(clientPanel);
		clientPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 12, 86, 14);
		clientPanel.add(lblNewLabel);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setBounds(128, 11, 207, 20);
		clientPanel.add(clientID_Field);
		clientID_Field.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName.setBounds(10, 40, 111, 14);
		clientPanel.add(lblFirstName);
		
		JLabel lblFirstName_1 = new JLabel("Last Name:");
		lblFirstName_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1.setBounds(10, 65, 111, 14);
		clientPanel.add(lblFirstName_1);
		
		firstName_Field = new JTextField();
		firstName_Field.setEditable(false);
		firstName_Field.setColumns(10);
		firstName_Field.setBounds(128, 39, 207, 20);
		clientPanel.add(firstName_Field);
		
		lastName_Field = new JTextField();
		lastName_Field.setEditable(false);
		lastName_Field.setColumns(10);
		lastName_Field.setBounds(128, 65, 207, 20);
		clientPanel.add(lastName_Field);
		
		JLabel lblFirstName_1_1 = new JLabel("Address:");
		lblFirstName_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1.setBounds(10, 90, 111, 14);
		clientPanel.add(lblFirstName_1_1);
		
		address_Field = new JTextField();
		address_Field.setEditable(false);
		address_Field.setColumns(10);
		address_Field.setBounds(128, 90, 207, 54);
		clientPanel.add(address_Field);
		
		JLabel lblFirstName_1_1_1 = new JLabel("Contact No.:");
		lblFirstName_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1.setBounds(10, 155, 111, 14);
		clientPanel.add(lblFirstName_1_1_1);
		
		contact_Field = new JTextField();
		contact_Field.setEditable(false);
		contact_Field.setColumns(10);
		contact_Field.setBounds(128, 155, 207, 20);
		clientPanel.add(contact_Field);
		
		JLabel lblFirstName_1_1_1_1 = new JLabel("Email Address:");
		lblFirstName_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1.setBounds(10, 182, 111, 14);
		clientPanel.add(lblFirstName_1_1_1_1);
		
		emailAddress_Field = new JTextField();
		emailAddress_Field.setEditable(false);
		emailAddress_Field.setColumns(10);
		emailAddress_Field.setBounds(128, 181, 207, 20);
		clientPanel.add(emailAddress_Field);
		
		JButton btnEditClient = new JButton("Edit");
		btnEditClient.setBounds(128, 234, 89, 23);
		clientPanel.add(btnEditClient);
		btnEditClient.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		JButton btnAddPet = new JButton("ADD PET");
		btnAddPet.setBounds(128, 268, 89, 23);
		clientPanel.add(btnAddPet);
		btnAddPet.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		
		table = new JTable();
		table.setBounds(76, 303, 0, 0);
		getContentPane().add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(0, 0, 884, 153);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClientInformation_1 = new JLabel("(Result)");
		lblClientInformation_1.setBounds(360, 78, 140, 75);
		panel_1.add(lblClientInformation_1);
		lblClientInformation_1.setForeground(Color.WHITE);
		lblClientInformation_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 28));
		
		JPanel petPanel = new JPanel();
		petPanel.setLayout(null);
		petPanel.setBackground(new Color(255, 182, 193));
		petPanel.setBounds(455, 198, 358, 303);
		getContentPane().add(petPanel);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetId.setBounds(10, 12, 86, 14);
		petPanel.add(lblPetId);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setColumns(10);
		petID_Field.setBounds(128, 11, 207, 20);
		petPanel.add(petID_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetName.setBounds(10, 40, 111, 14);
		petPanel.add(lblPetName);
		
		JLabel lblFirstName_1_2 = new JLabel("Species: ");
		lblFirstName_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_2.setBounds(10, 65, 111, 14);
		petPanel.add(lblFirstName_1_2);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(128, 39, 207, 20);
		petPanel.add(petName_Field);
		
		species_Field = new JTextField();
		species_Field.setEditable(false);
		species_Field.setColumns(10);
		species_Field.setBounds(128, 65, 207, 20);
		petPanel.add(species_Field);
		
		JLabel lblFirstName_1_1_2 = new JLabel("Breed:");
		lblFirstName_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_2.setBounds(10, 90, 111, 14);
		petPanel.add(lblFirstName_1_1_2);
		
		JLabel lblFirstName_1_1_1_2 = new JLabel("Weight:");
		lblFirstName_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_2.setBounds(10, 115, 111, 19);
		petPanel.add(lblFirstName_1_1_1_2);
		
		weight_Field = new JTextField();
		weight_Field.setEditable(false);
		weight_Field.setColumns(10);
		weight_Field.setBounds(128, 114, 207, 20);
		petPanel.add(weight_Field);
		
		JLabel lblFirstName_1_1_1_1_1 = new JLabel("Age:");
		lblFirstName_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1_1.setBounds(10, 139, 111, 19);
		petPanel.add(lblFirstName_1_1_1_1_1);
		
		age_Field = new JTextField();
		age_Field.setEditable(false);
		age_Field.setColumns(10);
		age_Field.setBounds(128, 138, 207, 20);
		petPanel.add(age_Field);
		
		JButton btnEditPet = new JButton("Edit");
		btnEditPet.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEditPet.setBounds(147, 241, 89, 23);
		petPanel.add(btnEditPet);
		
		breed_Field = new JTextField();
		breed_Field.setEditable(false);
		breed_Field.setColumns(10);
		breed_Field.setBounds(128, 89, 207, 20);
		petPanel.add(breed_Field);
		
		JLabel lblFirstName_1_1_1_1_1_1 = new JLabel("Gender:");
		lblFirstName_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1_1_1.setBounds(10, 165, 111, 19);
		petPanel.add(lblFirstName_1_1_1_1_1_1);
		
		gender_Field = new JTextField();
		gender_Field.setEditable(false);
		gender_Field.setColumns(10);
		gender_Field.setBounds(128, 166, 207, 20);
		petPanel.add(gender_Field);
		
		JLabel lblFirstName_1_1_1_1_1_1_1 = new JLabel("Color Markings:");
		lblFirstName_1_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFirstName_1_1_1_1_1_1_1.setBounds(10, 188, 130, 19);
		petPanel.add(lblFirstName_1_1_1_1_1_1_1);
		
		colorMarkings_Field = new JTextField();
		colorMarkings_Field.setEditable(false);
		colorMarkings_Field.setColumns(10);
		colorMarkings_Field.setBounds(128, 189, 207, 20);
		petPanel.add(colorMarkings_Field);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(170, 269, 50, 23);
		petPanel.add(scrollBar);
		
		
		// BUTTON LISTENERS
		btnAddPet.addActionListener(e -> { // add a pet
			createPetInformation.getOwnerId(clientID_Field.getText());
		});
		
		btnEditClient.addActionListener(e -> { // edit client
			editClientInformation.getClientIdEdit(clientId);
		});
		
		btnEditPet.addActionListener(e -> { // edit pet
			editPetInformation.getPetIdEdit(petId, clientId, "clientPanel");
		});
		
	
		scrollBar.addAdjustmentListener(new AdjustmentListener() { // scrollBar button; up and down
		    public void adjustmentValueChanged(AdjustmentEvent e) {
		        int value = e.getValue();
		        int petIndex = value + 1;

		        scrollBarPetInfo(clientId, petIndex);
		    }
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	public static void updateScrollMax() {
	    int petCount = getPetCount(clientId);

	    scrollBar.setMaximum(petCount);
	    scrollBar.setVisibleAmount(1);
	    scrollBar.setValue(scrollBar.getMaximum() - scrollBar.getVisibleAmount());
	}

	private static int getPetCount(int clientId) {
	    try {
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        
	        return dbManager.getPetCountByClientId(clientId);
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return 0;
	    }
	}
	
	public resultClientInformation() {
		initialize();
		updateScrollMax();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new resultClientInformation();
		});
	}	
}