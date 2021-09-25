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

  
<div class="login-form rbox rboxResp">
          
		    <form action="\SSS\updatePassword" method="post">
	            <div  class="form-group"  >	
	            	<input type="text" class="form-control inputBoxHeight" id = "OTP" name="enteredOtp" placeholder="OTP"  autocomplete="off" required>
	            </div>	      
		        <div class="form-group">
		            <button type="submit"  class="btn btn-primary btn-block sendOtp">Change Password</button>
		        </div>
        </form>
     

</div>
</div>
</body>
</html>