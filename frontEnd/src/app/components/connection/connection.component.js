{
    "use strict";
    class connectionController {
        constructor() {
        }
    }

    angular
        .module("app")
        .component(
        "connectionComponent",
        {
            controller: connectionController,
            templateUrl: "app/components/connection/connection.component.html"
        });
}