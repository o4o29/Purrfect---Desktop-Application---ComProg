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
	private JTextField petID_Field;
	private JTextField dosage_Field;
	private JTextField duration_Field;
	private JTextField time_Field;
	private JTextField drugName_Field;

	
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
		textArea_1.setEditable(false);
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
		
		petID_Field = new JTextField();
		petID_Field.setBounds(126, 20, 217, 30);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		dosage_Field = new JTextField();
		dosage_Field.setColumns(10);
		dosage_Field.setBounds(126, 105, 217, 30);
		panel.add(dosage_Field);
		
		duration_Field = new JTextField();
		duration_Field.setColumns(10);
		duration_Field.setBounds(126, 146, 217, 30);
		panel.add(duration_Field);
		
		time_Field = new JTextField();
		time_Field.setColumns(10);
		time_Field.setBounds(126, 190, 217, 30);
		panel.add(time_Field);
		
		drugName_Field = new JTextField();
		drugName_Field.setColumns(10);
		drugName_Field.setBounds(126, 61, 217, 30);
		panel.add(drugName_Field);
		
		JTextArea additionalInstruct_Field = new JTextArea();
		additionalInstruct_Field.setBounds(24, 269, 319, 60);
		panel.add(additionalInstruct_Field);
		
		JButton printSave_Btn = new JButton("Print & Save Prescription");
		printSave_Btn.setFont(new Font("Verdana", Font.PLAIN, 15));
		printSave_Btn.setBounds(51, 340, 217, 32);
		panel.add(printSave_Btn);
		
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
	

	public Prescription() {
		initialize();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
    		new Prescription();
        });
	}
}