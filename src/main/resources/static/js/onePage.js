/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var UserNames="";
var user_type="";
var sevarth_num ="";
var usr_id ="";
var password="";
var userDetail="";
var sevarth_id="";
var sessionFlag = "";
var unitnames = "";


window.onload = function () {
	
    var xhttp = new XMLHttpRequest();
    var httplevel = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
    	
    	if(this.status == 500){
    		document.getElementById("logoutForm").submit();
    	}
    	
        if (this.readyState === 4 || this.status === 200) {

             userDetail = JSON.parse(xhttp.responseText);                       
            document.getElementById("usernamee").innerHTML = userDetail.sevarth_no;
            document.getElementById("firstName").innerHTML = userDetail.first_name;
            
            httplevel.onreadystatechange = function () {
            	
            	 document.getElementById("unitname").innerHTML = "";
            document.getElementById("unitname").innerHTML = httplevel.responseText;
            unitnames = httplevel.responseText;
            }
            httplevel.open("GET", "UnitManagementRest/getUnitNameByLevel3?level3="+userDetail.level3, false);
            httplevel.send();
            
            user_type = userDetail.user_type;
            sevarth_num = userDetail.sevarth_no;
            usr_id = userDetail.usrid;
            password = userDetail.password;
            sevarth_id = userDetail.sevarth_id;
            
           
            if(user_type == "Super Admin"){
            	
            	document.getElementById("moduleManage").style.display = "block";
            	document.getElementById("userManage").style.display = "block";
            	document.getElementById("modulePerm").style.display = "block";
//            	document.getElementById("moduleEntry").style.display = "block";
            	document.getElementById("moduleView").style.display = "block";
            	document.getElementById("modulePermBulk").style.display = "block";
            	document.getElementById("unitManagement").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "block";
            	document.getElementById("loginHistory").style.display = "block";
            	document.getElementById("entryUpdateReport").style.display = "block";
            	document.getElementById("userCountReport").style.display = "block";
            	document.getElementById("moduleAssignedReport").style.display = "block";
            	 
            	
                        	
            }else if(user_type =="Module Admin"){
            	
            	document.getElementById("moduleManage").style.display = "none";
            	document.getElementById("userManage").style.display = "block";
            	document.getElementById("modulePerm").style.display = "block";
//            	document.getElementById("moduleEntry").style.display = "block";
            	document.getElementById("moduleView").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "block";
            	document.getElementById("modulePermBulk").style.display = "none";
            	document.getElementById("unitManagement").style.display = "none";
            	document.getElementById("loginHistory").style.display = "none";
            	document.getElementById("entryUpdateReport").style.display = "block";
            	document.getElementById("userCountReport").style.display = "block";
            	document.getElementById("moduleAssignedReport").style.display = "block";
            	
            }else if(user_type =="Unit User"){
            	
            	document.getElementById("moduleManage").style.display = "none";
            	document.getElementById("userManage").style.display = "block";
            	document.getElementById("modulePerm").style.display = "block";
//            	document.getElementById("moduleEntry").style.display = "block";
            	document.getElementById("moduleView").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "block";
            	document.getElementById("modulePermBulk").style.display = "none";
            	document.getElementById("unitManagement").style.display = "none";
            	document.getElementById("loginHistory").style.display = "none";
            	document.getElementById("entryUpdateReport").style.display = "none";
            	document.getElementById("userCountReport").style.display = "none";
            	document.getElementById("moduleAssignedReport").style.display = "none";
            	
            }else if(user_type =="Data Entry Operator"){
            	
            	document.getElementById("moduleManage").style.display = "none";
            	document.getElementById("userManage").style.display = "none";
            	document.getElementById("modulePerm").style.display = "none";
//            	document.getElementById("moduleEntry").style.display = "block";
            	document.getElementById("moduleView").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "block";
            	document.getElementById("modulePermBulk").style.display = "none";
            	document.getElementById("unitManagement").style.display = "none";
            	document.getElementById("loginHistory").style.display = "none";
            	document.getElementById("entryUpdateReport").style.display = "none";
            }
//            }else if(user_type =="Validator"){
//            	
//            	document.getElementById("moduleManage").style.display = "none";
//            	document.getElementById("userManage").style.display = "none";
//            	document.getElementById("modulePerm").style.display = "none";
////            	document.getElementById("moduleEntry").style.display = "block";
//            	document.getElementById("moduleView").style.display = "block";
////            	document.getElementById("moduleValidation").style.display = "block";
//            	
//            }
            else if(user_type =="GIS Viewer"){
            	
            	document.getElementById("moduleManage").style.display = "none";
            	document.getElementById("userManage").style.display = "none";
            	document.getElementById("modulePerm").style.display = "none";
//            	document.getElementById("moduleEntry").style.display = "none";
            	document.getElementById("moduleView").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "none";
            	document.getElementById("modulePermBulk").style.display = "none";
            	document.getElementById("unitManagement").style.display = "none";
            	document.getElementById("loginHistory").style.display = "none";
            	document.getElementById("entryUpdateReport").style.display = "none";
            	
            }else if(user_type =="Desk Officer"){
            	
            	document.getElementById("moduleManage").style.display = "none";
            	document.getElementById("userManage").style.display = "none";
            	document.getElementById("modulePerm").style.display = "none";
//            	document.getElementById("moduleEntry").style.display = "none";
            	document.getElementById("moduleView").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "none";
            	document.getElementById("modulePermBulk").style.display = "none";
            	document.getElementById("unitManagement").style.display = "none";
            	document.getElementById("loginHistory").style.display = "none";
            	document.getElementById("entryUpdateReport").style.display = "block";
            }
            	else if(user_type =="Viewer"){
            	
            	document.getElementById("moduleManage").style.display = "none";
            	document.getElementById("userManage").style.display = "none";
            	document.getElementById("modulePerm").style.display = "none";
//            	document.getElementById("moduleEntry").style.display = "none";
            	document.getElementById("moduleView").style.display = "block";
//            	document.getElementById("moduleValidation").style.display = "none";
            	document.getElementById("modulePermBulk").style.display = "none";
            	document.getElementById("unitManagement").style.display = "none";
            	document.getElementById("loginHistory").style.display = "none";
            	document.getElementById("entryUpdateReport").style.display = "none";
            }
            
          
        }
           
            
    }
    xhttp.open("GET", "UsersRest/getUserDataFromSession", false);
    xhttp.send();
   
   
  
};

var logFlag = 0;
var timeout;
document.onmousemove = function(){
  clearTimeout(timeout);
  timeout = setTimeout(function(){
	 // alert("mouse is not moved now");
	  document.getElementById("logoutForm").submit(); 	  
  }, 1200000);
  
  if(logFlag == 0){
  var xhttpss = new XMLHttpRequest();
  xhttpss.onreadystatechange = function () {
	  logFlag = 1;
		if(this.status == 500){
    		document.getElementById("logoutForm").submit();
    	}
					
  }
	xhttpss.open("GET", "UsersRest/getUserDataFromSession", false);
    xhttpss.send();
  }
  
}

//function preventBack() { console.log("helo yogesh prevent code"); window.history.forward(); }
//setTimeout("preventBack()", 0);
//window.onunload = function () { null };

var myApp = angular.module('myApp', ['ui.router', 'angucomplete-alt']);
myApp.config(function ($stateProvider, $urlRouterProvider) {
	
	 $urlRouterProvider.otherwise('/moduleView');
    $stateProvider
            .state('userCreation', {
                url: '/userCreation',
                controller: 'userCreationController',
                templateUrl: 'userCreation.html'
               })    
               .state('userUpdation', {
                   url: '/userUpdation',
                   controller: 'userUpdationController',
                   templateUrl: 'userUpdation.html'
                }) 
                .state('moduleManage', {
                    url: '/moduleManage',
                    controller: 'moduleManageController',
                    templateUrl: 'moduleManage.html'
                 })
                 .state('modulePermission', {
                     url: '/modulePermission',
                     controller: 'modulePermissionController',
                     templateUrl: 'modulePermission.html'
                  }) 
                 .state('moduleEntry', {
                     url: '/moduleEntry',
                     controller: 'moduleEntryController',
                     templateUrl: 'moduleEntry.html'
                  })  
                  .state('moduleView', {
                      url: '/moduleView',
                      controller: 'moduleViewController',
                      templateUrl: 'moduleView.html'
                   }) 
                   .state('moduleValidation', {
                       url: '/moduleValidation',
                       controller: 'moduleValidationController',
                       templateUrl: 'moduleValidation.html'
                    }) 
                    .state('modulePermissionBulk', {
                        url: '/modulePermissionBulk',
                        controller: 'modulePermissionBulkController',
                        templateUrl: 'modulePermissionBulk.html'
                    }) 
                    .state('unitManagement', {
                        url: '/unitManagement',
                        controller: 'unitManagementController',
                        templateUrl: 'unitManagement.html'
                    }) 
                     .state('loginHistory', {
                        url: '/loginHistory',
                        controller: 'loginHistoryController',
                        templateUrl: 'loginHistory.html'
                    })
                    .state('userCountReport', {  
                        url: '/userCountReport',
                        controller: 'userCountReportController',
                        templateUrl: 'userCountReport.html'
                    }) 
                    .state('moduleAssignedReport', {
                        url: '/moduleAssignedReport',
                        controller: 'moduleAssignedReportController',
                        templateUrl: 'moduleAssignedReport.html'
                    }) 
                    .state('entryUpdateReport', {
                        url: '/entryUpdateReport',
                        controller: 'entryUpdateReportController',
                        templateUrl: 'entryUpdateReport.html'
                    })                                   
                       
    });


myApp.controller('userCreationController', function ($scope, $state, $window, $http) {
	 $scope.userTypesObj=[];
	$scope.onload = function(){
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		 
		
		
		$http.get("UnitRest/getBranches").then(function(response){
			$scope.branchObj = response.data;
		})
		
		if(user_type ==="Super Admin"){
		$scope.userTypesObj.push("Super Admin","Module Admin","GIS Viewer","Desk Officer");
		}
		else if(user_type ==="Module Admin"){
			$scope.userTypesObj.push("Module Admin","GIS Viewer","Desk Officer","Unit User");
		}
		else if(user_type ==="Unit User"){
			$scope.userTypesObj.push("Unit User","Data Entry Operator","Viewer");  //"Validator" 
		}
		
		$http.get("RankRest/findAllRanks").then(function(response){
			$scope.rankObj = response.data;
			
		})
		
		
		document.getElementById("hidedist").style.display ="block";	
	}
	
//	$scope.chageUsertype = function(){
//		console.log($scope.userType);
//	}
	
	
	$scope.onChangeBranch = function(){
		if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
			document.getElementById("hidedist").style.display ="block";
		}
		$scope.cityRangeObj = null;
		$http.get("UnitRest/getLevel1Data",{params:{"branch":$scope.branch}}).then(function(response){
			$scope.cityRangeObj = response.data;
			if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
				$scope.policeStationObj = response.data;
			}
			
			
			if($scope.branch =="Commissionerate" || $scope.branch =="Range"){
				document.getElementById("hidedist").style.display ="none";
				$scope.policeStationObj = null;
			}else{
				document.getElementById("hidedist").style.display ="block";
				
			}
		})	
		$scope.distZoneObj = null;
		
		for(var i = 0;i < $scope.branchObj.length;i++){
			if($scope.branchObj[i].branch ===$scope.branch ){
				$scope.level0 =  $scope.branchObj[i].level0;
			}
		}
		
		
		
		
	}
	
	$scope.onChangeCityRange = function(){
		
		$http.get("UnitRest/getLevel2Data",{params:{"branch":$scope.branch,"level1":$scope.cityRange}}).then(function(response){
			$scope.distZoneObj = response.data;
								
		})
	}
	
$scope.onChangeDistZone = function(){
	var distZoneVal = document.getElementById("distZone").value ;
	 var distZoneArr =  distZoneVal.split(":");
	 var distZone = distZoneArr[1]; 
	
		$http.get("UnitRest/getPoliceStation",{params:{"level2":distZone}}).then(function(response){
			
			$scope.policeStationObj = response.data;
								
		})
	}

// getting  maximum value by rank

$scope.getMaxRankValue = function(){
	
	$http.get("UsersRest/getMaxRankValue",{params:{usr_rank:$scope.rank}}).then(function(response){
		
		$scope.rankPriority = parseInt(response.data);
	});
	
};



