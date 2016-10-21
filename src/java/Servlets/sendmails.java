/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
import Entities.Developer;
import Entities.Staff;
import Oparation.Mails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class sendmails extends HttpServlet {
  
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
            String parameter = request.getParameter("reviever");
            String hedder = request.getParameter("hedder");
            String message = request.getParameter("message");
            String []emaillist=null;
            int index=0;
            if(parameter=="allcustomer"){
                ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Customer());
                for (Object object : Searchdata) {
                    Customer c=(Customer) object;
                    emaillist[index]=c.getUsername();
                    ++index;
                }
            }else if(parameter=="alldeveloper"){
                ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Developer());
                for (Object object : Searchdata) {
                    Developer c=(Developer) object;
                    emaillist[index]=c.getUsername();
                    ++index;
                }
            }else if(parameter=="allstaff"){
                ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Staff());
                for (Object object : Searchdata) {
                    Staff c=(Staff) object;
                    emaillist[index]=c.getUsername();
                    ++index;
                }
            }
            Mails.sendFromGMail(emaillist, hedder, message);
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
