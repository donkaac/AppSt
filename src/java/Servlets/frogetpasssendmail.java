/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Customer;
import Entities.Emailvarified;
import Oparation.Mails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
             
            HttpSession s = request.getSession();

            String username = "Guest";
            boolean loging = false;
            Customer cc = new Customer();
            if (!request.getSession().equals(null)) {
                try {

                    int cusid = Integer.parseInt(s.getAttribute("userid").toString());
                    cc = (Customer) DataParser.getuniqeresault(new Customer(), cusid);
                    username = cc.getCustomerFname();
                    loging = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                response.sendRedirect("login.jsp");
            }
            if(!loging){
                 response.sendRedirect("index.jsp");
            }
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
               String EmailValidationCode = Oparation.EmailValidationCodeGenaration.EmailValidationCode();
                                Emailvarified emailvarified = new Emailvarified();
                                emailvarified.setToken(EmailValidationCode);
                                emailvarified.setEmailvarifiedDate(new Date());
                                emailvarified.setEmail(email);
                               emailvarified.setState(true);
                             c.setEmailvarified(emailvarified);
                   boolean Savedata = Datacontroller.DataParser.Savedata(emailvarified);
                   boolean UpdateData = Datacontroller.DataParser.UpdateData(c);
                   
                 try {
                             Mails.sendFromGMail(cemail, "Froget Password Request", EmailValidationCode);

             } catch (Exception e) {
             }
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
