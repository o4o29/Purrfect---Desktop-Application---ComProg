import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void insertClient(String firstname, String lastname, String address, String contact, String email) throws SQLException {
        String query = "INSERT INTO client (firstname, lastname, address, contact, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, address);
            statement.setString(4, contact);
            statement.setString(5, email);
            statement.executeUpdate();
        }
    }
    
    public void insertPet(String ownerID, String petname, String petspecies, String petbreed, String petgender, String petweight, String petage, String petcolor) throws SQLException {
    	String query = "INSERT INTO pet (ownerId, petname, speci, breed, gender, weight, age, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    	try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ownerID);
            statement.setString(2, petname);
            statement.setString(3, petspecies);
            statement.setString(4, petbreed);
            statement.setString(5, petgender);
            statement.setString(6, petweight);
            statement.setString(7, petage);
            statement.setString(8, petcolor);
            statement.executeUpdate();
        }
    }
    
    public boolean checkClientExists(int clientID) throws SQLException {
        String query = "SELECT * FROM client WHERE clientID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientID);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    public ResultSet getClientInformation(int clientID) throws SQLException {
        String query = "SELECT * FROM client WHERE clientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, clientID);
        return statement.executeQuery();
    }

    
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}
