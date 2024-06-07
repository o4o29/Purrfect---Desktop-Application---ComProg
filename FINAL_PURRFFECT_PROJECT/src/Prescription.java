import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Prescription extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField petID_Field;
	private JTextField dosage_Field;
	private JTextField drugName_Field;
	private JFrame dashboardFrame;
	private JTextField petIdrs_Field;
	private JTextField drugNamers_Field;
	private JTextField drugDosagers_Field;
	private JTextField durationrs_Field;
	private JTextField timers_Field;
	private JTextField addInstructionsrs_Field;

	
	private void initialize() {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
		getContentPane().setLayout(null);
	    
	    JLabel lblPrescription_1 = new JLabel("PRESCRIPTION");
	    lblPrescription_1.setForeground(Color.WHITE);
	    lblPrescription_1.setFont(new Font("Verdana", Font.BOLD, 35));
	    lblPrescription_1.setBounds(283, 56, 777, 75);
	    getContentPane().add(lblPrescription_1);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
	    lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
	    lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 60));
	    lblNewLabel_2_2.setBounds(261, 3, 634, 75);
	    getContentPane().add(lblNewLabel_2_2);
	    
	    JTextArea textArea = new JTextArea();
	    textArea.setEditable(false);
	    textArea.setBackground(new Color(255, 182, 193));
	    textArea.setBounds(0, 0, 884, 114);
	    getContentPane().add(textArea);
				    
				    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prescription", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(250, 128, 114)));
	    panel_1.setBackground(new Color(255, 239, 213));
	    panel_1.setBounds(447, 123, 400, 372);
	    getContentPane().add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblPetId = new JLabel("Pet ID:");
	    lblPetId.setFont(new Font("Verdana", Font.PLAIN, 15));
	    lblPetId.setBounds(28, 23, 131, 14);
	    panel_1.add(lblPetId);
	    
	    JLabel lblDrugName_1 = new JLabel("Drug Name:");
	    lblDrugName_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    lblDrugName_1.setBounds(28, 59, 125, 20);
	    panel_1.add(lblDrugName_1);
	    
	    JLabel lblDosage_1 = new JLabel("Dosage:");
	    lblDosage_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    lblDosage_1.setBounds(28, 103, 78, 20);
	    panel_1.add(lblDosage_1);
	    
	    JLabel lblDuration_1 = new JLabel("Duration:");
	    lblDuration_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    lblDuration_1.setBounds(28, 148, 78, 14);
	    panel_1.add(lblDuration_1);
	    
	    JLabel lblTime_1 = new JLabel("Time:");
	    lblTime_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    lblTime_1.setBounds(28, 190, 78, 14);
	    panel_1.add(lblTime_1);
	    
	    JLabel lblAdditionalInstructions_1 = new JLabel("Additional Instructions:\r\n");
	    lblAdditionalInstructions_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    lblAdditionalInstructions_1.setBounds(28, 227, 184, 20);
	    panel_1.add(lblAdditionalInstructions_1);
	    
	    petIdrs_Field = new JTextField();
	    petIdrs_Field.setEditable(false);
	    petIdrs_Field.setBounds(128, 22, 227, 20);
	    panel_1.add(petIdrs_Field);
	    petIdrs_Field.setColumns(10);
	    
	    drugNamers_Field = new JTextField();
	    drugNamers_Field.setEnabled(false);
	    drugNamers_Field.setColumns(10);
	    drugNamers_Field.setBounds(128, 61, 227, 20);
	    panel_1.add(drugNamers_Field);
	    
	    drugDosagers_Field = new JTextField();
	    drugDosagers_Field.setEnabled(false);
	    drugDosagers_Field.setColumns(10);
	    drugDosagers_Field.setBounds(128, 105, 227, 20);
	    panel_1.add(drugDosagers_Field);
	    
	    durationrs_Field = new JTextField();
	    durationrs_Field.setEnabled(false);
	    durationrs_Field.setColumns(10);
	    durationrs_Field.setBounds(128, 147, 227, 20);
	    panel_1.add(durationrs_Field);
	    
	    timers_Field = new JTextField();
	    timers_Field.setEditable(false);
	    timers_Field.setColumns(10);
	    timers_Field.setBounds(128, 189, 227, 20);
	    panel_1.add(timers_Field);
	    
	    addInstructionsrs_Field = new JTextField();
	    addInstructionsrs_Field.setEditable(false);
	    addInstructionsrs_Field.setEnabled(false);
	    addInstructionsrs_Field.setColumns(10);
	    addInstructionsrs_Field.setBounds(28, 258, 327, 103);
	    panel_1.add(addInstructionsrs_Field);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setBounds(40, 122, 365, 395);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHour = new JLabel("HH");
		lblHour.setBounds(157, 213, 20, 20);
		panel.add(lblHour);
		
		JLabel lblMinute = new JLabel("MM");
		lblMinute.setBounds(217, 213, 20, 20);
		panel.add(lblMinute);
		
		JSpinner time_Hour = new JSpinner(new SpinnerNumberModel(0, 0, 24, 1));
		time_Hour.setBounds(147, 196, 50, 20);
		panel.add(time_Hour);
		
		JSpinner time_Second = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
		time_Second.setBounds(267, 196, 50, 20);
		panel.add(time_Second);
		
		JLabel lblSecond = new JLabel("SS");
		lblSecond.setBounds(277, 213, 20, 20);
		panel.add(lblSecond);
		
		JSpinner time_Minute = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
		time_Minute.setBounds(207, 196, 50, 20);
		panel.add(time_Minute);
		
		JLabel lblNewLabel = new JLabel("Pet ID:\r\n");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 26, 64, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDrugName = new JLabel("Drug Name:");
		lblDrugName.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDrugName.setBounds(24, 67, 110, 20);
		panel.add(lblDrugName);
		
		JLabel lblDosage = new JLabel("Dosage:");
		lblDosage.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDosage.setBounds(23, 108, 93, 20);
		panel.add(lblDosage);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDuration.setBounds(24, 152, 110, 14);
		panel.add(lblDuration);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTime.setBounds(24, 196, 64, 14);
		panel.add(lblTime);
		
		JLabel lblAdditionalInstructions = new JLabel("Additional Instructions:\r\n");
		lblAdditionalInstructions.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblAdditionalInstructions.setBounds(24, 244, 203, 14);
		panel.add(lblAdditionalInstructions);
		
		petID_Field = new JTextField();
		petID_Field.setBounds(126, 20, 217, 30);
		panel.add(petID_Field);
		petID_Field.setColumns(10);
		
		dosage_Field = new JTextField();
		dosage_Field.setColumns(10);
		dosage_Field.setBounds(126, 105, 217, 30);
		panel.add(dosage_Field);
		
		drugName_Field = new JTextField();
		drugName_Field.setColumns(10);
		drugName_Field.setBounds(126, 61, 217, 30);
		panel.add(drugName_Field);
		
		JTextArea additionalInstruct_Field = new JTextArea();
		additionalInstruct_Field.setBounds(24, 269, 319, 60);
		panel.add(additionalInstruct_Field);
		
		JButton printSave_Btn = new JButton("Print & Save Prescription");
		printSave_Btn.setFont(new Font("Verdana", Font.PLAIN, 15));
		printSave_Btn.setBounds(51, 340, 217, 32);
		panel.add(printSave_Btn);
		
		JSpinner duration_Hour = new JSpinner(new SpinnerNumberModel(0, 0, 24, 1));
		duration_Hour.setBounds(147, 146, 50, 20);
		panel.add(duration_Hour);
		
		JLabel lblHour_1 = new JLabel("HH");
		lblHour_1.setBounds(157, 163, 20, 20);
		panel.add(lblHour_1);
		
		JSpinner duration_Minute = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
		duration_Minute.setBounds(207, 146, 50, 20);
		panel.add(duration_Minute);
		
		JLabel lblMinute_1 = new JLabel("MM");
		lblMinute_1.setBounds(217, 163, 20, 20);
		panel.add(lblMinute_1);
		
		JSpinner duration_Second = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
		duration_Second.setBounds(267, 146, 50, 20);
		panel.add(duration_Second);
		
		JLabel lblSecond_1 = new JLabel("SS");
		lblSecond_1.setBounds(277, 163, 20, 20);
		panel.add(lblSecond_1);
		
		
		JLabel lblPrescription = new JLabel("PRESCRIPTION");
		lblPrescription.setForeground(Color.WHITE);
		lblPrescription.setFont(new Font("Verdana", Font.BOLD, 40));
		lblPrescription.setBounds(261, 11, 353, 75);
		getContentPane().add(lblPrescription);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 94);
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
        
        printSave_Btn.addActionListener(e -> {
            String petID = petID_Field.getText();
            String drugName = drugName_Field.getText();
            String dosage = dosage_Field.getText();
            String duration = String.format("%02d:%02d:%02d", (int) duration_Hour.getValue(), (int) duration_Minute.getValue(), (int) duration_Second.getValue());
            String time = String.format("%02d:%02d:%02d", (int) time_Hour.getValue(), (int) time_Minute.getValue(), (int) time_Second.getValue());
            String additionalInstructions = additionalInstruct_Field.getText();
            
            try {
                Double.parseDouble(dosage);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Prescription.this, "Dosage must be a number.", "Invalid Dosage", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (petID_Field.getText().isEmpty() || drugName_Field.getText().isEmpty() || dosage_Field.getText().isEmpty() ||
            		duration.equals(null) || time.equals(null) || additionalInstruct_Field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Prescription.this, "Please fill in all fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            
            try {
                java.sql.Time durationTime = java.sql.Time.valueOf(duration);
                java.sql.Time timeTime = java.sql.Time.valueOf(time);
                
            	DatabaseManager dbManager = DatabaseManager.getInstance();
                boolean petExists = dbManager.doesPetExist(Integer.parseInt(petID));

                if (petExists) {
                	dbManager.insertPrescription(Integer.parseInt(petID), drugName, dosage, durationTime, timeTime, additionalInstructions);
                	JOptionPane.showMessageDialog(Prescription.this, "Successfully Saved", "Information", JOptionPane.INFORMATION_MESSAGE);
                	
                    petIdrs_Field.setText(petID);
                    drugNamers_Field.setText(drugName);
                    drugDosagers_Field.setText(dosage);
                    durationrs_Field.setText(duration);
                    timers_Field.setText(time);
                    addInstructionsrs_Field.setText(additionalInstructions);
                } else {
                    JOptionPane.showMessageDialog(this, "Pet not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
            	ex.printStackTrace();
            }
        });
	}
	
	
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }

	public Prescription(String from, int petId) {
		initialize();
		setVisible(true);
		
		if(from.equals("fromTreatment") && petId != 0) {
			petID_Field.setText(String.valueOf(petId));
			petID_Field.setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
    		new Prescription("here", 0);
        });
	}
}