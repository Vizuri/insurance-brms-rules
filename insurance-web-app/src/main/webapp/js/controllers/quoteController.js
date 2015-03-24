var quoteModdule = angular.module('quoteController', [ 'quoteService' ]);

QuoteStatus = {
	"FORM_INCOMPLETE" : "FORM_INCOMPLETE",
	"NEED_ELIGIBILITY_CHECK" : "NEED_ELIGIBILITY_CHECK",
	"ELIBIBILITY_COMPLETE" : "ELIBIBILITY_COMPLETE",
	"QUOTE_VALID_WITH_PRICE" : "QUOTE_VALID_WITH_PRICE"

}

function initScopeVars($scope) {

	$scope.QuoteStatus = QuoteStatus;
	$scope.wrapper = {};
	$scope.newApplicant = {};
	$scope.qmap = {};
	$scope.templates = 'partials/applicant.html';
	// $scope.propertyMap = {};
	$scope.newProperty = {};
	$scope.templatesApplicant = 'partials/applicant.html';
	$scope.templatesProperty = 'partials/property.html';
	$scope.quoteStatus = QuoteStatus.FORM_INCOMPLETE;
	// html input elements that fired
	$scope.currentSource = undefined;
}

function convertToDate(obj){
			var dt = obj;
			if(dt == undefined){
				return;
			}
			var date = new Date(dt);
			return date;
	
}


function copyQuoteDataToScope($scope, data) {
	console.log('inside copyQuoteDataToScope');
	$scope.wrapper = data;
	$scope.newApplicant = data.applicant;
	$scope.newProperty = data.property;
	$scope.qmap = data.applicantQuestMap;
	// $scope.propertyMap = data.propertyQuestMap;
	console.log('newApplicant', $scope.newApplicant);
	console.log('qMap', $scope.qMap);
	console.log('newProperty', $scope.newProperty);

	
	Try.these( function (){
			$scope.newProperty.policyBeginDate =convertToDate($scope.newProperty.policyBeginDate)
		} );
	Try.these( function (){
		$scope.newProperty.purchaseDate =convertToDate($scope.newProperty.purchaseDate)
	} );
	
	angular.forEach($scope.newProperty, function (val,key){
	//	var it = iter;
		//console.log('key,value',key+","+val);
		
		if("0" == val || 0 == val){
			$scope.newProperty[key] = undefined;
			
		}
		
		//console.log('key,value',key+","+$scope.newProperty[key]);
		
		
	});

}

