'use strict';

var cov_23zr1ngo3c = function () {
  var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\index.js',
      hash = '9a319866b3f6aad8bc825cde56c2dbb86397648f',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\index.js',
    statementMap: {
      '0': {
        start: {
          line: 1,
          column: 0
        },
        end: {
          line: 2,
          column: 32
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

++cov_23zr1ngo3c.s[0];
angular.module('app', ['ui.router']);