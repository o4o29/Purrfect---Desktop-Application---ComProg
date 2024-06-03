import javax.swing.*;
import java.util.List;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class searchClientAndPet extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField petId_field;
    private JTextField clientId_field;
    private JFrame dashboardFrame;
    private JPopupMenu surnameSuggestionsMenu;
    
    private List<String> surnameList;

    
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
        
        JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
        lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
        lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 60));
        lblNewLabel_2_2.setBounds(263, 11, 634, 75);
        contentPane.add(lblNewLabel_2_2);

        JLabel lblNewLabel = new JLabel("CLIENT AND PET INFORMATION");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        lblNewLabel.setBounds(120, 71, 777, 75);
        contentPane.add(lblNewLabel);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(255, 182, 193));
        textArea.setBounds(0, 0, 884, 143);
        contentPane.add(textArea);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 182, 193));
        mainPanel.setBounds(192, 182, 591, 336);
        contentPane.add(mainPanel);
        mainPanel.setLayout(null);

        JPanel searcClientIDPanel = new JPanel();
        searcClientIDPanel.setBounds(30, 52, 251, 124);
        mainPanel.add(searcClientIDPanel);
        searcClientIDPanel.setBackground(new Color(255, 228, 225));
        searcClientIDPanel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Search Client");
        lblNewLabel_2.setBounds(75, 11, 106, 25);
        searcClientIDPanel.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));

        clientId_field = new JTextField();
        clientId_field.setBounds(44, 57, 157, 20);
        searcClientIDPanel.add(clientId_field);
        clientId_field.setColumns(10);
        
        
        JButton clientIdBtn = new JButton("SEARCH");
        clientIdBtn.setBounds(44, 88, 157, 25);
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
        petIdBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        petIdBtn.setBounds(51, 88, 157, 25);
        searchPetIDPanel.add(petIdBtn);
        petIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        petIdBtn.setBackground(new Color(255, 240, 245));

        JPanel searchPetIDPanel_1 = new JPanel();
        searchPetIDPanel_1.setLayout(null);
        searchPetIDPanel_1.setBackground(new Color(255, 228, 225));
        searchPetIDPanel_1.setBounds(175, 219, 253, 95);
        mainPanel.add(searchPetIDPanel_1);

        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBounds(77, 48, 101, 25);
        searchPetIDPanel_1.add(btnCreate);
        btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCreate.setBackground(new Color(255, 240, 245));

        JLabel btnNewClient = new JLabel("NEW CLIENT?");
        btnNewClient.setBounds(69, 22, 134, 14);
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
        		String input = clientId_field.getText().trim();
                DatabaseManager dbManager = DatabaseManager.getInstance();
                if (input.contains(",")) { // Search by surname
                    String[] names = input.split(",", 2); // Split into last name and first name
                    String lastName = names[0].trim();
                    String firstName = names[1].trim();
                    ResultSet resultSet = dbManager.searchClientBySurname(lastName);
                    boolean found = false;
                    while (resultSet.next()) {
                        if (resultSet.getString("lastName").equalsIgnoreCase(lastName)
                                && resultSet.getString("firstName").equalsIgnoreCase(firstName)) {
                            resultClientInformation.getClientID(resultSet.getInt("clientID"));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(this, "Client not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else { // Search by ID
                    int clientId = Integer.parseInt(input);
                    boolean clientExists = dbManager.doesClientExist(clientId);
                    if (clientExists) {
                        resultClientInformation.getClientID(clientId);
                    } else {
                        JOptionPane.showMessageDialog(this, "Client not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid client ID", "Invalid Input", JOptionPane.ERROR_MESSAGE);
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
            
            JPopupMenu popupMenu = new JPopupMenu();
            addPopup(clientId_field, popupMenu);
            
            JLabel lblNewLabel_2_3 = new JLabel("by ID or Surname:");
            lblNewLabel_2_3.setFont(new Font("Verdana", Font.PLAIN, 15));
            lblNewLabel_2_3.setBounds(54, 32, 147, 25);
            searcClientIDPanel.add(lblNewLabel_2_3);
            
            
        });
        petId_field.setText("");


        // Initialize surname list
        surnameList = new ArrayList<>();

        // Initialize surname suggestions menu
        surnameSuggestionsMenu = new JPopupMenu();

        // Add key listener to surnameField
        clientId_field.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				String partialSurname = clientId_field.getText();
                updateSurnameSuggestions(partialSurname);
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
    }

    private void updateSurnameSuggestions(String partialSurname) {
        surnameSuggestionsMenu.removeAll();
        surnameList.clear();

        if (partialSurname.isEmpty()) {
            surnameSuggestionsMenu.setVisible(false);
            return;
        }

        try {
            DatabaseManager dbManager = DatabaseManager.getInstance();
            ResultSet resultSet = dbManager.searchClientBySurname(partialSurname);

            while (resultSet.next()) {
                String surname = resultSet.getString("lastName");
                String firstname = resultSet.getString("firstName");
                surnameList.add(surname + ", " + firstname);
                JMenuItem item = new JMenuItem(surname + ", " + firstname);
                item.addActionListener(e -> {
                	clientId_field.setText(surname + ", " + firstname);
//                	updateClientDataTable(partialSurname);
                    surnameSuggestionsMenu.setVisible(false);
                });
                surnameSuggestionsMenu.add(item);
            }

            // Show the suggestions menu just below the text field
            surnameSuggestionsMenu.setFocusable(false); // Prevent the popup menu from taking focus
            surnameSuggestionsMenu.show(clientId_field, 0, clientId_field.getHeight());
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database error
        }
    }
    
//    private void updateClientDataTable(int clientId) {
//        try {
//            // Get client data from the database
//            DatabaseManager dbManager = DatabaseManager.getInstance();
//            ResultSet clientDataResultSet = dbManager.getClientById(clientId);
//
//            // Populate the table model
//            ClientDataTableModel tableModel = new ClientDataTableModel(clientDataResultSet);
//
//            // Set the table model to the JTable
//            clientDataTable.setModel(tableModel);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            // Handle database error
//        }
//    }
//
//    private void updateClientDataTable(String partialSurname) {
//        try {
//            // Get client data from the database
//            DatabaseManager dbManager = DatabaseManager.getInstance();
//            ResultSet clientDataResultSet = dbManager.searchClientBySurname(partialSurname);
//
//            // Populate the table model
//            ClientDataTableModel tableModel = new ClientDataTableModel(clientDataResultSet);
//
//            // Set the table model to the JTable
//            clientDataTable.setModel(tableModel);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            // Handle database error
//        }
//    }

    // Inner class for the table model
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
