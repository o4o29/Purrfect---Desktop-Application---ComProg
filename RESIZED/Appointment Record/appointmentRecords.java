import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class appointmentRecords {

	private JFrame frame;
	private JTextField search_Field;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointmentRecords window = new appointmentRecords();
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
	public appointmentRecords() {
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
		
		JLabel lblPetAppointmentRecords = new JLabel("PET APPOINTMENT RECORDS");
		lblPetAppointmentRecords.setForeground(Color.WHITE);
		lblPetAppointmentRecords.setFont(new Font("Verdana", Font.BOLD, 35));
		lblPetAppointmentRecords.setBounds(150, 0, 578, 75);
		frame.getContentPane().add(lblPetAppointmentRecords);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 75);
		frame.getContentPane().add(textArea);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBackground(new Color(255, 182, 193));
		searchPanel.setBounds(279, 86, 282, 62);
		frame.getContentPane().add(searchPanel);
		
		search_Field = new JTextField();
		search_Field.setColumns(10);
		search_Field.setBounds(21, 11, 237, 20);
		searchPanel.add(search_Field);
		
		JLabel lblInputSearchKeywords = new JLabel("Input search keywords");
		lblInputSearchKeywords.setForeground(Color.BLACK);
		lblInputSearchKeywords.setFont(new Font("Verdana", Font.ITALIC, 13));
		lblInputSearchKeywords.setBounds(59, 21, 161, 41);
		searchPanel.add(lblInputSearchKeywords);
		
		JPanel tableAppointmentRecordPanel = new JPanel();
		tableAppointmentRecordPanel.setLayout(null);
		tableAppointmentRecordPanel.setBackground(new Color(255, 182, 193));
		tableAppointmentRecordPanel.setBounds(10, 170, 864, 363);
		frame.getContentPane().add(tableAppointmentRecordPanel);
		
		table = new JTable();
		table.setBounds(10, 11, 844, 341);
		tableAppointmentRecordPanel.add(table);
	}

}
