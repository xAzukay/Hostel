<%-- 
    Document   : index
    Created on : Nov 16, 2015, 9:09:09 AM
    Author     : shukor.saharuni
--%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="hostelapp" %>
<%@ taglib prefix="group" uri="/WEB-INF/tlds/group.tld"%>
<hostelapp:master>
  <jsp:attribute name="header">
    <!-- Page specific JS / CSS goes here -->
  </jsp:attribute>
  <jsp:attribute name="content">
    <h1>Hello World</h1>
    <form action="">
            Select User: <group:role /><br></br>
            <input type=submit value="Show selected user"/>
        </form>
        <form action="">
            Select User: <group:gender /><br></br>
            <input type=submit value="Show selected user"/>
        </form>
  </jsp:attribute>
</hostelapp:master>
