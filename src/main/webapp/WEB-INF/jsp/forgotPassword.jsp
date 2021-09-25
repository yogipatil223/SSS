
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<script src="js/forgotpass.js"></script>
</head>
<link rel="stylesheet"
	href="assets/libs/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/libs/css/loginone.css">
<link rel="stylesheet" href="assets/libs/css/loginres.css">
<body >
<div class="container-fluid" >
	<div class="row lsshead sshead"
		style="">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<label>Strategy Support System</label>
		</div>
	</div>
  
<div class="login-form rbox rboxResp" >
    
      <form action="\SSS\sendOtpForgotPass" method="post" >
       <div class="form-group ">
	      
	       <div   class="form-group" style="text-align: center;">	
	            	<h3 style="color: #428bca; " class="regLabel">Forgot Password ?</h3>
	            </div>	
	       		<div   class="form-group">	
	            	<input class="form-control inputBoxHeight" type="text"   id="sevarth_no" name="sevarth_no" placeholder="User Id" autocomplete="off" required>
	            </div>
	            <div class="form-group">
		            <input type="password" class="form-control inputBoxHeight" name="password"  id="pwd" placeholder="New Password" required="required" >    <!-- ng-model="password" -->            
		        </div>
		         <div class="form-group">
		            <input type="text" class="form-control inputBoxHeight" name="profileCode"  id="profileCode" placeholder="Profile Code" required="required"   autocomplete="off">    <!-- ng-model="password" -->            
		        </div>	
		        
		         <div class="form-group">
            <button type="submit"  class="btn btn-primary btn-block sendOtp">Submit</button>
        </div>
		   <div class="form-group" style="text-align:center" class="reqParam">
           <label style="color:red" id="reqParam" > <%= request.getAttribute("validateMob") %></label>
        </div>
		   </div> 
		   </form>
		
	 
</div>
</div>
<script>
console.log(document.getElementById("reqParam").innerHTML);
if(document.getElementById("reqParam").innerHTML === " null"){
	document.getElementById("reqParam").innerHTML ="";
}
</script>
</body>
</html>