import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

public class progressBar {
    public static void main(String[] args) {
      
        
        
        Image img1 = new ImageIcon(loginWall.class.getResource("logo_purrfect.png")).getImage();
        JFrame frmPurrfectSplash = new JFrame("Veterinary Clinic Management System");
        frmPurrfectSplash.setTitle("PURRFECT | Splash Screen");
        frmPurrfectSplash.getContentPane().setBackground(new Color(255, 228, 225));
        frmPurrfectSplash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPurrfectSplash.setSize(750, 600);
        frmPurrfectSplash.setResizable(false);
        frmPurrfectSplash.getContentPane().setLayout(null);
        frmPurrfectSplash.setLocationRelativeTo(null);
        
        Point originalLocation = frmPurrfectSplash.getLocation();
        frmPurrfectSplash.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
            	frmPurrfectSplash.setLocation(originalLocation);
            }
        });
        
        JPanel progressBarPanel = new JPanel();
        progressBarPanel.setBackground(new Color(255, 228, 225));
        progressBarPanel.setLayout(null);
        progressBarPanel.setBounds(116, 356, 465, 56);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(new Color(255, 182, 193));
        progressBar.setStringPainted(true);
        progressBar.setBounds(23, 11, 432, 26);
        progressBarPanel.add(progressBar);
        frmPurrfectSplash.getContentPane().add(progressBarPanel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 228, 225));
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(116, 424, 465, 49);
        
	    JButton startButton = new JButton("Start Application");
	    startButton.setBackground(Color.PINK);
	    startButton.setForeground(Color.BLACK);
	    startButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    startButton.setBounds(38, 11, 172, 30);
	    buttonPanel.add(startButton);
	    
        JButton exitButton = new JButton("Exit Application");
        exitButton.setBackground(Color.PINK);
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        exitButton.setBounds(271, 11, 172, 30);
        buttonPanel.add(exitButton);
        frmPurrfectSplash.getContentPane().add(buttonPanel);
        
        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon(img1));
        logo.setBounds(264, 139, 317, 180);
        frmPurrfectSplash.getContentPane().add(logo);
                
        JLabel lblNewLabel = new JLabel("Loading Progress...");
        lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        lblNewLabel.setBounds(285, 318, 154, 27);
        frmPurrfectSplash.getContentPane().add(lblNewLabel);

        JLabel lblVersion = new JLabel("Version 1.0");
        lblVersion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblVersion.setBounds(659, 11, 65, 27);
        frmPurrfectSplash.getContentPane().add(lblVersion);

        JLabel lblAllRights = new JLabel("© All Rights Reserved");
        lblAllRights.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblAllRights.setBounds(298, 523, 135, 27);
        frmPurrfectSplash.getContentPane().add(lblAllRights);

        JLabel lblNewLabel_1_1 = new JLabel("Veterinary Clinic Management System\r\n");
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        lblNewLabel_1_1.setBackground(new Color(255, 20, 147));
        lblNewLabel_1_1.setBounds(131, 97, 479, 40);
        frmPurrfectSplash.getContentPane().add(lblNewLabel_1_1);

        JLabel title = new JLabel("PURRFECT");
        title.setForeground(new Color(255, 20, 147));
        title.setBackground(new Color(255, 51, 255));
        title.setFont(new Font("Century Gothic", Font.BOLD, 70));
        title.setBounds(207, 11, 335, 100);
        frmPurrfectSplash.getContentPane().add(title);
        
        frmPurrfectSplash.setVisible(true);
      
	    startButton.addActionListener(e -> {
	        Thread thread = new Thread(() -> {
	
	            try {
	                updateProgressBar(progressBar, 10);
	                updateProgressBar(progressBar, 30);
	                updateProgressBar(progressBar, 60);
	                updateProgressBar(progressBar, 75);
	                updateProgressBar(progressBar, 100);
	                
	                DatabaseManager.getInstance();
	                System.out.println("Database Connected eaheahaew");
	            } catch (SQLException ex) {
	                JOptionPane.showMessageDialog(frmPurrfectSplash, "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                updateProgressBar(progressBar, 0); // Reset progress on error
	                return;
	            }
	
	            SwingUtilities.invokeLater(() -> {
	                frmPurrfectSplash.dispose();
	                new loginWall();
	            });
	        });
	        thread.start();
	    });
	    
	    exitButton.addActionListener(e -> {
	        frmPurrfectSplash.dispose();
	    });

    }

    
    private static void updateProgressBar(JProgressBar progressBar, int value) {
        SwingUtilities.invokeLater(() -> progressBar.setValue(value));
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
