
let Student = require('./Student');

function StudentDAO(dbo) {
    this.dbo = dbo;
    this.list = [];

    this.init = function() {
        this.list.push(new Student("Tina", "Master", "tina@master.at", 1));
        this.list.push(new Student("Jo", "Master", "jo@master.at", 2));
    }

    this.getAllStudents = ()  => {
        return new Promise((resolve, reject)=>{
            resolve(this.list);
        });
    }

    this.add = (student) => {
        return new Promise((resolve, reject)=>{
                this.list.push(student);
                if (student.id == undefined) {
                    student.id = this.getMaxId() + 1;
                }
                resolve(student.id);
        });
    }

    this.getMaxId = function() {
        let max = 0;
        for (let i = 0; i < this.list.length; i++) {
            let student = this.list[i];
            if (student.id > max) {
                max = student.id;
            }
        }  
        return max;
    }

    this.delete = (studentId) => {
        return new Promise((resolve, reject)=>{
            for (let i = 0; i < this.list.length; i++) {
                let student = this.list[i];
                if (student.id == studentId) {
                    console.log("Delete student with id " + student.id);
                    this.list.splice(i,1);
                }
            }    
             
            resolve(studentId);
        });
    }

    this.update = (student) => {
        return new Promise((resolve, reject)=>{
            for (let i = 0; i < this.list.length; i++) {
                let s = this.list[i];
                // console.log(s.id + " == " + student.id);
                if (s.id == student.id) {
                    console.log("update student with id " + s.id);
                    this.list[i] = student;
                }
            }    
            resolve(student);
        });
    }
}

module.exports = StudentDAO;