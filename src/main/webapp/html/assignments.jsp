<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/assignments.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Assignments</title>
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
            <div class="assig">
                <div class="assignment-form">
                    <h2>Create Assignment</h2>
                    <form action="/examsystem/AssignServlet" method="post">
                        <label for="subject">Subject:</label>
                        <input type="text" id="subject" name="subject" placeholder="Enter subject">

                        <label for="level">Level:</label>
                        <input type="text" id="level" name="level" placeholder="Enter level">

                        <label for="content">Content:</label>
                        <textarea id="content" name="content" placeholder="Enter content" class="txtar"></textarea>
                        
                        <button type="submit">Assign</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>