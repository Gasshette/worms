{
    "use strict";
    class SignInController {
        constructor($http, authProvider) {
            // this._locationProvider = $locationProvider;
            this._authprovider = authProvider;
            this._http = $http;
            this.login = '';
            this.password = '';
            // this.formInscription = {};

            if(typeof this._authprovider.auth != "undefined"){
                console.log("déjà connecté", this._authprovider.auth);
            }
            else{
                console.log("Pas connecté", this._authprovider.auth);
            }
        }

        authenticate(){
            if(typeof this._authprovider.auth == "undefined"){
                this._authprovider.authentication();
                this.login = "";
                this.password = "";
                console.log("connecté", this._authprovider.auth);
            }
        }

        // authentication(){
        //     let that = this;
        //     this.auth = this._http.get("resources/users.json")
        //     .then(function(response){
        //         if(response){
        //             that.auth = response.data;
        //             that.auth.forEach(function(el) {
        //                 if(el.login == that.login && el.password == that.password){
        //                     console.log(el);
        //                 }
        //             }, this);
        //         }
        //         that.login = "";
        //         that.password = "";
        //         // that.formInscription.$setPristine();
        //     },
        //     function(){
        //         console.log("Error");
        //     });
        // }
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