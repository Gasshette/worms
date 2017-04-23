{
    "use strict";
    class ProfileController {
        constructor(authProvider) {
            this._authProvider = authProvider;
            this.authedUser;
            this.init();
        }

        init() {
            this.authedUser = this._authProvider.authedUser;
        }

        getTypeOf(element) {
            return typeof element;
        }
    }

    angular
        .module("app")
        .component(
        "profileComponent",
        {
            controller: ProfileController,
            controllerAs: 'PrCtrl',
            templateUrl: "app/components/profile/profile.component.html"
        })
        .directive("progressBar", function (authProvider) {
            return {
                scope: {
                    percent: "="
                },
                restrict : 'E',
                link: function (scope) {
                    if (typeof authProvider.authedUser !== "undefined") {
                        let progbar = angular.element(document.querySelector("#progressbar > div"));
                        scope.percent = authProvider.authedUser.exp / 10 + "%";
                        angular.element(progbar).css("width", scope.percent);
                    }
                },
                templateUrl: "app/components/globalview/progressbar.html"
            };
        });
}