$scope.saveUser = function(){
	 var distZone = "NULL";
	 var email = "NULL";
	 var cityRange = "NULL"
	
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
	 
	var userObj = {
			 "sevarth_no":	$scope.sevarthnum,		
			 "first_name":$scope.firstname,
			 "middle_name":$scope.middlename,
			 "last_name":$scope.lastname,
			 "level0":$scope.level0,
			 "level1":$scope.cityRange,
			 "level2":distZone,
			 "level3":$scope.ps_station,
			 "mobile_num":$scope.mobile_num,
			 "emailid":email,
			 "creator_name":sevarth_num,
			 "status":"enable",
			 "user_type":$scope.userType,
			 "rank_status":parseInt($scope.rankstatus),
			 "branch":$scope.branch ,
			 "usr_rank":$scope.rank,
			 "gender":$scope.gender,
			 "sevarth_id":$scope.sevarth_id,
			 "modified_by":'NULL',
			 "modified_on":'NULL',
			 "priority":parseInt($scope.rankPriority)+1,
			 "visit_status" : 0,
			 "profile_code":"NULL"
	}	
	$http.post("UsersRest/saveUsers",userObj).then(function(response){
		if(response.data === true  ){
			alert("User Saved. Please assign the module to them from 'Module Permission'" );
			$scope.clearForm();
		}else{
			alert("Error ! Something is wrong.");
		}						
	}, function error(response) {
  	  alert("Error to save user ! please check whether user would present.");
    })	
}

$scope.clearForm = function(){
	
	$scope.sevarth_id="";
	$scope.sevarthnum ="";		
	$scope.firstname = "";
	$scope.middlename = "";
	$scope.lastname ="";
	$scope.level0 ="";
    $scope.cityRange = null;
	$scope.distZone =null;
	$scope.ps_station =null;
	$scope.mobile_num ="";
	$scope.emailid="";
	$scope.sevarth_id ="";
	$scope.userType=null;
	$scope.rankstatus = null;
	$scope.branch = null;
	$scope.rank = null;
	$scope.gender = null;
	document.getElementById("hidedist").style.display ="block";
	$scope.rankPriority= 0;
}

	$scope.onload();
})

.controller('userUpdationController', function ($scope, $state, $window, $http) {
	
	 $scope.userTypesObj=[];

// code while controller will load , initial code	 
	$scope.onload = function(){	
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		
		$http.get("UnitRest/getBranches").then(function(response){
			$scope.branchObj = response.data;
		})		
		if(user_type ==="Super Admin"){
		$scope.userTypesObj.push("Super Admin","Module Admin","GIS Viewer","Desk Officer");
		}
		else if(user_type ==="Module Admin"){
			$scope.userTypesObj.push("Module Admin","GIS Viewer","Desk Officer","Unit User");
		}
		else if(user_type ==="Unit User"){
			$scope.userTypesObj.push("Unit User","Data Entry Operator","Viewer");
			//,"Validator"
		}
		
		
		
		
		$http.get("UsersRest/readUsersByAdmin",{params:{userType:user_type}}).then(function(response){
			
			$scope.sevarthNumObj = response.data;
		})	
		
		$http.get("RankRest/findAllRanks").then(function(response){
			$scope.rankObj = response.data;
		})
		
		
		document.getElementById("hidedist").style.display ="block";
	}
	
	

	
// code for get cities and range object	
	$scope.onChangeBranch = function(){
		$scope.cityRangeObj = null;
		if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
			document.getElementById("hidedist").style.display ="block";
		}
		$http.get("UnitRest/getLevel1Data",{params:{"branch":$scope.branch}}).then(function(response){
			$scope.cityRangeObj = response.data;
			if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
				$scope.policeStationObj = response.data;
			}					
			if($scope.branch =="Commissionerate" || $scope.branch =="Range"){
				document.getElementById("hidedist").style.display ="none";
				$scope.policeStationObj = null;
			}else{
				document.getElementById("hidedist").style.display ="block";				
			}
		})	
		$scope.distZoneObj = null;
		
		for(var i = 0;i < $scope.branchObj.length;i++){
			if($scope.branchObj[i].branch ===$scope.branch ){
				$scope.level0 =  $scope.branchObj[i].level0;
			}
		}		
	}
	
// code for get district zone object
	$scope.onChangeCityRange = function(){		
		$http.get("UnitRest/getLevel2Data",{params:{"branch":$scope.branch,"level1":$scope.cityRange}}).then(function(response){
			$scope.distZoneObj = response.data;							
		})
	}
	
// code for get police station object
$scope.onChangeDistZone = function(){
	$scope.policeStationObj =[];
	var distZone ;	
	if($scope.branch ==="Range"){
		  distZone =  $scope.distZones;	}else if($scope.branch ==="Commissionerate"){  distZone = $scope.distZone;	}	
		$http.get("UnitRest/getPoliceStation",{params:{"level2":distZone}}).then(function(response){
		
			$scope.policeStationObj = response.data;							
		})
	}
//code to place the values automatically	

$scope.selectedSevarthNum = function(data){		
		$http.get("UsersRest/getUserBySevarthNumber",{params:{sevarthNum:data.title}}).then(function(response){	
			
			$scope.userid = response.data[0].usrid;
			$scope.sevarthnum =response.data[0].sevarth_no;		
			$scope.firstname = response.data[0].first_name;			
			$scope.middlename =response.data[0].middle_name;
			$scope.lastname =response.data[0].last_name;
			$scope.level0 =response.data[0].level0;			
			$scope.mobile_num =response.data[0].mobile_num;
			$scope.emailid=response.data[0].emailid;
			$scope.creator=response.data[0].creator_name;
			$scope.userType=response.data[0].user_type;
			$scope.rankstatus = JSON.stringify( response.data[0].rank_status);	
			$scope.status = response.data[0].status;
			$scope.branch = response.data[0].branch;
			$scope.gender = response.data[0].gender;
			$scope.rank = response.data[0].usr_rank;
			$scope.pass = response.data[0].password;
			$scope.sevarth_id = response.data[0].sevarth_id;
			$scope.created_on = response.data[0].created_on;
			$scope.ext_rank = response.data[0].usr_rank;
			$scope.rankPriority = response.data[0].priority;
			$scope.visit_status = response.data[0].visit_status;
			$scope.profile_code = response.data[0].profile_code;
			
			$http.get("UnitRest/getLevel1Data",{params:{"branch":$scope.branch}}).then(function(resp){
				$scope.cityRangeObj = resp.data;				
				if(resp.status === 200){
					$scope.cityRange=response.data[0].level1;										
					$http.get("UnitRest/getLevel2Data",{params:{"branch":$scope.branch,"level1":$scope.cityRange}}).then(function(respOne){
						$scope.distZoneObj = respOne.data;	
						
						if(respOne.status ===200 ){
							if($scope.branch ==="Range"){
								$scope.distZones = response.data[0].level2;
						}else{
							    $scope.distZone = response.data[0].level2;
						}														
							//$scope.policeStationObj =[];
							var distZone ;	
							if($scope.branch ==="Range"){
								  distZone =  $scope.distZones;	}else if($scope.branch ==="Commissionerate"){  distZone = $scope.distZone;	}	
								$http.get("UnitRest/getPoliceStation",{params:{"level2":distZone}}).then(function(respTwo){
								
									$scope.policeStationObj = respTwo.data;	
									if(respTwo.status === 200){
										 $scope.ps_station=response.data[0].level3;
									}
								})							
						}			
					})												
					if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
						$scope.policeStationObj = resp.data;
						if($scope.policeStationObj !==null){
							 $scope.ps_station=response.data[0].level3;
						}
					}					
					if($scope.branch =="Commissionerate" || $scope.branch =="Range"){
						document.getElementById("hidedist").style.display ="none";
						$scope.policeStationObj = null;
					}else{
						document.getElementById("hidedist").style.display ="block";				
					}									
				}				
			})								
		})
	};
	
	
	// getting  maximum value by rank

	$scope.getMaxRankValue = function(){
		
		if( $scope.ext_rank != $scope.rank){
		$http.get("UsersRest/getMaxRankValue",{params:{usr_rank:$scope.rank}}).then(function(response){
			
			$scope.rankPriority = parseInt(response.data)+1;
		});
		}
		
	};	
	

// code for user updation, to change the user data

$scope.updateUser = function(){
	var distZoneVal ;
	 var distZoneArr ;
	 var distZone ;
	 var cityRange = "NULL";
	var email = "NULL";
	if($scope.branch ==="Commissionerate"){
	 distZoneVal = document.getElementById("distZone").value ;
	  distZoneArr =  distZoneVal.split(":");
	  distZone = distZoneArr[1]; 
}else if($scope.branch ==="Range"){
	 distZoneVal = document.getElementById("distZones").value ;
	  distZoneArr =  distZoneVal.split(":");
	  distZone = distZoneArr[1]; 
}else{
	 distZone = "NULL";
}
	if($scope.cityRange !== null ){
		cityRange = $scope.cityRange;
	}
	if($scope.emailid !== null){
		email = $scope.emailid;
	}
	 
	
	var userObj = {
			 "usrid":$scope.userid,
			 "sevarth_no":	$scope.sevarthnum,		
			 "first_name":$scope.firstname,
			 "middle_name":$scope.middlename,
			 "last_name":$scope.lastname,
			 "level0":$scope.level0,
			 "level1":cityRange,
			 "level2":distZone,
			 "level3":$scope.ps_station,
			 "mobile_num":$scope.mobile_num,
			 "emailid":email,
			 "creator_name":$scope.creator,
			 "status":$scope.status,
			 "user_type":$scope.userType,
			 "rank_status":parseInt($scope.rankstatus),
			 "branch":$scope.branch ,
			 "usr_rank":$scope.rank,
			 "password":$scope.pass,
			 "gender":$scope.gender,
			 "sevarth_id":$scope.sevarth_id,
			 "created_on":$scope.created_on,
			 "modified_by":	sevarth_num	,
			 "priority":$scope.rankPriority,
			 "visit_status":$scope.visit_status,
			 "profile_code":$scope.profile_code
			 
	}
	
	$http.post("UsersRest/saveUsers",userObj).then(function(response){
		if(response.data === true  ){
			alert("User Updated. Please assign the module to them from 'Module Permission'" );
			$scope.clearForm();
		}else{
			alert("Error ! Something is wrong.");
		}						
	}, function error(response) {
  	  alert("! Error to update user detail ");
    })		
}

//resetPassword
$scope.resetPassword = function(){
//	public String resetUsrPassword(@RequestParam  int user_id ,@RequestParam  String mobile_num  ) {
	
	$http.get("UsersRest/resetUsrPassword",{params:{user_id:$scope.userid,mobile_num:$scope.mobile_num}} ).then(function(response){
		
		if(response.data === true || response.data ==="true"){
			alert("Paasword has been reset and sent to registerd contact no.");
		}else{
			alert("Error occured to change the password !");
		}
	}, function error(response) {
  	  alert("! Error occured");
    })
}


$scope.clearForm = function(){
		
	$scope.sevarth_id="";
	$scope.sevarthnum ="";		
	$scope.firstname = "";
	$scope.middlename = "";
	$scope.lastname ="";
	$scope.level0 ="";
    $scope.cityRange = null;
	$scope.distZone =null;
	$scope.ps_station =null;
	$scope.mobile_num ="";
	$scope.emailid="";
	$scope.creator="";
	$scope.userType=null;
	$scope.rankstatus = null;
	$scope.branch = null;
	$scope.status = null;
	$scope.rank = null;
	$scope.gender = null;
	document.getElementById("hidedist").style.display ="block";
}
	$scope.onload();
})

