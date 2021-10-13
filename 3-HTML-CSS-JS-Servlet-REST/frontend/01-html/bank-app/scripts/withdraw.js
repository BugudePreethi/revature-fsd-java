let addButton = document.getElementById("add");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

addButton.addEventListener("click", function(){
    withdraw();
});

async function withdraw(){
    let transaction = {
        accountNumber: form.account_number.value,
        amount: form.amount.value
    };

    var options = {
        method: 'POST',
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(transaction)
    };

    try{
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/deposit", options);
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        success.style.display = "block";
        success.innerText = "Amount withdrawed from account";
    } catch(err){
        error.style.display = "block";
        error.innerText = "Sorry, amount is not added to your account";
    }
}
function clearFormData(){
    form.account_number.value = "";
    form.amount.value = "";
}