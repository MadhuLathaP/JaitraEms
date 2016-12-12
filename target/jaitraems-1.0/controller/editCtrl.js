app.controller('editCtrl', function($scope, $rootScope, $location, $http
		) {

	var httpBaseUrl = baseUrl;
	
	$scope.add = true;
	$scope.update = false;
	
	
	$scope.employee = {
		employeeId : "",
		firstName : "",
		lastName : "",
		dateOfBirth : "",
		dateOfJoining : "",
		email : "",
		address : ""
	}
	$scope.employeeData=[];

	$scope.addEmployee = function(employee) {
		httpCreateEmployee = httpBaseUrl.concat("employee/create");

		$http.post(httpCreateEmployee, employee).success(
				function(response) {
			        $location.path('manager');
				});
	}
	
	
	$scope.editEmployee = function(emp){
		$scope.employee = emp;
	}
});

/*
 * $scope.addRow = function() { $scope.employee.push({ 'Employee ID' :
 * $scope.empId, 'First Name' : $scope.fname, 'Last Name' : $scope.lname, 'Date
 * Of Birth' : $scope.dob, 'Date of Joinig' : $scope.doj, 'email' :
 * $scope.email, 'address' : $scope.address }); };
 */

