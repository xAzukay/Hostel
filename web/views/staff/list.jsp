<%@ include file="../layouts/header.jsp" %>

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
                    <h1 class="page-header">Manage User</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <c:if test="${not empty message}">                
                <div class="alert ${alert} alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div>
                </c:if>                 
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <c:set var="rand"><%= java.lang.Math.round(java.lang.Math.random() * 1000000) %></c:set>
                            <a href="User/Insert/New" class="btn btn-success" role="button">New User</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <form action="${pageContext.request.contextPath}/User-List" method="POST" id="frmUser" role="form" >
                                    <input type="hidden" id="user_id" name="user_id">
                                    <input type="hidden" id="action" name="actionPost">
                                        <table class="table table-striped table-bordered table-hover" id="dataTable-user">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Name</th>
                                                    <th>Role</th>
                                                    <th>Date Created</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                    <tbody>
                                        <c:forEach var="user" items="${users}">
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/User/Edit/${util:encode(user.username)}">${user.name}</a>
                                                    <!--<a href="index?action=edit&userId=c:out value="{student.matric}"/>">{student.matric}</a>-->
                                                </td>
                                                <td><c:out value="${user.roleName}" /></td>
                                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${user.created}"/></td>
                                                <td align="center">
                                                    <a href="#" id="remove" 
                                                    onclick="document.getElementById('action').value = 'delete';
                                                             document.getElementById('user_id').value = '${user.userID}';
                                                             document.getElementById('frmUser').submit();"> 
                                                        <span class="glyphicon glyphicon-trash"/>
                                                    </a>        
                                                </td>
                                            </tr>
                                        </c:forEach>                                         
                                    </tbody>
                                </table>
                                </form>
                            </div>
                        </div>
            <!-- /.row -->
            <div class="row">
                
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
            </div>
    <!-- /#wrapper -->

<%@ include file="../layouts/footer.jsp" %>

<script>
    $(function () {

        //sorting selected colum only
        var aoColumnDefs = [{ "aTargets": [0,3], "bSortable": false }];

        //unsorting first column
        var t = $('#dataTable-user').DataTable({
            "aoColumnDefs": aoColumnDefs,
            "columnDefs": [{
                "searchable": false,
                "orderable": false,
                "targets": 0
            }],
            "order": [[1, 'asc']]
        });

        t.on('order.dt search.dt', function () {
            t.column(0, { search: 'applied', order: 'applied' }).nodes().each(function (cell, i) {
                cell.innerHTML = i + 1;
            });
        }).draw();

    });
    </script>
</body>

</html>