"use strict";

class ObjectList {
    constructor() {
        this.items = [];

        this.toString = function () {
            return "[" + this.items.join(", ") + "]";
        };

        this.add = function (item, index) {
            if (index !== undefined && index >= 0 && index <= this.items.length) {
                this.items.splice(index, 0, item);
            } else {
                this.items.push(item);
            }
        };

        this.deleteAtIndex = function (index) {
            if (index >= 0 && index < this.items.length) {
                this.items.splice(index, 1);
            }
        };

        this.reverse = function () {
            this.items.reverse();
        };
    }
}