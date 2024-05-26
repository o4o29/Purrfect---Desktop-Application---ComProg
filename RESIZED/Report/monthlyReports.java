
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;

public class monthlyReports {

	private JFrame frame;
	private JTable table;
	private JPanel headerPanel;
	private JLabel lblMonthlyReports;
	private JPanel mainPanel;



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(27, 86, 1, 1);
		frame.getContentPane().add(table);
		
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 182, 193));
		headerPanel.setBounds(0, 0,884, 153);
		frame.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		lblMonthlyReports = new JLabel("MONTHLY REPORTS");
		lblMonthlyReports.setBounds(86, 39, 687, 74);
		lblMonthlyReports.setForeground(Color.WHITE);
		lblMonthlyReports.setFont(new Font("Verdana", Font.BOLD, 60));
		headerPanel.add(lblMonthlyReports);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(10, 198, 864, 338);
		frame.getContentPane().add(mainPanel);
		
		
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
