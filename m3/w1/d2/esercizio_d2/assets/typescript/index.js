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
var SonAccount = /** @class */ (function () {
    function SonAccount(_balanceInit) {
        if (_balanceInit === void 0) { _balanceInit = 0; }
        this.balanceInit = _balanceInit;
    }
    SonAccount.prototype.oneDeposit = function () {
        var partial = this.balanceInit + 1000;
        this.oneWithDraw(partial);
    };
    SonAccount.prototype.oneWithDraw = function (oldPartial) {
        var partial = oldPartial - 250;
        this.twoDeposit(partial);
    };
    SonAccount.prototype.twoDeposit = function (oldPartial) {
        var partial = oldPartial + 500;
        this.twoWithDraw(partial);
    };
    SonAccount.prototype.twoWithDraw = function (oldPartial) {
        var partial = oldPartial - 300;
        console.log(partial);
    };
    return SonAccount;
}());
var MotherAccount = /** @class */ (function (_super) {
    __extends(MotherAccount, _super);
    function MotherAccount(_balanceInit, _addInterest) {
        if (_balanceInit === void 0) { _balanceInit = 0; }
        if (_addInterest === void 0) { _addInterest = 1.1; }
        var _this = _super.call(this, _balanceInit) || this;
        _this.addInterest = _addInterest;
        return _this;
    }
    MotherAccount.prototype.oneDeposit = function () {
        var partial = this.balanceInit + 2000;
        this.oneWithDraw(partial);
    };
    MotherAccount.prototype.oneWithDraw = function (oldPartial) {
        var partial = oldPartial - 55;
        this.twoDeposit(partial);
    };
    MotherAccount.prototype.twoDeposit = function (oldPartial) {
        var partial = oldPartial + 120;
        this.twoWithDraw(partial);
    };
    MotherAccount.prototype.twoWithDraw = function (oldPartial) {
        var partial = oldPartial - 65;
        console.log(partial * this.addInterest);
    };
    return MotherAccount;
}(SonAccount));
var son = new SonAccount();
son.oneDeposit();
var mom = new MotherAccount();
mom.oneDeposit();
