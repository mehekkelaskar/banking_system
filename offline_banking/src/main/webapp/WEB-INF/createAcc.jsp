<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
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
        .create-account-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 300px;
        }
        input[type="text"], input[type="password"], input[type="date"], button {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
        }
        select {
            width: 95%;
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
<div class="create-account-box">
    <h2>Create a New Account</h2>
    <form action="createAccount">
        <label for="name">Name:</label><br/>
        <input type="text" name="name" required /><br/>
        
        <label for="dob">Date of Birth:</label><br/>
        <input type="date" name="dob" required /><br/>
        
        <label for="address">Address:</label><br/>
        <input type="text" name="address" required /><br/>
        
        <label for="pin">PIN:</label><br/>
        <input type="password" name="pin" required /><br/>
        
        <label for="accountType">Account Type:</label><br/>
        <select name="accountType" required>
            <option value="Saving">Saving</option>
            <option value="Current">Current</option>
        </select><br/>
        
        <button type="submit">Create Account</button>
    </form>
</div>
</body>
</html>
