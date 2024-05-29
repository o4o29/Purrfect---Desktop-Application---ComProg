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
		
		JLabel btnAppointment = new JLabel("APPOINTMENT");
		btnAppointment.setBounds(193, 62, 532, 75);
		btnAppointment.setForeground(Color.WHITE);
		btnAppointment.setFont(new Font("Verdana", Font.BOLD, 60));
		getContentPane().add(btnAppointment);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 199, 508, 149);
		panel.setBackground(new Color(255, 182, 193));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Pet ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 36, 166, 19);
		panel.add(lblNewLabel);
		
		petID_Field = new JTextField();
		petID_Field.setBounds(216, 32, 240, 35);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		JButton createAppointBtn = new JButton("Create Appointment");
		createAppointBtn.setFont(new Font("Verdana", Font.PLAIN, 16));
		createAppointBtn.setBounds(152, 83, 202, 40);
		panel.add(createAppointBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(186, 376, 508, 149);
		panel_1.setBackground(new Color(255, 182, 193));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewClientRegister = new JLabel("New Client? Register your Client Information.");
		lblNewClientRegister.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewClientRegister.setBounds(25, 37, 473, 19);
		panel_1.add(lblNewClientRegister);
		
		JButton registerClientBtn = new JButton("Register Client");
		registerClientBtn.setFont(new Font("Verdana", Font.PLAIN, 16));
		registerClientBtn.setBounds(154, 78, 202, 40);
		panel_1.add(registerClientBtn);
		
		JLabel lblCreate = new JLabel("CREATE");
		lblCreate.setBounds(369, 11, 151, 75);
		lblCreate.setForeground(Color.WHITE);
		lblCreate.setFont(new Font("Verdana", Font.BOLD, 30));
		getContentPane().add(lblCreate);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(0, 0, 884, 167);
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