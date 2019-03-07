var  numbers = [5, 458 , 120 , -215 ]; 
var maxInNumbers = Math.max.apply(Math, numbers);   //458
    //maxInNumbers = Math.max.call(5, 458 , 120 , -215); //458

console.log(maxInNumbers);