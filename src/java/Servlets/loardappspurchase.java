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
public class loardappspurchase extends HttpServlet {

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
          
            System.out.println("Loading ");
            Application uniqeresault = (Application) Datacontroller.DataParser.getuniqeresault(new  Application(),Integer.parseInt(request.getParameter("appid")));
            Set<Customerhasapplication> comments = uniqeresault.getCustomerhasapplications();
            Double total=0.0;
            Double apptotal=0.0;
            Double incometotal=0.0;
            Double duetotal=0.0;
            
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
"                                            <th>Income</th>\n" +
"                                            <th>Developer Payment</th>\n" +
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
                out.write("<td>"+comment.getIncomePrice()+"</td>");
                out.write("<td>"+comment.getDeveloperPayementPrice()+"</td>");
                out.write("<td>"+comment.getCustomer().getIdCustomer()+"</td>");
                out.write("<td>"+comment.getCustomer().getCustomerFname()+" "+comment.getCustomer().getCustomerLname()+"</td>");
               if(!comment.getIsPayedDeveloper()){
               
                out.write("<td>Not WithDraw This Payment</td>");
               }else{
                    out.write("<td>"+comment.getPayedDateAndTimeToDeveloper()+"</td>");
               }
                total+=comment.getDeveloperPayementPrice();
                apptotal+=comment.getIncomePrice()+comment.getDeveloperPayementPrice();
                incometotal+=comment.getIncomePrice();
                if(!comment.getIsPayedDeveloper().booleanValue()){
                duetotal+=comment.getDeveloperPayementPrice();
                }
               
                out.write("</tr>");  
                }
            
              
           out.write("  </tbody>\n" +
"                                </table>\n" +
"                                <h3>App Total Amount :"+total+"</h3>\n" +
"                                <h3>Developer Earn Total Amount :"+total+"</h3>\n" +
"                                <h3>Due Total Amount :"+duetotal+"</h3>\n" +
"                                <h3> Total Income Amount :"+incometotal+"</h3>\n" +
                   
"                            </div>");
        }catch(Exception e){
            e.printStackTrace();
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
