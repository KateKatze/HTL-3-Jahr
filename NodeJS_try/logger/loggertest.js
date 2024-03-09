// Importing the Logger module
let logger = require('./logger.js');

// Using the log function to print directly to console
logger.log('Info: The new logger works perfectly!');

// Using the format function to get the formatted message
console.log(logger.format('Info: The new logger works perfectly!'));

