import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class appointmentOtherServices extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int petId;
	private static int clientId;
	private static String petName;
	private static Date date;
	private static Time time;
	private static List<Integer> selectedServiceIds;
	
	public static void getAppointmentInformation(int petId, String petName, int clientId, String date, String time, List<Integer> selectedServiceIds) {
		new appointmentOtherServices();
		
		appointmentOtherServices.petId = petId;
		appointmentOtherServices.clientId = clientId;
		appointmentOtherServices.petName = petName;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yy");
	    try {
	        appointmentOtherServices.date = new Date(dateFormat.parse(date).getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    // Parse the time string into the desired format
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	    try {
	        appointmentOtherServices.time = new Time(timeFormat.parse(time).getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		appointmentOtherServices.selectedServiceIds = selectedServiceIds;
	}
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCompleteAppointment_1 = new JLabel("2");
		lblCompleteAppointment_1.setForeground(Color.WHITE);
		lblCompleteAppointment_1.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCompleteAppointment_1.setBounds(10, 11, 36, 75);
		getContentPane().add(lblCompleteAppointment_1);
		
		JLabel lblCompleteAppointment = new JLabel("COMPLETE APPOINTMENT ");
		lblCompleteAppointment.setForeground(Color.WHITE);
		lblCompleteAppointment.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCompleteAppointment.setBounds(148, 11, 606, 75);
		getContentPane().add(lblCompleteAppointment);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		getContentPane().add(textArea_1);
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setBackground(new Color(240, 240, 240));
		lblPetId_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblPetId_1_1_1.setBounds(10, 114, 330, 46);
		getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setEditable(false);
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 114, 884, 46);
		getContentPane().add(textArea_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(255, 235, 205));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dental Care", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(57, 208, 210, 130);
		getContentPane().add(panel_1);
		
		JCheckBox teethClean_Chk = new JCheckBox("Teeth Cleaning");
		teethClean_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		teethClean_Chk.setBackground(new Color(255, 239, 213));
		teethClean_Chk.setBounds(6, 23, 162, 23);
		panel_1.add(teethClean_Chk);
		
		JCheckBox teethRemove_Chk = new JCheckBox("Teeth Removal");
		teethRemove_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		teethRemove_Chk.setBackground(new Color(255, 239, 213));
		teethRemove_Chk.setBounds(6, 49, 187, 23);
		panel_1.add(teethRemove_Chk);
		
		JCheckBox oralExam_Chk = new JCheckBox("Oral Health Exam");
		oralExam_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		oralExam_Chk.setBackground(new Color(255, 239, 213));
		oralExam_Chk.setBounds(6, 75, 187, 23);
		panel_1.add(oralExam_Chk);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Internal Medicine", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1.setBounds(326, 208, 210, 130);
		getContentPane().add(panel_1_1);
		
		JCheckBox medManage_Chk = new JCheckBox("Medication Management");
		medManage_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		medManage_Chk.setBackground(new Color(255, 239, 213));
		medManage_Chk.setBounds(6, 23, 198, 23);
		panel_1_1.add(medManage_Chk);
		
		JCheckBox gastroDisorder_Chk = new JCheckBox("Gastrointestinal Disorders");
		gastroDisorder_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		gastroDisorder_Chk.setBackground(new Color(255, 239, 213));
		gastroDisorder_Chk.setBounds(6, 49, 198, 23);
		panel_1_1.add(gastroDisorder_Chk);
		
		JCheckBox endocrineDisorder_Chk = new JCheckBox("Endocrine Disorder");
		endocrineDisorder_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		endocrineDisorder_Chk.setBackground(new Color(255, 239, 213));
		endocrineDisorder_Chk.setBounds(6, 73, 187, 23);
		panel_1_1.add(endocrineDisorder_Chk);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dermatology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1.setBounds(595, 208, 227, 130);
		getContentPane().add(panel_1_1_1);
		
		JCheckBox skinTreat_Chk = new JCheckBox("Skin Treatments");
		skinTreat_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		skinTreat_Chk.setBackground(new Color(255, 239, 213));
		skinTreat_Chk.setBounds(6, 23, 162, 23);
		panel_1_1_1.add(skinTreat_Chk);
		
		JCheckBox allergyTreat_Chk = new JCheckBox("Allergy Testing/ Treatments");
		allergyTreat_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		allergyTreat_Chk.setBackground(new Color(255, 239, 213));
		allergyTreat_Chk.setBounds(6, 49, 215, 23);
		panel_1_1_1.add(allergyTreat_Chk);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dermatology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1_1.setBounds(68, 378, 210, 130);
		getContentPane().add(panel_1_1_1_1);
		
		JCheckBox reproSer_Chk = new JCheckBox("Reproductive Services");
		reproSer_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		reproSer_Chk.setBackground(new Color(255, 239, 213));
		reproSer_Chk.setBounds(6, 38, 187, 23);
		panel_1_1_1_1.add(reproSer_Chk);
		
		JCheckBox breedSer_Chk = new JCheckBox("Breeding Services");
		breedSer_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		breedSer_Chk.setBackground(new Color(255, 239, 213));
		breedSer_Chk.setBounds(6, 66, 187, 23);
		panel_1_1_1_1.add(breedSer_Chk);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Oncology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1_1_1.setBounds(326, 389, 279, 94);
		getContentPane().add(panel_1_1_1_1_1);
		
		JCheckBox cancerTreat_Chk = new JCheckBox("Cancer Treatment/ Chemotheraphy");
		cancerTreat_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		cancerTreat_Chk.setBackground(new Color(255, 239, 213));
		cancerTreat_Chk.setBounds(6, 34, 267, 23);
		panel_1_1_1_1_1.add(cancerTreat_Chk);
		
		JButton saveAppointment_Btn = new JButton("SAVE APPOINTMENT");
		saveAppointment_Btn.setFont(new Font("Verdana", Font.PLAIN, 16));
		saveAppointment_Btn.setBounds(647, 422, 202, 40);
		getContentPane().add(saveAppointment_Btn);
		
		
		// LISTENERS
		saveAppointment_Btn.addActionListener(e -> { // SAVE THE APPOINTMENT
			if (teethClean_Chk.isSelected()) selectedServiceIds.add(9);
	        if (teethRemove_Chk.isSelected()) selectedServiceIds.add(10);
	        if (oralExam_Chk.isSelected()) selectedServiceIds.add(11);
	        if (medManage_Chk.isSelected()) selectedServiceIds.add(12);
	        if (gastroDisorder_Chk.isSelected()) selectedServiceIds.add(13);
	        if (endocrineDisorder_Chk.isSelected()) selectedServiceIds.add(14);
	        if (skinTreat_Chk.isSelected()) selectedServiceIds.add(15);
	        if (allergyTreat_Chk.isSelected()) selectedServiceIds.add(16);
	        if (reproSer_Chk.isSelected()) selectedServiceIds.add(17);
	        if (breedSer_Chk.isSelected()) selectedServiceIds.add(18);
	        if (cancerTreat_Chk.isSelected()) selectedServiceIds.add(19);
	        
	        try {
	        	double totalPrice = calculateTotalPrice(selectedServiceIds);
		        String selectedServiceIds = appointmentOtherServices.selectedServiceIds.toString();
	            DatabaseManager dbManager = DatabaseManager.getInstance();
	            int appointID = dbManager.insertAppointment(clientId, petId, selectedServiceIds, date, time, totalPrice, petName);
	            
	            if (appointID != -1) {
	            	appointmentSuccessful.getAppointmentInformation(appointID);
	                dispose();
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to retrieve appointment ID.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException ex) {
	            if (ex instanceof MysqlDataTruncation) {
	                MysqlDataTruncation truncationEx = (MysqlDataTruncation) ex;
                    JOptionPane.showMessageDialog(null, truncationEx.getErrorCode() + "; Truncation error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
	            } else {
	                JOptionPane.showMessageDialog(null, "Error occurred while creating appointment: " + ex.getMessage());
	            }
	        }
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	private double calculateTotalPrice(List<Integer> selectedServiceIds) {
	    double totalPrice = 0.0;

	    try {
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        for (int serviceId : selectedServiceIds) {
	            double servicePrice = dbManager.getServicePriceById(serviceId);
	            totalPrice += servicePrice;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalPrice;
	}
	
	public appointmentOtherServices() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new appointmentOtherServices();
		});
	}
}