var quoteModdule = angular.module('quoteController', [ 'quoteService' ]);

quoteModdule.controller('QuoteEntryController', [ '$scope', '$http','$location', 'QuoteWrapper',function($scope, $http, $location,QuoteWrapper) {
			$scope.wrapper = {}		
			$scope.newApplicant = {};
			$scope.qmap = {};
			$scope.templates  = 'partials/applicant.html';
			$scope.propertyMap = {};
			$scope.newProperty = {};
			$scope.templatesApplicant  = 'partials/applicant.html';
			$scope.templatesProperty  = 'partials/property.html';
				
			
			/**/QuoteWrapper.query(function(data) {
				console.log("data : ",data);
				
					$scope.wrapper = data;
					$scope.newApplicant = data.applicant;
					$scope.newProperty = data.property;
					$scope.qmap = data.applicantQuestMap;
					$scope.propertyMap = data.propertyQuestMap;
					console.log('newApplicant',$scope.newApplicant);
					console.log('qMap',$scope.qMap);
				//}
			
			});
			
			
			$scope.hideField = function (){
				console.log("hideField");
				$scope.newApplicant.filedForBankruptcy = false;
				$scope.qmap.filedForBankruptcy.enabled = false;
				console.log("$scope.qmap.filedForBankruptcy.enabled  : "+$scope.qmap.filedForBankruptcy.enabled );
				
			};
			$scope.changeHandle = function() {
				console.log('hello');
				
				
				
				QuoteWrapper.save($scope.wrapper, function(data) {
						
			        			            // mark success on the registration form
			            $scope.successMessages = [ 'Member Registered' ];
			            
			            $scope.wrapper = data;
						$scope.newApplicant = data.applicant;
						$scope.newProperty = data.property;
						$scope.qmap = data.applicantQuestMap;
						$scope.propertyMap = data.propertyQuestMap;
						
						console.log('newApplicant',$scope.newApplicant);
						console.log('qmap',$scope.qmap);
						console.log('propertyMap',$scope.propertyMap);
						
			        }, function(result) {
			            if ((result.status == 409) || (result.status == 400)) {
			                $scope.errors = result.data;
			            } else {
			                $scope.errorMessages = [ 'Unknown  server error' ];
			            }
			        });
				console.log('in change');
			};
			
			$scope.goToPropery = function (){
				
				//$location.path('/property');
				$scope.templates = 'partials/property.html';
			};
			$scope.goToApplication = function (){
				
				//$location.path('/applicant');
				$scope.templates = 'partials/applicant.html';
			};
			
			$scope.getEligibility = function (){
					$scope.wrapper.property.status = "";
					QuoteWrapper.checkEligibility($scope.wrapper, function(data) {
						   $scope.wrapper = data;
							$scope.newApplicant = data.applicant;
							$scope.newProperty = data.property;
							$scope.qmap = data.applicantQuestMap;
							$scope.propertyMap = data.propertyQuestMap;
					}, function(result) {
			            if ((result.status == 409) || (result.status == 400)) {
			                $scope.errors = result.data;
			            } else {
			                $scope.errorMessages = [ 'Unknown  server error' ];
			            }
			        });
			};
			
			//questRes
			//quoteCalculate
			$scope.quoteCalculate = function (){
				QuoteWrapper.quoteCalculate($scope.wrapper, function(data) {
					   $scope.wrapper = data;
						$scope.newApplicant = data.applicant;
						$scope.newProperty = data.property;
						$scope.qmap = data.applicantQuestMap;
						$scope.propertyMap = data.propertyQuestMap;
				}, function(result) {
		            if ((result.status == 409) || (result.status == 400)) {
		                $scope.errors = result.data;
		            } else {
		                $scope.errorMessages = [ 'Unknown  server error' ];
		            }
		        });
				
			}

			
			
		} ]);
