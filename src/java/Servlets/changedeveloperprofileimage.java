/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Customer;
import Entities.Developer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ish
 */
public class changedeveloperprofileimage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
            try {
              
                Developer c = (Developer) request.getSession().getAttribute("developer");
  c = (Developer) Datacontroller.DataParser.getuniqeresault(new Customer(), c.getIdDeveloper());
                FileItemFactory f1 = new DiskFileItemFactory();
                ServletFileUpload up = new ServletFileUpload(f1);

                List<FileItem> li = up.parseRequest(request);

                String Image_Title = null;
                String fn = null;
                String Image_Path = null;
                int i = 0;
                for (FileItem item : li) {

                   
                    Image_Path = "appinterface/developerimage/" + System.currentTimeMillis() + "" + item.getName();
                    System.out.println(item.getName());
                    File f = new File(request.getServletContext().getRealPath("/") + Image_Path);

                    item.write(f);

                    c.setDeveloperImage(Image_Path);
                    System.out.println(Image_Path);
                }
                boolean UpdateData = DataParser.UpdateData(c);
                if (UpdateData) {
                    request.getSession().setAttribute("developer", c);
                    response.sendRedirect("developer/profile.jsp");
                }
                if (i == 4) {
                    i = 0;
                }

            } catch (Exception e) {
                response.sendRedirect("developer/profile.jsp?msg=FileUploadIsError");
               

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
