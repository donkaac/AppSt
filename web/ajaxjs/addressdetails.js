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
            }
        };
        Object.open("POST", "../loard", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Object.send("state=" + true + "&type=country");
    }
}




function savecountry() {
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

                loardcountry();
            }
        };
       
        var newcountry = document.getElementById("NewCountry").value;
        if (document.getElementById("NewCountry").value === "") {
            alert("is null");
        } else {
            Object.open("POST", "../save", true);
            Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            Object.send("state=" + true + "&type=country&newcountry=" + newcountry);
        }
    }
}

function saveProvince(country) {
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
                loardProvince();
            }
        };
        
        var newprovince = document.getElementById("newprovince").value;
        if (document.getElementById("Countrylist").value === "" | document.getElementById("Countrylist").value === "Select Country") {
            alert("Select Country");
        } else {
            if (document.getElementById("newprovince").value === "") {
                alert("is null");
            } else {
                Object.open("POST", "../save", true);
                Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                Object.send("state=" + true + "&type=Province&country=" + country + "&province=" + newprovince);
            }
        }
    }

}

function saveDistrict(country, province) {
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
                    alert(document.getElementById("newdistrict").value + " " + ResponseText);
                }
                loardDistrict();
            }
        };
       
        var newdistrict = document.getElementById("newdistrict").value;
        if (document.getElementById("Countrylist").value === "" | document.getElementById("Countrylist").value === "Select Country") {
            alert("Select Country");
        } else {
            if (document.getElementById("provincelist").value === "" | document.getElementById("Countrylist").value === "Select Province") {
                alert("Select Province");
            } else {
                if (document.getElementById("newdistrict").value === "") {
                    alert("is null");
                } else {
                    Object.open("POST", "../save", true);
                    Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    Object.send("state=" + true + "&type=District&country=" + country + "&province=" + province + "&newdistrict=" + newdistrict);
                }
            }
        }
    }
}

function saveCity(country, province, distrcit) {
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
                    alert(document.getElementById("newcity").value + " " + ResponseText);
                }
                loardCity();
            }
        };
       
        var newcity = document.getElementById("newcity").value;
        if (document.getElementById("Countrylist").value === "" | document.getElementById("Countrylist").value === "Select Country") {
            alert("Select Country");
        } else {
            if (document.getElementById("newcity").value === "") {
                alert("is null");
            } else {
                Object.open("POST", "../save", true);
                Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                Object.send("state=" + true + "&type=City&country=" + country + "&province=" + province + "&district=" + distrcit + "&newcity=" + newcity);
            }
        }
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