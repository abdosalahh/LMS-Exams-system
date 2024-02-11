package connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet executeProcedure(int examId) {
        try (Connection connection = getConnection()) {
            String sql = "{CALL GetSubjectAndStudentGrades(?)}";
            try (PreparedStatement statement = connection.prepareCall(sql)) {
                statement.setInt(1, examId);
                statement.execute();
                return statement.getResultSet();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

