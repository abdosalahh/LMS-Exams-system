<%@ page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, java.sql.Timestamp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/timetable.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Exams Table</title>
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
                <a href="principle.jsp">
                    <i class="fa-sharp fa-solid fa-circle-left"></i>
                </a>
            </div>
            <!-- Data Table -->
            <div class="data-table">
                <!-- Example Data Row (Repeat this for each person) -->
                <div class="data-row">
                    <div>ID</div>
                    <div>Name</div>
                    <div>Type</div>
                    <div>Start Time</div>
                    <div>End Time</div>
                    <div>Total Grade</div>
                    <div>Level</div>
                </div>

                <!-- Java code to prepare timetable and display exam details -->
                <%
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
                %>
                                    <div class="data-row">
                                        <div><%= schid %></div>
                                        <div><%= name %></div>
                                        <div><%= type %></div>
                                        <div><%= startTime %></div>
                                        <div><%= endTime %></div>
                                        <div><%= totalGrade %></div>
                                        <div><%= yearLevel %></div>
                                    </div>
                <%
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
                %>
            </div>
        </div>
    </div>
</body>
</html>
