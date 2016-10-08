/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Application;
import Entities.Customer;
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
public class changeprofileimage extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            try {
               // Customer c = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), Integer.parseInt(request.getSession().getAttribute("userid").toString()));
                Customer c = (Customer) session.getAttribute("user");

                FileItemFactory f1 = new DiskFileItemFactory();
                ServletFileUpload up = new ServletFileUpload(f1);

                List<FileItem> li = up.parseRequest(request);

                String Image_Title = null;
                String fn = null;
                String Image_Path = null;
                int i = 0;
                for (FileItem item : li) {

                    String[] split = item.getName().split(".");
                    Image_Path = "appinterface/cusimage/" + System.currentTimeMillis() + "" + item.getName();
                    System.out.println(item.getName());
                    File f = new File(request.getServletContext().getRealPath("/") + Image_Path);

                    item.write(f);

                    c.setCustomerImage(Image_Path);

                }
                boolean UpdateData = DataParser.UpdateData(c);
                if (UpdateData) {
                    response.sendRedirect("profile.jsp");
                }
                if (i == 4) {
                    i = 0;
                }

            } catch (Exception e) {

                throw new ServletException(e);

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
