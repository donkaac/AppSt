function checkpassword() {
    if (!(document.getElementById("pass1").value === "" | document.getElementById("pass2").value === "")) {
        if (document.getElementById("pass1").value === document.getElementById("pass2").value) {
            return true;
        } else {
            return false;
            alert("Match Password");
        }
    } else {
        return false;
    }
}
function checkprofiledata(){
   if (!(document.document.forms["updatecusdata"]["fname"].value === "" |document.document.forms["updatecusdata"]["mname"].value === "" | document.document.forms["updatecusdata"]["lname"].value === ""| document.document.forms["updatecusdata"]["citylist"].value === ""| document.document.forms["updatecusdata"]["address"].value === "")) {
        alert(true);
        return true;
        
   }else{
        alert(false);
        return false;
        
   }
}