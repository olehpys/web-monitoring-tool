<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add new website</title>

    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this templates-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this templates-->
    <link href="/css/sb-admin.css" rel="stylesheet">
    <link href="/css/toast.css" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="/">Website Monitoring Tool</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/all">
                <i class="fas fa-fw fa-bookmark"></i>
                <span>All websites</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/add.jsp">
                <i class="fas fa-fw fa-folder"></i>
                <span>Add website</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="/">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Add new website</li>
            </ol>

            <div class="container">
                <div class="card card-login mx-auto mt-5">
                    <%--<div class="card-header">Login</div>--%>
                    <div class="card-body">
                        <form id="websiteForm" onsubmit="return submitForm()">
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name="id" id="inputId" class="form-control" placeholder="ID"
                                           required="required" autofocus="autofocus">
                                    <label for="inputId">Website ID</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name="url" id="inputUrl" class="form-control" placeholder="Url"
                                           required="required" autofocus="autofocus">
                                    <label for="inputUrl">Website URL</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name="expectedStateStatus" id="inputRespTime"
                                           class="form-control"
                                           placeholder="Response time" required="required" autofocus="autofocus">
                                    <label for="inputRespTime">Response time (sec)</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="number" name="expectedResponseCode" id="inputRespCode"
                                           class="form-control"
                                           placeholder="Response code" required="required" autofocus="autofocus">
                                    <label for="inputRespCode">Response code</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="number" name="expectedMinResponseValue" id="inputMinResponseValue"
                                           class="form-control"
                                           placeholder="Minimal response time size (bytes)" required="required"
                                           autofocus="autofocus">
                                    <label for="inputMinResponseValue">Minimal response size (bytes)</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="number" name="expectedMaxResponseValue" id="inputMaxResponseValue"
                                           class="form-control"
                                           placeholder="Maximal response size (bytes)" required="required"
                                           autofocus="autofocus">
                                    <label for="inputMaxResponseValue">Maximal response size (bytes)</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="websiteStatus" value="ACTIVE">
                            </div>
                            <input type="submit" class="btn btn-primary btn-block" value="Add website"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div id="snackbar">Website successfully added!</div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>2018</span>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<script>
    function submitForm() {
        $.ajax({
            type: 'POST',
            url: '/website/add',
            data: $('#websiteForm').serialize(),
            success: function (response) {
                var x = document.getElementById("snackbar");

                x.className = "show";

                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);

                setTimeout(function () {
                    window.location.reload();
                }, 3500);
            }
        });

        return false;
    }
</script>
<!-- Bootstrap core JavaScript-->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="/vendor/chart.js/Chart.min.js"></script>
<script src="/vendor/datatables/jquery.dataTables.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="/js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="/js/demo/datatables-demo.js"></script>
<script src="/js/demo/chart-area-demo.js"></script>

</body>

</html>
