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
<body >
<div  style=" border: 1px solid #d2cccc; width: 21%; padding: 15px;margin: auto;  margin-top: 9%;" >
  
<div class="login-form">          
		    <form action="\SSS\sendOtpForgotPass" method="post">
	            <div  class="form-group"  >	
	               <label  class="col-form-label required">Enter Profile Code :</label>
	            	<input type="text" class="form-control" id = "profileCode" name="profileCode"   autocomplete="off" required>
	            </div>	      
		        <div class="form-group">
		            <button type="submit"  class="btn btn-primary btn-block">Send OTP</button>
		        </div>
        </form>
     
</div>
</div>
</body>
</html>