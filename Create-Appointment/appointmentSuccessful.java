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

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(21, 366, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOtherSevices = new JButton("Submit Another Appointment");
		btnOtherSevices.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnOtherSevices.setBounds(458, 368, 229, 23);
		frame.getContentPane().add(btnOtherSevices);
		
		JLabel lblAppointmentSuccessful = new JLabel("APPOINTMENT SUCCESSFUL");
		lblAppointmentSuccessful.setForeground(Color.WHITE);
		lblAppointmentSuccessful.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblAppointmentSuccessful.setBounds(70, 11, 538, 75);
		frame.getContentPane().add(lblAppointmentSuccessful);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 92);
		frame.getContentPane().add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(146, 102, 373, 255);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 106, 14);
		panel.add(lblNewLabel);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClientId.setBounds(10, 36, 62, 14);
		panel.add(lblClientId);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPetId.setBounds(10, 60, 62, 14);
		panel.add(lblPetId);
		
		JLabel lblServices = new JLabel("Services:");
		lblServices.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblServices.setBounds(10, 85, 62, 14);
		panel.add(lblServices);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(10, 140, 62, 14);
		panel.add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(10, 162, 62, 14);
		panel.add(lblTime);
		
		JLabel lblTotalPayment = new JLabel("Total Payment:");
		lblTotalPayment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalPayment.setBounds(10, 187, 106, 14);
		panel.add(lblTotalPayment);
		
		textField = new JTextField();
		textField.setBounds(109, 9, 232, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 34, 232, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 58, 232, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 160, 232, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 185, 232, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(109, 138, 232, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(109, 83, 232, 44);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnPrint.setBounds(254, 216, 89, 23);
		panel.add(btnPrint);
	}
}
