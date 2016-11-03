<%-- 
    Document   : deactivatedaddressdata
    Created on : Oct 14, 2016, 11:41:14 PM
    Author     : Ish
--%>

<%@page import="java.util.Set"%>
<%@page import="Entities.Staff"%>
<%@page import="Entities.Rolehassubmenu"%>
<%@page import="Entities.City"%>
<%@page import="Entities.Discrict"%>
<%@page import="Entities.Province"%>
<%@page import="Entities.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Customer"%>
<%@page import="com.sun.xml.rpc.processor.generator.CustomClassGenerator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <html>   
       <%try{%> <!-- BEGIN HEAD -->
        <head>        
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
            <title>Customer Maintains</title>
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
            <script type="text/javascript" src="../ajaxjs/enableaddresdetails.js"></script>
            <link rel="shortcut icon" href="favicon.ico"/>
<%
            Set<Rolehassubmenu>  list=null;  if(request.getSession().getAttribute("staff").equals(null)){
                    response.sendRedirect("login.jsp");
                }
            try{
      Staff staff=(Staff)request.getSession().getAttribute("staff");
       list=staff.getRoles().getRolehassubmenus();
     boolean states=false;
      for(Rolehassubmenu rhs:list){
        if(  rhs.getSubmenu().getPageurl()=="deactivatedaddressdata.jsp"){
            System.out.println(rhs.getSubmenu().getPageurl());
            states=true;
        }
      }
      if(states){
          response.sendRedirect("dashboard.jsp?msg=NeedPermission");
      }
            }catch(NullPointerException e){
                 response.sendRedirect("dashboard.jsp");
            }
        %>
        </head>
        <!-- END HEAD -->
        <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
            <!-- BEGIN HEADER -->
            <div class="page-header navbar navbar-fixed-top">
                <!-- BEGIN HEADER INNER -->
                <div class="page-header-inner ">
                    <!-- BEGIN LOGO -->
                    <div class="page-logo">
                        <a href="index.html">
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
                            <!-- BEGIN NOTIFICATION DROPDOWN -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                             
                            <!-- END NOTIFICATION DROPDOWN -->
                            <!-- BEGIN INBOX DROPDOWN -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                             
                            <!-- END INBOX DROPDOWN -->
                            <!-- BEGIN TODO DROPDOWN -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                             
                            <li class="dropdown dropdown-user">
                                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                    <img alt="" class="img-circle" src="../assets/layouts/layout/img/avatar3_small.jpg" />
                                    <span class="username username-hide-on-mobile"> Nick </span>
                                    <i class="fa fa-angle-down"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-default">
                                    <li>
                                        <a href="page_user_profile_1.html">
                                            <i class="icon-user"></i> My Profile </a>
                                    </li>
                                    <li>
                                        <a href="app_calendar.html">
                                            <i class="icon-calendar"></i> My Calendar </a>
                                    </li>
                                    <li>
                                        <a href="app_inbox.html">
                                            <i class="icon-envelope-open"></i> My Inbox
                                            <span class="badge badge-danger"> 3 </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="app_todo.html">
                                            <i class="icon-rocket"></i> My Tasks
                                            <span class="badge badge-success"> 7 </span>
                                        </a>
                                    </li>
                                    <li class="divider"> </li>
                                    <li>
                                        <a href="page_user_lock_1.html">
                                            <i class="icon-lock"></i> Lock Screen </a>
                                    </li>
                                    <li>
                                        <a href="page_user_login_1.html">
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
                                 
                                <!-- END RESPONSIVE QUICK SEARCH FORM -->
                            </li>
                            <%for(Rolehassubmenu rhs:list){
                                
                            
                                  %>
                            <li class="nav-item start active open">
                                <a href="<%= rhs.getSubmenu().getPageurl()%>" class="nav-link nav-toggle">
                                    <i class="icon-home"></i>
                                    <span class="title"><%=  rhs.getSubmenu().getSubmenu()%></span>
                                    <span class="selected"></span>
                                    <span class="arrow open"></span>
                                </a>
                                 
                            </li>
                            <%}%>
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
                                    <a href="index.html">Home</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>Dashboard</span>
                                </li>
                            </ul>

                        </div>
                     
                        <%-- Main--%> 
                        <style type="text/css">
                            .table-fixed thead {
                                width: 97%;
                            }
                            .table-fixed tbody {
                                height: 230px;
                                overflow-y: auto;
                                width: 100%;
                            }
                            .table-fixed thead, .table-fixed tbody, .table-fixed tr, .table-fixed td, .table-fixed th {
                                display: block;
                            }
                            .table-fixed tbody td, .table-fixed thead > tr> th {
                                float: left;
                                border-bottom-width: 0;
                            }.scrollit {
                                overflow:scroll;
                                
                            }
                        </style>






                        <div class="container">
                            <h2>Deactive County</h2>
                            
                            <div class="scrollit table-bordered">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                             
                                            <th>Country</th>
                                            <th></th>
                                             
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<Object> countylist = Datacontroller.DataParser.Searchdata(new Country());
                                            for (Object cob : countylist) {
                                                Country c = (Country) cob;
                                                if (!c.isState()) {
                                                 

                                        %>
                                        <tr>
                                            <td><%=c.getIdCountry()%></td>
                                            <td><%=c.getCountryName()%></td>
                                            <td> <a class="btn-default"><button onclick="activeordeactiveCountry(true,<%=c.getIdCountry()%>)" type="submit"><span class="glyphicon glyphicon-send"> Enable Country </span></button></a></form></td>
                                        </tr>
                                        <%}
                                        }%>
                                    </tbody>
                                </table>
                            </div>

                            <h2>Deactive Province</h2>
                            
                            <div class="scrollit table-bordered"  >
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                             
                                            <th>Country</th>
                                            <th>Province</th>
                                            <th></th>
                                             
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<Object> provincelist = Datacontroller.DataParser.Searchdata(new Province());
                                            for (Object cob : provincelist) {
                                                Province c = (Province) cob;
                                                if (!c.isState()) {
                                                    

                                        %>
                                        <tr>
                                            <td><%=c.getIdprovince()%></td>
                                            <td><%= c.getCountry().getCountryName()%></td>
                                            <td><%=c.getProvinceName() %></td>
                                            <td> <a class="btn-default"><button onclick="activeordeactiveprovince(true,<%=c.getIdprovince()%>)" type="submit"><span class="glyphicon glyphicon-send"> Enable Province </span></button></a></form></td>
                                        </tr>
                                        <%}
                                        }%>
                                    </tbody>
                                </table>
                            </div> 
                                    
                                   <h2>Deactive District</h2>
                            
                            <div class="scrollit table-bordered" >
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                             
                                            <th>Country</th>
                                            <th>Province</th>
                                            <th>District</th>
                                            <th></th>
                                             
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<Object> districtlist = Datacontroller.DataParser.Searchdata(new Discrict());
                                            for (Object cob : districtlist) {
                                                Discrict c = (Discrict) cob;
                                                if (!c.isState()) {
                                                   

                                        %>
                                        <tr>
                                            <td><%=c.getIdDiscrict()%></td>
                                            <td><%= c.getProvince().getCountry().getCountryName()%></td>
                                            <td><%=c.getProvince().getProvinceName() %></td>
                                            <td><%=c.getDiscrictName() %></td>
                                            <td> <a class="btn-default"><button  onclick="activeordeactivedistrict(true,<%=c.getIdDiscrict()%>)" type="submit"><span class="glyphicon glyphicon-send"> Enable Province </span></button></a></form></td>
                                        </tr>
                                        <%}
                                        }%>
                                    </tbody>
                                </table>
                            </div>      
                                    
                                
                                    
                                      <h2>Deactive City</h2>
                            
                            <div class="scrollit table-bordered" >
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                             
                                            <th>Country</th>
                                            <th>Province</th>
                                            <th>District</th>
                                            <th>City</th>
                                            <th></th>
                                             
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<Object> citylist = Datacontroller.DataParser.Searchdata(new City());
                                            for (Object cob : citylist) {
                                                City c = (City) cob;
                                                if (!c.isState()) {
                                                   

                                        %>
                                        <tr>
                                            <td><%=c.getIdCity()%></td>
                                            <td><%= c.getDiscrict().getProvince().getCountry().getCountryName()%></td>
                                            <td><%=c.getDiscrict().getProvince().getProvinceName() %></td>
                                            <td><%=c.getDiscrict().getDiscrictName() %></td>
                                            <td><%=c.getIdCity() %></td>
                                            <td> <a class="btn-default"><button  onclick="activeordeactivecity(true,<%=c.getIdCity()%>)" type="submit"><span class="glyphicon glyphicon-send"> Enable Province </span></button></a></form></td>
                                        </tr>
                                        <%}
                                        }%>
                                    </tbody>
                                </table>
                            </div>
                                    
                                    
                        </div>








                    </div>
                    <!-- END CONTENT BODY -->
                </div>

            </div>
            <!-- END QUICK SIDEBAR -->

            <!-- END CONTAINER -->
            <!-- BEGIN FOOTER -->
            <div class="page-footer">
                <div class="page-footer-inner"> 2014 &copy; Metronic by keenthemes.
                    <a href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes" title="Purchase Metronic just for 27$ and get lifetime updates for free" target="_blank">Purchase Metronic!</a>
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
<%}catch(NullPointerException e){
                 response.sendRedirect("login.jsp");
            }catch(java.lang.IllegalStateException e){
response.sendRedirect("login.jsp");
}%>
    </html>