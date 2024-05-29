import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class searchClientAndPet extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField petId_field;
    private JTextField clientId_field;
    private JFrame dashboardFrame;
    
    
 // ----------------------------------------------------------------------------------------------------------------------------------
    private void initialize() {
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 228, 225));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("CLIENT AND PET");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 55));
        lblNewLabel.setBounds(174, 23, 532, 75);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("INFORMATION\r\n");
        lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 35));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(280, 83, 304, 61);
        contentPane.add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(255, 182, 193));
        textArea.setBounds(0, 0, 884, 153);
        contentPane.add(textArea);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 182, 193));
        mainPanel.setBounds(138, 177, 591, 353);
        contentPane.add(mainPanel);
        mainPanel.setLayout(null);

        JPanel searcClientIDPanel = new JPanel();
        searcClientIDPanel.setBounds(30, 52, 251, 124);
        mainPanel.add(searcClientIDPanel);
        searcClientIDPanel.setBackground(new Color(255, 228, 225));
        searcClientIDPanel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Search Client ID:");
        lblNewLabel_2.setBounds(63, 21, 163, 14);
        searcClientIDPanel.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));

        clientId_field = new JTextField();
        clientId_field.setBounds(44, 57, 157, 20);
        searcClientIDPanel.add(clientId_field);
        clientId_field.setColumns(10);

        JButton clientIdBtn = new JButton("SEARCH");
        clientIdBtn.setBounds(90, 88, 79, 25);
        searcClientIDPanel.add(clientIdBtn);
        clientIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        clientIdBtn.setBackground(new Color(255, 240, 245));

        JPanel searchPetIDPanel = new JPanel();
        searchPetIDPanel.setBounds(310, 52, 253, 124);
        mainPanel.add(searchPetIDPanel);
        searchPetIDPanel.setBackground(new Color(255, 228, 225));
        searchPetIDPanel.setLayout(null);

        JLabel lblNewLabel_2_1 = new JLabel("Search Pet ID:");
        lblNewLabel_2_1.setBounds(77, 22, 115, 14);
        searchPetIDPanel.add(lblNewLabel_2_1);
        lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));

        petId_field = new JTextField();
        petId_field.setBounds(51, 57, 157, 20);
        searchPetIDPanel.add(petId_field);
        petId_field.setColumns(10);

        JButton petIdBtn = new JButton("SEARCH");
        petIdBtn.setBounds(91, 88, 79, 25);
        searchPetIDPanel.add(petIdBtn);
        petIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        petIdBtn.setBackground(new Color(255, 240, 245));

        JPanel searchPetIDPanel_1 = new JPanel();
        searchPetIDPanel_1.setLayout(null);
        searchPetIDPanel_1.setBackground(new Color(255, 228, 225));
        searchPetIDPanel_1.setBounds(175, 227, 253, 115);
        mainPanel.add(searchPetIDPanel_1);

        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBounds(78, 63, 101, 25);
        searchPetIDPanel_1.add(btnCreate);
        btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCreate.setBackground(new Color(255, 240, 245));

        JLabel btnNewClient = new JLabel("NEW CLIENT?");
        btnNewClient.setBounds(70, 37, 134, 14);
        searchPetIDPanel_1.add(btnNewClient);
        btnNewClient.setFont(new Font("Verdana", Font.BOLD, 15));

        JLabel lblNewLabel_1_1 = new JLabel("For Existing Client");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(195, 0, 211, 61);
        mainPanel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("For New Client");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
        lblNewLabel_1_1_1.setBounds(215, 170, 175, 61);
        mainPanel.add(lblNewLabel_1_1_1);

        // LISTENERS
        addWindowListener(new WindowAdapter() { // exiting window
            public void windowClosing(WindowEvent e) {
                if (dashboardFrame != null) {
                    dashboardFrame.setEnabled(true);
                }
                dispose();
            }
        });

        btnCreate.addActionListener(e -> { // create a new client
            new createClientInformation();
        });

        clientIdBtn.addActionListener(e -> { // search a client
            try {
                int clientId = Integer.parseInt(clientId_field.getText());
                DatabaseManager dbManager = DatabaseManager.getInstance();
                boolean clientExists = dbManager.doesClientExist(clientId);

                if (clientExists) {
                    resultClientInformation.getClientID(clientId);
                } else {
                    JOptionPane.showMessageDialog(this, "Client not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex + " Please enter a valid client ID", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while searching for the client", "Error", JOptionPane.ERROR_MESSAGE);
            }

            clientId_field.setText("");
            petId_field.setText("");
        });


        petIdBtn.addActionListener(e -> { // search a pet
            try {
                int petId = Integer.parseInt(petId_field.getText());
                DatabaseManager dbManager = DatabaseManager.getInstance();
                boolean petExists = dbManager.doesPetExist(petId);

                if (petExists) {
                    resultPetInformation.getPetId(petId);
                } else {
                    JOptionPane.showMessageDialog(this, "Pet not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex + " Please enter a valid pet ID", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while searching for the client", "Error", JOptionPane.ERROR_MESSAGE);
            }

            clientId_field.setText("");
            petId_field.setText("");
        });
    }
    // ----------------------------------------------------------------------------------------------------------------------------------
    
    
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }

    public searchClientAndPet() {
        initialize();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new searchClientAndPet();
        });
    }
}