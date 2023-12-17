"use strict";

function calculateAge() {
  const day = parseInt(document.getElementById("day").value);
  const month = parseInt(document.getElementById("month").value);
  const year = parseInt(document.getElementById("year").value);

  const today = new Date();
  const currentYear = today.getFullYear();
  const currentMonth = today.getMonth() + 1; 
  const currentDay = today.getDate();

  let errorMessages = null;

  // Validation...
  if (isNaN(day) || isNaN(month) || isNaN(year)) {
    document.querySelectorAll('.invalid-d-error, .invalid-m-error, .invalid-y-error').forEach(element => {
      element.innerHTML = '<p>Please fill in all fields.</p>';
      element.classList.remove('hide');
      errorMessages = 1;
    });
  } else {
    const errorDivs = document.querySelectorAll('.invalid-d-error, .invalid-m-error, .invalid-y-error, .past-date-error');
    for (let i = 0; i < errorDivs.length; i++) {
        errorDivs[i].innerHTML = '';
        errorDivs[i].classList.add('hide');
    }
  
    if (day < 1 || day > 31) {
      document.querySelector('.invalid-d-error').innerHTML = '<p>Day must be between 1 and 31.</p>';
      document.querySelector('.invalid-d-error').classList.remove('hide');
      errorMessages = 1;
    }
  
    if (month < 1 || month > 12) {
      document.querySelector('.invalid-m-error').innerHTML = '<p>Month must be between 1 and 12.</p>';
      document.querySelector('.invalid-m-error').classList.remove('hide');
      errorMessages = 1;
    }
  
    if (year < 1000 || year > currentYear) {
      document.querySelector('.invalid-y-error').innerHTML = '<p>Year must be between 1000 and the current year.</p>';
      document.querySelector('.invalid-y-error').classList.remove('hide');
      errorMessages = 1;
    }
  
    // Validate if birthdate is in the past
    const birthDate = new Date(year, month - 1, day);
    if (birthDate >= today) {
      document.querySelector('.past-date-error').innerHTML = '<p>Birthdate must be in the past.</p>';
      document.querySelector('.past-date-error').classList.remove('hide');
      errorMessages = 1;
    }
  }

  // Calculate age only if there are no errors
  if (errorMessages === null) {
    const age = calculateAgeFromDate(year, month, day, today);
    
    const yearOutput = document.getElementById("year-output");
    const monthsOutput = document.getElementById("months-output");
    const daysOutput = document.getElementById("days-output");

    yearOutput.innerHTML = age.years;
    monthsOutput.innerHTML = age.months;
    daysOutput.innerHTML = age.days;
  }
}

function calculateAgeFromDate(year, month, day, today) {
  let age = today.getFullYear() - year;
  let months = today.getMonth() + 1 - month;
  let days = today.getDate() - day;

  if (months < 0 || (months === 0 && today.getDate() < day)) {
    age--;
    months += 12;
  }

  if (days < 0) {
    const tempDate = new Date(today.getFullYear(), today.getMonth(), 0);
    days += tempDate.getDate();
    months--;
  }

  return {
    years: age,
    months: months,
    days: days
  };
}