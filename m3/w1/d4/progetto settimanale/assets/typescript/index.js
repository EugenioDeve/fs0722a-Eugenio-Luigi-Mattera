var Abbigliamento = /** @class */ (function () {
    function Abbigliamento(_id, _codprod, _collezione, _capo, _modello, _quantita, _colore, _prezzoivaesclusa, _prezzoivainclusa, _disponibile, _saldo) {
        this.id = _id;
        this.codprod = _codprod;
        this.collezione = _collezione;
        this.capo = _capo;
        this.modello = _modello;
        this.quantita = _quantita;
        this.colore = _colore;
        this.prezzoivaesclusa = _prezzoivaesclusa;
        this.prezzoivainclusa = _prezzoivainclusa;
        this.disponibile = _disponibile;
        this.saldo = _saldo;
    }
    Abbigliamento.prototype.getSaldoCapo = function () {
        return this.prezzoivainclusa * this.saldo / 100;
    };
    Abbigliamento.prototype.getAcquistoCapo = function () {
        console.log((this.prezzoivainclusa - this.getSaldoCapo()).toFixed(2));
    };
    return Abbigliamento;
}());
window.addEventListener("DOMContentLoaded", print);
function print() {
    fetch("https://mocki.io/v1/765b2daf-41d5-4e94-a0d5-abd918f57b8f")
        .then(function (res) {
            return res.json();
        })
        .then(function (res) {
            res.forEach(function (element) {
                var abito = new Abbigliamento(element.id, element.codprod, element.collezione, element.capo, element.modello, element.quantita, element.colore, element.prezzoivaesclusa, element.prezzoivainclusa, element.disponibile, element.saldo);
                console.log(abito);
                console.log(abito.getAcquistoCapo());
            });
        });
}
