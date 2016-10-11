/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DB;
import Datacontroller.DataParser;
import Entities.Application;
import Entities.Cart;
import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class removecart extends HttpServlet {

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
            try {
                if (request.getSession().getAttribute("cartitems")==null) {

                    HttpSession session = request.getSession();
                    int appid = Integer.parseInt(request.getParameter("appid"));
                    System.out.println("cart p id" + appid);
                    //int cusid = Integer.parseInt(session.getAttribute("userid").toString());
                    Customer customer = (Customer) session.getAttribute("user");
                    System.out.println("OK");
                    int cusid = customer.getIdCustomer();
                    customer = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), customer.getIdCustomer());
                    System.out.println(cusid);
                    Set<Cart> carts = customer.getCarts();

                    for (Cart cart : carts) {
                        System.out.println("ok1");
                        if ((cart.getCustomer().getIdCustomer() == cusid) & (cart.getApplication().getIdApplication() == appid)) {
                            int executeUpdate = DB.getConnection().createStatement().executeUpdate("DELETE FROM cart WHERE Customer_idCustomer='" + cusid + "' AND Application_idApplication='" + appid + "'");
                            System.out.println("Delete Cart :" + executeUpdate);
                            if (executeUpdate == 1) {
                                out.write("true");
                            } else {
                                out.write("false");
                            }
                            break;
                        }
        
                    }

                }else{
                     List<Integer> cartitem=(List) request.getSession().getAttribute("cartitems");
                     int appid = Integer.parseInt(request.getParameter("appid"));
                    for (int i = 0; i < cartitem.size(); i++) {
                        
                        if (cartitem.get(i)==appid) {
                            
                        }
                        
                    }
                    
                }

            } catch (Exception e) {
                out.write("false");
                e.printStackTrace();
            }
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
