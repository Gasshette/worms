{
    "use strict";
    class connectedController {
        constructor() {
            }
    }

    angular
        .module("app")
        .component(
        "connectedComponent",
        {
            controller: connectedController,
            controllerAs: "conOKCtrl",
            templateUrl: "app/components/connected/connected.component.html"
        });
}