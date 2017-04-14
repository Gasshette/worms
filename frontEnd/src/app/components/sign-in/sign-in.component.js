{
    "use strict";
    class SignInController {
        constructor() {
        }
    }

    angular
        .module("app")
        .component(
        "signInComponent",
        {
            controller: SignInController,
            templateUrl: "app/components/sign-in/sign-in.component.html"
        });
}