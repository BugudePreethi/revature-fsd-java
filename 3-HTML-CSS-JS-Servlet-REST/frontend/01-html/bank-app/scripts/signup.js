let signup = document.getElementById("submit");
let firstName = document.getElementById("first_name");
let lastName = document.getElementById("last_name");
let email = document.getElementById("email");
let password = document.getElementById("password");
let error = document.getElementById("error");

error.style.display = "none";

let firstNameError = document.getElementById("firstNameError");
let valid = true;

signup.addEventListener("click", function(){

    if(valid){
        addCustomer();
    }
     
    // if(firstName.value == ""){
    //     let firstNameError = document.getElementById("firstNameError");
    //     firstNameError.innerText = "First Name is required";
    //     return;
    // }else if(email.value == ""){
    //     let emailError = document.getElementById("emailError");
    //     emailError.innerText = "Email is required";
    //     return;
    // }else if(password.value == ""){
    //     let passwordError = document.getElementById("passwordError");
    //     passwordError.innerText = "Password is required";
    //     return;
    // } else{
    //     addCustomer();
    // }

    
});

async function addCustomer(){

    //if(valid){
        let customer = {
            firstName: form.first_name.value,
            lastName: form.last_name.value,
            email: form.email.value,
            password: form.password.value
        };
    //};

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json"},
        body: JSON.stringify(customer)
    };

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        window.location.href = "login.html";
    } catch (err) {
        error.style.display = "block";
    }
}

firstName.addEventListener("keyup",function(){
    if(firstName.value != "" && firstName.value.length > 20){
        let firstNameError = document.getElementById("firstNameError");
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        return;
    }

    if(firstName.value != "" && firstName.value.length <= 20){
        let firstNameError = document.getElementById("firstNameError");
        firstNameError.innerText = "";
        return;
    }

    if (firstName.value != "") {
        let pattern = /^[A-Za-z]+$/;
        console.log(firstName.value.match(pattern));
        if (!firstName.value.match(pattern)) {
            firstNameError.innerText = "Numbers not allowed";
        }
    }

});
email.addEventListener("keyup",function(){
    if (email.value != "") {
        let pattern = /[a-z0-9._%+-]+@[a-z0-9.9.-]+\.[a-z]{2,}$/;
        console.log(email.value.match(pattern));
        if (!email.value.match(pattern)) {
            emailError.innerText = "Please enter a valid email";
        }
    }

});
