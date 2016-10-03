/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oparation;

/**
 *
 * @author Ish
 */
public class EmailValidationCodeGenaration {
    public static void main(String[] args) {
        while(true){
        System.out.println(EmailValidationCode());
        }
    }
    
public static String EmailValidationCode(){
      String i="";
    try {
        i=""+Math.toRadians(Math.random()+9999*Math.random()*Math.round(92.65565));
         i = Datacontroller.EncryptUtils.base64encode(i);
          
    } catch (Exception e) {
    }
  

return i;
}
}