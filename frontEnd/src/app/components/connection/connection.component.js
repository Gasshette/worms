{
    "use strict";
    class connectionController {
        constructor($http, authProvider) {
            this._authProvider = authProvider;
            this._http = $http;
            this.login;
            this.password;

            //Check of the connected user, to know if we have to show the child component or the sign in one
            if (typeof this._authProvider.authed == "object") {
                //déjà conencté
            }
            else {
                //Non connecté
            }
        }

        authenticate() {
            // let that = this;
            // if(typeof this._authProvider.auth == "undefined" &&(typeof this.login != "undefined" && typeof this.password != "undefined")){
            //     this._authProvider.authentication(this.login, this.password);
            //     console.log(that._authProvider.authedUser);

            let that = this;
            this._http.get("resources/users.json")
                .then(function (response) {
                    if (response) {
                        response.data.forEach(function (el) {
                            if (el.nickname == that.login && el.password == that.password) {
                                that._authProvider.authedUser = el;
                                console.log(that._authProvider.authedUser);
                            }
                        }, that);
                    }
                },
                function () {
                    console.log("Error");
                }
                );

            this.login = this.password = '';
        }
    }

    angular
        .module("app")
        .component(
        "connectionComponent",
        {
            controller: connectionController,
            templateUrl: "app/components/connection/connection.component.html"
        });
}