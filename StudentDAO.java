import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    public static void addStudent(String name, String email, int age, String course) {
        String query = "INSERT INTO students (name, email, age, course) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.setString(4, course);
            stmt.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewStudents() {
        String query = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") + ", Age: " + rs.getInt("age") +
                        ", Course: " + rs.getString("course"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
