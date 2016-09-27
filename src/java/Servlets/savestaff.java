/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ish
 */
public class savestaff extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            if(request.getParameter("pass1").equals(request.getParameter("pass2"))){
            Staff staff = new Staff();
            staff.setStaffFname(request.getParameter("fname"));
            staff.setStaffMname(request.getParameter("mname"));
            staff.setStaffLname(request.getParameter("lname"));
            staff.setUsername(request.getParameter("email"));
            staff.setStaffPassword(request.getParameter("pass1"));
         
                try {
                    String [][]s={{"cityName",request.getParameter("citylist") }};
                ArrayList<Object> Searchdata = DataParser.Searchdata(new City(),s);
                 City c=null;
                    for (Object object : Searchdata) {
                      c= (City) object;
                    }
                    
                    staff.setCity(c);
                } catch (Exception e) {
                }
            
            staff.setAddress(request.getParameter("address"));
            staff.setStaffRegDateAndTime(new Date());
            staff.setState(true);
             
                boolean Savedata = DataParser.Savedata(staff);
                writer.write(""+Savedata);
            }
        } catch (Exception e) {
        }
    }
 
}
