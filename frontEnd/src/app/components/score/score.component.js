{
    "use strict";
    class ScoreController {
        constructor($http, authProvider) {
            this._authProvider = authProvider;
            this._http = $http;
            this.listUsers = {};

            this.getUsers();
        }


        getUsers() {
            this.listUsers = this._authProvider.allUsers;
        }
    }

    angular
        .module("app")
        .component(
        "scoreComponent",
        {
            controller: ScoreController,
            controllerAs: 'ScCtrl',
            templateUrl: "app/components/score/score.component.html"
        })
        .directive("progressBarScore", function (authProvider) {
            return {
                link: function (scope, element, attrs) {
                    let progbar = angular.element(document.querySelector(".progress"));
                    progbar.find("div").css("width", attrs.percent/10 + "%");
                    progbar.removeClass("progress");

                    //Shortly, it notify the view with the new value of percent (we could bypass this by scope:{percent="@"} as a property of the directive)
                    attrs.$observe('percent', function (percent) {
                        scope.percent = percent / 10 + "%";
                    });
                },
                templateUrl: "app/components/globalview/progressbar.html"
            };
        });
}