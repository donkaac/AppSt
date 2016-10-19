function loardcomment(appid){
  var object;
  if(window.XMLHttpRequest){
      object=new XMLHttpRequest();
  }else if(window.ActiveXObject){
      object=new ActiveXObject();
  }else{
        alert("This Browser Not Support Ajax!");
  }
    
  if(object!=null){
      object.onreadystatechange=function (){
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
    
    


