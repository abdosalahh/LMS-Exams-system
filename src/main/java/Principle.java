import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
public class Principle extends User {

    public Principle() {
        super();
    }
    public Principle(int id, String name, String email, String password, long phone_Number) {
        super(id, name, email, password, phone_Number, "principle");
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
        String loginQuery = "SELECT * FROM principle WHERE email=? AND password=?";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try( PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {

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
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // If an exception occurred or login failed for some reason
        return false;
    }
    public void EditTeacher(int tableId ,String newName,String newEmail,String newPass,String newPhone_number,int newSalary)  {

            String url = "jdbc:mysql://localhost:3306/examsdatabase";
            String username = "root";
            String password = "572022";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement callableStatement = connection.prepareCall("{CALL EditTeacher(?, ?, ?, ?, ?, ?)}")) {

                    callableStatement.setInt(1,tableId);
                    callableStatement.setString(2, newName);
                    callableStatement.setString(3, newEmail);
                    callableStatement.setString(4, newPass);
                    callableStatement.setString(5, newPhone_number);
                    callableStatement.setInt(6,newSalary);

                    callableStatement.execute();

                    System.out.println("Record with ID " + tableId + " updated successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public void PrepareTimeTable() {

            String url = "jdbc:mysql://localhost:3306/examsdatabase";
            String username = "root";
            String password = "572022";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement callableStatement = connection.prepareCall("{CALL InsertIntoScheduleFromExam()}")) {
                    callableStatement.execute();
                    System.out.println("Schedule prepared successfully based on exams.");
                    try (Statement statement = connection.createStatement()) {
                        ResultSet scheduleResult = statement.executeQuery("SELECT * FROM schedule");

                        while (scheduleResult.next()) {
                            int schid = scheduleResult.getInt("Schid");
                            int eid = scheduleResult.getInt("Eid");
                            String name = scheduleResult.getString("name");
                            String type = scheduleResult.getString("Type");
                            Timestamp startTime = scheduleResult.getTimestamp("StartTime");
                            Timestamp endTime = scheduleResult.getTimestamp("EndTime");
                            double totalGrade = scheduleResult.getDouble("TotalGrade");
                            String yearLevel = scheduleResult.getString("year_level");

                            // Print the schedule information
                            System.out.println("Schedule ID: " + schid);
                            System.out.println("Exam ID: " + eid);
                            System.out.println("Name: " + name);
                            System.out.println("Type: " + type);
                            System.out.println("Start Time: " + startTime);
                            System.out.println("End Time: " + endTime);
                            System.out.println("Total Grade: " + totalGrade);
                            System.out.println("Year Level: " + yearLevel);
                            System.out.println("------------------------");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public void EditStudent (int tableId,String newEmail,String newPass , String newPhone_number,String newName ,int newLevel) {

            String url = "jdbc:mysql://localhost:3306/examsdatabase";
            String username = "root";
            String password = "572022";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement callableStatement = connection.prepareCall("{CALL EditStudent(?, ?, ?, ?, ?, ?)}")) {

                    callableStatement.setInt(1,tableId);
                    callableStatement.setString(2, newEmail);
                    callableStatement.setString(3, newPass);
                    callableStatement.setString(4, newPhone_number);
                    callableStatement.setString(5, newName);
                    callableStatement.setInt(6,newLevel);

                    callableStatement.execute();

                    System.out.println("Record with ID " + tableId + " updated successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public void ViewTeachersDetails () {
            String url = "jdbc:mysql://localhost:3306/examsdatabase";
            String username = "root";
            String password = "572022";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement callableStatement = connection.prepareCall("{CALL GetTeachersDetails()}")) {

                    callableStatement.execute();

                    ResultSet resultSet = callableStatement.getResultSet();

                    while (resultSet != null && resultSet.next()) {
                        int id = resultSet.getInt("Tid");
                        String Email = resultSet.getString("email");
                        String name = resultSet.getString("name");
                        String pass = resultSet.getString("password");
                        String p_number = resultSet.getString("phone_number");
                        String salary = resultSet.getString("salary");

                        System.out.println("ID: " + id + ", Name: " + name + ", email" + Email + ", pass" + pass + ", Phone Number" + p_number + ",Salary" + salary);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public void ViewStudentsDetails () {

            String url = "jdbc:mysql://localhost:3306/examsdatabase";
            String username = "root";
            String password = "572022";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (CallableStatement callableStatement = connection.prepareCall("{CALL GetStudentsDetails()}")) {

                    callableStatement.execute();

                    ResultSet resultSet = callableStatement.getResultSet();

                    while (resultSet != null && resultSet.next()) {
                        int Sid = resultSet.getInt("Sid");
                        String email = resultSet.getString("email");
                        String pass= resultSet.getString("password");
                        String phone_number = resultSet.getString("phone_number");
                        String name = resultSet.getString("name");
                        String level = resultSet.getString("level");

                        System.out.println("Sid: " + Sid + ", email: " + email + ", password: " + pass + ", phone_number: " + phone_number + ", name: " + name + ", level: " + level);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public void GetConductedExams () {
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL GetConductedExams()}")) {

                callableStatement.execute();

                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet != null && resultSet.next()) {
                    int Eid = resultSet.getInt("Eid");
                    int Tid = resultSet.getInt("Tid");
                    String name= resultSet.getString("name");
                    String Type = resultSet.getString("Type");
                    Date StartTime = resultSet.getTime("StartTime");
                    Date EndTime = resultSet.getTime("EndTime");
                    int conducted = resultSet.getInt("conducted");
                    int TotalGrade = resultSet.getInt("TotalGrade");

                    System.out.println("Eid: " + Eid + ", Tid: " + Tid + ", name: " + name + ", Type: " + Type + ", StartTime: " + StartTime + ", EndTime: " + EndTime + ", conducted: " + conducted + ", TotalGrade: " + TotalGrade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteTeacher (int tableId){
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL DeleteTeacher(?)}")) {
                callableStatement.setInt(1, tableId);
                callableStatement.execute();

                System.out.println("Record with ID " + tableId + " deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteStudent (int tableId){

        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL DeleteStudent(?)}")) {
                callableStatement.setInt(1, tableId);
                callableStatement.execute();

                System.out.println("Record with ID " + tableId + " deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void AddNewTeacher (String newName,String newEmail,String newPass ,String newPhone_number ,int newSalary){

        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL AddNewTeacher(?, ?, ?, ?, ?)}")) {
                callableStatement.setString(1, newName);
                callableStatement.setString(2, newEmail);
                callableStatement.setString(3, newPass);
                callableStatement.setString(4, newPhone_number);
                callableStatement.setInt(5, newSalary);

                callableStatement.execute();

                System.out.println("New teacher added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void AddNewStudent  (String email,String phone_number,String name , int level ){
        String url = "jdbc:mysql://localhost:3306/examsdatabase";
        String username = "root";
        String password = "572022";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (CallableStatement callableStatement = connection.prepareCall("{CALL AddNewStudent( ?, ?, ?, ?)}")) {
                callableStatement.setString(1, email);
                callableStatement.setString(2, phone_number);
                callableStatement.setString(3, name);
                callableStatement.setInt(4, level);

                callableStatement.execute();

                System.out.println("New Student added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}