// Assume you are using the Fetch API for making HTTP requests

// Example registration
const registerUser = async (userData) => {
    try {
        const response = await fetch('/api/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });

        if (!response.ok) {
            const errorMessage = await response.text();
            console.error(`Registration failed: ${errorMessage}`);
        } else {
            const successMessage = await response.text();
            console.log(`Registration successful: ${successMessage}`);
            // Redirect or perform additional actions as needed
        }
    } catch (error) {
        console.error('Error during registration:', error);
    }
};

// Example login
const loginUser = async (loginData) => {
    try {
        const response = await fetch('/api/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(loginData),
        });

        if (!response.ok) {
            const errorMessage = await response.text();
            console.error(`Login failed: ${errorMessage}`);
        } else {
            const successMessage = await response.text();
            console.log(`Login successful: ${successMessage}`);
            // Redirect or perform additional actions as needed
        }
    } catch (error) {
        console.error('Error during login:', error);
    }
};

// Example logout
const logoutUser = async () => {
    try {
        const response = await fetch('/api/users/logout', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            const errorMessage = await response.text();
            console.error(`Logout failed: ${errorMessage}`);
        } else {
            const successMessage = await response.text();
            console.log(`Logout successful: ${successMessage}`);
            // Redirect or perform additional actions as needed
        }
    } catch (error) {
        console.error('Error during logout:', error);
    }
};

// Usage examples
const registrationData = {
    // Your registration data here
};

const loginData = {
    // Your login data here
};

registerUser(registrationData);
loginUser(loginData);
logoutUser();
