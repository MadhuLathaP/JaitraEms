app.controller("homeCtrl", function($scope, $rootScope, $location, $uibModal, $http,modalService,ctrlService) {

	$scope.homeScreen = true;
	$scope.hidden = false;
	$scope.editData = false;
	$scope.leaveSummary = false;

	
	$scope.tableHeader = [];
	$scope.employeelist = [];

	
	var httpBaseUrl = baseUrl;
	
	$scope.employee = {
		employeeId : "",
		firstName : "",
		lastName : "",
		dateOfBirth : "",
		dateOfJoining : "",
		email : "",
		address : ""
	}

	
	$scope.tableHeader = ["Employee ID", "First Name", /*"Last Name",*/
			"Date of Birth", "Date of Joining", "Email", "Address", "" ];

	$scope.readAllEmployee = function()
	{
		modalService.readAllEmployee().then(function(response) {
			$scope.employeelist = response.data;
		});		
	}


	$scope.deleteEmployee = function(employee) {
		httpDeleteEmployee = httpBaseUrl.concat("employee/delete");

		$http.post(httpDeleteEmployee, employee).success(function(response) {

			$scope.readAllEmployee();
		});
	}
	
	
	$scope.updateEmployee = function(employee) {
		httpUpdateEmployee = httpBaseUrl.concat("employee/update");

		$http.post(httpUpdateEmployee, employee).success(function(response) {
				
			$scope.readAllEmployee();

		});
	}

	
	/*------------------- Leave Summary --------------------*/
	
	$scope.leaveTableHeader = [];

	$scope.leaveSummarydata = [];
	
/*	$scope.leaveTableHeader = [ "Casual Leave", "Sick Leave",
			"Sick Leave Used", "Casual Leave Used", "Total Leave Used",
			"Remaining Leaves" ];*/
	

	$scope.leavesummary = function(emp) {
		//$scope.employee = emp;
		//modalService.readEmployee(emp);
		ctrlService.setEmployeeData(emp);
		$scope.homeScreen = false;
		$scope.leaveSummary = true;
		
	}


	$scope.showHide = function (emp){
/*		$scope.show = false;
		$scope.hidden = true;*/
		$location.path('leaveSummary');
	}
	
	$scope.back = function(){
		//$location.path("/home");
		$scope.homeScreen = true;
		$scope.leaveSummary = false;
		$scope.editData = false;
	}
	
		
	/*------------------- Leave Details -------------------*/

	$scope.leaveDetails = function(){
		var modalInstance = $uibModal.open({
			templateUrl : 'html/leaveDetail.html',
			controller : 'leaveDetailCtrl'
				

				});
	}
	
		
	/*------------------- Edit -------------------*/
	
	$scope.edit = function(){
		$scope.editData = true;
		$scope.homeScreen = false;
	}
	
	$scope.add = true;
	$scope.update = false;
	$scope.editEmployee = function(emp){
		$scope.employee = emp;
		$scope.add = false;
		$scope.update = true;
	}
	
});













/*	$scope.leaveSummary = {
"leaveSummaryid" : "1",
"empId" : "",
"casualLeave" : "",
sickLeave : "",
casualLeaveUsed :"" ,
sickLeaveUsed : "",
totalLeaveUsed : "",
remainingLeaves : ""
} */

