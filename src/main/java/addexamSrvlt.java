

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet implementation class addexamSrvlt
 */
public class addexamSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addexamSrvlt() {
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
		 // Retrieve form parameters
        int Tid = Integer.parseInt(request.getParameter("Tid"));
        String examName = request.getParameter("examName");
        String examType = request.getParameter("examType");
        String startTimeString = request.getParameter("StartTime");
        String endTimeString = request.getParameter("EndTime");
        int totalGrade = Integer.parseInt(request.getParameter("totalGrade"));
        int yearlevel = Integer.parseInt(request.getParameter("yearLevel"));

        // Call the Java functions to add the new exam, questions, and choices
        Teacher t = new Teacher();
        t.AddNewExam(Tid, examName, examType, startTimeString, endTimeString, totalGrade, yearlevel);
        
        	
        // Redirect to the JSP page (optional)
        response.sendRedirect("html/newExam.jsp");
	}

}
