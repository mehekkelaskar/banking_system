<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Error</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .error-box {
        padding: 60px;
        width: 600px;
        background-color: #fce8e6; /* Pale red */
        border: 2px solid #d93025; /* Red border */
        border-radius: 15px;
        font-size: 22px;
        text-align: center;
        color: #a00000;
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
    }
     button {
        padding: 10px 25px;
        font-size: 16px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div class="error-box">
        ❌ <strong><%= request.getAttribute("message") %></strong>
    </div>
     <form action="enter">
    <button type="submit">Back to Main Page</button>
    </form>
</body>
</html>
