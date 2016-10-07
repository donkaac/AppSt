/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loardcountry() {
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
                 
                 
                document.getElementById("Countrylist").innerHTML = ResponseText;
                 document.getElementById("provincelist").innerHTML = "";
                 document.getElementById("citylist").innerHTML = "";
                 document.getElementById("districtlist").innerHTML = "";
            }
        };
        Object.open("POST", "../loard", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("state=" + true + "&type=country");
    }
}





function loardProvince() {
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
                 
                document.getElementById("provincelist").innerHTML = ResponseText;
                 document.getElementById("citylist").innerHTML = "";
                 document.getElementById("districtlist").innerHTML = "";
            }
        };
        Object.open("POST", "../loard", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("country=" + document.getElementById("Countrylist").value + "&state=" + true + "&type=Province");
    }
}

function loardDistrict() {
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
              
                
                document.getElementById("districtlist").innerHTML = ResponseText;
                 document.getElementById("citylist").innerHTML = "";
            }
        };
        Object.open("POST", "../loard", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("country=" + document.getElementById("Countrylist").value + "&province=" + document.getElementById("provincelist").value + "&state=" + true + "&type=district");
    }
}


function loardCity() {
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
              
                
                document.getElementById("citylist").innerHTML = ResponseText;
            }
        };
        Object.open("POST", "../loard", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("country=" + document.getElementById("Countrylist").value + "&province=" + document.getElementById("provincelist").value + "&district=" + document.getElementById("districtlist").value + "&state=" + true + "&type=city");
    }
}