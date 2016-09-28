<%-- 
    Document   : test
    Created on : Sep 25, 2016, 8:27:26 PM
    Author     : Ish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">

            function ABCD() {

                var input = document.forms['file_upload']['image_file'];

                if (input.files[0].size > 600000) {

                    document.getElementById('msg').innerHTML = "File Size Too Large..";
                    document.getElementById('msg').style.color = "RED";
                    return false;

                } else {

                    return true;

                }

            }

        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form onsubmit="return ABCD()" name="file_upload" action="test" enctype="multipart/form-data" method="POST">

            <table>

                <tr>

                    <td>Image Title</td>
                    <td><input type="text" name="image_title"></td>
                    <td><input type="text" name="fn"></td>

                </tr>

                <tr>

                    <td>Select File</td>
                    <td><input type="file" name="image_file"></td>
                    <td><input type="file" name="image_file"></td>
                    <td><input type="file" name="image_file"></td>
                    <td><input type="file" name="image_file"></td>

                </tr>

                <tr>

                    <td>&nbsp;</td>
                    <td><input type="submit" value="Upload"></td>

                </tr>

                <tr>

                    <td>&nbsp;</td>
                    <td id="msg"></td>

                </tr>

            </table>

        </form>

        <style>
            
            body{ margin-top:20px;}
.glyphicon { margin-right:5px;}
.rating .glyphicon {font-size: 22px;}
.rating-num { margin-top:0px;font-size: 54px; }
.progress { margin-bottom: 5px;}
.progress-bar { text-align: left; }
.rating-desc .col-md-3 {padding-right: 0px;}
.sr-only { margin-left: 5px;overflow: visible;clip: auto; }
        </style>
        
   <div class="col-xs-12 col-md-6 text-center">
                        <h1 class="rating-num">
                            4.0</h1>
                        <div class="rating">
                            <span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star">
                            </span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star">
                            </span><span class="glyphicon glyphicon-star-empty"></span>
                        </div>
                        <div>
                            <span class="glyphicon glyphicon-user"></span>1,050,008 total
                        </div>
                    </div>
        
    </body>
</html>
