let fs = require('fs');
let Student = require('./Student');

function StudentController(studentDAO) {
    
    this.studentDAO = studentDAO;
    
    this.getAllStudents = (request, response) => {
        this.studentDAO.getAllStudents().then(result=> response.send(result));
    }
    
    this.addStudent = (req, res) => {
        const studentId = req.body.id;
        const firstname = req.body.firstname;
        const lastname = req.body.lastname;
        const email = req.body.email;
        const student = new Student(firstname, lastname, email, studentId);
        this.studentDAO.add(student).then(studentId => {
            res.send(student);
        });
    }
    this.updateStudent = (req, res) => {
        const studentId = req.params.id;
        const firstname = req.body.firstname;
        const lastname = req.body.lastname;
        const email = req.body.email;
        const student = new Student(firstname, lastname, email, studentId);
        // console.log(student);
        this.studentDAO.update(student).then(student => {
            res.send(student);
        });
    }
    
    this.deleteStudent = (req, res) => {
        const studentId = req.body.id;
        this.studentDAO.delete(studentId).then(studentId => {
            res.send(`{"id":"${studentId}"}`);
        });
    }
    
    this.getFile = function(req, res) {
        let fileName = "../Client/" + req.params.name;
        
        fs.readFile(fileName, "utf8", function (err, data) {
            let chat;
            if (err) {
                console.log("File don't exist: " + fileName);
                res.status(404).send("File '" + req.params.name + "' not found!");
            } else {
                res.contentType(req.params.name);
                res.send(data);
                console.log("File sent: " + fileName);
            }
        });
        
    }
}

module.exports = StudentController;