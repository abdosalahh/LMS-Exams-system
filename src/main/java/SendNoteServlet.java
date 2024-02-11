import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SendNoteServlet
 */
public class SendNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int studentId = Integer.parseInt(request.getParameter("id"));
		    String name = request.getParameter("name");
	        String email = request.getParameter("email");
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
	            String storedProcedureCall = "CALL SendNoteToPrinciple(?,?, ?, ?)";
	            try (PreparedStatement statement = connection.prepareStatement(storedProcedureCall)) {
	                // Set the parameters for the stored procedure
	            	statement.setInt(4, studentId);
	                statement.setString(1, name);
	                statement.setString(2, email);
	                statement.setString(3, content);
	                

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
	        response.sendRedirect("html/note.jsp");
	    }
	}


