let loginButton = document.getElementById("login");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

loginButton.addEventListener("click", function(){
    console.log("Before get");
    getCustomer();
    console.log("After get");
});

async function getCustomer(){
    console.log("In get");
    let customer = {
        email: form.email.value,
        password: form.password.value
    };

    var options = {
        method: 'POST',
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(customer)
    };

    try{
        let response = await fetch("http://localhost:8080/bank-app-rest/authenticate", options);
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        window.location.href="accounts.html";
    } catch(err){
        console.log(err);
        error.style.display = "block";
        error.innerText = "Failed to get customer. Retry or report to site administrator."
    }
}
function clearFormData(){
    form.email.value = "";
    form.password.value = "";
}