function validateLogin() {
    let username = document.getElementsByName("username")[0].value.trim();
    let password = document.getElementsByName("password")[0].value;

    if (username === "" || password === "") {
        alert("All fields are required");
        return false;
    }
    return true;
}