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
        Object.open("POST", "../loardcat", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("state=" + true + "&type=Appplatform");
    }
}




function SaveAppplatform() {
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
                if (ResponseText === "Allredy Exist!") {
                    alert(document.getElementById("NewCountry").value + " " + ResponseText);
                }

                loardAppplatform();
            }
        };
       
        var newcountry = document.getElementById("NewAppplatform").value;
        if (document.getElementById("NewAppplatform").value === "") {
            alert("is null");
        } else {
            Object.open("POST", "../savecat", true);
            Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            Object.send("state=" + true + "&type=platform&newplatform=" + newcountry);
        }
    }
}

function saveAptype() {
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
                if (ResponseText === "Allredy Exist!") {
                    alert(document.getElementById("newprovince").value + " " + ResponseText);
                }
                loardApptype();
            }
        };
        
        var apptype = document.getElementById("newapptype").value;
        var appplatform = document.getElementById("Appplatformlist").value;
        if (document.getElementById("Appplatformlist").value === "" | document.getElementById("Appplatformlist").value === "Select Country") {
            alert("Select App Platform");
        } else {
            if (document.getElementById("newapptype").value === "") {
                alert("is null");
            } else {
                Object.open("POST", "../savecat", true);
                Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                Object.send("state=" + true + "&type=apptype&appplatform=" + appplatform + "&newapptype=" + apptype);
            }
        }
    }

}
 

function saveAppplatcategory() {
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
                if (ResponseText === "Allredy Exist!") {
                    alert(document.getElementById("newcategory").value + " " + ResponseText);
                }
                loardApptype();
            }
        };
       var appplatform = document.getElementById("Appplatformlist").value;
        var newcity = document.getElementById("newcategory").value;
        if (document.getElementById("apptypelist").value === "" | document.getElementById("apptypelist").value === "Select Country") {
            alert("Select Country");
        } else {
            if (document.getElementById("newcategory").value === "") {
                alert("is null");
            } else {
                Object.open("POST", "../savecat", true);
                Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                Object.send("state=" + true + "&type=category&appplatform=" + appplatform + "&apptype=" + document.getElementById("apptypelist").value + "&newcategory=" + document.getElementById("newcategory").value);
            }
        }
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
         
        Object.open("POST", "../loardcat", true);
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
        Object.open("POST", "../loardcat", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("Appplatform=" + document.getElementById("Appplatformlist").value + "&apptype=" + document.getElementById("apptypelist").value + "&state=" + true + "&type=appcategory");
    }
}

 