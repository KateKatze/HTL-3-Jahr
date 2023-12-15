"use strict";

document.getElementById("plus").onclick = plus;
document.getElementById("minus").onclick = minus;
document.getElementById("multiply").onclick = multiply;
document.getElementById("divide").onclick = divide;

let result = document.getElementById("result");


function plus(){
    let op1 = document.getElementById("op1").value;
    let op2 = document.getElementById("op2").value;
    let value = parseInt(op1) + parseInt(op2);
    result.innerHTML = value;
}

function minus(){
    let op1 = document.getElementById("op1").value;
    let op2 = document.getElementById("op2").value;
    let value = parseInt(op1) - parseInt(op2);
    result.innerHTML = value;
}

function multiply(){
    let op1 = document.getElementById("op1").value;
    let op2 = document.getElementById("op2").value;
    let value = parseInt(op1) * parseInt(op2);
    result.innerHTML = value;
}

function divide(){
    let op1 = document.getElementById("op1").value;
    let op2 = document.getElementById("op2").value;
    let value = parseInt(op1) / parseInt(op2);
    result.innerHTML = value;
}