/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import Entities.Customerhasapplication;
import Entities.Developer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class withdrawall extends HttpServlet {

    
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
                    if (session.getAttribute("developer") != null) {
                        Developer developer = (Developer) session.getAttribute("developer");
                        System.out.println("ss");
          if(request.getParameter("appid")!=null){
            int appid = Integer.parseInt(request.getParameter("appid"));
              System.out.println(appid+"");
           
               Application application= (Application) Datacontroller.DataParser.getuniqeresault(new Application(), appid);
          Set<Customerhasapplication> cushaslist= application.getCustomerhasapplications();
          boolean b=false;
              for (Customerhasapplication cushasob : cushaslist) {
              
                cushasob.setIsPayedDeveloper(true);
                cushasob.setPayedDateAndTimeToDeveloper(new Date());
               
                b = Datacontroller.DataParser.UpdateData(cushasob);
             
              }
                if(b){
                   response.sendRedirect("developer/appPurchaseHistory.jsp?msg=OK");
                }else{
                     response.sendRedirect("developer/appPurchaseHistory.jsp?msg=ERORR");
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
