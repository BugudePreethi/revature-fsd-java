let login = document.getElementById("login");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

login.addEventListener("click", function(){
    getEmployee();
    window.location.href="customer-details.html";
});

async function getEmployee(){
    let employee = {
        email: form.email.value,
        password: form.password.value
    };

    var options = {
        method: 'GET',
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(employee)
    };

    try{
        let response = await fetch("http://localhost:8080/bank-app-rest/employees", options);
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        success.style.display = "block";
        success.innerText = "Login successful.";
    } catch(err){
        error.style.display = "block";
        error.innerText = "Failed to get employee. Retry or report to site administrator."
    }
}
function clearFormData(){
    form.email.value = "";
    form.password.value = "";
}