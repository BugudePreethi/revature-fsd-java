document.getElementById("message").style.display = "none";
async function listEmployees() {
    try {
        let response = await fetch("http://localhost:8080/04-rest-learn/employees");
        let employees = await response.json();
        let html = "";
        for (let employee of employees) {
            html += 
                `<tr>
                    <td>${employee.name}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.department.name}</td>
                    <td><a href="emp-update.html?id=${employee.id}">Update</a></td>
                    <td><a href="emp-delete.html?id=${employee.id}">Delete</a></td>
                </tr>`;
        }
        document.getElementById("employeeData").innerHTML = html;
    } catch (err) {
        document.getElementById("message").style.display = "block";
    }
};
listEmployees();
