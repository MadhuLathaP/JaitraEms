app.controller('applyLeaveCtrl',function($scope,$uibModalInstance){
	
	$scope.leaveType = ["Leave Type","Sick","Casual"];
	
	$scope.cancel=function(){
		$uibModalInstance.dismiss('cancel');
	}
/*	$scope.apply = function(data){
		applyLeaveService.applyLeave(data);
	}*/
})


/*	$scope.apply = function(employee){
		httpApplyLeave = httpBaseUrl.concat("leavedetail/create");
		$http.post(httpApplyLeave, employee).success(function(response){
			
		})
	}*/