"use strict";

var cov_v13yw4c5m = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\header\\header.component.js",
        hash = "9fd5a79a68c85923008aa3ce36c4128b947555b3",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\header\\header.component.js",
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

    ++cov_v13yw4c5m.s[0];


    angular.module("app").component("headerComponent", {
        controller: HeaderController,
        templateUrl: "app/components/header/header.component.html"
    });
}