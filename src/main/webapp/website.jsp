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

    <title>Website details</title>

    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this templates-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this templates-->
    <link href="/css/sb-admin.css" rel="stylesheet">
    <link href="/css/toast.css" rel="stylesheet">

    <style>
        #buttons div {
            display: inline-block;
            width: 130px;
        }
    </style>
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
                <li class="breadcrumb-item active">Website details</li>
            </ol>

            <div class="container">
                <h2>Expected website data</h2>
                <table class="table table-striped">
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
                    <tr>
                        <td>${model.expectedWebsite.id}</td>
                        <td>${model.expectedWebsite.url}</td>
                        <td>${model.expectedWebsite.websiteStatus}</td>
                        <td>${model.expectedWebsite.expectedResponseTime}</td>
                        <td>${model.expectedWebsite.expectedResponseCode}</td>
                        <td>${model.expectedWebsite.expectedMinResponseValue}</td>
                        <td>${model.expectedWebsite.expectedMaxResponseValue}</td>
                        <td>${model.expectedWebsite.dateFrom}</td>
                        <td>${model.expectedWebsite.dateTo}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <br>

            <div class="container">
                <h2>Received website data</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>URL</th>
                        <th>State</th>
                        <th>Response code</th>
                        <th>Response time</th>
                        <th>Content length</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${model.websiteState.id}</td>
                        <td>${model.websiteState.url}</td>
                        <td>${model.websiteState.state}</td>
                        <td>${model.websiteState.responseCode}</td>
                        <td>${model.websiteState.responseTime}</td>
                        <td>${model.websiteState.contentLength}</td>

                    </tr>
                    </tbody>
                </table>
            </div>

            <div id="buttons" style="text-align:center">
                <button id="editWebsite" class="btn btn-info"
                        onclick="window.location='/website/edit/${model.expectedWebsite.id}';">Edit website
                </button>
                <form id="websiteDeleteForm" onsubmit="return submitForm()">
                    <br>
                    <input type="hidden" name="id" value="${model.expectedWebsite.id}">
                    <input type="submit" class="btn btn-danger" value="Delete website"/>
                </form>
                <br>
            </div>
            <div id="snackbar">Website successfully deleted!</div>
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
</div>
<!-- /#wrapper -->


<script>
    function submitForm() {
        $.ajax({
            type: 'POST',
            url: '/website/delete',
            data: $('#websiteDeleteForm').serialize(),
            success: function (response) {

                var x = document.getElementById("snackbar");

                x.className = "show";

                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);

                setTimeout(function () {
                    window.location = "/";
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

<script src="/js/demo/datatables-demo.js"></script>

</body>

</html>
