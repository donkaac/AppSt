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
        System.out.println(EmailValidationCode());
    }
    
public static String EmailValidationCode(){
    
  String i=""+(Math.random()*99999);
  
   

return i;
}
}