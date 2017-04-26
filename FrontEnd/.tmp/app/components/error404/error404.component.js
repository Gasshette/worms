"use strict";

var cov_6eawdi2lu = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\error404\\error404.component.js",
        hash = "425667187c5baa2c7eee4ade2415f4b1932d4766",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\error404\\error404.component.js",
        statementMap: {
            "0": {
                start: {
                    line: 2,
                    column: 4
                },
                end: {
                    line: 2,
                    column: 17
                }
            },
            "1": {
                start: {
                    line: 8,
                    column: 4
                },
                end: {
                    line: 15,
                    column: 11
                }
            }
        },
        fnMap: {
            "0": {
                name: "(anonymous_0)",
                decl: {
                    start: {
                        line: 4,
                        column: 8
                    },
                    end: {
                        line: 4,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 4,
                        column: 22
                    },
                    end: {
                        line: 5,
                        column: 9
                    }
                },
                line: 4
            }
        },
        branchMap: {},
        s: {
            "0": 0,
            "1": 0
        },
        f: {
            "0": 0
        },
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
    ++cov_6eawdi2lu.s[0];

    "use strict";

    var Error404Controller = function Error404Controller() {
        _classCallCheck(this, Error404Controller);

        ++cov_6eawdi2lu.f[0];
    };

    ++cov_6eawdi2lu.s[1];


    angular.module("app").component("error404Component", {
        controller: Error404Controller,
        templateUrl: "app/components/error404/error404.component.html"
    });
}