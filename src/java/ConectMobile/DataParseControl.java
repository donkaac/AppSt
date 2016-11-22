/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConectMobile;

import java.util.HashMap;

/**
 *
 * @author Ish
 */
public class DataParseControl {
DataParseControl dataparser;
    private DataParseControl Dataparser() {
        if(dataparser.equals(null)){
            dataparser=new DataParseControl();
        }
        return dataparser;
    }
   
public static HashMap getDataFromServer(HashMap hm){
     String type =hm.get("connectiontype").toString();
     System.out.println("SSSSSSSSS ::"+type );
HashMap returnHashMap=new HashMap();
if(  "login".equals(type)){
    if((hm.get("email").toString().equals("ishu.nimantha@gmail.com"))&hm.get("password").toString().equals("12345qwe")){
    System.out.println(hm.get("email")+"  "+hm.get("password"));
    returnHashMap.put("login", "ok");
    }else{
         returnHashMap.put("login", "no");
    }
}

 
    return returnHashMap;
   }    
 
}
