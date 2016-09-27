/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loardAppplatform() {
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
                 
                 
                document.getElementById("Appplatformlist").innerHTML = ResponseText;
            }
        };
        Object.open("POST", "loardcat", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("state=" + true + "&type=Appplatform");
    }
}



function loardApptype() {
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
                 
                document.getElementById("apptypelist").innerHTML = ResponseText;
            }
        };
         
        Object.open("POST", "loardcat", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("Appplatform=" + document.getElementById("Appplatformlist").value + "&state=" + true + "&type=apptype");
    }
}

function loardAppplatcategory() {
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
              
                
                document.getElementById("appcategorylist").innerHTML = ResponseText;
            }
        };
        Object.open("POST", "loardcat", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("Appplatform=" + document.getElementById("Appplatformlist").value + "&apptype=" + document.getElementById("apptypelist").value + "&state=" + true + "&type=appcategory");
    }
}

 