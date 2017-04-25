"use strict";

var cov_29xwp6x0s2 = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\components\\header\\header.component.js",
        hash = "e27d8f35b09a6a3119c032acff20410572524175",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\app\\components\\header\\header.component.js",
        statementMap: {
            "0": {
                start: {
                    line: 6,
                    column: 4
                },
                end: {
                    line: 10,
                    column: 7
                }
            }
        },
        fnMap: {},
        branchMap: {},
        s: {
            "0": 0
        },
        f: {},
        b: {},
        _coverageSchema: "332fd63041d2c1bcb487cc26dd0d5f7d97098a6c"
    },
        coverage = global[gcv] || (global[gcv] = {});

    if (coverage[path] && coverage[path].hash === hash) {
        return coverage[path];
    }

    coverageData.hash = hash;
    return coverage[path] = coverageData;
}();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

{
    var HeaderController = function HeaderController() {
        _classCallCheck(this, HeaderController);
    };

    ++cov_29xwp6x0s2.s[0];


    angular.module("app").component("headerComponent", {
        controller: HeaderController,
        templateUrl: "app/components/header/header.component.html"
    });
}