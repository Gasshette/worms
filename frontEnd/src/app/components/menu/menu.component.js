{
    "use strict";
    class MenuController {

        constructor() {
            this.style = {
                borderBottom: '#fff'
            };
        }

        changeColor(element) {
            if (element.target.tagName == 'A') {
                $(element.target).css("borderBottom", "2px solid " + '#' + Math.floor(Math.random() * 16777215).toString(16));
            }
        }

        resetColor(element) {
            $(element.target).css("borderBottom", "2px solid #fff");
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