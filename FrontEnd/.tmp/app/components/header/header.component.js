"use strict";

var cov_apxjzpeeq = function () {
    var path = "C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\components\\header\\header.component.js",
        hash = "23813d692554640027fb159c0d5a05a6b1505c20",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\components\\header\\header.component.js",
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

    ++cov_apxjzpeeq.s[0];


    angular.module("app").component("headerComponent", {
        controller: HeaderController,
        templateUrl: "app/components/header/header.component.html"
    });
}