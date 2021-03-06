/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import Entities.Cart;
import Entities.CartId;
import Entities.Customer;
import Entities.Wishlist;
import Entities.WishlistId;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class addtowishlist extends HttpServlet {

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
                if (!request.getSession().equals(null)) {
                    HttpSession session = request.getSession();
                    if (session.getAttribute("user") != null) {
                        Customer customer = (Customer) session.getAttribute("user");

                        int appid = Integer.parseInt(request.getParameter("appid"));
                        int cusid = customer.getIdCustomer();
                        customer = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), cusid);
                        Application app = (Application) Datacontroller.DataParser.getuniqeresault(new Application(), appid);

                        WishlistId wishlistId = new WishlistId(customer.getIdCustomer(), app.getIdApplication());
                        Wishlist wishlist = new Wishlist(wishlistId, app, customer, true);

                        boolean Savedata = Datacontroller.DataParser.Savedata(wishlist);

                        out.write("" + Savedata);
                    }

                }

            } catch (NullPointerException e) {
                 response.sendRedirect("login.jsp");
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
