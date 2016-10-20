/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class removecomment extends HttpServlet {

     
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
         if(request.getParameter("commentid")!=null){
             int commentid = Integer.parseInt(request.getParameter("commentid"));
             Comment uniqeresault = (Comment) Datacontroller.DataParser.getuniqeresault(new Comment(), commentid);
             
             uniqeresault.setState(false);
             boolean UpdateData = Datacontroller.DataParser.UpdateData(uniqeresault);
             PrintWriter writer = response.getWriter();
             writer.write(""+UpdateData);
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
