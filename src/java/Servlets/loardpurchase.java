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
            Double total=0.0;
            Double duetotal=0.0;
            
           out.write("<div class=\"scrollit\" style=\"width: 1100px\">\n" +
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
"                                            <th>Your Price</th>\n" +
"                                            <th>Customer ID </th>\n" +
"                                            <th>Customer Name</th>\n" +                         
"                                            <th>Payed Date</th>\n" +
"                                        </tr>\n" +
"                                    </thead>\n" +
"                                    <tbody>");
            for (Customerhasapplication comment : comments) {
             
                out.write("<tr>");
                out.write("<td>"+comment.getIdCustomerHasApplication()+"</td>");
                out.write("<td>"+comment.getCustomerHasApplicationDateAndTime()+"</td>");
                out.write("<td>"+comment.getApplication().getIdApplication()+"</td>");             
                out.write("<td>"+comment.getApplication().getApplicationName()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getCategory()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getApptype().getApptype()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getApptype().getAppplatform().getAppplatform()+"</td>");
                out.write("<td>"+comment.getApplication().getPrice()+"</td>");
                out.write("<td>"+comment.getDeveloperPayementPrice()+"</td>");
                out.write("<td>"+comment.getCustomer().getIdCustomer()+"</td>");
                out.write("<td>"+comment.getCustomer().getCustomerFname()+" "+comment.getCustomer().getCustomerLname()+"</td>");
               if(!comment.getIsPayedDeveloper()){
               
                out.write("<td><form action=\"../withdarwAppPayments\" method=\"POST\"><input name=\"id\" type=\"hidden\" value=\""+comment.getIdCustomerHasApplication()+"\"/><input class=\"form-control btn-default\" type=\"submit\" value=\"withdraw\"/></form> </td>");
               }else{
                    out.write("<td>"+comment.getPayedDateAndTimeToDeveloper()+"</td>");
               }
                total+=comment.getDeveloperPayementPrice();
                if(!comment.getIsPayedDeveloper().booleanValue()){
                duetotal+=comment.getDeveloperPayementPrice();
                }
               
                out.write("</tr>");  
                }
            
              out.write("<td><form action=\"../withdrawall\" method=\"POST\"><input name=\"appid\" type=\"hidden\" value=\""+uniqeresault.getIdApplication()+"\"/><input class=\"form-control btn\" type=\"submit\" value=\"withdraw All Payment On This App\"/></form> </td>");
           out.write("  </tbody>\n" +
"                                </table>\n" +
"                                <h3>Your Earn Total Amount :"+total+"</h3>\n" +
"                                <h3>Due Total Amount :"+duetotal+"</h3>\n" +
                   
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
