<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.entity.Customer" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.helper.DBHelper" %>
<%@ page import="com.helper.SqlAbstraction" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Grocery</title>
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
            color: #064c4e !important;
        }
       
        
        .search-bar {
        width:550px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px 0;
}

/* Style for the input field */
.search-bar input[type="text"] {
    width: 80%; /* Adjust width as needed */
    padding: 12px 20px;
    font-size: 16px;
    border: 2px solid #ddd;
    border-radius: 5px 0 0 5px; /* Rounded left side */
    outline: none;
    transition: all 0.3s ease; /* Smooth transition on focus */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

/* Input field focus effect */
.search-bar input[type="text"]:focus {
    border-color: #064c4e; /* Highlight the border on focus */
    box-shadow: 0 0 5px rgba(255, 111, 0, 0.5); /* Add glow effect on focus */
}

/* Style for the search button */

.search-bar button {
    padding: 12px 20px;
    background-color: #064c4e;
    color: #f7f8f1;
  
    border: none;
    border-radius: 0 5px 5px 0;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

/* Button hover effect */
.search-bar button:hover {
    background-color: #f7f8f1; /* Change to yellow on hover */
    color:#064c4e;
    transform: scale(1.05); /* Slightly enlarge on hover */
}

/* Button focus effect */
.search-bar button:focus {
    outline: none;
    background-color: #fdd835; /* Same as hover effect */
}

/* Additional responsiveness for smaller screens */
@media (max-width: 768px) {
    .search-bar input[type="text"] {
        width: 80%; /* Adjust width on smaller screens */
    }
}
        
        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            padding: 20px;
            margin: 0 auto;
        }
        .product-card {
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 15px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            display: flex;
    		flex-direction: column;
    		justify-content: space-between;
            aspect-ratio: 1 / 1; /* Ensures the card is square */
    		max-width: 300px; /* Optional: Limit max width */
    		margin: auto;
    		border-radius: 10px;
    background: linear-gradient(145deg, ##f9f9f9, #f0f0f0);
    box-shadow: 21px 21px 42px #cfc2c2c7, -21px -21px 42px #ffffff;
        }
        .product-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }
        .product-card img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 5px;
            margin-bottom: 15px;
            
        }
        
        .product-card h3 {
            font-size: 30px;
            margin: 10px 0;
        }
        .quantity-controls {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 10px 0;
        }
        .quantity-controls button {
            background-color: #2c3e50;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            font-size: 14px;
            cursor: pointer;
            margin: 0 5px;
        }
        .quantity-controls button:hover {
            background-color: #fdd835;
        }
        .quantity-controls span {
            font-size: 16px;
            margin: 0 10px;
        }
        .confirm-button {
            background-color: #48ff00;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            font-size: 14px;
            cursor: pointer;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }
        .confirm-button:hover {
            background-color: #45a049;
        }
        .search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 20px 0;
        }

        .search-container .search-bar {
            width: 69%;
            padding: 10px 15px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px 0 0 5px;
            outline: none;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .search-container .search-btn {
            padding: 10px 20px;
            background-color: #ff6f00;
            color: #fff;
            border: none;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .search-container .search-btn:hover {
            background-color: #48ff00;
        }

        .wishlist-button {
            background-color: #2c3e50;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
            text-align: center;
            transition: background-color 0.3s ease;
        }

        .wishlist-button:hover {
            background-color: #fdd835;
        }

        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            grid-column: span 3;
            background-color: #48ff00;
        }
        .my-container {
    		display: flex;
    		justify-content: center;
    		align-items: center;
        	height: 14vh; /* This makes the container fill the entire height of the viewport */
}

 .my-button {
        width: 100%;
        padding: 12px;
        background-color: #064c4e;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .my-button:hover {
        background-color: #217275;
    }

.banner{
	margin:0;
	padding:0;
	background-position : center;
	background-repeat: no-repeat;
	color:black;
	display:flex;
	flex-direction:column;
	justify-content:center;
	align-items:flex-end;
	
}

.shop-btn{
	cursor:pointer;
	text-decoration: none;
    background-color: #064c4e;
    color: #f7f8f1;
    padding: 10px 15px;
    border-radius: 5px;
    font-size: 16px;
    font-weight: 500;
    display: inline-flex;
    align-items: center;
    gap: 10px;
   margin-top:20px;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.shop-btn:hover {
    background-color: #f7f8f1;
    color: #064c4e;
    transform: translateY(-3px);
}
    </style>
</head>
<body>

<%
    if (session.getAttribute("customer") != null) {
        Customer customer = (Customer) session.getAttribute("customer");
        
%>
    <jsp:include page="./commons/publicNavBar.jsp" />
  

    
    
    
    
   

    <section class="product-grid">
        <%
        
        String searchQuery = request.getParameter("searchQuery");
        String sql = SqlAbstraction.abs1;

        // Add filtering based on the input
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
        	sql += SqlAbstraction.abs2;
    	}
    	String customerEmail = customer.getEmail();
    	try (PreparedStatement pstmt = DBHelper.getPreparedStatement(sql)) {
    		int paramIndex = 1;
        	pstmt.setString(paramIndex++, customerEmail);
        	if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                String searchTerm = "%" + searchQuery.trim() + "%";
                pstmt.setString(paramIndex++, searchTerm); // Set for productName
                pstmt.setString(paramIndex++, searchTerm); // Set for category
            }
        	
        	ResultSet rs = pstmt.executeQuery();
       
        	while (rs.next()) {
            	int productId = rs.getInt("productId");
            	String productName = rs.getString("productName");
            	String productCategory = rs.getString("category");
            	String productDescription = rs.getString("productDescription");
            	double productPrice = rs.getDouble("productPrice");
            	int productquantity = rs.getInt("productquantity");
                
            	String imgUrl = rs.getString("imgUrl");
            	int cartQuantity = rs.getInt("cartQuantity");
%>
<div class="product-card" id="product-card">
    <!-- Product Image -->
    <img src="<%= imgUrl != null ? imgUrl : "images/default-product.jpg" %>" alt="<%= productName %>">

    <!-- Product Name -->
    <h3><%= productName %></h3>
    
    <!-- Product Category -->
    <h3><%= productCategory %></h3>

    <!-- Product Price -->
    <p>Rs. <%= productPrice %> </p>
	
	<!-- Product in stock or not -->
	<%  
	   if(productquantity > 0){
	%>
	<p >In Stock</p>
	
	<%	   
	   }else{
	%>	   
	<p style="color : red">Not In Stock</p>
	
	<%
	   }
	%>
    <!-- Quantity Controls -->

    
    
    <!-- Quantity Controls -->
    <div class="quantity-controls">
        <!-- Decrement Button -->
        <form action="removeToCartAction" method="post" style="display: inline;">
            <input type="hidden" name="id" value="<%= productId %>">
            <button type="submit">-</button>
        </form>

        <!-- Quantity Display -->
        <input type="text" name="quantity" value="<%= cartQuantity > 0 ? cartQuantity : 0 %>" readonly style="width: 30px; text-align: center;">

        <!-- Increment Button -->
        <form action="AddToCart" method="post" style="display: inline;">
            <input type="hidden" name="id" value="<%= productId %>">
            <button type="submit">+</button>
        </form>
    </div>
</div>

<%
        }
    } catch (SQLException e) {
        out.println("Error: " + e.getMessage());
    }
%>
    </section>
    <div class="my-container">
        <form action="Cart.jsp" method="post">
            <button type="submit" class="my-button">Go to Cart</button>
        </form>
    </div>

<%
    } else {
        response.sendRedirect("LoginPage.jsp");
    }
%>
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
    function incrementQuantity(button) {
        const input = button.previousElementSibling;
        input.value = parseInt(input.value) + 1;
    }

    function decrementQuantity(button) {
        const input = button.nextElementSibling;
        if (parseInt(input.value) > 1) {
            input.value = parseInt(input.value) - 1;
        }
    }
    
    document.getElementById("shop-btn").addEventListener("click",function(){
    	const ProductCards=document.getElementById("product-card");
    	ProductCards.scrollIntoView({behavior:'smooth'});
    });
    
    
    
    window.addEventListener('beforeunload',function(){
    	sessionStorage.setItem('scrollPosition',window.scrollY);
    })
    
    window.addEventListener('load',function(){
    	const scrollPosition=sessionStorage.getItem('scrollPosition');
    	if(scrollPosition){
    		window.scrollTo(0,parseInt(scrollPosition,10));
    	}
    })
    
    

</script>
</body>
</html>