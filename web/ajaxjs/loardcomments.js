function loardcomment(appid){
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

        Object.open("POST", "../loardcomment", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      Object.send("state=" + true + "&appid=" + appid);
    }  
  }
   function loardpurchase(appid){
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
       
        Object.open("POST", "../loardpurchase", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      Object.send("state=" + false + "&appid=" + appid);
    }  
  } 
   function removecomment(commentid){
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
                }else if(ResponseText==="true"){
                   loardcomment(document.getElementById('selectapplist').value);
                }

                
                
            }
        };

        Object.open("POST", "../removecomment", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      Object.send("state=" + true + "&commentid=" + commentid);
    }  
  } 

  
   function addcommentreply(commentid){
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
                }else if(ResponseText==="true"){
                   loardcomment(document.getElementById('selectapplist').value);
                }else{

                alert(ResponseText);
            }
            }
        };
         var commettext=  document.getElementById(""+commentid).value;
        if((commettext == null || commettext == "")){
            
        }else{
        Object.open("POST", "../addcommentreply", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      Object.send("&commentid=" + commentid+"&text="+commettext);
        } 
    }  
  } 

 function removecommentreply(commentreplyid){
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
                }else if(ResponseText==="true"){
                   loardcomment(document.getElementById('selectapplist').value);
                }else{

                alert(ResponseText);
            }
            }
        };

        Object.open("POST", "../removecommentreply", true);
        Object.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      Object.send("&commentreplyid=" + commentreplyid);
    }  
  } 