"use strict";

var cov_mvq01gayu = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\connectionrequired\\connectionrequired.component.js",
        hash = "dd5b99a0a42150c506626f641d2bef025534172e",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\connectionrequired\\connectionrequired.component.js",
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
    ++cov_mvq01gayu.s[0];

    "use strict";

    var ConnectionRequiredController = function ConnectionRequiredController() {
        _classCallCheck(this, ConnectionRequiredController);

        ++cov_mvq01gayu.f[0];
    };

    ++cov_mvq01gayu.s[1];


    angular.module("app").component("connectionRequiredComponent", {
        controller: ConnectionRequiredController,
        controllerAs: 'ConRecCtrl',
        templateUrl: "app/components/connectionrequired/connectionrequired.component.html"
    });
}