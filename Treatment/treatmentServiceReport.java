import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class treatmentServiceReport {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					treatmentServiceReport window = new treatmentServiceReport();
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
	public treatmentServiceReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 713, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTreatmentService_1 = new JLabel("TREATMENT SERVICE");
		lblTreatmentService_1.setForeground(Color.WHITE);
		lblTreatmentService_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTreatmentService_1.setBounds(192, -12, 293, 75);
		frame.getContentPane().add(lblTreatmentService_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 56);
		frame.getContentPane().add(textArea_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 255, 0));
		panel_1.setBounds(10, 103, 677, 236);
		frame.getContentPane().add(panel_1);
		
		JLabel lblService = new JLabel("Service:");
		lblService.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblService.setBounds(21, 11, 129, 14);
		panel_1.add(lblService);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 9, 220, 20);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Medical Consultation:\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(21, 36, 129, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Procedure:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(21, 60, 129, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Diagnostic:\r\n");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(21, 85, 129, 14);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Emergency Care:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(21, 111, 129, 14);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Vaccinations:");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1.setBounds(321, 12, 76, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 34, 159, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 58, 220, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 83, 220, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(21, 131, 290, 73);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Name:");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1.setBounds(331, 36, 76, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(410, 34, 220, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1 = new JLabel("Against:");
		lblNewLabel_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1_1.setBounds(321, 61, 76, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(410, 58, 220, 20);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_1 = new JLabel("Deworming:");
		lblNewLabel_1_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1_1_1.setBounds(321, 86, 76, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(410, 109, 220, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_1_1 = new JLabel("For Follow Up Check up?");
		lblNewLabel_1_1_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1_1_1_1.setBounds(321, 135, 159, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_1_2 = new JLabel("Deworming:");
		lblNewLabel_1_1_2_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1_1_1_2.setBounds(321, 112, 76, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1_1_1_1_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes\r\n");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBackground(new Color(255, 182, 193));
		rdbtnNewRadioButton.setBounds(318, 156, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNo.setBackground(new Color(255, 182, 193));
		rdbtnNo.setBounds(456, 156, 109, 23);
		panel_1.add(rdbtnNo);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Yes\r\n");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBackground(new Color(255, 182, 193));
		rdbtnNewRadioButton_1.setBounds(410, 8, 89, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNo_1.setBackground(new Color(255, 182, 193));
		rdbtnNo_1.setBounds(501, 7, 109, 23);
		panel_1.add(rdbtnNo_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Yes\r\n");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1_1.setBackground(new Color(255, 182, 193));
		rdbtnNewRadioButton_1_1.setBounds(410, 82, 89, 23);
		panel_1.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Yes\r\n");
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1_1_1.setBackground(new Color(255, 182, 193));
		rdbtnNewRadioButton_1_1_1.setBounds(507, 82, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_2 = new JLabel("Veterinarian:");
		lblNewLabel_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_2.setBounds(321, 185, 76, 14);
		panel_1.add(lblNewLabel_1_1_2_1_1_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(321, 206, 220, 20);
		panel_1.add(textField_8);
		
		JLabel lblPetId = new JLabel("PET ID");
		lblPetId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPetId.setBounds(24, 67, 129, 14);
		frame.getContentPane().add(lblPetId);
		
		JLabel lblAppointmentId = new JLabel("APPOINTMENT ID");
		lblAppointmentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAppointmentId.setBounds(582, 67, 115, 14);
		frame.getContentPane().add(lblAppointmentId);
		
		JButton btnBackToDashboard = new JButton("BACK");
		btnBackToDashboard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBackToDashboard.setBounds(10, 363, 143, 23);
		frame.getContentPane().add(btnBackToDashboard);
		
		JButton btnBackToDashboard_1 = new JButton("BACK TO DASHBOARD");
		btnBackToDashboard_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBackToDashboard_1.setBounds(485, 363, 202, 23);
		frame.getContentPane().add(btnBackToDashboard_1);
	}

}
