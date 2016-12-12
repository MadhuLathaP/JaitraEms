app.service('modalService', function($http, $location, $rootScope) {
	var obj = {};
	// var data = this;
	var employeeData = {};
	var employee = {};

	var httpBaseUrl = baseUrl;

	obj.readAllEmployee = function() {
		httpReadAllEmployee = httpBaseUrl.concat("employee/readAll");

		return $http.get(httpReadAllEmployee)
	}

	
	obj.readEmployee = function(emp) {
		httpReadEmployee = httpBaseUrl.concat("employee/read");

		employeeData = $http.post(httpReadEmployee, emp);
	};

	
	obj.nav = function() {
		employeeData.then(function(response) {
			employee = response.data;

			if (employee.employeeId === "22") {
				$location.path('manager');
			} else if (employee.employeeId === "23") {
				$location.path('home');
			}

			else {
				$location.path('/manager.leaveSummary')
			}

		});
	}
	
	
	obj.getEmployee = function() {
		return employeeData;
	};
	return obj;
})