{
    "use strict";
    class MenuController {

        constructor(authProvider, $interval) {
            this._interval = $interval;
            this._authProvider = authProvider;
            this.authedUser = this._authProvider.authedUser;
            this.promisedColor;
            this.colors = ["orange", "orangered", "yellow", "yellowgreen",  "chocolate", "cornflowerblue", "darkgray", "darkorange", "dodgerblue", "gold", "limegreen", "peru", "plum", "royalblue", "whitesmoke", "wheat"];
        }

        changeColor(element) {
            if (element.target.tagName == 'A') {
                let that = this;
                that.promisedColor = that._interval(function(){
                    $(element.target).css("borderBottom", "2px solid " + that.colors[Math.floor(Math.random() * that.colors.length)]);
                }, 200);
            }
        }

        resetColor(element) {
            this._interval.cancel(this.promisedColor);
            $(element.target).css("borderBottom", "2px solid #fff");
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