.controller('moduleManageController', function ($scope, $state, $window, $http) {
	$scope.flag = 0;
	
	// code run on onload
	$scope.onload = function(){
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		
		$http.get("UsersRest/readUsersByAdmin",{params:{userType:user_type}}).then(function(response){					
					$scope.sevarthNumObj = response.data;
			})
			
			$http.get("ModuleRest/getModuleData",{params:{sevarthNum:sevarth_num}}).then(function(response){					
				$scope.moduleDataObj = response.data;
		})
	}
	
	
	
	// getting the value of angucomplete-alt 
	$scope.selectedSevarthNum = function(data){	
		$scope.mod_owner = data.title;
	}	
	// save and update module method
	$scope.saveModule = function(){
		var moduleObj = {};				  
				 
		if($scope.flag === 0){
			 moduleObj = {				  
					  "module_name":$scope.module_name,
					 
					  "mod_purpose":$scope.modPurpose,
					  "created_by":sevarth_num,
					  "category":$scope.category,
					  "mod_url":$scope.mod_url,
					  "mod_image":"assets/images/"
			 }
		}else{
			 moduleObj = {	
					 
					 "module_id" : $scope.module_id,
					  "module_name":$scope.module_name,
					 
					  "mod_purpose":$scope.modPurpose,
					  "created_by":sevarth_num	,
					  "category":$scope.category,
					  "mod_url":$scope.mod_url,
					  "mod_image":$scope.mod_image,
					  "mod_key":$scope.mod_key,
					  "mod_color":$scope.mod_color
		}
			
		}
	    	$http.post("ModuleRest/saveModule",moduleObj).then(function(response){					
			if(response.data ===true){
				if($scope.flag === 0){
					alert($scope.module_name +" is added.");
					$scope.onload();	
				}else{
					alert($scope.module_name +" is updated.")
					$scope.flag === 0;
					$scope.onload();	
				}
				
				
				$scope.clearForm();
			}else{
				alert("Error ! Something is wrong.");
			}
	}, function error(response) {
  	  alert("Error occured.");
    })			
	}	
	
	// clear module releted data
	$scope.clearForm = function(){
		
	      $scope.module_name="";
		  
		  $scope.modPurpose = "";		 
		  $scope.$broadcast('angucomplete-alt:clearInput');
		  $scope.flag = 0;
		  $scope.mod_url = "";
		  $scope.category = null;
	}
	
	$scope.getDataForUpdate = function(mod_id){
		$window.scrollTo(0, 0);
		$scope.flag = 1;
		for(var i = 0 ; i < $scope.moduleDataObj.length; i++){
			if(mod_id === parseInt($scope.moduleDataObj[i].module_id)){
				 $scope.module_name = $scope.moduleDataObj[i].module_name;
				
				 $scope.modPurpose = $scope.moduleDataObj[i].mod_purpose;
				 $scope.module_id = $scope.moduleDataObj[i].module_id;
				 $scope.category = $scope.moduleDataObj[i].category;
				 $scope.mod_image = $scope.moduleDataObj[i].mod_image;
				 $scope.mod_url =  $scope.moduleDataObj[i].mod_url;
				 $scope.mod_key = $scope.moduleDataObj[i].mod_key;
				 $scope.mod_color = $scope.moduleDataObj[i].mod_color;
			}
		}
	}
	
	// code for deleting the module
	$scope.deleteModule = function(mod_id){				
		$http.get("ModuleRest/deleteModule",{params:{mod_id:mod_id}}).then(function(response){	
			$window.scrollTo(0, 0);
			if(response.data === true){
				alert("module deleted successfully");
				$scope.onload();	
			}else{
				alert("Failed to delete module");
				$scope.onload();	
			}
	})
	}	
	$scope.onload();	
})

.controller('modulePermissionController', function ($scope, $state, $window, $http) {
	$scope.flag = 0;
	$scope.moduleDataObj = [];
// getting sevarth object and module data to display	
$scope.onload = function(){
	
	 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
	    }, function error(response) {
	    	  document.getElementById("logoutForm").submit();
	    })
	
	$scope.moduleDataObj = [];
	$http.get("UsersRest/readUsersByAdmin",{params:{userType:user_type}}).then(function(response){		
		$scope.sevarthNumObj = response.data;
	})
	
	if(user_type !== "Module Admin"){
	$http.get("ModuleRest/getModuleData",{params:{sevarthNum:sevarth_num}}).then(function(response){					
				$scope.moduleDataObj = response.data;
    })
	}else{
		$http.get("ModPermissionRest/getModuleBysevarthId",{params:{SevarthId : usr_id}}).then(function(response){
		//	$scope.moduleDataObj = response.data;
			$scope.moduleDataObj = [];
			for(var i = 0 ; i < response.data.length ; i++ ){
				$scope.moduleDataObj.push(response.data[i].bean);
			}
			
		})
		
	}
    
    
    $http.get("ModPermissionRest/getModPermissionData",{params:{applier_id:usr_id}}).then(function(response){					
    	
		$scope.modPermissionObj = response.data;
})
}
	
$scope.selectedSevarthNum = function(data){	
	$scope.sevarthId = data.title;
	$http.get("UsersRest/getUserBySevarthNumber",{params:{sevarthNum:data.title}}).then(function(response){	
	
		$scope.userId = response.data[0].usrid;
//		if(response.data[0].user_type == "Module Admin" || response.data[0].user_type == "Unit User" ){
//		
////			$scope.dataentry = true;
////			$scope.validation = true;
//			$scope.view  = true;
//			$scope.gisViewer = true;
//		}else{
//			$scope.dataentry = false;
//			$scope.validation = false;
//			$scope.view  = false;
//		}
		
		
		if( response.data[0].user_type == "Module Admin" || response.data[0].user_type == "Super Admin" ){		
			document.getElementById("dataentry").style.display = "none";
			//document.getElementById("validation").style.display = "none";
			document.getElementById("gisViewer").style.display = "block";
			document.getElementById("deskOfficer").style.display = "none";
			document.getElementById("view").style.display = "block";
			
		}else if(response.data[0].user_type == "Desk Officer"){
			document.getElementById("dataentry").style.display = "none";
			//document.getElementById("validation").style.display = "none";
			document.getElementById("gisViewer").style.display = "none";
			document.getElementById("deskOfficer").style.display = "block";
			document.getElementById("view").style.display = "none";
		}
		else if(response.data[0].user_type =="Viewer"){
			document.getElementById("dataentry").style.display = "none";
			//	document.getElementById("validation").style.display = "block";
				document.getElementById("gisViewer").style.display = "block";
				document.getElementById("deskOfficer").style.display = "none";
				document.getElementById("view").style.display = "block";
		}else if(response.data[0].user_type =="Data Entry Operator"){
			document.getElementById("dataentry").style.display = "block";
			//	document.getElementById("validation").style.display = "block";
				document.getElementById("gisViewer").style.display = "none";
				document.getElementById("deskOfficer").style.display = "none";
				document.getElementById("view").style.display = "none";
		}else if(response.data[0].user_type =="GIS Viewer"){
			document.getElementById("dataentry").style.display = "none";
			//document.getElementById("validation").style.display = "none";
			document.getElementById("gisViewer").style.display = "block";
			document.getElementById("deskOfficer").style.display = "none";
			document.getElementById("view").style.display = "none";
		}
		else{
			document.getElementById("dataentry").style.display = "block";
		//	document.getElementById("validation").style.display = "block";
			document.getElementById("gisViewer").style.display = "none";
			document.getElementById("deskOfficer").style.display = "none";
			document.getElementById("view").style.display = "block";
			
		}
		
		$http.get("ModPermissionRest/getModuleBysevarthId",{params:{SevarthId :$scope.userId}}).then(function(resp){

			$scope.modPermissionObj = resp.data;
			})
		
	});
	
	//console.log("typeof = "+typeof($scope.userId));
	
	
	
}

$scope.getDataByModId = function(){
	if(user_type === "Super Admin" || user_type === "Module Admin" )
	$http.get("ModPermissionRest/getPermiByModId",{params:{modid :parseInt($scope.moduleid)}}).then(function(response){
		$scope.modPermissionObj = response.data;
		})
	
}

// code to hide and show permission
$scope.showPermissionByModule = function(module_id){
	
//	for(var i = 0; i < $scope.moduleDataObj.length; i++ ){
//		
//		if(module_id == $scope.moduleDataObj[i].module_id ){
//			if($scope.moduleDataObj[i].category == "Data Entry"){
//				
//				
//				document.getElementById("dataentry").style.display = "block";
//				document.getElementById("validation").style.display = "block";
//				document.getElementById("view").style.display = "none";	
//				break;
//			}else{	
//				  
//				
//				document.getElementById("dataentry").style.display = "none";
//				document.getElementById("validation").style.display = "none";
//				document.getElementById("view").style.display = "block";	
//				break;
//			}			
//		}
//	}
	
}



// code for save and update
$scope.saveModpermission = function(){
	var per_view;
	var per_validate;
	var per_dataentry;
	var deskOfficer;
	var gisViewer;
	
	if($scope.dataentry == true){
		dataentry = 1;
	}else{
		dataentry = 0;
	}
	
	if($scope.validation == true){
		per_validate = 1;
	}else{
		per_validate = 0;
	}

	if($scope.view == true){
		per_view = 1;
	}else{
		per_view = 0;
	}
	
	if($scope.deskOfficer == true){
		deskOfficer = 1;
	}else{
		deskOfficer = 0;
	}
	if($scope.gisViewer == true){
		gisViewer = 1;
	}else{
		gisViewer = 0;
	}
	
	var permiObj = {};
	if($scope.flag === 0){
		 permiObj = {			 
				  "mod_id":$scope.moduleid,
				  "sevarthnum":parseInt($scope.userId),
			      "per_view":per_view,
				  "per_validate":per_validate,
			      "per_dataentry":dataentry,
			      "per_desk":deskOfficer,
			      "per_gis":gisViewer,
				  "applied_by":usr_id	
		 }
	}else{
		
		permiObj = {	
				
				  "pr_id":$scope.pr_id,
				  "mod_id":$scope.moduleid,
				  "sevarthnum":parseInt($scope.userId),
			      "per_view":per_view,
				  "per_validate":per_validate,
			      "per_dataentry":dataentry,
			      "per_desk":deskOfficer,
			      "per_gis":gisViewer,
				  "applied_by":usr_id	
		}
		
	}
		
		
	if($scope.moduleid !== undefined && $scope.sevarthId !== undefined ){
	$http.post("ModPermissionRest/saveModPermission",permiObj).then(function(response){					
		if(response.data == true){
			if($scope.flag == 0){
			alert("permission has been applied to "+$scope.sevarthId);
			$scope.clearForm();
			$scope.onload();
			}else{
				alert("permission has been changed to "+$scope.sevarthId);
				$scope.clearForm();
				$scope.onload();
				$scope.flag = 0;
			}
			
			
		}else{
			alert("Failed ! Record may be present");
			$scope.clearForm();
			$scope.onload();
		}
}, function error(response) {
	  alert("! Error occured. ");
})
	}else{
		alert("Please Fill all fields");
	}
}
//code for getting data by permission id.
$scope.getModDataByPermId = function(permId){
	$http.get("ModPermissionRest/getDataById",{params:{permId:permId}}).then(function(response){	
		
		$window.scrollTo(0, 0);
	     $scope.sevarthId = response.data.usrbean.sevarth_no;
	     $scope.userId = response.data.sevarthnum;
	   
		  $scope.moduleid = response.data.mod_id;
		  $scope.pr_id = response.data.pr_id;
		 if(response.data.per_view === 1){
			 $scope.view = true;
		}else{
			$scope.view = false;
		}
		 
		 if(response.data.per_validate === 1){
			 $scope.validation = true;
		}else{
			$scope.validation = false;
		}
		 
		 if(response.data.per_dataentry === 1){
			 $scope.dataentry = true;
		}else{
			$scope.dataentry = false;
		}
		 
		 $scope.$broadcast('angucomplete-alt:changeInput', 'ex1',response.data.usrbean.sevarth_no);   
})
$scope.flag = 1;
}

// code for delete record
$scope.deleteRecordById = function(permId){
	
	$http.get("ModPermissionRest/deleteDataByIds",{params:{permId:permId}}).then(function(response){
		if(response.data === true){
			alert("Record deleted.");
			$scope.onload();
		}else{
			alert("Error ! Something is wrong.");
		}
	}, function error(response) {
  	  alert("!Error Occured.");
    })
	
}

 $scope.clearForm = function(){
	
	 $scope.moduleid = null;
	 $scope.dataentry = false;
	 $scope.validation = false;
	 $scope.deskOfficer = false;
	 $scope.gisViewer = false;
	 $scope.view = false;
	 $scope.flag = 0;
	 	
	 $http.get("ModPermissionRest/getModuleBysevarthId",{params:{SevarthId :$scope.userId}}).then(function(response){		 
			$scope.modPermissionObj = response.data;
			$scope.sevarthId = "";
			$scope.userId = "";
			 $scope.$broadcast('angucomplete-alt:clearInput');
			})
	 
 }
 

$scope.onload();
})

