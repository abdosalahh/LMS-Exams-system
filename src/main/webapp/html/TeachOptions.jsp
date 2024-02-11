<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="../css/TeachOptions.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Teachers Options</title>
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
            <div class="dv">
                <div class="teacher-form">
                    <h2>Add new Teacher</h2>
                    <form action="/examsystem/AddTeacher" method="post">
                        <input type="text" name="name" placeholder="Name">
                        <input type="email" name="email" placeholder="Email">
                        <input type="password" name="password" placeholder="Password">
                        <input type="tel" name="phone" placeholder="Phone number">
                        <input type="number" name="salary" placeholder="Salary">
                        <button type="submit">Add</button>
                    </form>
                </div>
                <div class="teacher-form">
                    <h2>Edit Teacher data</h2>
                    <form action="/examsystem/EditTeacherSrv" method="post">
                        <input type="number" name="id" placeholder="ID">
                        <input type="text" name="name" placeholder="Name">
                        <input type="email" name="email" placeholder="Email">
                        <input type="password" name="password" placeholder="Password">
                        <input type="tel" name="phone" placeholder="Phone number">
                        <input type="number" name="salary" placeholder="Salary">
                        <button type="submit">Update</button>
                    </form>
                </div>
                <div class="teacher-form">
                    <h2>Delete Teacher</h2>
                    <form action="/examsystem/DeleteTeacherSrv" method="post">
                        <input type="number" name="id" placeholder="ID">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>