/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Logic;

import Entities.City;
import Entities.Customer;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Achi
 */
public class CustomerDAO {
    public static Customer getByID(Session session,int id){
        try {
            Customer c = (Customer)session.load((Class)Customer.class, (Serializable)Integer.valueOf(id));
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
   public static Customer getByQuery(Session session, String condition, String orderBy) {
        try {
            StringBuffer sb = new StringBuffer("From Customer as Customer");
            sb.append(" Where ").append(condition);
            if (orderBy != null) {
                sb.append(" Order By ").append(orderBy);
            }
            return (Customer)session.createQuery(sb.toString()).setMaxResults(1).uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Customer> listByQuery(Session session, String condition, String orderBy) {
        StringBuffer sb = new StringBuffer("From Customer as Customer");
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
        StringBuffer sb = new StringBuffer("From Customer as Customer");
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

    public static Customer save(Session session,Customer c) {
        try {        
            session.save((Object)c);
            return c;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean update(Session session, Customer c) {
        try {
            session.update((Object)c);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(Session session, Customer c) {
        try {
            session.delete((Object)c);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

