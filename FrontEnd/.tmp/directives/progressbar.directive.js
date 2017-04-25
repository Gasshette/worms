"use strict";

var cov_18xs7fiv94 = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\directives\\progressbar.directive.js",
        hash = "2afd4a7b60e2711face86ef8991fb445187f9458",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\frontEnd\\src\\directives\\progressbar.directive.js",
        statementMap: {
            "0": {
                start: {
                    line: 4,
                    column: 12
                },
                end: {
                    line: 17,
                    column: 14
                }
            },
            "1": {
                start: {
                    line: 10,
                    column: 20
                },
                end: {
                    line: 14,
                    column: 21
                }
            },
            "2": {
                start: {
                    line: 11,
                    column: 38
                },
                end: {
                    line: 11,
                    column: 99
                }
            },
            "3": {
                start: {
                    line: 12,
                    column: 24
                },
                end: {
                    line: 12,
                    column: 79
                }
            },
            "4": {
                start: {
                    line: 13,
                    column: 24
                },
                end: {
                    line: 13,
                    column: 77
                }
            }
        },
        fnMap: {
            "0": {
                name: "(anonymous_0)",
                decl: {
                    start: {
                        line: 3,
                        column: 8
                    },
                    end: {
                        line: 3,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 3,
                        column: 34
                    },
                    end: {
                        line: 18,
                        column: 9
                    }
                },
                line: 3
            },
            "1": {
                name: "(anonymous_1)",
                decl: {
                    start: {
                        line: 9,
                        column: 22
                    },
                    end: {
                        line: 9,
                        column: 23
                    }
                },
                loc: {
                    start: {
                        line: 9,
                        column: 39
                    },
                    end: {
                        line: 15,
                        column: 17
                    }
                },
                line: 9
            }
        },
        branchMap: {
            "0": {
                loc: {
                    start: {
                        line: 10,
                        column: 20
                    },
                    end: {
                        line: 14,
                        column: 21
                    }
                },
                type: "if",
                locations: [{
                    start: {
                        line: 10,
                        column: 20
                    },
                    end: {
                        line: 14,
                        column: 21
                    }
                }, {
                    start: {
                        line: 10,
                        column: 20
                    },
                    end: {
                        line: 14,
                        column: 21
                    }
                }],
                line: 10
            }
        },
        s: {
            "0": 0,
            "1": 0,
            "2": 0,
            "3": 0,
            "4": 0
        },
        f: {
            "0": 0,
            "1": 0
        },
        b: {
            "0": [0, 0]
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
    var ProgressBar = function ProgressBar(authProvider) {
        _classCallCheck(this, ProgressBar);

        ++cov_18xs7fiv94.f[0];
        ++cov_18xs7fiv94.s[0];

        return {
            scope: {
                percent: "="
            },
            restrict: 'E',
            link: function link(scope) {
                ++cov_18xs7fiv94.f[1];
                ++cov_18xs7fiv94.s[1];

                if (authProvider.authedUser !== null) {
                    ++cov_18xs7fiv94.b[0][0];

                    var progbar = (++cov_18xs7fiv94.s[2], angular.element(document.querySelector("#progressbar > div")));
                    ++cov_18xs7fiv94.s[3];
                    scope.percent = authProvider.authedUser.exp / 10 + "%";
                    ++cov_18xs7fiv94.s[4];
                    angular.element(progbar).css("width", scope.percent);
                } else {
                    ++cov_18xs7fiv94.b[0][1];
                }
            },
            templateUrl: "app/components/globalview/progressbar.html"
        };
    };
}