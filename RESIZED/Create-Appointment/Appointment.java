
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
	private JTextField petID_Field;



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
		
		JLabel lblNewLabel = new JLabel("Enter Pet ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 36, 166, 19);
		panel.add(lblNewLabel);
		
		petID_Field = new JTextField();
		petID_Field.setBounds(216, 32, 240, 35);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Create Appointment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNewButton_1.setBounds(152, 83, 202, 40);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(186, 376, 508, 149);
		panel_1.setBackground(new Color(255, 182, 193));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewClientRegister = new JLabel("New Client? Register your Client Information.");
		lblNewClientRegister.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewClientRegister.setBounds(25, 37, 473, 19);
		panel_1.add(lblNewClientRegister);
		
		JButton btnNewButton_1_1 = new JButton("Register Client");
		btnNewButton_1_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(154, 78, 202, 40);
		panel_1.add(btnNewButton_1_1);
		
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
