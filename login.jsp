<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <title>Login Page</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
        body {
            font-family: "Roboto", sans-serif;
            background: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-page {
            width: 360px;
            padding: 8% 0 0;
            margin: auto;
        }
        .form {
            background: #FFFFFF;
            max-width: 360px;
            margin: auto;
            padding: 45px;
            text-align: center;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2), 0 5px 5px rgba(0, 0, 0, 0.24);
            border-radius: 10px;
        }
        .form input {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 14px;
            border-radius: 5px;
        }
        .form button {
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            background: #4CAF50;
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            cursor: pointer;
            border-radius: 5px;
            transition: all 0.3s ease;
            margin-bottom: 10px;
        }
        .form button.user-login {
            margin-bottom: 15px;
        }
        .form button.admin-login {
            background: #2c3e50;
        }
        .form button:hover {
            background: #43A047;
        }
        .form button.admin-login:hover {
            background: #34495e;
        }
        .form .message {
            margin: 15px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }
        .form .message a {
            color: #4CAF50;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form id="login-form" action="customer" method="POST">
                <input type="hidden" value="login" name="action"/>
                <h2>Login</h2>
                <input type="text" id="login-email" name="customerID" placeholder="Enter Customer ID" required>
                <input type="password" id="login-password" name="password" placeholder="Enter Password" required>
                <button type="submit" class="user-login">User Login</button>
                <button type="button" class="admin-login" onclick="location.href='AdminLogin.jsp'">Admin Login</button>
                <p class="message">Not registered? <a href="RegisterPage.jsp">Create an account</a></p>
            </form>
            <div id="error-message" style="color: red; display: <%=(request.getAttribute("error") != null ? "block" : "none")%>; margin-top: 10px;">
                <p><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
            </div>
        </div>
    </div>
</body>
</html>
