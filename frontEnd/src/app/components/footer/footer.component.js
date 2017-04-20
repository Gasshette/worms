{
    "use strict";
    class FooterController {
        constructor() {
        }

    }

    angular.module("app")
        .component("footerComponent", {
            controller: FooterController,
            templateUrl: "app/components/footer/footer.component.html"
        });
}