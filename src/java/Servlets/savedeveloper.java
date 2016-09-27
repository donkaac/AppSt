/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.City;
import Entities.Developer;
import Entities.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class savedeveloper extends HttpServlet {
 
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
         try {
            if(request.getParameter("pass1").equals(request.getParameter("pass2"))){
                Developer developer = new Developer();
            developer.setDeveloperFname(request.getParameter("fname"));
            developer.setDeveloperMname(request.getParameter("mname"));
            developer.setDeveloperLname(request.getParameter("lname"));
            developer.setUsername(request.getParameter("email"));
            developer.setPassword(request.getParameter("pass1"));
         
                try {
                    String [][]s={{"cityName",request.getParameter("citylist") }};
                ArrayList<Object> Searchdata = DataParser.Searchdata(new City(),s);
                 City c=null;
                    for (Object object : Searchdata) {
                      c= (City) object;
                    }
                    
                    developer.setCity(c);
                } catch (Exception e) {
                }
            
            developer.setAddress(request.getParameter("address"));
             developer.setDeveloperRegdate(new Date());
            developer.setState(true);
             
                boolean Savedata = DataParser.Savedata(developer);
                writer.write(""+Savedata);
            }
        } catch (Exception e) {
        }
    }

    
}
