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
    	surnameList = new ArrayList<>();
        surnameSuggestionsMenu = new JPopupMenu();
        
        setSize(550, 580);
        setResizable(false);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 20, 147));
        contentPane.setBackground(new Color(255, 228, 225));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel_2_2 = new JLabel("PURRFECT");
        lblNewLabel_2_2.setBackground(new Color(255, 20, 147));
        lblNewLabel_2_2.setForeground(new Color(255, 20, 147));
        lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 50));
        lblNewLabel_2_2.setBounds(147, 0, 257, 75);
        contentPane.add(lblNewLabel_2_2);

        JLabel lblNewLabel = new JLabel("Veterinary Clinic Management System");
        lblNewLabel.setForeground(new Color(255, 20, 147));
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblNewLabel.setBounds(70, 41, 393, 75);
        contentPane.add(lblNewLabel);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(255, 182, 193));
        textArea.setBounds(0, 0, 534, 100);
        contentPane.add(textArea);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 182, 193));
        mainPanel.setBounds(10, 111, 514, 403);
        contentPane.add(mainPanel);
        mainPanel.setLayout(null);
        
        JLabel lblNewLabel_1_1_2_2_2_2_1_1 = new JLabel("Repeat this process for pets, ensuring both IDs exist in the system.");
        lblNewLabel_1_1_2_2_2_2_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_2_2_2_2_1_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
        lblNewLabel_1_1_2_2_2_2_1_1.setBounds(51, 229, 421, 32);
        mainPanel.add(lblNewLabel_1_1_2_2_2_2_1_1);
        
        JLabel lblNewLabel_1_1_2_2_2_2_1 = new JLabel("If you can't recall the ID, return to the main menu and search for the records. ");
        lblNewLabel_1_1_2_2_2_2_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_2_2_2_2_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
        lblNewLabel_1_1_2_2_2_2_1.setBounds(10, 208, 504, 32);
        mainPanel.add(lblNewLabel_1_1_2_2_2_2_1);
        
        JLabel lblNewLabel_1_1_2_2_2_2 = new JLabel("Please input the client ID to access their information.");
        lblNewLabel_1_1_2_2_2_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_2_2_2_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
        lblNewLabel_1_1_2_2_2_2.setBounds(86, 186, 349, 32);
        mainPanel.add(lblNewLabel_1_1_2_2_2_2);
        
        JLabel lblNewLabel_1_1_2_2_2 = new JLabel("RETURNING CLIENT");
        lblNewLabel_1_1_2_2_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_2_2_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblNewLabel_1_1_2_2_2.setBounds(175, 143, 167, 32);
        mainPanel.add(lblNewLabel_1_1_2_2_2);
        
        JLabel lblNewLabel_1_1_2_2_2_1 = new JLabel("NEW CLIENT?");
        lblNewLabel_1_1_2_2_2_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_2_2_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblNewLabel_1_1_2_2_2_1.setBounds(194, 11, 140, 32);
        mainPanel.add(lblNewLabel_1_1_2_2_2_1);
        
        JLabel lblNewLabel_1_1_2_2_2_1_1 = new JLabel("___________________________________________________________");
        lblNewLabel_1_1_2_2_2_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_2_2_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblNewLabel_1_1_2_2_2_1_1.setBounds(0, 116, 531, 32);
        mainPanel.add(lblNewLabel_1_1_2_2_2_1_1);

        JPanel searcClientIDPanel = new JPanel();
        searcClientIDPanel.setBounds(94, 272, 302, 48);
        mainPanel.add(searcClientIDPanel);
        searcClientIDPanel.setBackground(new Color(255, 228, 225));
        searcClientIDPanel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Input Client ID:");
        lblNewLabel_2.setBounds(10, 11, 116, 25);
        searcClientIDPanel.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        clientId_field = new JTextField();
        clientId_field.setBounds(124, 15, 141, 20);
        searcClientIDPanel.add(clientId_field);
        clientId_field.setColumns(10);
        
        
        JButton clientIdBtn = new JButton("");
        clientIdBtn.setBorderPainted(false);
        clientIdBtn.setForeground(new Color(255, 228, 225));
        clientIdBtn.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\search.png"));
        clientIdBtn.setBounds(264, 11, 28, 25);
        searcClientIDPanel.add(clientIdBtn);
        clientIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        clientIdBtn.setBackground(new Color(255, 228, 225));

        JPanel searchPetIDPanel = new JPanel();
        searchPetIDPanel.setBounds(94, 331, 302, 48);
        mainPanel.add(searchPetIDPanel);
        searchPetIDPanel.setBackground(new Color(255, 228, 225));
        searchPetIDPanel.setLayout(null);

        JLabel lblNewLabel_2_1 = new JLabel("Input Pet ID:");
        lblNewLabel_2_1.setBounds(10, 11, 115, 25);
        searchPetIDPanel.add(lblNewLabel_2_1);
        lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        JButton petIdBtn = new JButton("");
        petIdBtn.setBorderPainted(false);
        petIdBtn.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\search.png"));
        petIdBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        petIdBtn.setBounds(263, 11, 29, 25);
        searchPetIDPanel.add(petIdBtn);
        petIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        petIdBtn.setBackground(new Color(255, 228, 225));
        
        petId_field = new JTextField();
        petId_field.setBounds(122, 15, 141, 20);
        searchPetIDPanel.add(petId_field);
        petId_field.setColumns(10);
        petId_field.setText("");


        JPanel searchPetIDPanel_1 = new JPanel();
        searchPetIDPanel_1.setLayout(null);
        searchPetIDPanel_1.setBackground(new Color(255, 228, 225));
        searchPetIDPanel_1.setBounds(160, 54, 182, 77);
        mainPanel.add(searchPetIDPanel_1);

        JButton btnCreate = new JButton("Register");
        btnCreate.setIcon(new ImageIcon("C:\\Users\\juliebeth\\Pictures\\comprog\\arrow.png"));
        btnCreate.setBounds(33, 41, 115, 25);
        searchPetIDPanel_1.add(btnCreate);
        btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        btnCreate.setBackground(new Color(255, 240, 245));

        JLabel btnNewClient = new JLabel("Register New Client");
        btnNewClient.setBounds(23, 11, 154, 25);
        searchPetIDPanel_1.add(btnNewClient);
        btnNewClient.setFont(new Font("Century Gothic", Font.PLAIN, 15));

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
        		String input = clientId_field.getText();
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
        });


        petIdBtn.addActionListener(e -> { // search a pet
            try {
                DatabaseManager dbManager = DatabaseManager.getInstance();
                int petId = Integer.parseInt(petId_field.getText());
                

                boolean petExists = dbManager.doesPetExist(petId);

                if (petExists) {
                    resultPetInformation.getPetId(petId);
                } else {
                    JOptionPane.showMessageDialog(this, "Pet not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                petId_field.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid pet ID", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while searching for the pet", "Error", JOptionPane.ERROR_MESSAGE);
            }

            clientId_field.setText("");
            
            JPopupMenu popupMenu = new JPopupMenu();
            addPopup(clientId_field, popupMenu);
        });
        
        clientId_field.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				String partialSurname = clientId_field.getText();
                updateSurnameSuggestions(partialSurname);
			}
			
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}
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
                    surnameSuggestionsMenu.setVisible(false);
                });
                item.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            clientId_field.setText(surname + ", " + firstname);
                            surnameSuggestionsMenu.setVisible(false);
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        item.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        item.setBackground(UIManager.getColor("Menu.background"));
                    }
                });
                surnameSuggestionsMenu.add(item);
            }

            if (surnameSuggestionsMenu.getComponentCount() > 0) {
                surnameSuggestionsMenu.setFocusable(false);
                surnameSuggestionsMenu.show(clientId_field, 0, clientId_field.getHeight());
            } else {
                surnameSuggestionsMenu.setVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




    
    // ----------------------------------------------------------------------------------------------------------------------------------
    
    
    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }

    public searchClientAndPet() {
    	setTitle("Information");
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