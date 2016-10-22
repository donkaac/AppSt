/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DB;
import Entities.Rolehassubmenu;
import Entities.Roles;
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
public class deleterole extends HttpServlet {
  
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
            if(request.getParameter("roleid")!=null){
                Roles roles = new Roles();
                int roleid = Integer.parseInt(request.getParameter("roleid"));
               Roles role = (Roles) Datacontroller.DataParser.getuniqeresault(new Roles(), roleid);
                Set<Rolehassubmenu> rolehassubmenus = role.getRolehassubmenus();
                for (Rolehassubmenu rolehassubmenu : rolehassubmenus) {
                    
                     int executeUpdate = DB.getConnection().createStatement().executeUpdate("DELETE FROM rolehassubmenu WHERE roles_idroles='" + role.getIdroles() + "' AND submenu_idsubmenu='" + rolehassubmenu.getSubmenu().getIdsubmenu() + "'");
                
                }
                boolean DeleteDataByObject = Datacontroller.DataParser.DeleteDataById(new Roles(),roleid);
                System.out.println("Role Delete "+DeleteDataByObject);
            }
        } catch (Exception e) {
        }
        response.sendRedirect("admin/staffRoles.jsp");
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
