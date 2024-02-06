# NodeJS Backend for StudentList Example

## Prerequisites

* Install [NodeJS](https://nodejs.org/en/download/)

## Setup

1. Extract the source if you downloaded it as ZIP file. 
2. Open a console window, enter the directory where you extracted the source and execute
    ```
    npm install
    ```

## Running the backend server

1. Open a console window, enter the directory where you extracted the source and execute
    ```
    npm start
    ```
2. The server is running at 
http://localhost:5051. You can access, e.g. the list of students at 
http://localhost:5051/students with your browser. 

## Testing the backend

To test the server and get to know the different requests:
1. Install the extension [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) in your Visual Studio Code. 
2. Open the file `studentlist.http` in VSC. 
3. Above each request, there is a line saying 'Send Request' – click this line to see the output of the request. 
4. Customize/add requests (separate them with ###) as you like. 

<!-- > ## **CORS Note**
> The backend needs to allow access from your frontend (client) explicitly (see chapter CORS). 
> If you frontend does not run at http://localhost:5500, you need to **change line 10 in `StudentRoutes.js`**, e.g. from 
> ```js
> let corsOptions = {origin: 'http://127.0.0.1:5500', optionsSuccessStatus: 200}
> ```
> to
> ```js
> let corsOptions = {origin: 'http://127.0.0.1:5501', optionsSuccessStatus: 200}
> ```
> or something similar. -->
