/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Rolehassubmenu;
import Entities.RolehassubmenuId;
import Entities.Roles;
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
public class setprivilagestorole extends HttpServlet {
  
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
        if((request.getParameter("submenuid")!=null)&(request.getParameter("roleid")!=null)){
            int submenuid = Integer.parseInt(request.getParameter("submenuid"));
            int roleid = Integer.parseInt(request.getParameter("roleid"));
            RolehassubmenuId rolehassubmenuId = new RolehassubmenuId(roleid, submenuid);
            Roles role = (Roles) Datacontroller.DataParser.getuniqeresault(new Roles(), roleid);
            Submenu submenu = (Submenu) Datacontroller.DataParser.getuniqeresault(new Submenu(), submenuid);
            Rolehassubmenu rolehassubmenu = new Rolehassubmenu(rolehassubmenuId, role, submenu, true);
            
            boolean Savedata = Datacontroller.DataParser.Savedata(rolehassubmenu);
            
            if(Savedata){
                response.sendRedirect("admin/privilagesManagment.jsp?msg=success");
            }else{
                 response.sendRedirect("admin/privilagesManagment.jsp?msg=error");
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
