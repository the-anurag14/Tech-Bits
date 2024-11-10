import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientsDAO {
    private Connection connection;

    public PatientsDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a patient; it must throw SQLException
    public void createPatient(int userId, String medicalHistory, String insuranceNumber, String emergencyContact) throws SQLException {
        String sql = "INSERT INTO Patients (patient_id, medical_history, insurance_number, emergency_contact) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId); // user_id should match patient_id in Users table
            pstmt.setString(2, medicalHistory);
            pstmt.setString(3, insuranceNumber);
            pstmt.setString(4, emergencyContact);
            pstmt.executeUpdate();
        }
    }
}
