import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

public class loginWall extends JFrame {
    private static final long serialVersionUID = 1L;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField userName_Field;
    private JPasswordField passwordField;

    private void initialize() {
        setTitle("Login");
        setSize(563, 411);
        setResizable(false);
        setLocationRelativeTo(null);

        Point originalLocation = getLocation();
        addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                setLocation(originalLocation);
            }
        });

        JPanel LogInPanel = new JPanel();
        LogInPanel.setBackground(new Color(255, 182, 193));
        LogInPanel.setLayout(null);
        getContentPane().add(LogInPanel);

        JLabel lblNewLabel = new JLabel("PURRFECT");
        lblNewLabel.setForeground(new Color(255, 20, 147));
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
        lblNewLabel.setBounds(177, 24, 190, 49);
        LogInPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Veterinary Clinic Management System");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(64, 68, 428, 27);
        LogInPanel.add(lblNewLabel_1);

        JPanel LoginForgotPassPanel = new JPanel();
        LoginForgotPassPanel.setBackground(new Color(255, 228, 225));
        LoginForgotPassPanel.setBounds(101, 132, 324, 147);
        LogInPanel.add(LoginForgotPassPanel);
        LoginForgotPassPanel.setLayout(null);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(56, 92, 105, 35);
        LoginForgotPassPanel.add(btnLogin);
        buttonGroup.add(btnLogin);
        btnLogin.setBackground(new Color(255, 182, 193));
        btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 13));

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(171, 92, 105, 35);
        LoginForgotPassPanel.add(btnExit);
        btnExit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        btnExit.setBackground(new Color(255, 182, 193));

        JLabel lblNewLabel_2 = new JLabel("Username:");
        lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(23, 22, 74, 14);
        LoginForgotPassPanel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(23, 47, 74, 14);
        LoginForgotPassPanel.add(lblNewLabel_3);

        userName_Field = new JTextField();
        userName_Field.setBounds(107, 21, 186, 20);
        LoginForgotPassPanel.add(userName_Field);
        userName_Field.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(107, 48, 186, 20);
        LoginForgotPassPanel.add(passwordField);
        
        JButton btnCreateAccount = new JButton("Sign Up");
        btnCreateAccount.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        btnCreateAccount.setBackground(new Color(255, 182, 193));
        btnCreateAccount.setBounds(101, 290, 158, 35);
        LogInPanel.add(btnCreateAccount);
        
        JButton btnForgotPassword = new JButton("Forgot Password");
        btnForgotPassword.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        btnForgotPassword.setBackground(new Color(255, 182, 193));
        btnForgotPassword.setBounds(269, 290, 156, 35);
        LogInPanel.add(btnForgotPassword);

        // BUTTON LISTENERS
        btnLogin.addActionListener(e -> {
            String username = userName_Field.getText();
            String password = new String(passwordField.getPassword());

            try {
                DatabaseManager dbManager = DatabaseManager.getInstance();
                boolean isValidLogin = dbManager.validateLogin(username, password);

                if (isValidLogin) {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    
                    dispose();
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while processing your request. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExit.addActionListener(e -> {
            dispose();
        });
        
        btnCreateAccount.addActionListener(e -> {
        	dispose();
        	new SignUp();
        });
        
        btnForgotPassword.addActionListener(e -> {
        	dispose();
        	new ForgotPassword();
        });
    }

    public loginWall() {
        initialize();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new loginWall();
        });
    }
}
