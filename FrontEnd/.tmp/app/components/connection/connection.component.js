'use strict';

var cov_2d6q6k17c9 = function () {
    var path = 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\connection\\connection.component.js',
        hash = 'ac75b8ce40e6b823d8713974ac46aabf6f90a87a',
        global = new Function('return this')(),
        gcv = '__coverage__',
        coverageData = {
        path: 'C:\\Users\\Kotin\\Documents\\developpement\\github\\worms\\FrontEnd\\src\\app\\components\\connection\\connection.component.js',
        statementMap: {
            '0': {
                start: {
                    line: 2,
                    column: 4
                },
                end: {
                    line: 2,
                    column: 17
                }
            },
            '1': {
                start: {
                    line: 5,
                    column: 12
                },
                end: {
                    line: 5,
                    column: 39
                }
            },
            '2': {
                start: {
                    line: 6,
                    column: 12
                },
                end: {
                    line: 6,
                    column: 46
                }
            },
            '3': {
                start: {
                    line: 7,
                    column: 12
                },
                end: {
                    line: 7,
                    column: 31
                }
            },
            '4': {
                start: {
                    line: 8,
                    column: 12
                },
                end: {
                    line: 8,
                    column: 28
                }
            },
            '5': {
                start: {
                    line: 9,
                    column: 12
                },
                end: {
                    line: 9,
                    column: 31
                }
            },
            '6': {
                start: {
                    line: 10,
                    column: 12
                },
                end: {
                    line: 10,
                    column: 60
                }
            },
            '7': {
                start: {
                    line: 14,
                    column: 12
                },
                end: {
                    line: 19,
                    column: 21
                }
            },
            '8': {
                start: {
                    line: 15,
                    column: 16
                },
                end: {
                    line: 18,
                    column: 17
                }
            },
            '9': {
                start: {
                    line: 16,
                    column: 20
                },
                end: {
                    line: 16,
                    column: 60
                }
            },
            '10': {
                start: {
                    line: 17,
                    column: 20
                },
                end: {
                    line: 17,
                    column: 44
                }
            },
            '11': {
                start: {
                    line: 20,
                    column: 12
                },
                end: {
                    line: 20,
                    column: 44
                }
            },
            '12': {
                start: {
                    line: 24,
                    column: 4
                },
                end: {
                    line: 32,
                    column: 11
                }
            }
        },
        fnMap: {
            '0': {
                name: '(anonymous_0)',
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
                        column: 52
                    },
                    end: {
                        line: 11,
                        column: 9
                    }
                },
                line: 4
            },
            '1': {
                name: '(anonymous_1)',
                decl: {
                    start: {
                        line: 13,
                        column: 8
                    },
                    end: {
                        line: 13,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 13,
                        column: 23
                    },
                    end: {
                        line: 21,
                        column: 9
                    }
                },
                line: 13
            },
            '2': {
                name: '(anonymous_2)',
                decl: {
                    start: {
                        line: 14,
                        column: 48
                    },
                    end: {
                        line: 14,
                        column: 49
                    }
                },
                loc: {
                    start: {
                        line: 14,
                        column: 67
                    },
                    end: {
                        line: 19,
                        column: 13
                    }
                },
                line: 14
            }
        },
        branchMap: {
            '0': {
                loc: {
                    start: {
                        line: 15,
                        column: 16
                    },
                    end: {
                        line: 18,
                        column: 17
                    }
                },
                type: 'if',
                locations: [{
                    start: {
                        line: 15,
                        column: 16
                    },
                    end: {
                        line: 18,
                        column: 17
                    }
                }, {
                    start: {
                        line: 15,
                        column: 16
                    },
                    end: {
                        line: 18,
                        column: 17
                    }
                }],
                line: 15
            },
            '1': {
                loc: {
                    start: {
                        line: 15,
                        column: 20
                    },
                    end: {
                        line: 15,
                        column: 87
                    }
                },
                type: 'binary-expr',
                locations: [{
                    start: {
                        line: 15,
                        column: 20
                    },
                    end: {
                        line: 15,
                        column: 50
                    }
                }, {
                    start: {
                        line: 15,
                        column: 54
                    },
                    end: {
                        line: 15,
                        column: 87
                    }
                }],
                line: 15
            }
        },
        s: {
            '0': 0,
            '1': 0,
            '2': 0,
            '3': 0,
            '4': 0,
            '5': 0,
            '6': 0,
            '7': 0,
            '8': 0,
            '9': 0,
            '10': 0,
            '11': 0,
            '12': 0
        },
        f: {
            '0': 0,
            '1': 0,
            '2': 0
        },
        b: {
            '0': [0, 0],
            '1': [0, 0]
        },
        _coverageSchema: '332fd63041d2c1bcb487cc26dd0d5f7d97098a6c'
    },
        coverage = global[gcv] || (global[gcv] = {});

    if (coverage[path] && coverage[path].hash === hash) {
        return coverage[path];
    }

    coverageData.hash = hash;
    return coverage[path] = coverageData;
}();

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

{
    ++cov_2d6q6k17c9.s[0];

    "use strict";

    var connectionController = function () {
        function connectionController($http, authProvider, $location) {
            _classCallCheck(this, connectionController);

            ++cov_2d6q6k17c9.f[0];
            ++cov_2d6q6k17c9.s[1];

            this._location = $location;
            ++cov_2d6q6k17c9.s[2];
            this._authProvider = authProvider;
            ++cov_2d6q6k17c9.s[3];
            this._http = $http;
            ++cov_2d6q6k17c9.s[4];
            this.login = '';
            ++cov_2d6q6k17c9.s[5];
            this.password = '';
            ++cov_2d6q6k17c9.s[6];
            this.authedUser = this._authProvider.authedUser;
        }

        _createClass(connectionController, [{
            key: 'authenticate',
            value: function authenticate() {
                ++cov_2d6q6k17c9.f[1];
                ++cov_2d6q6k17c9.s[7];

                this._authProvider.allUsers.forEach(function (element) {
                    ++cov_2d6q6k17c9.f[2];
                    ++cov_2d6q6k17c9.s[8];

                    if ((++cov_2d6q6k17c9.b[1][0], element.nickname == this.login) && (++cov_2d6q6k17c9.b[1][1], element.password == this.password)) {
                        ++cov_2d6q6k17c9.b[0][0];
                        ++cov_2d6q6k17c9.s[9];

                        this._authProvider.authedUser = element;
                        ++cov_2d6q6k17c9.s[10];
                        this._location.url("/");
                    } else {
                        ++cov_2d6q6k17c9.b[0][1];
                    }
                }, this);
                ++cov_2d6q6k17c9.s[11];
                this.login = this.password = '';
            }
        }]);

        return connectionController;
    }();

    ++cov_2d6q6k17c9.s[12];


    angular.module("app").component("connectionComponent", {
        controller: connectionController,
        controllerAs: "conCtrl",
        templateUrl: "app/components/connection/connection.component.html"
    });
}