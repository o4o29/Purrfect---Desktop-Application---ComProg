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
import java.awt.TextField;
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
		setSize(900, 600); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENT AND PET");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel.setBounds(174, 23, 532, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMATION\r\n");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(280, 83, 304, 61);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 153);
		contentPane.add(textArea);
		
	
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(138, 177, 591, 353);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel searcClientIDPanel = new JPanel();
		searcClientIDPanel.setBounds(30, 52, 251, 124);
		mainPanel.add(searcClientIDPanel);
		searcClientIDPanel.setBackground(new Color(255, 228, 225));
		searcClientIDPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Search Client ID:");
		lblNewLabel_2.setBounds(63, 21, 163, 14);
		searcClientIDPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		petId_field = new JTextField();
		petId_field.setBounds(44, 57, 157, 20);
		searcClientIDPanel.add(petId_field);
		petId_field.setColumns(10);
		
		JButton clientIdBtn = new JButton("SEARCH");
		clientIdBtn.setBounds(90, 88, 79, 25);
		searcClientIDPanel.add(clientIdBtn);
		clientIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		clientIdBtn.setBackground(new Color(255, 240, 245));
		
		
		
		clientIdBtn.addActionListener(e -> {

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
		
		JPanel searchPetIDPanel = new JPanel();
		searchPetIDPanel.setBounds(310, 52, 253, 124);
		mainPanel.add(searchPetIDPanel);
		searchPetIDPanel.setBackground(new Color(255, 228, 225));
		searchPetIDPanel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Search Pet ID:");
		lblNewLabel_2_1.setBounds(77, 22, 115, 14);
		searchPetIDPanel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		clientId_field = new JTextField();
		clientId_field.setBounds(51, 57, 157, 20);
		searchPetIDPanel.add(clientId_field);
		clientId_field.setColumns(10);
		
		JButton petIdBtn = new JButton("SEARCH");
		petIdBtn.setBounds(91, 88, 79, 25);
		searchPetIDPanel.add(petIdBtn);
		petIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		petIdBtn.setBackground(new Color(255, 240, 245));
		int enteredClientID = Integer.parseInt(clientId_field.getText());
		
		JPanel searchPetIDPanel_1 = new JPanel();
		searchPetIDPanel_1.setLayout(null);
		searchPetIDPanel_1.setBackground(new Color(255, 228, 225));
		searchPetIDPanel_1.setBounds(175, 227, 253, 115);
		mainPanel.add(searchPetIDPanel_1);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBounds(78, 63, 101, 25);
		searchPetIDPanel_1.add(btnCreate);
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreate.setBackground(new Color(255, 240, 245));
		
		JLabel btnNewClient = new JLabel("NEW CLIENT?");
		btnNewClient.setBounds(70, 37, 134, 14);
		searchPetIDPanel_1.add(btnNewClient);
		btnNewClient.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("For Existing Client");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(195, 0, 211, 61);
		mainPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("For New Client");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(215, 170, 175, 61);
		mainPanel.add(lblNewLabel_1_1_1);
		
		
		// BUTTON LISTENERS
		btnCreate.addActionListener(e -> {
			this.dispose();
			new createClientInformation();
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
