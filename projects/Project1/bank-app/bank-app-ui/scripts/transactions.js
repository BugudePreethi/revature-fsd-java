const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');
let error = document.getElementById("error");
let transactionData = document.getElementById("transactionData")
error.style.display = "none";
async function listTransactions() {
    let transaction = {
        accountId: currentAccountId
    };
    console.log(currentAccountId);
    try {
        console.log("Before connection");
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/" + currentAccountId);
        console.log("After connection");
        let transactions = await response.json();
        if (transactions != 0) {
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
        } else {
            transactionData.innerText = "No transactions done yet";
        }
    } catch (err) {
        error.style.display = "block";
    }

};
listTransactions();