//moduleEntryController
.controller('moduleEntryController', function ($scope, $state, $window, $http) {

	$scope.onload = function(){
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		
		 var xhttpp = new XMLHttpRequest();
		    xhttpp.onreadystatechange = function () {
		    	$scope.moduleDataObj = JSON.parse(xhttpp.responseText); 
		        if (this.readyState === 4 || this.status === 200) {
		        	 setTimeout(function(){$scope.getUrl() }, 3000);	 
		        	
		        }
		    };
		    xhttpp.open("GET", "ModPermissionRest/getDataModuleEntryByUser?sevarthNum="+sevarth_num, false);
		    xhttpp.send();
		    
	}
		
	$scope.getUrl= function(){		
		for(var i = 0; i< $scope.moduleDataObj.length; i++){									
			document.getElementById("form"+i).action = $scope.moduleDataObj[i].bean.mod_url; 
		}
	}
	
	
	//document.getElementById("username").value = sevarth_num;
	//document.getElementById("password").value = password;
	
	
	$scope.username=sevarth_num;
	$scope.password =password;
	
	
	$scope.onload();	
})

.controller('moduleViewController', function ($scope, $state, $window, $http, $timeout) {

	$scope.onload = function(){
				 
		
	  var xhttps = new XMLHttpRequest();
	  xhttps.onreadystatechange = function () {
			if(this.status == 500){
	    		document.getElementById("logoutForm").submit();
	    	}
		var usrDetail =  JSON.parse(xhttps.responseText);
		
		
		$scope.username=usrDetail.sevarth_id;
		$scope.password =usrDetail.password;
		$scope.level0 = usrDetail.level0;
		$scope.level1 = usrDetail.level1;
		$scope.level2 = usrDetail.level2;
		$scope.level3 = usrDetail.level3;
		$scope.branch = usrDetail.branch;
		
		 var xhttpp = new XMLHttpRequest();
		    xhttpp.onreadystatechange = function () {
		    	$scope.moduleDataObj = JSON.parse(xhttpp.responseText); 
		    	
		    
		    
		        if (this.readyState === 4 || this.status === 200) {
		        	 setTimeout(function(){$scope.getUrl() },50);	 
		        	// $scope.getUrl();
		        }
		    };
		    xhttpp.open("GET", "ModPermissionRest/getDataViewByUser?sevarthNum="+usrDetail.usrid, false);
		    xhttpp.send();		
		
	  }
		xhttps.open("GET", "UsersRest/getUserDataFromSession", false);
	    xhttps.send();
		
		
	}
	document.getElementById("cardData").style.display = "none";
	
	$scope.getUrl= function(){	
		
		for(var i = 0; i< $scope.moduleDataObj.length; i++){
			
			document.getElementById("form"+i).action = $scope.moduleDataObj[i].bean.mod_url; 
			if(i == ($scope.moduleDataObj.length-1) ){
				document.getElementById("cardData").style.display = "flex";
			}
		}
	};
	
	$scope.sendModId = function(modid){
		
		var histData = {
				"mod_id" : modid
		};
		$http.post("LoginHistoryRest/saveModHitsLog",histData).then(function(response){
			
		});
	}
	
	$scope.onload();	
	
})

.controller('moduleValidationController', function ($scope, $state, $window, $http) {

	$scope.onload = function(){
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		
		 var xhttpp = new XMLHttpRequest();
		    xhttpp.onreadystatechange = function () {
		    	$scope.moduleDataObj = JSON.parse(xhttpp.responseText); 
		        if (this.readyState === 4 || this.status === 200) {
		        	 setTimeout(function(){$scope.getUrl() }, 3000);	 
		        	
		        }
		    };
		    xhttpp.open("GET", "ModPermissionRest/getDataValidationByUser?sevarthNum="+sevarth_num, false);
		    xhttpp.send();
		    
	}
	
	
	$scope.getUrl= function(){		
		for(var i = 0; i< $scope.moduleDataObj.length; i++){									
			document.getElementById("form"+i).action = $scope.moduleDataObj[i].bean.mod_url; 
		}
	}
	
	
	
	$scope.username=sevarth_num;
	$scope.password =password;
	
	
	$scope.onload();	
})

.controller('modulePermissionBulkController', function ($scope, $state, $window, $http) {
	
	$scope.onload = function(){
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		
		document.getElementById("filterData").style.display = "none";
		document.getElementById("updatedData").style.display = "none";
		
		$http.get("UnitRest/getBranches").then(function(response){
			$scope.branchObj = response.data;
		});
		
		$http.get("RankRest/findAllRanks").then(function(response){
			$scope.rankObj = response.data;
			
		});
		
		
		
		$scope.moduleDataObj = [];
		$http.get("UsersRest/readUsersByAdmin",{params:{userType:user_type}}).then(function(response){		
			$scope.sevarthNumObj = response.data;
		})
		
		if(user_type !== "Module Admin"){
		$http.get("ModuleRest/getModuleData",{params:{sevarthNum:sevarth_num}}).then(function(response){					
					$scope.moduleDataObj = response.data;
	    })
		}else{
			$http.get("ModPermissionRest/getModuleBysevarthId",{params:{SevarthId : usr_id}}).then(function(response){
			//	$scope.moduleDataObj = response.data;
				$scope.moduleDataObj = [];
				for(var i = 0 ; i < response.data.length ; i++ ){
					$scope.moduleDataObj.push(response.data[i].bean);
				}
				
			})
			
		}
		
		
		
		document.getElementById("hidedist").style.display ="block";	
	}
	

	$scope.onChangeBranch = function(){
		$scope.cityRangeObj = null;
		if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
			document.getElementById("hidedist").style.display ="block";
		}
		
		$http.get("UnitRest/getLevel1Data",{params:{"branch":$scope.branch}}).then(function(response){
			$scope.cityRangeObj = response.data;
			if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
				$scope.policeStationObj = response.data;
			}
			
			
			if($scope.branch =="Commissionerate" || $scope.branch =="Range"){
				document.getElementById("hidedist").style.display ="none";
				$scope.policeStationObj = null;
			}else{
				document.getElementById("hidedist").style.display ="block";
				
			}
		})	
		$scope.distZoneObj = null;
		
		for(var i = 0;i < $scope.branchObj.length;i++){
			if($scope.branchObj[i].branch ===$scope.branch ){
				$scope.level0 =  $scope.branchObj[i].level0;
			}
		}
				
	}
	
	$scope.onChangeCityRange = function(){
		
		$http.get("UnitRest/getLevel2Data",{params:{"branch":$scope.branch,"level1":$scope.cityRange}}).then(function(response){
			$scope.distZoneObj = response.data;
								
		})
	}
	
	
$scope.onChangeDistZone = function(){
	var distZoneVal = document.getElementById("distZone").value ;
	 var distZoneArr =  distZoneVal.split(":");
	 var distZone = distZoneArr[1]; 
	
		$http.get("UnitRest/getPoliceStation",{params:{"level2":distZone}}).then(function(response){
			
			$scope.policeStationObj = response.data;							
		})
};

$scope.saveModpermission = function(){
	
	document.getElementById("filterData").style.display = "none";
	document.getElementById("updatedData").style.display = "block";
	
	 var distZone = "NULL";
	 var email = "NULL";
	 var cityRange = "NULL"	
	var level1 = "NULL";
	var level2 = "NULL";
	var level3 = "NULL";
	var level0 = "NULL"; 
	var branch = "NULL";
	var joinCode = "NULL";
	var per_view;
	var per_validate;
	var per_dataentry;
	var deskOfficer;
	var gisViewer;
	
		
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
if($scope.branch !== undefined && $scope.branch !== null && $scope.branch !==""){
	level0 = $scope.level0;
}
if($scope.cityRange !== undefined && $scope.cityRange !== null && $scope.cityRange !==""){
	level1 = $scope.cityRange;
}
if(distZone !== undefined && distZone !== null && distZone !==""){
	level2 = distZone;
}
if($scope.ps_station !== undefined && $scope.ps_station !== null && $scope.ps_station !==""){
	level3 = $scope.ps_station;
}

if($scope.branch ==="Anti Naxal Operation"){
    joinCode = "ANO";
    branch = "Anti Naxal Operation";
}else if($scope.branch ==="Anti-Terrorism Squad"){
    joinCode = "ATS";
     branch = "Anti-Terrorism Squad";
}else if($scope.branch ==="CID"){
    joinCode = "CID_HQ";
     branch = "CID";
}else if($scope.branch ==="Commissionerate"){
    joinCode = "RGCM";
     branch = "Commissionerate";
}else if($scope.branch ==="DGP Office Mumbai"){
    joinCode = "DG_HQ";
     branch = "DGP Office Mumbai";
}else if($scope.branch ==="Motor Transport"){
    joinCode = "MT_MUM";
     branch = "Motor Transport";
}else if($scope.branch ==="Railway"){
    joinCode = "RPF_HQ";
     branch = "Railway";
}else if($scope.branch ==="Range"){
    joinCode = "RGIG";
     branch = "Range";
}else if($scope.branch ==="Special Unit"){
    joinCode = "SPO";
     branch = "Special Unit";
}else if($scope.branch ==="SRPF"){
    joinCode = "SRP";
     branch = "SRPF";
}else if($scope.branch ==="State Central Pool"){
    joinCode = "CEN_POOL";
     branch = "State Central Pool";
}else if($scope.branch ==="State Intelligence Department"){
    joinCode = "SID";
     branch = "State Intelligence Department";
}else if($scope.branch ==="Traffic"){
    joinCode = "TRF";
     branch = "Traffic";
}else if($scope.branch ==="Training"){
     joinCode = "ADG_TRG";
      branch = "Training";
}else if($scope.branch ==="Wireless"){
     joinCode = "WLL_HQ";
      branch = "Wireless";
}else{
   // $scope.branch ="";
     branch = "NULL";
}

if($scope.dataentry == true){
	dataentry = 1;
}else{
	dataentry = 0;
}

if($scope.validation == true){
	per_validate = 1;
}else{
	per_validate = 0;
}

if($scope.view == true){
	per_view = 1;
}else{
	per_view = 0;
}

if($scope.deskOfficer == true){
	deskOfficer = 1;
}else{
	deskOfficer = 0;
}
if($scope.gisViewer == true){
	gisViewer = 1;
}else{
	gisViewer = 0;
}


	
	 $scope.permiObj ={
		"branch":branch,
		"joinCode":joinCode,
		"level0":level0,
		"level1":level1,
		"level2":level2,
		"level3":level3,
		"mod_id":$scope.moduleid,
		"usr_rank": $scope.rank ,
		"applied_by": usr_id ,
		"applied_on":"NULL",
		 "per_view":per_view,
	     "per_validate":per_validate,
	     "per_dataentry":dataentry,
	     "deskOfficer":deskOfficer,
	     "gisViewer":gisViewer
		
	};
	
	$http.post("ModPermissionRest/saveModPermissionBulk",$scope.permiObj).then(function(response){
		if(response.data === "true"  || response.data ===true){
			
            alert("Permission assigned successfully");			
			$scope.getUpdatedRecord();
		}else{			
			alert("Error to save data ! ");
		}
	}, function error(response) {
  	  alert("! Error occured.");
    });
	
	
	
	
}

$scope.getUpdatedRecord = function(){
	
	$http.post("ModPermissionRest/getBulkUpdatedRecords",$scope.permiObj).then(function(response){
		if(response.data.length == 0){
			//alert("Error to save data ! ");
		}else{
		//	alert("Permission assigned successfully");
			$scope.modPermissionObj = response.data;
			
			
		}
	}, function error(response) {
  	  alert("! Error occured.");
    });
}


