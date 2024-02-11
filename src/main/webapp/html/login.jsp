<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/login.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Login</title>
</head>
<body>
    <div class="back">
        <a href="../index.jsp">
            <i class="fa-sharp fa-solid fa-circle-left"></i>
        </a>
    </div>
    <div class="container">
        <h1>Login</h1>
        <form action="/examsystem/LoginServlet" method="post">
            <div class="input-group">
                <div class="input-field">
                    <i class="fa-solid fa-envelope"></i>
                    <input type="email" required placeholder="Email" name="email">
                </div>    
                <div class="input-field">
                    <i class="fa-solid fa-key"></i>
                    <input type="password"placeholder="Password" name="Password" minlength="8" maxlength="25" required>
                </div>    
                <div class="radio-field">
                    <label for="Type">Login As :</label>
                    <br><br>    
                    <input type="radio" id="teacher" name="Type" value="teacher">
                    <label for="teacher">teacher</label>
                    <input type="radio" id="student" name="Type" value="student">
                    <label for="student">student</label>
                    <input type="radio" id="principle" name="Type" value="principle">
                    <label for="principle">admin</label>
                </div>    
                    <input type="submit" value="SIGN IN" class="btn">
            </div>
        </form>
    </div>   
</body>
</html>