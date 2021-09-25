<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>


<script src="js/login.js"></script>
</head>
<link rel="stylesheet" href="assets/libs/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/libs/css/loginone.css">
<link rel="stylesheet" href="assets/libs/css/loginres.css">

<body onload="loadUserData()">
<div class="container-fluid" >
	<div class="row lsshead sshead"
		style="">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<label>Strategy Support System</label>
		</div>
	</div>

<div class="row">
	<div class="col-md-4  col-lg-4  col-md-offset-4 col-lg-offset-4" >
	<div class="row">
	<div class="col-md-10  col-lg-10 col-md-offset-1  col-lg-offset-1">
<div id="loginDisp" style="border: 3px solid #5a7fc9;  padding: 15px; margin: auto; margin-top: 10%; border-radius: 11px;">

		<div class="login-form">
			<!--   <form class="ng-pristine ng-valid"> -->
			<!-- <h2 class="text-center" style="color:#428bca">Log in</h2> -->
			<!--  <div  class=" row" style="text-align: center;">
        <div class="col-sm-12 col-md-12 col-lg-12">
        <label style="font-size:24px;"> Strategy Support System</label>        
        </div>
        </div> -->

			<div class=" row"
				style="text-align: center;  padding: 16px">
				<img src="assets/images/Maharashtra-police-logo.png"
					 alt="Maharashtra Police Logo"
					class="avatar mhpolicelogo lmhpolicelogo">
			</div>


			<!-- <div class="form-group col-sm-12" style="font-weight: 600;">
				<div class=" col-sm-6	radioLabel lradioLabel" id="ranks" style="">
					<button type="button" class="btn btn-primary btn-block" onclick="getOtp()">Get Otp</button>
					location.href='getOtp'
					<input type="radio" name="rank" id="sp" value="sp"
						onClick="displayRadioValue()" style="color: #428bca;" class="radiosize">SP &
					Above User<br>

				</div>
				<div class=" col-sm-6	radioLabel lradioLabel" style="">
					<button type="button" class="btn btn-primary btn-block" onclick="getOtp()">Get Otp</button>
					location.href='getOtp'
					<input type="radio" name="rank" id="nosp" value="nosp"
						onClick="displayRadioValue()" style="color: #428bca;" class="radiosize">Other
					User<br>

				</div>

			</div> -->
			<div id="aboveSp">
				<form class="ng-pristine ng-valid">
					<!--  <div id="loginOne" class="row">
		        <div class="form-group col-sm-6">
		             <input type="text" class="form-control" id="sevarthid" name="sevarthid"  placeholder="Sevarth Id" required="required" autocomplete="off" > 
		             <input type="text" class="form-control" id="username" name="username"  placeholder="Username" required="required" autocomplete="off" >  
		        </div>
		        <div class="form-group col-sm-6" >
		            <input type="password" class="form-control" name="password" id="password"  placeholder="Password" required="required" >    ng-model="password"            
		        </div>
		</div> -->
					<div id="loginTwo" class="row">
						<div class="form-group col-sm-6">
							<!-- <select class="form-control inputBoxHeight" id="username" class="userData" name="username">								
								<option value="">- - User Id - -</option>
							</select> -->
							
							 <input list="usersname" class="form-control inputBoxHeight lborder"  placeholder="User Id" name="username" id="username">
							  <datalist id="usersname">
							  </datalist>

						</div>
						<div class="form-group col-sm-6">
							<input type="password" class="form-control inputBoxHeight lborder" name="password"
								id="pwd" placeholder="Password" required="required">
							<!-- ng-model="password" -->
						</div>
					</div>
					<div style="text-align: center">
						<label style="color:  red" id="reqParam" class="reqParam"></label>
					</div>

					<div class="form-group col-sm-12">
					<div class="row">
						<div class=" col-sm-offset-2 col-sm-8"
							style="text-align: center; margin-bottom: 3px;">
							<!-- <button type="button" class="btn btn-primary btn-block" onclick="getOtp()">Get Otp</button> -->
							<!-- location.href='getOtp' -->
							<input class="btn lsendOtp sendOtp " 
								style=""
								onClick="getMobileNum()" type="button" value="Send OTP">
							<!-- location.href='/login' -->
						</div>
						</div>
					</div>

				</form>
				<form action="\SSS\loginPage" method="post">
					<div class="form-group ">
						<div class="row" style="margin-bottom: 16px;">
							<div class=" col-sm-6" style="float: left;">
								<input class="form-control inputBoxHeight lborder" type="text" readonly="readonly"
									id="mobNo" name="mobNo" placeholder="Mobile Number"
									autocomplete="off" required>
							</div>
							<div class=" col-sm-6" style="float: left;">
								<input type="text" class="form-control inputBoxHeight lborder" id="OTP"
									name="enteredOtp" placeholder="OTP" autocomplete="off" required>
							</div>
						</div>
					</div>


					<div class="form-group">
						<label class=" text-center reqParam" id="reqid"
							style="color: red; width: 100%"> <%= request.getAttribute("otpStatus") %></label>
					</div>
					<div class="form-group llogbtmMargin logbtmMargin " >
						<button type="submit"
							style=""
							class="btn btn-primary btn-block sendOtp loginBtn">Log in</button>
					</div>
				</form>
			</div>

			<%-- <div id="belowSp">

				<form action="\SSS\loginPageBelowSp" method="post">
					<div id="loginOne" class="row">
						<div class="form-group col-sm-6">
							<input type="text" class="form-control inputBoxHeight" id="sevarthid"
								name="sevarthid" placeholder="User Id" required="required"
								autocomplete="off">
							<!-- <input type="text" class="form-control" id="username" name="username"  placeholder="Username" required="required" autocomplete="off" > -->
						</div>
						<div class="form-group col-sm-6">
							<input type="password" class="form-control inputBoxHeight" name="password"
								id="password" placeholder="Password" required="required">
							<!-- ng-model="password" -->
						</div>
					</div>


					<div class="form-group">
						<label class=" text-center reqParam" id="reqidTwo"
							style="color: red; width: 100%"><%=request.getAttribute("validUser") %></label>
					</div>
					<div class="form-group llogbtmMargin logbtmMargin" >
						<button type="submit"
							style=""
							class="btn btn-primary btn-block sendOtp loginBtn">Log in</button>
					</div>
				</form>
			</div> --%>

			
			<div class="row">
			<div class="col-sm-offset-2 col-sm-8">
			<div class="clearfix">
				<form action="\SSS\forgotPage" method="post"
					style="text-align: center;">
					<!--  <a href="" class="pull-right">Forgot Password?</a> -->
					<input class="btn lforgetBtn sendOtp logbtmMargin "
						style=""
						type="submit" value="Forgot Password?">
				</form>
			</div>
			</div>
			
			</div>


		</div>
	</div></div></div></div>
	</div>
	</div>
	<script>
document.getElementById("reqParam").style.display = "none";
console.log(document.getElementById("reqid").innerHTML);
if(document.getElementById("reqid").innerHTML === " null"){
	document.getElementById("reqid").style.display = "none";
	document.getElementById("reqid").innerHTML ="";
}

/* console.log(document.getElementById("reqidTwo").innerHTML);
if(document.getElementById("reqidTwo").innerHTML === "null"){
	document.getElementById("reqidTwo").innerHTML ="";
} */
var validd = "<%= request.getAttribute("validUser") %>";
if(validd==="Incorrect Username or Paasword"){
	console.log("hello 222333");
	//document.getElementById("nosp").checked = true;
	//document.getElementById("aboveSp").style.display = "none";
	//document.getElementById("belowSp").style.display = "block";

}



</script>

</body>
</html>