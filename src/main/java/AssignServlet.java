import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AssignServlet")
public class AssignServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String subject = request.getParameter("subject");
        String level = request.getParameter("level");
        String content = request.getParameter("content");

        // You need to replace these with your actual database credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/examsdatabase";
        String dbUser = "root";
        String dbPassword = "572022";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // Call the stored procedure using a prepared statement
            String storedProcedureCall = "{CALL AddAssignment(?, ?, ?)}";
            try (PreparedStatement statement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                statement.setString(1, content);
                statement.setString(2, level);
                statement.setString(3, subject);

                // Execute the stored procedure
                statement.executeUpdate();
            }

            // Close the database connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        // Redirect to a success page or back to the form page
        response.sendRedirect("html/assignments.jsp");
    }
}
