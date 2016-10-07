$('document').ready(function ()
{
    alert("as");
    $('.alert-danger',$('.form-signin')).hide();
    $('.alert-warning',$('.form-signin')).hide();
    $('.alert-success',$('.form-signin')).hide();
    /* validation */
    $("#form-horizontal").validate({
        rules:
                {
                    fname: {required: true},
                    maname: {required: true},
                    laname: {required: true},
                    citylist: {required: true},
                    email: {
                        required: true,
                        email: true
                    }
                },
        messages:
                {
                    pass1: {required: "Please enter your password"},
                    pass2: {required: "Please Retype your password"},
                    email:{
                        pass1: "Please enter your email address"
                    }            
                },
        submitHandler: submitForm
    });
    /* validation */

    /* login submit */
    function submitForm()
    {
        var data = $("#form-horizontal").serialize();

        $.ajax({
            type: 'POST',
            url: 'savestaff',
            data: data,
            beforeSend: function ()
            {
                $("#error").fadeOut();
                $("#btn green").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
            },
            success: function (response)
            {
                if (response == "ok") {
                    $('.alert-danger',$('.form-signin')).hide();
                    $('.alert-warning',$('.form-signin')).hide();
                    $('.alert-success',$('.form-signin')).show(500);
                  // $("#btn green").html('<img src="css/btn-ajax-loader.gif" /> &nbsp; Signing In ...');
                    setTimeout(' window.location.href = "index.jsp"; ', 4000);

                } else {

                    $("#error").fadeIn(1000, function () {
                        //$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; ' + response + ' !</div>');
                    $('.alert-warning',$('.form-signin')).show(500);
                        $("#btn green").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
                    });
                }
            }
        });
        
        setTimeout(function() {
        $('.alert-danger',$('.form-signin')).hide(1000);
        $('.alert-warning',$('.form-signin')).hide(1000);
        $('.alert-success',$('.form-signin')).hide(1000);
    }, 5000);

      return true;
    }
});