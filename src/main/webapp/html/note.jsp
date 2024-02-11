<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/note.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Notes</title>
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
            <div class="contactForm">
                <form action="/examsystem/SendNoteServlet" method="post">
                    <h2>Write Your Note</h2>
                    <div class="inputBox">
                    <input type="number" name="id" required="required">
                    <span>Your Id</span>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="name" required="required">
                        <span>Your Name</span>
                    </div>
                    <div class="inputBox">
                        <input type="email" name="email" required="required">
                        <span>Email</span>
                    </div>
                    <div class="inputBox">
                        <textarea class="note" name="content" required="required" ></textarea>
                        <span>type your message...</span>
                    </div>
                    <div class="inputBox">
                        <input class="send" type="submit" name="send" value="send">
                    </div>
                </form>
            </div>
        </div>
</body>
</html>