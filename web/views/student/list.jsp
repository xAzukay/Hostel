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
                    <h1 class="page-header">Manage Student</h1>
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
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <form action="${pageContext.request.contextPath}/Student-List" method="POST" id="frmStudent" role="form" >
                                    <input type="hidden" id="student_id" name="student_id">
                                    <input type="hidden" id="action" name="actionPost">
                                        <table class="table table-striped table-bordered table-hover" id="dataTable-student">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Matric No</th>
                                                    <th>Name</th>
                                                    <th>IC No</th>
                                                    <th>Gender</th>
                                                    <th>College</th>
                                                    <th>Status</th>
                                                    <th>Date Apply</th>
                                                </tr>
                                            </thead>
                                    <tbody>
                                        <c:forEach var="student" items="${students}">
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/Student/Edit/${util:encode(student.matric)}">${student.matric}</a>                                                   
                                                </td>
                                                <td><c:out value="${student.name}" /></td>
                                                <td><c:out value="${student.ic}" /></td>
                                                <td><c:out value="${student.genderName}" /></td>
                                                <td><c:out value="${student.buildingName}" /></td>
                                                <td><c:out value="${student.statusName}" /></td>
                                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${student.created}"/></td>
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
        var aoColumnDefs = [{ "aTargets": [0], "bSortable": false }];

        //unsorting first column
        var t = $('#dataTable-student').DataTable({
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