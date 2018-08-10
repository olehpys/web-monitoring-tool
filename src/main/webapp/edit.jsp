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

    <title>Edit website</title>

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
                <li class="breadcrumb-item">
                    <a href="/website/${website.id}">Website details</a>
                </li>
                <li class="breadcrumb-item active">Edit website</li>
            </ol>

            <div class="container">
                <div class="card card-login mx-auto mt-5">
                    <div class="card-body">
                        <form id="websiteForm" onsubmit="return submitForm()">
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name="id" id="inputId" class="form-control" value="${website.id}"
                                           required="required" autofocus="autofocus">
                                    <label for="inputId">Website ID</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name="url" id="inputUrl" class="form-control"
                                           value="${website.url}"
                                           required="required" autofocus="autofocus">
                                    <label for="inputUrl">Website URL</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name="expectedResponseTime" id="inputRespTime"
                                           class="form-control"
                                           value="${website.expectedResponseTime}" required="required"
                                           autofocus="autofocus">
                                    <label for="inputRespTime">Response time (sec)</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="number" name="expectedResponseCode" id="inputRespCode"
                                           class="form-control"
                                           value="${website.expectedResponseCode}" required="required"
                                           autofocus="autofocus">
                                    <label for="inputRespCode">Response code</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="number" name="expectedMinResponseValue" id="inputMinResponseValue"
                                           class="form-control"
                                           value="${website.expectedMinResponseValue}" required="required"
                                           autofocus="autofocus">
                                    <label for="inputMinResponseValue">Minimal response size (bytes)</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="number" name="expectedMaxResponseValue" id="inputMaxResponseValue"
                                           class="form-control"
                                           value="${website.expectedMaxResponseValue}" required="required"
                                           autofocus="autofocus">
                                    <label for="inputMaxResponseValue">Maximal response size (bytes)</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="date" name="dateFrom" id="inputDateFrom"
                                           class="form-control"
                                           value="${website.dateFrom}" required="required"
                                           autofocus="autofocus">
                                    <label for="inputDateFrom">Date to start monitoring</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="date" name="dateTo" id="inputDateTo"
                                           class="form-control"
                                           value="${website.dateTo}" required="required"
                                           autofocus="autofocus">
                                    <label for="inputDateTo">Date to stop monitoring</label>
                                </div>
                            </div>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="websiteStatus"
                                    id="inlineFormCustomSelect">
                                <option value="ACTIVE">Active</option>
                                <option value="INACTIVE">Inactive</option>
                            </select>
                            <br><br>
                            <input type="submit" class="btn btn-primary btn-block" value="Update website"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div id="snackbar">Website successfully updated!</div>
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
            url: '/website/edit',
            data: $('#websiteForm').serialize(),
            success: function (response) {

                var x = document.getElementById("snackbar");

                x.className = "show";

                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);
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


</body>

</html>
