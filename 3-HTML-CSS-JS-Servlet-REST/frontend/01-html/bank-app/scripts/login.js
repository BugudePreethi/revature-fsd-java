let loginButton = document.getElementById("login");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

var form1 = document.querySelector('.needs-validation');


loginButton.addEventListener("click", function(){
    form1.addEventListener('submit', function(event){
        if(form1.checkValidity() === false){
            event.preventDefault();
            event.stopPropagation();
            console.log("validation was failed");
        } else{
            form1.classList.add('was-validated');
            getCustomer();
            window.open('create-account.html');
        }
    })
});

async function getCustomer(){
    let customer = {
        email: form.email.value,
        password: form.password.value
    };

    var options = {
        method: 'GET',
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(customer)
    };

    try{
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        success.style.display = "block";
        success.innerText = "Login successful.";
    } catch(err){
        error.style.display = "block";
        error.innerText = "Failed to get customer. Retry or report to site administrator."
    }
}
function clearFormData(){
    form.email.value = "";
    form.password.value = "";
}