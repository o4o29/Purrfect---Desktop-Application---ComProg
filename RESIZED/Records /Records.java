import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Records {

	private JFrame frame;
	private JTextField searchRecord_Field;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Records window = new Records();
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
	public Records() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClientAndPet = new JLabel("CLIENT AND PET RECORDS");
		lblClientAndPet.setForeground(Color.WHITE);
		lblClientAndPet.setFont(new Font("Verdana", Font.BOLD, 35));
		lblClientAndPet.setBounds(159, 0, 532, 75);
		frame.getContentPane().add(lblClientAndPet);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 75);
		frame.getContentPane().add(textArea);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(255, 182, 193));
		searchPanel.setBounds(273, 86, 282, 62);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		searchRecord_Field = new JTextField();
		searchRecord_Field.setBounds(21, 11, 237, 20);
		searchPanel.add(searchRecord_Field);
		searchRecord_Field.setColumns(10);
		
		JLabel lblInputSearchKeywords = new JLabel("Input search keywords");
		lblInputSearchKeywords.setBounds(59, 17, 161, 45);
		searchPanel.add(lblInputSearchKeywords);
		lblInputSearchKeywords.setForeground(new Color(0, 0, 0));
		lblInputSearchKeywords.setFont(new Font("Verdana", Font.ITALIC, 13));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBackground(new Color(255, 182, 193));
		tablePanel.setBounds(10, 177, 864, 373);
		frame.getContentPane().add(tablePanel);
		
		table = new JTable();
		table.setBounds(10, 11, 844, 340);
		tablePanel.add(table);
	}
}
