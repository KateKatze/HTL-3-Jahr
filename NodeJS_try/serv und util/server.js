const http = require ("http");
const utilities = require ("./utilities.js");

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write("The date and time are currently: " + utilities.myDateTime());
    res.end();
}).listen(8080);