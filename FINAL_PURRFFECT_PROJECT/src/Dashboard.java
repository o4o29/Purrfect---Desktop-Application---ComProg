import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Dashboard implements ActionListener{
    private JFrame frmMainMenu;
    private Calendar calendar;
    private SimpleDateFormat timeFormat, dayFormat, dateFormat;
    private JLabel timeLabel, dayLabel, dateLabel, dateSchedLabel;
    private String time, day, date, dateSched;

    private JButton btnInformation, btnAppointment, btnTreatment, btnPrescription, btnRecord, btnReport, btnLogout, btnExit;
    private JTextField appointmentName_1, appointmentTime_1, appointmentName_2, appointmentTime_2;
    
    private JLabel lblNewLabel_1;
    private JTextField noAppoint;
    private JLabel name1;
    private JLabel time1;
    private JLabel time2;
    
    private JPanel panelMain;
    private JPanel panel1;
    private JPanel appointmentSchedule_Panel;
    private JLabel infoLabel;
    private JLabel labelApp;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    
    private int scrollPosition, count, currentIndex = 0;;
    
    private void initialize() {
    	// FRAME
        frmMainMenu = new JFrame("Dashboard");
        frmMainMenu.setTitle("Main Menu");
        frmMainMenu.getContentPane().setBackground(new Color(255, 228, 225));
        frmMainMenu.getContentPane().setLayout(null);
        frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMainMenu.setSize(1000, 700);
        frmMainMenu.setResizable(false);
        frmMainMenu.setLocationRelativeTo(null);
        frmMainMenu.setVisible(true);

        calendar = Calendar.getInstance();
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        time = timeFormat.format(calendar.getTime());
        
        appointmentSchedule_Panel = new JPanel();
        appointmentSchedule_Panel.setBackground(new Color(255, 182, 193));
        appointmentSchedule_Panel.setBounds(662, 250, 312, 311);
        frmMainMenu.getContentPane().add(appointmentSchedule_Panel);
        appointmentSchedule_Panel.setLayout(null);
        
        JPanel panelSched = new JPanel();
        panelSched.setBounds(10, 11, 289, 288);
        appointmentSchedule_Panel.add(panelSched);
        panelSched.setBorder(new LineBorder(new Color(244,197,215), 2, true));
        panelSched.setBackground(new Color(255, 228, 225));
        panelSched.setLayout(null);

        JLabel lblNewLabel = new JLabel("Appointment");
        lblNewLabel.setBackground(new Color(255, 217, 236));
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 17));
        lblNewLabel.setBounds(89, 22, 131, 21);
        panelSched.add(lblNewLabel);
        
        dateSchedLabel = new JLabel();
        dateSchedLabel.setBounds(96, 66, 165, 21);
        panelSched.add(dateSchedLabel);
        dateSchedLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        dateSchedLabel.setText(dateSched);
        
        lblNewLabel_1 = new JLabel("Appointments Today: ");
        lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
        lblNewLabel_1.setBounds(20, 98, 186, 19);
        panelSched.add(lblNewLabel_1);
        
        noAppoint = new JTextField();
        noAppoint.setBackground(new Color(250,242,208));
        noAppoint.setEditable(false);
        noAppoint.setBounds(207, 99, 72, 20);
        panelSched.add(noAppoint);
        noAppoint.setColumns(10);
        
        name1 = new JLabel("Name:");
        name1.setFont(new Font("Verdana", Font.PLAIN, 15));
        name1.setBounds(20, 128, 61, 21);
        panelSched.add(name1);
        
        time1 = new JLabel("Time:");
        time1.setFont(new Font("Verdana", Font.PLAIN, 15));
        time1.setBounds(20, 160, 46, 14);
        panelSched.add(time1);
        
        JLabel name2 = new JLabel("Name:");
        name2.setFont(new Font("Verdana", Font.PLAIN, 15));
        name2.setBounds(20, 202, 61, 14);
        panelSched.add(name2);
        
        time2 = new JLabel("Time:");
        time2.setFont(new Font("Verdana", Font.PLAIN, 15));
        time2.setBounds(20, 233, 46, 14);
        panelSched.add(time2);
        
        appointmentName_1 = new JTextField();
        appointmentName_1.setBackground(new Color(250,242,208));
        appointmentName_1.setEditable(false);
        appointmentName_1.setBounds(91, 128, 188, 20);
        panelSched.add(appointmentName_1);
        appointmentName_1.setColumns(10);
        
        appointmentTime_1 = new JTextField();
        appointmentTime_1.setBackground(new Color(250,242,208));
        appointmentTime_1.setEditable(false);
        appointmentTime_1.setColumns(10);
        appointmentTime_1.setBounds(91, 159, 188, 20);
        panelSched.add(appointmentTime_1);
        
        appointmentName_2 = new JTextField();
        appointmentName_2.setBackground(new Color(250,242,208));
        appointmentName_2.setEditable(false);
        appointmentName_2.setColumns(10);
        appointmentName_2.setBounds(91, 201, 188, 20);
        panelSched.add(appointmentName_2);
        
        appointmentTime_2 = new JTextField();
        appointmentTime_2.setBackground(new Color(255, 239, 213));
        appointmentTime_2.setEditable(false);
        appointmentTime_2.setColumns(10);
        appointmentTime_2.setBounds(91, 226, 188, 21);
        panelSched.add(appointmentTime_2);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(134, 256, 25, 21);
        panelSched.add(scrollBar);
        
        JLabel lblSchedule = new JLabel("Schedule");
        lblSchedule.setFont(new Font("Verdana", Font.BOLD, 17));
        lblSchedule.setBackground(new Color(255, 217, 236));
        lblSchedule.setBounds(109, 41, 92, 21);
        panelSched.add(lblSchedule);
        
        JPanel panelHead = new JPanel();
        panelHead.setBackground(new Color(255, 182, 193));
        panelHead.setBounds(0, 0, 984, 227);
        frmMainMenu.getContentPane().add(panelHead);
        panelHead.setLayout(null);
        
        dateLabel = new JLabel();
        dateLabel.setBounds(369, 173, 241, 43);
        panelHead.add(dateLabel);
        dateLabel.setForeground(new Color(255, 239, 213));
        dateLabel.setBackground(new Color(255, 239, 213));
        dateLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        dateLabel.setText(date);
        
        dayLabel = new JLabel();
        dayLabel.setForeground(new Color(255, 239, 213));
        dayLabel.setBackground(new Color(255, 20, 147));
        dayLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        dayLabel.setBounds(419, 137, 329, 43);
        panelHead.add(dayLabel);
        dayLabel.setText(day);
        
        timeLabel = new JLabel();
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 54));
        timeLabel.setBounds(317, 57, 416, 97);
        panelHead.add(timeLabel);
        timeLabel.setText(time);
        
        
        JLabel lblVcms = new JLabel("PURRFECT");
        lblVcms.setBounds(390, 11, 271, 64);
        panelHead.add(lblVcms);
        lblVcms.setForeground(Color.WHITE);
        lblVcms.setFont(new Font("Trebuchet MS", Font.BOLD, 39));
        
        JLabel logo1 = new JLabel("");
        Image img1 = new ImageIcon(Dashboard.class.getResource("logo_purrfect.png")).getImage();
        logo1.setIcon(new ImageIcon(img1));
        logo1.setBounds(52, 26, 231, 190);
        panelHead.add(logo1);
                                                
        panel1 = new JPanel();
        panel1.setBackground(new Color(255, 182, 193));
        panel1.setBounds(10, 250, 610, 388);
        frmMainMenu.getContentPane().add(panel1);
        panel1.setLayout(null);
        
        panelMain = new JPanel();
        panelMain.setBounds(10, 11, 593, 366);
        panel1.add(panelMain);
        panelMain.setLayout(null);
        panelMain.setBorder(new LineBorder(new Color(244,197,215), 2, true));
        panelMain.setBackground(new Color(255, 228, 225));
        
        btnAppointment = new JButton("");
        Image img4 = new ImageIcon(Dashboard.class.getResource("appointment.png")).getImage();
        btnAppointment.setIcon(new ImageIcon(img4));
        btnAppointment.setBounds(219, 21, 173, 141);
        panelMain.add(btnAppointment);
        btnAppointment.setBackground(new Color(249,173,183));
        btnAppointment.setFont(new Font("Verdana", Font.BOLD, 15));
        btnAppointment.addActionListener(this);
        btnAppointment.setFocusable(false);
                                                
        btnRecord = new JButton("");
        btnRecord.setBounds(219, 194, 165, 141);
        Image img7 = new ImageIcon(Dashboard.class.getResource("prescription.png")).getImage();
        btnRecord.setIcon(new ImageIcon(img7));
        panelMain.add(btnRecord);
        btnRecord.setBackground(new Color(249,173,183));
        btnRecord.setFont(new Font("Verdana", Font.BOLD, 15));
        btnRecord.addActionListener(this);
        btnRecord.setFocusable(false);
                                                        
	    btnTreatment = new JButton("");
	    btnTreatment.setBounds(412, 21, 158, 141);
	    Image img5 = new ImageIcon(Dashboard.class.getResource("treatment.png")).getImage();
	    btnTreatment.setIcon(new ImageIcon(img5));

	    panelMain.add(btnTreatment);
	    btnTreatment.setBackground(new Color(255, 182, 193));
	    btnTreatment.setFont(new Font("Verdana", Font.BOLD, 15));
	    btnTreatment.addActionListener(this);
	    btnTreatment.setFocusable(false);
                                                                
	    btnPrescription = new JButton("");
	    btnPrescription.setBounds(28, 194, 165, 141);
	    Image img6 = new ImageIcon(Dashboard.class.getResource("prescription_1.png")).getImage();
	    btnPrescription.setIcon(new ImageIcon(img6));
	
	    panelMain.add(btnPrescription);
	    btnPrescription.setBackground(new Color(249,173,183));
	    btnPrescription.setFont(new Font("Verdana", Font.BOLD, 15));
	    btnPrescription.addActionListener(this);
	    btnPrescription.setFocusable(false);
                                                                                                                                                  
	    btnInformation = new JButton("");
	    Image img2 = new ImageIcon(Dashboard.class.getResource("info.png")).getImage();
	    btnInformation.setIcon(new ImageIcon(img2));
	    btnInformation.setBounds(122, 140, 165, 130);
	    btnInformation.setBounds(28, 21, 165, 141);
	    
	    btnReport = new JButton("");
	    Image img3 = new ImageIcon(Dashboard.class.getResource("report.png")).getImage();
	    btnReport.setIcon(new ImageIcon(img3));
	    btnReport.setFont(new Font("Verdana", Font.BOLD, 15));
	    btnReport.setBackground(new Color(249, 173, 183));
	    btnReport.addActionListener(this);
	    btnReport.setBounds(405, 194, 165, 141);
	    panelMain.add(btnReport);
	    
	    panelMain.add(btnInformation); 
	    btnInformation.setBackground(new Color(249,173,183));
	    btnInformation.setFont(new Font("Verdana", Font.BOLD, 15));
	    btnInformation.addActionListener(this);
	    btnInformation.setFocusable(false);
	    
	    
	    infoLabel = new JLabel("INFORMATION");
	    infoLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	    infoLabel.setBounds(62, 168, 116, 14);
	    panelMain.add(infoLabel);
	    
	    labelApp = new JLabel("APPOINTMENT");
	    labelApp.setFont(new Font("Verdana", Font.BOLD, 12));
	    labelApp.setBounds(255, 169, 113, 14);
	    panelMain.add(labelApp);
	    
	    lblNewLabel_4 = new JLabel("TREATMENT");
	    lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 12));
	    lblNewLabel_4.setBounds(449, 168, 91, 14);
	    panelMain.add(lblNewLabel_4);
	    
	    lblNewLabel_2 = new JLabel("PRESCRIPTION");
	    lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
	    lblNewLabel_2.setBounds(62, 343, 116, 14);
	    panelMain.add(lblNewLabel_2);
	    
	    lblNewLabel_3 = new JLabel("RECORD");
	    lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 12));
	    lblNewLabel_3.setBounds(274, 343, 71, 14);
	    panelMain.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("REPORT");
	    lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 12));
	    lblNewLabel_3_1.setBounds(458, 344, 71, 14);
	    panelMain.add(lblNewLabel_3_1);
        
        btnExit = new JButton("EXIT");
        btnExit.setBounds(808, 603, 100, 37);
        frmMainMenu.getContentPane().add(btnExit);
        btnExit.setFont(new Font("Verdana", Font.PLAIN, 13));
        btnExit.setBackground(new Color(254,201,195));
        btnExit.addActionListener(this);
        btnExit.setFocusable(false);
        
        btnLogout = new JButton("LOG OUT");
        btnLogout.setBounds(704, 603, 100, 37);
        frmMainMenu.getContentPane().add(btnLogout);
        btnLogout.setFont(new Font("Verdana", Font.PLAIN, 13));
        btnLogout.setBackground(new Color(254,201,195));
        btnLogout.addActionListener(this);
        btnLogout.setFocusable(false);
        
        
        Point originalLocation = frmMainMenu.getLocation();
        frmMainMenu.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                frmMainMenu.setLocation(originalLocation);
            }
        });
        
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                scrollPosition = scrollBar.getValue();
                int maxIndex = Math.max(0, count - 2);
                currentIndex = Math.min(maxIndex, scrollPosition);
                updateAppointmentDisplay();
            }
        });
    }
    // ----------------------------------------------------------------------------------------------------------------------------------
    

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnInformation)) {
	        frmMainMenu.setEnabled(false);
	        searchClientAndPet clientAndPetFrame = new searchClientAndPet();
	        clientAndPetFrame.setDashboardFrame(frmMainMenu);
	    }

		
		if(e.getSource().equals(btnAppointment)) {
			frmMainMenu.setEnabled(false);
	        Appointment appointmentFrame = new Appointment();
	        appointmentFrame.setDashboardFrame(frmMainMenu);
		}	

		if(e.getSource().equals(btnTreatment)) {
			frmMainMenu.setEnabled(false);
	        treatmentFirst treatmentFrame = new treatmentFirst();
	        treatmentFrame.setDashboardFrame(frmMainMenu);
		}	

		if(e.getSource().equals(btnPrescription)) {
			frmMainMenu.setEnabled(false);
	        Prescription prescriptionFrame = new Prescription("here", 0);
	        prescriptionFrame.setDashboardFrame(frmMainMenu);
		}


		if(e.getSource().equals(btnRecord)) {
			frmMainMenu.setEnabled(false);
	        clientAndPetRecords clientAndPetRecordsFrame = new clientAndPetRecords();
	        clientAndPetRecordsFrame.setDashboardFrame(frmMainMenu);
		}	
		
		if(e.getSource().equals(btnReport)) {
			frmMainMenu.setEnabled(false);
	        reportGeneration reportGenerationFrame = new reportGeneration();
	        reportGenerationFrame.setDashboardFrame(frmMainMenu);
		}	

		if(e.getSource().equals(btnLogout)) {
			int result = JOptionPane.showConfirmDialog(frmMainMenu,"Are you sure you want to log out?", "Confirmation",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
			
			if(result == JOptionPane.YES_OPTION) {
				frmMainMenu.dispose();
				new Dashboard();
			} else if(result == JOptionPane.NO_OPTION) {
				return;
			}
		}	

		if(e.getSource().equals(btnExit)) {
			frmMainMenu.dispose();
		}	
	 }
	
	
    public void setTime() {
        Thread updateTimeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    time = timeFormat.format(Calendar.getInstance().getTime());
                    timeLabel.setText(time);
                    
                    day = dayFormat.format(Calendar.getInstance().getTime());
                    dayLabel.setText(day);
                    
                    date = dateFormat.format(Calendar.getInstance().getTime());
                    dateLabel.setText(date);
                    
                    dateSched = dateFormat.format(Calendar.getInstance().getTime());
                    dateSchedLabel.setText(dateSched);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        updateTimeThread.start();
    }
    
    
    // DISPLAY APPOINTMENTS; FETCH
	public void fetchAppointmentsForToday() {
	    Date today = new Date(System.currentTimeMillis());

	    try {
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        ResultSet resultSet = dbManager.getAppointmentsForDate(today);

	        count = 0;
	        
	        if (resultSet.next()) {
	            noAppoint.setVisible(true);
	            do {
	                String appointmentName = resultSet.getString("petName");
	                Time appointmentTime = resultSet.getTime("time");
	                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
	                String formattedTime = timeFormat.format(appointmentTime);

	                if (count == 0) {
	                    appointmentName_1.setText(appointmentName);
	                    appointmentTime_1.setText(formattedTime);
	                } else {
	                    appointmentName_2.setText(appointmentName);
	                    appointmentTime_2.setText(formattedTime);
	                }
	                count++;
	            } while (resultSet.next());
	        } else {
	            noAppoint.setText("No Appointment for Today");
	            noAppoint.setVisible(true);
	        }

	        displayAppointments(count);
	        updateAppointmentDisplay();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to fetch appointments from the database.");
	    }
	}

	
	private void updateAppointmentDisplay() {
	    int startIndex = currentIndex * 2;
	    int appointmentCount = Integer.parseInt(noAppoint.getText());

	    try {
	        Date today = new Date(System.currentTimeMillis());
	        DatabaseManager dbManager = DatabaseManager.getInstance();
	        ResultSet resultSet = dbManager.getAppointmentsForDate(today);

	        for (int i = 0; i < startIndex && resultSet.next(); i++) {}

	        for (int i = 0; i < 2; i++) {
	            if (startIndex + i < appointmentCount && resultSet.next()) {
	                String appointmentName = resultSet.getString("petName");
	                Time appointmentTime = resultSet.getTime("time");
	                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
	                String formattedTime = timeFormat.format(appointmentTime);

	                if (i == 0) {
	                    appointmentName_1.setText(appointmentName);
	                    appointmentTime_1.setText(formattedTime);
	                } else {
	                    appointmentName_2.setText(appointmentName);
	                    appointmentTime_2.setText(formattedTime);
	                }
	            } else {
	                if (i == 0) {
	                    appointmentName_1.setText("");
	                    appointmentTime_1.setText("");
	                } else {
	                    appointmentName_2.setText("");
	                    appointmentTime_2.setText("");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to fetch appointments from the database.");
	    }
	}

	
	private void displayAppointments(int appointmentCount) {
	    noAppoint.setText(Integer.toString(appointmentCount));
	}

	
	public void startAutoRefresh() {
	    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	    scheduler.scheduleAtFixedRate(() -> {
	        SwingUtilities.invokeLater(() -> {
	            fetchAppointmentsForToday();
	        });
	    }, 0, 3, TimeUnit.SECONDS); // 3 seconds refresh rate
	}
	
	public Dashboard() {
        initialize();
        startAutoRefresh();
        frmMainMenu.setVisible(true);
        setTime();
	}
	 
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            new Dashboard();
        });
    }
}