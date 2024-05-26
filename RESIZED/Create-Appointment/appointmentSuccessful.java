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
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAppointmentSuccessful = new JLabel("APPOINTMENT SUCCESSFUL");
		lblAppointmentSuccessful.setForeground(Color.WHITE);
		lblAppointmentSuccessful.setFont(new Font("Verdana", Font.BOLD, 40));
		lblAppointmentSuccessful.setBounds(135, 11, 667, 75);
		frame.getContentPane().add(lblAppointmentSuccessful);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
		frame.getContentPane().add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(171, 131, 528, 393);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(25, 13, 175, 26);
		panel.add(lblNewLabel);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblClientId.setBounds(88, 58, 106, 26);
		panel.add(lblClientId);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPetId.setBounds(110, 99, 65, 34);
		panel.add(lblPetId);
		
		JLabel lblServices = new JLabel("Services:");
		lblServices.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblServices.setBounds(89, 155, 89, 26);
		panel.add(lblServices);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDate.setBounds(121, 208, 62, 26);
		panel.add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTime.setBounds(121, 250, 62, 32);
		panel.add(lblTime);
		
		JLabel lblTotalPayment = new JLabel("Total Payment:");
		lblTotalPayment.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTotalPayment.setBounds(37, 298, 164, 26);
		panel.add(lblTotalPayment);
		
		textField = new JTextField();
		textField.setBounds(210, 15, 268, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 60, 268, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(210, 105, 268, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(210, 255, 268, 30);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(211, 300, 267, 30);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(210, 210, 268, 30);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(210, 150, 268, 44);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnPrint.setBounds(369, 356, 121, 26);
		panel.add(btnPrint);
	}
}