$scope.searchUsersByRankBranchWise = function(){
	
	document.getElementById("filterData").style.display = "block";
	document.getElementById("updatedData").style.display = "none";
	
	 var distZone = "NULL";
	 var email = "NULL";
	 var cityRange = "NULL"	
	var level1 = "NULL";
	var level2 = "NULL";
	var level3 = "NULL";
	var level0 = "NULL"; 
	var branch = "NULL";
	var joinCode = "NULL";
	var per_view;
	var per_validate;
	var per_dataentry;
	var deskOfficer;
	var gisViewer;
	
		
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
if($scope.branch !== undefined && $scope.branch !== null && $scope.branch !==""){
	level0 = $scope.level0;
}
if($scope.cityRange !== undefined && $scope.cityRange !== null && $scope.cityRange !==""){
	level1 = $scope.cityRange;
}
if(distZone !== undefined && distZone !== null && distZone !==""){
	level2 = distZone;
}
if($scope.ps_station !== undefined && $scope.ps_station !== null && $scope.ps_station !==""){
	level3 = $scope.ps_station;
}

if($scope.branch ==="Anti Naxal Operation"){
    joinCode = "ANO";
    branch = "Anti Naxal Operation";
}else if($scope.branch ==="Anti-Terrorism Squad"){
    joinCode = "ATS";
     branch = "Anti-Terrorism Squad";
}else if($scope.branch ==="CID"){
    joinCode = "CID_HQ";
     branch = "CID";
}else if($scope.branch ==="Commissionerate"){
    joinCode = "RGCM";
     branch = "Commissionerate";
}else if($scope.branch ==="DGP Office Mumbai"){
    joinCode = "DG_HQ";
     branch = "DGP Office Mumbai";
}else if($scope.branch ==="Motor Transport"){
    joinCode = "MT_MUM";
     branch = "Motor Transport";
}else if($scope.branch ==="Railway"){
    joinCode = "RPF_HQ";
     branch = "Railway";
}else if($scope.branch ==="Range"){
    joinCode = "RGIG";
     branch = "Range";
}else if($scope.branch ==="Special Unit"){
    joinCode = "SPO";
     branch = "Special Unit";
}else if($scope.branch ==="SRPF"){
    joinCode = "SRP";
     branch = "SRPF";
}else if($scope.branch ==="State Central Pool"){
    joinCode = "CEN_POOL";
     branch = "State Central Pool";
}else if($scope.branch ==="State Intelligence Department"){
    joinCode = "SID";
     branch = "State Intelligence Department";
}else if($scope.branch ==="Traffic"){
    joinCode = "TRF";
     branch = "Traffic";
}else if($scope.branch ==="Training"){
     joinCode = "ADG_TRG";
      branch = "Training";
}else if($scope.branch ==="Wireless"){
     joinCode = "WLL_HQ";
      branch = "Wireless";
}else{
   // $scope.branch ="";
     branch = "NULL";
}

if($scope.dataentry == true){
	dataentry = 1;
}else{
	dataentry = 0;
}

if($scope.validation == true){
	per_validate = 1;
}else{
	per_validate = 0;
}

if($scope.view == true){
	per_view = 1;
}else{
	per_view = 0;
}

if($scope.deskOfficer == true){
	deskOfficer = 1;
}else{
	deskOfficer = 0;
}
if($scope.gisViewer == true){
	gisViewer = 1;
}else{
	gisViewer = 0;
}


	 		
	
	
	
	 $scope.permiObj ={
		"branch":branch,
		"joinCode":joinCode,
		"level0":level0,
		"level1":level1,
		"level2":level2,
		"level3":level3,
		"mod_id":$scope.moduleid,
		"usr_rank": $scope.rank ,
		"applied_by": usr_id ,
		"applied_on":"NULL",
		 "per_view":per_view,
	     "per_validate":per_validate,
	     "per_dataentry":dataentry,
	     "deskOfficer":deskOfficer,
	     "gisViewer":gisViewer
		
	};
	
	$http.post("UsersRest/getusersDataBranchWise",$scope.permiObj).then(function(response){
		
			$scope.userInfoFilterObj = response.data;
								
	});
}


$scope.updateUsersBySelecting  = function(){
	
	var updateDataArr = [];
	for(var i = 1;i<= $scope.userInfoFilterObj.length; i++ ){
		
		var usrid = document.getElementById("userId"+i).innerHTML;
		
		var mod_Id = document.getElementById("moduleid"+i).value;
		var modArr = mod_Id.split(":");
		var modId = modArr[1];
		var dataentry = document.getElementById("dataentry"+i);
		var view = document.getElementById("view"+i);
		var deskOfficer = document.getElementById("deskOfficer"+i);
		var gisViewer = document.getElementById("gisViewer"+i);
						
		
		var per_view;
		var per_validate;
		var per_dataentry;
		var per_deskOfficer;
		var per_gisViewer;
		var per_validate = 0;
		
		if(dataentry.checked == true){
			per_dataentry = 1;
		}else{
			per_dataentry = 0;
		}
		
//		if($scope.validation == true){
//			per_validate = 1;
//		}else{
//			per_validate = 0;
//		}

		if(view.checked == true){
			per_view = 1;
		}else{
			per_view = 0;
		}
		
		if(deskOfficer.checked == true){
			per_deskOfficer = 1;
		}else{
			per_deskOfficer = 0;
		}
		if(gisViewer.checked == true){
			per_gisViewer = 1;
		}else{
			per_gisViewer = 0;
		}

		
		
		var permObj = {
								
				  "mod_id":parseInt(modId),
				  "sevarthnum":parseInt(usrid),
			      "per_view":per_view,
				  "per_validate":per_validate,
			      "per_dataentry":per_dataentry,
			      "per_desk":per_deskOfficer,
			      "per_gis":per_gisViewer,
				  "applied_by":usr_id											
		}
		if(modId !== undefined && modId !== "undefined"){
		updateDataArr.push(permObj);
		}
	}
	
	$http.post("ModPermissionRest/saveUserPermBySelect",updateDataArr).then(function(response){
		
		if(response.data == "true"  || response.data == true ){
			alert("Permission is assigned successfully to selected the users");
		}else{
			alert("Error to assign permission");
		}
	}, function error(response) {
  	  alert("! Error occured.");
    })
	
};


$scope.printDiv=function() {
   
                var dvExcelData = document.getElementById('dvExcelData');

                var newWin = window.open('', 'Print-Window');

                newWin.document.open();

                newWin.document.write('<html><head><link rel="stylesheet" 	href="assets/vendor/bootstrap/css/bootstrap.min.css"><link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet"><link rel="stylesheet" href="assets/libs/css/style.css">'
                	                		                	
                		+'<link rel="stylesheet"'
                			+'href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">'
                		+'<link rel="stylesheet"'
                			+'href="assets/vendor/charts/chartist-bundle/chartist.css">'
                		+'<link rel="stylesheet"'
                			+'href="assets/vendor/charts/morris-bundle/morris.css">'
                		+'<link rel="stylesheet"'
                		+	'href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">'
                		+'<link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">'
                		+'<link rel="stylesheet"'
                			+'href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css"></head><body onload="window.print()">' + dvExcelData.innerHTML + '</body></html>');

                newWin.document.close();

                setTimeout(function () { newWin.close(); }, 10);

            };

            

$scope.clearForm = function(){
	
	
	$scope.level0 ="";
    $scope.cityRange = null;
	$scope.distZone =null;
	$scope.ps_station =null;	
	$scope.branch = null;
	$scope.rank = null;
	 $scope.moduleid = null;
	 $scope.dataentry = false;
	 $scope.validation = false;
	 $scope.deskOfficer = false;
	 $scope.gisViewer = false;
	 $scope.view = false;

	document.getElementById("hidedist").style.display ="block";
	
}
	
	$scope.onload();
})


// unit rone management
.controller("unitManagementController",function($scope,$http,$window){
	
	$scope.onload = function(){	
		document.getElementById("loader").style.display = "block";
		$scope.flag = 0;
		var unitObj  = {};
		$http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
	    }, function error(response) {
	    	  document.getElementById("logoutForm").submit();
	    })
	    
	    
	    $http.get("UnitManagementRest/getRoneAllRecords").then(function(response){
	    	$scope.RoneDataObj = response.data;
	    	document.getElementById("loader").style.display = "none";
	    	
	    })
	    
	};
	
	
	
	
	
	$scope.saveRoneRecord = function(){
		
		if($scope.flag === 0){
					 unitObj = {
										 	 
								 "srno": 0,			
							     "ps_code" : $scope.ps_code,
							     "zncode" : $scope.zncode,
							     "rng_code" : $scope.rng_code,
							     "ps_name"  : $scope.ps_name,
								 "dtename" : $scope.dtename,
								 "ps_cctns" : $scope.ps_cctns,
								 "dg_code" : $scope.dg_code,
							     "cp_sp_rpf"  : $scope.cp_sp_rpf,
								 "cityrange_n" : $scope.cityrange_n,
								 "zone_n"  : $scope.zone_n,
							     "jurisdiction" : $scope.JURISDICTION,
								 "police_stn_lat"  : $scope.police_stn_lat,
							     "police_stn_long" : $scope.police_stn_long,
							     "range_cent_lat" : $scope.range_cent_lat,
								 "range_cent_long" : $scope.range_cent_long,
								 "dist_cent_lat" : $scope.dist_cent_lat,
								 "dist_cent_long" : $scope.dist_cent_long,
								 "police_stn_lat_n" : $scope.police_stn_lat_n,
								 "police_stn_long_n" : $scope.police_stn_long_n,
								 "population" : $scope.population,
								 "district_id" : $scope.district_id,
								 "range_id" : $scope.range_id,
								 "level0" : $scope.Level0,
								 "level1" : $scope.Level1,
								 "level2" : $scope.Level2,
								 "level3" : $scope.Level3,
								  "branch" : $scope.branch
					};
		}else{
			
			 unitObj = {
				 	 "id" :$scope.id,
					 "srno": $scope.srno,			
				     "ps_code" : $scope.ps_code,
				     "zncode" : $scope.zncode,
				     "rng_code" : $scope.rng_code,
				     "ps_name"  : $scope.ps_name,
					 "dtename" : $scope.dtename,
					 "ps_cctns" : $scope.ps_cctns,
					 "dg_code" : $scope.dg_code,
				     "cp_sp_rpf"  : $scope.cp_sp_rpf,
					 "cityrange_n" : $scope.cityrange_n,
					 "zone_n"  : $scope.zone_n,
				     "jurisdiction" : $scope.JURISDICTION,
					 "police_stn_lat"  : $scope.police_stn_lat,
				     "police_stn_long" : $scope.police_stn_long,
				     "range_cent_lat" : $scope.range_cent_lat,
					 "range_cent_long" : $scope.range_cent_long,
					 "dist_cent_lat" : $scope.dist_cent_lat,
					 "dist_cent_long" : $scope.dist_cent_long,
					 "police_stn_lat_n" : $scope.police_stn_lat_n,
					 "police_stn_long_n" : $scope.police_stn_long_n,
					 "population" : $scope.population,
					 "district_id" : $scope.district_id,
					 "range_id" : $scope.range_id,
					 "level0" : $scope.Level0,
					 "level1" : $scope.Level1,
					 "level2" : $scope.Level2,
					 "level3" : $scope.Level3,
					  "branch" : $scope.branch
		};
			
		}
		
		
	
	$http.post("UnitManagementRest/saveRoneRecordRest",unitObj).then(function(response){					
		if(response.data !== null || response.data !== "null"){
			if($scope.flag === 0){
				alert("Data inserted successfully");
				$scope.onload();	
			}else{
				alert("Data updated successfully");
				$scope.flag === 0;
				$scope.onload();	
			}
						
			$scope.clearForm();
		}else{
			alert("Error ! Something is wrong.");
		}
}, function error(response) {
	  alert("!Error occured.");
});			
		
	};
	
	$scope.updateRoneRecord = function(id){
		$window.scrollTo(0, 0);
		$scope.flag = 1;
		$http.get("UnitManagementRest/getRoneRecordsById",{params:{id:id}}).then(function(response){
			
			
			 $scope.id = response.data.id;
			 $scope.srno =	response.data.srno;	
		     $scope.ps_code = response.data.ps_code;
		     $scope.zncode = response.data.zncode;
		     $scope.rng_code = response.data.rng_code;
		     $scope.ps_name = response.data.ps_name;
			 $scope.dtename = response.data.dtename;
			 $scope.ps_cctns = response.data.ps_cctns;
			 $scope.dg_code = response.data.dg_code;
		      $scope.cp_sp_rpf = response.data.cp_sp_rpf;
			 $scope.cityrange_n = response.data.cityrange_n;
			 $scope.zone_n = response.data.zone_n;
		     $scope.JURISDICTION = response.data.jurisdiction;
			 $scope.police_stn_lat = response.data.police_stn_lat;
		     $scope.police_stn_long = response.data.police_stn_long;
		     $scope.range_cent_lat = response.data.range_cent_lat;
			 $scope.range_cent_long = response.data.range_cent_long;
			$scope.dist_cent_lat = response.data.dist_cent_lat;
			 $scope.dist_cent_long = response.data.dist_cent_long;
			 $scope.police_stn_lat_n = response.data.police_stn_lat_n;
			  $scope.police_stn_long_n = response.data.police_stn_long_n;
			$scope.population = response.data.population;
			$scope.district_id = response.data.district_id;
			 $scope.range_id = response.data.range_id;
			$scope.Level0 = response.data.level0;
			 $scope.Level1 = response.data.level1;
			 $scope.Level2 = response.data.level2;
			 $scope.Level3 = response.data.level3;
			 $scope.branch = response.data.branch;
			
		});
	};
	
	
	$scope.deleteRoneRecordById = function(id){
		
		$http.get("UnitManagementRest/deleteRoneRecordsById",{params:{id:id}}).then(function(response){
			
			if(response.data === "true" || response.data === true){
				$scope.onload();
				alert("Record deleted successfully");
			}else{
				alert("Error occured to delete record.");
			}
			
		});
		
	}
	
	
	$scope.clearForm = function(){
		
		 $scope.id = "";
		 $scope.srno =	"";
	     $scope.ps_code = "";
	     $scope.zncode = "";
	     $scope.rng_code = "";
	     $scope.ps_name = "";
		 $scope.dtename = "";
		 $scope.ps_cctns = "";
		 $scope.dg_code = "";
	      $scope.cp_sp_rpf = "";
		 $scope.cityrange_n = "";
		 $scope.zone_n = "";
	     $scope.JURISDICTION = "";
		 $scope.police_stn_lat = "";
	     $scope.police_stn_long = "";
	     $scope.range_cent_lat = "";
		 $scope.range_cent_long = "";
		$scope.dist_cent_lat = "";
		 $scope.dist_cent_long = "";
		 $scope.police_stn_lat_n = "";
		  $scope.police_stn_long_n = "";
		$scope.population = "";
		$scope.district_id = "";
		 $scope.range_id = "";
		$scope.Level0 = "";
		 $scope.Level1 = "";
		 $scope.Level2 = "";
		 $scope.Level3 = "";
		 $scope.branch = "";
		 $scope.flag = 0;
	};
	
	
	
	$scope.onload();
	
})

