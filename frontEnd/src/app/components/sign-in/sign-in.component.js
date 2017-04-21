{
    "use strict";
    class SignInController {
        constructor($http, authProvider) {
        }
}

angular
    .module("app")
    .component(
    "signInComponent",
    {
        controller: SignInController,
        controllerAs: 'SICtrl',
        templateUrl: "app/components/sign-in/sign-in.component.html"
    });
}