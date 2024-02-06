"use strict";

function Student(firstname, lastname, email, id){
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.id = id;
}

Student.prototype.toString = function(){
    return this.firstname + " " + this.lastname + " (" + this.email + ")";
}

module.exports = Student;