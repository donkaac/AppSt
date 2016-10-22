/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Menu;
import Entities.Submenu;
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
public class saveprivilages extends HttpServlet {  

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
            if((request.getParameter("newprivilage")!=null)&(request.getParameter("pageurl")!=null)&(request.getParameter("menuid")!=null)){
                Submenu submenu = new Submenu();
                Menu menu = (Menu) Datacontroller.DataParser.getuniqeresault(new Menu(), Integer.parseInt(request.getParameter("menuid")));
                submenu.setSubmenu(request.getParameter("newprivilage"));
                submenu.setPageurl(request.getParameter("pageurl"));
                submenu.setMenu(menu);
                boolean Savedata = Datacontroller.DataParser.Savedata(submenu);
                System.out.println("Is Saved"+Savedata);
                if(Savedata){
                     response.sendRedirect("admin/privilages.jsp?msg=Saved");
                }
            }else{
                response.sendRedirect("admin/privilages.jsp");
            }
        } catch (Exception e) {
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
