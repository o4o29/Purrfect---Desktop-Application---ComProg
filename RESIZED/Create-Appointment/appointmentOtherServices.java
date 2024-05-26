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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompleteAppointment_1 = new JLabel("2");
		lblCompleteAppointment_1.setForeground(Color.WHITE);
		lblCompleteAppointment_1.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCompleteAppointment_1.setBounds(10, 11, 36, 75);
		frame.getContentPane().add(lblCompleteAppointment_1);
		
		JLabel lblCompleteAppointment = new JLabel("COMPLETE APPOINTMENT ");
		lblCompleteAppointment.setForeground(Color.WHITE);
		lblCompleteAppointment.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCompleteAppointment.setBounds(148, 11, 606, 75);
		frame.getContentPane().add(lblCompleteAppointment);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblPetId_1_1_1 = new JLabel("Choose your Concern/ Service:");
		lblPetId_1_1_1.setBackground(new Color(240, 240, 240));
		lblPetId_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblPetId_1_1_1.setBounds(10, 114, 330, 46);
		frame.getContentPane().add(lblPetId_1_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBackground(new Color(255, 182, 193));
		textArea_1_1.setBounds(0, 114, 884, 46);
		frame.getContentPane().add(textArea_1_1);
		
		JPanel dentalCare_Panel = new JPanel();
		dentalCare_Panel.setLayout(null);
		dentalCare_Panel.setForeground(new Color(255, 235, 205));
		dentalCare_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dental Care", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dentalCare_Panel.setBackground(new Color(255, 239, 213));
		dentalCare_Panel.setBounds(57, 208, 210, 130);
		frame.getContentPane().add(dentalCare_Panel);
		
		JCheckBox teethClean_Chk = new JCheckBox("Teeth Cleaning");
		teethClean_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		teethClean_Chk.setBackground(new Color(255, 239, 213));
		teethClean_Chk.setBounds(6, 23, 162, 23);
		dentalCare_Panel.add(teethClean_Chk);
		
		JCheckBox teethRemove_Chk = new JCheckBox("Teeth Removal");
		teethRemove_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		teethRemove_Chk.setBackground(new Color(255, 239, 213));
		teethRemove_Chk.setBounds(6, 49, 187, 23);
		dentalCare_Panel.add(teethRemove_Chk);
		
		JCheckBox oralExam_Chk = new JCheckBox("Oral Health Exam");
		oralExam_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		oralExam_Chk.setBackground(new Color(255, 239, 213));
		oralExam_Chk.setBounds(6, 75, 187, 23);
		dentalCare_Panel.add(oralExam_Chk);
		
		JPanel internalMed_Panel = new JPanel();
		internalMed_Panel.setLayout(null);
		internalMed_Panel.setForeground(new Color(255, 235, 205));
		internalMed_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Internal Medicine", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		internalMed_Panel.setBackground(new Color(255, 239, 213));
		internalMed_Panel.setBounds(326, 208, 210, 130);
		frame.getContentPane().add(internalMed_Panel);
		
		JCheckBox medManage_Chk = new JCheckBox("Medication Management");
		medManage_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		medManage_Chk.setBackground(new Color(255, 239, 213));
		medManage_Chk.setBounds(6, 23, 198, 23);
		internalMed_Panel.add(medManage_Chk);
		
		JCheckBox gastroDisorder_Chk = new JCheckBox("Gastrointestinal Disorders");
		gastroDisorder_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		gastroDisorder_Chk.setBackground(new Color(255, 239, 213));
		gastroDisorder_Chk.setBounds(6, 49, 198, 23);
		internalMed_Panel.add(gastroDisorder_Chk);
		
		JCheckBox endocrineDisorder_Chk = new JCheckBox("Endocrine Disorder");
		endocrineDisorder_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		endocrineDisorder_Chk.setBackground(new Color(255, 239, 213));
		endocrineDisorder_Chk.setBounds(6, 73, 187, 23);
		internalMed_Panel.add(endocrineDisorder_Chk);
		
		JPanel dermatology_Panel = new JPanel();
		dermatology_Panel.setLayout(null);
		dermatology_Panel.setForeground(new Color(255, 235, 205));
		dermatology_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dermatology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dermatology_Panel.setBackground(new Color(255, 239, 213));
		dermatology_Panel.setBounds(595, 208, 227, 130);
		frame.getContentPane().add(dermatology_Panel);
		
		JCheckBox skinTreat_Chk = new JCheckBox("Skin Treatments");
		skinTreat_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		skinTreat_Chk.setBackground(new Color(255, 239, 213));
		skinTreat_Chk.setBounds(6, 23, 162, 23);
		dermatology_Panel.add(skinTreat_Chk);
		
		JCheckBox allergyTreat_Chk = new JCheckBox("Allergy Testing/ Treatments");
		allergyTreat_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		allergyTreat_Chk.setBackground(new Color(255, 239, 213));
		allergyTreat_Chk.setBounds(6, 49, 215, 23);
		dermatology_Panel.add(allergyTreat_Chk);
		
		JPanel reproductiveSer_Panel = new JPanel();
		reproductiveSer_Panel.setLayout(null);
		reproductiveSer_Panel.setForeground(new Color(255, 235, 205));
		reproductiveSer_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reproductive Services", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		reproductiveSer_Panel.setBackground(new Color(255, 239, 213));
		reproductiveSer_Panel.setBounds(68, 378, 210, 130);
		frame.getContentPane().add(reproductiveSer_Panel);
		
		JCheckBox reproSer_Chk = new JCheckBox("Reproductive Services");
		reproSer_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		reproSer_Chk.setBackground(new Color(255, 239, 213));
		reproSer_Chk.setBounds(6, 38, 187, 23);
		reproductiveSer_Panel.add(reproSer_Chk);
		
		JCheckBox breedSer_Chk = new JCheckBox("Breeding Services");
		breedSer_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		breedSer_Chk.setBackground(new Color(255, 239, 213));
		breedSer_Chk.setBounds(6, 66, 187, 23);
		reproductiveSer_Panel.add(breedSer_Chk);
		
		JPanel oncology_Panel = new JPanel();
		oncology_Panel.setLayout(null);
		oncology_Panel.setForeground(new Color(255, 235, 205));
		oncology_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Oncology", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		oncology_Panel.setBackground(new Color(255, 239, 213));
		oncology_Panel.setBounds(326, 389, 279, 94);
		frame.getContentPane().add(oncology_Panel);
		
		JCheckBox cancerTreat_Chk = new JCheckBox("Cancer Treatment/ Chemotheraphy");
		cancerTreat_Chk.setFont(new Font("Verdana", Font.PLAIN, 13));
		cancerTreat_Chk.setBackground(new Color(255, 239, 213));
		cancerTreat_Chk.setBounds(6, 34, 267, 23);
		oncology_Panel.add(cancerTreat_Chk);
		
		JButton saveAppointment_Btn = new JButton("SAVE APPOINTMENT");
		saveAppointment_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveAppointment_Btn.setFont(new Font("Verdana", Font.PLAIN, 16));
		saveAppointment_Btn.setBounds(647, 422, 202, 40);
		frame.getContentPane().add(saveAppointment_Btn);
	}

}
