function validateLogin() {

    let username = document.getElementsByName("username")[0].value.trim();
    let password = document.getElementsByName("password")[0].value.trim();

    if (username === "") {
        alert("Username is required");
        return false;
    }

    if (password === "") {
        alert("Password is required");
        return false;
    }

    return true;
}


function validateRegistration() {

    let fullname = document.getElementsByName("fullname")[0].value.trim();
    let email = document.getElementsByName("email")[0].value.trim();
    let mobile = document.getElementsByName("mobile")[0].value.trim();
    let username = document.getElementsByName("username")[0].value.trim();
    let password = document.getElementsByName("password")[0].value;
    let confirmPassword = document.getElementsByName("confirmPassword")[0].value;

    if (fullname === "" || email === "" || mobile === "" || username === "") {
        alert("All fields are required!");
        return false;
    }

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }

    if (password.length < 4) {
        alert("Password must be at least 4 characters");
        return false;
    }

    return true;
}