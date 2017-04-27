{
    "use strict";
    class ConnectionRequiredController {
        constructor() {
        }
    }

    angular
        .module("app")
        .component(
        "connectionRequiredComponent",
        {
            controller: ConnectionRequiredController,
            controllerAs: 'ConRecCtrl',
            templateUrl: "app/components/connectionrequired/connectionrequired.component.html"
        });
}