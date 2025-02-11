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
        .logo{
			   height: 50px;
			   width: 200px;
			   background-size: contain;
			   background-image: url(images_new/logo3.png) !important;
			   background-repeat: no-repeat;
		            
        }
        
        
        nav {
  background-color: #ffffff;
  color: #fff;
  padding: 15px 20px;
  display: flex;
  justify-content: space-between; /* This is key for left/right alignment */
  align-items: center;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
        nav .logo {
            font-size: 24px;
            font-weight: 600;
        }
        .logo a {
            text-decoration: none;
            color: #2c3e50;
            font-weight: bold;
            font-size: 3.5rem;
        }
        nav ul {
            list-style: none;
            display: flex;
            gap: 20px;
            margin: 0;
  			padding: 0;
        }
        nav ul.nav-left { /* Style for left-aligned items */
            margin-left: 0; /* Remove default left margin */
        }

        nav ul.nav-right { /* Style for right-aligned items */
            margin-right: 0; /* Remove default right margin */
        }
        nav ul li a {
            color: #fff;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.3s ease;
            display: inline-block;
        }
        
        .nav-button {
 text-decoration: none;
    background-color: #f7f8f1;
    color: #064c4e;
    padding: 10px 15px;
    border-radius: 5px;
    font-size: 16px;
    font-weight: 500;
    display: inline-flex;
    align-items: center;
    gap: 10px;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.nav-button i {
  font-size: 18px; /* Icon size */
}

.nav-button:hover {
  background-color: #064c4e;
  color: #f7f8f1;
  transform: translateY(-3px); /* Lift animation */
}

.nav-button:active {
  transform: translateY(1px);
}
        
        nav ul li a:hover {
            color: #fdd835;
        }
        header {
            text-align: center;
            margin: 20px 0;
            font-size: 28px;
            font-weight: 500;
        }
        .ProductController{
        }
 </style>     
</head>
<body>
<nav>

     
	  <ul class="nav-left">  <li>
	      <a href="HomePage.jsp?home=true" class="nav-button">
	        <i class="fas fa-home"></i> Home
	      </a>
	    </li>
	   
	    <li>
	      <a href="Cart.jsp" class="nav-button">
	        <i class="fas fa-shopping-cart"></i> Cart
	      </a>
	    </li>
	  </ul>
	  
	  <ul class="nav-right"> <li>
	      <a href="MyProfile.jsp" class="nav-button">
	        <i class="fas fa-user"></i> My Profile
	      </a>
	    </li>
	    <li>
	      <a href="Logout.jsp" class="nav-button">
	        <i class="fas fa-sign-out-alt"></i> Logout
	      </a>
	    </li>
	  </ul>
</nav>

<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
  rel="stylesheet"
/>

    
    
</body>
<script>


</script>
</html>