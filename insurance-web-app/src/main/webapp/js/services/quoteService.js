var module = angular.module('quoteService', [ 'ngResource' ]);



module.factory('QuoteWrapper', function($resource) {
	
	//return $resource("http://localhost:8080/insurance-web-app/rest/quoteService",{});

	
	var questRes = $resource("http://localhost:8080/insurance-web-app/rest/quoteService/:controller",
	{
		controller : "@controller"
	}, {
		query : {
			method : "GET",
			isArray : false
		},
		save : {
			
			method : "POST",
			isArray : false
		},
		checkEligibility :{
			method : "POST",
			isArray : false,
			params : {controller : "eligibility"}
			
			
		},
		quoteCalculate :{
			method : "POST",
			isArray : false,
			params : {controller : "quoteCalculate"}
			
			
		}
	});

	
	return questRes;
	
});





