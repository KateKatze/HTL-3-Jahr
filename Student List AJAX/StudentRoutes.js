let express = require('express');
let bodyParser = require('body-parser');
const cors = require('cors')

function StudentRoutes(app,controller) {
    this.app = app;
    this.controller = controller;
    this.setRoutes = function() {
		//set CORS options for client which is started with Visual Studio Code LiveServer
		let corsOptions = {origin: '*', optionsSuccessStatus: 200}
		//with this pre-flight requests are already handled for all routes
		this.app.use(cors(corsOptions));
        app.use(bodyParser.json());
        this.app.use('*', (req, res, next) => {
            console.log("Request Logger: " + req.originalUrl + " " + req.method + " " );
            next();
        });
		
        this.app.route('/file/:name').get(this.controller.getFile);
        this.app.route('/students').get(this.controller.getAllStudents);
        this.app.route('/students').post(this.controller.addStudent);
        this.app.route('/students/:id').put(this.controller.updateStudent);
        this.app.route('/students').delete(this.controller.deleteStudent);
    }
    
}

module.exports = StudentRoutes;