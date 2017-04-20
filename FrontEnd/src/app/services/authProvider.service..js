{
    class AuthProvider {
        constructor($http) {
            this._http = $http;
            this.auth;
        }

        authentication(){
            // console.log("dans authentication");
            let that = this;
            this.auth = this._http.get("resources/users.json")
            .then(function(response){
                if(response){
                    response.data.forEach(function(el) {
                        if(el.login == that.login && el.password == that.password){
                            that.auth = el;
                        }
                    }, this);
                }
            },
            function(){
                console.log("Error");
            });
        }
    }

    angular
        .module("app")
        .service('authProvider', AuthProvider);
}