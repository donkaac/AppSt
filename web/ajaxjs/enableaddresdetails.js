

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
                    location.reload();
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
                   location.reload();
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
                    location.reload();
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
                   location.reload();
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