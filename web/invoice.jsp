<%-- 
    Document   : invoice
    Created on : Nov 15, 2016, 4:09:12 PM
    Author     : Ish
--%>
<%@page import="Datacontroller.DataParser"%>
<%@page import="Entities.Customer"%>
<%@page import="java.util.Set"%>
<%@page import="Entities.Cart"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="en"><!--<![endif]--><!-- BEGIN HEAD --><head>
        <meta charset="utf-8">
        <title> Invoice</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css">
        <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
        <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
        <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css">
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css">
        <link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css">
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="assets/pages/css/invoice.min.css" rel="stylesheet" type="text/css">
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="assets/layouts/layout2/css/layout.min.css" rel="stylesheet" type="text/css">
        <link href="assets/layouts/layout2/css/themes/light.min.css" rel="stylesheet" type="text/css" id="style_color">
        <link href="assets/layouts/layout2/css/custom.min.css" rel="stylesheet" type="text/css">
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico"> </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid">
        <!-- BEGIN HEADER -->
        <%         try{       String username = "";
            boolean loging = false;
            Customer c = new Customer();
            if (!request.getSession().equals(null)) {
                try {
                    HttpSession s = request.getSession();
                    //int cusid = Integer.parseInt(s.getAttribute("userid").toString());
                    //c = (Customer) DataParser.getuniqeresault(new Customer(), cusid);
                    if (s.getAttribute("user") != null) {
                        c = (Customer) s.getAttribute("user");
                        c = (Customer) DataParser.getuniqeresault(new Customer(), c.getIdCustomer());
                        username = c.getCustomerFname();
                        loging = true;
                    } else {
                        c = (Customer) s.getAttribute("guest");
                        username = c.getCustomerFname();
                        //c.getCarts();
                    }
               } catch (NullPointerException e) {
                System.out.println("NULL EXCEPTION");
                response.sendRedirect("login.jsp");
            } catch (Exception ex) {
                System.out.println("  EXCEPTION");

                response.sendRedirect("login.jsp");
            }
            } else {
                response.sendRedirect("login.jsp");
            }
            String cartqty = "";
            if (!c.getCarts().isEmpty()) {
                cartqty = "" + c.getCarts().size();
            }
            String wishlistqty = "";
            if (!c.getWishlists().isEmpty()) {
                wishlistqty = "" + c.getWishlists().size();
            }

        %>
        <!-- END HEADER -->
        <!-- BEGIN HEADER & CONTENT DIVIDER -->
        <div class="clearfix"> </div>
        <!-- END HEADER & CONTENT DIVIDER -->
        <!-- BEGIN CONTAINER -->
        <div>

            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="thumbnail">
                <!-- BEGIN CONTENT BODY -->
                <div class="page-content panel">
                    <!-- BEGIN PAGE HEADER-->
                    <!-- BEGIN THEME PANEL -->

                    <!-- END THEME PANEL -->
                    <h3 class="page-title"> Invoice
                        <small>invoice sample</small>
                    </h3>

                    <!-- END PAGE HEADER-->
                    <div class="invoice">
                        <div class="row invoice-logo">
                            <div class="col-xs-6 invoice-logo-space">
                                <img src="../assets/pages/media/invoice/walmart.png" class="img-responsive" alt=""> </div>
                            <div class="col-xs-6">
                                <p> <%Date d = new Date();
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy");
                                    %><%=sdf.format(d)%>
                                    <span class="muted"><%=username%> </span>
                                </p>
                            </div>
                        </div>
                        <hr>

                        <div class="row">
                            <div class="col-xs-12">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th> App ID </th>
                                            <th> App </th>
                                            <th class="hidden-xs"> Description </th>

                                            <th class="hidden-xs"> Unit Cost </th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            double total = 0.00;
                                            Set<Cart> carts = null;
                                            if (loging) {
                                                carts = c.getCarts();
                                            } else {
                                                //carts = c.getCarts();
                                            }
                                            for (Cart cart : carts) {
                                                if (cart.isState()) {
                                                    total += cart.getApplication().getPrice();

                                        %>
                                        <tr>
                                            <td> <%=cart.getApplication().getIdApplication()%> </td>
                                            <td> <%=cart.getApplication().getApplicationName()%> </td>
                                            <td class="hidden-xs"> <%=cart.getApplication().getDescription()%> </td>
                                            <td class="hidden-xs"> <%= cart.getApplication().getPrice()%> </td>

                                        </tr>
                                        <%}
                                             }%>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">
                                <div class="well">
                                    <address>
                                        <strong>Loop, Inc.</strong>
                                        <br> 795 Park Ave, Suite 120
                                        <br> Matara, Sri Lanka
                                        <br>
                                        <abbr title="Phone">P:</abbr> (941) 145-1810 </address>
                                    <address>
                                        <strong><%%></strong>
                                        <br>
                                        <a href="mailto:#"> appss.store@email.com </a>
                                    </address>
                                </div>
                            </div>
                            <div class="col-xs-8 invoice-block">
                                <ul class="list-unstyled amounts">
                                    <li>
                                        <strong>Sub - Total amount:</strong> $<%=total%> </li>

                                    <li>

                                </ul>
                                <br>

                                <form action="buycartallapps" method="POST">
                                    <a class="btn btn-lg blue hidden-print margin-bottom-5" onclick="javascript:window.print();"> Print
                                        <i class="fa fa-print"></i>
                                    </a>
                                    <button class="btn btn-lg green hidden-print margin-bottom-5" > Ok
                                        <i class="fa fa-check"></button></i>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END CONTENT BODY -->
            </div>
            <!-- END CONTENT -->
            <!-- BEGIN QUICK SIDEBAR -->
            <a href="javascript:;" class="page-quick-sidebar-toggler">
                <i class="icon-login"></i>
            </a>

        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->

        <!-- END FOOTER -->
        <!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js"></script>
<script src="../assets/global/plugins/excanvas.min.js"></script> 
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
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="assets/layouts/layout2/scripts/layout.min.js" type="text/javascript"></script>
        <script src="assets/layouts/layout2/scripts/demo.min.js" type="text/javascript"></script>
        <script src="assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->

<%} catch (NullPointerException e) {
                System.out.println("NULL EXCEPTION");
                response.sendRedirect("login.jsp");
            } catch (Exception ex) {
                System.out.println("  EXCEPTION");

                response.sendRedirect("login.jsp");
            }%>
    </body></html>