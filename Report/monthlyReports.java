import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;

public class monthlyReports {

	private JFrame frame;
	private JTable table;
	private JTable table_1;



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 713, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMonthlyReport = new JLabel("MONTHLY REPORT");
		lblMonthlyReport.setForeground(Color.WHITE);
		lblMonthlyReport.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblMonthlyReport.setBounds(207, -14, 293, 75);
		frame.getContentPane().add(lblMonthlyReport);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 697, 56);
		frame.getContentPane().add(textArea_1);
		
		table = new JTable();
		table.setBounds(27, 86, 1, 1);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(27, 69, 622, 263);
		frame.getContentPane().add(table_1);
		
		JButton btnBack = new JButton("BACK TO DASHBOARD");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(227, 351, 202, 23);
		frame.getContentPane().add(btnBack);
		
		
		// BUTTON LISTENERS
		btnBack.addActionListener(e -> {
        	frame.dispose();
        	new Dashboard();
        });
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
    		new monthlyReports();
        });
	}

	public monthlyReports() {
		initialize();
		frame.setVisible(true);
	}
}
