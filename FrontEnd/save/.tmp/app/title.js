'use strict';

var cov_4pj82olxe = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\title.js',
      hash = '71a7575fc27c6fbb0fd294c497226fda1ff8f601',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\title.js',
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

++cov_4pj82olxe.s[0];
angular.module('app').component('fountainTitle', {
  templateUrl: 'app/title.html'
});