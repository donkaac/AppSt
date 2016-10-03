/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datacontroller;

import Entities.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ish
 */
/**
 *
 * @author Ish
 */
public class DataParser {

    private static DataParser dataparser;

    

    private DataParser DataParser() {

        if (dataparser.equals(null)) {
            dataparser = new DataParser();
            return dataparser;
        }
        return dataparser;
    }

    public static Object getuniqeresault(Object o, int id) {
        Session Session = Entities.HibernateUtil.getSessionFactory().openSession();
        
        Session.beginTransaction().commit();
        return Session.get(o.getClass(), id);
    }

    public static boolean Savedata(Object o) {
        try {
            Session Session = Entities.HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = Session.beginTransaction();

            Session.save(o);
            beginTransaction.commit();
            Session.flush();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static ArrayList<Object> Searchdata(Object o, String[][] SearchDataAndParameaters) {
        ArrayList<Object> resualt = null;
        try {
            Session s = Entities.HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM " + o.getClass().getSimpleName() + "";
            if (!SearchDataAndParameaters.equals(null)) {
                hql += " WHERE ";
            }
            for (int i = 0; i < SearchDataAndParameaters.length; ++i) {
                if (i == 0) {
                    hql += SearchDataAndParameaters[i][0].toString() + " ='" + SearchDataAndParameaters[i][1].toString() + "' ";
                } else {
                    hql += "AND " + SearchDataAndParameaters[i][0].toString() + "='" + SearchDataAndParameaters[i][1].toString() + "'";
                }
            }
            System.out.println(hql);
            Query q = s.createQuery(hql);
             
            List<Object> list = q.list();
            resualt = (ArrayList<Object>) list;
             s.flush();
             s.beginTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return resualt;
    }

    public static ArrayList<Object> Searchdata(Object o) {
        ArrayList<Object> resualt = null;
        try {
            Session s = Entities.HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM " + o.getClass().getSimpleName() + "";

            System.out.println(hql);
            Query q = s.createQuery(hql);
            List<Object> list = q.list();
            resualt = (ArrayList<Object>) list;
            s.flush();
        } catch (Exception e) {

            return null;
        }
        return resualt;
    }

    public static ArrayList<Object> HQLQuary(String hql) {
        ArrayList<Object> resualt = null;
        try {
            Session s = Entities.HibernateUtil.getSessionFactory().openSession();

            System.out.println(hql);
            Query q = s.createQuery(hql);
            if (q.equals(null)) {
                return null;
            }
            List<Object> list = q.list();
            resualt = (ArrayList<Object>) list;
             s.flush();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return resualt;
    }

    public static boolean DeleteDataById(Object o, int id) {
        try {
            Session s = Entities.HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            Object deleteob = s.load(o.getClass(), id);
            s.delete(deleteob);
            t.commit();
             s.flush();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
  public static boolean DeleteDataByObject(Object o) {
        try {
            Session s = Entities.HibernateUtil.getSessionFactory().openSession();
        
             
            s.delete(o);
            
             s.flush();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean UpdateData(Object o) {
        try {
            Session s = Entities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.getTransaction();
            tx.begin();
            s.merge(o);
            tx.commit();
             s.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
