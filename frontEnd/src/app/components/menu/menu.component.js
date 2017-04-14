{
    "use strict";
    class MenuController {
        constructor() {
        }
    }

    angular
        .module("app")
        .component(
        "menuComponent",
        {
            controller: MenuController,
            templateUrl: "app/components/menu/menu.component.html"
        });
}