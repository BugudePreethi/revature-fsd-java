let error = document.getElementById("error");
error.style.display = "none";

async function listEmployees() {
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts");
        let accounts = await response.json();
        let html = "";
        for (let account of accounts) {
            html += 
                `<h5>${account.accountNumber}</h5>
                <div>${customer.firstName}</div>
                <div class="badge badge-success">${account.balance}</div>`;
        }
        document.getElementById("accountDetails").innerHTML = html;
    } catch (err) {
        error.style.display = "block";
    }
};
listEmployees();
