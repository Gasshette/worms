{
    "use strict";
    class ScoreController {
        constructor($http, authProvider, scoreTemplateProvider) {
            this._authProvider = authProvider;
            this._scoreTemplateProvider = scoreTemplateProvider;
            this._http = $http;
            this.listUsers = {};
            this.currentView = "Normal view";

            this.compactView = angular.element(document.querySelector(".compact"));
            this.normalView = angular.element(document.querySelector(".normal"));

            this.compactView.css("display", "none");

            this.getUsers();

        }

        switchView() {
            // this.currentView = (this.currentView == "Normal view") ? "Compact view" : "Normal view";
            console.log(this.currentView);
            // this._scoreTemplateProvider.getTemplate(this.currentView);

            if(this.currentView == "Normal view"){
                this.currentView = "Compact view";
                this.compactView.css("display", "block");
                this.normalView.css("display", "none");
            }
            else if(this.currentView == "Compact view"){
                this.currentView = "Normal view";
                this.normalView.css("display", "block");
                this.compactView.css("display", "none");
            }
            else{
                console.log("fail to load view. please check the value of ScCtrl.currentView variable");
            }
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
        .directive("progressBarScore", function (authProvider, scoreTemplateProvider) {
            return {
                link: function (scope, element, attrs) {
                    let progbar = angular.element(document.querySelector(".progress"));
                    progbar.find("div").css("width", attrs.percent / 10 + "%");
                    progbar.removeClass("progress");

                    //Shortly, it notify the view with the new value of percent (we could bypass this by scope:{percent="@"} as parameter of the "return" object of the directive)
                    attrs.$observe('percent', function (percent) {
                        scope.percent = percent / 10 + "%";
                    });
                },
                templateUrl: "app/components/globalview/progressbar.html"
            };
        });
}