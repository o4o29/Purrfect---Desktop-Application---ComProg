import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

public class progressBar {
    public static void main(String[] args) {
        JFrame frmPurrfectSplash = new JFrame("Veterinary Clinic Management System");
        frmPurrfectSplash.setTitle("PURRFECT | Splash Screen");
        frmPurrfectSplash.getContentPane().setBackground(new Color(255, 228, 225));
        frmPurrfectSplash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPurrfectSplash.setSize(713, 436);
        frmPurrfectSplash.setResizable(false);
        frmPurrfectSplash.getContentPane().setLayout(null);
        frmPurrfectSplash.setLocationRelativeTo(null);
        
        Point originalLocation = frmPurrfectSplash.getLocation();
        frmPurrfectSplash.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
            	frmPurrfectSplash.setLocation(originalLocation);
            }
        });
        
        // Create the progress bar panel
        JPanel progressBarPanel = new JPanel();
        progressBarPanel.setBackground(new Color(255, 228, 225));
        progressBarPanel.setLayout(null); // Use null layout manager
        progressBarPanel.setBounds(116, 207, 465, 56); // Set position and size
        frmPurrfectSplash.getContentPane().add(progressBarPanel);

        // Create the progress bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(new Color(255, 182, 193));
        progressBar.setStringPainted(true); // Displays the progress percentage
        progressBar.setBounds(23, 11, 432, 26); // Set position and size of the progress bar
        progressBarPanel.add(progressBar);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 228, 225));
        buttonPanel.setLayout(null); // Use null layout manager
        buttonPanel.setBounds(116, 265, 465, 49); // Set position and size
        frmPurrfectSplash.getContentPane().add(buttonPanel);

        // Create the start button
        JButton startButton = new JButton("Start Application");
        startButton.setBackground(Color.PINK);
        startButton.setForeground(Color.BLACK);
        startButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        startButton.setBounds(50, 11, 172, 30); // Set position and size of the button
        buttonPanel.add(startButton);

        // Create the exit button
        JButton exitButton = new JButton("Exit Application");
        exitButton.setBackground(Color.PINK);
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        exitButton.setBounds(280, 11, 172, 30); // Set position and size of the button
        buttonPanel.add(exitButton);

        JLabel lblNewLabel = new JLabel("Loading Progress...");
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        lblNewLabel.setBounds(280, 178, 172, 27);
        frmPurrfectSplash.getContentPane().add(lblNewLabel);

        JLabel lblVersion = new JLabel("Version 1.0");
        lblVersion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblVersion.setBounds(622, 11, 65, 27);
        frmPurrfectSplash.getContentPane().add(lblVersion);

        JLabel lblAllRights = new JLabel("© All Rights Reserved");
        lblAllRights.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblAllRights.setBounds(292, 358, 135, 27);
        frmPurrfectSplash.getContentPane().add(lblAllRights);

        JLabel logo = new JLabel("");
        Image img1 = new ImageIcon(loginWall.class.getResource("logo_purrfect.png")).getImage();
        logo.setIcon(new ImageIcon(img1));
        logo.setBounds(0, 11, 214, 185);
        frmPurrfectSplash.getContentPane().add(logo);

        JLabel lblNewLabel_1 = new JLabel("PURRFECT");
        lblNewLabel_1.setForeground(new Color(255, 20, 147));
        lblNewLabel_1.setBackground(new Color(255, 20, 147));
        lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 60));
        lblNewLabel_1.setBounds(241, 25, 379, 100);
        frmPurrfectSplash.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Veterinary Clinic Management System\r\n");
        lblNewLabel_1_1.setForeground(new Color(255, 20, 147));
        lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 25));
        lblNewLabel_1_1.setBackground(new Color(255, 20, 147));
        lblNewLabel_1_1.setBounds(185, 111, 490, 40);
        frmPurrfectSplash.getContentPane().add(lblNewLabel_1_1);

        frmPurrfectSplash.setVisible(true);


        startButton.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                updateProgressBar(progressBar, 10);
                updateProgressBar(progressBar, 30);

                try {
                    DatabaseManager.getInstance();
                    updateProgressBar(progressBar, 60);
                    System.out.println("Database Connected eaheahaew");
                } catch (SQLException ex) {
                    updateProgressBar(progressBar, 0); // Reset progress on error
                    JOptionPane.showMessageDialog(frmPurrfectSplash, "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                updateProgressBar(progressBar, 75);
                updateProgressBar(progressBar, 100);

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