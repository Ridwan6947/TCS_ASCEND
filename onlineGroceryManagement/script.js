// Function to show only the specified form and hide the others
function showForm(formId) {
    // Remove active class from all forms
    document.getElementById("registration-form").classList.remove("active");
    document.getElementById("login-form").classList.remove("active");
    
    // Add active class to the selected form
    document.getElementById(formId).classList.add("active");
}

// Show login form when "Sign In" is clicked
document.getElementById("showLogin").addEventListener("click", function(event) {
    event.preventDefault();
    showForm("login-form");
});

// Show registration form when "Create an account" is clicked
document.getElementById("showRegister").addEventListener("click", function(event) {
    event.preventDefault();
    showForm("registration-form");
});

// Initial display setup
showForm("registration-form"); // Show registration form by default

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
        alert("Address field cannot be blank");
        return;
    }
    if(!/^\d{10}$/.test(contact)){
        alert("Contact number not valid");
        return;
    }
    if(password.length < 6 || !/[A-Z]/.test(password) || !/[0-9]/.test(password) || !/[!@#$%^&*]/.test(password)){
        alert("Password must be at least 6 characters long and include an uppercase letter, a number, and a special character.");
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
                showForm("login-form"); // Show login form
            }, 3000);
        }
    } catch (error) {
        console.error(error);
        alert("An error occurred");
    }
});

// Update login form handler
document.getElementById("login-form").addEventListener("submit", async function(event) {
    event.preventDefault();
    
    const email = document.getElementById("login-email").value.trim();
    const password = document.getElementById("login-password").value.trim();
    
    // Check if it's admin login
    if (email === ADMIN_EMAIL && password === ADMIN_PASSWORD) {
        document.getElementById("loginPage").style.display = "none";
        document.getElementById("adminPanel").style.display = "block";
        showAdminTab('dashboard');
        return;
    }
    
    try {
        // Check credentials in localStorage
        const users = JSON.parse(localStorage.getItem('users') || '[]');
        const user = users.find(u => u.email === email && u.password === password);
        
        if(user) {
            // Store current user in localStorage
            localStorage.setItem('currentUser', JSON.stringify(user));
            
            document.getElementById("loginPage").style.display = "none";
            document.getElementById("homePage").style.display = "block";
            document.getElementById("userName").innerText = user.name;
            document.getElementById("userNameDisplay").innerText = user.name;
            document.getElementById("userPhone").innerText = user.contact;
            document.getElementById("userEmail").innerText = user.email;
        } else {
            alert("Invalid credentials");
        }
    } catch (error) {
        console.error(error);
        alert("An error occurred");
    }
});

// Also update the logout function to clear currentUser
document.getElementById("logout").addEventListener("click", function(event) {
    event.preventDefault();
    localStorage.removeItem('currentUser'); // Clear current user
    cart = {}; // Clear cart
    document.getElementById("homePage").style.display = "none";
    document.getElementById("loginPage").style.display = "block";
});

// Home Page Functionality
const items = [
    { 
        name: "Apple", 
        price: 30,
        image: "https://images.unsplash.com/photo-1619546813926-a78fa6372cd2?w=500&q=80"
    },
    { 
        name: "Banana", 
        price: 30,
        image: "https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?w=500&q=80"
    },
    { 
        name: "Carrot", 
        price: 20,
        image: "https://images.unsplash.com/photo-1598170845058-32b9d6a5da37?w=500&q=80"
    },
    { 
        name: "Tomato", 
        price: 20,
        image: "https://images.unsplash.com/photo-1592924357228-91a4daadcfea?w=500&q=80"
    }
];
let cart = {};

function navigate(page) {
    document.getElementById("content").style.display = page === 'home' ? 'block' : 'none';
    document.getElementById("profilePage").style.display = page === 'profile' ? 'block' : 'none';
    document.getElementById("cartPage").style.display = page === 'cart' ? 'block' : 'none';
    
    if (page === 'cart' && Object.keys(cart).length === 0) {
        document.getElementById("cartPage").innerHTML = `
            <div style="text-align: center; padding: 20px;">
                <h2>Your Cart is Empty</h2>
                <p>Add some items to your cart to get started!</p>
                <button onclick="navigate('home')" class="checkout-btn">Continue Shopping</button>
            </div>
        `;
    }
}

