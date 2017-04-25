"use strict";

var cov_i2ozap5s = function () {
    var path = "C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\services\\history.service.js",
        hash = "8330989c4a0ed6efc271e8b63cf9b1dfdf996450",
        global = new Function('return this')(),
        gcv = "__coverage__",
        coverageData = {
        path: "C:\\Users\\Quentin\\Documents\\github\\worms\\FrontEnd\\src\\app\\services\\history.service.js",
        statementMap: {
            "0": {
                start: {
                    line: 4,
                    column: 12
                },
                end: {
                    line: 4,
                    column: 36
                }
            },
            "1": {
                start: {
                    line: 8,
                    column: 12
                },
                end: {
                    line: 8,
                    column: 38
                }
            },
            "2": {
                start: {
                    line: 11,
                    column: 12
                },
                end: {
                    line: 11,
                    column: 42
                }
            },
            "3": {
                start: {
                    line: 12,
                    column: 23
                },
                end: {
                    line: 12,
                    column: 35
                }
            },
            "4": {
                start: {
                    line: 13,
                    column: 12
                },
                end: {
                    line: 13,
                    column: 44
                }
            },
            "5": {
                start: {
                    line: 17,
                    column: 23
                },
                end: {
                    line: 17,
                    column: 35
                }
            },
            "6": {
                start: {
                    line: 18,
                    column: 12
                },
                end: {
                    line: 18,
                    column: 44
                }
            },
            "7": {
                start: {
                    line: 22,
                    column: 23
                },
                end: {
                    line: 22,
                    column: 35
                }
            },
            "8": {
                start: {
                    line: 23,
                    column: 12
                },
                end: {
                    line: 23,
                    column: 46
                }
            },
            "9": {
                start: {
                    line: 28,
                    column: 4
                },
                end: {
                    line: 30,
                    column: 37
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
                        column: 22
                    },
                    end: {
                        line: 5,
                        column: 9
                    }
                },
                line: 3
            },
            "1": {
                name: "(anonymous_1)",
                decl: {
                    start: {
                        line: 7,
                        column: 8
                    },
                    end: {
                        line: 7,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 7,
                        column: 19
                    },
                    end: {
                        line: 9,
                        column: 9
                    }
                },
                line: 7
            },
            "2": {
                name: "(anonymous_2)",
                decl: {
                    start: {
                        line: 10,
                        column: 8
                    },
                    end: {
                        line: 10,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 10,
                        column: 30
                    },
                    end: {
                        line: 14,
                        column: 9
                    }
                },
                line: 10
            },
            "3": {
                name: "(anonymous_3)",
                decl: {
                    start: {
                        line: 16,
                        column: 8
                    },
                    end: {
                        line: 16,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 16,
                        column: 32
                    },
                    end: {
                        line: 19,
                        column: 9
                    }
                },
                line: 16
            },
            "4": {
                name: "(anonymous_4)",
                decl: {
                    start: {
                        line: 21,
                        column: 8
                    },
                    end: {
                        line: 21,
                        column: 9
                    }
                },
                loc: {
                    start: {
                        line: 21,
                        column: 39
                    },
                    end: {
                        line: 24,
                        column: 9
                    }
                },
                line: 21
            }
        },
        branchMap: {},
        s: {
            "0": 0,
            "1": 0,
            "2": 0,
            "3": 0,
            "4": 0,
            "5": 0,
            "6": 0,
            "7": 0,
            "8": 0,
            "9": 0
        },
        f: {
            "0": 0,
            "1": 0,
            "2": 0,
            "3": 0,
            "4": 0
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

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

{
    var History = function () {
        function History() {
            _classCallCheck(this, History);

            ++cov_i2ozap5s.f[0];
            ++cov_i2ozap5s.s[0];

            this.requestBuffer = {};
        }

        _createClass(History, [{
            key: "getBuffer",
            value: function getBuffer() {
                ++cov_i2ozap5s.f[1];
                ++cov_i2ozap5s.s[1];

                return this.requestBuffer;
            }
        }, {
            key: "getResult",
            value: function getResult(date, titre) {
                ++cov_i2ozap5s.f[2];
                ++cov_i2ozap5s.s[2];

                console.log(this.getBuffer());
                var hash = (++cov_i2ozap5s.s[3], date + titre);
                ++cov_i2ozap5s.s[4];
                return this.requestBuffer[hash];
            }
        }, {
            key: "setRequest",
            value: function setRequest(date, titre) {
                ++cov_i2ozap5s.f[3];

                var hash = (++cov_i2ozap5s.s[5], date + titre);
                ++cov_i2ozap5s.s[6];
                this.requestBuffer[hash] = null;
            }
        }, {
            key: "setResult",
            value: function setResult(date, titre, result) {
                ++cov_i2ozap5s.f[4];

                var hash = (++cov_i2ozap5s.s[7], date + titre);
                ++cov_i2ozap5s.s[8];
                this.requestBuffer[hash] = result;
            }
        }]);

        return History;
    }();

    ++cov_i2ozap5s.s[9];


    angular.module("app").service('history', History);
}