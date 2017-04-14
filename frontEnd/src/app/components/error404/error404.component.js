{
    "use strict";
    class Error404Controller {
        constructor() {
        }
    }

    angular
        .module("app")
        .component(
        "error404Component",
        {
            controller: Error404Controller,
            templateUrl: "app/components/error404/error404.component.html"
        });
}