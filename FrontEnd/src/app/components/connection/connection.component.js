{
    "use strict";
    class connectionController {
        constructor($http, authProvider, $location) {
            this._location = $location;
            this._authProvider = authProvider;
            this._http = $http;
            this.login = '';
            this.password = '';
            this.authedUser = this._authProvider.authedUser; 
        }

        authenticate() {
            this._authProvider.allUsers.forEach(function (element) {
                if (element.nickname == this.login && element.password == this.password) {
                    this._authProvider.authedUser = element;
                    this._location.url("/");
                }
            }, this);
            this.login = this.password = '';
        }
    }

    angular
        .module("app")
        .component(
        "connectionComponent",
        {
            controller: connectionController,
            controllerAs: "conCtrl",
            templateUrl: "app/components/connection/connection.component.html"
        });
}