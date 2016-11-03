/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customerhasapplication;
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
public class setrate extends HttpServlet {
  
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
        if(request.getParameter("rate")!=null&request.getParameter("id")!=null){
            int cushasid = Integer.parseInt(request.getParameter("id"));
            int rate = Integer.parseInt(request.getParameter("rate"));
            if(rate<5){
                Customerhasapplication uniqeresault = (Customerhasapplication) Datacontroller.DataParser.getuniqeresault(new Customerhasapplication(), cushasid);
                uniqeresault.setRate(rate);
                boolean UpdateData = Datacontroller.DataParser.UpdateData(uniqeresault);
                if(UpdateData){
                    response.getWriter().write("true");
                }else{
                     response.getWriter().write("false");
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
