<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap");
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }
        body {
            background-color: #ffffff;
            color: #333;
        }
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
        }

        nav {
            background-color: #064c4e;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
        }

        nav .logo {
            font-size: 1.5em;
            font-weight: bold;
        }

        #homepageLogo {
            text-decoration: none;
            color: #ffffff;
        }

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            background-color: #064c4e;
  			padding: 10px 20px;
        }

        nav ul li {
        	position: relative;
            margin-left: 20px;
        }
        nav ul li:first-child {
  			margin-left: 0; /* Remove margin for the first item */
		}

        nav ul li a {
            color: #fff;
            text-decoration: none;
            font-weight: 24px;
            display: inline-flex;
  			align-items: center;
  			justify-content: center;
  			position: relative;
  			padding: 10px;
  			transition: color 0.3s ease;
            
        }

        nav ul li a:hover {
        	color: #535031;
        }
        
        .tooltip {
  			position: absolute;
  			bottom: -30px;
  			left: 50%;
  			transform: translateX(-50%);
  			background-color: #064c4e;
  			color: #fff;
  			padding: 5px 10px;
  			border-radius: 5px;
  			font-size: 14px;
  			font-weight: 500;
  			white-space: nowrap;
  			opacity: 0;
  			visibility: hidden;
  			transition: opacity 0.3s ease, visibility 0.3s ease;
  			pointer-events: none; /* Prevent tooltip from blocking mouse events */
		}
		
		nav ul li a:hover .tooltip {
  			opacity: 1;
  			visibility: visible;
		}
		
		.tooltip::after {
  			content: "";
  			position: absolute;
  			top: -5px;
  			left: 50%;
  			transform: translateX(-50%);
  			border-width: 5px;
 	 		border-style: solid;
  			border-color: transparent transparent #2c3e50 transparent;
		}
        
 </style>     
</head>
<body>

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">	
<nav>

        
        <ul>
            <li>
            	<a href="CustomerManagement.jsp">
            		<i class="fas fa-users"></i>
        			<span class="tooltip">Customer Details</span>
            	</a>
            	
            </li>
            <li>
            	<a href="ProductManagement.jsp">
            		<i class="fas fa-box"></i>
        			<span class="tooltip">Product Details</span>
            	</a>
            </li>
            <li>
            	<a href="AddProduct.jsp">
            		<i class="fas fa-plus"></i>
        			<span class="tooltip">Add Products</span>
            	</a>
            </li>
            <li><a href="DisplayOrder.jsp">
            	<i class="fas fa-list"></i>
        		<span class="tooltip">Order Details</span>
            </a></li>
            
            <li><a href="Logout.jsp">
            	<i class="fas fa-sign-out-alt"></i>
        		<span class="tooltip">Logout</span>
            
            </a></li>
        </ul>
    </nav>
    
    
</body>
</html>