import java.sql.*;
import java.util.Scanner;

class DeleteExamCommand implements Command {
    private final Scanner scanner;
    public DeleteExamCommand(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public void execute(int examId) {

        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String user = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (CallableStatement deleteExamStatement = connection.prepareCall("{CALL DeleteExamDetails(?)}")) {
                deleteExamStatement.setInt(1, examId);

                boolean hasResult = deleteExamStatement.execute();

                if (hasResult) {
                    // Process the result if needed
                    try (ResultSet resultSet = deleteExamStatement.getResultSet()) {
                        while (resultSet.next()) {
                            String result = resultSet.getString("Result");
                            System.out.println(result);
                        }
                    }
                } else {
                    System.out.println("Exam details deleted successfully.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
