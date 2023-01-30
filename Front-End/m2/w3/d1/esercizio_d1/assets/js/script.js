var outputArea = document.getElementById("outputArea");
var currentDate = new Date();
var btn = document.querySelector(".btn");

function User(_name, _surname, _birthday) {

    this.name = _name;
    this.surname = _surname;
    this.birthday = _birthday;
    let bd = new Date(this.birthday);
    this.fullName = `${this.name} ${this.surname}`;
    this.date = `${bd.getDate()} / ${(bd.getMonth() + 1)} / ${bd.getFullYear()}`;

    this.age = function () {
        let years = (currentDate.getFullYear() - bd.getFullYear());

        if (currentDate.getMonth() < bd.getMonth() ||
            (currentDate.getMonth() == bd.getMonth() &&
                currentDate.getDate() < bd.getDate())) {
            years--;
        }
        return years;
    }

}

btn.addEventListener("click", function () {

    let userName = document.getElementById("name").value;
    let userSurname = document.getElementById("surname").value;
    let userBirthday = document.getElementById("birthday").value;

    if (userName && userSurname && userBirthday) {

        calculateNPrint(userName, userSurname, userBirthday);

    } else {

        alert("Compila tutti i campi");

    }

})

function calculateNPrint(nome, cognome, data) {

    let newUser = new User(nome, cognome, data);

    let tr = document.createElement("tr");
    tr.innerHTML += `<td>${newUser.fullName}</td> <td>${newUser.date}</td> <td>${newUser.age()} anni</td>`;
    outputMonitor.appendChild(tr);

}