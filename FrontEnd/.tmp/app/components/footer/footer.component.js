"use strict";

var cov_7xzhssvvt = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\footer\\footer.component.js",
        hash = "ad13a07ae08b258280e2b6f3589d6dd145924ce2",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\footer\\footer.component.js",
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
                    line: 9,
                    column: 4
                },
                end: {
                    line: 13,
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
    ++cov_7xzhssvvt.s[0];

    "use strict";

    var FooterController = function FooterController() {
        _classCallCheck(this, FooterController);

        ++cov_7xzhssvvt.f[0];
    };

    ++cov_7xzhssvvt.s[1];


    angular.module("app").component("footerComponent", {
        controller: FooterController,
        templateUrl: "app/components/footer/footer.component.html"
    });
}