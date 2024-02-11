import java.sql.*;
import java.util.Scanner;
import java.time.LocalDateTime;
public class Student extends User{
    int level;
    public Student(int id, String name, String email, String password, long phone_Number, int level) {
        super(id, name, email, password, phone_Number, "student");
        this.level=level;
    }
    public Student(){
        super();
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
        String loginQuery = "SELECT * FROM student WHERE email=? AND password=?";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {

                // Set parameters for the prepared statement
                preparedStatement.setString(1, enteredEmail);
                preparedStatement.setString(2, enteredPassword);

                // Execute the query to check login credentials
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if the result set has at least one row
                    if (resultSet.next()) {
                        System.out.println("Login successful!");
                        return true;
                    } else {
                        System.out.println("Invalid credentials. Login failed.");
                        return false;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            // If an exception occurred or login failed for some reason
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void change_my_password( int studentId,String existingPassword, String newPassword) {
            String url = "jdbc:mysql://localhost:3306/examsdatabase";
            String username = "root";
            String password = "572022";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement callableStatement = connection.prepareCall("{CALL ChangeMyPassword(?, ?, ?)}")) {

                callableStatement.setInt(1, studentId);
                callableStatement.setString(2, existingPassword);
                callableStatement.setString(3, newPassword);

                callableStatement.execute();

                System.out.println("Password for student with ID " + studentId + " changed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    public void ViewGrades( int studentId) {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL GetStudentGradesForStudent(?)}")) {
                callableStatement.setInt(1, studentId);
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int studentID = resultSet.getInt("StudentID");
                        int studentLevel = resultSet.getInt("StudentLevel");
                        String examName = resultSet.getString("Exam_Name");
                        int examGrade = resultSet.getInt("Exam_Grade");
                        System.out.println("Student ID: " + studentID +
                                ", Level: " + studentLevel +
                                ", Exam Name: " + examName +
                                ", Exam Grade: " + examGrade);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Exam taking_their_exams_according_to_their_year_level(Exam e,int examId,int yearLevel) {
        /*
            Hints:
                PROCEDURE `GetExamInf`(IN p_ExamId INT)
                PROCEDURE GetQuestionsForExam(IN p_ExamId INT)
                PROCEDURE GetChoicesForQuestionInExam(IN p_QuestionId INT,  IN p_ExamId INT)
         */
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            try (CallableStatement getExamInfStatement = connection.prepareCall("{CALL GetExamInf(?, ?)}")) {
                getExamInfStatement.setInt(1, examId);
                getExamInfStatement.setInt(2, yearLevel);
                ResultSet examInfResult = getExamInfStatement.executeQuery();

                if (examInfResult.next()) {
                    String examName = examInfResult.getString("name");
                    String examType = examInfResult.getString("Type");
                    LocalDateTime startTime = examInfResult.getTimestamp("StartTime").toLocalDateTime();
                    LocalDateTime endTime = examInfResult.getTimestamp("EndTime").toLocalDateTime();
                    double totalGrade = examInfResult.getDouble("TotalGrade");

                    // You can use this information as needed
                    System.out.println("Exam Information:");
                    System.out.println("Name: " + examName);
                    System.out.println("Type: " + examType);
                    System.out.println("Start Time: " + startTime);
                    System.out.println("End Time: " + endTime);
                    System.out.println("Total Grade: " + totalGrade);
                    System.out.println("Year Level: " + yearLevel);
                    // Call GetQuestionsForExam procedure
                    try (CallableStatement getQuestionsStatement = connection.prepareCall("{CALL GetQuestionsForExam(?)}")) {
                        getQuestionsStatement.setInt(1, examId);
                        ResultSet questionsResult = getQuestionsStatement.executeQuery();

                        while (questionsResult.next()) {
                            int questionId = questionsResult.getInt("Qid");
                            String questionContent = questionsResult.getString("content");
                            int questionGrade = questionsResult.getInt("Qgrade");

                            // You can use this information as needed
                            System.out.println("Question ID: " + questionId);
                            System.out.println("Question Content: " + questionContent);
                            System.out.println("Question Grade: " + questionGrade);

                            // Call GetChoicesForQuestionInExam procedure for each question
                            try (CallableStatement getChoicesStatement = connection.prepareCall("{CALL GetChoicesForQuestionInExam(?, ?)}")) {
                                getChoicesStatement.setInt(1, questionId);
                                getChoicesStatement.setInt(2, examId);
                                ResultSet choicesResult = getChoicesStatement.executeQuery();

                                while (choicesResult.next()) {
                                    int choiceId = choicesResult.getInt("Chid");
                                    String choiceContent = choicesResult.getString("content");

                                    // You can use this information as needed
                                    System.out.println("Choice ID: " + choiceId);
                                    System.out.println("Choice Content: " + choiceContent);
                                }
                            }
                        }
                }
            }else {
                    System.out.println("Exam not found.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    public void send_note_to_principle(String noteContent,int principleId, int studentId ) {
        /*
            sending note to principle and save it in data base table (note)
        */
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement sendNoteStatement = connection.prepareCall("{CALL SendNoteToPrinciple(?, ?, ?)}")) {
                sendNoteStatement.setString(1, noteContent);
                sendNoteStatement.setInt(2, principleId);
                sendNoteStatement.setInt(3, studentId);

                sendNoteStatement.execute();

                System.out.println("Note sent to the principle successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
