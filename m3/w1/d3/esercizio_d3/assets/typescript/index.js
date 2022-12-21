var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var CalcoloReddito = /** @class */ (function () {
    function CalcoloReddito(_professione, _codredd, _redditoAnnuoLordo, _tasseInps, _tasseIrpef) {
        this.professione = _professione;
        this.codredd = _codredd;
        this.redditoAnnuoLordo = _redditoAnnuoLordo;
        this.tasseInps = _tasseInps;
        this.tasseIrpef = _tasseIrpef;
    }
    CalcoloReddito.prototype.getUtileTasse = function () {
        return (this.redditoAnnuoLordo * this.codredd / 100);
    };
    CalcoloReddito.prototype.getTasseInps = function () {
        return (this.getUtileTasse() * this.tasseInps / 100);
    };
    CalcoloReddito.prototype.getTasseIrpef = function () {
        return (this.getUtileTasse() * this.tasseIrpef / 100);
    };
    CalcoloReddito.prototype.getRedditoAnnuoNetto = function () {
        return (this.redditoAnnuoLordo - (this.getTasseInps() + this.getTasseIrpef()));
    };
    CalcoloReddito.prototype.stampeCalcoli = function () {
        console.log("---------------------------------");
        console.log("Professione: " + this.professione);
        console.log("Utile tasse: " + this.getUtileTasse());
        console.log("Tasse Inps: " + this.getTasseInps());
        console.log("tasse Irpef: " + this.getTasseIrpef());
        console.log("Reddito annuo netto: " + this.getRedditoAnnuoNetto());
        console.log("---------------------------------");
    };
    return CalcoloReddito;
}());
var Sanitario = /** @class */ (function (_super) {
    __extends(Sanitario, _super);
    function Sanitario(_professione, _codredd, _redditoAnnuoLordo) {
        return _super.call(this, _professione, _codredd, _redditoAnnuoLordo, 12, 20) || this;
    }
    return Sanitario;
}(CalcoloReddito));
var fisioterapista = new Sanitario("fisioterapista", 72, 30000);
fisioterapista.stampeCalcoli();
var Ristorazione = /** @class */ (function (_super) {
    __extends(Ristorazione, _super);
    function Ristorazione(_professione, _codredd, _redditoAnnuoLordo) {
        return _super.call(this, _professione, _codredd, _redditoAnnuoLordo, 15, 21) || this;
    }
    return Ristorazione;
}(CalcoloReddito));
var pizzaiolo = new Ristorazione("pizzaiolo", 75, 28000);
pizzaiolo.stampeCalcoli();
var Commerciante = /** @class */ (function (_super) {
    __extends(Commerciante, _super);
    function Commerciante(_professione, _codredd, _redditoAnnuoLordo) {
        return _super.call(this, _professione, _codredd, _redditoAnnuoLordo, 13, 18) || this;
    }
    return Commerciante;
}(CalcoloReddito));
var negoziante = new Commerciante("negoziante", 70, 25000);
negoziante.stampeCalcoli();
