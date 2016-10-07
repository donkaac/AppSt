/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Logic;

import Entities.Customer;
import Entities.Developer;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ish
 */
public class DeveloperDAO {
        public static Developer getByID(Session session,int id){
        try {
            Developer d = (Developer)session.load((Class)Customer.class, (Serializable)Integer.valueOf(id));
            return d;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
         
   public static Developer getByQuery(Session session, String condition, String orderBy) {
        try {
            StringBuffer sb = new StringBuffer("From Customer as Developer");
            sb.append(" Where ").append(condition);
            if (orderBy != null) {
                sb.append(" Order By ").append(orderBy);
            }
            return (Developer)session.createQuery(sb.toString()).setMaxResults(1).uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Developer> listByQuery(Session session, String condition, String orderBy) {
        StringBuffer sb = new StringBuffer("From Customer as Developer");
        if (condition != null) {
            sb.append(" Where ").append(condition);
        }
        if (orderBy != null) {
            sb.append(" Order By ").append(orderBy);
        }
        try {
            List list = session.createQuery(sb.toString()).list();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Iterator iterateByQuery(Session session, String condition, String orderBy) {
        StringBuffer sb = new StringBuffer("From Customer as Developer");
        if (condition != null) {
            sb.append(" Where ").append(condition);
        }
        if (orderBy != null) {
            sb.append(" Order By ").append(orderBy);
        }
        try {
            Query query = session.createQuery(sb.toString());
            return query.iterate();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Developer save(Session session,Developer d) {
        try {        
            session.save((Object)d);
            return d;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean update(Session session, Developer d) {
        try {
            session.update((Object)d);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(Session session, Developer d) {
        try {
            session.delete((Object)d);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
