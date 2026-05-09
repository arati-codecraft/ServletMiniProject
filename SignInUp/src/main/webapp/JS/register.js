function validateRegistration() {
    let password = document.getElementsByName("password")[0].value;
    let confirmPassword = document.getElementsByName("confirmPassword")[0].value;

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }
    return true;
}