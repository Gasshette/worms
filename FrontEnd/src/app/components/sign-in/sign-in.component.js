{
    "use strict";
    class SignInController {
        constructor($http, authProvider, $location) {
            this._http = $http;
            this._authProvider = authProvider;
            this._location = $location;
            this.authedUser = this._authProvider.authedUser;
            this.login = null;
            this.password = null;
            this.gold = 0;
            this.gem = 0;
            this.level = 1;
            this.exp = 0;

        }

        signIn() {
            let flag = false;
            this._authProvider.allUsers.forEach(function (element) {
                if (element.nickname == this.login) {
                    flag = true;
                }
            }, this);

            if (!flag) {
                let user = {
                    id: this._authProvider.allUsers.length,
                    nickname: this.login,
                    password: this.password,
                    gold: this.gold,
                    gem: this.gem,
                    level: this.level,
                    exp: this.exp
                };
                let validation = this._authProvider.registerUser(user);
                if(validation){
                    this._location.url("/");
                }
        }

            this.login = '';
            this.password = '';
        }
    }

    angular
        .module("app")
        .component(
        "signInComponent",
        {
            controller: SignInController,
            controllerAs: 'SICtrl',
            templateUrl: "app/components/sign-in/sign-in.component.html"
        });
}