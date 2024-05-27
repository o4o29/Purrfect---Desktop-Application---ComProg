import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class editClientInformation {

	private JFrame frmEditClientInformation;
	private JTextField FName_Field;
	private JTextField LName_Field;
	private JTextField contact_Field;
	private JTextField emailAdd_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editClientInformation window = new editClientInformation();
					window.frmEditClientInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editClientInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditClientInformation = new JFrame();
		frmEditClientInformation.getContentPane().setBackground(new Color(255, 228, 225));
		frmEditClientInformation.setTitle("Edit Client Information");
		frmEditClientInformation.setBounds(100, 100, 900 , 600);
		frmEditClientInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditClientInformation.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255, 182, 193));
		headerPanel.setBounds(0, 0, 884, 150);
		frmEditClientInformation.getContentPane().add(headerPanel);
		
		JLabel lblClientInformation = new JLabel("CLIENT INFORMATION");
		lblClientInformation.setForeground(Color.WHITE);
		lblClientInformation.setFont(new Font("Verdana", Font.BOLD, 55));
		lblClientInformation.setBounds(85, 29, 717, 50);
		headerPanel.add(lblClientInformation);
		
		JLabel lblEdit = new JLabel("EDIT");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Verdana", Font.BOLD, 25));
		lblEdit.setBounds(373, 90, 69, 50);
		headerPanel.add(lblEdit);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(215, 184, 411, 293);
		frmEditClientInformation.getContentPane().add(mainPanel);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(31, 25, 76, 19);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(31, 55, 96, 14);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(31, 80, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Contact No.:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(31, 157, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Email Address:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(31, 182, 106, 14);
		mainPanel.add(lblNewLabel_2_1_1_1_1);
		
		FName_Field = new JTextField();
		FName_Field.setColumns(10);
		FName_Field.setBounds(133, 26, 248, 20);
		mainPanel.add(FName_Field);
		
		LName_Field = new JTextField();
		LName_Field.setColumns(10);
		LName_Field.setBounds(133, 54, 248, 20);
		mainPanel.add(LName_Field);
		
		contact_Field = new JTextField();
		contact_Field.setColumns(10);
		contact_Field.setBounds(133, 156, 248, 20);
		mainPanel.add(contact_Field);
		
		emailAdd_Field = new JTextField();
		emailAdd_Field.setColumns(10);
		emailAdd_Field.setBounds(133, 181, 248, 20);
		mainPanel.add(emailAdd_Field);
		
		JTextArea address_Field = new JTextArea();
		address_Field.setBounds(133, 80, 248, 66);
		mainPanel.add(address_Field);
		
		JButton submitChanges_Btn = new JButton("SUBMIT CHANGES");
		submitChanges_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		submitChanges_Btn.setBackground(new Color(255, 240, 245));
		submitChanges_Btn.setBounds(129, 257, 150, 25);
		mainPanel.add(submitChanges_Btn);
	}
}
