import java.sql.*;
import java.util.Scanner;
class CheckingStudentsGradesCommand implements Command {
    private final Scanner scanner;

    public CheckingStudentsGradesCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(int examId) {

        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL GetSubjectAndStudentGrades(?)}")) {
                callableStatement.setInt(1, examId);

                // Execute the stored procedure
                ResultSet resultSet = callableStatement.executeQuery();

                // Process the result set
                while (resultSet.next()) {
                    String studentName = resultSet.getString("student_name");
                    int grade = resultSet.getInt("Grade");

                    // Process or print the results as needed
                    System.out.println("Student: " + studentName + ", Grade: " + grade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
