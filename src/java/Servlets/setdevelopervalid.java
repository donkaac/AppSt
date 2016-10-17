/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Developer;
import Entities.Developervalid;
import Entities.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class setdevelopervalid extends HttpServlet {

     
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
        try {
            if(null!=request.getParameter("developerid")){
                int developerid=Integer.parseInt(request.getParameter("developerid"));
                Developer developer = (Developer) Datacontroller.DataParser.getuniqeresault(new Developer(), developerid);
                Staff staff = (Staff) Datacontroller.DataParser.getuniqeresault(new Staff(), 2);
                if(developer.getDevelopervalids().isEmpty()){
                Developervalid developervalid = new Developervalid(developer, staff, new Date(), true);
                boolean Savedata = DataParser.Savedata(developervalid);
                if(Savedata){
                    response.sendRedirect("admin/setdevelopervalid.jsp");
                }}
            } else {
                
            }
        } catch (Exception e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
