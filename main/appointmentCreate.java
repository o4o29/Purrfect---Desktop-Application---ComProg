import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class appointmentCreate extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JTextField petID_Field;
	private static JTextField petName_Field;
	private static JTextField clientID_Field;
	private static JTextField date_Field;
	private static JTextField time_Field;
	private static int clientId;
	private static int petId;
	private static String petName;
	private static String date;
	private static String time;
	
	
	public static appointmentCreate getPetInformation(int petId) {
		appointmentCreate.petId = petId;
		new appointmentCreate();		
		
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getPetById(petId);
		     
		     if (resultSet.next()) {
		    	 petID_Field.setText(String.valueOf(resultSet.getInt("petID")));
		    	 appointmentCreate.petId = resultSet.getInt("petID");
		    	 
		    	 petName_Field.setText(resultSet.getString("petName"));
		    	 appointmentCreate.petName = resultSet.getString("petName");
		    	 
		    	 clientID_Field.setText(String.valueOf(resultSet.getInt("clientID")));
		    	 appointmentCreate.clientId = resultSet.getInt("clientID");
		    	 
		    	 date_Field.setText(date);		    	 
		    	 time_Field.setText(time);
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	        
		return null;
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
		panel.setBounds(23, 113, 297, 163);
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
		lblDate.setBounds(10, 91, 44, 31);
		panel.add(lblDate);
		
		JLabel lblPetId_1_1 = new JLabel("Time:");
		lblPetId_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetId_1_1.setBounds(10, 124, 44, 31);
		panel.add(lblPetId_1_1);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setBounds(85, 11, 186, 22);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(85, 41, 186, 22);
		panel.add(petName_Field);
		
		clientID_Field = new JTextField();
		clientID_Field.setEditable(false);
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(85, 69, 186, 22);
		panel.add(clientID_Field);
		
		date_Field = new JTextField();
		date_Field.setEditable(false);
		date_Field.setColumns(10);
		date_Field.setBounds(85, 97, 186, 22);
		panel.add(date_Field);
		
		time_Field = new JTextField();
		time_Field.setEditable(false);
		time_Field.setColumns(10);
		time_Field.setBounds(85, 130, 186, 22);
		panel.add(time_Field);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetName.setBounds(10, 32, 72, 31);
		panel.add(lblPetName);
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setBackground(new Color(240, 240, 240));
		lblPetId_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblPetId_1_1_1.setBounds(10, 298, 330, 46);
		getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setEditable(false);
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 298, 884, 46);
		getContentPane().add(textArea_1_1);
		
		JPanel checkups_Panel = new JPanel();
		checkups_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CheckUps", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		checkups_Panel.setLayout(null);
		checkups_Panel.setForeground(new Color(255, 235, 205));
		checkups_Panel.setBackground(new Color(255, 239, 213));
		checkups_Panel.setBounds(23, 387, 322, 94);
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
		diagnostic_Panel.setBounds(355, 373, 230, 120);
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
		surgery_Panel.setBounds(611, 373, 230, 120);
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
		btnOtherSevices.setBounds(639, 510, 202, 40);
		getContentPane().add(btnOtherSevices);
		
		
		// LISTENERS
		btnOtherSevices.addActionListener(new ActionListener() { // other services of appointment
			public void actionPerformed(ActionEvent e) {
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
		        appointmentOtherServices.getAppointmentInformation(petId, petName, clientId, date, time, selectedServiceIds);
		    }
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------

	
	public appointmentCreate() {
		date = new SimpleDateFormat("MMMM dd, yyyy").format(Calendar.getInstance().getTime());
	    time = new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime());
	        
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new appointmentCreate();
		});
	}
}