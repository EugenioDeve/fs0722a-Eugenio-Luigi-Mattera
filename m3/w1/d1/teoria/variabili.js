// sintassi per dichiarare una variabile
// let nome:string = "Mary"    // la variabile memorizza un tipo di dato stringa
// let nome:string             // la variabile è una stringa il valore è undefined
// let nome= "Mary"            // il tipo di dato è dedotto dal valore -> la variabile è di tipo stringa
// let nome                    // il tipo di dato è any e il valore è undefined                        
var nome = "John";
var score1 = 50;
var score2 = 42.50;
var sum = score1 + score2;
console.log("name " + nome);
console.log("first score: " + score1);
console.log("second score: " + score2);
console.log("sum of the scores: " + sum);
// Type Assertion
var code = 123;
var employeeCode = code;
console.log(typeof (employeeCode));
// Inferred typing
var num = 2; // data type inferred as number
console.log("value of num " + num);
//num = "12"; // dà errore perché ormai num è num:number (tipo di dato number)
// ambiti delle variabili
var global_num = 12; //global variable 
var Numbers = /** @class */ (function () {
    function Numbers() {
        this.num_val = 13; //class variable 
    }
    Numbers.prototype.storeNum = function () {
        var local_num = 14; //local variable 
    };
    Numbers.sval = 10; //static field 
    return Numbers;
}());
console.log("Global num: " + global_num);
console.log(Numbers.sval);
var obj = new Numbers();
console.log("Global num: " + obj.num_val);
