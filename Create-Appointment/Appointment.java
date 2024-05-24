import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Appointment {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment window = new Appointment();
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
	public Appointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 713, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAppointment = new JLabel("APPOINTMENT");
		lblAppointment.setForeground(Color.WHITE);
		lblAppointment.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblAppointment.setBounds(150, 40, 381, 75);
		frame.getContentPane().add(lblAppointment);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 363, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(137, 172, 396, 94);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Client ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 26, 107, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 25, 230, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Create Appointment");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(116, 60, 166, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(137, 277, 396, 75);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewClientRegister = new JLabel("New Client? Register your Client Information.");
		lblNewClientRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewClientRegister.setBounds(53, 11, 303, 19);
		panel_1.add(lblNewClientRegister);
		
		JButton btnNewButton_1_1 = new JButton("Register Client");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(114, 41, 166, 23);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblCreate = new JLabel("CREATE");
		lblCreate.setForeground(Color.WHITE);
		lblCreate.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCreate.setBounds(281, -11, 116, 75);
		frame.getContentPane().add(lblCreate);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 125);
		frame.getContentPane().add(textArea_1);
	}

}
