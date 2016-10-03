/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class changepassword extends HttpServlet {

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
            String oldapass = request.getParameter("oldpassword");
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");
            HttpSession s = request.getSession();
            if (!s.getAttribute("userid").toString().equals(null)) {
                
              if (pass1 == pass2) {
                int cusid = Integer.parseInt(s.getAttribute("userid").toString());
                Customer cusObject = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), cusid);
                if (cusObject.getPassword() == Datacontroller.EncryptUtils.base64encode(oldapass)) {
                    cusObject.setPassword(pass1);
                }
              }}else{
                response.sendRedirect("index.jsp");
            }
            
        } catch (Exception e) {
        }
    }

}
