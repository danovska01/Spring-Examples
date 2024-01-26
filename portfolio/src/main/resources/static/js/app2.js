const form = document.querySelector('#form');
const username = document.querySelector('#username');
const email = document.querySelector('#email');
const password = document.querySelector('#password');
const cpassword = document.querySelector('#cpassword');

form.addEventListener('submit', (e) => {
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

    fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
        .then((response) => {
            if (!response.ok) {
                console.error('Server Error:', response);

                // Access error message from the response body
                return response.text().then(errorMessage => {
                    console.error('Error Message:', errorMessage);
                    throw new Error(`HTTP error! Status: ${response.status}. Message: ${errorMessage}`);
                });
            }
            return response.json();
        })



        .then((data) => {
            console.log('Success:', data);
            // Handle success, e.g., redirect to login page
            window.location.href = '/login';
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle error, e.g., display an error message
        });
});

function validateInputs() {
    const username = username.value.trim();
    const email = email.value.trim();
    const password = password.value.trim();
    const confirmPassword = cpassword.value.trim();
    let success = true;

    if (username === '') {
        success = false;
        setError(username, 'Username is required');
    } else {
        setSuccess(username);
    }

    if (email === '') {
        success = false;
        setError(email, 'Email is required');
    } else if (!validateEmail(email)) {
        success = false;
        setError(email, 'Please enter a valid email');
    } else {
        setSuccess(email);
    }

    if (password === '') {
        success = false;
        setError(password, 'Password is required');
    } else if (password.length < 8) {
        success = false;
        setError(password, 'Password must be at least 8 characters long');
    } else {
        setSuccess(password);
    }

    if (confirmPassword === '') {
        success = false;
        setError(cpassword, 'Confirm password is required');
    } else if (confirmPassword !== password) {
        success = false;
        setError(cpassword, 'Password does not match');
    } else {
        setSuccess(cpassword);
    }

    return success;
}

function setError(element, message) {
    const inputGroup = element.parentElement;
    const errorElement = inputGroup.querySelector('.error');

    errorElement.innerText = message;
    inputGroup.classList.add('error');
    inputGroup.classList.remove('success');
}

function setSuccess(element) {
    const inputGroup = element.parentElement;
    const errorElement = inputGroup.querySelector('.error');

    errorElement.innerText = '';
    inputGroup.classList.add('success');
    inputGroup.classList.remove('error');
}

const validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
};
