/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
import Entities.Staff;
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
public class changestaffpassword extends HttpServlet {
  
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
            if (s.getAttribute("user")!= null) {
                
              if (pass1 == null ? pass2 == null : pass1.equals(pass2)) {
               
                //Customer cusObject = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), cusid);
                Staff cusObject = (Staff) s.getAttribute("user");
                  System.out.println("ok");
                if (!(null == cusObject.getStaffPassword()) ? null == Datacontroller.EncryptUtils.base64encode(oldapass) : (cusObject.getStaffPassword() == null ? (Datacontroller.EncryptUtils.base64encode(oldapass)) == null : cusObject.getStaffPassword().equals(Datacontroller.EncryptUtils.base64encode(oldapass)))) {
                } else {
                    cusObject.setStaffPassword(Datacontroller.EncryptUtils.base64encode(pass2));
                    System.out.println("ok");
                    boolean UpdateData = Datacontroller.DataParser.UpdateData(cusObject);
                    response.sendRedirect("profle.jsp");
                  }
              }else{
                  response.sendRedirect("profle.jsp?msg=Check Your Password");
              }
            }else{
                response.sendRedirect("index.jsp");
            }
            
        } catch (NumberFormatException | IOException e) {
            response.sendRedirect("profle.jsp?msg=Error");
            e.printStackTrace();
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
