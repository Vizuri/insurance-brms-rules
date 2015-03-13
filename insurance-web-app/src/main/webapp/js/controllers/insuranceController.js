var applicantModule = angular.module('insuranceController', [ 'insuranceService' ]);

applicantModule.controller('ApplicantEntryController', [ '$scope', '$http', '$location', 'Applicant', function($scope, $http, $location, Applicant) {
	$scope.newApplicant = Applicant.getApplicant();
	$scope.fireSome = function() {
		console.log("applicantModule in fireSome");

		$http.post('rest/insurance/createApplicant', $scope.newApplicant).success(function(data, status, headers, config) {
			console.log('success ');
			$scope.newApplicant = data;
			$location.path('/property');
		}).error(function(data, status, headers, config) {
			console.log('error ');
		});

	};

} ]);

var creatPropertyUi = function() {

	var propertyUiMeta = [ {
		"name" : "policyBeginDate",
		"type" : "text",
		"value" : "",
		"placeHolder" : "Enter Policy Begin Date",
		"required":true,
		//"pattern" : "^\d{2}\\/\d{2}\\/\\d{4}$"
	}, {
		"name" : "purchaseDate",
		"type" : "list",
		"value" : "",
		"placeHolder" : "Enter Purchase Date",
		"selectValues" : [ undefined, "today", "yesterday" ],
		"required":true,
		//"pattern" : "^\d{2}\\/\d{2}\\/\\d{4}$"
	}, {
		"name" : "previousClaims",
		"type" : "radio",
		"value" : "",
		"placeHolder" : "Previous Claims",
		"required":true,
		"selectValues" : [ "true", "false" ]
	},
	
	];

	return propertyUiMeta;
};

applicantModule.controller('PropertyEntryController', [ '$scope', '$http', '$location', 'Property', function($scope, $http, $location, Property) {

	$scope.newProperty = Property.getProperty();
	$scope.propui = creatPropertyUi();
	$scope.fireProperty = function() {
		console.log("PropertyEntryController in fireSome");
	
		$http.post('rest/insurance/createProperty', $scope.newProperty).success(function(data, status, headers, config) {
			console.log('success ');
			$scope.newProperty = data;

		}).error(function(data, status, headers, config) {
			console.log('error ');
		});

	};

	$scope.changeHandle = function() {
		console.log("Inside changeHandle");

		$http.post('rest/insurance/createProperty', $scope.newProperty).success(function(data, status, headers, config) {
			console.log('success ');
			$scope.newProperty = data;

		}).error(function(data, status, headers, config) {
			console.log('error ');
		});
	};

} ]);