let error = document.getElementById("error");
error.style.display = "none";

async function getaccounts() {
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts");
        let accounts = await response.json();
        let html = "";
        for (let account of accounts) {
            html +=
                `<div class="card border-dark col-md-3 mb-3">
                <div class="card-body">
                <h5>${account.accountNumber}</h5>
                <div class="badge badge-success">${account.balance}</div>
                </div>
                <div class="card-footer">
                <a href="withdraw.html" class="btn btn-primary btn-sm">Withdraw</a>
                <a href="deposit.html" class="btn btn-primary btn-sm">Deposit</a>
                <a href="transactions.html" class="btn btn-primary btn-sm">Transactions</a>
                </div>
                </div>`;
        }
        document.getElementById("accountDetails").innerHTML = html;
    } catch (err) {
        error.style.display = "block";
    }
};
getaccounts();
