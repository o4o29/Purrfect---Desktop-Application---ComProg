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

public class searchClientAndPet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
	public searchClientAndPet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(713, 436); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENT AND PET");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblNewLabel.setBounds(131, 0, 423, 75);
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
		
		JLabel lblNewLabel_2 = new JLabel("Search Client ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(73, 161, 163, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Search Pet ID:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(370, 161, 96, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(188, 160, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(476, 160, 139, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setBounds(146, 195, 101, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setBounds(439, 191, 101, 25);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(59, 145, 280, 84);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(349, 145, 280, 84);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("NEW CLIENT?");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(304, 258, 96, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JButton btnNewButton_2_1 = new JButton("CREATE");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1.setBackground(new Color(255, 240, 245));
		btnNewButton_2_1.setBounds(299, 285, 101, 25);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("BACK");
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1_1.setBackground(new Color(255, 240, 245));
		btnNewButton_2_1_1.setBounds(10, 361, 101, 25);
		contentPane.add(btnNewButton_2_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setBounds(209, 240, 280, 84);
		contentPane.add(panel_2);
	}
}
