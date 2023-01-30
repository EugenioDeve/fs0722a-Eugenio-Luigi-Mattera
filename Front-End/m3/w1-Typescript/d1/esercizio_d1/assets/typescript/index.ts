let estratto: number = Math.floor((Math.random() * 100) + 1);
let numEstratto: string = `il numero estratto è ${estratto}`
let giocatore1: number = Math.floor((Math.random() * 100) + 1);
let numGioc1: string = `il numero del giocatore 1 è ${giocatore1}`
let giocatore2: number = Math.floor((Math.random() * 100) + 1);
let numGioc2: string = `il numero del giocatore 2 è ${giocatore2}`

console.log(numEstratto)
console.log(numGioc1)
console.log(numGioc2)

if (giocatore1 == estratto) {
    console.log('Il giocatore 1 ha indovinato!');
} else if (giocatore2 == estratto) {
    console.log('Il giocatore 2 ha indovinato!');
} else if ((Math.abs(estratto - giocatore1)) < (Math.abs(estratto - giocatore2))) {
    console.log('Nessuno ha indovinato, ma il giocatore 1 si è avvicinato di più');
} else {
    console.log('Nessuno ha indovinato, ma il giocatore 2 si è avvicinato di più');
}