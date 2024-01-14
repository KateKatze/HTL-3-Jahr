"use strict";

let DomUtils = {
    dom: document,
    setValues: function(id, value){
                const element = this.dom.getElementById(id);
                    if (element) {
                     element.value = value;
                    } 
                },
    getValues: function(id){
                const element = this.dom.getElementById(id);
                return element ? element.value : undefined;
                },
    elementExists: function(id){
                    if(this.dom.getElementById(id)){
                        return true;
                    }
                    },
    setFormValues: function(obj) {
                    for (let i in obj) {
                        if (obj.hasOwnProperty(i)) {
                            if (this.elementExists(i)) {
                              this.setValues(i, obj[i]);
                            }
                        }
                    }
                   },
    getFormValues: function(obj) {
                    for (let i in obj) {
                        if (obj.hasOwnProperty(i)) {
                            if (this.elementExists(i)) {
                                obj[i] = parseInt(this.getValues(i), 10) || 0;
                              //In case of NaN, the property will have a default value of 0.
                            }
                        }
                    }
                   },
};

console.log(DomUtils.elementExists("num1")); // true

DomUtils.setValues("num1", 5);
DomUtils.setValues("num2", 10);

let data = { num1: 0, num2: 0 }
DomUtils.getFormValues(data);
console.log(data); // { num1: 5, num2: 10 }

data.num1 = 12;
DomUtils.setFormValues(data);
console.log(DomUtils.getValues("num1")); // 12