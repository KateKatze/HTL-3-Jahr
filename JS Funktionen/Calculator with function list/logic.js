"use strict";

let functionList = [(a,b)=>a+b,(a,b)=>a-b,(a,b)=>a*b,(a,b)=>a/b]

let operatorList = ["+", "-", "*", "/"];

document.getElementById("calculate").addEventListener("click", find);

function find(){
    let a = parseFloat(document.querySelector('#op1').value);
    let b = parseFloat(document.querySelector('#op2').value);
    let input = document.querySelector('#selection').value;
    let findIndexOfTheOperator = operatorList.findIndex(item => item === input);
    if (findIndexOfTheOperator !== -1){
        let params = functionList[findIndexOfTheOperator];
        let result = params(a,b);
        console.log(result);
        document.querySelector('#result').innerHTML = result;
    } else {
        document.querySelector('#result').innerHTML = "Error"
    } 
}
document.getElementById("calculate").addEventListener("click", find);