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
	private JTextField petID_Field;
	private JTextField petName_Field;
	private JTextField clientID_Field;
	private JTextField date_Field;
	private JTextField time_Field;

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
		panel.setBounds(23, 113, 297, 163);
		frame.getContentPane().add(panel);
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
		petID_Field.setBounds(85, 11, 186, 22);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		petName_Field = new JTextField();
		petName_Field.setColumns(10);
		petName_Field.setBounds(85, 41, 186, 22);
		panel.add(petName_Field);
		
		clientID_Field = new JTextField();
		clientID_Field.setColumns(10);
		clientID_Field.setBounds(85, 69, 186, 22);
		panel.add(clientID_Field);
		
		date_Field = new JTextField();
		date_Field.setColumns(10);
		date_Field.setBounds(85, 97, 186, 22);
		panel.add(date_Field);
		
		time_Field = new JTextField();
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
		frame.getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 298, 884, 46);
		frame.getContentPane().add(textArea_1_1);
		
		JPanel checkups_Panel = new JPanel();
		checkups_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CheckUps", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		checkups_Panel.setLayout(null);
		checkups_Panel.setForeground(new Color(255, 235, 205));
		checkups_Panel.setBackground(new Color(255, 239, 213));
		checkups_Panel.setBounds(23, 387, 322, 94);
		frame.getContentPane().add(checkups_Panel);
		
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
		frame.getContentPane().add(diagnostic_Panel);
		
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
		frame.getContentPane().add(surgery_Panel);
		
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
