<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/Tgrades.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>All Students Grades</title>
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
                <a href="teacher.jsp">
                    <i class="fa-sharp fa-solid fa-circle-left"></i>
                </a>
            </div>
            <!-- Form to input examId -->
            <form method="post" action="">
                Enter Exam ID: <input type="text" name="examId">
                <input type="submit" value="Submit">
            </form>

            <!-- Data Table -->
            <div class="data-table">
                <!-- Java code to retrieve data from the stored procedure -->
                <%
                    try {
                        // Check if the form is submitted
                        if (request.getMethod().equalsIgnoreCase("post")) {
                            // Get the examId from the form
                            int examId = Integer.parseInt(request.getParameter("examId"));

                            // Load the JDBC driver
                            Class.forName("com.mysql.cj.jdbc.Driver");

                            // Establish the connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examsdatabase", "root", "572022");

                            // Prepare the stored procedure call
                            String sql = "{CALL GetSubjectAndStudentGrades(?)}";
                            try (PreparedStatement statement = connection.prepareCall(sql)) {
                                statement.setInt(1, examId);

                                // Execute the stored procedure
                                boolean hasResults = statement.execute();

                                if (hasResults) {
                                    ResultSet resultSet = statement.getResultSet();
                                    while (resultSet.next()) {
                            %>
                                        <!-- Data Row for each result -->
                                        <div class="data-row">
                                            <div><%= resultSet.getString("student_name") %></div>
                                            <div><%= resultSet.getString("Grade") %></div>
                                        </div>
                            <%
                                    }
                                    resultSet.close();
                                }
                            }
                            connection.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>