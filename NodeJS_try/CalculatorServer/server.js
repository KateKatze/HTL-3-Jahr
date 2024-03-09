const http = require('http');
const url = require('url');

function calculate(num1, num2, operator) {
    switch (operator) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
        case '/':
            return num1 / num2;
        default:
            return 0;
    }
}

const server = http.createServer((req, res) => {
    res.writeHead(200, {
        'Content-Type': 'text/plain',
        'Access-Control-Allow-Origin': '*'
    });

    const queryObject = url.parse(req.url, true).query;
    const number1 = parseFloat(queryObject.number1);
    const number2 = parseFloat(queryObject.number2);
    const operator = queryObject.operator;
    const result = calculate(number1, number2, operator);

    res.end(result.toString());
});

server.listen(8080, () => {});
