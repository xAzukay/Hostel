<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
		<!-- BASICS -->
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>UTM Space Residential College</title>
        <meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asset/utm/css/isotope.css" media="screen" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/css/bootstrap.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/css/bootstrap-theme.css">
		<link href="${pageContext.request.contextPath}/asset/utm/css/responsive-slider.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/css/animate.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/css/style.css">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/css/font-awesome.min.css">
		<!-- skin -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/utm/skin/default.css">
    </head>

    <body>


	<div class="header">
	<section id="header" class="appear">

		<div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="fa fa-bars color-white"></span>
					</button>
					<h1><a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp" data-0="line-height:90px;" data-300="line-height:50px;">e-UTMSRC
					</a></h1>
				</div>
			</div>


	</section>
	</div>

		
			<div class="container">

				<div class="row mar-bot40">
					<div class="col-md-offset-3 col-md-6">
						<div class="section-header">
							<h2 class="section-heading animated" data-animation="bounceInUp">APPLICATION FORM</h2>
						</div>
					</div>
				</div>
<form role="form" name="frmID" method="POST" action="${pageContext.request.contextPath}/Application-Form">
				<div class="col-md-20">
                                    <c:if test="${not empty message}">                
                <div class="alert ${alert} alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div>
                </c:if>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i> PERSONAL DETAILS</h4>
                    </div>
                <div class="panel-body">
						
					<div class="form-group">
						  <label for="name" class="col-md-2">
							Name:
						  </label>
						<div class="input-group col-md-10">
							<input type="text" class="form-control" id="firstname" name="fullname" placeholder="Enter Your Name" required>
						</div>
                                        </div>

						<div class="form-group">
							<label for="ic" class="col-md-2">
								IC Number:
							</label>
							<div class="input-group col-md-10">
								<input type="text" class="form-control" id="icpassport" name="icno" placeholder="Enter Your IC Number" style="width:300px" required>
							</div>
						</div>

						<div class="form-group">
					  <label for="matricnumber" class="col-md-2">
						Matric Number:
					  </label>
					  <div class="input-group col-md-10">
						<input type="text" class="form-control" id="matricnumber" name="matricno" placeholder="Enter Your Matric Number" style="width:300px" required>
					  </div>
					</div>

					<div class="form-group">
					  <label for="address" class="col-md-2">
						Address:
					  </label>
					  <div class="input-group col-md-10">
						<input type="text" class="form-control" id="address" name="address" placeholder="Enter Your Permenant Address" required>
					  </div>
					</div>

					<div class="form-group">
					  <label for="emailaddress" class="col-md-2">
						Email address:
					  </label>
					  <div class="input-group col-md-10">
						<input type="email" class="form-control" id="emailaddress" name="email" placeholder="Enter email address" style="width:400px">
						<!--<p class="help-block">
						   Example: yourname@domain.com
						</p>-->
					  </div>
						</div>

						<div class="form-group">
						  <label for="contact" class="col-md-2">
							Contact Number:
						  </label>
						  <div class="input-group col-md-10">
							<input type="contact" class="form-control" id="contact" name="mobileno" placeholder="Enter Your Contact Number" style="width:300px">
							<!--<p class="help-block">
							  (10 digit number)
							</p>-->
						  </div>
						</div>

						<div class="form-group">
                                                    <label for="gender" class="col-md-2">
							Gender:
						  </label>
                                                    <div class="input-group col-md-10">
                                                    <select name='gender' id="data_gender" class="form-control" required style="width:200px">
                                                      <option value=''>-- Please Select --</option>
                                                      <c:forEach items="${listGender}" var="gender">
                                                          <option value="${gender.genderID}">${gender.description}</option>
                                                      </c:forEach>
                                                    </select>
                                                  </div>
                                                </div>

						<div class="form-group">
						  <label for="session" class="col-md-2">
							Session:
						  </label>
						  <div class="input-group col-md-10">
							<input type="text" class="form-control" id="session" name="sessionyear" placeholder="Enter Your Session / Semester Admission" style="width:300px" required>
						  </div>
						</div>
                    
                                            <div class="form-group">
                                              <label for="faculty" class="col-md-2">
							Faculty:
						  </label>
                                                    <div class="input-group col-md-10">
                                              <select name='faculty' id="data_faculty" class="form-control" required style="width:500px">
                                                <option value=''>-- Please Select --</option>
                                                <c:forEach items="${listFaculty}" var="faculty">
                                                    <option value="${faculty.facultyID}">${faculty.facultyName}</option>
                                                </c:forEach>
                                              </select>
                                            </div>
                                                </div>
                    
                                                <div class="form-group">
                                              <label for="courses" class="col-md-2">
							Course:
						  </label>
                                                    <div class="input-group col-md-10">
                                              <select name='courses' id="data_courses" class="form-control" required style="width:550px">
                                                <!--<option value=''>-- Please Select --</option>
                                                <:forEach items="{listCourses}" var="courses">
                                                    <option value="{courses.coursesID}">{courses.coursesName}</option>
                                                </:forEach>-->
                                              </select>
                                            </div>
                                                </div>

						<div class="form-group">
                                              <label for="college" class="col-md-2">
							College:
						  </label>
                                                    <div class="input-group col-md-10">
                                              <select name='college' id="data_college" class="form-control" required style="width:250px">
                                                <!--<option value=''>-- Please Select --</option>
                                                <:forEach items="{listCollege}" var="college">
                                                    <option value="{college.collegeID}">{college.collegeName}</option>
                                                </:forEach>-->
                                              </select>
                                            </div>
                                                </div>

						<!--<div class="form-group">
						  <label for="roomtype" class="col-md-2">
							Room Type:
						  </label>
						  <div class="input-group col-md-10">
							<select name="roomtype" id="roomtype" class="form-control">
							  <option>--Please Select--</option>
							  <option>Single</option>
							  <option>Double</option>
							</select>
						  </div>
						</div>

						<div class="form-group">
							<label for="uploadimage" class="col-md-2">
								Upload Image:
							</label>
							<div class="col-md-10">
								<input type="file" name="uploadimage" id="uploadimage">
								<p class="help-block">
								  Allowed formats: jpeg, jpg, gif, png
								</p>
							</div>
						</div>-->

					</div>
                </div>
            </div>
				


						<!--<div class="col-md-15">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4><i class="fa fa-fw fa-check"></i> EMERGENCY CONTACT</h4>
									</div>
									<div class="panel-body">

										<div class="form-group">
											<label for="name" class="col-md-2">
											Name:
											</label>
											<div class="col-md-10">
											<input type="text" class="form-control" id="firstname" placeholder="Name of Contact Person">
											</div>
										</div>

										<div class="form-group">
										  <label for="cpaddress" class="col-md-2">
											Address:
										  </label>
										  <div class="col-md-10">
											<input type="text" class="form-control" id="cpaddress" placeholder="Enter Permenant Address">
										  </div>
										</div>

										<div class="form-group">
										  <label for="contact" class="col-md-2">
											Contact Number:
										  </label>
										  <div class="col-md-10">
											<input type="contact" class="form-control" id="contact" placeholder="Enter Contact Number">
											<p class="help-block">
											  (10 digit number)
											</p>
										  </div>
										</div>

										<div class="form-group">
											<label for="relationship" class="col-md-2">
												Relationship:
											</label>
											<div class="col-md-10">
												<input type="text" class="form-control" id="relationship" placeholder="Relationship">
											</div>
										</div>

									</div>
								</div>
						</div>-->

						<div class="col-md-20">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4><i class="fa fa-fw fa-check"></i> DECLARATION</h4>
								</div>

								<div class="list-style">
									<div class="row">
										<div class="company mar-left10">
											<ul>
												<li>I confirm and agree that I have read the Code of Conduct and shall abide with the said Hostel Code of Conduct.
												In the event I fail to follow the code of conduct, I hereby agree that the University can terminate my accommodation contract and request me to vacate the hostel premises immediately.</li>
												<li>I agree that I will not take any action against the University in the event the
												above action is taken against me as a result of default in payment.</li>
											</ul>
										</div>
									</div>
								</div>

								<div class="panel-body">
									<label>
									<input type="checkbox">I fully understand and agree to all the terms and conditions </label>
								</div>
							</div>
						</div>

                                                <center>
							  <div class="col-md-10">
								<button type="submit" class="btn btn-info">Submit</button>
							  </div>
							</center>
						  </form>
						  </div>
                                        <br>
		


	<section id="footer" class="section footer">
		<div class="container">
			<div class="row animated opacity mar-bot0" data-andown="fadeIn" data-animation="animation">
				<div class="col-sm-12 align-center">
                    <ul class="social-network social-circle">
                        <li><a href="http://www4.utmspace.edu.my/" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
                        <li><a href="https://www.facebook.com/univteknologimalaysia" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="https://twitter.com/utm_my" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                    </ul>
				</div>
			</div>

			<div class="row align-center copyright">
					<div class="col-sm-12"><p>Copyright &copy; 2015 e-UTMSRC - by S.A.J</p></div>
			</div>
		</div>

	</section>
	<a href="#header" class="scrollup"><i class="fa fa-chevron-up"></i></a>

	<script src="${pageContext.request.contextPath}/asset/utm/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.easing.1.3.js"></script>
        <script src="${pageContext.request.contextPath}/asset/utm/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.nicescroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/fancybox/jquery.fancybox.pack.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.parallax-1.1.3.js" type="text/javascript" ></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/skrollr.min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.localscroll-1.2.7-min.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/stellar.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/responsive-slider.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/jquery.appear.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/validate.js"></script>
	<script src="${pageContext.request.contextPath}/asset/utm/js/grid.js"></script>
        <script src="${pageContext.request.contextPath}/asset/utm/js/main.js"></script>
        
        <script>
            $('#data_gender').on('change', function (e) {
            var gender = $('#data_gender').val();

            $.getJSON('Application-Form',{ type: gender }, function (data) {
                var col = $('#data_college');
                col.empty();
                $(col).append("<option value='' >" + "-- Please Select --" + "</option>");
                for (var i = 0; i < data.length; i++) {
                    $(col).append(new Option(data[i]._collegeName, data[i]._collegeID));
                }
            });
        });
        
        $('#data_faculty').on('change', function (e) {
            var courses = $('#data_faculty').val();

            $.getJSON('Application-Form',{ kos: courses }, function (data) {
                var col = $('#data_courses');
                col.empty();
                $(col).append("<option value='' >" + "-- Please Select --" + "</option>");
                for (var i = 0; i < data.length; i++) {
                    $(col).append(new Option(data[i].coursesName, data[i].coursesID));
                }
            });
        });
        </script>
	</body>
</html>
