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
  document.getElementById("NewCountry").value="";
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
                 document.getElementById("newprovince").value="";
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
                 document.getElementById("newdistrict").value="";
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
           document.getElementById("newcity").value="";
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

function Countrysetselectedtoupdate(){
    
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
                    alert("Success!");
                    document.getElementById("SelectedCountry").value="";
                    loardcountry();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        if(document.getElementById("SelectedCountry").value===""){
            alert("Country Name Is Null!");
        }else{
        Object.open("POST", "../getaddressbyid", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");        
        Object.send("id=" +document.getElementById("Countrylist").value + "&text=" + document.getElementById("SelectedCountry").value + "&type=country");
        }
}}


function Provincesetselectedtoupdate(){
    
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
                    alert("Success!");
                    document.getElementById("SelectedProvince").value="";
                    loardcountry();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        if(document.getElementById("SelectedProvince").value===""){
            alert("Country Name Is Null!");
        }else{
        Object.open("POST", "../getaddressbyid", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");        
        Object.send("id=" +document.getElementById("provincelist").value + "&text=" + document.getElementById("SelectedProvince").value + "&type=province");
        }
}}

function Districtsetselectedtoupdate(){
    
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
                    alert("Success!");
                    document.getElementById("SelectedDistrict").value="";
                    loardcountry();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        if(document.getElementById("SelectedDistrict").value===""){
            alert("Country Name Is Null!");
        }else{
        Object.open("POST", "../getaddressbyid", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");        
        Object.send("id=" +document.getElementById("districtlist").value + "&text=" + document.getElementById("SelectedDistrict").value + "&type=district");
        }
}}
function Citysetselectedtoupdate(){
    
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
                    alert("Success!");
                    document.getElementById("SelectedCity").value="";
                    loardcountry();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        if(document.getElementById("SelectedCity").value===""){
            alert("Country Name Is Null!");
        }else{
        Object.open("POST", "../getaddressbyid", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");        
        Object.send("id=" +document.getElementById("citylist").value + "&text=" + document.getElementById("SelectedCity").value + "&type=city");
        }
}}
function activeordeactiveCountry(state,id) {
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
                    alert("Success!");
                    loardcountry();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        Object.open("POST", "../deactive", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        if(state===true){
            
        Object.send("countryid=" +id + "&state=" + true + "&type=country");
    }else if(state===false){
          
          Object.send("countryid=" + id+ "&state=" + false + "&type=country");
    }
    }
}

function activeordeactiveprovince(state,id) {
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
                    alert("Success!");
                    loardProvince();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        Object.open("POST", "../deactive", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        if(state===true){
           
        Object.send("provinceid=" +id + "&state=" + true + "&type=province");
    }else if(state===false){
         
          Object.send("provinceid=" +id + "&state=" + false + "&type=province");
    }
    }
}

function activeordeactivedistrict(state,id) {
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
                    alert("Success!");
                    loardDistrict();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        Object.open("POST", "../deactive", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        if(state===true){
           
        Object.send("districtid=" + id + "&state=" + true + "&type=district");
    }else if(state===false){
         
          Object.send("districtid=" + id+ "&state=" + false + "&type=district");
    }
    }
}

function activeordeactivecity(state,id) {
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
                    alert("Success!");
                    loardCity();
                }else{
                    alert(ResponseText);
                }
                
                 
            }
        };
        Object.open("POST", "../deactive", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        if(state===true){
            
        Object.send("cityid=" +id+ "&state=" + true + "&type=city");
    }else if(state===false){
         
          Object.send("cityid=" +id + "&state=" + false + "&type=city");
    }
    }
}
