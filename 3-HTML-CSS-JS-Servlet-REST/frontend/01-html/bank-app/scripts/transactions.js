let error = document.getElementById("error");
let transactionData = document.getElementById("transactionData")
error.style.display = "none";
async function listTransactions(){
    try{
        console.log("Before connection");
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions");
        console.log("After connection");
        let transactions = await response.json();
        let data = "";
        for (let transaction of transactions) {
            console.log("Inside for loop");
            data +=
            `<tr>
                <td>${transaction.accountNumber}</td>
                <td>${transaction.amount}</td>
                <td>${transaction.type}</td>
                <td>${transaction.balance}</td>
            </tr>`;
        }
        transactionData.innerHTML = data;
    } catch(err){
        error.style.display = "block";
    }

};
listTransactions();
