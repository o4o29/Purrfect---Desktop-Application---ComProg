import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class searchClientAndPet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField clientId_field;
	private JTextField petId_field;

	
	/**
	 * Create the frame.
	 */
	private void initialize() {
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
		
		clientId_field = new JTextField();
		clientId_field.setBounds(188, 160, 139, 20);
		contentPane.add(clientId_field);
		clientId_field.setColumns(10);
		
		petId_field = new JTextField();
		petId_field.setColumns(10);
		petId_field.setBounds(476, 160, 139, 20);
		contentPane.add(petId_field);
		
		JButton clientIdBtn = new JButton("SEARCH");
		clientIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		clientIdBtn.setBackground(new Color(255, 240, 245));
		clientIdBtn.setBounds(146, 195, 101, 25);
		contentPane.add(clientIdBtn);
		
		JButton petIdBtn = new JButton("SEARCH");
		petIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		petIdBtn.setBackground(new Color(255, 240, 245));
		petIdBtn.setBounds(439, 191, 101, 25);
		contentPane.add(petIdBtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(59, 145, 280, 84);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(349, 145, 280, 84);
		contentPane.add(panel_1);
		
		JLabel btnNewClient = new JLabel("NEW CLIENT?");
		btnNewClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewClient.setBounds(304, 258, 96, 14);
		contentPane.add(btnNewClient);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreate.setBackground(new Color(255, 240, 245));
		btnCreate.setBounds(299, 285, 101, 25);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(new Color(255, 240, 245));
		btnBack.setBounds(10, 361, 101, 25);
		contentPane.add(btnBack);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setBounds(209, 240, 280, 84);
		contentPane.add(panel_2);
		
		
		// BUTTON LISTENERS
		btnCreate.addActionListener(e -> {
			this.dispose();
			new createClientInformation();
		});
		
		btnBack.addActionListener(e -> {
        	this.dispose();
        	new Dashboard();
        });
		
		clientIdBtn.addActionListener(e -> {
		    int enteredClientID = Integer.parseInt(clientId_field.getText());

		    try {
		        DatabaseManager dbManager = DatabaseManager.getInstance();
		        boolean clientExists = dbManager.checkClientExists(enteredClientID);

		        if (clientExists) {
		        	this.dispose();
		            ResultSet clientInfo = dbManager.getClientInformation(enteredClientID);
		            if (clientInfo != null) {
		                resultClientInformation resultWindow = new resultClientInformation();
		                resultWindow.populateTable(clientInfo);
		            }
		        } else {
		            JOptionPane.showMessageDialog(contentPane, "Client ID does not exist.");
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		});

	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
    		new searchClientAndPet();
        });
	}
	
	public searchClientAndPet() {
		initialize();
		this.setVisible(true);
	}
}
