var module = angular.module('insuranceService', [ 'ngResource' ]);

module.factory('Applicant', function() {
	// /var newLeague = {};
	// //var allLeagues = {};
	var newApplicant = {};
	return {
		getApplicant : function() {
			return newApplicant;
		},

		setApplicant : function(applicant) {
			newApplicant = applicant;
		}
	};
});

module.factory('Property', function() {

	var newProperty = {};
	return {
		getProperty : function() {
			return newProperty;
		},

		setSetProperty : function(property) {
			newProperty = property;
		}
	};
});

module.factory('QuestionsApplicant', [ '$resource', function($resource) {


	var questRes = $resource("http://localhost:8080/insurance-web-app/rest/insurance/questionsByGroup", {}, {
		query : {
			method : "GET",
			isArray : false
		}
	});
	var questions = [];
	var questMappings = {};
	/*questRes.query(function(data) {

		// data.questions;
		angular.forEach(data.questions, function(iter) {

			//iter["answer"] = "";
			var answerType = iter["answerType"];
			//iter["answerType"] = mapping[answerType];
			if (iter.group == "Applicant") {
				questions.push(iter);
				questMappings[iter["mappedProperty"] ]= iter;
			}

		});
	});*/
	return {
		getQuestions : function() {
			return questions;
		},
		toApplicant: function(questions){
			
		},getQuestionMappings : function (){
			return questMappings;
			
		}
		

	};

} ]);