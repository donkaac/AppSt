/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Developervalid;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class developerValidAciveOrDeactive extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
         try {
               if((null!=request.getParameter("developervalidid"))&(null!=request.getParameter("state"))){
                int developerid=Integer.parseInt(request.getParameter("developervalidid"));
                boolean s = Boolean.parseBoolean(request.getParameter("state"));
                Developervalid developervalid = (Developervalid) DataParser.getuniqeresault(new Developervalid(), developerid);
                developervalid.setDeveloperValidState(s);
                boolean Savedata = DataParser.UpdateData(developervalid);
                if(Savedata){
                    response.sendRedirect("admin/setdevelopervalid.jsp");
                }
            }  
        } catch (Exception e) {
        }
         
    }
 
}
