angular
  .module('app')
  .config(routesConfig);

function routesConfig($stateProvider, $urlRouterProvider, $locationProvider) {
  $locationProvider.html5Mode(true).hashPrefix('!');
  $urlRouterProvider.otherwise('/error/404');

  let films = {
    name: 'films',
    url: '/films',
    component: 'filmSearchComponent'
  };

  let accueil = {
    name: 'accueil',
    url: '/',
    component: 'app'
  };

  let signIn = {
    name: 'signIn',
    url: '/sign-in',
    component: 'signInComponent'
  };

  let connection = {
    name: 'connection',
    url: '/connection',
    component: 'connectionComponent'
  };

  let error = {
    name: 'error',
    url: '/error/:id',
    component: 'errorComponent'
  };

  let reception = {
    name: 'reception',
    url: '/reception',
    component: 'receptionComponent'
  };

  let profile = {
    name: 'profile',
    url: '/profile',
    component: 'profileComponent'
  };

  let score = {
    name: 'score',
    url: '/score',
    component: 'scoreComponent'
  };

  $stateProvider.state(accueil);
  $stateProvider.state(films);
  $stateProvider.state(signIn);
  $stateProvider.state(connection);
  $stateProvider.state(error);
  $stateProvider.state(reception);
  $stateProvider.state(profile);
  $stateProvider.state(score);
}
