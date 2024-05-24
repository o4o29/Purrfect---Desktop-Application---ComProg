import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class appointmentSuccessful {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointmentSuccessful window = new appointmentSuccessful();
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
	public appointmentSuccessful() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 713, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompleteAppointment = new JLabel("COMPLETE APPOINTMENT ");
		lblCompleteAppointment.setForeground(Color.WHITE);
		lblCompleteAppointment.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCompleteAppointment.setBounds(172, -11, 386, 75);
		frame.getContentPane().add(lblCompleteAppointment);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setForeground(new Color(255, 235, 205));
		panel.setBounds(21, 67, 231, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setBounds(10, 0, 81, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPetId.setBounds(10, 25, 81, 40);
		panel.add(lblPetId);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(10, 50, 81, 40);
		panel.add(lblDate);
		
		JLabel lblPetId_1_1 = new JLabel("Time:");
		lblPetId_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPetId_1_1.setBounds(10, 71, 81, 40);
		panel.add(lblPetId_1_1);
		
		textField = new JTextField();
		textField.setBounds(75, 11, 144, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 36, 144, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(75, 61, 144, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(75, 82, 144, 20);
		panel.add(textField_3);
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setBackground(new Color(240, 240, 240));
		lblPetId_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPetId_1_1_1.setBounds(10, 186, 199, 40);
		frame.getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 193, 697, 28);
		frame.getContentPane().add(textArea_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CheckUps", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(255, 235, 205));
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(21, 232, 199, 115);
		frame.getContentPane().add(panel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Wellness Exams (Monitor)");
		chckbxNewCheckBox.setBackground(new Color(255, 239, 213));
		chckbxNewCheckBox.setBounds(6, 23, 162, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxPreventiveCareadvice = new JCheckBox("Preventive Care \r\n(Advice and Treatment)\r\n");
		chckbxPreventiveCareadvice.setBackground(new Color(255, 239, 213));
		chckbxPreventiveCareadvice.setBounds(6, 49, 187, 23);
		panel_1.add(chckbxPreventiveCareadvice);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "Diagnostic", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1.setBounds(241, 232, 212, 115);
		frame.getContentPane().add(panel_1_1);
		
		JCheckBox chckbxLaboratoryTesting = new JCheckBox("Laboratory Testing");
		chckbxLaboratoryTesting.setBackground(new Color(255, 239, 213));
		chckbxLaboratoryTesting.setBounds(6, 22, 162, 23);
		panel_1_1.add(chckbxLaboratoryTesting);
		
		JCheckBox chckbxImagingServices = new JCheckBox("Imaging Services");
		chckbxImagingServices.setBackground(new Color(255, 239, 213));
		chckbxImagingServices.setBounds(6, 48, 162, 23);
		panel_1_1.add(chckbxImagingServices);
		
		JCheckBox chckbxEcgAndEkg = new JCheckBox("ECG and EKG");
		chckbxEcgAndEkg.setBackground(new Color(255, 239, 213));
		chckbxEcgAndEkg.setBounds(6, 74, 162, 23);
		panel_1_1.add(chckbxEcgAndEkg);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Surgery", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1.setBounds(475, 232, 212, 115);
		frame.getContentPane().add(panel_1_1_1);
		
		JCheckBox chckbxSpayingAndNeuturing = new JCheckBox("Spaying and Neuturing");
		chckbxSpayingAndNeuturing.setBackground(new Color(255, 239, 213));
		chckbxSpayingAndNeuturing.setBounds(6, 22, 162, 23);
		panel_1_1_1.add(chckbxSpayingAndNeuturing);
		
		JCheckBox chckbxTumorRemoval = new JCheckBox("Tumor Removal");
		chckbxTumorRemoval.setBackground(new Color(255, 239, 213));
		chckbxTumorRemoval.setBounds(6, 45, 162, 23);
		panel_1_1_1.add(chckbxTumorRemoval);
		
		JCheckBox chckbxWoundRepair = new JCheckBox("Wound Repair");
		chckbxWoundRepair.setBackground(new Color(255, 239, 213));
		chckbxWoundRepair.setBounds(6, 71, 162, 23);
		panel_1_1_1.add(chckbxWoundRepair);
		
		JLabel lblCompleteAppointment_1 = new JLabel("1\r\n");
		lblCompleteAppointment_1.setForeground(Color.WHITE);
		lblCompleteAppointment_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCompleteAppointment_1.setBounds(10, -11, 17, 75);
		frame.getContentPane().add(lblCompleteAppointment_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 56);
		frame.getContentPane().add(textArea_1);
		
		table = new JTable();
		table.setBounds(262, 67, 425, 106);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(21, 366, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOtherSevices = new JButton("Other Sevices");
		btnOtherSevices.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnOtherSevices.setBounds(562, 368, 125, 23);
		frame.getContentPane().add(btnOtherSevices);
	}
}
