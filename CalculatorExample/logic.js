"use strict";

document.getElementById("calculate").onclick = decision;

let result = document.getElementById("result");

function decision() {
    let selectElement = document.querySelector('#selection');
    let output = selectElement.value;
    switch (output) {
        case '+':
            plus();
            break;
        case '-':
            minus();
            break;
        case '*':
            multiply();
            break;
        case '/':
            divide();
            break;
        default:
            console.log("no action");
    }
}

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