<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="icon" href="img/icon.jpg">
    <title>Home</title>
</head>
<body>
    <div class="container">
        <div class="nav">
            <div class="logo">
                <img src="img/lms.png">
            </div>
            <div class="choices">
                <ul>
                    <li><a>Home</a></li>
                    <li><a href="html/about.jsp">About</a></li>
                    <li class="services-dropdown">
                        <a href="#">Services</a>
                        <ul class="dropdown-content">
                            <li><a href="html/student.jsp">Student Services</a></li>
                            <li><a href="html/teacher.jsp">Teacher Services</a></li>
                            <li><a href="html/principle.jsp">Admin Services</a></li>
                        </ul>
                    </li>
                    <li><a href="html/contact.jsp">Contact</a></li>
                    <li><a href="html/login.jsp">Login</a></li>
                </ul>
            </div>
        </div>
        <div class="screen">
            <div class="scripe">
                <h1>Online <br>
                    Education
                </h1>
            </div>
            <div class="down">
                <div class="s">
                    <div class="ic">
                        <i class="fa-solid fa-graduation-cap"></i>
                    </div>
                    <div class="para">
                        <h1>160</h1>
                        <p>Courses</p>
                    </div>
                </div>
                <div class="s">
                    <div class="ic">
                        <i class="fa-solid fa-user-graduate"></i>
                    </div>
                    <div class="para">
                        <h1>1500</h1>
                        <p>Students</p>
                    </div>
                </div>
                <div class="s">
                    <div class="ic">
                        <i class="fa-solid fa-chalkboard-user"></i>
                    </div>
                    <div class="para">
                        <h1>30</h1>
                        <p>Teachers</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>


