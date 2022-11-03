/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/
function inserisciNumero0() {
  let numero1 = prompt("scegli primo numero");
  let numero2 = prompt("scegli il secondo numero");

  if (numero1 > numero2) {
    document.getElementById("risultato").innerHTML = "Il primo numero inserito è il più grande";
  } else if (numero2 > numero1) {
    document.getElementById("risultato").innerHTML = "Il secondo numero inserito è il più grande";
  } else {
    document.getElementById("risultato").innerHTML = "I numeri sono uguali";
  }
}

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/
function notequal() {
  let num1 = prompt("inserisci numero");
  let num2 = 5;
  if (num1 == num2) {
    console.log("Equal");
    document.getElementById("notequal").innerHTML = "Equal";
  } else {
    console.log("Not-equal");
    document.getElementById("notequal").innerHTML = "Not-Equal";
  }
}

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

function divisibile5() {
  let num1 = prompt("inserisci numero");
  if (num1 % 5 == 0) {
    document.getElementById("divisibile").innerHTML = "divisibile per 5";
  } else {
    document.getElementById("divisibile").innerHTML = "non divisibile per 5";
  }
}

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/
function numero8() {
  let numero1 = prompt("scegli primo numero");
  let numero2 = prompt("scegli il secondo numero");

  if (numero1 == 8 || numero2 == 8) {
    console.log("uno dei numeri inseriti è uguale a 8");
    document.getElementById("numeroOtto").innerHTML = "un dei numeri inseriti è 8";
  } else if (Number(numero1) + Number(numero2) == 8) {
    console.log("il risultato della somma da 8");
    document.getElementById("numeroOtto").innerHTML = "il risultato della somma da 8";
  } else if (Number(numero1) - Number(numero2) == 8 || Number(numero2) - Number(numero1) == 8) {
    console.log("il risultato della sottrazione da 8");
    document.getElementById("numeroOtto").innerHTML = "il risultato della sottrazione da 8";
  }
}

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/
function shopping() {
  let totalShoppingCart = prompt("inserisci saldo totale carrello");
  let spedizione = "Spedizione Gratuita";
  const costoSpedizione = 10;
  if (totalShoppingCart >= 50) {
    console.log("hai ottenuto la : " + spedizione);
    document.getElementById("e-commerce").innerHTML = "hai ottenuto la : " + spedizione;
  } else {
    console.log("il totale non arriva a 50€ quindi la spedizione sarà: " + costoSpedizione);
    document.getElementById("e-commerce").innerHTML = "il totale non arriva a 50€ quindi la spedizione sarà: " + costoSpedizione;
  }
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/
function sconto() {
  let totalShoppingCart = prompt("inserisci saldo totale carrello");
  let spedizione = "Spedizione Gratuita";
  let sconto20 = "sconto del 20% "
  let blackFriday = 20;
  const costoSpedizione = 10;
  if (totalShoppingCart >= 50) {
    console.log("hai ottenuto: " + sconto20 + spedizione);
    document.getElementById("e-commerce1").innerHTML = "hai ottenuto la : " + sconto20 + spedizione;

  } else {
    console.log("I costo totale dei tuoi prodotti non supera 50 quindi il costo della Spedizione è: " + costoSpedizione);
    document.getElementById("e-commerce1").innerHTML = "il totale non arriva a 50€ quindi la spedizione sarà: " + costoSpedizione;
  }
}

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/
let numeri = [10, 12, 52];
numeri.sort(function (a, b) {
  return a - b;
}).reverse;
console.log(numeri);

let a = 32
let b = 41
let c = 20
if (a >= b) {
  if (c >= a) {
    console.log(c, a, b);
  }
  else if (c >= a) {
    console.log(a, c, b);
  }
  else {
    console.log(a, b, c);
  }
}
else if (c >= a) {
  console.log(c, b, a);
}
else if (b >= a) {
  console.log(b, c, a);

}
else {
  console.log(b, a, c);
}


/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/
function esercizio8(valore) {
  if (typeof (valore) === 'number') {
    return (valore + ' è di tipo : ' + typeof (valore));
  } else {
    return ('il valore inserito non è di tipo number')
  }
}
console.log(esercizio8('ciao'))

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/
function esercizio9() {
  let numero = prompt("scegli numero");
  if (numero % 2 == 0) {
    document.getElementById("pariDispari").innerHTML = ('il numero: ' + numero + ' è pari');
  } else {
    document.getElementById("pariDispari").innerHTML = ('il numero: ' + numero + ' è dispari');

  }
}



/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  */
let val = 10
if (val < 10 && val > 5) {
  console.log("Meno di 10");
} else if (val < 5) {
  console.log("Meno di 5");
} else {
  console.log("Uguale a 10 o maggiore");
}


/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: "John",
  lastName: "Doe",
  skills: ["javascript", "html", "css"],
};

me.city = "Toronto";
console.log(me);

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/
delete me["lastName"];
console.log(me)

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

delete me.skills["2"];
console.log(me);

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/
let arrVuoto = [];
console.log(arrVuoto, 'ArrayVuota');

arrVuoto = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100];
console.log(arrVuoto)


/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

arrVuoto[10] = 1000;
console.log(arrVuoto);
