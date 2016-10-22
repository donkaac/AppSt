/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Datacontroller.HibernateUtil;
import Entities.Application;
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
            Session session = HibernateUtil.getSessionFactory().openSession();
                Criteria cr = session.createCriteria(Application.class);
String s="k";
                
                Criterion stcr = Restrictions.eq("state", true);
                Criterion namecr = Restrictions.ilike("applicationName", s+"%");
               
                cr.add(stcr);
                cr.add(namecr);
                List list = cr.list();
                for (Object object : list) {
            Application app=(Application) object;
                    System.out.println("APP NAME ????"+app.getApplicationName());
        }
    }
}
