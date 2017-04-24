{
    "use strict";
    class MenuController {

        constructor(authProvider, $interval) {
            let that = this;
            this._interval = $interval;
            this._authProvider = authProvider;
            this.authedUser = this._authProvider.authedUser;
            this.colors = ["orange", "orangered", "yellow", "yellowgreen", "chocolate", "cornflowerblue", "darkgray", "darkorange", "dodgerblue", "gold", "limegreen", "peru", "plum", "royalblue", "whitesmoke", "wheat"];
            this.targetColor = null;

            //create only one promise for the entire page.
            this.promisedColor = this._interval(function (e) {
                    if(that.targetColor) {
                        that.targetColor.css("borderBottom", "2px solid " + that.colors[Math.floor(Math.random() * that.colors.length)]);
                    }
                }, 500);
        }

        changeColor(event) {
            if (event.target.tagName == 'A') {
                this.targetColor = $(event.target);
            }
        }

        resetColor() {
            if(this.targetColor) {
                this.targetColor.css("borderBottom", "2px solid #fff");
                this.targetColor = null;
            }
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