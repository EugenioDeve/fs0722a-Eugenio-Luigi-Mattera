var estratto = Math.floor((Math.random() * 100) + 1);
var numEstratto = "il numero estratto \u00E8 ".concat(estratto);
var giocatore1 = Math.floor((Math.random() * 100) + 1);
var numGioc1 = "il numero del giocatore 1 \u00E8 ".concat(giocatore1);
var giocatore2 = Math.floor((Math.random() * 100) + 1);
var numGioc2 = "il numero del giocatore 2 \u00E8 ".concat(giocatore2);
console.log(numEstratto);
console.log(numGioc1);
console.log(numGioc2);
if (giocatore1 == estratto) {
    console.log('Il giocatore 1 ha indovinato!');
}
else if (giocatore2 == estratto) {
    console.log('Il giocatore 2 ha indovinato!');
}
else if ((Math.abs(estratto - giocatore1)) < (Math.abs(estratto - giocatore2))) {
    console.log('Nessuno ha indovinato, ma il giocatore 1 si è avvicinato di più');
}
else {
    console.log('Nessuno ha indovinato, ma il giocatore 2 si è avvicinato di più');
}
