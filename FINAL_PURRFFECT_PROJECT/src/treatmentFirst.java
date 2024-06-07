import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class treatmentFirst extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField appointmentID_Field;
    private JFrame dashboardFrame;

    private void initialize() {
        getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 11));
        getContentPane().setBackground(new Color(255, 228, 225));
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setLayout(null);

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(255, 182, 193));
        mainPanel.setBounds(67, 135, 447, 283);
        getContentPane().add(mainPanel);

        // Search Appointment ID panel setup
        JPanel searchAppID_Panel = new JPanel();
        searchAppID_Panel.setLayout(null);
        searchAppID_Panel.setBackground(new Color(255, 228, 225));
        searchAppID_Panel.setBounds(117, 97, 214, 71);
        mainPanel.add(searchAppID_Panel);

        // Search button
        JButton search_Btn = new JButton("");
        search_Btn.setBorderPainted(false);
        search_Btn.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\arrow.png"));
        search_Btn.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        search_Btn.setBackground(new Color(255, 228, 225));
        search_Btn.setBounds(160, 31, 27, 25);
        searchAppID_Panel.add(search_Btn);

        // Enter Appointment ID label
        JLabel lblEnterAppointmentId = new JLabel("Enter Appointment ID");
        lblEnterAppointmentId.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblEnterAppointmentId.setBounds(31, 11, 162, 14);
        searchAppID_Panel.add(lblEnterAppointmentId);

        // Appointment ID text field
        appointmentID_Field = new JTextField();
        appointmentID_Field.setBounds(44, 36, 115, 20);
        searchAppID_Panel.add(appointmentID_Field);
        appointmentID_Field.setColumns(10);

        // Appointment panel setup
        JPanel appointPanel = new JPanel();
        appointPanel.setLayout(null);
        appointPanel.setBackground(new Color(255, 228, 225));
        appointPanel.setBounds(66, 179, 314, 81);
        mainPanel.add(appointPanel);

        // Create Appointment button
        JButton createAppointment_Btn = new JButton("CREATE APPOINTMENT");
        createAppointment_Btn.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\arrow.png"));
        createAppointment_Btn.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        createAppointment_Btn.setBackground(new Color(255, 240, 245));
        createAppointment_Btn.setBounds(46, 45, 225, 25);
        appointPanel.add(createAppointment_Btn);

        // No Appointment ID label
        JLabel lblNewLabel_1_1_1_1 = new JLabel("No Appointment ID? Go to Appointment.");
        lblNewLabel_1_1_1_1.setBounds(10, 0, 339, 50);
        appointPanel.add(lblNewLabel_1_1_1_1);
        lblNewLabel_1_1_1_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
        
                // Appointment ID label in the main panel
                JLabel lblNewLabel_1_1_1 = new JLabel("TREATMENT MANAGEMENT");
                lblNewLabel_1_1_1.setBounds(94, 0, 261, 61);
                mainPanel.add(lblNewLabel_1_1_1);
                lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
                lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
                
                JLabel lblYouNeedAn = new JLabel("You need an appointment ID to access the treatment service.");
                lblYouNeedAn.setFont(new Font("Century Gothic", Font.ITALIC, 13));
                lblYouNeedAn.setBounds(21, 47, 426, 14);
                mainPanel.add(lblYouNeedAn);
        
        JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
        lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
        lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 40));
        lblNewLabel_2_2.setBounds(199, -13, 246, 75);
        getContentPane().add(lblNewLabel_2_2);
                
                JLabel lblClientInformationresult = new JLabel("Veterinary Clinic Management System");
                lblClientInformationresult.setForeground(new Color(255, 20, 147));
                lblClientInformationresult.setFont(new Font("Century Gothic", Font.BOLD, 24));
                lblClientInformationresult.setBounds(57, 25, 464, 75);
                getContentPane().add(lblClientInformationresult);
                
                        // Header background area
                        JTextArea header = new JTextArea();
                        header.setEnabled(false);
                        header.setEditable(false);
                        header.setBackground(new Color(255, 182, 193));
                        header.setBounds(0, 0, 584, 90);
                        getContentPane().add(header);
        
        
        // LISTENERS
        addWindowListener(new WindowAdapter() { // exiting window
            public void windowClosing(WindowEvent e) {
                if (dashboardFrame != null) {
                    dashboardFrame.setEnabled(true);
                }
                dispose();
            }
        });
        
        createAppointment_Btn.addActionListener(e -> {
        	Appointment appointmentFrame = new Appointment();
        	
        	appointmentFrame.setDashboardFrame(dashboardFrame);
        	this.dispose();
        });
        
        search_Btn.addActionListener(e -> {
        	try {
        		DatabaseManager dbManager = DatabaseManager.getInstance();
            	
           	    int appointmentID = Integer.parseInt(appointmentID_Field.getText());
                boolean appointmentExists = dbManager.doesAppointmentExist(appointmentID);
                
                if (appointmentExists) {
                    Treatment.getAppointmentId(appointmentID, dashboardFrame);
                } else {
                	JOptionPane.showMessageDialog(this, "Appointment ID not valid", "Error", JOptionPane.ERROR_MESSAGE);
                }
        	} catch (SQLException | NumberFormatException ex) {
        		ex.printStackTrace();
        		JOptionPane.showMessageDialog(this, "Appointment not found", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        });
    }
    
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }

    public treatmentFirst() {
    	setTitle("Treatment Management");
        initialize();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	new treatmentFirst();
        });
    }
}