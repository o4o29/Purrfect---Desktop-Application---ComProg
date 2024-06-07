import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class Appointment extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField petID_Field;
	private JFrame dashboardFrame;
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setBounds(57, 434, 777, 104);
		getContentPane().add(panel_2);
		
		JLabel lblViewExistingAppointments = new JLabel("View Appointment Records");
		lblViewExistingAppointments.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblViewExistingAppointments.setBounds(268, 23, 211, 19);
		panel_2.add(lblViewExistingAppointments);
		
		JButton btnAppointments = new JButton("Appointment Record");
		btnAppointments.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAppointments.setBounds(277, 53, 202, 40);
		panel_2.add(btnAppointments);
		
		JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
		lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 60));
		lblNewLabel_2_2.setBounds(259, -36, 634, 156);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewAppointment = new JLabel("NEW APPOINTMENT");
		lblNewAppointment.setForeground(Color.WHITE);
		lblNewAppointment.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewAppointment.setBounds(227, 60, 777, 96);
		getContentPane().add(lblNewAppointment);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(43, 0, 884, 156);
		getContentPane().add(textArea);
		
		JLabel btnAppointment = new JLabel("APPOINTMENT");
		btnAppointment.setBounds(193, 62, 532, 75);
		btnAppointment.setForeground(Color.WHITE);
		btnAppointment.setFont(new Font("Verdana", Font.BOLD, 60));
		getContentPane().add(btnAppointment);
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 187, 777, 96);
		panel.setBackground(new Color(255, 182, 193));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Pet ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(116, 53, 166, 19);
		panel.add(lblNewLabel);
		
		petID_Field = new JTextField();
		petID_Field.setBounds(218, 52, 240, 25);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		JButton createAppointBtn = new JButton("Create Appointment");
		createAppointBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
		createAppointBtn.setBounds(474, 42, 202, 40);
		panel.add(createAppointBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(57, 308, 777, 104);
		panel_1.setBackground(new Color(255, 182, 193));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewClientRegister = new JLabel("New Client? Register your Client Information.");
		lblNewClientRegister.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewClientRegister.setBounds(208, 25, 347, 19);
		panel_1.add(lblNewClientRegister);
		
		JButton registerClientBtn = new JButton("Register Client");
		registerClientBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
		registerClientBtn.setBounds(275, 53, 202, 40);
		panel_1.add(registerClientBtn);
		
		JLabel lblCreate = new JLabel("CREATE");
		lblCreate.setBounds(369, 11, 151, 75);
		lblCreate.setForeground(Color.WHITE);
		lblCreate.setFont(new Font("Verdana", Font.BOLD, 30));
		getContentPane().add(lblCreate);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(0, 0, 884, 156);
		textArea_1.setBackground(new Color(255, 182, 193));
		getContentPane().add(textArea_1);
		
		
		// LISTENERS
        addWindowListener(new WindowAdapter() { // exiting window
            public void windowClosing(WindowEvent e) {
                if (dashboardFrame != null) {
                    dashboardFrame.setEnabled(true);
                }
                dispose();
            }
        });
        
		registerClientBtn.addActionListener(e -> { // create new client
			new createClientInformation();
		});
		
		createAppointBtn.addActionListener(e -> { // creating appointment
            try {
                int petId = Integer.parseInt(petID_Field.getText());
                DatabaseManager dbManager = DatabaseManager.getInstance();
                boolean petExists = dbManager.doesPetExist(petId);

                if (petExists) {
                	appointmentCreate.getPetInformation(petId);
                } else {
                    JOptionPane.showMessageDialog(this, "Pet not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex + " Please enter a valid pet ID", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while searching for the pet", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            petID_Field.setText("");
		});
		
		btnAppointments.addActionListener(e -> {
			new appointmentRecords();
		});
	}
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	
	public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }
  
	public Appointment() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Appointment();
		});
	}
}