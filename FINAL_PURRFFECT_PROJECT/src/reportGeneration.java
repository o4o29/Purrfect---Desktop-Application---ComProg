import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class reportGeneration extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFrame dashboardFrame;
	private JButton btnClientInformation, btnPetInformation, btnAppointments, btnTreatments, btnPrescription;

	private void initialize() {
		setTitle("Report Generation");
		getContentPane().setBackground(new Color(255, 182, 193));
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
		
		JLabel title = new JLabel("PURRFECT");
		title.setForeground(new Color(255, 20, 147));
		title.setFont(new Font("Century Gothic", Font.BOLD, 55));
		title.setBackground(new Color(255, 240, 245));
		title.setBounds(222, 0, 262, 100);
		getContentPane().add(title);
		
		JLabel lblNewLabel_1_1 = new JLabel("Veterinary Clinic Management System\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1.setBounds(119, 70, 479, 40);
		getContentPane().add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(22, 133, 639, 298);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Report Generation");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1_1.setBounds(236, 0, 189, 40);
		panel.add(lblNewLabel_1_1_1);
		
		btnClientInformation = new JButton("CLIENT INFORMATION");
		btnClientInformation.setBounds(22, 64, 197, 23);
		
		panel.add(btnClientInformation);
		
		btnPetInformation = new JButton("PET INFORMATION");
		btnPetInformation.setBounds(228, 64, 197, 23);
		panel.add(btnPetInformation);
		
		btnAppointments = new JButton("APPOINTMENTS\r\n\r\n");
		btnAppointments.setBounds(22, 101, 197, 23);
		panel.add(btnAppointments);
		
		btnTreatments = new JButton("TREATMENTS");
		btnTreatments.setBounds(228, 98, 197, 23);
		panel.add(btnTreatments);
		
		btnPrescription = new JButton("PRESCRIPTION");
		btnPrescription.setBounds(432, 98, 197, 23);
		panel.add(btnPrescription);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("temporary lang button muna");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBackground(new Color(255, 20, 147));
		lblNewLabel_1_1_1_1.setBounds(171, 182, 341, 40);
		panel.add(lblNewLabel_1_1_1_1);
		
        btnClientInformation.addActionListener(this);
        btnPetInformation.addActionListener(this);
        btnAppointments.addActionListener(this);
        btnTreatments.addActionListener(this);
        btnPrescription.addActionListener(this);
		// LISTENERS
        addWindowListener(new WindowAdapter() { // exiting window
            public void windowClosing(WindowEvent e) {
                if (dashboardFrame != null) {
                    dashboardFrame.setEnabled(true);
                }
                dispose();
            }
        });
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnClientInformation)) {
			new reportClientInfo();
	    }

		if(e.getSource().equals(btnPetInformation)) {
			new reportPetInfo();
		}	

		if(e.getSource().equals(btnAppointments)) {
			new reportAppointment();
		}	

		if(e.getSource().equals(btnTreatments)) {
			new reportTreatment();
		}

		if(e.getSource().equals(btnPrescription)) {
			new reportPrescription();
		}		
	 }
	
	
	
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }
    
	public reportGeneration() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new reportGeneration();
		});
	}
}
