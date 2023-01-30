var n = 5;
while (n > 5) {
    console.log("Entered while");
}
do {
    console.log("Entered do while");
} while (n > 5);
/********** es break
var i:number = 1
while(i<=10) {
    if (i % 5 == 0) {
        console.log ("The first multiple of 5 betwwen 1 and 10 is : "+i)
        break // exit the loop
    }
    i++
}
*/
var num = 0;
var count = 0;
for (num = 0; num <= 20; num++) {
    if (num % 2 == 0) {
        continue;
    }
    count++;
}
console.log(" The count of odd values betwwen 0 and 20 is: " + count);
