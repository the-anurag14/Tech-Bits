import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected Connection connection;

    // Method to connect to the database and return the Connection object
    public Connection connect() {
        try {
            // Update these values with your database credentials
            String url = "jdbc:mysql://localhost:3306/hospital_management"; // Your database URL
            String user = "root"; // Your database username
            String password = "rohit"; // Your database password

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully");
            return connection; // Return the Connection object
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return null; // Return null in case of failure
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }
}
