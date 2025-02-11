<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f2f5;
            font-family: "Poppins", sans-serif;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }
        .container h2 {
            margin-bottom: 20px;
            color: #333;
        }
        .input-box {
            position: relative;
            margin: 15px 0;
        }
        .input-box input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .btn {
            width: 100%;
            padding: 10px;
            border: none;
            background: #064c4e;
            color: white;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 15px;
        }
        .btn:hover {
            background: #053e40;
        }
        .register-link {
            margin-top: 15px;
            font-size: 14px;
        }
        .register-link a {
            color: #064c4e;
            text-decoration: none;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
        .error-message {
            color: rgb(255, 191, 0);
            margin-top: 10px;
            display: <%=(request.getAttribute("error") != null ? "block" : "none")%>;
        }
        .back-btn {
            width: 100%;
            padding: 10px;
            border: none;
            background: #ccc;
            color: #333;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }
        .back-btn:hover {
            background: #bbb;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Login</h2>
        <form action="admin" method="POST" id="loginForm">
            <input type="hidden" name="action" value="login" />
            <div class="input-box">
                <input type="text" placeholder="AdminID" name="adminID" id="adminID" required />
            </div>
            <div class="input-box">
                <input type="password" placeholder="Password" name="password" id="password" required maxlength="30" />
            </div>
            <button type="submit" class="btn">Login</button>
            <div class="error-message">
                <p id="error-text"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
            </div>
        </form>
        <button class="back-btn" onclick="window.location.href='LoginPage.jsp'">Back to Customer Login</button>
    </div>
</body>
</html>
