import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class treatmentFirst {

    private JFrame frame;
    private JTextField appointmentID_Field;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    treatmentFirst window = new treatmentFirst();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public treatmentFirst() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Frame setup
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
        frame.getContentPane().setBackground(new Color(255, 228, 225));
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Header label
        JLabel lblSearchAppointment = new JLabel("TREATMENT");
        lblSearchAppointment.setForeground(Color.WHITE);
        lblSearchAppointment.setFont(new Font("Verdana", Font.BOLD, 50));
        lblSearchAppointment.setBounds(285, 31, 351, 75);
        frame.getContentPane().add(lblSearchAppointment);

        // Header background area
        JTextArea header = new JTextArea();
        header.setEnabled(false);
        header.setEditable(false);
        header.setBackground(new Color(255, 182, 193));
        header.setBounds(0, 0, 884, 134);
        frame.getContentPane().add(header);

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(255, 182, 193));
        mainPanel.setBounds(149, 176, 591, 353);
        frame.getContentPane().add(mainPanel);

        // Search Appointment ID panel setup
        JPanel searchAppID_Panel = new JPanel();
        searchAppID_Panel.setLayout(null);
        searchAppID_Panel.setBackground(new Color(255, 228, 225));
        searchAppID_Panel.setBounds(175, 67, 244, 115);
        mainPanel.add(searchAppID_Panel);

        // Search button
        JButton search_Btn = new JButton("SEARCH");
        search_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        search_Btn.setBackground(new Color(255, 240, 245));
        search_Btn.setBounds(71, 79, 101, 25);
        searchAppID_Panel.add(search_Btn);

        // Enter Appointment ID label
        JLabel lblEnterAppointmentId = new JLabel("Enter Appointment ID");
        lblEnterAppointmentId.setFont(new Font("Verdana", Font.BOLD, 15));
        lblEnterAppointmentId.setBounds(33, 21, 180, 14);
        searchAppID_Panel.add(lblEnterAppointmentId);

        // Appointment ID text field
        appointmentID_Field = new JTextField();
        appointmentID_Field.setBounds(53, 46, 140, 20);
        searchAppID_Panel.add(appointmentID_Field);
        appointmentID_Field.setColumns(10);

        // Appointment ID label in the main panel
        JLabel lblNewLabel_1_1_1 = new JLabel("APPOINTMENT ID");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
        lblNewLabel_1_1_1.setBounds(196, 11, 209, 61);
        mainPanel.add(lblNewLabel_1_1_1);

        // Appointment panel setup
        JPanel appointPanel = new JPanel();
        appointPanel.setLayout(null);
        appointPanel.setBackground(new Color(255, 228, 225));
        appointPanel.setBounds(79, 218, 432, 102);
        mainPanel.add(appointPanel);

        // Create Appointment button
        JButton createAppointment_Btn = new JButton("CREATE APPOINTMENT");
        createAppointment_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        createAppointment_Btn.setBackground(new Color(255, 240, 245));
        createAppointment_Btn.setBounds(109, 46, 225, 25);
        appointPanel.add(createAppointment_Btn);

        // No Appointment ID label
        JLabel lblNewLabel_1_1_1_1 = new JLabel("No Appointment ID? Go to Appointment.");
        lblNewLabel_1_1_1_1.setBounds(47, 0, 339, 61);
        appointPanel.add(lblNewLabel_1_1_1_1);
        lblNewLabel_1_1_1_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
    }
}
