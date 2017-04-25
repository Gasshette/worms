'use strict';

var cov_1bfo4wu15x = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\techs\\tech.spec.js',
      hash = 'f4c4a6f60c58b8f23d5e94d9fa6a2af87440c534',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\techs\\tech.spec.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 0
        },
        end: {
          line: 23,
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
          line: 22,
          column: 6
        }
      },
      '5': {
        start: {
          line: 10,
          column: 19
        },
        end: {
          line: 10,
          column: 36
        }
      },
      '6': {
        start: {
          line: 11,
          column: 4
        },
        end: {
          line: 17,
          column: 6
        }
      },
      '7': {
        start: {
          line: 18,
          column: 20
        },
        end: {
          line: 18,
          column: 86
        }
      },
      '8': {
        start: {
          line: 19,
          column: 4
        },
        end: {
          line: 19,
          column: 21
        }
      },
      '9': {
        start: {
          line: 20,
          column: 17
        },
        end: {
          line: 20,
          column: 35
        }
      },
      '10': {
        start: {
          line: 21,
          column: 4
        },
        end: {
          line: 21,
          column: 47
        }
      }
    },
    fnMap: {
      '0': {
        name: '(anonymous_0)',
        decl: {
          start: {
            line: 1,
            column: 27
          },
          end: {
            line: 1,
            column: 28
          }
        },
        loc: {
          start: {
            line: 1,
            column: 33
          },
          end: {
            line: 23,
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
            column: 37
          },
          end: {
            line: 3,
            column: 38
          }
        },
        loc: {
          start: {
            line: 3,
            column: 43
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
            column: 47
          },
          end: {
            line: 9,
            column: 48
          }
        },
        loc: {
          start: {
            line: 9,
            column: 73
          },
          end: {
            line: 22,
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
      '8': 0,
      '9': 0,
      '10': 0
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

++cov_1bfo4wu15x.s[0];
describe('tech component', function () {
  ++cov_1bfo4wu15x.f[0];
  ++cov_1bfo4wu15x.s[1];

  beforeEach(module('app', function ($provide) {
    ++cov_1bfo4wu15x.f[1];
    ++cov_1bfo4wu15x.s[2];

    $provide.factory('fountainTech', function () {
      ++cov_1bfo4wu15x.f[2];
      ++cov_1bfo4wu15x.s[3];

      return {
        templateUrl: 'app/techs/tech.html'
      };
    });
  }));
  ++cov_1bfo4wu15x.s[4];
  it('should render Gulp', angular.mock.inject(function ($rootScope, $compile) {
    ++cov_1bfo4wu15x.f[3];

    var $scope = (++cov_1bfo4wu15x.s[5], $rootScope.$new());
    ++cov_1bfo4wu15x.s[6];
    $scope.fixture = {
      key: 'gulp',
      title: 'Gulp',
      logo: 'http://fountainjs.io/assets/imgs/gulp.png',
      text1: 'The streaming build system',
      text2: 'Automate and enhance your workflow'
    };
    var element = (++cov_1bfo4wu15x.s[7], $compile('<fountain-tech tech="fixture"></fountain-tech>')($scope));
    ++cov_1bfo4wu15x.s[8];
    $scope.$digest();
    var tech = (++cov_1bfo4wu15x.s[9], element.find('h3'));
    ++cov_1bfo4wu15x.s[10];
    expect(tech.html().trim()).toEqual('Gulp');
  }));
});