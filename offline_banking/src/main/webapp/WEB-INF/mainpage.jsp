<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Enter PIN</title>
    <style>
        body {
           
        display: flex;
        height: 100vh;
        justify-content: center;
        align-items: center;
        font-family: Arial, sans-serif;
        background-image: url('https://image.slidesdocs.com/responsive-images/background/line-professional-frame-blue-square-shape-business-powerpoint-background_9c874dd0f4__960_540.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        margin: 0;
		}
        .login-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            text-align: center;
            width: 300px;
        }
        input[type="password"], button {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
        }
        a {
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Enter Your PIN</h2>
    <form action="login">
        <label for="pin">PIN:</label><br/>
        <input type="password" name="pin" required /><br/>
        <button type="submit">Login</button>
    </form>
    
    <p>Don't have an account? <a href="createAccountForm">Create an account</a></p>
  
</div>
</body>
</html>

