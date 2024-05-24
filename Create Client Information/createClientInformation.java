import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class createClientInformation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createClientInformation frame = new createClientInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public createClientInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(713, 436); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE CLIENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblNewLabel.setBounds(146, 0, 423, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMATION\r\n");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(216, 54, 304, 61);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 697, 115);
		contentPane.add(textArea);
		
		JButton btnNewButton_2_1_1 = new JButton("BACK");
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1_1.setBackground(new Color(255, 240, 245));
		btnNewButton_2_1_1.setBounds(10, 361, 101, 25);
		contentPane.add(btnNewButton_2_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(132, 137, 423, 233);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setBounds(38, 24, 76, 19);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(144, 25, 248, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name:");
		lblNewLabel_2_1.setBounds(38, 54, 96, 14);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 53, 248, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(38, 79, 106, 14);
		panel.add(lblNewLabel_2_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(144, 79, 248, 51);
		panel.add(textArea_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Contact No.:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(38, 136, 106, 14);
		panel.add(lblNewLabel_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 135, 248, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Email Address:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(38, 161, 106, 14);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 160, 248, 20);
		panel.add(textField_3);
		
		JButton btnNewButton_2_1_1_1 = new JButton("CREATE CLIENT\r\n");
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1_1_1.setBackground(new Color(255, 240, 245));
		btnNewButton_2_1_1_1.setBounds(144, 197, 150, 25);
		panel.add(btnNewButton_2_1_1_1);
	}
}
