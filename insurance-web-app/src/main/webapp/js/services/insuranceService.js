var module = angular.module('insuranceService', []);

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