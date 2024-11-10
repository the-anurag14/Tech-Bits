//Project

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = null; // Declare a connection variable
        try {
            connection = dbConnection.connect(); // Connect to the database and retrieve the connection
            System.out.println("Database connected successfully.");

            // Create user, doctor, patient, and appointment
            UsersDAO usersDAO = new UsersDAO(connection);
            usersDAO.createUser("John Doe", "john@example.com", "password", "Patient", "1234567890", Date.valueOf("1990-01-01"), "123 Main St");

            // Here, we assume that user_id for John Doe is 1 since it's the first entry.
            DoctorsDAO doctorsDAO = new DoctorsDAO(connection); // Pass connection to DoctorsDAO
            doctorsDAO.createDoctor(1, "Cardiology", "L12345", 150.00, "Mon-Fri 9AM-5PM");

            PatientsDAO patientsDAO = new PatientsDAO(connection); // Pass connection to PatientsDAO
            patientsDAO.createPatient(1, "No known allergies", "INS123456", "9876543210");

            AppointmentsDAO appointmentsDAO = new AppointmentsDAO(connection); // Pass connection to AppointmentsDAO
            appointmentsDAO.createAppointment(1, 1, "2024-10-30 10:00:00", "Pending", "Online");

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        } finally {
            // Close the connection in the finally block to ensure it's closed
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}
