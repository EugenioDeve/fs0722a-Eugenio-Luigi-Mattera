/*
var num:number = 12345
console.log(num)
var message:string = "Hello World"
console.log(message)
*/
class Greeting {
    greet():void {
        console.log("Hello World!!!")
    }
}
var obj = new Greeting();
obj.greet();
/*
1. definisco una classe Greeting
2. aggiungo un metodo greet()
3. il metodo stampa una stringa in console
4. la keyword new crea un oggetto della classe (obj)
5. l'oggetto invoca il metodo greet()
(se vi dice che Greeting è duplicata ci arriveremo non è un problema)
*/