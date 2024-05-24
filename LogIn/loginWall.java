import javax.swing.*;
import java.awt.*;

public class loginWall extends JFrame {
   
    private static final long serialVersionUID = 1L;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField txtAdminID;
    private JTextField txtPassword;

    private void initialize() {
        setTitle("Paws and Claws VCMS - LogIn Wall");
        setSize(713, 436); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        
        JPanel LogInPanel = new JPanel();
        LogInPanel.setBackground(new Color(255, 228, 225));
        LogInPanel.setLayout(null);
        
        getContentPane().add(LogInPanel);
        
        
        JLabel lblNewLabel = new JLabel("PURRFECT");
        lblNewLabel.setForeground(new Color(255, 20, 147));
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 39));
        lblNewLabel.setBounds(226, 11, 244, 49);
        LogInPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Veterinary Clinic Management System");
        lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(147, 57, 428, 27);
        
        
        
        JLabel lblNewLabel_3 = new JLabel("ADMIN LOGIN WALL");
        lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 15));
        lblNewLabel_3.setBounds(380, 88, 198, 54);
        LogInPanel.add(lblNewLabel_3);
        
        JLabel AdminPicture = new JLabel("");
        Image img3 = new ImageIcon(loginWall.class.getResource("adminpic.png")).getImage();
        AdminPicture.setIcon(new ImageIcon(img3));
        AdminPicture.setBounds(447, 141, 57, 49);
        LogInPanel.add(AdminPicture);
        
        JPanel AdminPassPanel = new JPanel();
        AdminPassPanel.setBackground(new Color(255, 228, 225));
        AdminPassPanel.setBounds(325, 198, 299, 81);
        LogInPanel.add(AdminPassPanel);
        AdminPassPanel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Admin ID:");
        lblNewLabel_2.setBounds(10, 11, 105, 23);
        AdminPassPanel.add(lblNewLabel_2);
        
        lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
        
        txtAdminID = new JTextField();
        txtAdminID.setBounds(82, 14, 207, 20);
        AdminPassPanel.add(txtAdminID);
        txtAdminID.setColumns(10);
        
        JLabel lblNewLabel_2_1 = new JLabel("Password:");
        lblNewLabel_2_1.setBounds(10, 47, 105, 23);
        AdminPassPanel.add(lblNewLabel_2_1);
        lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 13));
        
        txtPassword = new JTextField();
        txtPassword.setBounds(82, 50, 207, 20);
        AdminPassPanel.add(txtPassword);
        txtPassword.setColumns(10);
        
        JPanel LoginForgotPassPanel = new JPanel();
        LoginForgotPassPanel.setBackground(new Color(255, 228, 225));
        LoginForgotPassPanel.setBounds(325, 290, 299, 73);
        LogInPanel.add(LoginForgotPassPanel);
        LoginForgotPassPanel.setLayout(null);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(110, 11, 82, 23);
        LoginForgotPassPanel.add(btnLogin);
        buttonGroup.add(btnLogin);
        btnLogin.setBackground(new Color(255, 182, 193));
        btnLogin.setFont(new Font("Verdana", Font.PLAIN, 13));
        
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Verdana", Font.PLAIN, 13));
        btnExit.setBackground(new Color(255, 182, 193));
        btnExit.setBounds(110, 39, 82, 23);
        LoginForgotPassPanel.add(btnExit);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 182, 193));
        panel.setBounds(317, 190, 314, 96);
        LogInPanel.add(panel);
        
        JLabel logo = new JLabel("");
        Image img = new ImageIcon(loginWall.class.getResource("logo_purrfect_big.png")).getImage();
        logo.setIcon(new ImageIcon(img));

        logo.setBounds(10, 88, 299, 298);
        LogInPanel.add(logo);
        
        
        // BUTTON LISTENERS
        btnLogin.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Login successful!");
            
            SwingUtilities.invokeLater(() -> {
            	this.dispose();
            	new Dashboard();   
            });
        });
        
        btnExit.addActionListener(e -> {
        	this.dispose();
        });
    }

    public loginWall() {
    	initialize();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
    		new loginWall();
        });
    }
}
