{
    "use strict";
    class SignInController {
        constructor($http, $compile) {
            this._http = $http;
            this.login = '';
            this.password = '';
            this.auth = {};
            this.formInscription;
        }

        authentication(){
            let that = this;
            this.auth = this._http.get("resources/users.json")
            .then(function(response){
                if(response){
                    that.auth = response.data;
                    that.auth.forEach(function(el) {
                        if(el.login == that.login && el.password == that.password){
                            console.log(el);
                        }
                    }, this);
                }
                that.login = "";
                that.password = "";
                that.formInscription.$setPristine();
            }),
            function(){
                console.log("Error");
            };



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