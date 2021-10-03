let signupButton = document.getElementById("signup");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

var form1 = document.querySelector('.needs-validation');


signupButton.addEventListener("click", function(){
    form1.addEventListener('submit', function(event){
        if(form1.checkValidity() === false){
            event.preventDefault();
            event.stopPropagation();
            console.log("validation was failed");
        } else{
            form1.classList.add('was-validated');
            addCustomer();
            window.open('customer-login.html');
        }
    })
});

async function addCustomer(){
    let customer = {
        firstName: form.first_name.value,
        lastName: form.last_name.value,
        email: form.email.value,
        password: form.password.value
    };

    var options = {
        method: 'POST',
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(customer)
    };

    try{
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        success.style.display = "block";
        success.innerText = "Customer added successfully.";
    } catch(err){
        error.style.display = "block";
        error.innerText = "Failed to add customer. Retry or report to site administrator."
    }
}
function clearFormData(){
    form.first_name.value = "";
    form.last_name.value = "";
    form.email.value = "";
    form.password.value = "";
}