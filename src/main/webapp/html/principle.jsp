<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/principle.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Admin</title>
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
            <div class="scripe">
                <h1>Admin Services</h1>
            </div>
            <div class="down">
                <div class="block">
                    <i class="fa-solid fa-person-chalkboard"></i>
                    <h1>Teachers Management</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <div class="dropdown">
                        <button class="btn">Manage <i class="fa-solid fa-down-long"></i></button>
                        <div class="dropdown-content">
                            <a href="allteachers.jsp">All Teachers</a>
                            <a href="TeachOptions.jsp">Teacher Affairs</a>
                        </div>
                    </div>
                </div>
                <div class="block">
                    <i class="fa-regular fa-user"></i>
                    <h1>Students Affairs</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <div class="dropdown">
                        <button class="btn">Manage <i class="fa-solid fa-down-long"></i></button>
                        <div class="dropdown-content">
                            <a href="allstudents.jsp">All Students</a>
                            <a href="StudOptions.jsp">Students Affairs</a>
                        </div>
                    </div>
                </div>
                <div class="block">
                    <i class="fa-solid fa-school"></i>
                    <h1>Time Table</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <div class="dropdown">
                        <button class="btn">Prepare <i class="fa-solid fa-down-long"></i></button>
                        <div class="dropdown-content">
                            <a href="conducted.jsp">Conducted Exam</a>
                            <a href="timetable.jsp">UpComing Exam</a>
                        </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>