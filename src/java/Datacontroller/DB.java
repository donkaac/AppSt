/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datacontroller;

//DB connection class
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ishan(ish)
 */

public class DB {
    public static  Connection c;
    public  static  Connection getConnection() throws Exception{
     
        if(c==null){
       Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/appstore", "root", "1234");
        return c;
        }else{
            return c;
        }
    }

}