let esignup = document.getElementById("esignup");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";
let signup = document.getElementById("submit");
let firstName = document.getElementById("firstName");
let email = document.getElementById("email");
let password = document.getElementById("password");
let form = document.forms[0];
let valid = true;

let firstNameError = document.getElementById("firstNameError");
let emailError = document.getElementById("emailError");
let passwordError = document.getElementById("passwordError");

let firstNameValidError;

success.style.display = "none";
error.style.display = "none";


 function  onClickingButton() {
    let firstNameValid = true;
    let emailValid = true;
    let passwordValid = true;
    if (firstName.value == "" ) {        
        firstNameError.innerText = "First name is required";
        firstNamevalid=false;
        return;
        
    }
   else if(!firstName.value.match( /^[A-Za-z]+$/)){
         
        firstNameError.innerText = "Please do not enter numbers";
        firstNamevalid=false;
        return;
    }
    
    if(email.value == ""){
        emailError.innerText = "Email is required";
        emailValid = false;
    }
    else if(!email.value.match(/[a-z0-9._%+-]+@[a-z0-9.9.-]+\.[a-z]{2,}$/)){
        emailError.innerText="Please enter email in correct format";
        emailValid = false;
    }
    if(password.value == ""){
        passwordError.innerText = "Password is required";
        passwordValid = false;
    }
    console.log(valid);
    if(firstNameValid == true && emailValid == true && passwordValid == true && firstNameValidError == true){
        console.log("Before adding customer and after clicking submit button");
        addCustomer(); 
    }
}

firstName.addEventListener("keyup", function () {
   firstNameValidError = true;
    if (firstName.value != "" && firstName.value.length > 20) {
        firstNameValidError = false;
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        return;
    }
    if (firstName.value != "" && firstName.value.length <= 20) {       
        firstNameError.innerText = "Looks good";
        return;
    }   
});
email.addEventListener("keyup", function () {
    if (email.value != "" ) {
        emailError.innerText = "";
        return;
    }    
});

password.addEventListener("keyup", function(){
    if (password.value != "" && password.value.length <= 20) {
        console.log("called");
        passwordError.innerText = "";
        return;
    }
})

// esignup.addEventListener("click", function(){
//     addEmployee();
// });

async function addEmployee(){
    let employee = {
        firstName: form.first_name.value,
        lastName: form.last_name.value,
        email: form.email.value,
        password: form.password.value
    };

    var options = {
        method: 'POST',
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(employee)
    };

    try{
        let response = await fetch("http://localhost:8080/bank-app-rest/employees", options);
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        success.style.display = "block";
        success.innerText = "Employee added successfully.";
        window.location.href="employee-login.html";
    } catch(err){
        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."
    }
}
function clearFormData(){
    form.first_name.value = "";
    form.last_name.value = "";
    form.email.value = "";
    form.password.value = "";
}