import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class SignUp extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField username_field;
	private JPasswordField password_field;
	private JPasswordField confirmPassword_field;


	private void initialize() {
		setTitle("Sign Up ");
		getContentPane().setBackground(new Color(255, 182, 193));
		setBounds(100, 100, 450, 300);
		setSize(563, 411);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("PURRFECT");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setBounds(181, 11, 190, 49);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Veterinary Clinic Management System");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(66, 53, 428, 27);
		getContentPane().add(lblNewLabel_1);
		
		JPanel LoginForgotPassPanel = new JPanel();
		LoginForgotPassPanel.setLayout(null);
		LoginForgotPassPanel.setBackground(new Color(255, 228, 225));
		LoginForgotPassPanel.setBounds(66, 144, 396, 182);
		getContentPane().add(LoginForgotPassPanel);
		
		JButton btnSaveAccount = new JButton("Save Account");
		btnSaveAccount.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSaveAccount.setBackground(new Color(255, 182, 193));
		btnSaveAccount.setBounds(116, 134, 161, 35);
		LoginForgotPassPanel.add(btnSaveAccount);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Username:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(23, 22, 111, 14);
		LoginForgotPassPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Password:");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(23, 47, 111, 14);
		LoginForgotPassPanel.add(lblNewLabel_3);
		
		username_field = new JTextField();
		username_field.setColumns(10);
		username_field.setBounds(166, 21, 186, 20);
		LoginForgotPassPanel.add(username_field);
		
		password_field = new JPasswordField();
		password_field.setBounds(166, 46, 186, 20);
		LoginForgotPassPanel.add(password_field);
		
		JLabel lblNewLabel_3_1 = new JLabel("Confirm Password:");
		lblNewLabel_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(23, 72, 133, 14);
		LoginForgotPassPanel.add(lblNewLabel_3_1);
		
		confirmPassword_field = new JPasswordField();
		confirmPassword_field.setBounds(166, 71, 186, 20);
		LoginForgotPassPanel.add(confirmPassword_field);
		
		JCheckBox showPass_checkbox = new JCheckBox("Show Password");
		showPass_checkbox.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		showPass_checkbox.setBackground(new Color(255, 228, 225));
		showPass_checkbox.setBounds(236, 98, 133, 23);
		LoginForgotPassPanel.add(showPass_checkbox);
		
		JLabel lblSignUpHere = new JLabel("SIGN UP HERE");
		lblSignUpHere.setForeground(new Color(255, 20, 147));
		lblSignUpHere.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblSignUpHere.setBounds(206, 88, 155, 56);
		getContentPane().add(lblSignUpHere);
		
		
		// LISTENERS
		btnSaveAccount.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String username = username_field.getText();
		        String password = new String(password_field.getPassword());
		        String confirmPassword = new String(confirmPassword_field.getPassword());

		        // Check if any of the fields are empty
		        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
		            JOptionPane.showMessageDialog(SignUp.this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Check if passwords match
		        if (!password.equals(confirmPassword)) {
		            JOptionPane.showMessageDialog(SignUp.this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Get the current date
		        Date created_at = new Date(System.currentTimeMillis());

		        try {
		            DatabaseManager dbManager = DatabaseManager.getInstance();
		            if (dbManager.doesAdminExist(username)) {
		                JOptionPane.showMessageDialog(SignUp.this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            int adminId = dbManager.insertAdmin(username, password, created_at);
		            if (adminId != -1) {
		                JOptionPane.showMessageDialog(SignUp.this, "Admin user created with ID: " + adminId, "Success", JOptionPane.INFORMATION_MESSAGE);
		                dispose();
		                new loginWall();
		            } else {
		                JOptionPane.showMessageDialog(SignUp.this, "Failed to create admin user", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		showPass_checkbox.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            password_field.setEchoChar((char) 0);
		            confirmPassword_field.setEchoChar((char) 0);
		        } else {
		            password_field.setEchoChar('\u2022');
		            confirmPassword_field.setEchoChar('\u2022');
		        }
		    }
		});
	}
	
	
	public SignUp() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SignUp();
		});
	}
}
