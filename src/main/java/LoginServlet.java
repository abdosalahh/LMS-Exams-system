

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	private int getUserIDFromDatabase(String email) {
	    int userId = -1; // Default value if the user is not found or an error occurs
	    
	    // Database connection details
	    String jdbcUrl = "jdbc:mysql://localhost:3306/examsdatabase";
	    String dbUser = "root";
	    String dbPassword = "572022";

	    try {
	        // Load the JDBC driver
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Establish a connection
	        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
	            // Prepare the SQL query
	            String sql = "SELECT Sid FROM student WHERE email=?";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, email);

	                // Execute the query
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    // Check if a user was found
	                    if (resultSet.next()) {
	                        userId = resultSet.getInt("Sid");
	                    }
	                }
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace(); // Handle the exception appropriately in your application
	    }

	    return userId;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
        String password = request.getParameter("Password");
        LoginFactory loginFactory = new LoginFactory();
        
        
        if ("teacher".equals(request.getParameter("Type")))
        {
            User user = loginFactory.getUesr("teacher");
	    	 if(user.Login(email,password))
	    	 {
	    		 response.sendRedirect("html/teacher.jsp");
	    	 }
	    	 else
	    	 {
	    		 response.sendRedirect("html/login.jsp");
	    	 }
        }
        else if ("student".equals(request.getParameter("Type")))
        {
              User user = loginFactory.getUesr("student");
              if (user.Login(email,password))
              {	
            	  String loginQuery = "SELECT Sid FROM student WHERE email=? AND password=?";
 	    		  int userId = getUserIDFromDatabase(email);
 	    		  HttpSession session = request.getSession();
 	    		  session.setAttribute("userId", userId);
             	  response.sendRedirect("html/student.jsp"); 
              }
              else
 	    	 {
 	    		 response.sendRedirect("html/login.jsp");
 	    	 }
            
        } 
        else if ("principle".equals(request.getParameter("Type"))) 
        {
              User user = loginFactory.getUesr("principle");
             if (user.Login(email,password))
             {
            	 response.sendRedirect("html/principle.jsp");
             }
             else
 	    	 {
 	    		 response.sendRedirect("html/login.jsp");
 	    	 }  
        }
	}

}
