import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Appointment {

	private JFrame frame;
	private JTextField clientID_Field;



	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel btnAppointment = new JLabel("APPOINTMENT");
		btnAppointment.setBounds(193, 62, 532, 75);
		btnAppointment.setForeground(Color.WHITE);
		btnAppointment.setFont(new Font("Verdana", Font.BOLD, 60));
		frame.getContentPane().add(btnAppointment);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 199, 508, 149);
		panel.setBackground(new Color(255, 182, 193));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Client ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 36, 166, 19);
		panel.add(lblNewLabel);
		
		clientID_Field = new JTextField();
		clientID_Field.setBounds(216, 32, 240, 35);
		panel.add(clientID_Field);
		clientID_Field.setColumns(10);
		
		JButton createAppoint_Btn = new JButton("Create Appointment");
		createAppoint_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createAppoint_Btn.setFont(new Font("Verdana", Font.PLAIN, 16));
		createAppoint_Btn.setBounds(152, 83, 202, 40);
		panel.add(createAppoint_Btn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(186, 376, 508, 149);
		panel_1.setBackground(new Color(255, 182, 193));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewClientRegister = new JLabel("New Client? Register your Client Information.");
		lblNewClientRegister.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewClientRegister.setBounds(25, 37, 473, 19);
		panel_1.add(lblNewClientRegister);
		
		JButton registerClient_Btn = new JButton("Register Client");
		registerClient_Btn.setFont(new Font("Verdana", Font.PLAIN, 16));
		registerClient_Btn.setBounds(154, 78, 202, 40);
		panel_1.add(registerClient_Btn);
		
		JLabel lblCreate = new JLabel("CREATE");
		lblCreate.setBounds(369, 11, 151, 75);
		lblCreate.setForeground(Color.WHITE);
		lblCreate.setFont(new Font("Verdana", Font.BOLD, 30));
		frame.getContentPane().add(lblCreate);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(0, 0, 884, 167);
		textArea_1.setBackground(new Color(255, 182, 193));
		frame.getContentPane().add(textArea_1);
		
	}

	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Appointment();
		});
	}

	public Appointment() {
		initialize();
		frame.setVisible(true);
	}
}
