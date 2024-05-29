import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class appointmentSuccessful extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField appointmentID_Field;
	private static JTextArea services_Field;
	private static JTextField clientID_Field;
	private static JTextField petID_Field;
	private static JTextField time_Field;
	private static JTextField totalPayment_Field;
	private static JTextField date_Field;
	@SuppressWarnings("unused")
	private static int appointId;
	private static JTextField petName_Field;
	
	public static appointmentSuccessful getAppointmentInformation(int appointId) {
		appointmentSuccessful.appointId = appointId;
		
		new appointmentSuccessful();		
		
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getAppointmentById(appointId);
		     
		     if (resultSet.next()) {
		    	 appointmentID_Field.setText(String.valueOf(resultSet.getInt("appointmentID")));
		    	 clientID_Field.setText(String.valueOf(resultSet.getInt("clientID")));
		    	 petID_Field.setText(resultSet.getString("petID"));
		    	 petName_Field.setText(resultSet.getString("petName"));
				
		    	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    	 date_Field.setText(dateFormat.format(resultSet.getDate("date")));
				
		    	 SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		    	 time_Field.setText(timeFormat.format(resultSet.getTime("time")));
		    	 totalPayment_Field.setText("₱" + String.valueOf(resultSet.getDouble("payment")));
		    	 
		    	 String serviceIdsStr = resultSet.getString("services");
		    	 String[] serviceIds = serviceIdsStr.substring(1, serviceIdsStr.length() - 1).split(", ");
				
		    	 StringBuilder serviceNames = new StringBuilder();
		    	 for (String serviceId : serviceIds) {
		    		 String serviceName = dbManager.getServiceNameById(Integer.parseInt(serviceId.trim()));
		    		 serviceNames.append(serviceName).append(", ");
				 }
		    	 
		    	 services_Field.setText(serviceNames.toString());
	         } 
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	        
		return null;
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblAppointmentSuccessful = new JLabel("APPOINTMENT SUCCESSFUL");
		lblAppointmentSuccessful.setForeground(Color.WHITE);
		lblAppointmentSuccessful.setFont(new Font("Verdana", Font.BOLD, 40));
		lblAppointmentSuccessful.setBounds(135, 11, 667, 75);
		getContentPane().add(lblAppointmentSuccessful);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		getContentPane().add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(49, 131, 810, 399);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(25, 13, 175, 26);
		panel.add(lblNewLabel);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblClientId.setBounds(88, 58, 106, 26);
		panel.add(lblClientId);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPetId.setBounds(110, 99, 65, 34);
		panel.add(lblPetId);
		
		JLabel lblServices = new JLabel("Services:");
		lblServices.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblServices.setBounds(86, 167, 89, 26);
		panel.add(lblServices);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDate.setBounds(121, 223, 62, 26);
		panel.add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTime.setBounds(121, 265, 62, 32);
		panel.add(lblTime);
		
		JLabel lblTotalPayment = new JLabel("Total Payment:");
		lblTotalPayment.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTotalPayment.setBounds(37, 313, 164, 26);
		panel.add(lblTotalPayment);
		
		appointmentID_Field = new JTextField();
		appointmentID_Field.setEditable(false);
		appointmentID_Field.setBounds(210, 15, 268, 30);
		panel.add(appointmentID_Field);
		appointmentID_Field.setColumns(10);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(210, 60, 268, 30);
		panel.add(clientID_Field);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setColumns(10);
		petID_Field.setBounds(210, 105, 268, 30);
		panel.add(petID_Field);
		
		time_Field = new JTextField();
		time_Field.setEditable(false);
		time_Field.setColumns(10);
		time_Field.setBounds(210, 270, 268, 30);
		panel.add(time_Field);
		
		totalPayment_Field = new JTextField();
		totalPayment_Field.setEditable(false);
		totalPayment_Field.setColumns(10);
		totalPayment_Field.setBounds(211, 315, 267, 30);
		panel.add(totalPayment_Field);
		
		date_Field = new JTextField();
		date_Field.setEditable(false);
		date_Field.setColumns(10);
		date_Field.setBounds(210, 225, 268, 30);
		panel.add(date_Field);
		
		JButton print_Btn = new JButton("PRINT");
		print_Btn.setFont(new Font("Verdana", Font.PLAIN, 16));
		print_Btn.setBounds(375, 362, 121, 26);
		panel.add(print_Btn);
		
		services_Field = new JTextArea();
		services_Field.setLineWrap(true);
		services_Field.setEditable(false);
		services_Field.setBounds(210, 155, 268, 59);
		panel.add(services_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPetName.setBounds(515, 13, 106, 34);
		panel.add(lblPetName);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(515, 47, 268, 30);
		panel.add(petName_Field);
		
		
		// LISTENERS
		print_Btn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Concatenate all appointment information into a single string
		        StringBuilder appointmentInfo = new StringBuilder();
		        appointmentInfo.append("Appointment ID: ").append(appointmentID_Field.getText()).append("\n");
		        appointmentInfo.append("Client ID: ").append(clientID_Field.getText()).append("\n");
		        appointmentInfo.append("Pet ID: ").append(petID_Field.getText()).append("\n");
		        appointmentInfo.append("Pet Name: ").append(petName_Field.getText()).append("\n");
		        appointmentInfo.append("Services: ").append(services_Field.getText()).append("\n");
		        appointmentInfo.append("Date: ").append(date_Field.getText()).append("\n");
		        appointmentInfo.append("Time: ").append(time_Field.getText()).append("\n");
		        appointmentInfo.append("Total Payment: ").append(totalPayment_Field.getText()).append("\n");

		        // Show a message dialog with all the appointment information
		        JOptionPane.showMessageDialog(appointmentSuccessful.this, appointmentInfo.toString(), "Appointment Details", JOptionPane.INFORMATION_MESSAGE);
		        dispose();
		    }
		});

	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	public appointmentSuccessful() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new appointmentSuccessful();
		});
	}
}