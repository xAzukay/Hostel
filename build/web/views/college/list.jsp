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
                    <h1 class="page-header">College</h1>
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
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <form action="${pageContext.request.contextPath}/College-List" method="POST" id="frmCollege" role="form" >
                                    <input type="hidden" id="college_id" name="college_id">
                                    <input type="hidden" id="action" name="actionPost">
                                        <table class="table table-striped table-bordered table-hover" id="dataTable-user">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Name</th>
                                                </tr>
                                            </thead>
                                    <tbody>
                                        <c:forEach var="coll" items="${college}">
                                            <tr>
                                                <td></td>
                                                <td>
                                                    ${coll.collegeName}
                                                    <!--<a href="index?action=edit&userId=c:out value="{student.matric}"/>">{student.matric}</a>-->
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
        var aoColumnDefs = [{ "aTargets": [0], "bSortable": false }];

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