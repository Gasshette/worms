angular
  .module('app')
  .config(routesConfig);

/** @ngInject */
function routesConfig($stateProvider, $urlRouterProvider, $locationProvider) {
  $locationProvider.html5Mode(true).hashPrefix('!');
  $urlRouterProvider.otherwise('/');


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

  // let error404 = {
  //   name: 'error.error404',
  //   url: '/404',
  //   component: 'error404Component'
  // };

  $stateProvider.state(accueil);
  $stateProvider.state(films);
  $stateProvider.state(signIn);
  $stateProvider.state(connection);
  $stateProvider.state(error);
  // $stateProvider.state(error404);

  // $stateProvider
  //   .state('accueil', {
  //     url: '/',
  //     component: 'app'
  //   })
  //   .state('films', {
  //     url: '/films',
  //     component: 'filmSearchComponent'
  //   });
}
