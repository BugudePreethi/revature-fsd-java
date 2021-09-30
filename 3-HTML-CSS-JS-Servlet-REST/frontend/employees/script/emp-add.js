let submitBtn = document.getElementById("submit");
let success = document.getElementById("success");
let error = document.getElementById("error");
let form = document.forms[0];
success.style.display = "none";
error.style.display = "none";

(async function () {
    try {
        let response = await fetch("http://localhost:8080/04-rest-learn/departments");
        let departments = await response.json();
        let html = "<option>-- Select Department --</option>";
        for (let department of departments) {
            html += `<option value="${department.id}">${department.name}</option>`;
        }
        document.getElementById("department").innerHTML = html;
    } catch (err) {
        error.style.display = "block";
        error.innerText = "Get when getting department list. Retry or report to site administrator."
    }
})();

submitBtn.addEventListener("click", function () {
    addEmployee();
});

async function addEmployee() {
    let employee = {
        name: form.name.value,
        gender: form.gender.value,
        salary: form.salary.value,
        department: {
            id: form.department.value
        }
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json"},
        body: JSON.stringify(employee)
    };
    try {
        let response = await fetch("http://localhost:8080/04-rest-learn/employees", options);
        //let data = await response.json();
        console.log("after getting data");
        clearFormData();
        console.log("after clearing form");
        success.style.display = "block";
        success.innerText = "Employee added successfully.";
    } catch (err) {
        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."
    }
}

function clearFormData() {
    form.name.value = "";
    form.gender.value = "";
    form.salary.value = "";
}