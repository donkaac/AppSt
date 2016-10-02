/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
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
public class frogetpasssendmail extends HttpServlet {
 
 
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
        try (PrintWriter out = response.getWriter()) {
               String email = request.getParameter("email");
            String[][] ar={{"username",email}};
            ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Customer(), ar);
            boolean ifstate=false;
             Customer c=null;
            for (Object object : Searchdata) {
                c=(Customer) object;
                if(c.getUsername().equals(email)){
                ifstate=true;      break;
            }
            }
         if(ifstate){
            String cemail[]={email};
            Mails.sendFromGMail(cemail, "", email);
         }
             System.out.println("Froget Password");
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
