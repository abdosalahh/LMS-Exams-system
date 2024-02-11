<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/Sgrades.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Student Grade</title>
</head>
<body>
    <div class="container">
        <div class="nav">
            <div class="logo">
                <img src="../img/lms.png">
            </div>
            <div class="choices">
                <ul>
                    <li><a href="../index.jsp">Home</a></li>
                    <li><a href="../html/about.jsp">About</a></li>
                    <li><a href="../html/contact.jsp">Contact</a></li>
                    <li><a href="../html/login.jsp">Log out</a></li>
                </ul>
            </div>
        </div>
        <div class="screen">
            <div class="back">
                <a href="student.jsp">
                    <i class="fa-sharp fa-solid fa-circle-left"></i>
                </a>
            </div>
            <!-- Data Table -->
            <div class="data-table">
                <!-- Example Data Row (Repeat this for each person) -->
                <div class="data-row">
                    <div>Subject</div>
                    <div>Level</div>
                    <div>Grade</div>
                </div>

                <!-- Sample Data Rows (Replace with actual data) -->
                <%
                    String url = "jdbc:mysql://localhost:3306/examsdatabase";
                    String username = "root";
                    String password = "572022";
                    int userId = (int)session.getAttribute("userId");

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    try (Connection connection = DriverManager.getConnection(url, username, password)) {
                        try (CallableStatement callableStatement = connection.prepareCall("{CALL GetStudentGradesForStudent(?)}")) {
                            callableStatement.setInt(1, userId);
                            try (ResultSet resultSet = callableStatement.executeQuery()) {
                                while (resultSet.next()) {
                                    String subject = resultSet.getString("Exam_Name");
                                    int level = resultSet.getInt("StudentLevel");
                                    int grade = resultSet.getInt("Exam_Grade");
                %>
                                    <div class="data-row">
                                        <div><%= subject %></div>
                                        <div><%= level %></div>
                                        <div><%= grade %></div>
                                    </div>
                <%
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>
