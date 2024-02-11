<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/joinexam.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Exam Paper</title>
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
            <div class="paper-header">
                <h2>Subject: Math</h2>
                <p>Start Time: 10:00 AM</p>
                <p>End Time: 12:00 PM</p>
                <p>Level: Intermediate</p>
                <p>Total Grade: 100</p>
            </div>
            <div class="paper-body">
                <div class="question">
                    <p>1. Question description......................................................................? (Question Grade)</p>
                    <div class="options">
                        <label class="hov"><input type="radio" name="q1" value="a"> a. First answer</label>
                        <label class="hov"><input type="radio" name="q1" value="b"> b. Second answer</label>
                        <label class="hov"><input type="radio" name="q1" value="c"> c. Third answer</label>
                        <label class="hov"><input type="radio" name="q1" value="d"> d. Fourth answer</label>
                    </div>
                </div>
                <div class="question">
                    <p>3. Question description......................................................................? (Question Grade)</p>
                    <div class="options">
                        <label class="hov"><input type="radio" name="q3" value="a"> a. First answer</label>
                        <label class="hov"><input type="radio" name="q3" value="b"> b. Second answer</label>
                        <label class="hov"><input type="radio" name="q3" value="c"> c. Third answer</label>
                        <label class="hov"><input type="radio" name="q3" value="d"> d. Fourth answer</label>
                    </div>
                </div>
                <div class="question">
                    <p>3. Question description......................................................................? (Question Grade)</p>
                    <div class="options">
                        <label class="hov"><input type="radio" name="q3" value="a"> a. First answer</label>
                        <label class="hov"><input type="radio" name="q3" value="b"> b. Second answer</label>
                        <label class="hov"><input type="radio" name="q3" value="c"> c. Third answer</label>
                        <label class="hov"><input type="radio" name="q3" value="d"> d. Fourth answer</label>
                    </div>
                </div>
            </div>
            <div class="buttons">
                <a href="student.jsp"><button class="submit">Submit</button></a>
                <a href="student.jsp"><button class="cancel">Cancel</button></a>
            </div>
        </div>
    </div>
</body>
</html>
