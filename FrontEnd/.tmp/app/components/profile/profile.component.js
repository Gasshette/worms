"use strict";

var cov_14e5rdelqs = function () {
    var path = "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\profile\\profile.component.js",
        hash = "725a9bd67ddfb8f76d5f2c0a552e57dbe5bbc6d6",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\profile\\profile.component.js",
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
                    line: 5,
                    column: 12
                },
                end: {
                    line: 5,
                    column: 46
                }
            },
            "2": {
                start: {
                    line: 6,
                    column: 12
                },
                end: {
                    line: 6,
                    column: 60
                }
            },
            "3": {
                start: {
                    line: 10,
                    column: 4
                },
                end: {
                    line: 34,
                    column: 11
                }
            },
            "4": {
                start: {
                    line: 20,
                    column: 12
                },
                end: {
                    line: 33,
                    column: 14
                }
            },
            "5": {
                start: {
                    line: 26,
                    column: 20
                },
                end: {
                    line: 30,
                    column: 21
                }
            },
            "6": {
                start: {
                    line: 27,
                    column: 38
                },
                end: {
                    line: 27,
                    column: 99
                }
            },
            "7": {
                start: {
                    line: 28,
                    column: 24
                },
                end: {
                    line: 28,
                    column: 79
                }
            },
            "8": {
                start: {
                    line: 29,
                    column: 24
                },
                end: {
                    line: 29,
                    column: 77
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
                        line: 7,
                        column: 9
                    }
                },
                line: 4
            },
            "1": {
                name: "(anonymous_1)",
                decl: {
                    start: {
                        line: 19,
                        column: 34
                    },
                    end: {
                        line: 19,
                        column: 35
                    }
                },
                loc: {
                    start: {
                        line: 19,
                        column: 58
                    },
                    end: {
                        line: 34,
                        column: 9
                    }
                },
                line: 19
            },
            "2": {
                name: "(anonymous_2)",
                decl: {
                    start: {
                        line: 25,
                        column: 22
                    },
                    end: {
                        line: 25,
                        column: 23
                    }
                },
                loc: {
                    start: {
                        line: 25,
                        column: 39
                    },
                    end: {
                        line: 31,
                        column: 17
                    }
                },
                line: 25
            }
        },
        branchMap: {
            "0": {
                loc: {
                    start: {
                        line: 26,
                        column: 20
                    },
                    end: {
                        line: 30,
                        column: 21
                    }
                },
                type: "if",
                locations: [{
                    start: {
                        line: 26,
                        column: 20
                    },
                    end: {
                        line: 30,
                        column: 21
                    }
                }, {
                    start: {
                        line: 26,
                        column: 20
                    },
                    end: {
                        line: 30,
                        column: 21
                    }
                }],
                line: 26
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
            "0": 0,
            "1": 0,
            "2": 0
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
    ++cov_14e5rdelqs.s[0];

    "use strict";

    var ProfileController = function ProfileController(authProvider) {
        _classCallCheck(this, ProfileController);

        ++cov_14e5rdelqs.f[0];
        ++cov_14e5rdelqs.s[1];

        this._authProvider = authProvider;
        ++cov_14e5rdelqs.s[2];
        this.authedUser = this._authProvider.authedUser;
    };

    ++cov_14e5rdelqs.s[3];


    angular.module("app").component("profileComponent", {
        controller: ProfileController,
        controllerAs: 'PrCtrl',
        templateUrl: "app/components/profile/profile.component.html"
    }).directive("progressBar", function (authProvider) {
        ++cov_14e5rdelqs.f[1];
        ++cov_14e5rdelqs.s[4];

        return {
            scope: {
                percent: "="
            },
            restrict: 'E',
            link: function link(scope) {
                ++cov_14e5rdelqs.f[2];
                ++cov_14e5rdelqs.s[5];

                if (authProvider.authedUser !== null) {
                    ++cov_14e5rdelqs.b[0][0];

                    var progbar = (++cov_14e5rdelqs.s[6], angular.element(document.querySelector("#progressbar > div")));
                    ++cov_14e5rdelqs.s[7];
                    scope.percent = authProvider.authedUser.exp / 10 + "%";
                    ++cov_14e5rdelqs.s[8];
                    angular.element(progbar).css("width", scope.percent);
                } else {
                    ++cov_14e5rdelqs.b[0][1];
                }
            },
            templateUrl: "app/components/globalview/progressbar.html"
        };
    });
}