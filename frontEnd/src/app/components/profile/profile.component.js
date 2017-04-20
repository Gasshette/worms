{
    "use strict";
    class ProfileController {
        constructor() {
            this.user = {
                "id": 46,
                "nickname": "Claudette",
                "password": 123456,
                "gold": 928,
                "gem": 4,
                "key": 1,
                "level": 6
            };
        }
    }

    angular
        .module("app")
        .component(
        "profileComponent",
        {
            controller: ProfileController,
            controllerAs: 'PrCtrl',
            templateUrl: "app/components/profile/profile.component.html"
        });
}