'use strict';

var cov_d72zoa9ql = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\main.js',
      hash = '5fcf7cb8d21b369f22f5431cb0b45d22ce486188',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\main.js',
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

++cov_d72zoa9ql.s[0];
angular.module('app').component('app', {
  templateUrl: 'app/main.html'
});