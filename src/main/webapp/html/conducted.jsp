<%@ page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, java.sql.Timestamp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/conducted.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Conducted Exams Table</title>
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
                    <div>Conducted</div>
                    <div>Total Grade</div>
                    <div>Level</div>
                </div>

                <!-- Java code to retrieve conducted exams and display exam details -->
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
                        try (CallableStatement callableStatement = connection.prepareCall("{CALL GetConductedExams()}")) {

                            callableStatement.execute();

                            ResultSet resultSet = callableStatement.getResultSet();
                            while (resultSet != null && resultSet.next()) {
                                int Eid = resultSet.getInt("Eid");
                                int Tid = resultSet.getInt("Tid");
                                String name= resultSet.getString("name");
                                String Type = resultSet.getString("Type");
                                Timestamp StartTime = resultSet.getTimestamp("StartTime");
                                Timestamp EndTime = resultSet.getTimestamp("EndTime");
                                int conducted = resultSet.getInt("conducted");
                                int TotalGrade = resultSet.getInt("TotalGrade");
                                String yearLevel = resultSet.getString("year_level");
                %>
                                <div class="data-row">
                                    <div><%= Eid %></div>
                                    <div><%= name %></div>
                                    <div><%= Type %></div>
                                    <div><%= StartTime %></div>
                                    <div><%= EndTime %></div>
                                    <div><%= conducted %></div>
                                    <div><%= TotalGrade %></div>
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
                %>
            </div>
        </div>
    </div>
</body>
</html>
