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
import javax.swing.JRadioButton;

public class createPetInformation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createPetInformation frame = new createPetInformation();
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
	public createPetInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(713, 436); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE PET");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblNewLabel.setBounds(193, 0, 304, 75);
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
		panel.setBounds(62, 136, 569, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Client ID:");
		lblNewLabel_2.setBounds(38, 24, 85, 19);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(130, 25, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pet Name:");
		lblNewLabel_2_1.setBounds(38, 59, 96, 14);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 58, 145, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Species:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(38, 91, 106, 14);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Breed:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(38, 125, 106, 14);
		panel.add(lblNewLabel_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 124, 145, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Gender:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(304, 91, 106, 14);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(130, 90, 145, 20);
		panel.add(textField_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBackground(new Color(255, 182, 193));
		rdbtnNewRadioButton.setBounds(382, 88, 64, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female\r\n");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFemale.setBackground(new Color(255, 182, 193));
		rdbtnFemale.setBounds(441, 88, 109, 23);
		panel.add(rdbtnFemale);
		
		JLabel lblNewLabel_2_2 = new JLabel("Weight:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(304, 24, 85, 19);
		panel.add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(382, 25, 145, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Age:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(304, 58, 85, 19);
		panel.add(lblNewLabel_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(382, 58, 145, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Color/ Markings:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1_1.setBounds(304, 123, 109, 19);
		panel.add(lblNewLabel_2_2_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(418, 124, 109, 20);
		panel.add(textField_6);
		
		JButton btnNewButton_2_1_1_1 = new JButton("CREATE CLIENT\r\n");
		btnNewButton_2_1_1_1.setBounds(537, 361, 150, 25);
		contentPane.add(btnNewButton_2_1_1_1);
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1_1_1.setBackground(new Color(255, 240, 245));
	}
}
