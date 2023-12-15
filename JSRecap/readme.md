<h3>Maturafragen</h3>

<table>
<thead>
    <tr>
        <th>Java</th>
        <th>JavaScript</th>
    </tr>
</thead>
<tbody>
    <tr>
        <td>Compiliert</td>
        <td>Interpretiert</td>
    </tr>
     <tr>
        <td>Statische Typisierung</td>
        <td>Dynamische Typisierung</td>
    </tr>
     <tr>
        <td>RTE: Virtual Maschine (JVM)</td>
        <td>RunTimeEnvironment: Browser, NodeJs als Runtime fürs Backend</td>
    </tr>
</tbody>
</table>

<h3>Recap: </h3>

<p>Write down at the beginning of the page "use strict"- strict check of the JS Syntax</p>

<p> "defer" in script tag schreiben - damit JS auf Elemente dieser Seite zugreift erst dann, wenn die ganze Seite geloaded wird</p>

<p> .js files connect via script tag </p>

<p> live server to open the files </p>

<p> variablen ohne typ </p>
<p> let value; console.log(typeof value); >> undefined</p>

<p>+ -> String hat ein Vorrang "5" + 4 = 54</p>

<h3>Funktionen: </h3>

<p>
function sum(a, b){
 let retVal = a+b;
  return retVal;
}

value = sum(2,3);

console.log(value);</p>

<h3>DOM - dynamic object model</h3>

<p> div id="header" myattr="x!">Hallo! /div </p>

<p>let elem;
elem=document.getElementById("header");
alert(elem.getAttribute("myAttr"));</p>

<p>Suche bei id (nicht Standartattribute): alert(header.getAttribute("myAttr"));</p>

<p>Was im Element mit diesem id steht: alert(elem.innerHTML);</p>

<p>Gesamten Element, auf Standartattribute zugreifen: alert(elem.outerHTML);</p>

<p>onclick="myFunction()" oder direkt in JS</p>

<p>name ist der Name des Parameters beim Formaufruf</p>

<p> String in Number umleiten: Number("5") </p>

<h3>Array: </h3>

<p>let fruits = ["Apple", "Banana", "Pear]; fruits[8] = "Orange"; in between another indexes will be undefined</p>

<p>Prefix ++a Postfix a++ </p>

<p>let a=1;
alert(a++);

let b=1;
alert(++b);

let c=1;
++c;
alert(c);</p>

<h3>Vergleich: </h3>

<p> === wert&typ müssen gleich sein </p>

<h3>Ifs: </h3>

<p>Jede String außer Leersting wird als true interpretiert: 
if("false"){
  alert(true);
} else {
  alert(false);
} </p>

<p>0, undefined, null, NaN, "" - false</p>

<h3>Ternary Operator</h3>

<p>x = (condition) ? (true condition) : (false condition); </p>




