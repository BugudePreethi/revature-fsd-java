let error = document.getElementById("error");
let customerData = document.getElementById("customerData")
error.style.display = "none";
async function listCustomers(){
    var options = {
        credentials: 'include'
    };
    try{
        console.log("Before connection");
        let response = await fetch("http://localhost:8080/bank-app-rest/employees/customers");
        console.log("After connection");
        let names = await response.json();
        let data = "";
        for (let name of names) {
            console.log("Inside for loop");
            data +=
            `<tr>
                <td>${name.firstName}</td>
                <td>${name.lastName}</td>
                <td>${name.email}</td>
                <td>${name.account.accountNumber}</td>
                <td>${name.account.balance}</td>
                <td>${name.account.approved}</td>
                <td><a href="customer-transactions.html?num=${name.account.accountNumber}" class="btn btn-primary btn-sm">View Transactions</a></td>
            </tr>`;
        }
        customerData.innerHTML = data;
    } catch(err){
        error.style.display = "block";
    }

};
listCustomers();
