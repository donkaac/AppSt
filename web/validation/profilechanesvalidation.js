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
    
}