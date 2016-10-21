function checksendingmail(){
    if((document.getElementById("reviever").value!=0)&(document.getElementById("hedder").value!=" ")&(document.getElementById("hedder").value!=null)&(document.getElementById("message").value!=null)&(document.getElementById("message").value!=" ")){
    return true;
}else{
        return false;
}
}
