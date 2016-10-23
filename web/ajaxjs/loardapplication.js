function loardsingleapplication(applicationid) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                if (ResponseText === "false") {
                    alert("Something wrong !");
                }


                document.getElementById("applicationArea").innerHTML = ResponseText;
            }
        };

        Object.open("POST", "search", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("state=" + true + "&type=appid&appid=" + applicationid);
    }
}


function loardapplicationByName(appname) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                if (ResponseText === "false") {
                    alert("Something wrong !");
                }

               
                document.getElementById("applicationArea").innerHTML = ResponseText;
            }
        };
     
        Object.open("POST", "searchbyname", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appname=" + appname);
    }
}
function addtocart(appid) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                if (ResponseText === "false") {
                    alert("Something wrong !");
                }
                alert(ResponseText);
                if (ResponseText == "true") {
                    removewishlist(appid);
                }
                location.reload();
            }
        };

        Object.open("POST", "addtocart", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appid=" + appid);
    }
}
function addtowishlist(appid) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                if (ResponseText === "false") {
                    alert("Something wrong !");
                }
                 
                location.reload();
            }
        };

        Object.open("POST", "addtowishlist", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appid=" + appid);
    }
}
function removecart(appid) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                
                if (ResponseText === "false") {
                    //$('#msgwindow').val(ResponseText);
                    $('.alert-danger').show(500);
                }

                if (ResponseText === "true") {
                    //$('#msgwindow').val("Success");
                    $('.alert-success').show(500);
                    //location.reload();
                    
                }
              location.reload(5000);
              
            }
        };

        Object.open("POST", "removecart", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appid=" + appid);
    }
}
function buyapp(appid) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                if (ResponseText === "false") {
                    alert("Something wrong !");
                }
                alert(ResponseText);
                if (ResponseText == "true") {
                    removecart(appid);
                    removewishlist(appid);
                }
                location.reload();
            }
        };
        
        Object.open("POST", "buyApp", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appid=" + appid);
    }
}
function removewishlist(appid) {
    var Object;
    if (window.XMLHttpRequest) {
        Object = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        Object = new ActiveXObject();
    } else {
        alert("Your Browser Doesn't Support AJAX Technology!");
    }
    if (Object !== null) {
        Object.onreadystatechange = function () {
            if (Object.readyState < 4) {
            } else if (Object.readyState === 4) {
                var ResponseText = Object.responseText;
                if (ResponseText === "false") {
                    alert("Something wrong !");
                }


               
                if (ResponseText === "true") {
                    location.reload();
                }
            }
        };

        Object.open("POST", "removewishlist", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appid=" + appid);
    }
}
