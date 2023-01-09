class SonAccount {
    balanceInit: number;
    constructor (_balanceInit:number = 0) {
        this.balanceInit = _balanceInit;
    }
    oneDeposit() {
        let partial: number = this.balanceInit + 1000;
        this.oneWithDraw(partial);
    }
    oneWithDraw(oldPartial:number) {
        let partial: number = oldPartial - 250;
        this.twoDeposit(partial);
    }
    twoDeposit(oldPartial:number) {
        let partial: number = oldPartial +500;
        this.twoWithDraw(partial);
    }
    twoWithDraw(oldPartial:number) {
        let partial: number = oldPartial - 300;
        console.log(partial);
    }
}

class MotherAccount extends SonAccount {
    addInterest: number;
    constructor (_balanceInit: number = 0, _addInterest:number = 1.1) {
        super(_balanceInit);
        this.addInterest = _addInterest;
    }
    oneDeposit() {
        let partial: number = this.balanceInit + 2000;
        this.oneWithDraw(partial);
    }
    oneWithDraw(oldPartial:number) {
        let partial: number = oldPartial - 55;
        this.twoDeposit(partial);
    }
    twoDeposit(oldPartial:number) {
        let partial: number = oldPartial +120;
        this.twoWithDraw(partial);
    }
    twoWithDraw(oldPartial:number) {
        let partial: number = oldPartial - 65;
        console.log(partial*this.addInterest)
    }
}

var son = new SonAccount();
son.oneDeposit();
var mom = new MotherAccount();
mom.oneDeposit();