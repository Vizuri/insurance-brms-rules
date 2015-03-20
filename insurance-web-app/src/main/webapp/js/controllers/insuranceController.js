var applicantModule = angular.module('insuranceController', [ 'insuranceService' ]);

applicantModule
		.controller(
				'ApplicantEntryController',
				[
						'$scope',
						'$http',
						'$location',
						'Applicant',
						'QuestionsApplicant',
						function($scope, $http, $location, Applicant,
								QuestionsApplicant) {
	$scope.newApplicant = {};// Applicant.getApplicant();
	var mapping = {
		'String' : 'text',
		'IntegEer' : 'number',
		'Double' : 'number',
		"Boolean" : 'checkbox'

	};
	/*
	 * Questions.query(function(data) {
	 * 
	 * $scope.questions = [];//data.questions;
	 * angular.forEach(data.questions,function(iter){
	 * 
	 * iter["answer"] = ""; var answerType = iter["answerType"];
	 * iter["answerType"] = mapping[answerType]; if(iter.group == "Applicant"){
	 * $scope.questions.push(iter); }
	 * 
	 * 
	 * }); });
	 */

	$scope.questions = QuestionsApplicant.getQuestions();
	$scope.qmap = QuestionsApplicant.getQuestionMappings();
	$scope.fireSome = function() {
		console.log("applicantModule in fireSome");

		$http.post('http://localhost:8080/insurance-web-app/rest/insurance/createApplicant', $scope).success(function(data, status, headers, config) {
			console.log('success ');

			$location.path('/property');
		}).error(function(data, status, headers, config) {
			console.log('error ');
		});
		$location.path('/property');
	};

	$scope.changeHandle = function() {
		console.log("Inside changeHandle");
		console.log('$scope : ', this.newApplicant);
		$http.post('http://localhost:8080/insurance-web-app/rest/insurance/fireRulesApplicant', {
			'applicant':$scope.newApplicant,
			'questions'  : $scope.questions
			
		}).success(function(data, status, headers, config) {
			console.log('success data',data);
			$scope.newApplicant=data.applicant;
			var questions = [];
			var qmap = {};
			angular.forEach(data.questions, function(iter) {

				
				//var answerType = iter["answerType"];
				
				if (iter.group == "Applicant") {
					questions.push(iter);
					qmap[iter["mappedProperty"] ]= iter;
				}

			});
			
			$scope.questions = questions;
			$scope.qmap = qmap;	
			 $scope.refresh();
		}).error(function(data, status, headers, config) {
			console.log('error ');
		});
	};

} ]);

applicantModule.controller('PropertyEntryController', [ '$scope', '$http', '$location', 'Property', function($scope, $http, $location, Property) {

	$scope.newProperty = Property.getProperty();
	$scope.propui = creatPropertyUi();
	$scope.fireProperty = function() {
		console.log("PropertyEntryController in fireSome");

		/*
		 * $http.post('/insurance-web-app/rest/insurance/createProperty',
		 * $scope.newProperty).success(function(data, status, headers, config) {
		 * console.log('success '); $scope.newProperty = data;
		 * 
		 * }).error(function(data, status, headers, config) { console.log('error
		 * '); });
		 */

	};

	$scope.changeHandle = function() {
		console.log("Inside changeHandle");

		/*
		 * $http.post('/insurance-web-apprest/insurance/createProperty',
		 * $scope.newProperty).success(function(data, status, headers, config) {
		 * console.log('success '); $scope.newProperty = data;
		 * 
		 * }).error(function(data, status, headers, config) { console.log('error
		 * '); });
		 */
	};

} ]);