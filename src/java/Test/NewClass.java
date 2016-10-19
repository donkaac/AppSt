/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Datacontroller.DataParser;
import Entities.Application;
import Entities.Developer;
import java.util.Set;

/**
 *
 * @author Ish
 */
public class NewClass {
    public static void main(String[] args) {
     
                            
        String base64decode = Datacontroller.EncryptUtils.base64encode("hhjk");
        System.out.println(base64decode);
        try {
          
             
            Developer uniqeresault = (Developer) DataParser.getuniqeresault(new Developer(), 6);
            Set<Application> applications = uniqeresault.getApplications();
            for (Application application : applications) {
                System.out.println(""+application.getApplicationName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
