<%-- 
    Document   : profile
    Created on : Sep 16, 2016, 4:23:18 PM
    Author     : Ish
--%>

<%@page import="Entities.Customerhasapplication"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> Profile</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="One Movies Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/contactstyle.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/faqstyle.css" type="text/css" media="all" />
        <link href="css/single.css" rel='stylesheet' type='text/css' />
        <link href="css/medile.css" rel='stylesheet' type='text/css' />
        <!-- banner-slider -->
        <link href="css/jquery.slidey.min.css" rel="stylesheet">
        <!-- //banner-slider -->
        <!-- pop-up -->
        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //pop-up -->
        <!-- font-awesome icons -->
        <link rel="stylesheet" href="css/font-awesome.min.css" />
        <!-- //font-awesome icons -->
        <!-- js -->
         <script src="../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="ajaxjs/customeraddressdetails.js"></script>
             
        <!-- //js -->
        <!-- banner-bottom-plugin -->
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
        <script src="js/owl.carousel.js"></script>
        <script>
            $(document).ready(function () {
                $("#owl-demo").owlCarousel({
                    autoPlay: 3000, //Set AutoPlay to 3 seconds

                    items: 5,
                    itemsDesktop: [640, 4],
                    itemsDesktopSmall: [414, 3]

                });

            });
        </script> 
        <!-- //banner-bottom-plugin -->
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!-- start-smoth-scrolling -->
    </head>

    <body onload="loardcountry()">
        <!-- header -->
        <div class="header">
            <div class="container">
                <div class="w3layouts_logo">
                    <a href="index.jsp"><h1>Apps<span>Store</span></h1></a>
                </div>
                <div class="w3_search">
                    <form action="#" method="post">
                        <input type="text" name="Search" placeholder="Search" required="">
                        <input type="submit" value="Go">
                    </form>
                </div>
                <div class="w3l_sign_in_register">
                    <ul>
                        <%if (true) {%>
                        <li>
                            <div>
                                <h3><span class="glyphicon glyphicon-shopping-cart"></span></h3>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3><span class="glyphicon glyphicon-list"></span></h3>
                            </div>
                        </li>
                        <li class="dropdown profile_details_drop">
                            <span href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <div class="profile_img">	
                                    <span class="prfil-img"><img width="50px" height="50px" src="images/user.jpg" alt=""> </span> 
                                    <div class="clearfix"></div>	
                                </div>	
                            </span>
                            <ul class="dropdown-menu drp-mnu">

                                <li> <a href="profile.php"><i class="fa fa-user"></i> Profile</a> </li> 
                                <li> <a href="logout.php"><i class="fa fa-sign-out"></i> Logout</a> </li>
                            </ul>

                        </li>


                        <%} else {%>

                        
                            <%}%>

                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //header -->
      
        <script>
            $('.toggle').click(function () {
                // Switches the Icon
                $(this).children('i').toggleClass('fa-pencil');
                // Switches the forms  
                $('.form').animate({
                    height: "toggle",
                    'padding-top': 'toggle',
                    'padding-bottom': 'toggle',
                    opacity: "toggle"
                }, "slow");
            });
        </script>
        <!-- //bootstrap-pop-up -->
        <!-- nav -->
        <div class="movies_nav">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="navbar-header navbar-left">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                        <nav>
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="index.html">Home</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Genres <b class="caret"></b></a>
                                    <ul class="dropdown-menu multi-column columns-3">
                                        <li>
                                            <div class="col-sm-4">
                                                <ul class="multi-column-dropdown">
                                                    <li><a href="genres.html">Action</a></li>
                                                    <li><a href="genres.html">Biography</a></li>
                                                    <li><a href="genres.html">Crime</a></li>
                                                    <li><a href="genres.html">Family</a></li>
                                                    <li><a href="horror.html">Horror</a></li>
                                                    <li><a href="genres.html">Romance</a></li>
                                                    <li><a href="genres.html">Sports</a></li>
                                                    <li><a href="genres.html">War</a></li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <ul class="multi-column-dropdown">
                                                    <li><a href="genres.html">Adventure</a></li>
                                                    <li><a href="comedy.html">Comedy</a></li>
                                                    <li><a href="genres.html">Documentary</a></li>
                                                    <li><a href="genres.html">Fantasy</a></li>
                                                    <li><a href="genres.html">Thriller</a></li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <ul class="multi-column-dropdown">
                                                    <li><a href="genres.html">Animation</a></li>
                                                    <li><a href="genres.html">Costume</a></li>
                                                    <li><a href="genres.html">Drama</a></li>
                                                    <li><a href="genres.html">History</a></li>
                                                    <li><a href="genres.html">Musical</a></li>
                                                    <li><a href="genres.html">Psychological</a></li>
                                                </ul>
                                            </div>
                                            <div class="clearfix"></div>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="series.html">tv - series</a></li>
                                <li><a href="news.html">news</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Country <b class="caret"></b></a>
                                    <ul class="dropdown-menu multi-column columns-3">
                                        <li>
                                            <div class="col-sm-4">
                                                <ul class="multi-column-dropdown">
                                                    <li><a href="genres.html">Asia</a></li>
                                                    <li><a href="genres.html">France</a></li>
                                                    <li><a href="genres.html">Taiwan</a></li>
                                                    <li><a href="genres.html">United States</a></li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <ul class="multi-column-dropdown">
                                                    <li><a href="genres.html">China</a></li>
                                                    <li><a href="genres.html">HongCong</a></li>
                                                    <li><a href="genres.html">Japan</a></li>
                                                    <li><a href="genres.html">Thailand</a></li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <ul class="multi-column-dropdown">
                                                    <li><a href="genres.html">Euro</a></li>
                                                    <li><a href="genres.html">India</a></li>
                                                    <li><a href="genres.html">Korea</a></li>
                                                    <li><a href="genres.html">United Kingdom</a></li>
                                                </ul>
                                            </div>
                                            <div class="clearfix"></div>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="short-codes.html">Short Codes</a></li>
                                <li><a href="list.html">A - z list</a></li>
                            </ul>
                        </nav>
                    </div>
                </nav>	
            </div>
        </div>
        <!-- //nav -->
        <!-- banner -->
        <div id="slidey" style="display:none;">
            <ul>
                <li><img src="images/5.jpg" alt=" "><p class='title'>Tarzan</p><p class='description'> Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment.</p></li>
                <li><img src="images/2.jpg" alt=" "><p class='title'>Maximum Ride</p><p class='description'>Six children, genetically cross-bred with avian DNA, take flight around the country to discover their origins. Along the way, their mysterious past is ...</p></li>
                <li><img src="images/3.jpg" alt=" "><p class='title'>Independence</p><p class='description'>The fate of humanity hangs in the balance as the U.S. President and citizens decide if these aliens are to be trusted ...or feared.</p></li>
                <li><img src="images/4.jpg" alt=" "><p class='title'>Central Intelligence</p><p class='description'>Bullied as a teen for being overweight, Bob Stone (Dwayne Johnson) shows up to his high school reunion looking fit and muscular. Claiming to be on a top-secret ...</p></li>
                <li><img src="images/6.jpg" alt=" "><p class='title'>Ice Age</p><p class='description'>In the film's epilogue, Scrat keeps struggling to control the alien ship until it crashes on Mars, destroying all life on the planet.</p></li>
                <li><img src="images/7.jpg" alt=" "><p class='title'>X - Man</p><p class='description'>In 1977, paranormal investigators Ed (Patrick Wilson) and Lorraine Warren come out of a self-imposed sabbatical to travel to Enfield, a borough in north ...</p></li>
            </ul>   	
        </div>
        <script src="js/jquery.slidey.js"></script>
        <script src="js/jquery.dotdotdot.min.js"></script>
        <script type="text/javascript">
            $("#slidey").slidey({
                interval: 8000,
                listCount: 5,
                autoplay: false,
                showList: true
            });
            $(".slidey-list-description").dotdotdot();
        </script>
        <!-- //banner -->
        <!-- banner-bottom -->

        <!-- //banner-bottom -->
         

        <!-- general -->
        <div class="general">
            <h4 class="latest-text w3_latest_text">Profile Data</h4>
            <div class="container">
                <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                    <ul id="myTab" class="nav nav-tabs" role="tablist">
                         </ul>
                    <div id="myTabContent" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
                             <div class="scroller" style="height: 525px;" data-always-visible="1" data-rail-visible1="1">
                            <div class="portlet-body">
                                    <!-- BEGIN FORM-->
                                    <form action="../savedeveloper"  method="POST"  class="form-horizontal">
                                        <div class="form-body">
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">First Name</label>
                                                <div class="col-md-9">
                                                    <input type="text" id="fname" name="fname" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                     
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Middle Name</label>
                                                <div class="col-md-9">
                                                    <input type="text" id="maname" name="mname" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Last Name</label>
                                                <div class="col-md-9">
                                                    <input type="text" name="lname" id="lname" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    
                                                </div>
                                            </div>
                                         
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Email</label>
                                                <div class="col-md-9">
                                                    <div class="input-group">
                                                        <input type="email" id="email" name="email" class="form-control" placeholder="Email Address">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-envelope"></i>
                                                        </span>
                                                        <div class="form-control-focus"> </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                             <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Password</label>
                                                <div class="col-md-9">
                                                    <input type="password" name="pass1" id="pass1" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                    
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Retype Password</label>
                                                <div class="col-md-9">
                                                    <input type="password" name="pass2" id="pass2" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                     
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Country</label>
                                                <div class="col-md-9">
                                                    <select class="form-control" id="Countrylist" ondblclick="loardcountry()" onchange="loardProvince()" name="Countrylist">
                                                         
                                                    </select>
                                                    <div class="form-control-focus"> </div>
                                                    
                                                </div>
                                            </div>
                                             <div class="form-group form-md-line-input">
                                                 <label class="col-md-3 control-label"   for="form_control_1">Province</label>
                                                <div class="col-md-9">
                                                    <select class="form-control" id="provincelist" onchange="loardDistrict()" name="provincelist">
                                                        
                                                    </select>
                                                    <div class="form-control-focus"> </div>
                                                    
                                                </div>
                                            </div>
                                             <div class="form-group form-md-line-input">
                                                 <label class="col-md-3 control-label"   for="form_control_1">District</label>
                                                <div class="col-md-9">
                                                    <select class="form-control" id="districtlist" onchange="loardCity()" name="districtlist">
                                                        
                                                    </select>
                                                    <div class="form-control-focus"> </div>
                                                     
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label"  for="form_control_1">City</label>
                                                <div class="col-md-9">
                                                    <select class="form-control" id="citylist" name="citylist">
                                                        
                                                    </select>
                                                    <div class="form-control-focus"> </div>
                                                    
                                                </div>
                                            </div>
                                               <div class="form-group form-md-line-input">
                                                <label class="col-md-3 control-label" for="form_control_1">Address</label>
                                                <div class="col-md-9">
                                                    <input type="text" name="address" id="address" class="form-control" placeholder="">
                                                    <div class="form-control-focus"> </div>
                                                 
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="form-group form-md-radios  ">
                                                <label class="col-md-3 control-label" for="form_control_1">Select Gender</label>
                                                <div class="col-md-9">
                                                    <div class="md-radio-inline">
                                                        <div class="md-radio">
                                                            <input type="radio" id="checkbox1_8" checked="" name="gender" value="male" class="md-radiobtn">
                                                            <label for="checkbox1_8">
                                                                <span class="inc"></span>
                                                                <span class="check"></span>
                                                                <span class="box"></span> Male</label>
                                                        </div>
                                                        <div class="md-radio">
                                                            <input type="radio" id="checkbox1_9" name="gender" value="female" class="md-radiobtn">
                                                            <label for="checkbox1_9">
                                                                <span class="inc"></span>
                                                                <span class="check"></span>
                                                                <span class="box"></span> Female </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-actions">
                                            <div class="row">
                                                <div class="col-md-offset-3 col-md-9">
                                                    <input type="submit"  class="btn green"/>
                                                    <a href="" class="btn default">Cancel</a>
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
        <!-- //general -->
       
        <!-- flexSlider -->
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
        <script defer src="js/jquery.flexslider.js"></script>
        <script type="text/javascript">
    $(window).load(function () {
        $('.flexslider').flexslider({
            animation: "slide",
            start: function (slider) {
                $('body').removeClass('loading');
            }
        });
    });
        </script>
        <!-- //flexSlider -->
    </div>
</div>
<!-- pop-up-box -->  
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box -->
<div id="small-dialog" class="mfp-hide">
    <iframe src="https://player.vimeo.com/video/164819130?title=0&byline=0"></iframe>
</div>
<div id="small-dialog1" class="mfp-hide">
    <iframe src="https://player.vimeo.com/video/148284736"></iframe>
</div>
<div id="small-dialog2" class="mfp-hide">
    <iframe src="https://player.vimeo.com/video/165197924?color=ffffff&title=0&byline=0&portrait=0"></iframe>
</div>
<script>
    $(document).ready(function () {
        $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>
 
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $(".dropdown").hover(
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                    $(this).toggleClass('open');
                },
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                    $(this).toggleClass('open');
                }
        );
    });
</script>
<!-- //Bootstrap Core JavaScript -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear' 
         };
         */

        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<!-- //here ends scrolling icon -->
</body>
</html>
