/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import Entities.Comment;
import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
@WebServlet(name = "SaveComment", urlPatterns = {"/SaveComment"})
public class SaveComment extends HttpServlet {
  
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
         if((request.getParameter("text")!=null)&(request.getParameter("appid")!=null)){
             Customer customer=(Customer) request.getSession().getAttribute("user");
            customer=(Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), customer.getIdCustomer());
             Application application = (Application) Datacontroller.DataParser.getuniqeresault(new Application(), Integer.parseInt(request.getParameter("appid")));
             Comment comment = new Comment(application, customer, new Date(), true);
             comment.setComment(request.getParameter("text"));
             boolean Savedata = Datacontroller.DataParser.Savedata(comment);
             if(Savedata){
                 response.sendRedirect("viewapp.jsp?appid="+application.getIdApplication()+"&msg=Succsess");
             }else{
                 response.sendRedirect("viewapp.jsp");
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
