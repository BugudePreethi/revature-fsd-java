const urlParams = new URLSearchParams(window.location.search);
const account_id = urlParams.get('id');
let addButton = document.getElementById("add");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

addButton.addEventListener("click", function(){
    deposit();
});

async function deposit(){
    let transaction = {
        amount: form.amount.value,
        type: 'D'
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
        success.innerText = "Amount deposited in account";
    } catch(err){
        error.style.display = "block";
        error.innerText = "Sorry, amount is not added to your account";
    }
}
function clearFormData(){
    form.account_number.value = "";
    form.amount.value = "";
}