function addToCart(index) {
    let item = items[index];
    if (cart[item.name]) {
        cart[item.name].quantity += 1;
    } else {
        cart[item.name] = { ...item, quantity: 1 };
    }
    displayItems();
}

function updateQuantity(itemName, change) {
    if (cart[itemName]) {
        cart[itemName].quantity += change;
        if (cart[itemName].quantity <= 0) {
            delete cart[itemName];
        }
    }
    displayItems();
}

function updateCartCount() {
    const count = Object.values(cart).reduce((sum, item) => sum + item.quantity, 0);
    document.querySelector('.cart-count').textContent = count;
}

function displayItems() {
    let store = document.getElementById("storeItems");
    store.innerHTML = "";
    items.forEach((item, index) => {
        let quantity = cart[item.name] ? cart[item.name].quantity : 0;
        store.innerHTML += `
            <div class="item">
                <div class="item-image">
                    <img src="${item.image}" alt="${item.name}">
                </div>
                <div class="item-details">
                    <h3>${item.name}</h3>
                    <p class="price">Rs${item.price.toFixed(2)}</p>
                    <div class="cart-controls">
                        <button onclick="updateQuantity('${item.name}', -1)">-</button>
                        <span class="quantity">${quantity}</span>
                        <button onclick="addToCart(${index})">+</button>
                    </div>
                </div>
            </div>
        `;
    });

    let cartItems = document.getElementById("cartItems");
    cartItems.innerHTML = "";
    let total = 0;
    
    for (let itemName in cart) {
        let cartItem = cart[itemName];
        let itemTotal = cartItem.price * cartItem.quantity;
        total += itemTotal;
        cartItems.innerHTML += `
            <tr>
                <td>${cartItem.name}</td>
                <td>$${cartItem.price.toFixed(2)}</td>
                <td>${cartItem.quantity}</td>
                <td>$${itemTotal.toFixed(2)}</td>
                <td>
                    <button class="delete-icon" onclick="deleteItem('${itemName}')">🗑️</button>
                </td>
            </tr>
        `;
    }
    
    document.getElementById("totalAmount").innerText = total.toFixed(2);
    updateCartCount();
}

function deleteItem(itemName) {
    delete cart[itemName];
    displayItems();
}

function editProfile() {
    // Logic to edit profile
    const newName = prompt("Enter new name:", document.getElementById("userNameDisplay").innerText);
    const newPhone = prompt("Enter new phone:", document.getElementById("userPhone").innerText);
    const newEmail = prompt("Enter new email:", document.getElementById("userEmail").innerText);
    
    if (newName) {
        document.getElementById("userNameDisplay").innerText = newName;
        document.getElementById("userName").innerText = newName; // Update name on home page
    }
    if (newPhone) document.getElementById("userPhone").innerText = newPhone;
    if (newEmail) document.getElementById("userEmail").innerText = newEmail;
}

// Load user data from localStorage
const users = JSON.parse(localStorage.getItem('users') || '[]');
const loggedInUser        = users[0]; // Assuming the first user is logged in for demo purposes
if (loggedInUser        ) {
    document.getElementById("userName").innerText = loggedInUser        .name;
    document.getElementById("userNameDisplay").innerText = loggedInUser        .name;
    document.getElementById("userPhone").innerText = loggedInUser        .contact;
    document.getElementById("userEmail").innerText = loggedInUser        .email;
}

// Add these functions for checkout and notification
function showNotification(message) {
    // Create notification element
    const notification = document.createElement('div');
    notification.className = 'notification';
    notification.textContent = message;
    document.body.appendChild(notification);

    // Show notification
    setTimeout(() => notification.classList.add('show'), 100);

    // Remove notification after 3 seconds
    setTimeout(() => {
        notification.classList.remove('show');
        setTimeout(() => notification.remove(), 300);
    }, 3000);
}

function generateOrderId() {
    return 'ORD' + Math.random().toString(36).substr(2, 9).toUpperCase();
}

