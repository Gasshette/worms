{
    "use strict";
    class ReceptionController {
        constructor($http) {
            this._http = $http;
            // this.login = '';
            // this.password = '';
        }

        // getPostConnection(){
        //     this._http.get(`http://localhost:3000/reception?login=${this.login}&password=${this.password}`)
        //     .then(function(response){
        //         console.log("success", angular.fromJson(response.data));
        //     })
        //     .then(function(){
        //         console.log("Error");
        //     })
        // }
    }

    angular
        .module("app")
        .component(
        "receptionComponent",
        {
            controller: ReceptionController,
            controllerAs : 'RCtrl',
            templateUrl: "app/components/reception/reception.component.html"
        });
}