
let titoloCard = document.querySelectorAll(".card-title");
let mail = document.querySelectorAll(".card-link");         //aggancio le variabili nel DOM
let img = document.querySelectorAll(".image");

fetch('./json/users.json')            //con fetch mi collego al file JSON locale
  .then(response => response.json())
  .then(data => {
    const arrayPersone = data;
    for (let i = 0; i < arrayPersone.length; i++) {
      img[i].src = arrayPersone[i].profileURL;
      titoloCard[i].textContent = arrayPersone[i].firstName + " " + arrayPersone[i].lastName;
      mail[i].textContent = arrayPersone[i].email;
    }
  });