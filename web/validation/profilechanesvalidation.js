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
   if (!(document.getElementById("fname").value === "" |document.getElementById("address").value === "" | document.getElementById("citylist").value === ""| document.getElementById("citylist").value === ""| document.getElementById("citylist").value === ""| document.getElementById("lname").value === ""| document.getElementById("maname").value === "")) {
        alert(true);
        return true;
        
   }else{
        alert(false);
        return false;
        
   }
}