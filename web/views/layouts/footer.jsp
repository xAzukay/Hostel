<script src="${pageContext.request.contextPath}/asset/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/asset/plugin/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/asset/js/sb-admin-2.js"></script>
    <script src="${pageContext.request.contextPath}/asset/plugin/datatable/js/jquery.dataTables.min.js"></script>
     <script src="${pageContext.request.contextPath}/asset/plugin/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    
    <script>
    $(document).ready(function() {
        if(${user.name == null}){
            alert("Your session expirated. Please login");
            window.location.href="${pageContext.request.contextPath}/User-Login";
        }
    });
    </script>
