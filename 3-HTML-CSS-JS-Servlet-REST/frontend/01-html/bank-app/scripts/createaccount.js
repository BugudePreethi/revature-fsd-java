let createButton = document.getElementById("add");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

createButton.addEventListener("click", function(){
    if(form.balance.value >= 2000){
        addAccount();
    }
});

async function addAccount(){
    let account = {
        accountNumber: form.account_number.value,
        customerId: 1,
        balance: form.balance.value,
        approved: "N"
    };

     var options = {
         method: 'POST',
         headers:{ "Content-Type": "application/json"},
         body: JSON.stringify(account)
     };

     try{
         let response = await fetch("http://localhost:8080/bank-app-rest/accounts", options);
         clearFormData();
         success.style.display = "block";
         success.innerText = "Account added successfully. You can view your account/accounts.";
     } catch(err){
         error.style.display = "block";
         error.innerText = "Failed to add an account."
     }
}

function clearFormData(){
    form.account_number.value = "";
    form.balance.value = "";
}