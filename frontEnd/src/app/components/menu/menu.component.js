{
    "use strict";
    class MenuController {

        constructor() {
            this.style = {
                borderBottom: '#fff'
            };
        }

        changeColor() {
            this.style.borderBottom = "2px solid"  + '#' + Math.floor(Math.random() * 16777215).toString(16);
        }

        resetColor(){
            this.style.borderBottom = "2px solid #fff";
        }
    }

    angular
        .module("app")
        .component(
        "menuComponent",
        {
            controller: MenuController,
            controllerAs: "mc",
            templateUrl: "app/components/menu/menu.component.html"
        });
}