<%@ page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/allteachers.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>View all Teachers</title>
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
                    <div>Email</div>
                    <div>Password</div>
                    <div>Phone number</div>
                    <div>Salary</div>
                </div>

                <!-- Java code to retrieve and display teachers -->
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
                        try (CallableStatement callableStatement = connection.prepareCall("{CALL GetTeachersDetails()}")) {

                            callableStatement.execute();
                            ResultSet resultSet = callableStatement.getResultSet();

                            while (resultSet != null && resultSet.next()) {
                                int id = resultSet.getInt("Tid");
                                String email = resultSet.getString("email");
                                String name = resultSet.getString("name");
                                String pass = resultSet.getString("password");
                                String p_number = resultSet.getString("phone_number");
                                String salary = resultSet.getString("salary");
                %>
                                <div class="data-row">
                                    <div><%= id %></div>
                                    <div><%= name %></div>
                                    <div><%= email %></div>
                                    <div><%= pass %></div>
                                    <div><%= p_number %></div>
                                    <div><%= salary %></div>
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
