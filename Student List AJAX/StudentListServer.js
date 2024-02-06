let express = require('express');
const app = express();

//Prerequisites: 
//npm install express
//npm install cors 

let StudentDAO = require('./StudentDAO');
let StudentController = require('./StudentController');
let StudentRoutes = require('./StudentRoutes');

//see https://stackoverflow.com/questions/37911838/how-to-use-mongodb-with-promises-in-node-js
//see https://blog.mlab.com/2017/05/mongodb-connection-pooling-for-express-applications/
function StudentListServer() {   
    this.start = function() {
        const studentDAO = new StudentDAO();
        studentDAO.init();
        const studentController = new StudentController(studentDAO);
        const studentRoutes = new StudentRoutes(app, studentController);
        studentRoutes.setRoutes();
        app.listen(5051, () => console.log('Listening on port 5051'));
    }
}
let studentListServer = new StudentListServer();
studentListServer.start();