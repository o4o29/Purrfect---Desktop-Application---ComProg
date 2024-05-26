import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class Prescription {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrescription = new JLabel("PRESCRIPTION");
		lblPrescription.setForeground(Color.WHITE);
		lblPrescription.setFont(new Font("Verdana", Font.BOLD, 40));
		lblPrescription.setBounds(261, 11, 353, 75);
		frame.getContentPane().add(lblPrescription);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		frame.getContentPane().add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setBounds(40, 122, 365, 395);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pet ID:\r\n");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 26, 64, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDrugName = new JLabel("Drug Name:");
		lblDrugName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDrugName.setBounds(24, 67, 110, 20);
		panel.add(lblDrugName);
		
		JLabel lblDosage = new JLabel("Dosage:");
		lblDosage.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDosage.setBounds(23, 108, 93, 20);
		panel.add(lblDosage);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDuration.setBounds(24, 152, 110, 14);
		panel.add(lblDuration);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTime.setBounds(24, 196, 64, 14);
		panel.add(lblTime);
		
		JLabel lblAdditionalInstructions = new JLabel("Additional Instructions:\r\n");
		lblAdditionalInstructions.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblAdditionalInstructions.setBounds(24, 244, 203, 14);
		panel.add(lblAdditionalInstructions);
		
		textField = new JTextField();
		textField.setBounds(126, 20, 217, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 105, 217, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 146, 217, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(126, 190, 217, 30);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(126, 61, 217, 30);
		panel.add(textField_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 269, 319, 60);
		panel.add(textArea);
		
		JButton btnSaveAppointment_1_1 = new JButton("Print & Save Prescription");
		btnSaveAppointment_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSaveAppointment_1_1.setBounds(51, 340, 217, 32);
		panel.add(btnSaveAppointment_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prescription", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(250, 128, 114)));
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(447, 123, 400, 372);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPetId.setBounds(28, 23, 131, 14);
		panel_1.add(lblPetId);
		
		JLabel lblDrugName_1 = new JLabel("Drug Name:");
		lblDrugName_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDrugName_1.setBounds(28, 59, 125, 20);
		panel_1.add(lblDrugName_1);
		
		JLabel lblDosage_1 = new JLabel("Dosage:");
		lblDosage_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDosage_1.setBounds(28, 103, 78, 20);
		panel_1.add(lblDosage_1);
		
		JLabel lblDuration_1 = new JLabel("Duration:");
		lblDuration_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDuration_1.setBounds(28, 148, 78, 14);
		panel_1.add(lblDuration_1);
		
		JLabel lblTime_1 = new JLabel("Time:");
		lblTime_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTime_1.setBounds(28, 190, 78, 14);
		panel_1.add(lblTime_1);
		
		JLabel lblAdditionalInstructions_1 = new JLabel("Additional Instructions:\r\n");
		lblAdditionalInstructions_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblAdditionalInstructions_1.setBounds(28, 227, 184, 20);
		panel_1.add(lblAdditionalInstructions_1);
		
		
}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
    		new Prescription();
        });
	}

	public Prescription() {
		initialize();
		frame.setVisible(true);
	}
}
