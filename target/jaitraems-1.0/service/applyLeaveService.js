app.service('applyLeaveService', function($http, $location, $rootScope) {
	var obj = {};

	var httpBaseUrl = baseUrl;

	obj.applyLeave = function(leaveData) {
		httpapplyLeave = httpBaseUrl.concat("leavedetail/create");

		return $http.post(httpapplyLeave,leaveData)
	}

	
	return obj;
})