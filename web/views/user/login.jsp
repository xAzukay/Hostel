<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Creative - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/animate.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/creative.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/custom.css" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>

<body id="page-top">

<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
          
        <form method="POST" action="${pageContext.request.contextPath}/Dashboard" role="login">
          <!--<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />-->
          <h1 align="center">e-UTMSRC</h1>
          <!--Error Message-->
            <c:if test="${not empty errMessage}">                
                <div class="alert alert-danger">
                    ${errMessage}
                </div>
            </c:if> 
          <input type="text" name="username" placeholder="Username" required class="form-control input-lg" value="" required="required" />
          <input type="hidden" name="loginPage" value="login">
          <input type="password" name="password" placeholder="Password" class="form-control input-lg" id="password" required="required" />
          
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Log in</button>
          
          <input type="hidden" name="loginPage" value="login">
        </form>
        
        
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
</div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/asset/login/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/asset/js/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/asset/js/jquery.fittext.js"></script>
    <script src="${pageContext.request.contextPath}/asset/js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/asset/js/creative.js"></script>
    <script src="${pageContext.request.contextPath}/asset/js/custom.js"></script>
    
    
</body>

</html>