.controller("loginHistoryController",function($scope,$http,$window){
	
	
	$scope.onload = function(){
		
		$http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
	    }, function error(response) {
	    	  document.getElementById("logoutForm").submit();
	    });
		
		document.getElementById("loader").style.display = "block";

		$http.get("LoginAttemptRest/getLoginHistory").then(function(response){
			$scope.loginHistoryObj = response.data;
			document.getElementById("loader").style.display = "none";
		});
	};
	
	$scope.getReport = function(){
		var fromDate = document.getElementById("fromDate").value + " 00:00:00";
		var toDate = document.getElementById("toDate").value + " 00:00:00";
		
		document.getElementById("loader").style.display = "block";
		$http.get("LoginAttemptRest/getLoginHistoryMonthWise",{params:{fromDate:fromDate,toDate:toDate}}).then(function(response){
			$scope.loginHistoryObj = response.data;
			document.getElementById("loader").style.display = "none";
		},function(error){
			document.getElementById("loader").style.display = "none";
		});
	}
	
	
	$scope.onload();
})

.controller("userCountReportController",function($scope,$http,$window){
	
	
	$scope.onload = function(){
		
		 document.getElementById("loader").style.display = "none"; 
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    });
		
		document.getElementById("filterData").style.display = "none";
		document.getElementById("updatedData").style.display = "none";
		
		$http.get("UnitRest/getBranches").then(function(response){
			$scope.branchObj = response.data;
		});
		
		$http.get("RankRest/findAllRanks").then(function(response){
			$scope.rankObj = response.data;
			
		});
		
		
		
		$scope.moduleDataObj = [];
		$http.get("UsersRest/readUsersByAdmin",{params:{userType:user_type}}).then(function(response){		
			$scope.sevarthNumObj = response.data;
		})
		
		if(user_type !== "Module Admin"){
		$http.get("ModuleRest/getModuleData",{params:{sevarthNum:sevarth_num}}).then(function(response){					
					$scope.moduleDataObj = response.data;
	    })
		}else{
			$http.get("ModPermissionRest/getModuleBysevarthId",{params:{SevarthId : usr_id}}).then(function(response){
			//	$scope.moduleDataObj = response.data;
				$scope.moduleDataObj = [];
				for(var i = 0 ; i < response.data.length ; i++ ){
					$scope.moduleDataObj.push(response.data[i].bean);
				}
				
			})
			
		}
		
		
		
		document.getElementById("hidedist").style.display ="block";	
	}
	

	$scope.onChangeBranch = function(){
		$scope.cityRangeObj = null;
		if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
			document.getElementById("hidedist").style.display ="block";
		}
		
		$http.get("UnitRest/getLevel1Data",{params:{"branch":$scope.branch}}).then(function(response){
			$scope.cityRangeObj = response.data;
			if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
				$scope.policeStationObj = response.data;
			}
			
			
			if($scope.branch =="Commissionerate" || $scope.branch =="Range"){
				document.getElementById("hidedist").style.display ="none";
				$scope.policeStationObj = null;
			}else{
				document.getElementById("hidedist").style.display ="block";
				
			}
		})	
		$scope.distZoneObj = null;
		
		for(var i = 0;i < $scope.branchObj.length;i++){
			if($scope.branchObj[i].branch ===$scope.branch ){
				$scope.level0 =  $scope.branchObj[i].level0;
			}
		}
				
	}
	
	$scope.onChangeCityRange = function(){
		
		$http.get("UnitRest/getLevel2Data",{params:{"branch":$scope.branch,"level1":$scope.cityRange}}).then(function(response){
			$scope.distZoneObj = response.data;
								
		})
	}
	
	
$scope.onChangeDistZone = function(){
	var distZoneVal = document.getElementById("distZone").value ;
	 var distZoneArr =  distZoneVal.split(":");
	 var distZone = distZoneArr[1]; 
	
		$http.get("UnitRest/getPoliceStation",{params:{"level2":distZone}}).then(function(response){
			
			$scope.policeStationObj = response.data;							
		})
};



$scope.getCount = function(){
	
	 document.getElementById("loader").style.display = "block"; 
	document.getElementById("filterData").style.display = "block";
	document.getElementById("updatedData").style.display = "none";
	
	 var distZone = "NULL";
	
	 var cityRange = "NULL"	
	var level1 = "NULL";
	var level2 = "NULL";
	var level3 = "NULL";
	var level0 = "NULL"; 
	var branch = "NULL";
	var joinCode = "NULL";
	var usr_rank = "NULL";
	
	
		
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
if($scope.branch !== undefined && $scope.branch !== null && $scope.branch !==""){
	level0 = $scope.level0;
}
if($scope.cityRange !== undefined && $scope.cityRange !== null && $scope.cityRange !==""){
	level1 = $scope.cityRange;
}
if(distZone !== undefined && distZone !== null && distZone !==""){
	level2 = distZone;
}
if($scope.ps_station !== undefined && $scope.ps_station !== null && $scope.ps_station !==""){
	level3 = $scope.ps_station;
}
if($scope.rank !== undefined && $scope.rank !== null && $scope.rank !==""){
	usr_rank = $scope.rank;
}

if($scope.branch ==="Anti Naxal Operation"){
    joinCode = "ANO";
    branch = "Anti Naxal Operation";
}else if($scope.branch ==="Anti-Terrorism Squad"){
    joinCode = "ATS";
     branch = "Anti-Terrorism Squad";
}else if($scope.branch ==="CID"){
    joinCode = "CID_HQ";
     branch = "CID";
}else if($scope.branch ==="Commissionerate"){
    joinCode = "RGCM";
     branch = "Commissionerate";
}else if($scope.branch ==="DGP Office Mumbai"){
    joinCode = "DG_HQ";
     branch = "DGP Office Mumbai";
}else if($scope.branch ==="Motor Transport"){
    joinCode = "MT_MUM";
     branch = "Motor Transport";
}else if($scope.branch ==="Railway"){
    joinCode = "RPF_HQ";
     branch = "Railway";
}else if($scope.branch ==="Range"){
    joinCode = "RGIG";
     branch = "Range";
}else if($scope.branch ==="Special Unit"){
    joinCode = "SPO";
     branch = "Special Unit";
}else if($scope.branch ==="SRPF"){
    joinCode = "SRP";
     branch = "SRPF";
}else if($scope.branch ==="State Central Pool"){
    joinCode = "CEN_POOL";
     branch = "State Central Pool";
}else if($scope.branch ==="State Intelligence Department"){
    joinCode = "SID";
     branch = "State Intelligence Department";
}else if($scope.branch ==="Traffic"){
    joinCode = "TRF";
     branch = "Traffic";
}else if($scope.branch ==="Training"){
     joinCode = "ADG_TRG";
      branch = "Training";
}else if($scope.branch ==="Wireless"){
     joinCode = "WLL_HQ";
      branch = "Wireless";
}
else if($scope.branch ==="ACB"){
    joinCode = "ACB";
     branch = "ACB";
}else if($scope.branch ==="SDRF"){
    joinCode = "SDR";
    branch = "SDRF";
}else{
   // $scope.branch ="";
     branch = "NULL";
}
	 		
	
	
	
	 $scope.permiObj ={
		"branch":branch,
		"joinCode":joinCode,
		"level0":level0,
		"level1":level1,
		"level2":level2,
		"level3":level3,		
		"usr_rank": usr_rank 
				
	};
	 
	 $http.post("UsersRest/getUserCountByFilter",$scope.permiObj).then(function(response){
		 $scope.userCountObj = response.data;
		 
		 document.getElementById("userCountData").innerHTML ="";
		 for(var i=0;i<$scope.userCountObj.length;i++){
			
			 document.getElementById("userCountData").innerHTML +='<tr><td>'+(parseInt(i)+parseInt(1))+'</td><td>'+$scope.userCountObj[i][0]+'</td><td>'+$scope.userCountObj[i][1]+'</td><td>'+$scope.userCountObj[i][2]+'</td></tr>';
		 }
		 document.getElementById("loader").style.display = "none";  
	 })
	 
	
	
//	$http.post("UsersRest/getusersDataBranchWise",$scope.permiObj).then(function(response){
//		
//			$scope.userInfoFilterObj = response.data;
//								
//	});
};


$scope.getUserDetail = function(){
	 document.getElementById("loader").style.display = "block";
	
	document.getElementById("filterData").style.display = "none";
	document.getElementById("updatedData").style.display = "block";
	
	 var distZone = "NULL";
	
	 var cityRange = "NULL"	
	var level1 = "NULL";
	var level2 = "NULL";
	var level3 = "NULL";
	var level0 = "NULL"; 
	var branch = "NULL";
	var joinCode = "NULL";
	var usr_rank = "NULL";
	
	
		
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
if($scope.branch !== undefined && $scope.branch !== null && $scope.branch !==""){
	level0 = $scope.level0;
}
if($scope.cityRange !== undefined && $scope.cityRange !== null && $scope.cityRange !==""){
	level1 = $scope.cityRange;
}
if(distZone !== undefined && distZone !== null && distZone !==""){
	level2 = distZone;
}
if($scope.ps_station !== undefined && $scope.ps_station !== null && $scope.ps_station !==""){
	level3 = $scope.ps_station;
}
if($scope.rank !== undefined && $scope.rank !== null && $scope.rank !==""){
	usr_rank = $scope.rank;
}

if($scope.branch ==="Anti Naxal Operation"){
    joinCode = "ANO";
    branch = "Anti Naxal Operation";
}else if($scope.branch ==="Anti-Terrorism Squad"){
    joinCode = "ATS";
     branch = "Anti-Terrorism Squad";
}else if($scope.branch ==="CID"){
    joinCode = "CID_HQ";
     branch = "CID";
}else if($scope.branch ==="Commissionerate"){
    joinCode = "RGCM";
     branch = "Commissionerate";
}else if($scope.branch ==="DGP Office Mumbai"){
    joinCode = "DG_HQ";
     branch = "DGP Office Mumbai";
}else if($scope.branch ==="Motor Transport"){
    joinCode = "MT_MUM";
     branch = "Motor Transport";
}else if($scope.branch ==="Railway"){
    joinCode = "RPF_HQ";
     branch = "Railway";
}else if($scope.branch ==="Range"){
    joinCode = "RGIG";
     branch = "Range";
}else if($scope.branch ==="Special Unit"){
    joinCode = "SPO";
     branch = "Special Unit";
}else if($scope.branch ==="SRPF"){
    joinCode = "SRP";
     branch = "SRPF";
}else if($scope.branch ==="State Central Pool"){
    joinCode = "CEN_POOL";
     branch = "State Central Pool";
}else if($scope.branch ==="State Intelligence Department"){
    joinCode = "SID";
     branch = "State Intelligence Department";
}else if($scope.branch ==="Traffic"){
    joinCode = "TRF";
     branch = "Traffic";
}else if($scope.branch ==="Training"){
     joinCode = "ADG_TRG";
      branch = "Training";
}else if($scope.branch ==="Wireless"){
     joinCode = "WLL_HQ";
      branch = "Wireless";
}
else if($scope.branch ==="ACB"){
    joinCode = "ACB";
     branch = "ACB";
}else if($scope.branch ==="SDRF"){
    joinCode = "SDR";
    branch = "SDRF";
}else{
   // $scope.branch ="";
     branch = "NULL";
}
	 		
		
	 $scope.permiObj ={
		"branch":branch,
		"joinCode":joinCode,
		"level0":level0,
		"level1":level1,
		"level2":level2,
		"level3":level3,		
		"usr_rank": usr_rank 
				
	};
	 
	 
	 $http.post("UsersRest/getUserDetailByFilter",$scope.permiObj).then(function(response){
		 $scope.userDetailObj = response.data;
		
		 document.getElementById("userDetailData").innerHTML ="";
		 for(var i=0;i<$scope.userDetailObj.length;i++){
			
			 document.getElementById("userDetailData").innerHTML +='<tr><td>'+(parseInt(i)+parseInt(1))+'</td><td>'+$scope.userDetailObj[i][0]+'</td><td>'+$scope.userDetailObj[i][1]+'</td><td>'+$scope.userDetailObj[i][2]+'</td><td>'+$scope.userDetailObj[i][3]+'</td><td>'+$scope.userDetailObj[i][4]+'</td><td>'+$scope.userDetailObj[i][5]+'</td><td>'+$scope.userDetailObj[i][6]+'</td></tr>';
		 }
		 document.getElementById("loader").style.display = "none"; 
	 })
	
};


