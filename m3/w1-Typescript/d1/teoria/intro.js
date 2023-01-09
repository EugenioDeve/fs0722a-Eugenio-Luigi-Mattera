/*
var num:number = 12345
console.log(num)
var message:string = "Hello World"
console.log(message)
*/
var Greeting = /** @class */ (function () {
    function Greeting() {
    }
    Greeting.prototype.greet = function () {
        console.log("Hello World!!!");
    };
    return Greeting;
}());
var obj = new Greeting();
obj.greet();
