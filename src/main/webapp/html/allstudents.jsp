<%@ page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/allteachers.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>View All Students</title>
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
                    <div>Level</div>
                </div>

                <!-- Java code to retrieve and display student details -->
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
                        try (CallableStatement callableStatement = connection.prepareCall("{CALL GetStudentsDetails()}")) {

                            callableStatement.execute();
                            ResultSet resultSet = callableStatement.getResultSet();

                            while (resultSet != null && resultSet.next()) {
                                int Sid = resultSet.getInt("Sid");
                                String email = resultSet.getString("email");
                                String pass = resultSet.getString("password");
                                String phone_number = resultSet.getString("phone_number");
                                String name = resultSet.getString("name");
                                String level = resultSet.getString("level");
                %>
                                <div class="data-row">
                                    <div><%= Sid %></div>
                                    <div><%= name %></div>
                                    <div><%= email %></div>
                                    <div><%= pass %></div>
                                    <div><%= phone_number %></div>
                                    <div><%= level %></div>
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