$scope.clearForm = function(){
	$scope.branch=null;
	$scope.cityRange=null;
	$scope.ps_station = null;
	document.getElementById("distZone").value="";
	$scope.distZone= null;
	document.getElementById("hidedist").style.display ="block";
	$scope.level0="";
}


$scope.onload();

$("#btnExport").click(function (e) {
    $(this).attr({
        'download': "Reports.xls",
        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData1').html())
    });
});

$("#btnExport1").click(function (e) {
    $(this).attr({
        'download': "Reports.xls",
        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData').html())
    });
});
	
	
	
})

.controller("moduleAssignedReportController",function($scope,$http){
	
	
	$scope.onload = function(){
		
		 document.getElementById("loader").style.display = "none"; 
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		
		document.getElementById("filterData").style.display = "none";
		document.getElementById("updatedData").style.display = "none";
		
		$http.get("UnitRest/getBranches").then(function(response){
			$scope.branchObj = response.data;
		});
		
		$http.get("RankRest/findAllRanks").then(function(response){
			$scope.rankObj = response.data;
			
		});
		
		
		
		$scope.moduleDataObj = [];
		$http.get("UsersRest/readUsersByAdmin",{params:{userType:user_type}}).then(function(response){		
			$scope.sevarthNumObj = response.data;
		})
		
		if(user_type !== "Module Admin"){
		$http.get("ModuleRest/getModuleData",{params:{sevarthNum:sevarth_num}}).then(function(response){					
					$scope.moduleDataObj = response.data;
	    })
		}else{
			$http.get("ModPermissionRest/getModuleBysevarthId",{params:{SevarthId : usr_id}}).then(function(response){
			//	$scope.moduleDataObj = response.data;
				$scope.moduleDataObj = [];
				for(var i = 0 ; i < response.data.length ; i++ ){
					$scope.moduleDataObj.push(response.data[i].bean);
				}
				
			})
			
		}
		
		
		
		document.getElementById("hidedist").style.display ="block";	
	}
	

	$scope.onChangeBranch = function(){
		$scope.cityRangeObj = null;
		if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
			document.getElementById("hidedist").style.display ="block";
		}
		
		$http.get("UnitRest/getLevel1Data",{params:{"branch":$scope.branch}}).then(function(response){
			$scope.cityRangeObj = response.data;
			if($scope.branch != 'Commissionerate' &&  $scope.branch !='Range'){
				$scope.policeStationObj = response.data;
			}
			
			
			if($scope.branch =="Commissionerate" || $scope.branch =="Range"){
				document.getElementById("hidedist").style.display ="none";
				$scope.policeStationObj = null;
			}else{
				document.getElementById("hidedist").style.display ="block";
				
			}
		})	
		$scope.distZoneObj = null;
		
		for(var i = 0;i < $scope.branchObj.length;i++){
			if($scope.branchObj[i].branch ===$scope.branch ){
				$scope.level0 =  $scope.branchObj[i].level0;
			}
		}
				
	}
	
	$scope.onChangeCityRange = function(){
		
		$http.get("UnitRest/getLevel2Data",{params:{"branch":$scope.branch,"level1":$scope.cityRange}}).then(function(response){
			$scope.distZoneObj = response.data;
								
		})
	}
	
	
$scope.onChangeDistZone = function(){
	var distZoneVal = document.getElementById("distZone").value ;
	 var distZoneArr =  distZoneVal.split(":");
	 var distZone = distZoneArr[1]; 
	
		$http.get("UnitRest/getPoliceStation",{params:{"level2":distZone}}).then(function(response){
			
			$scope.policeStationObj = response.data;							
		})
};



$scope.getCount = function(){
	
	 document.getElementById("loader").style.display = "block"; 
	document.getElementById("filterData").style.display = "block";
	document.getElementById("updatedData").style.display = "none";
	
	 var distZone = "NULL";
	
	 var cityRange = "NULL"	
	var level1 = "NULL";
	var level2 = "NULL";
	var level3 = "NULL";
	var level0 = "NULL"; 
	var branch = "NULL";
	var joinCode = "NULL";
	var usr_rank = "NULL";
	
	
		
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
if($scope.branch !== undefined && $scope.branch !== null && $scope.branch !==""){
	level0 = $scope.level0;
}
if($scope.cityRange !== undefined && $scope.cityRange !== null && $scope.cityRange !==""){
	level1 = $scope.cityRange;
}
if(distZone !== undefined && distZone !== null && distZone !==""){
	level2 = distZone;
}
if($scope.ps_station !== undefined && $scope.ps_station !== null && $scope.ps_station !==""){
	level3 = $scope.ps_station;
}
if($scope.rank !== undefined && $scope.rank !== null && $scope.rank !==""){
	usr_rank = $scope.rank;
}

if($scope.branch ==="Anti Naxal Operation"){
    joinCode = "ANO";
    branch = "Anti Naxal Operation";
}else if($scope.branch ==="Anti-Terrorism Squad"){
    joinCode = "ATS";
     branch = "Anti-Terrorism Squad";
}else if($scope.branch ==="CID"){
    joinCode = "CID_HQ";
     branch = "CID";
}else if($scope.branch ==="Commissionerate"){
    joinCode = "RGCM";
     branch = "Commissionerate";
}else if($scope.branch ==="DGP Office Mumbai"){
    joinCode = "DG_HQ";
     branch = "DGP Office Mumbai";
}else if($scope.branch ==="Motor Transport"){
    joinCode = "MT_MUM";
     branch = "Motor Transport";
}else if($scope.branch ==="Railway"){
    joinCode = "RPF_HQ";
     branch = "Railway";
}else if($scope.branch ==="Range"){
    joinCode = "RGIG";
     branch = "Range";
}else if($scope.branch ==="Special Unit"){
    joinCode = "SPO";
     branch = "Special Unit";
}else if($scope.branch ==="SRPF"){
    joinCode = "SRP";
     branch = "SRPF";
}else if($scope.branch ==="State Central Pool"){
    joinCode = "CEN_POOL";
     branch = "State Central Pool";
}else if($scope.branch ==="State Intelligence Department"){
    joinCode = "SID";
     branch = "State Intelligence Department";
}else if($scope.branch ==="Traffic"){
    joinCode = "TRF";
     branch = "Traffic";
}else if($scope.branch ==="Training"){
     joinCode = "ADG_TRG";
      branch = "Training";
}else if($scope.branch ==="Wireless"){
     joinCode = "WLL_HQ";
      branch = "Wireless";
}
else if($scope.branch ==="ACB"){
    joinCode = "ACB";
     branch = "ACB";
}else if($scope.branch ==="SDRF"){
    joinCode = "SDR";
    branch = "SDRF";
}else{
   // $scope.branch ="";
     branch = "NULL";
}
	 		
	
	
	
	 $scope.permiObj ={
		"branch":branch,
		"joinCode":joinCode,
		"level0":level0,
		"level1":level1,
		"level2":level2,
		"level3":level3,		
		"usr_rank": usr_rank 
				
	};
	 
	 $http.post("UsersRest/getUserTypeCountByFilter",$scope.permiObj).then(function(response){
		 $scope.userCountObj = response.data;
		
		 document.getElementById("userCountData").innerHTML ="";
		 for(var i=0;i<$scope.userCountObj.length;i++){
			 
			 document.getElementById("userCountData").innerHTML +='<tr><td>'+(parseInt(i)+parseInt(1))+'</td><td>'+$scope.userCountObj[i][0]+'</td><td>'+$scope.userCountObj[i][1]+'</td><td>'+$scope.userCountObj[i][2]+'</td></tr>';
		 }
		 document.getElementById("loader").style.display = "none";  
	 })
	 
	
};


$scope.getUserDetail = function(){
	 document.getElementById("loader").style.display = "block";
	
	document.getElementById("filterData").style.display = "none";
	document.getElementById("updatedData").style.display = "block";
	
	 var distZone = "NULL";
	
	 var cityRange = "NULL"	
	var level1 = "NULL";
	var level2 = "NULL";
	var level3 = "NULL";
	var level0 = "NULL"; 
	var branch = "NULL";
	var joinCode = "NULL";
	var usr_rank = "NULL";
	
	
		
	if(document.getElementById("distZone") !== null){
		var distZoneVal = document.getElementById("distZone").value ;
		
		 var distZoneArr =  distZoneVal.split(":");
		  distZone = distZoneArr[1]; 
	}
	if($scope.emailid !== null){
		email = $scope.emailid ;
	}
	if($scope.cityRange !== null){
		cityRange = $scope.cityRange;
	}
	
if($scope.branch !== undefined && $scope.branch !== null && $scope.branch !==""){
	level0 = $scope.level0;
}
if($scope.cityRange !== undefined && $scope.cityRange !== null && $scope.cityRange !==""){
	level1 = $scope.cityRange;
}
if(distZone !== undefined && distZone !== null && distZone !==""){
	level2 = distZone;
}
if($scope.ps_station !== undefined && $scope.ps_station !== null && $scope.ps_station !==""){
	level3 = $scope.ps_station;
}
if($scope.rank !== undefined && $scope.rank !== null && $scope.rank !==""){
	usr_rank = $scope.rank;
}

if($scope.branch ==="Anti Naxal Operation"){
    joinCode = "ANO";
    branch = "Anti Naxal Operation";
}else if($scope.branch ==="Anti-Terrorism Squad"){
    joinCode = "ATS";
     branch = "Anti-Terrorism Squad";
}else if($scope.branch ==="CID"){
    joinCode = "CID_HQ";
     branch = "CID";
}else if($scope.branch ==="Commissionerate"){
    joinCode = "RGCM";
     branch = "Commissionerate";
}else if($scope.branch ==="DGP Office Mumbai"){
    joinCode = "DG_HQ";
     branch = "DGP Office Mumbai";
}else if($scope.branch ==="Motor Transport"){
    joinCode = "MT_MUM";
     branch = "Motor Transport";
}else if($scope.branch ==="Railway"){
    joinCode = "RPF_HQ";
     branch = "Railway";
}else if($scope.branch ==="Range"){
    joinCode = "RGIG";
     branch = "Range";
}else if($scope.branch ==="Special Unit"){
    joinCode = "SPO";
     branch = "Special Unit";
}else if($scope.branch ==="SRPF"){
    joinCode = "SRP";
     branch = "SRPF";
}else if($scope.branch ==="State Central Pool"){
    joinCode = "CEN_POOL";
     branch = "State Central Pool";
}else if($scope.branch ==="State Intelligence Department"){
    joinCode = "SID";
     branch = "State Intelligence Department";
}else if($scope.branch ==="Traffic"){
    joinCode = "TRF";
     branch = "Traffic";
}else if($scope.branch ==="Training"){
     joinCode = "ADG_TRG";
      branch = "Training";
}else if($scope.branch ==="Wireless"){
     joinCode = "WLL_HQ";
      branch = "Wireless";
}
else if($scope.branch ==="ACB"){
    joinCode = "ACB";
     branch = "ACB";
}else if($scope.branch ==="SDRF"){
    joinCode = "SDR";
    branch = "SDRF";
}else{
   // $scope.branch ="";
     branch = "NULL";
}
	 		
		
	 $scope.permiObj ={
		"branch":branch,
		"joinCode":joinCode,
		"level0":level0,
		"level1":level1,
		"level2":level2,
		"level3":level3,		
		"usr_rank": usr_rank 
				
	};
	 
	 
	 $http.post("UsersRest/getUserDetailByFilter",$scope.permiObj).then(function(response){
		 $scope.userDetailObj = response.data;
		
		 document.getElementById("userDetailData").innerHTML ="";
		 for(var i=0;i<$scope.userDetailObj.length;i++){
			 
			
			 document.getElementById("userDetailData").innerHTML +='<tr><td>'+(parseInt(i)+parseInt(1))+'</td><td>'+$scope.userDetailObj[i][0]+'</td><td>'+$scope.userDetailObj[i][7]+'</td><td>'+$scope.userDetailObj[i][2]+'</td><td>'+$scope.userDetailObj[i][3]+'</td><td>'+$scope.userDetailObj[i][4]+'</td><td>'+$scope.userDetailObj[i][5]+'</td><td>'+$scope.userDetailObj[i][6]+'</td>'
			 +'<td> <table class="table table-striped"><tbody id="usr'+i+'"></tbody></table> </td>       </tr>';
			 
		 }
		 for(var i=0;i<$scope.userDetailObj.length;i++){
		 for(var j=0;j<$scope.userDetailObj[i][8].length;j++){
			 document.getElementById("usr"+i).innerHTML += '<tr><td>'+$scope.userDetailObj[i][8][j]+'</td></tr>';
		 }
		 }
		 document.getElementById("loader").style.display = "none"; 
	 })
	
};


$scope.clearForm = function(){
	$scope.branch=null;
	$scope.cityRange=null;
	$scope.ps_station = null;
	document.getElementById("distZone").value="";
	$scope.distZone= null;
	document.getElementById("hidedist").style.display ="block";
	$scope.level0="";
}

$scope.onload();

$("#btnExport").click(function (e) {
    $(this).attr({
        'download': "Reports.xls",
        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData1').html())
    });
});

$("#btnExport1").click(function (e) {
    $(this).attr({
        'download': "Reports.xls",
        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData').html())
    });
});
	
	
})

