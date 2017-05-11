{
    "use strict";
    class ErrorController {
        constructor($stateParams) {

            switch ($stateParams.id) {
                case 304:
                    this.id = $stateParams.id;
                    break;
                case 504:
                    this.id = $stateParams.id;
                    break;
                default:
                    this.id = 404;
                    break;
            }
        }
    }

    angular
        .module("app")
        .component(
        "errorComponent",
        {
            controller: ErrorController,
            controllerAs: 'err',
            templateUrl: 'app/components/error/error.component.html'
        });
}