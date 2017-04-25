'use strict';

var cov_za76jjeuj = function () {
  var path = 'C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\index.js',
      hash = '45f4b282b19537c7ebd127dc9a3b0f8b327bd230',
      global = new Function('return this')(),
      gcv = '__coverage__',
      coverageData = {
    path: 'C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\index.js',
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

++cov_za76jjeuj.s[0];
angular.module('app', ['ui.router']);