$('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
 });
 
 document.getElementById("registration-form").addEventListener("submit", async function (event){
    event.preventDefault();
    
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const address = document.getElementById("address").value.trim();
    const contact = document.getElementById("contact").value.trim();
    
    if(!/^[A-Za-z\s]+$/.test(name)){
      alert("Customer name must have alphabets only");
      return;
    }
    if(!email.includes("@")){
      alert("Email id not valid");
      return;
    }
    if(address === ""){
      alert("address field cannot be blank");
      return;
    }
    if(!/^\d{10}$/.test(contact)){
      alert("Contact number not valid");
      return;
    }
    
    const formData = {
        name, 
        email, 
        password, 
        address, 
        contact,
        customerId: 'CUST' + Math.floor(100000 + Math.random() * 900000) // Generate random 6-digit ID
    };
    
    try {
        // Store in localStorage for testing
        const existingUsers = JSON.parse(localStorage.getItem('users') || '[]');
        existingUsers.push(formData);
        localStorage.setItem('users', JSON.stringify(existingUsers));

        // Simulate API response
        const data = {
            success: true,
            customerId: formData.customerId
        };
        
        if(data.success){
            document.getElementById("customer-id").textContent = data.customerId;
            document.getElementById("registration-form").style.display = "none";
            document.getElementById("acknowledgment").style.display = "block";
            
            // Hide acknowledgment and show login form after 3 seconds
            setTimeout(() => {
                document.getElementById("acknowledgment").style.display = "none";
                $('.login-form').animate({height: "toggle", opacity: "toggle"}, "slow");
            }, 3000);
        }
    } catch (error) {
        console.error(error);
        alert("An error occurred");
    }
 });

// Update login form handler to check localStorage
document.querySelector(".login-form").addEventListener("submit", async function(event) {
    event.preventDefault();
    
    const email = document.getElementById("login-email").value.trim();
    const password = document.getElementById("login-password").value.trim();
    
    try {
        // Check credentials in localStorage
        const users = JSON.parse(localStorage.getItem('users') || '[]');
        const user = users.find(u => u.email === email && u.password === password);
        
        if(user){
            window.location.href = "#"; // Replace with actual home.html path later
        } else {
            alert("Invalid credentials");
        }
    } catch (error) {
        console.error(error);
        alert("An error occurred");
    }
});

$(document).ready(function() {
    $('.register-form').show();
    $('.login-form').hide();
});