

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSet;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import java.sql.SQLException;
	public class resultClientInformation {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_2;
	private JTable table_1;




	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBackground(new Color(255, 228, 225));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 713, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClientInformation = new JLabel("CLIENT INFORMATION");
		lblClientInformation.setForeground(Color.WHITE);
		lblClientInformation.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblClientInformation.setBounds(51, 11, 581, 75);
		frame.getContentPane().add(lblClientInformation);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(229, 127, 253, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 12, 86, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(98, 11, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnBack.setBounds(22, 363, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnPrint.setBounds(580, 193, 89, 23);
		frame.getContentPane().add(btnPrint);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEdit.setBounds(580, 228, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.setBounds(580, 262, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnAddPet = new JButton("ADD PET");
		btnAddPet.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAddPet.setBounds(580, 300, 89, 23);
		frame.getContentPane().add(btnAddPet);
		
		JButton btnViewMoreInformation = new JButton("View More Information");
		btnViewMoreInformation.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnViewMoreInformation.setBounds(488, 363, 181, 23);
		frame.getContentPane().add(btnViewMoreInformation);
		
		table = new JTable();
		table.setBounds(76, 303, 0, 0);
		frame.getContentPane().add(table);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_2.setBounds(37, 298, 516, 54);
		frame.getContentPane().add(table_2);
		
		JLabel lblresult = new JLabel("(Result)");
		lblresult.setBackground(new Color(240, 240, 240));
		lblresult.setForeground(Color.WHITE);
		lblresult.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lblresult.setBounds(298, 62, 78, 54);
		frame.getContentPane().add(lblresult);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 697, 116);
		frame.getContentPane().add(textArea);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_1.setEnabled(false);
		table_1.setBounds(37, 199, 516, 54);
		frame.getContentPane().add(table_1);
		
		
		// BUTTON LISTENERS
		btnBack.addActionListener(e -> {
			frame.dispose();
			new searchClientAndPet();
		});
		
		btnAddPet.addActionListener(e -> {
			frame.dispose();
			new createPetInformation();
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new resultClientInformation();
		});
	}

	public resultClientInformation() {
		initialize();
		frame.setVisible(true);
	}
	
	public void populateTable(ResultSet resultSet) throws SQLException {
        table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
	
}
