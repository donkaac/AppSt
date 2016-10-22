/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import Entities.Customerhasapplication;
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
public class loardpurchase extends HttpServlet {
  
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
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            Application uniqeresault = (Application) Datacontroller.DataParser.getuniqeresault(new  Application(),Integer.parseInt(request.getParameter("appid")));
            Set<Customerhasapplication> comments = uniqeresault.getCustomerhasapplications();
            
           out.write("<div class=\"scrollit\" style=\"width: 1000px\">\n" +
"                                <table class=\"table table-hover\">\n" +
"                                    <thead>\n" +
"                                        <tr>\n" +
"                                            <th>ID</th>\n" +             
"                                            <th>Date</th>\n" +
"                                            <th>App ID</th>\n" +
"                                            <th>App Name</th>\n" +
"                                            <th>Category</th>\n" +
"                                            <th>Type</th>\n" +
"                                            <th>Platform</th>\n" +
"                                            <th>Price</th>\n" +
"                                            <th>Customer ID </th>\n" +
"                                            <th>Customer Name</th>\n" +                         
"                                            <th></th>\n" +
"                                        </tr>\n" +
"                                    </thead>\n" +
"                                    <tbody>");
            for (Customerhasapplication comment : comments) {
                if(comment.getIsPayedDeveloper()==state){
                out.write("<tr>");
                out.write("<td>"+comment.getIdCustomerHasApplication()+"</td>");
                out.write("<td>"+comment.getPayedDateAndTimeToDeveloper()+"</td>");
                out.write("<td>"+comment.getApplication().getIdApplication()+"</td>");             
                out.write("<td>"+comment.getApplication().getApplicationName()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getCategory()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getApptype().getApptype()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getApptype().getAppplatform().getAppplatform()+"</td>");
                out.write("<td>"+comment.getApplication().getPrice()+"</td>");
                out.write("<td>"+comment.getCustomer().getIdCustomer()+"</td>");
                out.write("<td>"+comment.getCustomer().getCustomerFname()+" "+comment.getCustomer().getCustomerLname()+"</td>");
                out.write("<td></td>");
                out.write("<td></td>");
                out.write("<td></td>");
               out.write("<form action=\"withdarwAppPayments\" method=\"POST\"><input type=\"hidden\" value=\""+comment.getIdCustomerHasApplication()+"\" name=\"cushasid\"/><input class=\"form-control btn-default\" type=\"submit\" value=\"Withdraw\"/></form>");
                
                out.write("</tr>");  
                }
            }
           
           out.write("  </tbody>\n" +
"                                </table>\n" +
"                            </div>");
        }catch(Exception e){
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
