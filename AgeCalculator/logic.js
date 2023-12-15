"use strict";

document.getElementById("resultbtn").onclick = berechnen;

let resultYear = document.getElementById("year-output");
let resultMonth = document.getElementById("months-output");
let resultDay = document.getElementById("days-output");

function berechnen(){
    let day = document.getElementById("day").value;
    let month = document.getElementById("month").value;
    let year = document.getElementById("year").value;

    let currentDate = new Date();
    let currentYear = currentDate.getFullYear();
    let currentMonth = currentDate.getMonth() + 1;
    let currentDay = currentDate.getDate();

    let years = currentYear - year;
    let months = currentMonth - month;
    let days = currentDay - day;

    if (months < 0 || (months === 0 && currentDate.getDate() < birthDate.getDate())) {
        years--;
        months += 12;
    }

    if (days < 0) {
        months--;
        const tempDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), 0);
        days += tempDate.getDate();
    }

    resultYear.innerHTML = years;
    resultMonth.innerHTML = months;
    resultDay.innerHTML = days;
}