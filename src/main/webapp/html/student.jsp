<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/student.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Student</title>
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
                    <li><a href="mail.jsp"><i class="fa-solid fa-bell"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="screen">
            <div class="scripe">
                <h1>Student Services</h1>
            </div>
            <div class="down">
                <div class="block">
                    <i class="fa-solid fa-list-check"></i>
                    <h1>Join Exam</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <div class="dropdown">
                        <button class="btn">select <i class="fa-solid fa-down-long"></i></button>
                        <div class="dropdown-content">
                            <input type="number" name="id" placeholder="ID">
                            <input type="number" name="level" placeholder="level">
                            <a href="joinexam.jsp"><button>Start</button></a>
                        </div>
                    </div>
                </div>
                <div class="block">
                    <i class="fa-solid fa-chart-simple"></i>
                    <h1>My Grades</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
					
                    <a href="Sgrades.jsp"><button>View</button></a>
                </div>
                <div class="block">
                    <i class="fa-solid fa-note-sticky"></i>
                    <h1>Write Note</h1>
                    <p>Lorem ipsum dolor sit amet consectetur,
                        adipisicing elit. Quaerat cum porro,
                        repellat exercitationem ipsum quasi illum
                        vitae quam eius laudantium aliquam in id
                        nobis, qui accusantium pariatur fugiat nisi alias.
                    </p>
                    <a href="note.jsp"><button>Go</button></a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>