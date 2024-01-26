document.addEventListener('DOMContentLoaded', function () {
    const registerForm = document.getElementById('form');

    registerForm.addEventListener('submit', function (e) {
        e.preventDefault();

        if (!validateInputs()) {
            return;
        }

        const formData = {
            username: username.value.trim(),
            email: email.value.trim(),
            password: password.value.trim(),
            cpassword: cpassword.value.trim(),
        };


        fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Success:', data);
                // Redirect to the login page on successful registration
                window.location.href = '/login';
            })
            .catch(error => {
                console.error('Error:', error);
                // Handle error, e.g., display an error message
            });
    });

    function validateInputs() {
        // Implement your input validation logic
        return true; // Return true if validation passes
    }
});
