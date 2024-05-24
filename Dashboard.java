
import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Dashboard implements ActionListener{

    private JFrame frame;
    private Calendar calendar;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat dateSchedFormat;
    private JLabel timeLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;
    private JLabel dateSchedLabel;
    private String time;
    private String day;
    private String date;
    private String dateSched;
    
    private JButton btnInformation;
    private JButton btnAppointment;
    private JButton btnTreatment;
    private JButton btnPrescription;
    private JButton btnReports;
    private JButton btnLogout;
    private JButton btnExit;
    private JLabel lblNewLabel_1;
    private JTextField noAppoint;
    private JLabel name1;
    private JLabel time1;
    private JLabel time2;
    private JTextField txtName1;
    private JTextField txtTime1;
    private JTextField txtName2;
    private JTextField txtTime2;
    
   
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Dashboard");
        frame.getContentPane().setBackground(new Color(255, 228, 225));
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(713, 436); // Set the initial size of the frame
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        btnInformation = new JButton("INFORMATION");
        btnInformation.setBackground(new Color(249,173,183));
        btnInformation.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnInformation.setBounds(24, 177, 144, 55);
        btnInformation.addActionListener(this);
        btnInformation.setFocusable(false);
        frame.getContentPane().add(btnInformation);

        btnAppointment = new JButton("APPOINTMENT");
        btnAppointment.setBackground(new Color(249,173,183));
        btnAppointment.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnAppointment.setBounds(185, 177, 144, 55);
        btnAppointment.addActionListener(this);
        btnAppointment.setFocusable(false);
        frame.getContentPane().add(btnAppointment);

        btnTreatment = new JButton("TREATMENT");
        btnTreatment.setBackground(new Color(255, 182, 193));
        btnTreatment.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnTreatment.setBounds(349, 177, 144, 55);
        btnTreatment.addActionListener(this);
        btnTreatment.setFocusable(false);
        frame.getContentPane().add(btnTreatment);

        btnPrescription = new JButton("PRESCRIPTION");
        btnPrescription.setBackground(new Color(249,173,183));
        btnPrescription.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnPrescription.setBounds(107, 254, 144, 55);
        btnPrescription.addActionListener(this);
        btnPrescription.setFocusable(false);
        frame.getContentPane().add(btnPrescription);

        btnReports = new JButton("REPORTS");
        btnReports.setBackground(new Color(249,173,183));
        btnReports.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnReports.setBounds(268, 254, 144, 55);
        btnReports.addActionListener(this);
        btnReports.setFocusable(false);
        frame.getContentPane().add(btnReports);

        calendar = Calendar.getInstance();
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        dateSchedFormat = new SimpleDateFormat("MMMM dd, yyyy");
        time = timeFormat.format(calendar.getTime());
        
        ImageIcon logo = new ImageIcon("logo.png");
        
        btnLogout = new JButton("LOG OUT");
        btnLogout.setFont(new Font("Verdana", Font.PLAIN, 13));
        btnLogout.setBackground(new Color(254,201,195));
        btnLogout.setBounds(132, 338, 100, 37);
        btnLogout.addActionListener(this);
        btnLogout.setFocusable(false);
        frame.getContentPane().add(btnLogout);
        
        btnExit = new JButton("EXIT");
        btnExit.setFont(new Font("Verdana", Font.PLAIN, 13));
        btnExit.setBackground(new Color(254,201,195));
        btnExit.setBounds(291, 338, 100, 37);
        btnExit.addActionListener(this);
        btnExit.setFocusable(false);
        frame.getContentPane().add(btnExit);
        
        JPanel panelSched = new JPanel();
        panelSched.setBorder(new LineBorder(new Color(244,197,215), 2, true));
        panelSched.setBackground(new Color(255, 182, 193));
        panelSched.setBounds(509, 160, 178, 237);
        frame.getContentPane().add(panelSched);
        panelSched.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Appointment Schedule");
        lblNewLabel.setBackground(new Color(255, 217, 236));
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel.setBounds(20, 11, 158, 14);
        panelSched.add(lblNewLabel);
        
        dateSchedLabel = new JLabel();
        dateSchedLabel.setBounds(41, 23, 107, 21);
        panelSched.add(dateSchedLabel);
        dateSchedLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        dateSchedLabel.setText(dateSched);
        
        lblNewLabel_1 = new JLabel("Appointments Today: ");
        lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 55, 138, 14);
        panelSched.add(lblNewLabel_1);
        
        noAppoint = new JTextField();
        noAppoint.setBackground(new Color(250,242,208));
        noAppoint.setEditable(false);
        noAppoint.setBounds(138, 55, 30, 20);
        panelSched.add(noAppoint);
        noAppoint.setColumns(10);
        
        name1 = new JLabel("Name:");
        name1.setFont(new Font("Verdana", Font.PLAIN, 11));
        name1.setBounds(20, 92, 46, 14);
        panelSched.add(name1);
        
        time1 = new JLabel("Time:");
        time1.setFont(new Font("Verdana", Font.PLAIN, 11));
        time1.setBounds(20, 119, 46, 14);
        panelSched.add(time1);
        
        JLabel name2 = new JLabel("Name:");
        name2.setFont(new Font("Verdana", Font.PLAIN, 11));
        name2.setBounds(20, 155, 46, 14);
        panelSched.add(name2);
        
        time2 = new JLabel("Time:");
        time2.setFont(new Font("Verdana", Font.PLAIN, 11));
        time2.setBounds(20, 180, 46, 14);
        panelSched.add(time2);
        
        txtName1 = new JTextField();
        txtName1.setBackground(new Color(250,242,208));
        txtName1.setEditable(false);
        txtName1.setBounds(63, 90, 105, 20);
        panelSched.add(txtName1);
        txtName1.setColumns(10);
        
        txtTime1 = new JTextField();
        txtTime1.setBackground(new Color(250,242,208));
        txtTime1.setEditable(false);
        txtTime1.setColumns(10);
        txtTime1.setBounds(63, 117, 105, 20);
        panelSched.add(txtTime1);
        
        txtName2 = new JTextField();
        txtName2.setBackground(new Color(250,242,208));
        txtName2.setEditable(false);
        txtName2.setColumns(10);
        txtName2.setBounds(63, 153, 105, 20);
        panelSched.add(txtName2);
        
        txtTime2 = new JTextField();
        txtTime2.setBackground(new Color(250,242,208));
        txtTime2.setEditable(false);
        txtTime2.setColumns(10);
        txtTime2.setBounds(63, 178, 105, 20);
        panelSched.add(txtTime2);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(83, 209, 17, 21);
        panelSched.add(scrollBar);
        
        JPanel panelHead = new JPanel();
        panelHead.setBackground(new Color(255, 228, 225));
        panelHead.setBounds(0, 0, 697, 155);
        frame.getContentPane().add(panelHead);
        panelHead.setLayout(null);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setBounds(22, 11, 134, 133);
        panelHead.add(logoLabel);
        
        timeLabel = new JLabel();
        timeLabel.setForeground(new Color(255, 20, 147));
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        timeLabel.setBounds(210, 47, 266, 43);
        panelHead.add(timeLabel);
        timeLabel.setText(time);
        
        dayLabel = new JLabel();
        dayLabel.setForeground(new Color(255, 20, 147));
        dayLabel.setBackground(new Color(255, 20, 147));
        dayLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        dayLabel.setBounds(210, 89, 139, 43);
        panelHead.add(dayLabel);
        dayLabel.setText(day);
                
        JLabel lblVcms = new JLabel("PURRFECT");
        lblVcms.setBounds(290, 0, 126, 64);
        panelHead.add(lblVcms);
        lblVcms.setForeground(new Color(255, 20, 147));
        lblVcms.setFont(new Font("Century Gothic", Font.BOLD, 25));
        
        dateLabel = new JLabel();
        dateLabel.setBounds(333, 89, 184, 43);
        panelHead.add(dateLabel);
        dateLabel.setForeground(new Color(255, 20, 147));
        dateLabel.setBackground(new Color(255, 20, 147));
        dateLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        dateLabel.setText(date);
        
        /*dateSched = new JLabel();
        dateSched.setText((String) null);
        dateSched.setFont(new Font("Verdana", Font.PLAIN, 14));
        dateSched.setBounds(10, 23, 168, 29);
        panelSched.add(dateSched);
        */
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
                        Thread.sleep(1000); // Update every second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        updateTimeThread.start();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInformation)) {
			frame.dispose();
			new searchClientAndPet();
		}
		
		if(e.getSource().equals(btnAppointment)) {
			frame.dispose();
			new Appointment();
		}	

		if(e.getSource().equals(btnTreatment)) {
			frame.dispose();
			new Treatment();
		}	

		if(e.getSource().equals(btnPrescription)) {
			frame.dispose();
			new Prescription();
		}


		if(e.getSource().equals(btnReports)) {
			frame.dispose();
			new monthlyReports();
		}	

		if(e.getSource().equals(btnLogout)) {
			int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to log out?", "Confirmation",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
			
			if(result == JOptionPane.YES_OPTION) {
				frame.dispose();
				new loginWall();
			} else if(result == JOptionPane.NO_OPTION) {
				return;
			}
		}	

		if(e.getSource().equals(btnExit)) {
			frame.dispose();
		}	
	}
	
	
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            new Dashboard();
        });
    
    }

    public Dashboard() {
        initialize();
        frame.setVisible(true);
        setTime();
    }
}
