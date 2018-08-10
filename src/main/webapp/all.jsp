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

    <title>All websites</title>

    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this templates-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this templates-->
    <link href="/css/sb-admin.css" rel="stylesheet">

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
                    <a href="#">All websites</a>
                </li>
                <li class="breadcrumb-item active">Overview</li>
            </ol>


            <!-- DataTables Example -->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    All websites table
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>URL</th>
                                <th>Status</th>
                                <th>Response time</th>
                                <th>Response code</th>
                                <th>Min response length</th>
                                <th>Max response length</th>
                                <th>Date to start monitoring</th>
                                <th>Date to stop monitoring</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${websites}" var="websites">
                                <tr>
                                    <td><a href="/website/${websites.id}">${websites.id}</a></td>
                                    <td>${websites.url}</td>
                                    <td>${websites.websiteStatus}</td>
                                    <td>${websites.expectedResponseTime}</td>
                                    <td>${websites.expectedResponseCode}</td>
                                    <td>${websites.expectedMinResponseValue}</td>
                                    <td>${websites.expectedMaxResponseValue}</td>
                                    <td>${websites.dateFrom}</td>
                                    <td>${websites.dateTo}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated now</div>
            </div>

        </div>
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

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


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

<script src="/js/demo/datatables-demo.js"></script>

</body>

</html>
