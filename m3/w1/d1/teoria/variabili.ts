// sintassi per dichiarare una variabile
// let nome:string = "Mary"    // la variabile memorizza un tipo di dato stringa
// let nome:string             // la variabile è una stringa il valore è undefined
// let nome= "Mary"            // il tipo di dato è dedotto dal valore -> la variabile è di tipo stringa
// let nome                    // il tipo di dato è any e il valore è undefined                        
let nome:string = "John";
let score1:number = 50;
let score2:number = 42.50;
let sum = score1 + score2;
console.log("name "+nome);
console.log("first score: "+score1);
console.log("second score: "+score2);
console.log("sum of the scores: "+sum);

// Type Assertion
let code:any = 123;
let employeeCode = <number> code;
console.log(typeof(employeeCode));

// Inferred typing
var num = 2;    // data type inferred as number
console.log("value of num "+num);
//num = "12"; // dà errore perché ormai num è num:number (tipo di dato number)

// ambiti delle variabili
var global_num = 12          //global variable 
class Numbers { 
   num_val = 13;             //class variable 
   static sval = 10;         //static field 
   
   storeNum():void { 
      var local_num = 14;    //local variable 
   } 
} 
console.log("Global num: "+global_num)
console.log(Numbers.sval)
var obje = new Numbers(); 
console.log("Global num: "+obje.num_val)
// console.log("Local num "+local_num) // non lo stampa (si tenta di avvedere alla variabile locale da fuori dal metodo)
