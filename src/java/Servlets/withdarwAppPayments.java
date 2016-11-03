/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
import Entities.Customerhasapplication;
import Entities.Developer;
import java.io.IOException;
import java.io.PrintWriter;
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
public class withdarwAppPayments extends HttpServlet {
  
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
         HttpSession session = request.getSession();
                    if (session.getAttribute("user") != null) {
                        Developer developer = (Developer) session.getAttribute("developer");
                        System.out.println("ss");
          if(request.getParameter("id")!=null){
            int cushasid = Integer.parseInt(request.getParameter("id"));
           
           
                Customerhasapplication uniqeresault = (Customerhasapplication) Datacontroller.DataParser.getuniqeresault(new Customerhasapplication(), cushasid);
           
                uniqeresault.setIsPayedDeveloper(true);
                uniqeresault.setPayedDateAndTimeToDeveloper(new Date());
               
                boolean UpdateData = Datacontroller.DataParser.UpdateData(uniqeresault);
                if(UpdateData){
                   response.sendRedirect("appPurchaseHistory.jsp?msg=OK");
                }else{
                     response.sendRedirect("appPurchaseHistory.jsp?msg=ERORR");
                }
            }
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
