import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/purrfect_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;
    private static DatabaseManager instance;

    private DatabaseManager() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static DatabaseManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                instance = null; // Reset instance when connection is closed
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    // METHODS
    // Client
    public int insertClient(String firstName, String lastName, String address, String contactNumber, String emailAddress) throws SQLException {
        String query = "INSERT INTO client (firstName, lastName, address, contactNumber, emailAddress) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, address);
        statement.setString(4, contactNumber);
        statement.setString(5, emailAddress);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated client ID
        }
        return -1; // Return -1 if no key was generated
    }
    
    public int updateClient(int clientId, String firstName, String lastName, String address, String contactNumber, String emailAddress) throws SQLException {
        String query = "UPDATE client SET firstName = ?, lastName = ?, address = ?, contactNumber = ?, emailAddress = ? WHERE clientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, address);
        statement.setString(4, contactNumber);
        statement.setString(5, emailAddress);
        statement.setInt(6, clientId);
        return statement.executeUpdate();
    }

    
    public boolean doesClientExist(int clientId) throws SQLException {
        String query = "SELECT * FROM client WHERE clientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, clientId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public ResultSet getClientById(int clientId) throws SQLException {
        String query = "SELECT * FROM client WHERE clientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, clientId);
        return statement.executeQuery();
    }
    
    // Pet
    public int insertPet(int clientId, String petname, String petspecies, String petbreed, String petweight, String petage, String petgender, String petcolor) throws SQLException {
        String query = "INSERT INTO pet (clientID, petName, petSpecies, petBreed, petWeight, petAge, petGender, petColor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, clientId);
        statement.setString(2, petname);
        statement.setString(3, petspecies);
        statement.setString(4, petbreed);
        statement.setString(5, petweight);
        statement.setString(6, petage);
        statement.setString(7, petgender);
        statement.setString(8, petcolor);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated client ID
        }
        return -1; // Return -1 if no key was generated
    }   

    public int updatePet(int petId, String petname, String petspecies, String petbreed, String petweight, String petage, String petgender, String petcolor) throws SQLException {
        String query = "UPDATE pet SET petName = ?, petSpecies = ?, petBreed = ?, petWeight = ?, petAge = ?, petGender = ?, petColor = ? WHERE petID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, petname);
        statement.setString(2, petspecies);
        statement.setString(3, petbreed);
        statement.setString(4, petweight);
        statement.setString(5, petage);
        statement.setString(6, petgender);
        statement.setString(7, petcolor);
        statement.setInt(8, petId);
        return statement.executeUpdate();
    }

    public boolean doesPetExist(int petId) throws SQLException {
        String query = "SELECT * FROM pet WHERE petID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, petId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
    
    public ResultSet getPetById(int petId) throws SQLException {
        String query = "SELECT * FROM pet WHERE petID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, petId);
        return statement.executeQuery();
    }
    
    public ResultSet getPetByClientAndIndex(int clientID, int petIndex) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            
            String query = "SELECT * FROM pet WHERE clientID = ? LIMIT ?, 1";
            
            statement = connection.prepareStatement(query);
            statement.setInt(1, clientID);
            statement.setInt(2, petIndex - 1);
            
            resultSet = statement.executeQuery();
            
            return resultSet;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
            return null;
        }
    }
    
    public int getPetCountByClientId(int clientId) throws SQLException {
        String query = "SELECT COUNT(*) AS petCount FROM pet WHERE clientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, clientId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	int petCount = resultSet.getInt("petCount");
            System.out.println("Pet count for client " + clientId + ": " + petCount); // Debug statement
            return petCount;
        } else {
        	return 0;
        }
    } 
    
    
    // Appointment
    public int insertAppointment(int clientId, int petId, String servicesJson, Date date, Time time, double payment, String petName) throws SQLException {
        String query = "INSERT INTO appointment (clientID, petID, petName, services, date, time, payment) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, clientId);
        statement.setInt(2, petId);
        statement.setString(3, petName);
        statement.setString(4, servicesJson);
        statement.setDate(5, date);
        statement.setTime(6, time);
        statement.setDouble(7, payment);
        // Execute the query
        statement.executeUpdate();
        
        // Get the generated keys
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated appointment ID
        }
        
        return -1; // Return -1 if no key was generated
    }
    
    public boolean doesAppointmentExist(int appointId) throws SQLException {
        String query = "SELECT * FROM appointment WHERE appointmentID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, appointId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public ResultSet getAppointmentById(int appointId) throws SQLException {
        String query = "SELECT * FROM appointment WHERE appointmentID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, appointId);
        return statement.executeQuery();
    }
    
    public ResultSet getAppointmentsForDate(Date date) throws SQLException {
        String query = "SELECT petName, time FROM appointment WHERE date = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, date);
        return statement.executeQuery();
    }
    
    public String getServiceNameById(int serviceId) throws SQLException {
        String serviceName = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection(); // Assuming getConnection() is a method to establish a database connection

            String query = "SELECT serviceName FROM services WHERE serviceID = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, serviceId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                serviceName = resultSet.getString("serviceName");
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }

        return serviceName;
    }

    
    public double getServicePriceById(int serviceId) throws SQLException {
        String query = "SELECT servicePrice FROM services WHERE serviceID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, serviceId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("servicePrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return 0.0; // Return 0 if no price found (handle appropriately in calling method)
    }
}