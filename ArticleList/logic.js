"use strict";

function Article(id, name, price){
    this.id = id;
    this.name = name;
    this.price = price;
};

function ObjectList(){
    this.objects = [];
    this.add = (newObject) => {this.objects.push(newObject)};
    this.getByIndex = (index) => {return this.objects[index];};
    this.getById = (id) => {return this.objects.find(obj => obj.id === id);};
};

function ArticleManager(){
    this.articleList = new ObjectList();
    this.readProperty = (label) => {
        return prompt(label);
    };
    this.add = () => {
        let id = this.readProperty("Enter id: ");
        let name = this.readProperty("Enter name: ");
        let price = this.readProperty("Enter price: ");

        let newArticle = new Article(id, name, price);
        this.articleList.add(newArticle);
    };    
}

function ArticleControlManager(){
                this.articleManager = new ArticleManager;

                this.refresh = () => {
                    const outputList = document.querySelector("#output");

                    if (outputList) {
                        outputList.innerHTML = ''; // Clear the outputList
                
                        const articles = this.articleManager.articleList.objects;

                        for (let i = 0; i < articles.length; i++) {
                            const article = articles[i];
                            outputList.innerHTML += `<li>${article.id}, ${article.name}, ${article.price}</li>`;
                        }
                    } else {
                        console.error("Element not found");
                    }
                };

                this.main = function(){
                    //do {
                        this.articleManager.add();
                        this.refresh();
                    //} while (confirm("Another article?");
                        if(confirm("Another action?")){
                            setTimeout(()=>this.main());
                        }
                }
};
