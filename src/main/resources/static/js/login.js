
var xhttp = new XMLHttpRequest();
function loadUserData(){
 
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 || this.status === 200) {

            var userDetail = JSON.parse(xhttp.responseText);
           
            
            for(var i = 0; i < userDetail.length ; i++){
            	
            //document.getElementById("username").innerHTML +='<option value="'+userDetail[i].sevarth_no+'">'+userDetail[i].sevarth_no+'</option>' 
            document.getElementById("usersname").innerHTML += '<option value="'+userDetail[i]+'">'
            }
            
        }
    };
    xhttp.open("GET", "UsersRest/getusers", false);
    xhttp.send();
   
//    document.getElementById("sp").checked = true;
//    if(document.getElementById("reqidTwo").innerHTML =="Incorrect Username or Paasword"){
//    	 document.getElementById("nosp").checked = true;
//    }else{
//    	
//    	 document.getElementById("sp").checked = true;
//    }
//    displayRadioValue();
}




//loadUserData();
//function displayRadioValue() { 
//	document.getElementById("belowSp").style.display = "none";
//	document.getElementById("aboveSp").style.display = "none";
//  
//	if(document.getElementById("sp").checked === true){
//		document.getElementById("aboveSp").style.display = "block";
////		document.getElementById("loginOne").style.display = "none";	
////		document.getElementById("loginTwo").style.display = "block";
//	}else{
//		document.getElementById("belowSp").style.display = "block";
////		document.getElementById("loginOne").style.display = "block";
////		document.getElementById("loginTwo").style.display = "none";
//	}
//} 

var mobileNumber = "";
var flagEnter = 0;
function getMobileNum(){
	var username = "";
	var password = "";
	//if(document.getElementById("sp").checked === true){
		
		username = document.getElementById("username").value;  	
		password = document.getElementById("pwd").value; 
		
	//}
//	if(document.getElementById("nosp").checked === true){
//		document.getElementById("belowSp").style.display = "block";
//		username = document.getElementById("sevarthid").value;  	
//		password = document.getElementById("password").value; 
//	}
	
	xhttp.onreadystatechange = function () {
		flagEnter = 1;
		
        if ( this.status === 200){

            var mobileNum = JSON.parse(xhttp.responseText);                   
            mobileNumber = JSON.stringify(mobileNum);     
           
            var lastNum = mobileNumber.substr(6, 4);
            var lastDigit = "xxxxxx" + lastNum;
        	document.getElementById("mobNo").value = lastDigit;    
        	username = null;
        	password = null;
        	document.getElementById("reqParam").innerHTML= "";
        }
        if(this.status === 500){
        	flagEnter = 0;
        	document.getElementById("reqParam").innerHTML= "Invalid Username or Password";  
        	document.getElementById("reqParam").style.display = "block";
        	document.getElementById("mobNo").value="";
        }
    };
    xhttp.open("GET", "UsersRest/getMobileNum?sevarth_no="+username+"&pass="+password+"", false);
    xhttp.send();	
}



window.addEventListener("keyup", function(event) {
	if(flagEnter == 0){
  if (event.keyCode === 13) {
   event.preventDefault();
   getMobileNum();
  }
	}
});

function login(){	
	 var otp = document.getElementById("OTP").value;
	 if(otp ==="" || otp=== undefined || otp === null){
		 alert("please Enter OTP");
	 }else{
	xhttp.onreadystatechange = function () {
        if (this.readyState === 4 || this.status === 200) {

              
        }else{
       
        	document.getElementById("reqid").style.display = "block";
        	
        }
    };
    xhttp.open("GET", "UsersRest/loginPage?mobileNum="+mobileNumber+"&otp="+otp+"", false);
    xhttp.send();
	 }
}



