{
    "use strict";
    class DownloadController {
        constructor() {
        }
    }

    angular
        .module("app")
        .component(
        "downloadComponent",
        {
            controller: DownloadController,
            controllerAs: 'DlCtrl',
            templateUrl: 'app/components/download/download.component.html'
        });
}