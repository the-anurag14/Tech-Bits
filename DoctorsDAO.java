import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorsDAO {
    private Connection connection;

    public DoctorsDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a doctor; it must throw SQLException
    public void createDoctor(int userId, String specialization, String licenseNumber, double consultationFee, String availableHours) throws SQLException {
        String sql = "INSERT INTO Doctors (doctor_id, specialization, license_number, consultation_fee, available_hours) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId); // user_id should match doctor_id in Users table
            pstmt.setString(2, specialization);
            pstmt.setString(3, licenseNumber);
            pstmt.setDouble(4, consultationFee);
            pstmt.setString(5, availableHours);
            pstmt.executeUpdate();
        }
    }
}
