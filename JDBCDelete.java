CREATE DATABASE college;
USE college;
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);

INSERT INTO student VALUES (101, 'Ravi', 85);
INSERT INTO student VALUES (102, 'Raju', 90);
Java program
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDelete {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "root";

        try {
            // Step 1: Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            // Step 2: Prepare DELETE query
            String query = "DELETE FROM student WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            // Step 3: Set student ID to delete
            ps.setInt(1, 101);

            // Step 4: Execute DELETE query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Record not found.");
            }

            // Step 5: Close resources
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
