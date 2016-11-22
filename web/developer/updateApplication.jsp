<%-- 
    Document   : updateApplication
    Created on : Oct 4, 2016, 9:50:56 PM
    Author     : Ish
--%>

<%@page import="Entities.Application"%>
<%@page import="Entities.Developer"%>
<%@page import="Entities.Developer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <html>   
 <%try{if(!request.getSession().getAttribute("developer").equals(null)){%>          <!-- BEGIN HEAD -->
        <head>        
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
            <title>Update App Data</title>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta content="width=device-width, initial-scale=1" name="viewport"/>
            <meta content="" name="description"/>
            <meta content="" name="author"/>
            <!-- BEGIN GLOBAL MANDATORY STYLES -->
            <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
            <!-- END GLOBAL MANDATORY STYLES -->
            <!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
            <link href="../assets/global/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
            <!-- END PAGE LEVEL PLUGIN STYLES -->
            <!-- BEGIN PAGE STYLES -->
            <link href="../assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
            <!-- END PAGE STYLES -->
            <!-- BEGIN THEME STYLES -->
            <link href="../assets/global/css/components.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/layouts/layout/css/layout.css" rel="stylesheet" type="text/css"/>
            <link href="../assets/layouts/layout/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
            <link href="../assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css"/>
            <!-- END THEME STYLES -->
            <!-- AJAX FILE -->

            <script type="text/javascript" src="../ajaxjs/category.js"></script>
            <script type="text/javascript" src="../ajaxjs/loardapplicationforinfolder.js"></script>
            <link rel="shortcut icon" href="favicon.ico"/>

        </head>
        <!-- END HEAD -->
        <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" onload="loardAppplatform()">
            <%
                String appid=null;
                String username = "Guest";
                boolean loging = false;
                Developer c =  (Developer)request.getSession().getAttribute("developer");
                if (!request.getSession().equals(null)) {
                    try {

                        HttpSession s = request.getSession();

                         c= (Developer)s.getAttribute("developer");
                       
                        username = c.getDeveloperFname();
                        loging = true;
                        appid= request.getParameter("appid");
                       if(appid==null){
                              response.sendRedirect("developer/applist.jsp");
                       }
                    } catch (Exception e) {

                    }
                }
                if(!loging){
                    response.sendRedirect("developer/login.jsp");
                }
                String appqty = "";
                if (!c.getApplications().isEmpty()) {
                    appqty = "" + c.getApplications().size();
                }
                

            %>


            <!-- BEGIN HEADER -->
            <div class="page-header navbar navbar-fixed-top">
                <!-- BEGIN HEADER INNER -->
                <div class="page-header-inner ">
                    <!-- BEGIN LOGO -->
                    <div class="page-logo">
                        <a href="index.jsp">
                            <img src="../assets/layouts/layout/img/logo.png" alt="logo" class="logo-default" /> </a>
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
                                    <img alt="" class="img-circle" src="../assets/layouts/layout/img/avatar3_small.jpg" />
                                    <span class="username username-hide-on-mobile"> <%=username%> </span>
                                    <i class="fa fa-angle-down"></i>
                                </a>
                               <ul class="dropdown-menu dropdown-menu-default">
                                  
                                    <li>
                                        <a href="profile.jsp">
                                            <i class="icon-user"></i> My Profile </a>
                                    </li>
                                     <li>
                                         <a href="appPurchaseHistory.jsp">
                                            <i class="glyphicon glyphicon-bitcoin"></i> Purchase History </a>
                                    </li>
                                     <li>
                                         <a href="saveapplication.jsp">
                                            <i class="glyphicon glyphicon-pencil"></i> New Apps </a>
                                    </li>
                                    <li>
                                        <a href="applist.jsp">
                                            <i class="glyphicon glyphicon-list"></i> App List
                                            <span class="badge badge-danger"> <%=appqty%> </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="commentsbox.jsp">
                                            <i class="glyphicon glyphicon-comment"></i> Comment Box
                                            
                                        </a>
                                    </li>
                                    <li> 
                                    
                                    <li>

                                        <a href="../logout">
                                            <i class="icon-key"></i> Log Out </a>
                                    </li>
                                  

                                </ul>
                            </li>
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
                                    <a href="dashboard.jsp">Home</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>Dashboard</span>
                                </li>
                            </ul>

                        </div>

                        <div class="row">
                            <!-- BEGIN VALIDATION STATES-->
                            <div class="portlet light portlet-fit portlet-form bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class=" icon-layers font-green"></i>
                                        <span class="caption-subject font-green sbold uppercase">Register New Application</span>
                                    </div>
                                    <div class="actions">

                                    </div>
                                </div>
                                <%
                              Application ap =(Application) Datacontroller.DataParser.getuniqeresault(new Application(), Integer.parseInt(appid));
                                
                                %>
                                <div class="portlet-body">
                                    <!-- BEGIN FORM-->
                                    <input type="text"  name="appid" class="form-control" placeholder="">
                                    <form action="../updateappdata" onsubmit="return checkAppregistration()" method="POST" class="form-horizontal">
                                        <div class="form-body">
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Applicatoin Name</label>
                                                <div class="col-md-9">
                                                    <input required type="text" id="appname" name="appname" value="<%=ap.getApplicationName()%>" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">App Price</label>
                                                <div class="col-md-9">
                                                    <input type="number" required id="price" name="price" value="<%=ap.getPrice()%>" class="form-control " placeholder="">
                                                   
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>


                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Descriptions</label>
                                                <div class="col-md-9">
                                                    <input type="text" required name="description" value="<%=ap.getDescription()%>"  id="description" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Application File</label>
                                                <div class="col-md-9">
                                                    <input type="file" required name="applicationfile" value="<%=ap.getAppurl()%>" id="applicationfile" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">User Manual URL</label>
                                                <div class="col-md-9">
                                                    <input type="url" required name="usermanualurl" value="<%=ap.getUserManualUrl()%>" id="usermanualurl" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">App Icon</label>
                                                <div class="col-md-9">
                                                    <input type="file" required name="appicon" value="<%=ap.getAppImage()%>" id="appicon" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Video URL</label>
                                                <div class="col-md-9">
                                                    <input type="url" required name="videourl" value="<%=ap.getVideoUrl()%>" id="videourl" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                            
                                             <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Images 1</label>
                                                <div class="col-md-9">
                                                    <input type="file" required name="images1" value="<%=ap.getInterface1()%>" id="images1" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                             <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Images 2</label>
                                                <div class="col-md-9">
                                                    <input type="file" required name="images2" value="<%=ap.getInterface2()%>" id="images2" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>
                                             <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Images 3</label>
                                                <div class="col-md-9">
                                                    <input type="file" required name="images3" value="<%=ap.getInterface3()%>" id="images3" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    <span class="help-block">Some help goes here...</span>
                                                </div>
                                            </div>

                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">  Selects App platform </label>
                                                <div class="col-md-9">

                                                    <span>
                                                        <select required style="width:80%px" class="form-control form-inline" onchange="loardApptype()"    id="Appplatformlist">

                                                        </select>

                                                    </span> 
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1"> Selects app Type </label>
                                                <div class="col-md-9">

                                                    <span>
                                                        <select required class="form-control" onchange="loardAppplatcategory()" id="apptypelist">

                                                        </select>

                                                    </span> 
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1"> Selects app Category </label>
                                                <div class="col-md-9">

                                                    <span>
                                                        <select required class="form-control"   id="appcategorylist">

                                                        </select>

                                                    </span> 
                                                </div>
                                            </div>


                                            
                                        </div>
                                        <div class="form-actions">
                                            <div class="row">
                                                <div class="col-md-offset-3 col-md-9">
                                                    <input type="submit" class="btn green"/>
                                                    <a href="javascript:;" class="btn default">Cancel</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- END FORM-->
                                </div>
                            </div>
                            <!-- END VALIDATION STATES-->
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
           <div class="page-footer-inner"> Apps Store Developers 
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
        <script src="../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="../assets/global/plugins/moment.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/counterup/jquery.counterup.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/pie.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/radar.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/themes/light.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/themes/patterns.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amcharts/themes/chalk.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/ammap/ammap.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/ammap/maps/js/worldLow.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/amcharts/amstockcharts/amstock.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
        <script src="../assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="../assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="../assets/pages/scripts/dashboard.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="../assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
        <script src="../assets/layouts/layout/scripts/demo.min.js" type="text/javascript"></script>
        <script src="../assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
    </body>
<%}}catch(Exception e){
response.sendRedirect("applist.jsp");
}%>
</html>