.controller("entryUpdateReportController",function($scope,$http){
	
	$scope.onload = function(){
		//http://117.222.38.169:9090
		document.getElementById("loader").style.display = "none";
		
		 $http.get("UsersRest/getUserDataFromSession").then(function(response){			 		 
		    }, function error(response) {
		    	  document.getElementById("logoutForm").submit();
		    })
		    
		    
		  $scope.sevarth_id = sevarth_id;		 
		  $scope.unitnames = unitnames;
		  
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();
			today = yyyy + '-' + mm + '-'+dd;
			$scope.todayDate = today;
			
			
			$scope.month = new Date(yyyy, (parseInt(mm)-1), dd);
	};
	
	$scope.getReport = function(){
		
		
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();

		today = yyyy + '-' + mm ;
		
		//console.log("month = "+document.getElementById("month").value+" month="+$scope.month);
		var month = document.getElementById("monthThis").value;
		
		
		var selectedMonth = new Date($scope.month);
		var newDate = new Date($scope.month.setMonth($scope.month.getMonth()+1));
		
			
		var selectedDate = newDate.getFullYear()+"-"+  ('0' + (parseInt(newDate.getMonth())+1)).slice(-2);
		var selectedDateForOther = selectedMonth.getFullYear()+"-"+    ('0' + (parseInt(selectedMonth.getMonth())+1)).slice(-2);
		
		
		if($scope.moduleid == "da"){
			document.getElementById("loader").style.display = "block";
			$http.get("http://117.222.38.169:9090/suspension_form/rest/EnteredEntryRest/getDisciplinaryStatus",{params:{date:selectedDate}}).then(function(response){
				
				$scope.dispObj = response.data;
				document.getElementById("loader").style.display = "none";
			}, function error(response) {
				document.getElementById("loader").style.display = "none";
				
		    })
			
		    $scope.reportType = null;
			$scope.ArmsReportType = null;
		    
		}else if($scope.moduleid == "wa"){			
			document.getElementById("loader").style.display = "block";
			$http.get("http://117.222.38.169:9090/WelfareActivityProject/rest/EntryUpdateRest/welfareUpdatedStatus",{params:{date:selectedDateForOther}}).then(function(response){
				
				$scope.fundObj = response.data[0].fundObj;
				$scope.bankObj = response.data[1].bankDetailObj;
				$scope.loanObj = response.data[2].loanObj;
				$scope.schemeObj = response.data[3].schemeObj;
				document.getElementById("loader").style.display = "none";
			}, function error(response) {
				document.getElementById("loader").style.display = "none";
		    })
			$scope.ArmsReportType = null;
			
		}else if($scope.moduleid == "as"){
			document.getElementById("loader").style.display = "block";
			
			$http.get("http://117.222.38.169:9090/arms/rest/EntryUpdateRest/armsUpdatedStatus",{params:{date:selectedDateForOther}}).then(function(response){
				
				$scope.armsObj = response.data[0].armsObj;
				$scope.ammunitionObj = response.data[1].ammunitionObj;
				$scope.gasAmmunitionObj = response.data[2].gasAmmunitionObj;
			
				document.getElementById("loader").style.display = "none";
			}, function error(response) {
				document.getElementById("loader").style.display = "none";
		    })
			
			
			 $scope.reportType = null;
		}
	};
	
	$scope.unitNames="";
	$scope.setUnitName = function(){		
		if($scope.unitName== null || $scope.unitName == undefined ||  $scope.unitName ==""){
			$scope.unitNames = "";
		}else{
			$scope.unitNames = $scope.unitName;
		}				
	}
	
	$scope.unitNameFunds="";
	$scope.setUnitNameFund = function(){		
		if($scope.unitNameFund== null || $scope.unitNameFund == undefined ||  $scope.unitNameFund ==""){
			$scope.unitNameFunds = "";
		}else{
			$scope.unitNameFunds = $scope.unitNameFund;
		}				
	}
	
	$scope.unitNameBanks="";
	$scope.setUnitNameBank = function(){		
		if($scope.unitNameBank== null || $scope.unitNameBank == undefined ||  $scope.unitNameBank ==""){
			$scope.unitNameBanks = "";
		}else{
			$scope.unitNameBanks = $scope.unitNameBank;
		}				
	}
	
	$scope.unitNameLoans="";
	$scope.setUnitNameLoan = function(){		
		if($scope.unitNameLoan== null || $scope.unitNameLoan == undefined ||  $scope.unitNameLoan ==""){
			$scope.unitNameLoans = "";
		}else{
			$scope.unitNameLoans = $scope.unitNameLoan;
		}				
	}
	
	$scope.unitNameSchemes="";
	$scope.setUnitNameScheme = function(){		
		if($scope.unitNameScheme== null || $scope.unitNameScheme == undefined ||  $scope.unitNameScheme ==""){
			$scope.unitNameSchemes = "";
		}else{
			$scope.unitNameSchemes = $scope.unitNameScheme;
		}				
	}
	
	$scope.unitNameArmss="";
	$scope.setUnitNameArms = function(){		
		if($scope.unitNameArms== null || $scope.unitNameArms == undefined ||  $scope.unitNameArms ==""){
			$scope.unitNameArmss = "";
		}else{
			$scope.unitNameArmss = $scope.unitNameArms;
		}				
	}
	
	$scope.unitNameAmmunitions="";
	$scope.setUnitNameAmmunition = function(){		
		if($scope.unitNameAmmunition== null || $scope.unitNameAmmunition == undefined ||  $scope.unitNameAmmunition ==""){
			$scope.unitNameAmmunitions = "";
		}else{
			$scope.unitNameAmmunitions = $scope.unitNameAmmunition;
		}				
	}
	
	$scope.unitNameGass="";
	$scope.setUnitNameGas = function(){		
		if($scope.unitNameGas== null || $scope.unitNameGas == undefined ||  $scope.unitNameGas ==""){
			$scope.unitNameGass = "";
		}else{
			$scope.unitNameGass = $scope.unitNameGas;
		}				
	}

	$scope.printDiv=function(Id) {
	   
	                var dvExcelData = document.getElementById('dvExcelData'+Id);

	                var newWin = window.open('', 'Print-Window');

	                newWin.document.open();

	                newWin.document.write('<html><head><link rel="stylesheet" 	href="assets/vendor/bootstrap/css/bootstrap.min.css"><link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet"><link rel="stylesheet" href="assets/libs/css/style.css">'
	                	                		                	
	                		+'<link rel="stylesheet"'
	                			+'href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">'
	                		+'<link rel="stylesheet"'
	                			+'href="assets/vendor/charts/chartist-bundle/chartist.css">'
	                		+'<link rel="stylesheet"'
	                			+'href="assets/vendor/charts/morris-bundle/morris.css">'
	                		+'<link rel="stylesheet"'
	                		+	'href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">'
	                		+'<link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">'
	                		+'<link rel="stylesheet"'
	                			+'href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css"></head><body onload="window.print()">' + dvExcelData.innerHTML + '</body></html>');

	                newWin.document.close();

	                setTimeout(function () { newWin.close(); }, 10);

	            };


	
	
	
	
	$scope.onload();	
	
	$("#btnExport1").click(function (e) {
	    $(this).attr({
	        'download': "disciplinaryUpdate.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData1').html())
	    });
	});
	$("#btnExport2").click(function (e) {
	    $(this).attr({
	        'download': "welfareUpdateFund.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData2').html())
	    });
	});
	$("#btnExport3").click(function (e) {
	    $(this).attr({
	        'download': "welfareUpdateBank.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData3').html())
	    });
	});
	$("#btnExport4").click(function (e) {
	    $(this).attr({
	        'download': "welfareUpdateLoan.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData4').html())
	    });
	});
	$("#btnExport5").click(function (e) {
	    $(this).attr({
	        'download': "welfareUpdateScheme.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData5').html())
	    });
	});
	$("#btnExport6").click(function (e) {
	    $(this).attr({
	        'download': "ArmsArmoryStatus.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData6').html())
	    });
	});
	$("#btnExport7").click(function (e) {
	    $(this).attr({
	        'download': "AmmunitionArmoryStatus.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData7').html())
	    });
	});
	$("#btnExport8").click(function (e) {
	    $(this).attr({
	        'download': "GasAmmunitionStatus.xls",
	        'href': 'data:application/csv;charset=utf-8,' + encodeURIComponent($('#dvExcelData8').html())
	    });
	});
	
});



myApp.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9.]/g, '');

                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});


myApp.directive('textaccept', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                var transformedInput = text.replace(/[^A-Za-z ]/g, '');

                if (transformedInput !== text) {
                    ngModelCtrl.$setViewValue(transformedInput);
                    ngModelCtrl.$render();
                }
                return transformedInput;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

myApp.directive('capitalize', function() {
    return {
      require: 'ngModel',
      link: function(scope, element, attrs, modelCtrl) {
        var capitalize = function(inputValue) {
          if (inputValue == undefined) inputValue = '';
          var capitalized = inputValue.toUpperCase();
          if (capitalized !== inputValue) {
            // see where the cursor is before the update so that we can set it back
            var selection = element[0].selectionStart;
            modelCtrl.$setViewValue(capitalized);
            modelCtrl.$render();
            // set back the cursor after rendering
            element[0].selectionStart = selection;
            element[0].selectionEnd = selection;
          }
          return capitalized;
        }
        modelCtrl.$parsers.push(capitalize);
        capitalize(scope[attrs.ngModel]); // capitalize initial value
      }
    };
  });
