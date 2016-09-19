/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.json.simple.JSONArray;

/**
 *
 * @author Ish
 */
public class staffLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Session hibernate = HibernateUtil.getSessionFactory().openSession();
            HttpSession ses = request.getSession();

            boolean success = false;
            String message = "";
            Integer idURoll = null;

            JSONArray js = new JSONArray();
            Map m = new HashMap();
            try {
                String USERNAME = request.getParameter("username");
                String PASSWORD = request.getParameter("password");
                
                System.out.println(USERNAME+""+PASSWORD);
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
