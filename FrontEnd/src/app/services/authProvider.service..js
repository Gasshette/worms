{
    class AuthProvider {
        constructor($http) {
            this._http = $http;
            this.authedUser;
            this.allUsers = [];

            this.getAllUsers();

        }

        getAllUsers() {
            let that= this;
            this._http.get("/resources/users.json")
            .then(function(response){
                response.data.forEach(function(el) {
                    that.allUsers.push(el);
                }, this);
            }, function(){
                console.log("An error occured while trying to get all users.");
            });
        }

        registerUser(user){
            let flag = false;
            if(typeof user.login != "undefined" && typeof user.password != "undefined"){
                this.allUsers.forEach(function(el) {
                    if(el.nickname == user.login){
                        flag = true;
                    }
                }, this);

                if(!flag){
                    this.allUsers.push(user);
                }
            }
        }
}

angular
    .module("app")
    .service('authProvider', AuthProvider);
}