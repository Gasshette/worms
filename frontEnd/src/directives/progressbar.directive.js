{
    class ProgressBar {
        constructor(authProvider) {
            return {
                scope: {
                    percent: "="
                },
                restrict: 'E',
                link: function (scope) {
                    if (authProvider.authedUser !== null) {
                        let progbar = angular.element(document.querySelector("#progressbar > div"));
                        scope.percent = authProvider.authedUser.exp / 10 + "%";
                        angular.element(progbar).css("width", scope.percent);
                    }
                },
                templateUrl: "app/components/globalview/progressbar.html"
            };
        }
    }


}