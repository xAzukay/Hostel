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
                            Student Application Detail
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <form action="${pageContext.request.contextPath}/Student-List" method="POST" id="frmStudent" role="form" >
                                    <input type="hidden" id="student_id" name="student_id" value="${result.matric}">
                                    <input type="hidden" id="action" name="actionPost">
                                    <input type="hidden" id="user_id" name="user_id" value="${user.userID}">
                                        <table class="table table-bordered" id="dataTable-student">
                                            
                                    <tbody>
                                        <tr>
                                            <td class="col-md-3">Matric No.</td>
                                            <td class="col-md-5">${result.matric}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Name</td>
                                            <td class="col-md-5">${result.name}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">IC No</td>
                                            <td class="col-md-5">${result.ic}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Address</td>
                                            <td class="col-md-5">${result.address}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Mobile No.</td>
                                            <td class="col-md-5">${result.mobile}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Email</td>
                                            <td class="col-md-5">${result.email}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Gender</td>
                                            <td class="col-md-5">${result.genderName}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Semester</td>
                                            <td class="col-md-5">${result.sessionYear}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Faculty</td>
                                            <td class="col-md-5">${result.facultyName}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Courses</td>
                                            <td class="col-md-5">${result.coursesName}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">College</td>
                                            <td class="col-md-5">${result.buildingName}</td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Date Apply</td>
                                            <td class="col-md-5"><fmt:formatDate pattern="dd/MM/yyyy" value="${result.created}"/></td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Level</td>
                                            <td class="col-md-5">
                                                <select name='level' class="form-control" id="data_level" style="width:200px">
                                                    <option value=''>-- Please Select --</option>
                                                    <option value='1'>Level 1</option>
                                                    <option value='2'>Level 2</option>
                                                    <option value='3'>Level 3</option>
                                                    <option value='4'>Level 4</option>
                                                    <option value='5'>Level 5</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Room</td>
                                            <td class="col-md-5">
                                                <select name='room' class="form-control" id="data_room" style="width:200px"></select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Status</td>
                                            <td class="col-md-5">
                                                <select name='status' class="form-control" id="data_status" style="width:200px">
                                                  <option value=''>-- Please Select --</option>
                                                  <c:forEach items="${listStatus}" var="stats">
                                                      <option value="${stats.statusID}">${stats.statusName}</option>
                                                  </c:forEach>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-3">Remark</td>
                                            <td class="col-md-5"><input type="text" class="form-control" name="remark" id="cancelRemark"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><button type="submit" class="btn btn-primary">Submit</button></td>
                                        </tr>
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
        
        $('#data_level').on('change', function (e) {
            var level = $('#data_level').val();

            $.getJSON('Student/Edit',{ room: ${result.buildingID},level: level }, function (data) {
                var col = $('#data_room');
                col.empty();
                $(col).append("<option value='' >" + "-- Please Select --" + "</option>");
                for (var i = 0; i < data.length; i++) {
                    $(col).append(new Option(data[i]._roomName, data[i]._roomID));
                }
            });
        });
    </script>
</body>

</html>