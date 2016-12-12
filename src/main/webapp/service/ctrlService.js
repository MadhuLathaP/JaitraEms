app.service('ctrlService',function(){
	var obj={};
	// var data = this;
	var employeeData={};

	obj.setEmployeeData = function(emp){
		employeeData = emp;
	}
	obj.getEmployeeData = function(){
		return employeeData;
	};
	return obj;
})