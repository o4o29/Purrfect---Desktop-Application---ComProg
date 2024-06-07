import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.sql.Time;

public class appointmentCreate extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField petID_Field;
	private static JTextField petName_Field;
	private static JTextField clientID_Field;

	private JTextField clientName_Field;
	
	private static int clientId;
	private static int petId;
	private static String petName;
	private static String clientName;
	
	private static JDateChooser dateChooser;
	private static JSpinner hourSpinner, minuteSpinner, secondSpinner;
	private static JComboBox<String> ampmComboBox;
	
	public static void getPetInformation(int petId) {
		appointmentCreate.petId = petId;
	
		SwingUtilities.invokeLater(() -> new appointmentCreate().populateFields());
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCompleteAppointment = new JLabel("COMPLETE APPOINTMENT ");
		lblCompleteAppointment.setForeground(Color.WHITE);
		lblCompleteAppointment.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCompleteAppointment.setBounds(148, 11, 606, 75);
		getContentPane().add(lblCompleteAppointment);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setForeground(new Color(255, 235, 205));
		panel.setBounds(23, 113, 342, 190);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setBounds(10, 63, 72, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetId.setBounds(10, 5, 59, 31);
		panel.add(lblPetId);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDate.setBounds(10, 118, 44, 31);
		panel.add(lblDate);
		
		JLabel lblPetId_1_1 = new JLabel("Time:");
		lblPetId_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetId_1_1.setBounds(10, 148, 44, 31);
		panel.add(lblPetId_1_1);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setBounds(106, 11, 169, 22);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(106, 41, 169, 22);
		panel.add(petName_Field);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(106, 69, 169, 22);
		panel.add(clientID_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetName.setBounds(10, 32, 72, 31);
		panel.add(lblPetName);
		
		clientName_Field = new JTextField();
		clientName_Field.setEditable(false);
		clientName_Field.setColumns(10);
		clientName_Field.setBounds(106, 97, 169, 22);
		panel.add(clientName_Field);
		
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblClientName.setBounds(10, 91, 93, 31);
		panel.add(lblClientName);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 124, 169, 22);
		panel.add(dateChooser);
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        dateChooser.setMinSelectableDate(calendar.getTime());
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setBackground(new Color(240, 240, 240));
		lblPetId_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblPetId_1_1_1.setBounds(10, 314, 330, 46);
		getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setEditable(false);
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 314, 884, 46);
		getContentPane().add(textArea_1_1);
		
		JPanel checkups_Panel = new JPanel();
		checkups_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CheckUps", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		checkups_Panel.setLayout(null);
		checkups_Panel.setForeground(new Color(255, 235, 205));
		checkups_Panel.setBackground(new Color(255, 239, 213));
		checkups_Panel.setBounds(23, 403, 322, 94);
		getContentPane().add(checkups_Panel);
		
		JCheckBox wellnessExam_Chk = new JCheckBox("Wellness Exams (Monitor)");
		wellnessExam_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		wellnessExam_Chk.setBackground(new Color(255, 239, 213));
		wellnessExam_Chk.setBounds(19, 22, 218, 23);
		checkups_Panel.add(wellnessExam_Chk);
		
		JCheckBox preventCare_Chk = new JCheckBox("Preventive Care \r\n(Advice and Treatment)\r\n");
		preventCare_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		preventCare_Chk.setBackground(new Color(255, 239, 213));
		preventCare_Chk.setBounds(19, 49, 295, 23);
		checkups_Panel.add(preventCare_Chk);
		
		JPanel diagnostic_Panel = new JPanel();
		diagnostic_Panel.setBorder(new TitledBorder(null, "Diagnostic", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		diagnostic_Panel.setLayout(null);
		diagnostic_Panel.setForeground(new Color(255, 235, 205));
		diagnostic_Panel.setBackground(new Color(255, 239, 213));
		diagnostic_Panel.setBounds(355, 389, 230, 120);
		getContentPane().add(diagnostic_Panel);
		
		JCheckBox labTesting_Chk = new JCheckBox("Laboratory Testing");
		labTesting_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		labTesting_Chk.setBackground(new Color(255, 239, 213));
		labTesting_Chk.setBounds(18, 22, 206, 23);
		diagnostic_Panel.add(labTesting_Chk);
		
		JCheckBox imagingServ_Chk = new JCheckBox("Imaging Services");
		imagingServ_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		imagingServ_Chk.setBackground(new Color(255, 239, 213));
		imagingServ_Chk.setBounds(18, 48, 206, 23);
		diagnostic_Panel.add(imagingServ_Chk);
		
		JCheckBox ecgEkg_Chk = new JCheckBox("ECG and EKG");
		ecgEkg_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		ecgEkg_Chk.setBackground(new Color(255, 239, 213));
		ecgEkg_Chk.setBounds(18, 74, 206, 23);
		diagnostic_Panel.add(ecgEkg_Chk);
		
		JPanel surgery_Panel = new JPanel();
		surgery_Panel.setLayout(null);
		surgery_Panel.setForeground(new Color(255, 235, 205));
		surgery_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Surgery", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		surgery_Panel.setBackground(new Color(255, 239, 213));
		surgery_Panel.setBounds(611, 389, 230, 120);
		getContentPane().add(surgery_Panel);
		
		JCheckBox spayNeut_Chk = new JCheckBox("Spaying and Neuturing");
		spayNeut_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		spayNeut_Chk.setBackground(new Color(255, 239, 213));
		spayNeut_Chk.setBounds(16, 22, 188, 23);
		surgery_Panel.add(spayNeut_Chk);
		
		JCheckBox tumorRemoval_Chk = new JCheckBox("Tumor Removal");
		tumorRemoval_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		tumorRemoval_Chk.setBackground(new Color(255, 239, 213));
		tumorRemoval_Chk.setBounds(16, 48, 188, 23);
		surgery_Panel.add(tumorRemoval_Chk);
		
		JCheckBox woundRepair_Chk = new JCheckBox("Wound Repair");
		woundRepair_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		woundRepair_Chk.setBounds(16, 76, 190, 23);
		surgery_Panel.add(woundRepair_Chk);
		woundRepair_Chk.setBackground(new Color(255, 239, 213));
		
		JLabel lblCompleteAppointment_1 = new JLabel("1\r\n");
		lblCompleteAppointment_1.setForeground(Color.WHITE);
		lblCompleteAppointment_1.setFont(new Font("Verdana", Font.BOLD, 34));
		lblCompleteAppointment_1.setBounds(23, 11, 44, 75);
		getContentPane().add(lblCompleteAppointment_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		getContentPane().add(textArea_1);
		
		JButton btnOtherSevices = new JButton("Other Sevices");

		btnOtherSevices.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnOtherSevices.setBounds(639, 521, 194, 29);
		getContentPane().add(btnOtherSevices);
		
        hourSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
        hourSpinner.setBounds(105, 153, 50, 20);
        panel.add(hourSpinner);
         
        JLabel lblHour = new JLabel("HH");
        lblHour.setBounds(115, 170, 20, 20);
        panel.add(lblHour);

        // Minute Spinner
        minuteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        minuteSpinner.setBounds(165, 153, 50, 20);
        panel.add(minuteSpinner);
        
        JLabel lblMinute = new JLabel("MM");
        lblMinute.setBounds(175, 170, 20, 20);
        panel.add(lblMinute);

        // Second Spinner
        secondSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 0, 1));
        secondSpinner.setBounds(225, 153, 50, 20);
        secondSpinner.setEnabled(false); // Disable the spinner
        panel.add(secondSpinner);

        
        JLabel lblSecond = new JLabel("SS");
        lblSecond.setBounds(235, 170, 20, 20);
        panel.add(lblSecond);
        
        String[] ampm = {"AM", "PM"};
        ampmComboBox = new JComboBox<>(ampm);
        ampmComboBox.setBounds(285, 153, 44, 20);
        panel.add(ampmComboBox);
        
		// LISTENERS
		btnOtherSevices.addActionListener(new ActionListener() { // other services of appointment
			
			
			public void actionPerformed(ActionEvent e) {
				if (dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Please select a date before proceeding.", "Date Not Selected", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
		        JsonArray servicesArray = new JsonArray();

		        if (wellnessExam_Chk.isSelected()) servicesArray.add(1);
		        if (preventCare_Chk.isSelected()) servicesArray.add(2);
		        if (labTesting_Chk.isSelected()) servicesArray.add(3);
		        if (imagingServ_Chk.isSelected()) servicesArray.add(4);
		        if (ecgEkg_Chk.isSelected()) servicesArray.add(5);
		        if (spayNeut_Chk.isSelected()) servicesArray.add(6);
		        if (tumorRemoval_Chk.isSelected()) servicesArray.add(7);
		        if (woundRepair_Chk.isSelected()) servicesArray.add(8);
		        
		        List<Integer> selectedServiceIds = new ArrayList<>();
		        for (JsonElement element : servicesArray) {
		            selectedServiceIds.add(element.getAsInt());
		        }
		        
		        dispose();
		        appointmentOtherServices.getAppointmentInformation(petId, petName, clientId, clientName, selectedServiceIds, getSelectedDate(), getSelectedTime());
		    }
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------

	public java.sql.Date getSelectedDate() {
		Date selectedDate = dateChooser.getDate();
		java.sql.Date mainDate = new java.sql.Date(selectedDate.getTime());
		
		return mainDate;
	}
	
	public Time getSelectedTime() {
	    int hour = (int) hourSpinner.getValue();
	    int minute = (int) minuteSpinner.getValue();
//	    int second = (int) secondSpinner.getValue();
	    String ampm = (String) ampmComboBox.getSelectedItem();
	    
	    // Convert hour to 24-hour format if PM is selected
	    if (ampm.equals("PM") && hour < 12) {
	        hour += 12;
	    }
	    
	    return Time.valueOf(String.format("%02d:%02d:00", hour, minute));
	}

	
	public void populateFields() {
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getPetById(petId);
		     
		     if (resultSet.next()) {
		    	 appointmentCreate.petId = resultSet.getInt("petID");
		    	 petID_Field.setText(String.valueOf(petId));
		    	 
		    	 appointmentCreate.petName = resultSet.getString("petName");
		    	 petName_Field.setText(petName);
		    	 
		    	 appointmentCreate.clientId = resultSet.getInt("clientID");
		    	 clientID_Field.setText(String.valueOf(clientId));
//		    	 
//		    	 date_Field.setText(date);		    	 
//		    	 time_Field.setText(time);
		    	 
		    	 ResultSet clientSet = dbManager.getClientById(clientId);
		    	 if(clientSet.next()) {
		    		 String firstName = clientSet.getString("firstName");;
		    		 String lastName = clientSet.getString("lastName");
		    		 
		    		 appointmentCreate.clientName = firstName + " " + lastName;
		    		 clientName_Field.setText(clientName);
		    	 }
	         }
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public appointmentCreate() {        
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new appointmentCreate();
		});
	}
}