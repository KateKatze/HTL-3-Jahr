const express = require('express');
const fs = require('fs');
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get('/calc/:num1/:operator/:num2', (req, res) => {
    const { num1, operator, num2 } = req.params;
    let result;

    switch (operator.toUpperCase()) {
        case 'ADD':
            result = parseFloat(num1) + parseFloat(num2);
            break;
        case 'MIN':
            result = parseFloat(num1) - parseFloat(num2);
            break;
        case 'MULT':
            result = parseFloat(num1) * parseFloat(num2);
            break;
        case 'DIV':
            result = parseFloat(num1) / parseFloat(num2);
            break;
        default:
            return res.status(400).send('Operator names: ADD +, DIV -, MULT *, DIV /');
    }

    const input = `${num1} ${operator} ${num2}`;
    fs.appendFile('calc_history.txt', input + '\n', (err) => {
        if (err) {
            console.error('Error:', err);
        }
    });

    res.send(`Result: ${result}`);
});

app.listen(5040, () => {
    console.log(`Server: http://localhost:5040`);
});
