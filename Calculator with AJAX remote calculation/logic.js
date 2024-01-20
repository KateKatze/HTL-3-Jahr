"use strict";

function sendRequest(){
    const a = parseFloat(document.querySelector('#op1').value);
    const b = parseFloat(document.querySelector('#op2').value);
    const op = document.querySelector('#selection').value;

    const url = new URL("https://faas-fra1-afec6ce7.doserverless.co/api/v1/web/fn-a2df8e50-3266-47e2-819b-8c46de65fb73/wmcdemos/Calculator?operand1="+a+"&operand2="+b+"&operator="+op);

    const methodType = 'POST';
    
    makeAjaxCall(url, methodType, (res) => {document.querySelector('#result').innerHTML = `${res}`;});
}

function makeAjaxCall(url, methodType, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open(methodType, url, true);
    xhr.send();
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4){
            if (xhr.status === 200){
            console.log("xhr done successfully");
            var resp = xhr.responseText;
            var respJson = JSON.parse(resp);
            callback(respJson); 
            } else {
                document.querySelector('#result').innerHTML = `Error ${xhr.status}: ${xhr.statusText}`; 
            }
        };
    }
}