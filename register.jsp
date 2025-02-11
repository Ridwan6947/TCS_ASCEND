<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap");
        @import url('https://fonts.googleapis.com/css?family=Roboto:400,500,700');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f5f5f5; /* Changed background color */
        }

        .wrapper {
            width: 420px;
            position: relative; /* Added for z-index */
            z-index: 1; /* Added for z-index */
            background: #FFFFFF; /* White background for the form */
            max-width: 360px; /* Set max-width */
            margin: 0 auto 100px; /* Centered with margin */
            padding: 45px; /* Added padding */
            text-align: center; /* Centered text */
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24); /* Added box shadow */
            border-radius: 10px;
        }

        .wrapper h1 {
            font-size: 36px;
            text-align: center;
            margin-bottom: 20px;
            color: #333; /* Darker heading color */
        }

        .input-box {
            position: relative;
            width: 100%;
            margin: 15px 0; /* Adjusted margin */
        }

        .input-box input,
        .input-box textarea {
            width: 100%;
            background: transparent;
            border: none;
            outline: none;
            border: 1px solid #ccc; /* Slightly darker border */
            border-radius: 5px; /* Slightly smaller border radius */
            font-size: 16px;
            color: #333; /* Darker text color */
            padding: 10px 15px;
        }

        .input-box textarea {
            resize: none;
            height: 70px;
        }

        .input-box input::placeholder,
        .input-box textarea::placeholder {
            color: #999; /* Lighter placeholder color */
        }

        .error-message {
            color: #ff0000; /* Red error messages */
            font-size: 12px;
            margin-top: 5px;
            font-weight: bold;
        }

        .btn {
            font-family: "Roboto", sans-serif; /* Added font family */
            text-transform: uppercase; /* Added text transform */
            outline: 0;
            background: #4CAF50; /* Green button background */
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            transition: all 0.3s ease;
            cursor: pointer;
            margin-bottom: 10px;
            border-radius: 5px; /* Added border radius */
        }

        .btn:hover {
            background: #43A047; /* Darker green on hover */
        }

        .register-link {
            font-size: 14.5px;
            text-align: center;
            margin-top: 20px;
            color: #333; /* Darker link text */
        }

        .register-link p a {
            text-decoration: none;
            font-weight: 600;
            color: #064c4e; /* Teal link color */
        }

        .register-link p a:hover {
            text-decoration: underline;
            color: #064c4e; /* Darker teal on hover */
        }

        .password-toggle, .password-er {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            font-size: 20px;
            color: #333; /* Darker icon color */
        }
        .hero-section{
            display:none; /* Hide the hero section */
        }
    </style>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
    <div class="wrapper">
        <form action="customer" id="registrationForm" method="POST" onsubmit="return validateForm()">
            <input type="hidden" value="register" name="action" />
            <h1>Registration</h1>

            <div class="input-box">
                <input type="text" name="customerName" id="customerName" placeholder="Customer Name" maxlength="50">
                <div class="error-message" id="nameError"></div>
            </div>

            <div class="input-box">
                <input type="text" name="email" id="email" placeholder="Email">
                <div class="error-message" id="emailError"></div>
            </div>

            <div class="input-box">
                <input type="password" name="password" id="password" placeholder="Password" maxlength="30">
                <i id="ibtn" class="bx bxs-show password-toggle" onclick="togglePasswordVisibility()"></i>
                <div class="error-message" id="passwordError"></div>
            </div>

            <div class="input-box">
                <textarea id="address" name="address" placeholder="Address" maxlength="100"></textarea>
                <div class="error-message" id="addressError"></div>
            </div>

            <div class="input-box">
                <input type="text" name="contactNumber" id="contactNumber" placeholder="Contact Number" maxlength="10">
                <div class="error-message" id="contactError"></div>
            </div>

            <button type="submit" class="btn">Register</button>

            <div class="register-link">
                <p>Have an Account? <a href="LoginPage.jsp">Login</a></p>
            </div>
        </form>
    </div>

    <script>
    
    document.addEventListener("DOMContentLoaded",function(){
    	 const customerName = document.getElementById("customerName");
         const email = document.getElementById("email");
         const password = document.getElementById("password");
         const address = document.getElementById("address");
         const contactNumber = document.getElementById("contactNumber");
         const ibtn= document.getElementById("ibtn");
         
         const nameError = document.getElementById("nameError");
         const emailError = document.getElementById("emailError");
         const passwordError = document.getElementById("passwordError");
         const addressError = document.getElementById("addressError");
         const contactError = document.getElementById("contactError");
         
         //validate name
         const validateName = function (){
        	    const name = customerName.value.trim();
        	    const nameRegex=/^[A-Za-z\s]+$/;
        	    if(name===""){
        	    	nameError.textContent = "Name is required";
        	    	 customerName.classList.add("error-message");
           	      	 customerName.classList.remove("error-message");
        	    }
        	    else if (!nameRegex.test(name)){
        	    	 nameError.textContent = "Name must only contain alphabates";
           	      customerName.classList.add("error-message");
           	      customerName.classList.remove("error-message");
        	    }
        	    else if (name.length < 3) {
        	      nameError.textContent = "Name must be at least 3 characters.";
        	      customerName.classList.add("error-message");
        	      customerName.classList.remove("error-message");
        	    } else {
        	      nameError.textContent = "";
        	      customerName.classList.add("error-message");
        	      customerName.classList.remove("error-message");
        	    }
        	  };
        	  
        	  
       	//validate email
       	
        	  const validateEmail =  function () {
        		    const emails = email.value.trim();
        		    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        		    if(emails===""){
        		    	emailError.textContent = "email is required";
        		    	email.classList.add("error-message");
        		    	email.classList.remove("error-message");
            	    }
        		    else if (!emailRegex.test(emails)) {
        		      emailError.textContent = "Invalid email address.";
        		      email.classList.add("error-message");
        		      email.classList.remove("error-message");
        		    } else {
        		      emailError.textContent = "";
        		      email.classList.add("error-message");
        		      email.classList.remove("error-message");
        		    }
        		  };
         //validate password
        		  const validatePassword = function () {
        			    const finalPassword = password.value.trim();
        			    const passwordRegex=/^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,}$/;
        			    if(finalPassword===""){
        			    	passwordError.textContent = "password is required";
        			    	password.classList.add("error-message");
            		    	password.classList.remove("error-message");
            		    	
            		    	 
        			    }
        			    else if (finalPassword.length < 8) {
        			      passwordError.textContent = "Password must be at least 8 characters.";
        			      password.classList.add("error-message");
        			      password.classList.remove("error-message");
        			      ibtn.classList.remove("password-toggle");
          		    	ibtn.classList.add("password-er");
        			    }
        			    else if(!passwordRegex.test(finalPassword)){
        			    	passwordError.textContent = "password must contain combination of uppercase letters, lowercase letters, numbers, and symbols";
        			    	password.classList.add("error-message");
            		    	password.classList.remove("error-message");
            		    	 ibtn.classList.remove("password-toggle");
               		    	ibtn.classList.add("password-er");
        			    }
        			    else {
        			      passwordError.textContent = "";
        			      password.classList.add("error-message");
        			      password.classList.remove("error-message");
        			      ibtn.classList.remove("password-toggle");
            		    	ibtn.classList.add("password-er");
        			    }
        			  };
        // validate address

        			  const validateAddress =  function () {
        			    const finalAddress = address.value.trim();
        			    if(finalAddress===""){
        			    	addressError.textContent = "address is required";
        			    	address.classList.add("error-message");
        			    	address.classList.remove("error-message");
                	    }
        			    if (finalAddress === "") {
        			      addressError.textContent = "Address cannot be empty.";
        			      address.classList.add("error-message");
        			      address.classList.remove("error-message");
        			    } else {
        			      addressError.textContent = "";
        			      address.classList.add("error-message");
        			      address.classList.remove("error-message");
        			    }
        			  };
		//validate contact
        			  const validateContact =  function () {
			
        				    const finalContact = contactNumber.value.trim();
        				    const contactRegex = /^[0-9]{10}$/;
        				    if(finalContact===""){
        				    	contactError.textContent = "contact is required";
        				    	contactNumber.classList.add("error-message");
        				    	contactNumber.classList.remove("error-message");
                    	    }
        				    else if (finalContact.length < 10) {
        				      contactError.textContent = "contact must contain exact 10 digits.";
        				      contactNumber.classList.add("error-message");
        				      contactNumber.classList.remove("error-message");
              			    }
        				    else if (!/^[6-9][0-9]{9}$/.test(finalContact)) {
        				      contactError.textContent = "Contact number must be start with 6-9.";
        				      contactNumber.classList.add("error-message");
        				      contactNumber.classList.remove("error-message");
        				    } else {
        				      contactError.textContent = "";
        				      contactNumber.classList.add("error-message");
        				      contactNumber.classList.remove("error-message");
        				    }
        				  };
        			  
        				  customerName.addEventListener("input", validateName);
        				  email.addEventListener("input", validateEmail);
        				  password.addEventListener("input", validatePassword);
        				  address.addEventListener("input", validateAddress);
        				  contactNumber.addEventListener("input", validateContact);
        				  
        				  // Prevent form submission if there are errors
        				  const form = document.getElementById("registrationForm");
        				  form.addEventListener("submit", (e) => {
        				    validateName();
        				    validateEmail();
        				    validatePassword();
        				    validateAddress();
        				    validateContact();

        				    if (
        				      nameError.textContent ||
        				      emailError.textContent ||
        				      passwordError.textContent ||
        				      addressError.textContent ||
        				      contactError.textContent
        				    ) {
        				      e.preventDefault();
        				    }
        				  });

         
    })
    
    
    //OLD CODE
   
  
        function togglePasswordVisibility() {
          const passwordInput = document.getElementById("password");
          const toggleIcon = document.querySelector(".password-toggle");

          if (passwordInput.type === "password") {
            passwordInput.type = "text";
            toggleIcon.classList.remove("bxs-show");
            toggleIcon.classList.add("bxs-hide");
          } else {
            passwordInput.type = "password";
            toggleIcon.classList.remove("bxs-hide");
            toggleIcon.classList.add("bxs-show");
          }
        }

    </script>
</body>

</html>