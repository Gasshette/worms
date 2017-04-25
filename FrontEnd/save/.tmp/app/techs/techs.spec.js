'use strict';

var cov_20hw9qqg1c = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\techs\\techs.spec.js',
      hash = 'dab70bd855e36bb7a9e34c2d264214860a6b7225',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\techs\\techs.spec.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 18
        },
        end: {
          line: 23,
          column: 1
        }
      },
      '1': {
        start: {
          line: 25,
          column: 0
        },
        end: {
          line: 36,
          column: 3
        }
      },
      '2': {
        start: {
          line: 26,
          column: 2
        },
        end: {
          line: 26,
          column: 41
        }
      },
      '3': {
        start: {
          line: 28,
          column: 2
        },
        end: {
          line: 35,
          column: 6
        }
      },
      '4': {
        start: {
          line: 29,
          column: 4
        },
        end: {
          line: 29,
          column: 72
        }
      },
      '5': {
        start: {
          line: 30,
          column: 20
        },
        end: {
          line: 30,
          column: 77
        }
      },
      '6': {
        start: {
          line: 31,
          column: 4
        },
        end: {
          line: 31,
          column: 25
        }
      },
      '7': {
        start: {
          line: 32,
          column: 4
        },
        end: {
          line: 32,
          column: 25
        }
      },
      '8': {
        start: {
          line: 33,
          column: 18
        },
        end: {
          line: 33,
          column: 47
        }
      },
      '9': {
        start: {
          line: 34,
          column: 4
        },
        end: {
          line: 34,
          column: 36
        }
      }
    },
    fnMap: {
      '0': {
        name: '(anonymous_0)',
        decl: {
          start: {
            line: 25,
            column: 28
          },
          end: {
            line: 25,
            column: 29
          }
        },
        loc: {
          start: {
            line: 25,
            column: 34
          },
          end: {
            line: 36,
            column: 1
          }
        },
        line: 25
      },
      '1': {
        name: '(anonymous_1)',
        decl: {
          start: {
            line: 28,
            column: 69
          },
          end: {
            line: 28,
            column: 70
          }
        },
        loc: {
          start: {
            line: 28,
            column: 109
          },
          end: {
            line: 35,
            column: 3
          }
        },
        line: 28
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

var techsJson = (++cov_20hw9qqg1c.s[0], [{
  key: 'gulp',
  title: 'Gulp',
  logo: 'http://fountainjs.io/assets/imgs/gulp.png',
  text1: 'The streaming build system',
  text2: 'Automate and enhance your workflow'
}, {
  key: 'react',
  title: 'React',
  logo: 'http://fountainjs.io/assets/imgs/react.png',
  text1: 'A JavaScript library for building user interfaces',
  text2: 'A declarative, efficient, and flexible JavaScript library for building user interfaces'
}, {
  key: 'angular1',
  title: 'Angular 1',
  logo: 'http://fountainjs.io/assets/imgs/angular1.png',
  text1: 'HTML enhanced for web apps!',
  text2: 'AngularJS lets you extend HTML vocabulary for your application. The resulting environment is extraordinarily expressive, readable, and quick to develop.'
}]);

++cov_20hw9qqg1c.s[1];
describe('techs component', function () {
  ++cov_20hw9qqg1c.f[0];
  ++cov_20hw9qqg1c.s[2];

  beforeEach(angular.mock.module('app'));

  ++cov_20hw9qqg1c.s[3];
  it('should render 3 elements <fountain-tech>', angular.mock.inject(function ($rootScope, $compile, $httpBackend) {
    ++cov_20hw9qqg1c.f[1];
    ++cov_20hw9qqg1c.s[4];

    $httpBackend.when('GET', 'app/techs/techs.json').respond(techsJson);
    var element = (++cov_20hw9qqg1c.s[5], $compile('<fountain-techs></fountain-techs>')($rootScope));
    ++cov_20hw9qqg1c.s[6];
    $httpBackend.flush();
    ++cov_20hw9qqg1c.s[7];
    $rootScope.$digest();
    var techs = (++cov_20hw9qqg1c.s[8], element.find('fountain-tech'));
    ++cov_20hw9qqg1c.s[9];
    expect(techs.length).toEqual(3);
  }));
});