/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Datacontroller.HibernateUtil;
import Entities.Application;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ish
 */
public class NewClass1 {
    public static void main(String[] args) { 
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY,MM,dd");
        String tdate = simpleDateFormat.format(date);
        System.out.println(tdate);
        String base64encode = Datacontroller.EncryptUtils.base64encode(Datacontroller.EncryptUtils.base64encode(Datacontroller.EncryptUtils.base64encode("123developer♦1♦"+tdate)));
        String base64dencode = Datacontroller.EncryptUtils.base64decode(Datacontroller.EncryptUtils.base64decode(Datacontroller.EncryptUtils.base64decode("VFhWTFduQnJNVlZUV0hKcGJXRmFXRnBYVVdkVWJUa3lTVVJCZVVsRVJYaFBha0Y1VDJwVk0wbEZiRlJXUTBGNVRVUkZNalJ3YlcxWg0KTTFaNlpFYzVkRnBZU1QwPQ==")));
        System.out.println( base64encode+ "  \n "+base64dencode);
        String[] split = base64dencode.split("♦");
        for (String string : split) {
            System.out.println("○"+string);
        }
       
    }
}
