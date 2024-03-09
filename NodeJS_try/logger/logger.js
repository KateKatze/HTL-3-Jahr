// Function to format the current date and time
function getCurrentDateTime() {
    const now = new Date();
    const date = now.toISOString().slice(0, 10); // Get date in YYYY-MM-DD format
    const time = now.toTimeString().slice(0, 8); // Get time in HH:MM:SS format
    const millis = now.getMilliseconds(); // Get milliseconds
    return `${date} ${time} - ${millis}`;
}

// Function to create a formatted logging message
function createLogMessage(message) {
    const moduleName = 'logger'; // You can change this to your module name
    const dateTime = getCurrentDateTime();
    return `${moduleName} (${dateTime}): ${message}`;
}

// Function to print the log message to the console
function log(message) {
    console.log(createLogMessage(message));
}

// Function to return the formatted log message
function format(message) {
    return createLogMessage(message);
}

// Exporting functions as module
module.exports = {
    log,
    format
};
