app.controller("leaveDetailCtrl", function($scope,$uibModalInstance) {

	$scope.tableHeader = [];

	$scope.tableHeader = [ "Leave Type", "From Date",
			"To Date", "Number of Days", "Reason"];

	$scope.leaveDetail = [ {
		'Id' : 13,
		'leaveType' : 'Sick',
		'fromDate' : '03-0-2016',
		'toDate' : '10-02-2016',
		'totalDays' : 5,
		'reason' : "dfsf"
	}, { 
		'Id' : 14,
		'leaveType' : 'Casual',
		'fromDate' : '13-06-2016',
		'toDate' : '15-06-2016',
		'totalDays' : 2,
		'reason' : "dfsf"
	} ];
	  $scope.ok = function () {
		    $uibModalInstance.close();
		  };
})