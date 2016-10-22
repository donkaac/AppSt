/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.HibernateUtil;
import Entities.Application;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ish
 */
public class searchappbynameonfolder extends HttpServlet {

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
            throws ServletException, IOException {{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("appname") != null) {
                System.out.println("Request send");
                String name = request.getParameter("appname");
                System.out.println("NAME ::::::"+name);
                Session session = HibernateUtil.getSessionFactory().openSession();
                Criteria cr = session.createCriteria(Application.class);

                
               
                Criterion namecr = Restrictions.ilike("applicationName", "%"+name + "%");
               
                cr.add(namecr);
               
                List list = cr.list();
                for (Object object : list) {
                    System.out.println("for loop");
                    Application app = (Application) object;
                  app.setAppImage("../"+app.getAppImage());
                    if(app.isState()){
                    out.write("<div class=\"col-sm-3\">\n"
                            + "            <article class=\"col-item\">\n"
                            + "        		<div  class=\"photo\">\n"
                            + "        			 \n"
                            + "        			<a> <img src=\"" +app.getAppImage() + "\" class=\"img-responsive\" alt=\"Product Image\" /> </a>\n"
                            + "        		</div>\n"
                            + "        		<div class=\"info\">\n"
                            + "        			<div class=\"row\">\n"
                            + "        				<div class=\"price-details col-md-6\">\n"
                            + "        					<p class=\"details\">\n"
                            + "        					" + app.getDescription() + "\n"
                            + "        					</p>\n"
                            + "        					<h1>" + app.getApplicationName() + "</h1>\n"
                            + "        					<span class=\"price-new\">$" + app.getPrice() + "</span>\n"
                            + "        				</div>\n"
                            + "        			</div>\n"
                            + "        		</div>\n"
                            + "        	</article>\n"
                            + "        </div>");
                }}
            }
        }
            }}

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
