
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
<div>
  
<div class="login-form" style=" border: 1px solid #d2cccc; width: 21%; padding: 15px;margin: auto;  margin-top: 9%;">
    
      <form action="\SSS\sendOtpChangePass" method="post" >
       <div class="form-group ">
	      
	       <div   class="form-group" style="text-align: center;">	
	            	<h3 style="color: #428bca;">Change Password </h3>
	            </div>	
	       		<div   class="form-group">	
	            	<input class="form-control" type="text"   id="sevarthNum" name="sevarthNum" placeholder="User Id" autocomplete="off" required>
	            </div>
	             <div class="form-group">
		            <input type="password" class="form-control" name="oldpassword"  id="oldpassword" placeholder="System generated password" required="required" >    <!-- ng-model="password" -->            
		        </div>
		         <div class="form-group">
		            <input type="password" class="form-control" name="newpassword"  id="newpassword" placeholder="New Password" required="required" >    <!-- ng-model="password" -->            
		        </div>
	           
		        
		         <div class="form-group">
            <button type="submit"  class="btn btn-primary btn-block">Send OTP</button>
        </div>
		   <div class="form-group" style="text-align:center">
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