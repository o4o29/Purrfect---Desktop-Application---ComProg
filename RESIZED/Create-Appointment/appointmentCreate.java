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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appointmentCreate{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
	 * @wbp.parser.entryPoint
	 */
	public appointmentCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompleteAppointment = new JLabel("COMPLETE APPOINTMENT ");
		lblCompleteAppointment.setForeground(Color.WHITE);
		lblCompleteAppointment.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCompleteAppointment.setBounds(148, 11, 606, 75);
		frame.getContentPane().add(lblCompleteAppointment);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setForeground(new Color(255, 235, 205));
		panel.setBounds(23, 116, 297, 129);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setBounds(10, 5, 72, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetId.setBounds(10, 35, 59, 31);
		panel.add(lblPetId);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDate.setBounds(10, 60, 44, 31);
		panel.add(lblDate);
		
		JLabel lblPetId_1_1 = new JLabel("Time:");
		lblPetId_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPetId_1_1.setBounds(10, 88, 44, 31);
		panel.add(lblPetId_1_1);
		
		textField = new JTextField();
		textField.setBounds(85, 11, 186, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 41, 186, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 69, 186, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(85, 97, 186, 22);
		panel.add(textField_3);
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setBackground(new Color(240, 240, 240));
		lblPetId_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblPetId_1_1_1.setBounds(10, 271, 330, 46);
		frame.getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 271, 884, 46);
		frame.getContentPane().add(textArea_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CheckUps", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(255, 235, 205));
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(23, 376, 322, 94);
		frame.getContentPane().add(panel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Wellness Exams (Monitor)");
		chckbxNewCheckBox.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxNewCheckBox.setBackground(new Color(255, 239, 213));
		chckbxNewCheckBox.setBounds(19, 22, 218, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxPreventiveCareadvice = new JCheckBox("Preventive Care \r\n(Advice and Treatment)\r\n");
		chckbxPreventiveCareadvice.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxPreventiveCareadvice.setBackground(new Color(255, 239, 213));
		chckbxPreventiveCareadvice.setBounds(19, 49, 295, 23);
		panel_1.add(chckbxPreventiveCareadvice);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "Diagnostic", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1.setBounds(360, 361, 230, 120);
		frame.getContentPane().add(panel_1_1);
		
		JCheckBox chckbxLaboratoryTesting = new JCheckBox("Laboratory Testing");
		chckbxLaboratoryTesting.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxLaboratoryTesting.setBackground(new Color(255, 239, 213));
		chckbxLaboratoryTesting.setBounds(18, 22, 206, 23);
		panel_1_1.add(chckbxLaboratoryTesting);
		
		JCheckBox chckbxImagingServices = new JCheckBox("Imaging Services");
		chckbxImagingServices.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxImagingServices.setBackground(new Color(255, 239, 213));
		chckbxImagingServices.setBounds(18, 48, 206, 23);
		panel_1_1.add(chckbxImagingServices);
		
		JCheckBox chckbxEcgAndEkg = new JCheckBox("ECG and EKG");
		chckbxEcgAndEkg.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxEcgAndEkg.setBackground(new Color(255, 239, 213));
		chckbxEcgAndEkg.setBounds(18, 74, 206, 23);
		panel_1_1.add(chckbxEcgAndEkg);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setForeground(new Color(255, 235, 205));
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Surgery", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(255, 239, 213));
		panel_1_1_1.setBounds(611, 361, 230, 120);
		frame.getContentPane().add(panel_1_1_1);
		
		JCheckBox chckbxSpayingAndNeuturing = new JCheckBox("Spaying and Neuturing");
		chckbxSpayingAndNeuturing.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxSpayingAndNeuturing.setBackground(new Color(255, 239, 213));
		chckbxSpayingAndNeuturing.setBounds(16, 22, 188, 23);
		panel_1_1_1.add(chckbxSpayingAndNeuturing);
		
		JCheckBox chckbxTumorRemoval = new JCheckBox("Tumor Removal");
		chckbxTumorRemoval.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxTumorRemoval.setBackground(new Color(255, 239, 213));
		chckbxTumorRemoval.setBounds(16, 48, 188, 23);
		panel_1_1_1.add(chckbxTumorRemoval);
		
		JCheckBox chckbxWoundRepair = new JCheckBox("Wound Repair");
		chckbxWoundRepair.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxWoundRepair.setBounds(16, 76, 190, 23);
		panel_1_1_1.add(chckbxWoundRepair);
		chckbxWoundRepair.setBackground(new Color(255, 239, 213));
		
		JLabel lblCompleteAppointment_1 = new JLabel("1\r\n");
		lblCompleteAppointment_1.setForeground(Color.WHITE);
		lblCompleteAppointment_1.setFont(new Font("Verdana", Font.BOLD, 34));
		lblCompleteAppointment_1.setBounds(23, 11, 44, 75);
		frame.getContentPane().add(lblCompleteAppointment_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		frame.getContentPane().add(textArea_1);
		
		JButton btnOtherSevices = new JButton("Other Sevices");
		btnOtherSevices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOtherSevices.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnOtherSevices.setBounds(639, 510, 202, 40);
		frame.getContentPane().add(btnOtherSevices);
	}
}
