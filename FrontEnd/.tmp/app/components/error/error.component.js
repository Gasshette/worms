"use strict";

var cov_1ku31a65xl = function () {
    var path = "C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\components\\error\\error.component.js",
        hash = "bed287dd032e18fd744a126d089064dda479dcb8",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\components\\error\\error.component.js",
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
                    line: 6,
                    column: 12
                },
                end: {
                    line: 16,
                    column: 13
                }
            },
            "2": {
                start: {
                    line: 8,
                    column: 20
                },
                end: {
                    line: 8,
                    column: 46
                }
            },
            "3": {
                start: {
                    line: 9,
                    column: 20
                },
                end: {
                    line: 9,
                    column: 26
                }
            },
            "4": {
                start: {
                    line: 11,
                    column: 20
                },
                end: {
                    line: 11,
                    column: 46
                }
            },
            "5": {
                start: {
                    line: 12,
                    column: 20
                },
                end: {
                    line: 12,
                    column: 26
                }
            },
            "6": {
                start: {
                    line: 14,
                    column: 20
                },
                end: {
                    line: 14,
                    column: 34
                }
            },
            "7": {
                start: {
                    line: 15,
                    column: 20
                },
                end: {
                    line: 15,
                    column: 26
                }
            },
            "8": {
                start: {
                    line: 20,
                    column: 4
                },
                end: {
                    line: 28,
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
                        column: 34
                    },
                    end: {
                        line: 17,
                        column: 9
                    }
                },
                line: 4
            }
        },
        branchMap: {
            "0": {
                loc: {
                    start: {
                        line: 6,
                        column: 12
                    },
                    end: {
                        line: 16,
                        column: 13
                    }
                },
                type: "switch",
                locations: [{
                    start: {
                        line: 7,
                        column: 16
                    },
                    end: {
                        line: 9,
                        column: 26
                    }
                }, {
                    start: {
                        line: 10,
                        column: 16
                    },
                    end: {
                        line: 12,
                        column: 26
                    }
                }, {
                    start: {
                        line: 13,
                        column: 16
                    },
                    end: {
                        line: 15,
                        column: 26
                    }
                }],
                line: 6
            }
        },
        s: {
            "0": 0,
            "1": 0,
            "2": 0,
            "3": 0,
            "4": 0,
            "5": 0,
            "6": 0,
            "7": 0,
            "8": 0
        },
        f: {
            "0": 0
        },
        b: {
            "0": [0, 0, 0]
        },
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
    ++cov_1ku31a65xl.s[0];

    "use strict";

    var ErrorController = function ErrorController($stateParams) {
        _classCallCheck(this, ErrorController);

        ++cov_1ku31a65xl.f[0];
        ++cov_1ku31a65xl.s[1];


        switch ($stateParams.id) {
            case 304:
                ++cov_1ku31a65xl.b[0][0];
                ++cov_1ku31a65xl.s[2];

                this.id = $stateParams.id;
                ++cov_1ku31a65xl.s[3];
                break;
            case 504:
                ++cov_1ku31a65xl.b[0][1];
                ++cov_1ku31a65xl.s[4];

                this.id = $stateParams.id;
                ++cov_1ku31a65xl.s[5];
                break;
            default:
                ++cov_1ku31a65xl.b[0][2];
                ++cov_1ku31a65xl.s[6];

                this.id = 404;
                ++cov_1ku31a65xl.s[7];
                break;
        }
    };

    ++cov_1ku31a65xl.s[8];


    angular.module("app").component("errorComponent", {
        controller: ErrorController,
        controllerAs: 'err',
        templateUrl: 'app/components/error/error.component.html'
    });
}