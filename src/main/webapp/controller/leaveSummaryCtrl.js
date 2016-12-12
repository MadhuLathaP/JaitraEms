app.controller("leaveSummaryCtrl", function($scope, $http, $uibModal,
		$location, $rootScope, modalService, ctrlService) {

	$scope.leaveTableHeader = [];

	$scope.leaveTableHeader = [ "Casual Leave", "Sick Leave",
			"Sick Leave Used", "Casual Leave Used", "Total Leave Used",
			"Remaining Leaves", "" ];

	$scope.leaveSummarydata = [ {
		'Id' : 13,
		'casualLeave' : 15,
		'sickLeave' : 5,
		'casualLeaveUsed' : 3,
		'sickLeaveUsed' : 2,
		'totalLeaveUsed' : 5,
		'remainingLeaves' : 20
	} ];

	$scope.readEmployee = function() {
		$scope.employee = ctrlService.getEmployeeData();
		
/*		modalService.getEmployee().then(function(response) {
		
		$scope.employee = response.data;
		
		});*/
	}

	/*------------------ Apply leave popup ----------------------*/
	$scope.applyLeave = function() {
		var uibModalInstance = $uibModal.open({
			templateUrl : 'html/applyLeave.html',
			controller : 'applyLeaveCtrl',
			scope : $scope
		});
	}

	/*------------------ leave details popup ----------------------*/
	$scope.leaveDetails = function() {
		var modalInstance = $uibModal.open({
			templateUrl : 'html/leaveDetail.html',
			controller : 'leaveDetailCtrl'

		});
	}

})
