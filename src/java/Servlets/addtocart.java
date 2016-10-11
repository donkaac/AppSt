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
public class addtocart extends HttpServlet {

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
                if (request.getSession().getAttribute("user") != null) {
                    HttpSession session = request.getSession();
                    int appid = Integer.parseInt(request.getParameter("appid"));
                    //int cusid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
                    Customer customer = (Customer) session.getAttribute("user");
                    Application app = (Application) Datacontroller.DataParser.getuniqeresault(new Application(), appid);
                    CartId cartid = new CartId(customer.getIdCustomer(), app.getIdApplication());
                    Cart cart = new Cart(cartid, app, customer, true);

                    boolean Savedata = Datacontroller.DataParser.Savedata(cart);
                    
                    if (Savedata) {
                        customer = (Customer)Datacontroller.DataParser.getuniqeresault(new Customer(), customer.getIdCustomer());
                        session.setAttribute("user", customer);
                    }

                    out.write("" + Savedata);
                }else{
                     List <Integer>cartitem=null;
                     
                    if(!(request.getSession().getAttribute("cartitems")==null)){
                       cartitem=(List<Integer>) request.getSession().getAttribute("cartitems");
                    }
                   
                    boolean add = cartitem.add(Integer.parseInt(request.getParameter("appid")));
                    System.out.println(add+"ADDEWD");
                    request.getSession().setAttribute("cartitems", cartitem);
                    out.write(""+add);
                }

            } catch (Exception e) {
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
