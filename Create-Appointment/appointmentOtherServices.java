import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class appointmentOtherServices {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointmentOtherServices window = new appointmentOtherServices();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public appointmentOtherServices() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompleteAppointment_1 = new JLabel("2");
		lblCompleteAppointment_1.setForeground(Color.WHITE);
		lblCompleteAppointment_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCompleteAppointment_1.setBounds(10, -12, 17, 75);
		frame.getContentPane().add(lblCompleteAppointment_1);
		
		JLabel lblCompleteAppointment = new JLabel("COMPLETE APPOINTMENT ");
		lblCompleteAppointment.setForeground(Color.WHITE);
		lblCompleteAppointment.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCompleteAppointment.setBounds(160, -12, 386, 75);
		frame.getContentPane().add(lblCompleteAppointment);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 56);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPetId_1_1_1.setBackground(UIManager.getColor("Button.background"));
		lblPetId_1_1_1.setBounds(10, 58, 199, 40);
		frame.getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 67, 697, 28);
		frame.getContentPane().add(textArea_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(255, 235, 205));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dental Care", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(10, 106, 199, 115);
		frame.getContentPane().add(panel_1);
		
		JCheckBox chckbxTeethCleaning = new JCheckBox("Teeth Cleaning");
		chckbxTeethCleaning.setBackground(new Color(255, 239, 213));
		chckbxTeethCleaning.setBounds(6, 23, 162, 23);
		panel_1.add(chckbxTeethCleaning);
		
		JCheckBox chckbxTeethRemoval = new JCheckBox("Teeth Removal");
		chckbxTeethRemoval.setBackground(new Color(255, 239, 213));
		chckbxTeethRemoval.setBounds(6, 49, 187, 23);
		panel_1.add(chckbxTeethRemoval);
		
		JCheckBox chckbxOralHealthExam = new JCheckBox("Oral Health Exam");
		chckbxOralHealthExam.setBackground(new Color(255, 239, 213));
		chckbxOralHealthExam.setBounds(6, 75, 187, 23);
		panel_1.add(chckbxOralHealthExam);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Internal Medicine", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1.setBounds(227, 106, 199, 115);
		frame.getContentPane().add(panel_1_1);
		
		JCheckBox chckbxMedicationManagement = new JCheckBox("Medication Management");
		chckbxMedicationManagement.setBackground(new Color(255, 239, 213));
		chckbxMedicationManagement.setBounds(6, 23, 162, 23);
		panel_1_1.add(chckbxMedicationManagement);
		
		JCheckBox chckbxGastrointestinalDisorders = new JCheckBox("Gastrointestinal Disorders");
		chckbxGastrointestinalDisorders.setBackground(new Color(255, 239, 213));
		chckbxGastrointestinalDisorders.setBounds(6, 49, 187, 23);
		panel_1_1.add(chckbxGastrointestinalDisorders);
		
		JCheckBox chckbxEndocrineDisorder = new JCheckBox("Endocrine Disorder");
		chckbxEndocrineDisorder.setBackground(new Color(255, 239, 213));
		chckbxEndocrineDisorder.setBounds(6, 73, 187, 23);
		panel_1_1.add(chckbxEndocrineDisorder);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dermatology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1.setBounds(444, 106, 199, 115);
		frame.getContentPane().add(panel_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Skin Treatments");
		chckbxNewCheckBox_1_1.setBackground(new Color(255, 239, 213));
		chckbxNewCheckBox_1_1.setBounds(6, 23, 162, 23);
		panel_1_1_1.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxPreventiveCareadvice_1_1 = new JCheckBox("Allergy Testing/ Treatments");
		chckbxPreventiveCareadvice_1_1.setBackground(new Color(255, 239, 213));
		chckbxPreventiveCareadvice_1_1.setBounds(6, 49, 187, 23);
		panel_1_1_1.add(chckbxPreventiveCareadvice_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dermatology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1_1.setBounds(132, 231, 199, 115);
		frame.getContentPane().add(panel_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1_1_1 = new JCheckBox("Reproductive Services");
		chckbxNewCheckBox_1_1_1.setBackground(new Color(255, 239, 213));
		chckbxNewCheckBox_1_1_1.setBounds(6, 23, 162, 23);
		panel_1_1_1_1.add(chckbxNewCheckBox_1_1_1);
		
		JCheckBox chckbxPreventiveCareadvice_1_1_1 = new JCheckBox("Breeding Services");
		chckbxPreventiveCareadvice_1_1_1.setBackground(new Color(255, 239, 213));
		chckbxPreventiveCareadvice_1_1_1.setBounds(6, 49, 187, 23);
		panel_1_1_1_1.add(chckbxPreventiveCareadvice_1_1_1);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Oncology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1_1_1.setBounds(341, 232, 199, 115);
		frame.getContentPane().add(panel_1_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1_1_1_1 = new JCheckBox("Cancer Treatment/ Chemotheraphy");
		chckbxNewCheckBox_1_1_1_1.setBackground(new Color(255, 239, 213));
		chckbxNewCheckBox_1_1_1_1.setBounds(6, 23, 162, 23);
		panel_1_1_1_1_1.add(chckbxNewCheckBox_1_1_1_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 363, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSaveAppointment = new JButton("SAVE APPOINTMENT");
		btnSaveAppointment.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSaveAppointment.setBounds(520, 365, 167, 23);
		frame.getContentPane().add(btnSaveAppointment);
		frame.setBounds(100, 100, 713, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
