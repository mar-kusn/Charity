<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Charity - Admin panel</title>

    <!-- Custom fonts for this template-->
    <link rel="stylesheet" href="<c:url value="resources/vendor/fontawesome-free/css/all.min.css"/>" type="text/css"/>
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="resources/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Charity <sup>Admin panel</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/admin">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Admin panel</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Manage
        </div>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/admins" aria-expanded="true">
                <i class="fas fa-fw fa-cog"></i>
                <span>Admins</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/institutions" aria-expanded="true">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Institutions</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/" aria-expanded="true">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Charity main page</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

    </ul>
    <!-- End of Sidebar -->
