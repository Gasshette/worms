'use strict';

var cov_4tlhnty9q = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\techs\\techs.js',
      hash = '9812587d025f28cb2cc32729ec04052dc22e503e',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\techs\\techs.js',
    statementMap: {
      '0': {
        start: {
          line: 4,
          column: 4
        },
        end: {
          line: 8,
          column: 9
        }
      },
      '1': {
        start: {
          line: 7,
          column: 8
        },
        end: {
          line: 7,
          column: 35
        }
      },
      '2': {
        start: {
          line: 12,
          column: 0
        },
        end: {
          line: 17,
          column: 5
        }
      }
    },
    fnMap: {
      '0': {
        name: '(anonymous_0)',
        decl: {
          start: {
            line: 3,
            column: 2
          },
          end: {
            line: 3,
            column: 3
          }
        },
        loc: {
          start: {
            line: 3,
            column: 21
          },
          end: {
            line: 9,
            column: 3
          }
        },
        line: 3
      },
      '1': {
        name: '(anonymous_1)',
        decl: {
          start: {
            line: 6,
            column: 12
          },
          end: {
            line: 6,
            column: 13
          }
        },
        loc: {
          start: {
            line: 6,
            column: 24
          },
          end: {
            line: 8,
            column: 7
          }
        },
        line: 6
      }
    },
    branchMap: {},
    s: {
      '0': 0,
      '1': 0,
      '2': 0
    },
    f: {
      '0': 0,
      '1': 0
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

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var TechsController =
/** @ngInject */
function TechsController($http) {
  var _this = this;

  _classCallCheck(this, TechsController);

  ++cov_4tlhnty9q.f[0];
  ++cov_4tlhnty9q.s[0];

  $http.get('app/techs/techs.json').then(function (response) {
    ++cov_4tlhnty9q.f[1];
    ++cov_4tlhnty9q.s[1];

    _this.techs = response.data;
  });
};

++cov_4tlhnty9q.s[2];


angular.module('app').component('fountainTechs', {
  templateUrl: 'app/techs/techs.html',
  controller: TechsController
});