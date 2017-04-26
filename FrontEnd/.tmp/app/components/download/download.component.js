"use strict";

var cov_164zol99q7 = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\download\\download.component.js",
        hash = "3e17c747e15665e9757689f09b0f50c962eba4a3",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\download\\download.component.js",
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
                    line: 16,
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
    ++cov_164zol99q7.s[0];

    "use strict";

    var DownloadController = function DownloadController() {
        _classCallCheck(this, DownloadController);

        ++cov_164zol99q7.f[0];
    };

    ++cov_164zol99q7.s[1];


    angular.module("app").component("downloadComponent", {
        controller: DownloadController,
        controllerAs: 'DlCtrl',
        templateUrl: 'app/components/download/download.component.html'
    });
}