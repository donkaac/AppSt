/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DB;
import Entities.Rolehassubmenu;
import Entities.Roles;
import Entities.Submenu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class deleteprivilages extends HttpServlet {
  
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
            if(request.getParameter("submenuid")!=null){
              
                int submenuid = Integer.parseInt(request.getParameter("submenuid"));
                System.out.println("sub menu id"+submenuid);
               Submenu submenu = (Submenu) Datacontroller.DataParser.getuniqeresault(new Submenu(), submenuid);
                Set<Rolehassubmenu> rolehassubmenus = submenu.getRolehassubmenus();
                for (Rolehassubmenu rolehassubmenu : rolehassubmenus) {
                    
                     int executeUpdate = DB.getConnection().createStatement().executeUpdate("DELETE FROM rolehassubmenu WHERE submenu_idsubmenu='" + rolehassubmenu.getSubmenu().getIdsubmenu() + "'");
                if(executeUpdate==1){
                    System.out.println("Is Deleted");
                }
                }
                boolean DeleteDataByObject = Datacontroller.DataParser.DeleteDataById(new Roles(),submenuid);
                System.out.println("Role Delete "+DeleteDataByObject);
            }
        } catch (Exception e) {
        }
        response.sendRedirect("admin/privilages.jsp");
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
