'use strict';

var cov_xrhg9o0f8 = function () {
  var path = 'C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\main.js',
      hash = '6bd766dda283d561e80058102c95f78ee91c4b03',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\main.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 0
        },
        end: {
          line: 5,
          column: 5
        }
      }
    },
    fnMap: {},
    branchMap: {},
    s: {
      '0': 0
    },
    f: {},
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

++cov_xrhg9o0f8.s[0];
angular.module('app').component('app', {
  templateUrl: 'app/main.html'
});