function calculateTotal() {
    return Object.values(cart).reduce((total, item) => total + (item.price * item.quantity), 0);
}

function checkout() {
    if (Object.keys(cart).length === 0) {
        showNotification('Your cart is empty!');
        return;
    }

    const orderId = generateOrderId();
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    
    if (!currentUser) {
        showNotification('Please login to checkout!');
        return;
    }
    
    const order = {
        orderId,
        customerName: currentUser.name,
        contact: currentUser.contact,
        items: Object.values(cart),
        total: calculateTotal(),
        date: new Date().toISOString()
    };

    // Store order in localStorage
    const orders = JSON.parse(localStorage.getItem('orders') || '[]');
    orders.push(order);
    localStorage.setItem('orders', JSON.stringify(orders));

    // Clear cart and show notification
    cart = {};
    displayItems();
    showNotification(`Order placed successfully! Your order ID is: ${orderId}`);
    
    setTimeout(() => {
        navigate('home');
    }, 2000);
}

// Admin credentials
const ADMIN_EMAIL = "ridwan@gmail.com";
const ADMIN_PASSWORD = "Ridwan1211@#";

// Admin login function
function adminLogin() {
    const email = document.getElementById("login-email").value;
    const password = document.getElementById("login-password").value;

    if (email === ADMIN_EMAIL && password === ADMIN_PASSWORD) {
        document.getElementById("loginPage").style.display = "none";
        document.getElementById("adminPanel").style.display = "block";
        showAdminTab('dashboard'); // Show dashboard by default
        updateDashboard();
    } else {
        alert("Invalid admin credentials!");
    }
}

function adminLogout() {
    document.getElementById("adminPanel").style.display = "none";
    document.getElementById("loginPage").style.display = "block";
}

function showAdminTab(tab) {
    // Hide all tabs first
    document.getElementById('adminDashboard').style.display = 'none';
    document.getElementById('adminProducts').style.display = 'none';
    document.getElementById('adminOrders').style.display = 'none';
    document.getElementById('adminCustomers').style.display = 'none';

    // Remove active class from all nav items
    document.querySelectorAll('.admin-panel .nav-left a').forEach(item => {
        item.classList.remove('active');
    });

    // Add active class to clicked nav item
    const activeNav = document.querySelector(`.admin-panel .nav-left a[onclick="showAdminTab('${tab}')"]`);
    if (activeNav) activeNav.classList.add('active');

    // Show selected tab and update its content
    switch(tab) {
        case 'dashboard':
            document.getElementById('adminDashboard').style.display = 'block';
            updateDashboard();
            break;
        case 'products':
            document.getElementById('adminProducts').style.display = 'block';
            displayProducts();
            break;
        case 'orders':
            document.getElementById('adminOrders').style.display = 'block';
            displayOrders();
            break;
        case 'customers':
            document.getElementById('adminCustomers').style.display = 'block';
            displayCustomers();
            break;
    }
}

function updateDashboard() {
    const users = JSON.parse(localStorage.getItem('users') || '[]');
    const orders = JSON.parse(localStorage.getItem('orders') || '[]');
    let totalSales = orders.reduce((sum, order) => sum + order.total, 0);

    document.getElementById('totalOrders').textContent = orders.length;
    document.getElementById('totalSales').textContent = totalSales.toFixed(2);
    document.getElementById('totalCustomers').textContent = users.length;
}

function showAddProductForm() {
    const form = document.getElementById('addProductForm');
    form.style.display = form.style.display === 'none' ? 'block' : 'none';
}

function addProduct(event) {
    event.preventDefault();
    const products = JSON.parse(localStorage.getItem('products') || '[]');
    
    const newProduct = {
        id: 'PROD' + Math.random().toString(36).substr(2, 9).toUpperCase(),
        name: document.getElementById('productName').value,
        price: parseFloat(document.getElementById('productPrice').value),
        image: document.getElementById('productImage').value
    };

    products.push(newProduct);
    localStorage.setItem('products', JSON.stringify(products));
    displayProducts(); // Refresh the products display
    event.target.reset();
    showAddProductForm();
}

