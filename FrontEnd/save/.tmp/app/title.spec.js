'use strict';

var cov_c44n27639 = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\title.spec.js',
      hash = '411e55278ed77475ef017c43412a0c873510a387',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\title.spec.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 0
        },
        end: {
          line: 16,
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
          line: 9,
          column: 41
        }
      },
      '5': {
        start: {
          line: 10,
          column: 2
        },
        end: {
          line: 15,
          column: 6
        }
      },
      '6': {
        start: {
          line: 11,
          column: 20
        },
        end: {
          line: 11,
          column: 77
        }
      },
      '7': {
        start: {
          line: 12,
          column: 4
        },
        end: {
          line: 12,
          column: 25
        }
      },
      '8': {
        start: {
          line: 13,
          column: 18
        },
        end: {
          line: 13,
          column: 36
        }
      },
      '9': {
        start: {
          line: 14,
          column: 4
        },
        end: {
          line: 14,
          column: 59
        }
      }
    },
    fnMap: {
      '0': {
        name: '(anonymous_0)',
        decl: {
          start: {
            line: 1,
            column: 28
          },
          end: {
            line: 1,
            column: 29
          }
        },
        loc: {
          start: {
            line: 1,
            column: 34
          },
          end: {
            line: 16,
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
            column: 38
          },
          end: {
            line: 3,
            column: 39
          }
        },
        loc: {
          start: {
            line: 3,
            column: 44
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
            line: 10,
            column: 58
          },
          end: {
            line: 10,
            column: 59
          }
        },
        loc: {
          start: {
            line: 10,
            column: 84
          },
          end: {
            line: 15,
            column: 3
          }
        },
        line: 10
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
      '9': 0
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

++cov_c44n27639.s[0];
describe('title component', function () {
  ++cov_c44n27639.f[0];
  ++cov_c44n27639.s[1];

  beforeEach(module('app', function ($provide) {
    ++cov_c44n27639.f[1];
    ++cov_c44n27639.s[2];

    $provide.factory('fountainTitle', function () {
      ++cov_c44n27639.f[2];
      ++cov_c44n27639.s[3];

      return {
        templateUrl: 'app/title.html'
      };
    });
  }));
  ++cov_c44n27639.s[4];
  beforeEach(angular.mock.module('app'));
  ++cov_c44n27639.s[5];
  it('should render \'Allo, \'Allo!', angular.mock.inject(function ($rootScope, $compile) {
    ++cov_c44n27639.f[3];

    var element = (++cov_c44n27639.s[6], $compile('<fountain-title></fountain-title>')($rootScope));
    ++cov_c44n27639.s[7];
    $rootScope.$digest();
    var title = (++cov_c44n27639.s[8], element.find('h1'));
    ++cov_c44n27639.s[9];
    expect(title.html().trim()).toEqual('\'Allo, \'Allo!');
  }));
});