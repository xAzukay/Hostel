<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="content" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<!DOCTYPE html>
 
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="../resources/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
    <jsp:invoke fragment="header"/>
  </head>

  <body>
    <jsp:invoke fragment="content"/>

    <script src="../resources/js/jquery/jquery.min.js"></script>
    <script src="../resources/js/bootstrap/bootstrap.min.js"></script>
    <jsp:invoke fragment="footer"/>
  </body>
</html>