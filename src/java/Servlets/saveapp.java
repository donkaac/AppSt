/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Category;
import Entities.Customer;
import Entities.Developer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Ish
 */
@WebServlet(name = "saveapp", urlPatterns = {"/saveapp"})
public class saveapp extends HttpServlet {

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
            String appname = request.getParameter("appname");
            String description = request.getParameter("description");
            String usermanualurl = request.getParameter("usermanualurl");
            String videourl = request.getParameter("videourl");
            Double price = Double.parseDouble(request.getParameter("price"));
            Category category = (Category) Datacontroller.DataParser.getuniqeresault(new Category(), Integer.parseInt(request.getParameter("appcategorylist")));
            Developer developer = (Developer) request.getSession().getAttribute("developer");
            int developerid = developer.getIdDeveloper();
            developer = (Developer) Datacontroller.DataParser.getuniqeresault(new Developer(), developerid);
            
            
            
            
            
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
