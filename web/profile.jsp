<%-- 
    Document   : category
    Created on : Sep 26, 2016, 12:35:38 AM
    Author     : Ish
--%>

<%@page import="Entities.Gender"%>
<%@page import="Entities.Wishlist"%>
<%@page import="Entities.Customer"%>
<%@page import="Datacontroller.DataParser"%>
<%@page import="Entities.Application"%>
<%@page import="Entities.Category"%>
<%@page import="Entities.Apptype"%>
<%@page import="java.util.Set"%>
<%@page import="Entities.Appplatform"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("user")!= null){%>
<html lang="en">  
        <!-- BEGIN HEAD -->
        <head>        
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
            <title>Profile</title>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta content="width=device-width, initial-scale=1" name="viewport"/>
            <meta content="" name="description"/>
            <meta content="" name="author"/>
            <!-- BEGIN GLOBAL MANDATORY STYLES -->
            <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
            <!-- END GLOBAL MANDATORY STYLES -->
            <!-- BEGIN PGE LEVEL PLUGIN STYLES -->
            <link href="assets/global/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
            <!-- END PAGE LEVEL PLUGIN STYLES -->
            <!-- BEGIN PAGE STYLES -->
            <link href="assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
            <!-- END PAGE STYLES -->
            <!-- BEGIN THEME STYLES -->
            <link href="assets/global/css/components.css" rel="stylesheet" type="text/css"/>
            <link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
            <link href="assets/layouts/layout/css/layout.css" rel="stylesheet" type="text/css"/>
            <link href="assets/layouts/layout/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
            <link href="assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css"/>
            <!-- END THEME STYLES -->
            <!-- AJAX FILE -->
            <script type="text/javascript" src="ajaxjs/category.js"></script>
            <script type="text/javascript" src="ajaxjs/loardapplication.js"></script>
            <script type="text/javascript" src="ajaxjs/customeraddressdetails.js"></script>
            <link rel="shortcut icon" href="favicon.ico"/>

        </head>

        <!-- END HEAD -->
        <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
            <%
                try {
                   // Customer c = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), Integer.parseInt(request.getSession().getAttribute("userid").toString()));
                    Customer c = (Customer) session.getAttribute("user");
                    //if (request.getSession().getAttribute("userid").equals(c.getIdCustomer())) {
                    if (c != null) {
                        String image = "assets/layouts/layout/img/avatar3_small.jpg";
                        if (!(c.getCustomerImage() == null)) {
                            image = c.getCustomerImage();
                        }
                        String cartqty = "";
                        String wishlistqty = "";
                        String username = c.getCustomerFname();

            %>
            <!-- BEGIN HEADER -->
            <div class="page-header navbar navbar-fixed-top">
                <!-- BEGIN HEADER INNER -->
                <div class="page-header-inner ">
                    <!-- BEGIN LOGO -->
                    <div class="page-logo">
                        <a href="index.jsp">
                            <img src="assets/layouts/layout/img/logo.png" alt="logo" class="logo-default" /> </a>
                        <div class="menu-toggler sidebar-toggler"> </div>
                    </div>
                    <!-- END LOGO -->
                    <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                    <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
                    <!-- END RESPONSIVE MENU TOGGLER -->
                    <!-- BEGIN TOP NAVIGATION MENU -->
                    <div class="top-menu">
                        <ul class="nav navbar-nav pull-right">

                            <!-- END NOTIFICATION DROPDOWN -->
                            <!-- BEGIN INBOX DROPDOWN -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->

                            <li class="dropdown dropdown-user">
                                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                    <img alt="" class="img-circle" src="<%=image%>" />
                                    <span class="username username-hide-on-mobile"><%=username%></span>
                                    <i class="fa fa-angle-down"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-default">
                                    <li>
                                        <a href="profile.jsp">
                                            <i class="icon-user"></i> My Profile </a>
                                    </li>

                                    <li>
                                        <a href="cart.jsp">
                                            <i class="glyphicon glyphicon-shopping-cart"></i> Cart
                                            <span class="badge badge-danger"><%=cartqty%></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="wishlist.jsp">
                                            <i class="icon-wallet"></i> WishList
                                            <span class="badge badge-default"><%=wishlistqty%> </span>
                                        </a>
                                    </li>

                                    <li>

                                        <a href="logout">
                                            <i class="icon-key"></i> Log Out </a>
                                    </li>
                                </ul>
                            </li>
                            <!-- END USER LOGIN DROPDOWN -->
                            <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                            <li class="dropdown dropdown-quick-sidebar-toggler">
                                <a href="javascript:;" class="dropdown-toggle">
                                    <i class="icon-logout"></i>
                                </a>
                            </li>
                            <!-- END QUICK SIDEBAR TOGGLER -->
                        </ul>
                    </div>
                    <!-- END TOP NAVIGATION MENU -->
                </div>
                <!-- END HEADER INNER -->
            </div>
            <!-- END HEADER -->
            <!-- BEGIN HEADER & CONTENT DIVIDER -->
            <div class="clearfix"> </div>
            <!-- END HEADER & CONTENT DIVIDER -->
            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <!-- BEGIN SIDEBAR -->
                <div class="page-sidebar-wrapper">
                    <div class="page-sidebar navbar-collapse collapse">
                        <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                            <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                            <li class="sidebar-toggler-wrapper hide">
                                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                                <div class="sidebar-toggler"> </div>
                                <!-- END SIDEBAR TOGGLER BUTTON -->
                            </li>
                            <!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
                            <li class="sidebar-search-wrapper">
                                <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                                <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
                                <!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
                                <form class="sidebar-search  " action="" method="POST">
                                    <a href="javascript:;" class="remove">
                                        <i class="icon-close"></i>
                                    </a>
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search...">
                                        <span class="input-group-btn">
                                            <a href="javascript:;" class="btn submit">
                                                <i class="icon-magnifier"></i>
                                            </a>
                                        </span>
                                    </div>
                                </form>
                                <!-- END RESPONSIVE QUICK SEARCH FORM -->
                            </li>
                            <%
                                ArrayList<Object> apps = Datacontroller.DataParser.Searchdata(new Appplatform());
                                for (Object o : apps) {
                                    Appplatform app = (Appplatform) o;
                                    if (app.isState()) {
                            %>
                            <li class="nav-item start">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-home"></i>
                                    <span class="title"><%=app.getAppplatform()%></span>
                                    <span class="selected"></span>
                                    <span class="arrow open"></span>
                                </a>

                                <ul class="sub-menu">
                                    <%

                                        Set<Apptype> apptypes = app.getApptypes();
                                        for (Apptype apptype : apptypes) {
                                            if (apptype.isState()) {
                                    %>
                                    <li class="nav-item start">
                                        <a href="javascript:;" class="nav-link nav-toggle">
                                            <i class="icon-tag"></i>

                                            <span class="title"><%=apptype.getApptype()%></span>
                                            <span class="selected"></span>
                                            <span class="arrow open"></span>
                                        </a>
                                        <ul class="sub-menu">
                                            <%
                                                Set<Category> categories = apptype.getCategories();
                                                for (Category category : categories) {
                                                    if (category.isState()) {
                                            %>
                                            <li class="nav-item start">
                                                <a href="javascript:;" class="nav-link nav-toggle">

                                                    <i class="icon-folder"></i>
                                                    <span class="title"><%=category.getCategory()%></span>
                                                    <span class="selected"></span>
                                                    <span class="arrow open"></span>
                                                </a>
                                                <ul>
                                                    <%
                                                        Set<Application> applications = category.getApplications();
                                                        for (Application appl : applications) {
                                                            if (appl.isState()) {


                                                    %>
                                                    <li class="nav-item start">
                                                        <a href="index.jsp?appid=<%= appl.getIdApplication()%>" class="nav-link nav-item">

                                                            <i class="icon-game-controller"></i>
                                                            <span class="title"><%=  appl.getApplicationName()%></span>
                                                            <span class="selected"></span>
                                                            <span class="views"></span>
                                                        </a>
                                                    </li>

                                                    <%
                                                            }

                                                        }
                                                    %>
                                                </ul>
                                            </li>
                                            <%}
                                                }%>
                                        </ul>
                                        <%}
                                            }%>

                                </ul>

                            </li>
                            <%}
                                }%>
                        </ul>
                        <!-- END SIDEBAR MENU -->
                        <!-- END SIDEBAR MENU -->
                    </div>
                    <!-- END SIDEBAR -->
                </div>

                <!-- END SIDEBAR -->
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <!-- BEGIN CONTENT BODY -->
                    <div class="page-content">
                        <!-- BEGIN PAGE HEADER-->
                        <!-- BEGIN THEME PANEL -->
                        <div class="theme-panel hidden-xs hidden-sm">
                            <div class="toggler"> </div>
                            <div class="toggler-close"> </div>
                            <div class="theme-options">
                                <div class="theme-option theme-colors clearfix">
                                    <span> THEME COLOR </span>
                                    <ul>
                                        <li class="color-default current tooltips" data-style="default" data-container="body" data-original-title="Default"> </li>
                                        <li class="color-darkblue tooltips" data-style="darkblue" data-container="body" data-original-title="Dark Blue"> </li>
                                        <li class="color-blue tooltips" data-style="blue" data-container="body" data-original-title="Blue"> </li>
                                        <li class="color-grey tooltips" data-style="grey" data-container="body" data-original-title="Grey"> </li>
                                        <li class="color-light tooltips" data-style="light" data-container="body" data-original-title="Light"> </li>
                                        <li class="color-light2 tooltips" data-style="light2" data-container="body" data-html="true" data-original-title="Light 2"> </li>
                                    </ul>
                                </div>
                                <div class="theme-option">
                                    <span> Theme Style </span>
                                    <select class="layout-style-option form-control input-sm">
                                        <option value="square" selected="selected">Square corners</option>
                                        <option value="rounded">Rounded corners</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Layout </span>
                                    <select class="layout-option form-control input-sm">
                                        <option value="fluid" selected="selected">Fluid</option>
                                        <option value="boxed">Boxed</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Header </span>
                                    <select class="page-header-option form-control input-sm">
                                        <option value="fixed" selected="selected">Fixed</option>
                                        <option value="default">Default</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Top Menu Dropdown</span>
                                    <select class="page-header-top-dropdown-style-option form-control input-sm">
                                        <option value="light" selected="selected">Light</option>
                                        <option value="dark">Dark</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Sidebar Mode</span>
                                    <select class="sidebar-option form-control input-sm">
                                        <option value="fixed">Fixed</option>
                                        <option value="default" selected="selected">Default</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Sidebar Menu </span>
                                    <select class="sidebar-menu-option form-control input-sm">
                                        <option value="accordion" selected="selected">Accordion</option>
                                        <option value="hover">Hover</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Sidebar Style </span>
                                    <select class="sidebar-style-option form-control input-sm">
                                        <option value="default" selected="selected">Default</option>
                                        <option value="light">Light</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Sidebar Position </span>
                                    <select class="sidebar-pos-option form-control input-sm">
                                        <option value="left" selected="selected">Left</option>
                                        <option value="right">Right</option>
                                    </select>
                                </div>
                                <div class="theme-option">
                                    <span> Footer </span>
                                    <select class="page-footer-option form-control input-sm">
                                        <option value="fixed">Fixed</option>
                                        <option value="default" selected="selected">Default</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!-- END THEME PANEL -->
                        <!-- BEGIN PAGE BAR -->
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="index.jsp">Home</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>Profile</span>
                                </li>
                            </ul>

                        </div>
                        <div class="row">
                            <div class="col-lg-12">

                            </div>
                        </div>
                        <%-- Main--%>
                        <div class="container">
                            <div>
                                <div class="general">

                                    <h4 class="latest-text w3_latest_text">Change Password</h4>
                                    <div class="container">

                                        <%--      password chage are       ---%>
                                        <form onsubmit="return checkpassword()" action="changepassword" method="POST"><div class="form-group form-md-line-input" >
                                                <label class="col-md-3 control-label"  for="form_control_1">Current Password</label>
                                                <div class="col-md-6">
                                                    <input type="password" name="oldpassword" id="pass1" class="form-control" placeholder="" required>
                                                    <div class="form-control-focus"> </div>

                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label"  for="form_control_1">Password</label>
                                                <div class="col-md-6">
                                                    <input type="password" name="pass1" id="pass1" class="form-control" placeholder="" required>
                                                    <div class="form-control-focus"> </div>

                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Retype Password</label>
                                                <div class="col-md-6">
                                                    <input type="password" name="pass2" id="pass2" class="form-control" placeholder="" required>
                                                    <div class="form-control-focus"> </div>

                                                </div>
                                            </div>
                                            <br>
                                            <div class="form-actions">
                                                <div class="row">
                                                    <div class="col-md-offset-3 col-md-6">
                                                        <input type="submit" value="Change Password"  class="btn green"/>
                                                        <a href="profile.jsp" class="btn default">Cancel</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                        </form>
                                        <%--      password chage are end      ---%>

                                        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                                            <ul id="myTab" class="nav nav-tabs" role="tablist">
                                            </ul>
                                            <div id="myTabContent" class="tab-content">
                                                <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
                                                    <div class="scroller" style="height: 525px;" data-always-visible="1" data-rail-visible1="1">
                                                        <div class="portlet-body">
                                                            <div class="form-inline">

                                                                <script type="text/javascript">

                                                                    function checkimage() {

                                                                        var input = document.forms['file_upload']['image_file'];

                                                                        if (input.files[0].size > 600000) {

                                                                            document.getElementById('msg').innerHTML = "File Size Too Large.. ";
                                                                            document.getElementById('msg').style.color = "RED";
                                                                            return false;

                                                                        } else {

                                                                            return true;

                                                                        }

                                                                    }

                                                                </script>
                                                                <form action="changeprofileimage" onsubmit="return checkimage()" name="file_upload" enctype="multipart/form-data" method="POST">
                                                                    <div class="panel right inline">
                                                                        <div class="col-md-offset-3">
                                                                            <img width="100px" id="pimage" class="pull-xs-left" src="<%=image%>"/>
                                                                            <p id="msg"></p>
                                                                        </div>
                                                                        <div class="col-md-offset-3">
                                                                            <input type="file"  name="image" onselect="document.getElementById('pimage').src = document.getElementById('image').value" class="btn-default" />
                                                                            <div class="col-md-offset-6">
                                                                                <input type="submit" value="Change Image"  class="btn green"/>
                                                                            </div>
                                                                        </div>  

                                                                    </div>
                                                                </form>
                                                            </div>
                                                            <!-- BEGIN FORM-->
                                                            <form action="updatecustomerdata" onsubmit="return checkprofiledata()" name="updatecusdata"   method="POST"  class="form-horizontal">
                                                                <div class="form-body">
                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label" for="form_control_1">First Name</label>
                                                                        <div class="col-md-6">
                                                                            <input type="text" id="fname" name="fname" value="<%=c.getCustomerFname()%>" class="form-control" placeholder="" required>
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label" for="form_control_1">Middle Name</label>
                                                                        <div class="col-md-6">
                                                                            <input type="text" id="mname" value="<%=c.getCustomerMname()%>" name="mname" class="form-control" placeholder="">
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>


                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label" for="form_control_1">Last Name</label>
                                                                        <div class="col-md-6">
                                                                            <input type="text" name="lname" value="<%=c.getCustomerLname()%>" id="lname" class="form-control" placeholder="" required>
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>

                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label" for="form_control_1">Email</label>
                                                                        <div class="col-md-6">
                                                                            <div class="input-group">
                                                                                <input type="reset" id="email" name="email" value="<%=c.getUsername()%>" class="form-control" placeholder="Email Address">
                                                                                <span class="input-group-addon">
                                                                                    <i class="fa fa-envelope"></i>
                                                                                </span>
                                                                                <div class="form-control-focus"> </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>



                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label"  for="form_control_1">Country</label>
                                                                        <div class="col-md-6">
                                                                            <select class="form-control" id="Countrylist" onchange="loardProvince()" name="Countrylist" required>
                                                                                <option><%=c.getCity().getDiscrict().getProvince().getCountry().getCountryName()%></option>
                                                                            </select>
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label"   for="form_control_1">Province</label>
                                                                        <div class="col-md-6">
                                                                            <select class="form-control"  id="provincelist" onchange="loardDistrict()" name="provincelist" required>
                                                                                <option><%=c.getCity().getDiscrict().getProvince().getProvinceName()%></option>
                                                                            </select>
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label"   for="form_control_1">District</label>
                                                                        <div class="col-md-6">
                                                                            <select class="form-control"  id="districtlist" onchange="loardCity()" name="districtlist" required>
                                                                                <option><%=c.getCity().getDiscrict().getDiscrictName()%></option>
                                                                            </select>
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label"  for="form_control_1">City</label>
                                                                        <div class="col-md-6">
                                                                            <select class="form-control"  id="citylist" name="citylist" required>
                                                                                <option value="<%=c.getCity().getIdCity()%>"><%=c.getCity().getCityName()%></option>
                                                                            </select>
                                                                            <div class="form-control-focus"> </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group form-md-line-input">
                                                                        <label class="col-md-3 control-label" for="form_control_1">Address</label>
                                                                        <div class="col-md-6">
                                                                            <input type="text" name="address"value="<%=c.getAddress()%>" id="address" class="form-control" placeholder="" required>
                                                                            <div class="form-control-focus"> </div>

                                                                        </div>
                                                                    </div>


                                                                    <div class="form-group form-md-radios  ">
                                                                        <label class="col-md-3 control-label"  for="form_control_1">Gender</label>
                                                                        <div class="col-md-6">

                                                                            <div class="md-radio-inline">


                                                                                <div class="md-radio">
                                                                                    <input type="radio" id="checkbox1_8" checked="false" name="gender" value="<%=c.getGender().getGender()%>" class="md-radiobtn">
                                                                                    <label for="checkbox1_8">
                                                                                        <span class="inc"></span>
                                                                                        <span class="check"></span>
                                                                                        <span class="box"></span><%=c.getGender().getGender()%></label>
                                                                                </div>




                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-actions">
                                                                    <div class="row">
                                                                        <div class="col-md-offset-3 col-md-6">
                                                                            <input type="submit" value="Save Changes" class="btn green"/>
                                                                            <a href="profile.jsp" class="btn default">Cancel</a>
                                                                        </div>
                                                                    </div>
                                                                </div>


                                                            </form>
                                                            <!-- END FORM-->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>   



            <div class="clearfix"></div>



        </div>
        <!-- END CONTENT BODY -->
    </div>

</div>
<!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <div class="page-footer-inner">  

    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
<!-- END FOOTER -->
<!--[if lt IE 9]>
<script src="./assets/global/plugins/respond.min.js"></script>
<script src="./assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="assets/global/plugins/moment.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
<script src="assets/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/counterup/jquery.counterup.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/pie.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/radar.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/themes/light.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/themes/patterns.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/themes/chalk.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/ammap/ammap.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/ammap/maps/js/worldLow.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amstockcharts/amstock.js" type="text/javascript"></script>
<script src="assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/pages/scripts/dashboard.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
<script src="assets/layouts/layout/scripts/demo.min.js" type="text/javascript"></script>
<script src="assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
</body>
<%}
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }%>
</html>
<% }else{ response.sendRedirect("index.jsp");}%>