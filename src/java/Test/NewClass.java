/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Datacontroller.DataParser;
import Entities.Application;
import Entities.Appplatform;
import Entities.Apptype;
import Entities.Category;
import Entities.Country;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Ish
 */
public class NewClass {
    public static void main(String[] args) {
        ArrayList<Object> apps= Datacontroller.DataParser.Searchdata(new Appplatform());
                            for (Object o : apps) {
            Appplatform app=(Appplatform) o;
            app.getAppplatform();
            
            Set<Apptype> apptypes = app.getApptypes();
                                for (Apptype apptype : apptypes) {
                                    apptype.getApptype();
                                    
                Set<Category> categories = apptype.getCategories();
                                    for (Category category : categories) {
                                        category.getCategory();
                                        Set<Application> applications = category.getApplications();
                                        for (Application application : applications) {
                                            application.getApplicationName();
                                        }
                                                
                                    }
                                }
        }
    }
}
