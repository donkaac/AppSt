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

        Object.open("POST", "../search", true);
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
     
        Object.open("POST", "../searchappbynameonfolder", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("appname=" + appname);
    }
}
 
  