quoteModdule
		.controller(
				'QuoteEntryController',
				[
						'$scope',
						'$http',
						'$location',
						'QuoteWrapper',
						'$filter',
						function($scope, $http, $location, QuoteWrapper,$filter) {

							initScopeVars($scope);
								
							/**/QuoteWrapper.query(function(data) {
								console.log("data : ", data);

								copyQuoteDataToScope($scope, data);
								$scope.addClaimRow();

							});

							$scope.hideField = function() {
								console.log("hideField");
								$scope.newApplicant.filedForBankruptcy = false;
								$scope.qmap.filedForBankruptcy.enabled = false;
								console
										.log("$scope.qmap.filedForBankruptcy.enabled  : "
												+ $scope.qmap.filedForBankruptcy.enabled);

							};
							$scope.changeHandle = function() {
								console.log('hello');
								
								$scope.quoteStatus = QuoteStatus.FORM_INCOMPLETE;
								
								Try.these( function (){
										$scope.currentSource = window.event.srcElement.id;
									});
								
								try{
									if(window.event.srcElement != undefined){
										var val = window.event.srcElement.value;
										var strVal = val.toString();
										if(strVal.isEmpty()){
											console.log('change event not happening empty value');
											return;
										}
									}
								}catch(err){
									
								}
								
								
								console.log("event source : "+$scope.currentSource.id);
								console.log("ageOfRoof :",$scope.newProperty.ageOfRoof);

								QuoteWrapper
										.save(
												$scope.wrapper,
												function(data) {

													// mark success on the
													// registration form
													$scope.successMessages = [ 'Member Registered' ];

													copyQuoteDataToScope(
															$scope, data);

													console
															.log(
																	'newApplicant',
																	$scope.newApplicant);
													console.log('newProperty',
															$scope.newProperty);
													console.log('qmap',
															$scope.qmap);
													$scope.wrapper.property.status = "";
													$scope.wrapper.quote = {};
													$scope.addClaimRow();
													$scope.addDogs();
													if ($scope.mainForm.$valid) {
														$scope.quoteStatus = QuoteStatus.NEED_ELIGIBILITY_CHECK;
													} else {

														$scope.quoteStatus = QuoteStatus.FORM_INCOMPLETE;
													}
													$scope.currentSource = undefined;
												},
												function(result) {
													if ((result.status == 409)
															|| (result.status == 400)) {
														$scope.errors = result.data;
													} else {
														$scope.errorMessages = [ 'Unknown  server error' ];
													}
												});
								console.log('in change');
							};

							$scope.goToPropery = function() {

								// $location.path('/property');
								$scope.templates = 'partials/property.html';
							};
							$scope.goToApplication = function() {

								// $location.path('/applicant');
								$scope.templates = 'partials/applicant.html';
							};

							$scope.getEligibility = function() {
								$scope.wrapper.property.status = "";
								QuoteWrapper
										.checkEligibility(
												$scope.wrapper,
												function(data) {
													copyQuoteDataToScope($scope, data);
													$scope.newProperty.status = $scope.newProperty.status == undefined ? "" : $scope.newProperty.status;
													if ($scope.mainForm.$valid && $scope.newProperty.status.isEmpty()) {
														$scope.quoteStatus = QuoteStatus.ELIBIBILITY_COMPLETE;
													}
												},
												function(result) {
													if ((result.status == 409)
															|| (result.status == 400)) {
														$scope.errors = result.data;
													} else {
														$scope.errorMessages = [ 'Unknown  server error' ];
													}
												});
							};

							// questRes
							// quoteCalculate
							$scope.quoteCalculate = function() {
								QuoteWrapper
										.quoteCalculate(
												$scope.wrapper,
												function(data) {
													copyQuoteDataToScope($scope, data);
													
												},
												function(result) {
													if ((result.status == 409)
															|| (result.status == 400)) {
														$scope.errors = result.data;
													} else {
														$scope.errorMessages = [ 'Unknown  server error' ];
													}
												});

							}
							// qmap['p.previousClaims'].enabled == true
							$scope.addClaimRow = function(source) {
								
								console.log('$scope.newProperty.claims',	$scope.newProperty.claims);

								var claimRowRequired = $scope.newProperty.previousClaims === true
										&& $scope.qmap['p.claimDate'].enabled === true
										&& $scope.qmap['p.claimAmount'].enabled === true;
								
								if (!claimRowRequired) {
									$scope.newProperty.claims = [];
									return;
								}

								if ($scope.newProperty.claims == undefined	|| $scope.newProperty.claims.length == 0) {
									$scope.newProperty.claims = [];

									$scope.newProperty.claims.push({
										"claimDate" : null,
										"claimAmount" : null
									});
								} else {
									
									if('add' == source){
										var claim = $scope.newProperty.claims[$scope.newProperty.claims.length - 1];
										$scope.newProperty.claims.push({
											"claimDate" : "",
											"claimAmount" : ""
										});
										/*if (claim.claimDate && claim.claimAmount && !claim.claimDate.toString()	.isEmpty() && !claim.claimAmount.toString()	.isEmpty()) {
										
										}*/
									}


								}
								
								for(var idx = 0 ;idx < $scope.newProperty.claims.length; idx++){
									var cl = $scope.newProperty.claims[idx];
									try{
										cl.claimDate = convertToDate(cl.claimDate);
									}catch(err){
										console.error(err);
									}
									
									
								}

							};

							$scope.deleteClaimRow = function($index) {

								if ($scope.newProperty.claims.length > 0) {
									$scope.newProperty.claims.splice($index, 1);
								}

							}

							$scope.dogList = [];
							$scope.addDogs = function(source) {
								if(!'dogExists' == $scope.currentSource  || !'add' == source){
									return;
								}
								if ($scope.qmap['p.dogs'].enabled === false) {
									$scope.dogList = [];
									return;

								}

								$scope.dogList.push({
									"dogType" : ""
								})

							}

							$scope.deleteDogs = function() {
								$scope.dogList = [];
							}
							
							$scope.removeDog = function($index) {
								
								if ($scope.dogList.length > 0) {
									$scope.dogList.splice($index, 1);
								}
							}

						} ]);
