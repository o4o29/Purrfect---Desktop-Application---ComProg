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
    private static final String URL = "jdbc:mysql://localhost:3306/purrfect_db?defaultResultSetType=TYPE_SCROLL_INSENSITIVE";
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
    public int insertClient(String firstName, String lastName, String address, String contactNumber, String emailAddress, Date dateCreated) throws SQLException {
        String query = "INSERT INTO client (firstName, lastName, address, contactNumber, emailAddress, dateCreated) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, address);
        statement.setString(4, contactNumber);
        statement.setString(5, emailAddress);
        statement.setDate(6, dateCreated);
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
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client WHERE clientID = ?");
        preparedStatement.setInt(1, clientId);
        return preparedStatement.executeQuery();
    }


    
    public ResultSet searchClientBySurname(String partialSurname) throws SQLException {
        String query = "SELECT lastName, firstName, clientID FROM client WHERE lastName LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, partialSurname + "%");
        return statement.executeQuery();
    }

    
    // Pet
    public int insertPet(int clientId, String petname, String pettype, String petbreed, String petweight, Date birthdate, String petage, String petgender, String petcolor, String clientName) throws SQLException {
        String query = "INSERT INTO pet (clientID, petName, petType, petBreed, petWeight, petBirthdate, petAge, petGender, petColor, clientName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, clientId);
        statement.setString(2, petname);
        statement.setString(3, pettype);
        statement.setString(4, petbreed);
        statement.setString(5, petweight);
        statement.setDate(6, birthdate);
        statement.setString(7, petage);
        statement.setString(8, petgender);
        statement.setString(9, petcolor);
        statement.setString(10, clientName);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated client ID
        }
        return -1; // Return -1 if no key was generated
    }   

    public int updatePet(int petId, String petname, String pettype, String petbreed, String petweight, Date petbirthdate, String petage, String petgender, String petcolor) throws SQLException {
        String query = "UPDATE pet SET petName = ?, petType = ?, petBreed = ?, petWeight = ?, petBirthdate = ?, petAge = ?, petGender = ?, petColor = ? WHERE petID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, petname);
        statement.setString(2, pettype);
        statement.setString(3, petbreed);
        statement.setString(4, petweight);
        statement.setDate(5, petbirthdate);
        statement.setString(6, petage);
        statement.setString(7, petgender);
        statement.setString(8, petcolor);
        statement.setInt(9, petId);
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
    public int insertAppointment(int clientId, int petId, String servicesJson, Date date, Time time, double payment, String petName, String clientName) throws SQLException {
        String query = "INSERT INTO appointment (clientID, clientName, petID, petName, services, date, time, payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, clientId);
        statement.setString(2, clientName);
        statement.setInt(3, petId);
        statement.setString(4, petName);
        statement.setString(5, servicesJson);
        statement.setDate(6, date);
        statement.setTime(7, time);
        statement.setDouble(8, payment);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        
        return -1;
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
    
    // SEARCHING RECORDS
    public ResultSet searchClientByKeyword(String keyword) throws SQLException {
    	if (keyword.length() >= 2) {
    		String query = "SELECT * FROM client WHERE (firstName LIKE ? OR lastName LIKE ? OR contactNumber LIKE ? AND LENGTH(?) >= 3)";
    		PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            statement.setString(4, "%" + keyword + "%");
            
            return statement.executeQuery();
    	} else {
    		String query = "SELECT * FROM client WHERE clientID LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            return statement.executeQuery();
    	}
        
    }
    
    public ResultSet searchPetByKeyword(String keyword) throws SQLException {
        if (keyword.length() >= 2) {
            String query = "SELECT * FROM pet WHERE (petName LIKE ? AND LENGTH(?) >= 3)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            
            return statement.executeQuery();
        } else {
        	String query = "SELECT * FROM pet WHERE petID LIKE ?";
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            
            return statement.executeQuery();
        }
    }

    public ResultSet getPetByClientId(int clientId) throws SQLException {
        String query = "SELECT * FROM pet WHERE clientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, clientId);
        return statement.executeQuery();
    }
    
    // APPOINTMENT RECORDS
    public ResultSet searchAppointmentByKeyword(String keyword) throws SQLException {
    	if (keyword.length() >= 2) {
            String query = "SELECT * FROM appointment WHERE (petName LIKE ? OR clientName LIKE ? OR DATE_FORMAT(`Date`, '%M %d, %Y') LIKE ?AND LENGTH(?) >= 3)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            statement.setString(4, "%" + keyword + "%");
            
            return statement.executeQuery();
        } else {
        	String query = "SELECT * FROM appointment WHERE appointmentID LIKE ? OR Date LIKE ? OR Time LIKE ? OR petID LIKE ? OR clientID LIKE ?";
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            statement.setString(4, "%" + keyword + "%");
            statement.setString(5, "%" + keyword + "%");
            
            return statement.executeQuery();
        }
    }
    
    // TREATMENT
    public int insertTreatment(int appointmentId, int petId, String petName, String services, Date date, Time time, double vitalTemp, double vitalHeartRate, double vitalRespRate, String hasVaccine, String vaccineName, String vaccineAgainst, String vaccineOthers, String treatmentPlans, String medicalProcedure, String diagnosis, String deworming, String followUpCheckUp) throws SQLException {
        String query = "INSERT INTO treatment (appointmentID, petID, petName, services, date, time, vitalTemp, vitalHeartRate, vitalRespRate, hasVaccine, vaccineName, vaccineAgainst, vaccineOthers, treatmentPlans, medicalProcedure, diagnosis, deworming, followUpCheckUp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, appointmentId);
        statement.setInt(2, petId);
        statement.setString(3, petName);
        statement.setString(4, services);
        statement.setDate(5, date);
        statement.setTime(6, time);
        statement.setDouble(7, vitalTemp);
        statement.setDouble(8, vitalHeartRate);
        statement.setDouble(9, vitalRespRate);
        statement.setString(10, hasVaccine);
        statement.setString(11, vaccineName);
        statement.setString(12, vaccineAgainst);
        statement.setString(13, vaccineOthers);
        statement.setString(14, treatmentPlans);
        statement.setString(15, medicalProcedure);
        statement.setString(16, diagnosis);
        statement.setString(17, deworming);
        statement.setString(18, followUpCheckUp);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        
        return -1;
    }
    
    public ResultSet getTreatmentByPetId(int petID) throws SQLException {
        String query = "SELECT date, services, diagnosis FROM treatment WHERE petID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, petID);
        return statement.executeQuery();
    }
    
    // PRESCRIPTION
    public int insertPrescription(int petID, String drugName, String drugDosage, Time drugDuration, Time drugTakeTime, String additionalInstructions) throws SQLException {
        String query = "INSERT INTO prescription (petID, drugName, drugDosage, drugDuration, drugTakeTime, additionalInstructions) VALUES (?, ?, ?, ?, ?, ?)"; 
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, petID);
        statement.setString(2, drugName);
        statement.setString(3, drugDosage);
        statement.setTime(4, drugDuration);
        statement.setTime(5, drugTakeTime);
        statement.setString(6, additionalInstructions);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated client ID
        }
        return -1; // Return -1 if no key was generated
    }  
    
    // LOGIN; SIGNUP
    public boolean validateLogin(String username, String password) throws SQLException {
        String query = "SELECT * FROM admin WHERE LOWER(username) = LOWER(?) AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }


    public boolean updatePassword(String username, String newPassword) throws SQLException {
        String query = "UPDATE admin SET password = ? WHERE LOWER(username) = LOWER(?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newPassword);
            statement.setString(2, username);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; // Return true if at least one row was updated
        }
    }


    
    public int insertAdmin(String username, String password, Date created_at) throws SQLException {
        String query = "INSERT INTO admin (username, password, created_at) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setDate(3, created_at);
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated client ID
        }
        return -1; // Return -1 if no key was generated
    }
    
    public boolean doesAdminExist(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM admin WHERE LOWER(username) = LOWER(?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    // REPORT GENERATION
    public ResultSet getAllClients() throws SQLException {
        String query = "SELECT * FROM client";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }
    
    public ResultSet getAllPets() throws SQLException {
        String query = "SELECT * FROM pet";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }
    
    public ResultSet getAllAppointments() throws SQLException {
        String query = "SELECT * FROM appointment";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }
    
    public ResultSet getAllTreatments() throws SQLException {
        String query = "SELECT * FROM treatment";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }
    
    public ResultSet getAllPrescriptions() throws SQLException {
        String query = "SELECT * FROM prescription";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }
}