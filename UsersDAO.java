import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {
    private Connection connection;

    public UsersDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a user; it must throw SQLException
    public void createUser(String name, String email, String password, String role, String contactNumber, Date birthDate, String address) throws SQLException {
        String sql = "INSERT INTO Users (name, email, password, role, contact_number, date_of_birth, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, role);
            pstmt.setString(5, contactNumber);
            pstmt.setDate(6, birthDate);
            pstmt.setString(7, address);
            pstmt.executeUpdate();
        }
    }
}
