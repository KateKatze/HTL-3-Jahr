"use strict";

let operatorList = ["+", "-", "*", "/"];

function find(){
    let a = parseFloat(document.querySelector('#op1').value);
    let b = parseFloat(document.querySelector('#op2').value);
    let op = document.querySelector('#selection').value;
    calcRemote(a, b, op, (res) => {console.log("Result of a query is", res); document.querySelector('#result').innerHTML = "look in the console";});
}

function calcRemote(op1, op2, op, callback) {
    let xhr = new XMLHttpRequest();
    let url = new URL("https://faas-fra1-afec6ce7.doserverless.co/api/v1/web/fn-a2df8e50-3266-47e2-819b-8c46de65fb73/wmcdemos/Calculator");
    url.searchParams.set("operand1", op1);
    url.searchParams.set("operand2", op2);
    url.searchParams.set("operator", op);
    xhr.onload = () => callback(xhr.response);
    xhr.open('GET', url);
    xhr.send();
}