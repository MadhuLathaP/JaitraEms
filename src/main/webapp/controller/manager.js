app.controller("managerCtrl", function($scope) {
	
	 //$scope.selectedTab = "1";
	 $scope.isSelectedTab = function(tempTab){
	  return $scope.selectedTab == tempTab;
	 }
	 
	 $scope.setSelectedTab = function(tempTab){
	  $scope.selectedTab = tempTab;
	 }
});