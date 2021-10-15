const urlParams = new URLSearchParams(window.location.search);
const currentAccountNumber = urlParams.get('num');
let error = document.getElementById("error");
let customerTransactionData = document.getElementById("customerTransactionData")
error.style.display = "none";
async function listTransactions() {
    let transaction = {
        accountNumber: currentAccountNumber
    };
    console.log(currentAccountNumber);
    try {
        console.log("Before connection");
        let response = await fetch("http://localhost:8080/bank-app-rest/employees/transactions/" + currentAccountNumber);
        console.log("After connection");
        console.log("After connection" + currentAccountNumber);
        let cTransactions = await response.json();
        if (cTransactions != 0) {
            let data = "";
            for (let cTransaction of cTransactions) {
                data +=
                    `<tr>
                <td>${cTransaction.accountNumber}</td>
                <td>${cTransaction.amount}</td>
                <td>${cTransaction.type}</td>
                <td>${cTransaction.balance}</td>
            </tr>`;
            }
            customerTransactionData.innerHTML = data;
        } else {
            customerTransactionData.innerText="No transactions done yet";
        }

    } catch (err) {
        error.style.display = "block";
    }

};
listTransactions();
