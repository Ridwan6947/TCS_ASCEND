<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.helper.DBHelper" %>
<%@ page import="com.entity.Admin" %>
<%@ page import="com.helper.SqlAbstraction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Homepage</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            display: flex;
        }

        .admin-homepage {
            display: flex;
            width: 100%;
        }

        /* Sidebar Styles */
        .sidebar {
            width: 250px; /* Increased sidebar width */
            background-color: #064c4e;
            color: #f7f8f1;
            padding: 20px;
            height: 100vh;
            position: fixed;
            display: flex; /* Flexbox for vertical alignment */
            flex-direction: column;
        }

        .sidebar h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .sidebar ul {
            list-style: none;
            flex-grow: 1; /* Allows the buttons to take up available space */
            padding: 0; /* Remove default padding */
        }

        .sidebar ul li {
            margin: 15px 0;
        }

        .sidebar ul li a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease; /* Add transition for hover effect */
            text-align: center; /* Center the button text */
        }

        .sidebar ul li a:hover {
            background-color: #34495e;
        }

        /* Main Content Styles */
        .main-content {
            margin-left: 270px; /* Adjusted margin to accommodate wider sidebar */
            padding: 20px;
            width: calc(100% - 270px);
        }

        header {
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between; /* Align items to left and right */
            align-items: center;
            background-color: #f7f8f1; /* Light background for header */
        }

        header h1 {
            margin: 0;
            color: #064c4e;
        }

        header p {
            color: #7f8c8d;
        }

        .logout-button {
            text-decoration: none;
            background-color: #064c4e;
            color: #f7f8f1;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .logout-button:hover {
            background-color: #34495e;
            transform: translateY(-2px);
        }

        .logout-button:active {
            transform: translateY(1px);
        }

        .stats {
            display: flex;
            gap: 20px;
            margin-top: 20px;
        }

        .stat-card {
            flex: 1;
            background-color: #f7f8f1;
            color: #064c4e;
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease; /* Add transition for hover effect */
        }

        .stat-card:hover {
            transform: translateY(-5px);
        }

        .stat-card h3 {
            margin: 0 0 10px 0;
        }

        .quick-links {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .button-container {
            display: grid;
            grid-template-columns: 1fr; /* Single column layout for sidebar */
            gap: 20px;
            margin-top: 20px; /* Add top margin */
        }

        .button-link {
            text-decoration: none;
            background-color: #f7f8f1;
            color: #064c4e;
            padding: 10px 20px; /* Adjusted padding */
            border-radius: 10px;
            font-size: 16px; /* Reduced font size */
            font-weight: bold;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.2s ease;
            display: flex;
            align-items: center;
            justify-content: center; /* Center icon and text */
            gap: 15px;
            width: 100%; /* Make buttons full width of sidebar */
        }

        .button-link i {
            font-size: 20px; /* Adjusted icon size */
        }

        .button-link:hover {
            background-color: #064c4e;
            color: #f7f8f1;
            transform: translateY(-5px);
        }

        .button-link:active {
            transform: translateY(2px);
        }

        p {
            margin: 10px;
        }

        .logo-container {
            height: 50px;
            width: 200px;
            background-size: contain;
            background-image: url('images_new/logo3.png');
            background-repeat: no-repeat;
        }

        img {
            background: transparent;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("admin") != null) {
        Admin admin = (Admin) session.getAttribute("admin");
%>

<div class="admin-homepage">
    <div class="sidebar">
        <h2>Admin Panel</h2>
        <ul>
            <p> Admin logged </p>
            <p>ID: <%= admin.getAdminId() %></p>
        </ul>
    </div>

<%
    } else {
        response.sendRedirect("AdminLogin.jsp");
    }
%>


    <!-- Main Content -->
   
    <div class="main-content">
      <header>
      	<div class="header-container">

        	<a href="AdminLogout.jsp" class="logout-button">Logout</a>
        </div>
        <p></p>
      </header><br><br><br>
<%
    String sql = SqlAbstraction.abs3;
    int registeredCustomers = 0;

    try (PreparedStatement pstmt = DBHelper.getPreparedStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            registeredCustomers = rs.getInt("CustomerCount");
        }
    } catch (SQLException e) {
        out.println("Error: " + e.getMessage());
    }
%>

<%
    String sql2 = SqlAbstraction.abs4 ;
    int ProductPrice = 0;

    try (PreparedStatement pstmt2 = DBHelper.getPreparedStatement(sql2)) {
        ResultSet rs2 = pstmt2.executeQuery();
        if (rs2.next()) {
        	ProductPrice = rs2.getInt("SUM_PRODUCT");
        }
    } catch (SQLException e) {
        out.println("Error: " + e.getMessage());
    }
%>


<%
    String sql3 = SqlAbstraction.abs5;
    int totalorders = 0;

    try (PreparedStatement pstmt3 = DBHelper.getPreparedStatement(sql3)) {
        ResultSet rs3 = pstmt3.executeQuery();
        if (rs3.next()) {
        	totalorders = rs3.getInt("TotalOrders");
        }
    } catch (SQLException e) {
        out.println("Error: " + e.getMessage());
    }
%>

<!-- Stats Section -->
<section class="stats">
  
  <div class="stat-card">
    <h3>No Of. Orders</h3>
    <p><%= totalorders %></p>
    <img alt="" src="images_new/order-list-number.png" height="80px" width="80px">
  </div>
  <div class="stat-card">
    <h3>Sales</h3>
    <p>₹ <%= ProductPrice %></p>
    <img alt="" src="images_new/online-sales-growth-number.png" height="80px" width="80px">
  </div>
  <div class="stat-card">
    <h3>Total Customers</h3>
    <p><%= registeredCustomers %></p>
    <img alt="" src="images_new/customer-3d-render-icon-number.jpg" height="80px" width="80px">
  </div>
</section><br><br><br>
      <!-- Quick Links -->
      
      <section class="quick-links">
        
        
        <!-- Include Font Awesome -->
			<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

				<div class="button-container">
  					<a href="AddProduct.jsp" class="button-link">
    					<i class="fas fa-plus"></i> Add Product
  					</a>
  					<a href="DisplayOrder.jsp" class="button-link">
    					<i class="fas fa-list"></i> Orders Details
  					</a>
  					<a href="ProductManagement.jsp" class="button-link">
    					<i class="fas fa-box"></i> Product Details
  					</a>
  					<a href="CustomerManagement.jsp" class="button-link">
    					<i class="fas fa-users"></i> Customer Details
  					</a>
				</div>
      </section>
    </div>
  </div>
</body>
<script>

window.addEventListener('pageshow',function(event){
    if(event.persisted){
    	window.location.reload();
    }
    })
window.addEventListener('popstate',function(){
    	console.log("refreshed")
 	   location.reload(true);
    })
</script>
</html>