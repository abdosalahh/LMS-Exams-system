import java.sql.*;
import java.util.Scanner;

public class Teacher extends User {
    private  TeacherCommandInvoker commandInvoker;
    private  Scanner scanner;

    public Teacher() {
        super();
        this.commandInvoker = new TeacherCommandInvoker();
        this.scanner = new Scanner(System.in);
    }

    double salary;
    public Teacher(int id, String name, String email, String password, long phone_Number, double salary) {
        super(id, name, email, password, phone_Number, "teacher");
        this.salary = salary;
    }
    @Override
    public boolean Login(String enteredEmail, String enteredPassword) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // SQL query to check login credentials
        String loginQuery = "SELECT * FROM teacher WHERE email=? AND password=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {

            // Set parameters for the prepared statement
            preparedStatement.setString(1, enteredEmail);
            preparedStatement.setString(2, enteredPassword);

            // Execute the query to check if the user with the given email exists
            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {
                // Check if the result set has at least one row
                if (resultSet.next()) {
                    // User exists, now compare passwords
                    String storedPassword = resultSet.getString("password");
                    if (enteredPassword.equals(storedPassword)) {
                        System.out.println("Login successful!");
                        return true;
                    } else {
                        System.out.println("Invalid credentials. Login failed.");
                        return false;
                    }
                } else {
                    // User does not exist
                    System.out.println("User does not exist. Login failed.");
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Exception occurred!", e);
        }
    }
    public void DeleteQuastionFromExam( int questionId ) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement deleteQuestionStatement = connection.prepareCall("{CALL DeleteQuestionsForExam(?)}")) {
                deleteQuestionStatement.setInt(1, questionId);

                int rowsAffected = deleteQuestionStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Question deleted successfully.");
                } else {
                    System.out.println("Question not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteChoicesFormQuestion(int choiceId) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement deleteChoicesStatement = connection.prepareCall("{CALL DeleteChoicesForQuestion(?)}")) {
                deleteChoicesStatement.setInt(1, choiceId);

                int rowsAffected = deleteChoicesStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Choices deleted successfully.");
                } else {
                    System.out.println("Choices not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddNewExam(int Tid,String examName,String examType,String  startTimeString,String endTimeString,int totalGrade,int yearlevel) 
    {
    	
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL AddNewExam(?, ?, ?, ?, ?,?, ?)}")) {
                callableStatement.setInt(1, Tid);
                callableStatement.setString(2, examName);
                callableStatement.setString(3, examType);
                callableStatement.setString(4, startTimeString);
                callableStatement.setString(5, endTimeString);
                callableStatement.setInt(6, totalGrade);
                callableStatement.setInt(7,yearlevel);

                callableStatement.execute();

                System.out.println("New exam added successfully.");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddQuestionsToExam(int Eid, String questionContent,int questionGrade  ) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            if (questionContent.equalsIgnoreCase("exit")) {
                break;
            }
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement addQuestionsStatement = connection.prepareCall("{CALL AddQuestionsToExam(?, ?, ?)}")) {
                    addQuestionsStatement.setInt(1, Eid);
                    addQuestionsStatement.setString(2, questionContent);
                    addQuestionsStatement.setInt(3, questionGrade);

                    addQuestionsStatement.execute();

                    System.out.println("Questions added to the exam successfully.");

                    scanner.nextLine(); // Consume the newline character


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public void AddChoicesToQuestion(int Qid,String choiceContent,int choiceStatus) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement addChoicesStatement = connection.prepareCall("{CALL AddChoicesToQuestion(?, ?, ?)}")) {
                    addChoicesStatement.setInt(1, Qid);
                    addChoicesStatement.setString(2, choiceContent);
                    addChoicesStatement.setInt(3, choiceStatus);

                    addChoicesStatement.execute();

                    System.out.println("Choice added to the question successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
    public void EditExam( int examId,String newStartTime,String newEndTime,int newConducted,int newTotalGrade,int yearLevel) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement editExamStatement = connection.prepareCall("{CALL EditExam(?, ?, ?, ?, ?,?)}")) {
                editExamStatement.setInt(1, examId);
                editExamStatement.setString(2, newStartTime);
                editExamStatement.setString(3, newEndTime);
                editExamStatement.setInt(4, newConducted);
                editExamStatement.setInt(5, newTotalGrade);
                editExamStatement.setInt(6,yearLevel);  // Add this line

                editExamStatement.execute();

                System.out.println("Exam with ID " + examId + " updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void EditQuestion(int questionId,String newQuestionContent, int newQuestionGrade){
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement editQuestionStatement = connection.prepareCall("{CALL EditQuestion(?, ?, ?)}")) {
                editQuestionStatement.setInt(1, questionId);
                editQuestionStatement.setString(2, newQuestionContent);
                editQuestionStatement.setInt(3, newQuestionGrade);

                editQuestionStatement.execute();

                System.out.println("Question with ID " + questionId + " updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void EditChoicesForQuestion(int choiceId,String newChoiceContent,int newChoiceStatus) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement editChoicesStatement = connection.prepareCall("{CALL EditChoicesForQuestion(?, ?, ?)}")) {
                editChoicesStatement.setInt(1, choiceId);
                editChoicesStatement.setString(2, newChoiceContent);
                editChoicesStatement.setInt(3, newChoiceStatus);

                editChoicesStatement.execute();

                System.out.println("Choice with ID " + choiceId + " updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateDatabase(int Eid,int conducted ) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL UpdateExamState(?, ?)}")) {
                callableStatement.setInt(1, Eid);
                callableStatement.setInt(2, conducted);

                callableStatement.execute();

                System.out.println("Exam state updated in the database.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddAssignment(String content,String level,String subject) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL AddAssignment(?, ?, ?)}")) {
                callableStatement.setString(1, content);
                callableStatement.setString(2, level);
                callableStatement.setString(3, subject);

                callableStatement.execute();

                System.out.println("Assignment added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void EditAssignment(int assignmentId,String newContent ,String newLevel,String newSubject) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL EditAssignment(?, ?, ?, ?)}")) {
                callableStatement.setInt(1, assignmentId);
                callableStatement.setString(2, newContent);
                callableStatement.setString(3, newLevel);
                callableStatement.setString(4, newSubject);

                callableStatement.execute();

                System.out.println("Assignment with ID " + assignmentId + " updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteAssignment(int assignmentId) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL DeleteAssignment(?)}")) {
                callableStatement.setInt(1, assignmentId);
                callableStatement.execute();

                System.out.println("Assignment with ID " + assignmentId + " deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}