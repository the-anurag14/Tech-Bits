import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentsDAO {
    private Connection connection;

    public AppointmentsDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create an appointment; it must throw SQLException
    public void createAppointment(int doctorId, int patientId, String dateTime, String status, String type) throws SQLException {
        String sql = "INSERT INTO Appointments (doctor_id, patient_id, appointment_date, status, consultation_type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, doctorId);
            pstmt.setInt(2, patientId);
            pstmt.setString(3, dateTime);
            pstmt.setString(4, status);
            pstmt.setString(5, type);
            pstmt.executeUpdate();
        }
    }
}
