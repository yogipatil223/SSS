
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
    
      <form action="\SSS\setProfileCode" method="post" >
       <div class="form-group ">
	      
	       <div   class="form-group" style="text-align: center;">	
	            	<h3 style="color: #428bca;" class="regLabel">Registration</h3>
	            </div>	
	       		
	            <div class="form-group">
	            <label  class="col-form-label required radioLabel" style="color:grey">Change Your Login Password  :</label>
		            <input type="password" class="form-control inputBoxHeight" name="password"  id="pwd" placeholder="New Password" required="required" >    <!-- ng-model="password" -->            
		        </div>
		        <div   class="form-group">	
	       			<label  class="col-form-label required radioLabel" style="color:grey">Set Profile Password (Required in case of "Forgot Password") :</label>
	            	<input class="form-control inputBoxHeight " type="text"   id="profileCode" placeholder="Set Profile Password" name="profileCode"  autocomplete="off" required>
	            </div>
		         <div class="form-group">
            <button type="submit"  class="btn btn-primary btn-block sendOtp">Submit</button>
        </div>
		   
		   </div> 
		   </form>
		
	 
</div>
</div>
<script>

</script>
</body>
</html>