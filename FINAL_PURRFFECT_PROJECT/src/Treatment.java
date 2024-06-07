import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;

public class Treatment extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField appointmentID_Field;
	private JTextField vaxName_Field;
	private JTextField petID_Field;
	private JTextField petName_Field;
	private JTextField temp_Field;
	private JTextField heartRate_Field;
	private JTextField respRate_Field;
	private JTextField against_Field;
	private JTextField others_Field;
	private JTextArea services_Field;
	private static int appointmentID;
	private static String serviceIds;
	private JTextField time_Field;
	private JDateChooser dateChooser;
	private static JFrame dashboardFrame;
	
	public static void getAppointmentId(int appointmentID, JFrame dashboardFrame) {
		Treatment.appointmentID = appointmentID;
		Treatment.dashboardFrame = dashboardFrame;
		
		SwingUtilities.invokeLater(() -> new Treatment().populateFields());
	}
	
	private void initialize() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
		lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 60));
		lblNewLabel_2_2.setBounds(263, -14, 634, 84);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblTreatmentService = new JLabel("TREATMENT SERVICE");
		lblTreatmentService.setForeground(Color.WHITE);
		lblTreatmentService.setFont(new Font("Verdana", Font.BOLD, 35));
		lblTreatmentService.setBounds(233, 60, 777, 24);
		getContentPane().add(lblTreatmentService);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 182, 193));
		mainPanel.setBounds(149, 106, 595, 141);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 11, 129, 14);
		mainPanel.add(lblNewLabel);
		
		appointmentID_Field = new JTextField();
		appointmentID_Field.setEditable(false);
		appointmentID_Field.setBounds(127, 9, 179, 20);
		mainPanel.add(appointmentID_Field);
		appointmentID_Field.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(21, 38, 129, 14);
		mainPanel.add(lblDate);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pet ID:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(21, 85, 129, 14);
		mainPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Pet Name:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(21, 110, 129, 14);
		mainPanel.add(lblNewLabel_1_2_1);
		
		petID_Field = new JTextField();
		petID_Field.setEditable(false);
		petID_Field.setColumns(10);
		petID_Field.setBounds(127, 85, 179, 20);
		mainPanel.add(petID_Field);
		
		petName_Field = new JTextField();
		petName_Field.setEditable(false);
		petName_Field.setColumns(10);
		petName_Field.setBounds(127, 110, 179, 20);
		mainPanel.add(petName_Field);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Services:");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_2.setBounds(316, 63, 129, 14);
		mainPanel.add(lblNewLabel_1_2_1_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(127, 36, 179, 20);
		mainPanel.add(dateChooser);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(21, 64, 129, 14);
		mainPanel.add(lblTime);
		
		time_Field = new JTextField();
		time_Field.setEditable(false);
		time_Field.setColumns(10);
		time_Field.setBounds(127, 61, 179, 20);
		mainPanel.add(time_Field);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 43, 212, 59);
		mainPanel.add(scrollPane);
		
		services_Field = new JTextArea();
		services_Field.setEditable(false);
		scrollPane.setViewportView(services_Field);
		
		JPanel dewormingPanel = new JPanel();
		dewormingPanel.setLayout(null);
		dewormingPanel.setBackground(new Color(255, 182, 193));
		dewormingPanel.setBounds(29, 258, 827, 292);
		getContentPane().add(dewormingPanel);
		
		JPanel vitalSigns_Panel = new JPanel();
		vitalSigns_Panel.setBorder(new TitledBorder(null, "Vital Signs", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		vitalSigns_Panel.setBackground(new Color(255, 228, 225));
		vitalSigns_Panel.setBounds(21, 13, 176, 105);
		dewormingPanel.add(vitalSigns_Panel);
		vitalSigns_Panel.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Temperature:");
		lblNewLabel_1_2_1_1.setBounds(10, 24, 80, 14);
		vitalSigns_Panel.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Heart Rate:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(10, 49, 70, 14);
		vitalSigns_Panel.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Resp. Rate");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 74, 70, 14);
		vitalSigns_Panel.add(lblNewLabel_1_2_1_1_1_1);
		
		temp_Field = new JTextField();
		temp_Field.setBounds(90, 22, 76, 20);
		vitalSigns_Panel.add(temp_Field);
		temp_Field.setColumns(10);
		
		heartRate_Field = new JTextField();
		heartRate_Field.setColumns(10);
		heartRate_Field.setBounds(90, 47, 76, 20);
		vitalSigns_Panel.add(heartRate_Field);
		
		respRate_Field = new JTextField();
		respRate_Field.setColumns(10);
		respRate_Field.setBounds(90, 72, 76, 20);
		vitalSigns_Panel.add(respRate_Field);
		
		JPanel diagnosisPanel = new JPanel();
		diagnosisPanel.setLayout(null);
		diagnosisPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Diagnosis", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		diagnosisPanel.setBackground(new Color(255, 228, 225));
		diagnosisPanel.setBounds(21, 135, 176, 146);
		dewormingPanel.add(diagnosisPanel);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Enter Diagnosis Here:");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_2.setBounds(10, 24, 156, 14);
		diagnosisPanel.add(lblNewLabel_1_2_1_1_2);
		
		JTextArea diagnosis_Area = new JTextArea();
		diagnosis_Area.setLineWrap(true);
		diagnosis_Area.setBounds(10, 44, 156, 91);
		diagnosisPanel.add(diagnosis_Area);
		
		JPanel vaccinationPanel = new JPanel();
		vaccinationPanel.setLayout(null);
		vaccinationPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Vaccination", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		vaccinationPanel.setBackground(new Color(255, 228, 225));
		vaccinationPanel.setBounds(221, 11, 176, 178);
		dewormingPanel.add(vaccinationPanel);
		
		JRadioButton yes_Rdo = new JRadioButton("Yes");
		yes_Rdo.setBounds(17, 18, 89, 23);
		vaccinationPanel.add(yes_Rdo);
		yes_Rdo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yes_Rdo.setBackground(new Color(255, 228, 225));
		
		JRadioButton no_Rdo = new JRadioButton("No");
		no_Rdo.setBounds(17, 44, 109, 23);
		vaccinationPanel.add(no_Rdo);
		no_Rdo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		no_Rdo.setBackground(new Color(255, 228, 225));
		
		 ButtonGroup vaccinationGroup = new ButtonGroup();
	     vaccinationGroup.add(yes_Rdo);
	     vaccinationGroup.add(no_Rdo);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Name:");
		lblNewLabel_1_1_2_1_1_1.setBounds(17, 74, 43, 14);
		vaccinationPanel.add(lblNewLabel_1_1_2_1_1_1);
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		vaxName_Field = new JTextField();
		vaxName_Field.setBounds(69, 74, 97, 20);
		vaccinationPanel.add(vaxName_Field);
		vaxName_Field.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_2 = new JLabel("Against:");
		lblNewLabel_1_1_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1_1_2.setBounds(17, 99, 76, 14);
		vaccinationPanel.add(lblNewLabel_1_1_2_1_1_1_1_2);
		
		against_Field = new JTextField();
		against_Field.setColumns(10);
		against_Field.setBounds(69, 97, 97, 20);
		vaccinationPanel.add(against_Field);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_2_1 = new JLabel("Others:");
		lblNewLabel_1_1_2_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1_1_1_2_1.setBounds(17, 132, 76, 14);
		vaccinationPanel.add(lblNewLabel_1_1_2_1_1_1_1_2_1);
		
		others_Field = new JTextField();
		others_Field.setColumns(10);
		others_Field.setBounds(69, 130, 97, 20);
		vaccinationPanel.add(others_Field);
		
		JPanel diagnosisPanel_1_1 = new JPanel();
		diagnosisPanel_1_1.setLayout(null);
		diagnosisPanel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Deworming", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		diagnosisPanel_1_1.setBackground(new Color(255, 228, 225));
		diagnosisPanel_1_1.setBounds(221, 200, 176, 68);
		dewormingPanel.add(diagnosisPanel_1_1);
		
		JRadioButton yesDwrm_Rdo = new JRadioButton("Yes");
		yesDwrm_Rdo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yesDwrm_Rdo.setBackground(new Color(255, 228, 225));
		yesDwrm_Rdo.setBounds(17, 18, 68, 23);
		diagnosisPanel_1_1.add(yesDwrm_Rdo);
		
		JRadioButton noDwrm_Rdo = new JRadioButton("No");
		noDwrm_Rdo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		noDwrm_Rdo.setBackground(new Color(255, 228, 225));
		noDwrm_Rdo.setBounds(87, 18, 85, 23);
		diagnosisPanel_1_1.add(noDwrm_Rdo);
		
		ButtonGroup dewormingGroup = new ButtonGroup();
        dewormingGroup.add(yesDwrm_Rdo);
        dewormingGroup.add(noDwrm_Rdo);
		
		JPanel treatmentPlan_Panel = new JPanel();
		treatmentPlan_Panel.setLayout(null);
		treatmentPlan_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Treatment Plans", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		treatmentPlan_Panel.setBackground(new Color(255, 228, 225));
		treatmentPlan_Panel.setBounds(407, 13, 404, 90);
		dewormingPanel.add(treatmentPlan_Panel);
		
		JTextArea treatment_Area = new JTextArea();
		treatment_Area.setLineWrap(true);
		treatment_Area.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		treatment_Area.setBounds(10, 11, 384, 68);
		treatmentPlan_Panel.add(treatment_Area);
		
		JPanel medProcedure_Panel = new JPanel();
		medProcedure_Panel.setLayout(null);
		medProcedure_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Medical Procedures", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		medProcedure_Panel.setBackground(new Color(255, 228, 225));
		medProcedure_Panel.setBounds(407, 109, 404, 90);
		dewormingPanel.add(medProcedure_Panel);
		
		JTextArea medProcedure_Area = new JTextArea();
		medProcedure_Area.setLineWrap(true);
		medProcedure_Area.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		medProcedure_Area.setBounds(10, 11, 384, 68);
		medProcedure_Panel.add(medProcedure_Area);
		
		JPanel followUp_Panel = new JPanel();
		followUp_Panel.setLayout(null);
		followUp_Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Follow Up Check Up", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		followUp_Panel.setBackground(new Color(255, 228, 225));
		followUp_Panel.setBounds(417, 210, 176, 54);
		dewormingPanel.add(followUp_Panel);
		
		JRadioButton yesFlw_Rdo = new JRadioButton("Yes");
		yesFlw_Rdo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yesFlw_Rdo.setBackground(new Color(255, 228, 225));
		yesFlw_Rdo.setBounds(17, 18, 68, 23);
		followUp_Panel.add(yesFlw_Rdo);
		
		JRadioButton noFlw_Rdo = new JRadioButton("No");
		noFlw_Rdo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		noFlw_Rdo.setBackground(new Color(255, 228, 225));
		noFlw_Rdo.setBounds(92, 18, 85, 23);
		followUp_Panel.add(noFlw_Rdo);
		
		ButtonGroup follow_upGroup = new ButtonGroup();
		follow_upGroup.add(yesFlw_Rdo);
		follow_upGroup.add(noFlw_Rdo);
		
		JButton btnSavePrint = new JButton("Save /  Print");
		btnSavePrint.setBounds(629, 210, 176, 34);
		dewormingPanel.add(btnSavePrint);
		
		JButton btnPrescription = new JButton("Prescription");
		btnPrescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrescription.setBounds(629, 247, 176, 34);
		dewormingPanel.add(btnPrescription);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255, 182, 193));
		textArea_1.setBounds(0, 0, 884, 95);
		getContentPane().add(textArea_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setBounds(0, 0, 884, 95);
		getContentPane().add(textArea);
		
		
		// LISTENERS
        yes_Rdo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vaxName_Field.setEditable(true);
                against_Field.setEditable(true);
                others_Field.setEditable(true);
            }
        });

        no_Rdo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vaxName_Field.setEditable(false);
                against_Field.setEditable(false);
                others_Field.setEditable(false);
                vaxName_Field.setText("");
                against_Field.setText("");
                others_Field.setText("");
            }
        });
        
        btnSavePrint.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    DatabaseManager dbManager = DatabaseManager.getInstance();
                    
                    int appointmentID = Integer.parseInt(appointmentID_Field.getText());
                    int petID = Integer.parseInt(petID_Field.getText());
                    
                    String petName = petName_Field.getText();
                    String hasVaccine = yes_Rdo.isSelected() ? "Yes" : "No";
                    String vaccineName = vaxName_Field.getText();
                    String vaccineAgainst = against_Field.getText();
                    String vaccineOthers = others_Field.getText();
                    String treatmentPlans = treatment_Area.getText();
                    String medicalProcedure = medProcedure_Area.getText();
                    String diagnosis = diagnosis_Area.getText();
                    String deworming = yesDwrm_Rdo.isSelected() ? "Yes" : "No";
                    String followUpCheckUp = yesFlw_Rdo.isSelected() ? "Yes" : "No";
                    
                    Date date = new Date(dateChooser.getDate().getTime());
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                    java.util.Date parsedDate = sdf.parse(time_Field.getText());
                    Time time = new Time(parsedDate.getTime());
                    
                    
                    if (hasVaccine.equals("Yes") && (vaccineName.isEmpty() || vaccineAgainst.isEmpty() || vaccineOthers.isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if (hasVaccine.equals("No") && (treatmentPlans.isEmpty() || medicalProcedure.isEmpty() || diagnosis.isEmpty() || deworming.isEmpty() || followUpCheckUp.isEmpty())) {
                    	JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (!isNumeric(temp_Field.getText()) || !isNumeric(heartRate_Field.getText()) || !isNumeric(respRate_Field.getText())) {
                        JOptionPane.showMessageDialog(null, "Temperature, Heart Rate, and Respiratory Rate must be numeric.");
                        return;
                    }
                    
                    double temperature = Double.parseDouble(temp_Field.getText());
                    double heartRate = Double.parseDouble(heartRate_Field.getText());
                    double respRate = Double.parseDouble(respRate_Field.getText());
                    
                    dbManager.insertTreatment(appointmentID, petID, petName, serviceIds, date, time, temperature, heartRate, respRate,
                                            hasVaccine, vaccineName, vaccineAgainst, vaccineOthers, treatmentPlans, medicalProcedure, diagnosis, deworming, followUpCheckUp);
                    
                    StringBuilder message = new StringBuilder();
                    message.append("Appointment ID: ").append(appointmentID).append("\n");
                    message.append("Date: ").append(date).append("\n");
                    message.append("Time: ").append(time).append("\n\n");
                    message.append("Pet ID: ").append(petID).append("\n");
                    message.append("Pet Name: ").append(petName).append("\n\n");
                    message.append("Services: \n").append(services_Field.getText()).append("\n");
                    message.append("Temperature: ").append(temperature).append("\n");
                    message.append("Heart Rate: ").append(heartRate).append("\n");
                    message.append("Respiratory Rate: ").append(respRate).append("\n\n");
                    message.append("Has Vaccine: ").append(hasVaccine).append("\n");
                    if (hasVaccine.equals("Yes")) {
                        message.append("Vaccine Name: ").append(vaccineName).append("\n");
                        message.append("Vaccine Against: ").append(vaccineAgainst).append("\n");
                        message.append("Other Vaccine Information: ").append(vaccineOthers).append("\n\n");
                    }
                    message.append("Treatment Plans: ").append(treatmentPlans).append("\n");
                    message.append("Medical Procedure: ").append(medicalProcedure).append("\n");
                    message.append("Diagnosis: ").append(diagnosis).append("\n\n");
                    message.append("Deworming: ").append(deworming).append("\n");
                    message.append("Follow-Up Check-Up: ").append(followUpCheckUp);
                    
                    JOptionPane.showMessageDialog(null, message.toString(), "Printed Information", JOptionPane.INFORMATION_MESSAGE);
                    
                    btnSavePrint.setEnabled(false);
                } catch (SQLException | ParseException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        
        btnPrescription.addActionListener(e -> {
        	Prescription prescriptionFrame = new Prescription("fromTreatment", Integer.parseInt(petID_Field.getText()));
        	
        	prescriptionFrame.setDashboardFrame(dashboardFrame);
        	this.dispose();
        });
	}
	
	
	public void populateFields() {
		try {
			 DatabaseManager dbManager = DatabaseManager.getInstance();
		     ResultSet resultSet = dbManager.getAppointmentById(appointmentID);
		     
		     if (resultSet.next()) {
	                appointmentID_Field.setText(String.valueOf(resultSet.getInt("appointmentID")));
	                
					dateChooser.setDate(resultSet.getDate("date"));
					
					time_Field.setText(String.valueOf(getFormattedTime()));
					petID_Field.setText(resultSet.getString("petID"));
					petName_Field.setText(resultSet.getString("petName"));
					
					String serviceIdsStr = resultSet.getString("services");
					Treatment.serviceIds = serviceIdsStr;
			    	 String[] serviceIds = serviceIdsStr.substring(1, serviceIdsStr.length() - 1).split(", ");
					
			    	 StringBuilder serviceNames = new StringBuilder();
			    	 for (String serviceId : serviceIds) {
			    		 String serviceName = dbManager.getServiceNameById(Integer.parseInt(serviceId.trim()));
			    		 serviceNames.append(serviceName).append("\n");
					 }
			    	 services_Field.setText(String.valueOf(serviceNames));
	         }
		     
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public String getFormattedTime() {
	    try {
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        ResultSet resultSet = dbManager.getAppointmentById(appointmentID);

	        if (resultSet.next()) {
	            Time timeFromDB = resultSet.getTime("time");
	            Date date = new Date(timeFromDB.getTime());

	            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
	            return sdf.format(date);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return null;
	}
	
	private boolean isNumeric(String str) {
	    return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	public Treatment() {
		initialize();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Treatment();
		});
	}
}