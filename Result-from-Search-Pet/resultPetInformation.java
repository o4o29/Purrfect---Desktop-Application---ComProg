import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class resultPetID {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultPetID window = new resultPetID();
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
	public resultPetID() {
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
		
		JLabel lblPetInformation = new JLabel("PET INFORMATION");
		lblPetInformation.setForeground(Color.WHITE);
		lblPetInformation.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblPetInformation.setBounds(99, 11, 481, 75);
		frame.getContentPane().add(lblPetInformation);
		
		JLabel lblresult = new JLabel("(Result)");
		lblresult.setForeground(Color.WHITE);
		lblresult.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lblresult.setBackground(UIManager.getColor("Button.background"));
		lblresult.setBounds(301, 62, 78, 54);
		frame.getContentPane().add(lblresult);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 116);
		frame.getContentPane().add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(208, 130, 253, 41);
		frame.getContentPane().add(panel);
		
		JLabel lblPetId = new JLabel("Pet ID:");
		lblPetId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPetId.setBounds(10, 12, 86, 14);
		panel.add(lblPetId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(98, 11, 145, 20);
		panel.add(textField);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnPrint.setBounds(581, 201, 89, 23);
		frame.getContentPane().add(btnPrint);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEdit.setBounds(581, 235, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.setBounds(581, 269, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnViewMoreInformation = new JButton("View More Information");
		btnViewMoreInformation.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnViewMoreInformation.setBounds(486, 363, 181, 23);
		frame.getContentPane().add(btnViewMoreInformation);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 365, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(75, 183, 493, 169);
		frame.getContentPane().add(table);
	}

}
