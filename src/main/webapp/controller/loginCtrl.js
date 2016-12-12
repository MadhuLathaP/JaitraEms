app.controller('loginCtlr', function($rootScope, $location, $scope, $uibModal,$http,modalService) {

	$scope.login_btn = false;
	var httpBaseUrl = baseUrl;
	$scope.employeeId = "";
	$scope.employee = {
		"employeeId" : "",
		firstName : "",
		lastName : "",
		dateOfBirth : "",
		dateOfJoining : "",
		email : "",
		address : ""
	};
	$scope.submit = function(employee) {
			modalService.readEmployee(employee);
			modalService.nav();

	};

});