angular.module('app').run(['$templateCache', function($templateCache) {$templateCache.put('app/main.html','<div class="main-container">\r\n\r\n  <main class="main">\r\n\r\n\r\n    <div class="inner-block img-block left-align">\r\n      <img src="resources/images/hill_large.png">\r\n      <img src="resources/images/hill_large.png">\r\n      <img src="resources/images/hill_large.png">\r\n      <img src="resources/images/hill_large.png">\r\n      <img src="resources/images/hill_large.png">\r\n    </div>\r\n\r\n    <div class="inner-block">\r\n      <h2>Greetings player :)</h2>\r\n      <p>\r\n        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam porta sagittis dui, et mattis odio scelerisque vel. Mauris\r\n        ac dui dictum, iaculis eros sed, varius lorem. Etiam porta odio quis felis mattis cursus.\r\n      </p>\r\n    </div>\r\n\r\n    <div class="inner-block">\r\n      <h2>Presentation</h2>\r\n      <p>Aliquam non porta leo. Curabitur quis felis nec libero tempor rutrum vitae eu odio. Curabitur suscipit in odio vitae\r\n        gravida. Etiam venenatis nibh eu lectus commodo hendrerit. Proin at imperdiet nisl. Nulla facilisi. Phasellus suscipit,\r\n        urna a cursus rutrum, diam lectus condimentum felis, in gravida neque quam non purus. Suspendisse suscipit enim molestie\r\n        mauris maximus, a mattis tortor eleifend. Nunc sapien eros, vehicula in facilisis eu, placerat a dui.\r\n      </p>\r\n    </div>\r\n\r\n    <div class="inner-block img-block right-align">\r\n      <img src="resources/images/hud_spritesheet.png">\r\n    </div>\r\n\r\n\r\n    <div class="inner-block img-block left-align">\r\n      <img src="resources/images/tiles_spritesheet.png">\r\n    </div>\r\n\r\n    <div class="inner-block">\r\n      <h2>Technologies</h2>\r\n\r\n      <p>Aliquam non porta leo. Curabitur quis felis nec libero tempor rutrum vitae eu odio. Curabitur suscipit in odio vitae\r\n        gravida. Etiam venenatis nibh eu lectus commodo hendrerit. Proin at imperdiet nisl. Nulla facilisi. Phasellus suscipit,\r\n        urna a cursus rutrum, diam lectus condimentum felis, in gravida neque quam non purus. Suspendisse suscipit enim molestie\r\n        mauris maximus, a mattis tortor eleifend. Nunc sapien eros, vehicula in facilisis eu, placerat a dui. Mauris iaculis\r\n        condimentum tortor vel malesuada.\r\n      </p>\r\n    </div>\r\n\r\n\r\n  </main>\r\n</div>');
$templateCache.put('app/components/connected/connected.component.html','<p class="alert alert-success">You are connected</p>');
$templateCache.put('app/components/connection/connection.component.html','<div>\r\n    <h2>Connection to the website</h2>\r\n    <div ng-switch on="conCtrl.authedUser">\r\n        <div ng-switch-when="null">\r\n            <form class="form-inline form-vertical" name="formConnection" ng-submit="conCtrl.authenticate()">\r\n                <div class="form-group">\r\n\r\n                    <div class="input-group">\r\n                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>\r\n                        <input type="text" name="login" placeholder="Type your login" class="form-control" ng-model="conCtrl.login">\r\n                    </div>\r\n\r\n                    <div class="input-group">\r\n                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>\r\n                        <input type="password" name="password" placeholder="Type your password" class="form-control" ng-model="conCtrl.password">\r\n                    </div>\r\n                </div>\r\n                <button type="submit" class="btn btn-info">Sign up</button>\r\n            </form>\r\n        </div>\r\n\r\n        <div ng-switch-default>\r\n            <connected-component></connected-component>\r\n        </div>\r\n    </div>\r\n\r\n\r\n\r\n\r\n</div>');
$templateCache.put('app/components/connectionrequired/connectionrequired.component.html','<div>\r\n    <p class="alert alert-warning"> Please sign in and/or sign up to access this page</p>\r\n</div>');
$templateCache.put('app/components/download/download.component.html','<h2>Download</h2>\r\n\r\n\r\n<div class="row">\r\n    <div class="blockDL">\r\n        Download the game here :\r\n        <ul>\r\n            <li><a href="https://github.com/Gasshette/worms">On our GitHub repository</a>\r\n        </li></ul>\r\n    </div>\r\n\r\n    <div class="blockDL">\r\n        <img src="resources/images/download.png">\r\n    </div>\r\n</div>');
$templateCache.put('app/components/error/error.component.html','<p class="alert alert-warning">Error {{err.id}}</p>\r\n<!--<ui-view></ui-view> permet d\'int\xE9grer un enfant-->');
$templateCache.put('app/components/error404/error404.component.html','<div>\r\n    <p class="alert alert-danger"> An error occured while navigating on our website.</p>\r\n</div>');
$templateCache.put('app/components/footer/footer.component.html','<footer class="footer">\r\n    <div class="wide-content">\r\n        <div class="container footer-container">\r\n            Worms Project - Promo 2017 - Rodrigue Mullier, Louis Duchateau, Quentin Grisel, Damien Kesteloot\r\n        </div>\r\n    </div>\r\n</footer>');
$templateCache.put('app/components/globalview/progressbar.html','<div id="progressbar" class="progress">\r\n    <div>{{percent}}</div>\r\n</div>');
$templateCache.put('app/components/header/header.component.html','<div class="header-container">\r\n    <header class="header">\r\n        <div class="jumbotron">\r\n\r\n            <div class="cloud">\r\n                <div class="fat-cloud">\r\n                    <img src="resources/images/cloud.png">\r\n\r\n                    <div class="small-cloud">\r\n                        <img src="resources/images/cloud.png">\r\n                    </div>\r\n\r\n                </div>\r\n            </div>\r\n\r\n\r\n            <!--<div class="cloud fat-cloud"><img src="resources/images/cloud.png"></div>-->\r\n\r\n\r\n\r\n\r\n\r\n            <div class="container">\r\n                <h1>Worms Project</h1>\r\n                <h2>A small multiplayer game done with all our heart content <span class="glyphicon glyphicon-heart text-danger"></span></h2>\r\n            </div>\r\n        </div>\r\n    </header>\r\n</div>');
$templateCache.put('app/components/menu/menu.component.html','<nav class="navbar navbar-default navbar-static-top">\r\n    <div class="container-fluid">\r\n        <div class="container">\r\n            <div class="navbar-header">\r\n                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">\r\n              <span class="sr-only">Toggle navigation</span>\r\n              <span class="icon-bar"></span>\r\n              <span class="icon-bar"></span>\r\n              <span class="icon-bar"></span>\r\n            </button>\r\n                <a class="navbar-brand" ui-sref="accueil" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)"><span class="glyphicon glyphicon-home"></span></a>\r\n            </div>\r\n            <div id="navbar" class="navbar-collapse collapse in" aria-expanded="false">\r\n                <ul class="nav navbar-nav">\r\n                    <li>\r\n                        <a ui-sref="profile" ui-sref-active="active" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)">Profile</a>\r\n                    </li>\r\n                    <li>\r\n                        <a ui-sref="score" ui-sref-active="active" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)">Score</a>\r\n                    </li>\r\n                    <li>\r\n                        <a ui-sref="download" ui-sref-active="active" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)">Download the game</a>\r\n                    </li>\r\n                </ul>\r\n                <div ng-switch on="mc.logged">\r\n\r\n                <ul class="nav navbar-nav navbar-right" ng-switch-when="true">\r\n                    <li>\r\n                        <a ui-sref="accueil" ui-sref-active="active" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)" ng-click="mc.disconnect()">Disconnect</a>\r\n                    </li>\r\n                </ul>\r\n\r\n                <ul class="nav navbar-nav navbar-right" ng-switch-when="false">\r\n                    <li>\r\n                        <a ui-sref="signIn" ui-sref-active="active" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)">Sign-in</a>\r\n                    </li>\r\n                    <li>\r\n                        <a ui-sref="connection" ui-sref-active="active" ng-mouseover="mc.changeColor($event)" ng-mouseleave="mc.resetColor($event)">Sign-up</a>\r\n                    </li>\r\n                </ul>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</nav>');
$templateCache.put('app/components/menu/score.component.html','<h2>Score table</h2>\r\n\r\n<label class="switch">\r\n  <input type="checkbox">\r\n  <div class="slider round"></div>\r\n</label>\r\n\r\n<table class="table table-stripped" ng-repeat="u in ScCtrl.listUsers | orderBy : \'-level\'">\r\n    <caption>\r\n        <h3>{{u.nickname}} <br>  N\xB0 {{$index+1}}</h3>\r\n    </caption>\r\n\r\n    <tr>\r\n        <td rowspan="4"><img src="../resources/images/player.png"></td>\r\n        <td colspan="2">Level : {{u.level}}<br>\r\n            <progress-bar-score percent="{{u.exp}}"></progress-bar-score>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n\r\n    </tr>\r\n    <tr>\r\n        <td><img src="../resources/images/coin.png"></td>\r\n        <td>{{u.gold}} gold</td>\r\n    </tr>\r\n    <tr>\r\n        <td><img src="../resources/images/gemBlue.png"></td>\r\n        <td>{{(u.gem > 1) ? u.gem + \' gems\' : u.gem + \' gem\' }}</td>\r\n    </tr>\r\n</table>');
$templateCache.put('app/components/profile/profile.component.html','<div class="profile-component">\r\n    <div ng-switch on="PrCtrl.authedUser">\r\n        <h2>Profile</h2>\r\n\r\n        <div ng-switch-when="null">\r\n            <connection-required-component></connection-required-component>\r\n        </div>\r\n\r\n\r\n        <div ng-switch-default>\r\n\r\n            <table class="table table-stripped">\r\n                <caption>\r\n                    <h4>{{PrCtrl.authedUser.nickname}}</h4>\r\n                </caption>\r\n                <tr>\r\n                    <td rowspan="4"><img src="../resources/images/player.png"></td>\r\n                    <td colspan="2">Level : {{PrCtrl.authedUser.level}}<br>\r\n                        <progress-bar percent="$index"></progress-bar>\r\n                    </td>\r\n                </tr>\r\n                <tr>\r\n                    <td><img src="../resources/images/coin.png"></td>\r\n                    <td>{{PrCtrl.authedUser.gold}} gold</td>\r\n                </tr>\r\n                <tr>\r\n                    <td><img src="../resources/images/gemBlue.png"></td>\r\n                    <td>{{(PrCtrl.authedUser.gem > 1) ? PrCtrl.authedUser.gem + \' gems\' : PrCtrl.authedUser.gem + \' gem\' }}</td>\r\n                </tr>\r\n            </table>\r\n        </div>\r\n    </div>\r\n\r\n</div>');
$templateCache.put('app/components/score/score.component.html','<div class="temp-score">\r\n\r\n    <h2>Ladder</h2>\r\n\r\n    <div class="switch-component">\r\n        <div class="render">\r\n            <label class="switch">\r\n                <input type="checkbox" ng-click="ScCtrl.switchView()">\r\n                <div class="slider round"></div>\r\n            </label>\r\n        </div>\r\n        <div class="render">\r\n            {{ScCtrl.currentView}}\r\n        </div>\r\n    </div>\r\n\r\n    <div class="normal">\r\n        <table class="table table-stripped" ng-repeat="u in ScCtrl.listUsers | orderBy : \'-level\'">\r\n            <caption>\r\n                <h4>{{u.nickname}} - N\xB0 {{$index+1}}</h4>\r\n            </caption>\r\n\r\n            <tr>\r\n                <td rowspan="4"><img src="../resources/images/player.png"></td>\r\n                <td colspan="2">Level : {{u.level}}<br>\r\n                    <progress-bar-score percent="{{u.exp}}"></progress-bar-score>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n\r\n            </tr>\r\n            <tr>\r\n                <td><img src="../resources/images/coin.png"></td>\r\n                <td>{{u.gold}} gold</td>\r\n            </tr>\r\n            <tr>\r\n                <td><img src="../resources/images/gemBlue.png"></td>\r\n                <td>{{(u.gem > 1) ? u.gem + \' gems\' : u.gem + \' gem\' }}</td>\r\n            </tr>\r\n        </table>\r\n    </div>\r\n\r\n    <div class="compact">\r\n        <table class="table table-stripped">\r\n            <header>\r\n                <tr>\r\n                    <td>Rank</td>\r\n                    <td>Nickname</td>\r\n                    <td>Level</td>\r\n                    <td>Progression</td>\r\n                    <td><img src="../resources/images/coin.png"></td>\r\n                    <td><img src="../resources/images/gemBlue.png"></td>\r\n                </tr>\r\n            </header>\r\n            <tr ng-repeat="u in ScCtrl.listUsers | orderBy : \'-level\'">\r\n                <td>{{$index+1}}</td>\r\n                <td>{{u.nickname}}</td>\r\n                <td>{{u.level}}</td>\r\n                <td>\r\n                    <progress-bar-score percent="{{u.exp}}"></progress-bar-score>\r\n                </td>\r\n                <td>{{u.gold}} gold</td>\r\n                <td>{{(u.gem > 1) ? u.gem + \' gems\' : u.gem + \' gem\' }}</td>\r\n            </tr>\r\n        </table>\r\n    </div>\r\n\r\n</div>');
$templateCache.put('app/components/sign-in/sign-in.component.html','<div>\r\n    <h2>Sign in and create your account</h2>\r\n    <div ng-switch on="SICtrl.authedUser">\r\n\r\n        <div ng-switch-when="null">\r\n            <form name="formInscription" class="form-inline" ng-submit="SICtrl.signIn()">\r\n                <div class="form-group">\r\n\r\n                    <div class="input-group">\r\n                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>\r\n                        <input type="text" name="login" placeholder="Type your login" class="form-control" ng-model="SICtrl.login">\r\n                    </div>\r\n\r\n                    <div class="input-group">\r\n                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>\r\n                        <input type="password" name="password" placeholder="Type your password" class="form-control" ng-model="SICtrl.password">\r\n                    </div>\r\n                </div>\r\n                <button type="submit" class="btn btn-info">Sign in</button>\r\n            </form>\r\n        </div>\r\n\r\n        <div ng-switch-default>\r\n            <connected-component></connected-component>\r\n        </div>\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n');}]);