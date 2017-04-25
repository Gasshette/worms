{
    class AuthProvider {
        constructor($http) {
            this._http = $http;
            this.authedUser = null;
            this.allUsers = [];

            this.getAllUsers();
        }

        getAllUsers() {
            let that = this;
            this._http.get("/resources/users.json")
                .then(function (response) {
                    response.data.forEach(function (el) {
                        that.allUsers.push(el);
                    }, this);
                }, function () {
                    console.log("An error occured while trying to get all users.");
                });
        }
        

        registerUser(user) {
            let flag = false;
            let userOK = true;

            angular.forEach(user, function (key, value) {
                if(typeof value == 'undefined'){
                    userOK = false;
                }
            }, this);

            if (userOK) {
                this.allUsers.forEach(function (el) {
                    if (el.nickname == user.login) {
                        flag = true;
                    }
                }, this);

                if (!flag) {
                    this.allUsers.push(user);
                    //Connect the user who just registered
                    this.authedUser = user;
                    return true;
                }
            }
        }
    }

    angular
        .module("app")
        .service('authProvider', AuthProvider);
}