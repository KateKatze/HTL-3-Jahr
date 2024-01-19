"use strict";

function start() {
    let userList = new ObjectList();

    // Start
    outputOfList("Start: ", userList);

    // Add 3 people
    userList.add("John", 1);
    userList.add("Jill", 2);
    userList.add("Mary", 3);

    outputOfList("After add(): ", userList);

    // Reverse order
    userList.reverse();
    outputOfList("After reverse(): ", userList);

    // Delete 1
    userList.deleteAtIndex(1);
    outputOfList("1 deleteAtIndex: ", userList);

    // Delete 1 extra
    userList.deleteAtIndex(0);
    outputOfList("2 deleteAtIndex: ", userList);
}

function outputOfList(message, userList) {
    const result = document.getElementById("output");
    const listItem = document.createElement("li");
    listItem.textContent = message + " " + userList.toString();
    result.appendChild(listItem);
}