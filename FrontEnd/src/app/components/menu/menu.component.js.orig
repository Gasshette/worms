{
    "use strict";
    class MenuController {

        constructor(authProvider, $interval, $location, $scope) {
            let that = this;
            this._scope = $scope;
            this._interval = $interval;
            this._authProvider = authProvider;
            this._location = $location;
            this.logged = null;
            this.colors = ["orange", "orangered", "yellow", "yellowgreen", "chocolate", "cornflowerblue", "darkgray", "darkorange", "dodgerblue", "gold", "limegreen", "peru", "plum", "royalblue", "whitesmoke", "wheat"];
            this.targetColor = null;

            //create only one promise for the entire page.
            this.promisedColor = this._interval(function (e) {
                let color = that.colors[Math.floor(Math.random() * that.colors.length)];
                if (that.targetColor) {
                    that.targetColor.css("borderBottom", "2px solid " + color);
                    if (that.targetColor.find(".glyphicon-home")) {
                        that.targetColor.find(".glyphicon-home").css("color", color);
                    }
                }
            }, 500);

            //check if you're logged in or not
            //This is kinda disgusting, need to change it for a $apply() or $digest() if possible. But if i remember well, angular 2 does not use $digest anymore
            this._interval(function () {
                that._scope.$watch(that._authProvider.authedUser, function () {
                that.logged = (that._authProvider.authedUser === null) ? false : true;
            });
            }, 300);

            
        }

        changeColor(event) {
            if (event.target.tagName == 'A') {
                this.targetColor = $(event.target);
            }
        }

        resetColor() {
            if (this.targetColor) {
                this.targetColor.css("borderBottom", "2px solid #fff");
                this.targetColor.find(".glyphicon-home").css("color", "#777");
                this.targetColor = null;
            }
        }

        disconnect() {
            this._authProvider.authedUser = null;
            this._location.url("/");
        }
    }

    angular
        .module("app")
        .component(
        "menuComponent",
        {
            controller: MenuController,
            controllerAs: "mc",
            templateUrl: "app/components/menu/menu.component.html"
        });
}