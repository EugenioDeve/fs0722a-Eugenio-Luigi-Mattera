abstract class CalcoloReddito {

    professione: string;
    codredd: number;
    redditoAnnuoLordo: number;
    tasseInps: number;
    tasseIrpef: number;
    
    constructor(_professione: string, _codredd: number, _redditoAnnuoLordo: number, _tasseInps: number, _tasseIrpef: number) {
        this.professione = _professione;
        this.codredd = _codredd;
        this.redditoAnnuoLordo = _redditoAnnuoLordo;
        this.tasseInps = _tasseInps;
        this.tasseIrpef = _tasseIrpef;
    }

    getUtileTasse() {
        return (this.redditoAnnuoLordo * this.codredd / 100);
    }

    getTasseInps() {
        return (this.getUtileTasse() * this.tasseInps / 100);
    }

    getTasseIrpef() {
        return (this.getUtileTasse() * this.tasseIrpef / 100);
    }

    getRedditoAnnuoNetto() {
        return (this.redditoAnnuoLordo - (this.getTasseInps() + this.getTasseIrpef()));
    }

    stampeCalcoli() {
        console.log("---------------------------------");
        console.log("Professione: " + this.professione);
        console.log("Utile tasse: " + this.getUtileTasse());
        console.log("Tasse Inps: " + this.getTasseInps());
        console.log("tasse Irpef: " + this.getTasseIrpef());
        console.log("Reddito annuo netto: " + this.getRedditoAnnuoNetto());
        console.log("---------------------------------");
    }
}

class Sanitario extends CalcoloReddito {
    constructor(_professione: string, _codredd: number, _redditoAnnuoLordo: number) {
        super(_professione, _codredd, _redditoAnnuoLordo, 12, 20)
    }
}

var fisioterapista = new Sanitario("fisioterapista", 72, 30000);
fisioterapista.stampeCalcoli();

class Ristorazione extends CalcoloReddito {
    constructor(_professione: string, _codredd: number, _redditoAnnuoLordo: number) {
        super(_professione, _codredd, _redditoAnnuoLordo, 15, 21)
    }
}

var pizzaiolo = new Ristorazione("pizzaiolo", 75, 28000);
pizzaiolo.stampeCalcoli();

class Commerciante extends CalcoloReddito {
    constructor(_professione: string, _codredd: number, _redditoAnnuoLordo: number) {
        super(_professione, _codredd, _redditoAnnuoLordo, 13, 18)
    }
}

var negoziante = new Commerciante("negoziante", 70,25000);
negoziante.stampeCalcoli();