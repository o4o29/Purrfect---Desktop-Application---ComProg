import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class ForgotPassword extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField username_field;
	private JPasswordField password_field;
	private JPasswordField confirmPass_field;

	public ForgotPassword() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new ForgotPassword();
		});
	}


	private void initialize() {
		setTitle("Forgot Password");
		getContentPane().setBackground(new Color(255, 182, 193));
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);
		setSize(563, 411);
        setResizable(false);
        setLocationRelativeTo(null);
        
		JLabel lblNewLabel = new JLabel("PURRFECT");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setBounds(176, 11, 190, 49);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Veterinary Clinic Management System");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(67, 55, 428, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblForgotPassword = new JLabel("FORGOT PASSWORD?");
		lblForgotPassword.setForeground(new Color(255, 20, 147));
		lblForgotPassword.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblForgotPassword.setBounds(176, 93, 202, 56);
		getContentPane().add(lblForgotPassword);
		
		JPanel LoginForgotPassPanel = new JPanel();
		LoginForgotPassPanel.setLayout(null);
		LoginForgotPassPanel.setBackground(new Color(255, 228, 225));
		LoginForgotPassPanel.setBounds(67, 140, 396, 196);
		getContentPane().add(LoginForgotPassPanel);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnConfirm.setBackground(new Color(255, 182, 193));
		btnConfirm.setBounds(116, 134, 161, 35);
		LoginForgotPassPanel.add(btnConfirm);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Username:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(23, 22, 111, 14);
		LoginForgotPassPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter NEW Password:");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(23, 47, 146, 14);
		LoginForgotPassPanel.add(lblNewLabel_3);
		
		username_field = new JTextField();
		username_field.setColumns(10);
		username_field.setBounds(186, 21, 186, 20);
		LoginForgotPassPanel.add(username_field);
		
		password_field = new JPasswordField();
		password_field.setBounds(186, 46, 186, 20);
		LoginForgotPassPanel.add(password_field);
		
		JLabel lblNewLabel_3_1 = new JLabel("Confirm NEW Password:");
		lblNewLabel_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(23, 72, 161, 14);
		LoginForgotPassPanel.add(lblNewLabel_3_1);
		
		confirmPass_field = new JPasswordField();
		confirmPass_field.setBounds(186, 71, 186, 20);
		LoginForgotPassPanel.add(confirmPass_field);
		
		JCheckBox showPass_checkbox = new JCheckBox("Show Password");
		showPass_checkbox.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		showPass_checkbox.setBackground(new Color(255, 228, 225));
		showPass_checkbox.setBounds(257, 98, 133, 23);
		LoginForgotPassPanel.add(showPass_checkbox);
		
		
		// LISTENERS
		btnConfirm.addActionListener(e -> {
		    String username = username_field.getText();
		    String newPassword = new String(password_field.getPassword());
		    String confirmNewPassword = new String(confirmPass_field.getPassword());

		    if (username.isEmpty() || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if (!newPassword.equals(confirmNewPassword)) {
		        JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    try {
		        DatabaseManager dbManager = DatabaseManager.getInstance();
		        if (!dbManager.doesAdminExist(username)) {
		            JOptionPane.showMessageDialog(null, "Username does not exist", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        boolean updated = dbManager.updatePassword(username, newPassword);
		        if (updated) {
		            JOptionPane.showMessageDialog(null, "Password updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		            dispose();
		            new loginWall();
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to update password", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		});
		
		showPass_checkbox.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            password_field.setEchoChar((char) 0);
		            confirmPass_field.setEchoChar((char) 0);
		        } else {
		            password_field.setEchoChar('\u2022');
		            confirmPass_field.setEchoChar('\u2022');
		        }
		    }
		});
		
	}
}