function displayProducts() {
    const products = JSON.parse(localStorage.getItem('products') || '[]');
    const tbody = document.getElementById('productsList');
    if (!tbody) return; // Safety check

    tbody.innerHTML = products.map(product => `
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>₹${product.price.toFixed(2)}</td>
            <td><button class="delete-btn" onclick="deleteProduct('${product.id}')">Delete</button></td>
        </tr>
    `).join('');
}

function deleteProduct(id) {
    if (confirm('Are you sure you want to delete this product?')) {
        let products = JSON.parse(localStorage.getItem('products') || '[]');
        products = products.filter(p => p.id !== id);
        localStorage.setItem('products', JSON.stringify(products));
        displayProducts(); // Refresh the display
    }
}

function displayOrders() {
    const orders = JSON.parse(localStorage.getItem('orders') || '[]');
    const tbody = document.getElementById('ordersList');
    if (!tbody) return; // Safety check

    tbody.innerHTML = orders.map(order => `
        <tr>
            <td>${order.orderId}</td>
            <td>${order.customerName}</td>
            <td>${order.items.map(item => `${item.name} (${item.quantity})`).join(', ')}</td>
            <td>₹${order.total.toFixed(2)}</td>
            <td>${order.contact}</td>
        </tr>
    `).join('');
}

function displayCustomers() {
    const users = JSON.parse(localStorage.getItem('users') || '[]');
    const tbody = document.getElementById('customersList');
    if (!tbody) return; // Safety check

    tbody.innerHTML = users.map(user => `
        <tr>
            <td>${user.customerId}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.contact}</td>
            <td><button class="delete-btn" onclick="deleteCustomer('${user.customerId}')">Delete</button></td>
        </tr>
    `).join('');
}

function deleteCustomer(id) {
    if (confirm('Are you sure you want to delete this customer?')) {
        let users = JSON.parse(localStorage.getItem('users') || '[]');
        users = users.filter(u => u.customerId !== id);
        localStorage.setItem('users', JSON.stringify(users));
        displayCustomers(); // Refresh the customers display
        updateDashboard(); // Update dashboard numbers
    }
}

function searchProducts(query) {
    const products = JSON.parse(localStorage.getItem('products') || '[]');
    const filtered = products.filter(p => 
        p.name.toLowerCase().includes(query.toLowerCase()) ||
        p.id.toLowerCase().includes(query.toLowerCase())
    );
    const tbody = document.getElementById('productsList');
    tbody.innerHTML = filtered.map(product => `
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>₹${product.price.toFixed(2)}</td>
            <td><button class="delete-btn" onclick="deleteProduct('${product.id}')">Delete</button></td>
        </tr>
    `).join('');
}

function searchOrders(query) {
    const orders = JSON.parse(localStorage.getItem('orders') || '[]');
    const filtered = orders.filter(o => 
        o.orderId.toLowerCase().includes(query.toLowerCase()) ||
        o.customerName.toLowerCase().includes(query.toLowerCase())
    );
    const tbody = document.getElementById('ordersList');
    tbody.innerHTML = filtered.map(order => `
        <tr>
            <td>${order.orderId}</td>
            <td>${order.customerName}</td>
            <td>${order.items.map(item => `${item.name} (${item.quantity})`).join(', ')}</td>
            <td>₹${order.total.toFixed(2)}</td>
            <td>${order.contact}</td>
        </tr>
    `).join('');
}

function searchCustomers(query) {
    const users = JSON.parse(localStorage.getItem('users') || '[]');
    const filtered = users.filter(u => 
        u.name.toLowerCase().includes(query.toLowerCase()) ||
        u.email.toLowerCase().includes(query.toLowerCase()) ||
        u.customerId.toLowerCase().includes(query.toLowerCase())
    );
    const tbody = document.getElementById('customersList');
    tbody.innerHTML = filtered.map(user => `
        <tr>
            <td>${user.customerId}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.contact}</td>
            <td><button class="delete-btn" onclick="deleteCustomer('${user.customerId}')">Delete</button></td>
        </tr>
    `).join('');
}

displayItems();