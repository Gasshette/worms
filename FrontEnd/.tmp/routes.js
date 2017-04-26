'use strict';

var cov_125cecisn5 = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\routes.js',
      hash = 'ab1c4f9906826b1fcfc4297248e90566da6ddbdd',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\routes.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 0
        },
        end: {
          line: 3,
          column: 24
        }
      },
      '1': {
        start: {
          line: 6,
          column: 2
        },
        end: {
          line: 6,
          column: 52
        }
      },
      '2': {
        start: {
          line: 7,
          column: 2
        },
        end: {
          line: 7,
          column: 45
        }
      },
      '3': {
        start: {
          line: 9,
          column: 14
        },
        end: {
          line: 13,
          column: 3
        }
      },
      '4': {
        start: {
          line: 15,
          column: 16
        },
        end: {
          line: 19,
          column: 3
        }
      },
      '5': {
        start: {
          line: 21,
          column: 15
        },
        end: {
          line: 25,
          column: 3
        }
      },
      '6': {
        start: {
          line: 27,
          column: 19
        },
        end: {
          line: 31,
          column: 3
        }
      },
      '7': {
        start: {
          line: 33,
          column: 14
        },
        end: {
          line: 37,
          column: 3
        }
      },
      '8': {
        start: {
          line: 39,
          column: 18
        },
        end: {
          line: 43,
          column: 3
        }
      },
      '9': {
        start: {
          line: 45,
          column: 16
        },
        end: {
          line: 49,
          column: 3
        }
      },
      '10': {
        start: {
          line: 51,
          column: 14
        },
        end: {
          line: 55,
          column: 3
        }
      },
      '11': {
        start: {
          line: 57,
          column: 17
        },
        end: {
          line: 61,
          column: 3
        }
      },
      '12': {
        start: {
          line: 67,
          column: 4
        },
        end: {
          line: 67,
          column: 34
        }
      },
      '13': {
        start: {
          line: 68,
          column: 4
        },
        end: {
          line: 68,
          column: 32
        }
      },
      '14': {
        start: {
          line: 69,
          column: 4
        },
        end: {
          line: 69,
          column: 33
        }
      },
      '15': {
        start: {
          line: 70,
          column: 4
        },
        end: {
          line: 70,
          column: 37
        }
      },
      '16': {
        start: {
          line: 71,
          column: 4
        },
        end: {
          line: 71,
          column: 32
        }
      },
      '17': {
        start: {
          line: 72,
          column: 4
        },
        end: {
          line: 72,
          column: 36
        }
      },
      '18': {
        start: {
          line: 73,
          column: 4
        },
        end: {
          line: 73,
          column: 34
        }
      },
      '19': {
        start: {
          line: 74,
          column: 4
        },
        end: {
          line: 74,
          column: 32
        }
      },
      '20': {
        start: {
          line: 75,
          column: 4
        },
        end: {
          line: 75,
          column: 35
        }
      }
    },
    fnMap: {
      '0': {
        name: 'routesConfig',
        decl: {
          start: {
            line: 5,
            column: 9
          },
          end: {
            line: 5,
            column: 21
          }
        },
        loc: {
          start: {
            line: 5,
            column: 77
          },
          end: {
            line: 78,
            column: 1
          }
        },
        line: 5
      }
    },
    branchMap: {},
    s: {
      '0': 0,
      '1': 0,
      '2': 0,
      '3': 0,
      '4': 0,
      '5': 0,
      '6': 0,
      '7': 0,
      '8': 0,
      '9': 0,
      '10': 0,
      '11': 0,
      '12': 0,
      '13': 0,
      '14': 0,
      '15': 0,
      '16': 0,
      '17': 0,
      '18': 0,
      '19': 0,
      '20': 0
    },
    f: {
      '0': 0
    },
    b: {},
    _coverageSchema: '332fd63041d2c1bcb487cc26dd0d5f7d97098a6c'
  },
      coverage = global[gcv] || (global[gcv] = {});

  if (coverage[path] && coverage[path].hash === hash) {
    return coverage[path];
  }

  coverageData.hash = hash;
  return coverage[path] = coverageData;
}();

++cov_125cecisn5.s[0];
angular.module('app').config(routesConfig);

function routesConfig($stateProvider, $urlRouterProvider, $locationProvider) {
  ++cov_125cecisn5.f[0];
  ++cov_125cecisn5.s[1];

  $locationProvider.html5Mode(true).hashPrefix('!');
  ++cov_125cecisn5.s[2];
  $urlRouterProvider.otherwise('/error/404');

  var films = (++cov_125cecisn5.s[3], {
    name: 'films',
    url: '/films',
    component: 'filmSearchComponent'
  });

  var accueil = (++cov_125cecisn5.s[4], {
    name: 'accueil',
    url: '/',
    component: 'app'
  });

  var signIn = (++cov_125cecisn5.s[5], {
    name: 'signIn',
    url: '/sign-in',
    component: 'signInComponent'
  });

  var connection = (++cov_125cecisn5.s[6], {
    name: 'connection',
    url: '/connection',
    component: 'connectionComponent'
  });

  var error = (++cov_125cecisn5.s[7], {
    name: 'error',
    url: '/error/:id',
    component: 'errorComponent'
  });

  var reception = (++cov_125cecisn5.s[8], {
    name: 'reception',
    url: '/reception',
    component: 'receptionComponent'
  });

  var profile = (++cov_125cecisn5.s[9], {
    name: 'profile',
    url: '/profile',
    component: 'profileComponent'
  });

  var score = (++cov_125cecisn5.s[10], {
    name: 'score',
    url: '/score',
    component: 'scoreComponent'
  });

  var download = (++cov_125cecisn5.s[11], {
    name: 'download',
    url: '/download',
    component: 'downloadComponent'
  });

  // if (typeof authProvider.authedUser == "undefined") {
  //   $locationProvider.url("/connection");
  // }
  // else {
  ++cov_125cecisn5.s[12];
  $stateProvider.state(accueil);
  ++cov_125cecisn5.s[13];
  $stateProvider.state(films);
  ++cov_125cecisn5.s[14];
  $stateProvider.state(signIn);
  ++cov_125cecisn5.s[15];
  $stateProvider.state(connection);
  ++cov_125cecisn5.s[16];
  $stateProvider.state(error);
  ++cov_125cecisn5.s[17];
  $stateProvider.state(reception);
  ++cov_125cecisn5.s[18];
  $stateProvider.state(profile);
  ++cov_125cecisn5.s[19];
  $stateProvider.state(score);
  ++cov_125cecisn5.s[20];
  $stateProvider.state(download);
  // }
}