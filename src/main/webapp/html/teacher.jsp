<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/teacher.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Teacher</title>
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
                <h1>Teacher Services</h1>
            </div>
            <div class="down">
                <div class="block">
                    <i class="fa-solid fa-gear"></i>
                    <h1>Exams Management</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <div class="dropdown">
                        <button class="btn">Open <i class="fa-solid fa-down-long"></i></button>
                        <div class="dropdown-content">
                            <a href="newExam.jsp">New Exam</a>
                            <a href="editExam.jsp">Edit Exam</a>
                        </div>
                    </div>
                </div>
                <div class="block">
                    <i class="fa-solid fa-chart-simple"></i>
                    <h1>Student Grades</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <a href="Tgrades.jsp"><button>Check</button></a>
                </div>
                <div class="block">
                    <i class="fa-solid fa-chart-simple"></i>
                    <h1>Assignments</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <a href="assignments.jsp"><button>Assigning</button></a>
                </div>
               
            </div>
        </div>
    </div>
</body>
</html>