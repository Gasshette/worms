'use strict';

var cov_3kcftxkkh = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\header.spec.js',
      hash = '41690464e4ed00d7af828cde570754d4140e4700',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\header.spec.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 0
        },
        end: {
          line: 15,
          column: 3
        }
      },
      '1': {
        start: {
          line: 2,
          column: 2
        },
        end: {
          line: 8,
          column: 6
        }
      },
      '2': {
        start: {
          line: 3,
          column: 4
        },
        end: {
          line: 7,
          column: 7
        }
      },
      '3': {
        start: {
          line: 4,
          column: 6
        },
        end: {
          line: 6,
          column: 8
        }
      },
      '4': {
        start: {
          line: 9,
          column: 2
        },
        end: {
          line: 14,
          column: 6
        }
      },
      '5': {
        start: {
          line: 10,
          column: 20
        },
        end: {
          line: 10,
          column: 79
        }
      },
      '6': {
        start: {
          line: 11,
          column: 4
        },
        end: {
          line: 11,
          column: 25
        }
      },
      '7': {
        start: {
          line: 12,
          column: 19
        },
        end: {
          line: 12,
          column: 36
        }
      },
      '8': {
        start: {
          line: 13,
          column: 4
        },
        end: {
          line: 13,
          column: 63
        }
      }
    },
    fnMap: {
      '0': {
        name: '(anonymous_0)',
        decl: {
          start: {
            line: 1,
            column: 29
          },
          end: {
            line: 1,
            column: 30
          }
        },
        loc: {
          start: {
            line: 1,
            column: 35
          },
          end: {
            line: 15,
            column: 1
          }
        },
        line: 1
      },
      '1': {
        name: '(anonymous_1)',
        decl: {
          start: {
            line: 2,
            column: 27
          },
          end: {
            line: 2,
            column: 28
          }
        },
        loc: {
          start: {
            line: 2,
            column: 39
          },
          end: {
            line: 8,
            column: 3
          }
        },
        line: 2
      },
      '2': {
        name: '(anonymous_2)',
        decl: {
          start: {
            line: 3,
            column: 39
          },
          end: {
            line: 3,
            column: 40
          }
        },
        loc: {
          start: {
            line: 3,
            column: 45
          },
          end: {
            line: 7,
            column: 5
          }
        },
        line: 3
      },
      '3': {
        name: '(anonymous_3)',
        decl: {
          start: {
            line: 9,
            column: 65
          },
          end: {
            line: 9,
            column: 66
          }
        },
        loc: {
          start: {
            line: 9,
            column: 91
          },
          end: {
            line: 14,
            column: 3
          }
        },
        line: 9
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
      '8': 0
    },
    f: {
      '0': 0,
      '1': 0,
      '2': 0,
      '3': 0
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

++cov_3kcftxkkh.s[0];
describe('header component', function () {
  ++cov_3kcftxkkh.f[0];
  ++cov_3kcftxkkh.s[1];

  beforeEach(module('app', function ($provide) {
    ++cov_3kcftxkkh.f[1];
    ++cov_3kcftxkkh.s[2];

    $provide.factory('fountainHeader', function () {
      ++cov_3kcftxkkh.f[2];
      ++cov_3kcftxkkh.s[3];

      return {
        templateUrl: 'app/header.html'
      };
    });
  }));
  ++cov_3kcftxkkh.s[4];
  it('should render \'Fountain Generator\'', angular.mock.inject(function ($rootScope, $compile) {
    ++cov_3kcftxkkh.f[3];

    var element = (++cov_3kcftxkkh.s[5], $compile('<fountain-header></fountain-header>')($rootScope));
    ++cov_3kcftxkkh.s[6];
    $rootScope.$digest();
    var header = (++cov_3kcftxkkh.s[7], element.find('a'));
    ++cov_3kcftxkkh.s[8];
    expect(header.html().trim()).toEqual('Fountain Generator');
  }));
});