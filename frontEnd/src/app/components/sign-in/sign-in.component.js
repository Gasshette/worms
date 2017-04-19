{
    "use strict";
    class SignInController {
        constructor($http) {
            this._http = $http;
            this.login = '';
            this.password = '';
            this.auth = {};
        }

        authentication(){
            let that = this;
            that.auth = {
               'login' : that.login || '',
                'password' : that.password || ''
            };
            
            let jsonAuth = angular.toJson(that.auth);
            
            that._http.post('/reception', jsonAuth)
            .then(function(response){
                console.log("success", response.data);
            })
            .then(function(){
                console.log("Error");
            });

            // console.log(jsonAuth);
            // console.log(angular.fromJson(this.auth));
        }
    }

    angular
        .module("app")
        .component(
        "signInComponent",
        {
            controller: SignInController,
            controllerAs : 'SICtrl',
            templateUrl: "app/components/sign-in/sign-in.component.html"
        });
}