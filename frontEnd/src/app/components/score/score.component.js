{
    "use strict";
    class ScoreController {
        constructor($http) {
            this._http = $http;
            this.listUsers = {};

            this.getUsers();
        }


        getUsers() {
            let that = this;
            this.listUsers = this._http.get("resources/users.json")
                .then(function (res) {
                    if (res) {
                        that.listUsers = res.data;
                    }
                },
                function () {
                    console.log("Error");
                });
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
        });
}