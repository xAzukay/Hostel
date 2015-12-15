<%@ include file="../layouts/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <%@ include file="../layouts/navbar.jsp" %>

            <%@ include file="../layouts/sidebar.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">New User</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-6">
          <div class="box box-primary">            
            <form role="form" method="POST" action="${pageContext.request.contextPath}/User-List">
              <div class="box-body">
                <div class="form-group">
                  <label>Name</label>
                  <input type="text" class="form-control" name="name" value="${student.name}" required>
                </div>
                  <div class="form-group">
                  <label>Username</label>
                  <input type="text" class="form-control" name="username" id="uname" value="${student.username}" required>
                </div>
                  <div class="form-group">
                  <label>Password</label>
                  <input type="password" class="form-control" name="password" value="${student.password}" required>
                </div>
                <div class="form-group">
                  <label>Confirm Password</label>
                  <input type="password" class="form-control" name="cpassword" value="${student.password}" required>
                </div>
                  <!--<div class="form-group">
                  <label>Gender</label>
                  <select name='gender' class="form-control" required>
                    <option value=''>-- Please Select --</option>
                    <:forEach items="{listGender}" var="gender">
                        <option value="{gender.genderID}" {gender.genderID == student.gender ? 'selected="selected"' : ''}>{gender.description}</option>
                    </:forEach>
                  </select>
                </div>-->
                <div class="form-group">
                  <label>Role</label>
                  <select name='role' class="form-control" required>
                    <option value=''>-- Please Select --</option>
                    <c:forEach items="${listRole}" var="role">
                        <option value="${role.roleID}" ${role.roleID == student.role ? 'selected="selected"' : ''}>${role.name}</option>
                    </c:forEach>
                  </select>
                </div>
                  <input type="hidden" name="current_date" value="<fmt:formatDate type="date" value="${now}" />" />
                  <input type="hidden" name="actionPost" value="Add" />
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/User-List" class="btn btn-info" role="button">Cancel</a>
              </div>
            </form>
          </div>
                </div>
            </div>
    <!-- /#wrapper -->

<%@ include file="../layouts/footer.jsp" %>

 <script>
    $(document).ready(function() {
        if(${student.name != null}){
            $("#uname").prop("readonly",true);
        }
    });
    </script>
    
</body>

</html>