<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
<link rel="stylesheet" href="assets/libs/css/style.css">
<link rel="stylesheet"
	href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
<link rel="stylesheet"
	href="assets/vendor/charts/chartist-bundle/chartist.css">
<link rel="stylesheet"
	href="assets/vendor/charts/morris-bundle/morris.css">
<link rel="stylesheet"
	href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
<link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
<link rel="stylesheet"
	href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
<link rel="stylesheet" href="assets/libs/css/dashboardres.css">

<script src="js/angular.min.js" ></script>
<script src="js/uiRouter.min.js" ></script>
<script src="js/angucomplete-alt.min.js" ></script>
<script src="js/onePage.js"></script>	
	
<title></title>

</head>

<body ng-app="myApp">

	<!-- ============================================================== -->
	<!-- main wrapper -->
	<!-- ============================================================== -->
	<div class="dashboard-main-wrapper">
		<!-- ============================================================== -->
		<!-- navbar -->
		<!-- ============================================================== -->
		<div class="dashboard-header">
		
		
			<nav class="navbar navbar-expand-lg bg-white fixed-top">
			<img style="width: 55px; 
    margin-left: 32%;" class="dlogo" src="assets/images/mahapolices.png" />
				<a class="navbar-brand dheadsize" > STRATEGY  SUPPORT  SYSTEM</a>
				<img style="width: 71px;" class="dlogo" src="assets/images/wireless.jpeg" />
				<button class="navbar-toggler dlogo" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse " id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto navbar-right-top">
						
						<li class="nav-item dropdown nav-user"  style="padding-right: 18px; padding-left: 11px;margin:auto;">
						<h6 id="usernamee" style="color: #797575;"></h6>
							</li>
							<li class="nav-item dropdown nav-user"  style="padding-right: 18px; padding-left: 11px;margin:auto;">
						<h6 id="firstName" style="color: #797575;"></h6>
							</li>
							<li class="nav-item dropdown nav-user"  style="padding-right: 18px; padding-left: 11px;margin:auto;">
						<h6 id="unitname" style="color: #797575;"></h6>
							</li>
											
						
						<li class="nav-item dropdown nav-user" style="margin:auto;">
							
								
								 <form action="\SSS\logout" id="logoutForm" method="post">
								 <button  style="font-size: 13px;"
									class="dropdown-item" ><i
									class="fas fa-power-off mr-2"></i>Logout</button></form>
									
							</li>
					</ul>
				</div>
			</nav>
		</div>
		<!-- ============================================================== -->
		<!-- end navbar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- left sidebar -->
		<!-- ============================================================== -->
		<div class="nav-left-sidebar sidebar-dark">
			<div class="menu-list">
				<nav class="navbar navbar-expand-lg navbar-light">
					<a class="d-xl-none d-lg-none" href="#">Dashboard</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNav" aria-controls="navbarNav"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav flex-column">
							<li style="color:white" class="nav-divider">Menu</li>
							<li  ui-sref="moduleView()" id="moduleView" class="nav-item"><a class="nav-link" ><i
									class="fas fa-fw fa-home"></i>Home</a>
								<!-- <div id="submenu-5" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/general-table.html">General Tables</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/data-tables.html">Data Tables</a></li>
									</ul>
								</div> -->
								</li>
							
							<li ui-sref="moduleManage()" id="moduleManage" class="nav-item"><a class="nav-link" >								 
								<i	class="fa fa-fw fa-chart-pie"></i>Module management</a></li>
								
								<li class="nav-item "  id="userManage"><a class="nav-link "
								data-toggle="collapse" aria-expanded="false"
								data-target="#submenu-1" aria-controls="submenu-1"><i
									class="fa fa-fw fa-user-circle"></i>User Management <span
									class="badge badge-success">6</span></a>
								<div id="submenu-1" class="collapse submenu" style="">
									<ul class="nav flex-column">
										
										<li ui-sref="userCreation()" class="nav-item"><a class="nav-link" style="font-size: 12px;"
											>User Creation</a></li>
										<li ui-sref="userUpdation()" class="nav-item"><a class="nav-link" style="font-size: 12px;"
											>User Updation</a></li>
										 <li ui-sref="userCountReport()" id="userCountReport" class="nav-item"><a class="nav-link" style="font-size: 12px;"
											>User Count Report</a></li> 
									     <li ui-sref="moduleAssignedReport()"  id="moduleAssignedReport" class="nav-item"><a class="nav-link" style="font-size: 12px;"
											>Assigned modules Report</a></li> 		
									    <!-- <li class="nav-item"><a class="nav-link"
											>User List</a></li> -->
										<!-- <li class="nav-item">
                                            <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1-1" aria-controls="submenu-1-1">Infulencer</a>
                                            <div id="submenu-1-1" class="collapse submenu" style="">
                                                <ul class="nav flex-column">
                                                    <li class="nav-item">
                                                        <a class="nav-link" href="dashboard-influencer.html">Influencer</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" href="influencer-finder.html">Influencer Finder</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" href="influencer-profile.html">Influencer Profile</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li> -->
									</ul>
								</div></li>
							<li  ui-sref="modulePermission()" id="modulePerm"  class="nav-item"><a class="nav-link" >
								<i class="fab fa-fw fa-wpforms"></i>Module Permission</a>
								<!-- <div id="submenu-3" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-c3.html">C3 Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-chartist.html">Chartist Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-charts.html">Chart</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-morris.html">Morris</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-sparkline.html">Sparkline</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-gauge.html">Guage</a></li>
									</ul>
								</div> -->
								</li>
								 <li  ui-sref="modulePermissionBulk()" id="modulePermBulk"  class="nav-item"><a class="nav-link" >
								<i class="fab fa-fw fa-wpforms"></i>Module Permission Bulk</a>
								<!-- <div id="submenu-3" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-c3.html">C3 Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-chartist.html">Chartist Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-charts.html">Chart</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-morris.html">Morris</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-sparkline.html">Sparkline</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-gauge.html">Guage</a></li>
									</ul>
								</div> -->
								</li> 
								
								 <li  ui-sref="unitManagement()" id="unitManagement"  class="nav-item"><a class="nav-link" >
								<i class="fab fa fa-building"></i>Unit Management</a>
								<!-- <div id="submenu-3" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-c3.html">C3 Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-chartist.html">Chartist Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-charts.html">Chart</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-morris.html">Morris</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-sparkline.html">Sparkline</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-gauge.html">Guage</a></li>
									</ul>
								</div> -->
								</li> 
								 <li  ui-sref="loginHistory()" id="loginHistory"  class="nav-item"><a class="nav-link" >
								<i class="fab fa fa-history"></i>User's login history</a>
								<!-- <div id="submenu-3" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-c3.html">C3 Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-chartist.html">Chartist Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-charts.html">Chart</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-morris.html">Morris</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-sparkline.html">Sparkline</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-gauge.html">Guage</a></li>
									</ul>
								</div> -->
								</li> 
								 <li  ui-sref="entryUpdateReport()" id="entryUpdateReport"  class="nav-item"><a class="nav-link" >
								<i class="fab fa-fw fa-wpforms"></i>Entry Update Report</a>
								<!-- <div id="submenu-3" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-c3.html">C3 Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-chartist.html">Chartist Charts</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-charts.html">Chart</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-morris.html">Morris</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-sparkline.html">Sparkline</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/chart-gauge.html">Guage</a></li>
									</ul>
								</div> -->
								</li> 
								
								
								
								 <li  id="log_out"  class="nav-item">
								<form action="\SSS\logout" id="logoutForm" method="post" class="nav-link">
								 <button class="dlogout"
									  ><i
									class="fas fa-power-off mr-2"></i>Logout</button></form>
								</li>
							<!-- <li ui-sref="moduleEntry()" id="moduleEntry" class="nav-item "><a class="nav-link" >
							<i class="fas fa-fw fa-table"></i>Module Entry</a>
								<div id="submenu-4" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/form-elements.html">Form Elements</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/form-validation.html">Parsely Validations</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/multiselect.html">Multiselect</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/datepicker.html">Date Picker</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/bootstrap-select.html">Bootstrap Select</a></li>
									</ul>
								</div>
								</li> -->
							
								<!-- <li ui-sref="moduleValidation()" id="moduleValidation" class="nav-item"><a class="nav-link" ><i
									class="fas fa-fw fa-inbox"></i>Module Validation</a>
								<div id="submenu-5" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link"
											href="pages/general-table.html">General Tables</a></li>
										<li class="nav-item"><a class="nav-link"
											href="pages/data-tables.html">Data Tables</a></li>
									</ul>
								</div>
								</li> -->
							
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- end left sidebar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- wrapper  -->
		<!-- ============================================================== -->
		<div class="dashboard-wrapper" style="background:#3333ff">
			<div class="dashboard-ecommerce">
				<ui-view></ui-view>
			</div>
			
		</div>
		
	</div>
	
	
	<!-- jquery 3.3.1 -->
	<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
	<!-- bootstap bundle js -->
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
	<!-- slimscroll js -->
	<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
	<!-- main js -->
	<script src="assets/libs/js/main-js.js"></script>
	<!-- chart chartist js -->
	<script src="assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
	<!-- sparkline js -->
	<script src="assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
	<!-- morris js -->
	<script src="assets/vendor/charts/morris-bundle/raphael.min.js"></script>
	<script src="assets/vendor/charts/morris-bundle/morris.js"></script>
	<!-- chart c3 js -->
	<script src="assets/vendor/charts/c3charts/c3.min.js"></script>
	<script src="assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
	<script src="assets/vendor/charts/c3charts/C3chartjs.js"></script>
	<script src="assets/libs/js/dashboard-ecommerce.js"></script>
	<script>

	
	</script>
</body>

</html>