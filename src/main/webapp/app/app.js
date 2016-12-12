var app = angular.module('myApp', [ 'ui.router', 'ui.bootstrap' ]);

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {

	// $urlRouterProvider.otherwise("/login");

	$stateProvider.state('Login', {
		url : '/login',
		templateUrl : 'html/login.html',
		controller : 'loginCtlr'
	}).state('manager', {
		url : '/manager',
		templateUrl : 'html/manager.html',
		controller : 'managerCtrl'
	}).state('manager.home', {
		url : '/home',
		templateUrl : 'html/home.html',
		controller : 'homeCtrl'
	}).state('manager.editEmployee', {
		url : '/edit',
		templateUrl : 'html/edit.html',
		controller : 'editCtrl'
	}).state('applyleave', {
		url : '/applyleave',
		templateUrl : 'html/applyLeave.html',
		controller : 'applyLeaveCtrl'
	}).state('manager.leaveSummary', {
		url : '/leaveSummary',
		templateUrl : 'html/leaveSummary.html',
		controller : 'leaveSummaryCtrl'
	})
	/*
	 * .state('leaveDetail', { url : '/leaveDetail', templateUrl :
	 * 'html/leaveDetail.html', controller : 'leaveDetailCtrl' })
	 */
})

/*
 * var app = angular.module('myApp', [ 'ngRoute' ]);
 * 
 * app.config([ '$routeProvider', function($routeProvider) {
 * $routeProvider.when('/home', { title : 'Employee', templateUrl :
 * 'html/home.html', controller : 'homeCtrl' }).when('/edit', { title : 'Edit
 * Employee', templateUrl : 'html/edit.html', controller : 'editCtrl'
 * }).when('/apply', { title : 'Apply Leave', templateUrl :
 * 'html/applyLeave.html', controller : 'applyLeaveCtrl'
 * }).when('/leaveSummary/:id', { title : 'Leave Summary', templateUrl :
 * 'html/leaveSummary.html', controller : 'leaveSummaryCtrl'
 * }).when('/leaveDetail', { title : 'Leave Detail', templateUrl :
 * 'html/leaveDetail.html', controller : 'leaveDetailCtrl' }).otherwise({
 * redirectTo : '/home' }); } ]);
 */
/*
 * app.run(['$location', '$rootScope', function($location, $rootScope) {
 * $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
 * $rootScope.title = current.$$route.title; }); }]);
 */