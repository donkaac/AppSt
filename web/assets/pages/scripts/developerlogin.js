/* global Pace */

var Login = function () {
    var e = function () {
        $(".login-form").validate({
            errorElement: "span",
            errorClass: "help-block",
            focusInvalid: !1,
            rules: {
                username: {
                    required: !0,
                    email: !0
                    
                },
                password: {
                    required: !0
                },
                remember: {
                    required: !1
                }
            },
            messages: {
                username: {
                    required: "Username is required."
                },
                password: {
                    required: "Password is required."
                }
            }, invalidHandler: function (e, r) {
                $(".alert-danger", $(".login-form")).show(500);
            }, highlight: function (e) {
                $(e).closest(".form-group").addClass("has-error");
            }, success: function (e) {
                e.closest(".form-group").removeClass("has-error"), e.remove();
            }, errorPlacement: function (e, r) {
                e.insertAfter(r.closest(".input-icon"));
            }, submitHandler: function (e) {

                var data = $(".login-form").serialize();

                Pace.track(function () {
                    $.ajax({
                        type: 'POST',
                        url: '../developerlogin',
                        data: data,
                        beforeSend: function ()
                        {

                            $("#error").fadeOut();
                            $("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
                        },
                        success: function (response)
                        { 
                            
                            if (response == "ok") {
                                $("#btn-login").html('<img src="css/btn-ajax-loader.gif" /> &nbsp; Signing In ...');
                                $('.alert-success', $('.login-form')).show(500);
                                setTimeout(' window.location.href = "dashboard.jsp"; ', 4000);

                            } else if (response == "error") {
                                $('.alert-warning', $('.login-form')).show(500);
                            } else {
                                window.location.href = "error/system_500.jsp";
                            }
                        }
                    });
                });
                
                
                e.submit();
            }}), $(".login-form input").keypress(function (e) {
            return 13 == e.which ? ($(".login-form").validate().form() && $(".login-form").submit(), !1) : void 0;
        });
    };


    r = function () {
        $(".forget-form").validate({
            errorElement: "span",
            errorClass: "help-block",
            focusInvalid: !1,
            ignore: "",
            rules: {
                email: {
                    required: !0,
                    email: !0
                }
            },
            messages: {
                email: {
                    required: "Email is required."
                }
            }, invalidHandler: function (e, r) {},
            highlight: function (e) {
                $(e).closest(".form-group").addClass("has-error");
            }, success: function (e) {
                e.closest(".form-group").removeClass("has-error"), e.remove();
            }, errorPlacement: function (e, r) {
                e.insertAfter(r.closest(".input-icon"));
            }, submitHandler: function (e) {
                var data = $(".forget-form").serialize();

                Pace.track(function () {
                    $.ajax({
                        type: 'POST',
                        url: '../developerfrogetpassword',
                        data: data,
                        beforeSend: function ()
                        {

                            $("#error").fadeOut();

                        },
                        success: function (response)
                        {
                            
                            if (response == "ok") {

                                $('.alert-success', $('.forget-form')).show(500);
                                setTimeout(' window.location.href = "login.jsp"; ', 4000);

                            } else if (response == "error") {
                                alert("Check Email");
                                $('.alert-warning', $('.forget-form')).show(500);
                            } else {
                                window.location.href = "error/system_500.jsp";
                            }
                        }
                    });
                });


                e.submit();
            }}), $(".forget-form input").keypress(function (e) {
            return 13 == e.which ? ($(".forget-form").validate().form() && $(".forget-form").submit(), !1) : void 0;
        }), jQuery("#forget-password").click(function () {
            jQuery(".login-form").hide(), jQuery(".forget-form").show();
        }), jQuery("#back-btn").click(function () {
            jQuery(".login-form").show(), jQuery(".forget-form").hide();
        });
    };


    s = function () {
        function e(e) {
            if (!e.id)
                return e.text;
            var r = $('<span><img src="../assets/global/img/flags/' + e.element.value.toLowerCase() + '.png" class="img-flag" /> ' + e.text + "</span>");
            return r;
        }
        jQuery().select2 && $("#country_list").size() > 0 && ($("#country_list").select2({
            placeholder: '<i class="fa fa-map-marker"></i>&nbsp;Select a Country',
            templateResult: e,
            templateSelection: e,
            width: "auto",
            escapeMarkup: function (e) {
                return e;
            }}), $("#country_list").change(function () {
            $(".register-form").validate().element($(this));
        })),
                $(".register-form").validate({
            errorElement: "span",
            errorClass: "help-block",
            focusInvalid: !1,
            ignore: "",
            rules: {
                fname: {
                    required: !0
                },
                mname: {
                    required: !0
                }, lname: {
                    required: !0
                }, mobile: {
                    required: !0
                }, gender: {
                    required: !0
                },
                email: {
                    required: !0,
                    email: !0
                },
                address: {
                    required: !0
                },
                city: {
                    required: !0
                },
                country: {
                    required: !0
                }, district: {
                    required: !0
                }, province: {
                    required: !0
                },
                password: {
                    required: !0
                },
                rpassword: {
                    equalTo: "#register_password"
                },
                tnc: {required: !0
                }
            }, messages: {
                tnc: {
                    required: "Please accept TNC first."
                }, email: {
                    required: "Please Enter Email"
                }, city: {
                    required: "Please Select city"
                }, address: {
                    required: "Please Enter Address"
                }, district: {
                    required: "Please Select District"
                }, province: {
                    required: "Please Select Provice"
                }, mobile: {
                    required: "Please Enter Mobile NO "
                }
            }, invalidHandler: function (e, r) {}, highlight: function (e) {
                $(e).closest(".form-group").addClass("has-error");
            }, success: function (e) {
                e.closest(".form-group").removeClass("has-error"), e.remove();
            }, errorPlacement: function (e, r) {
                "tnc" == r.attr("name") ? e.insertAfter($("#register_tnc_error")) : 1 === r.closest(".input-icon").size() ? e.insertAfter(r.closest(".input-icon")) : e.insertAfter(r);
            }, submitHandler: function (e) {
                var data = $(".register-form").serialize();

                Pace.track(function () {
                    $.ajax({
                        type: 'POST',
                        url: 'savedeveloper',
                        data: data,
                        beforeSend: function ()
                        {

                            $("#error").fadeOut();

                        },
                        success: function (response)
                        {
                            alert("sending");
                            if (response == "true") {

                                $('.alert-success', $('.register-form')).show(500);
                                setTimeout(' window.location.href = "login.jsp"; ', 4000);

                            } else if (response == "false") {
                                $('.alert-warning', $('.register-form')).show(500);
                            } else if (response == "emailexist") {
                                $('.alert-warning', $('.register-form')).show(500);
                            }else {
                                window.location.href = "error/system_500.jsp";
                            }
                        }
                    });
                });

                e.submit();
            }}), $(".register-form input").keypress(function (e) {
            return 13 == e.which ? ($(".register-form").validate().form() && $(".register-form").submit(), !1) : void 0;
        }), jQuery("#register-btn").click(function () {
            jQuery(".login-form").hide(), jQuery(".register-form").show();
        }), jQuery("#register-back-btn").click(function () {
            jQuery(".login-form").show(), jQuery(".register-form").hide();
        });
    };


    return{
        init: function () {
            e(), r(), s(), $.backstretch([
                "./assets/pages/media/bg/1.jpg",
                "./assets/pages/media/bg/2.jpg",
                "./assets/pages/media/bg/3.jpg",
                "./assets/pages/media/bg/4.jpg"],
                    {
                        fade: 1e3,
                        duration: 8e3
                    });
        }};
}();
jQuery(document).ready(function () {
    Login.init();
});