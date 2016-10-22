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
import Entities.Customerhasapplication;
import Entities.Serialkeys;
import Oparation.EmailValidationCodeGenaration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
public class buycartallapps extends HttpServlet {  
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
                      boolean Savedata=false;
                if (request.getSession().getAttribute("user") != null) {
                    HttpSession session = request.getSession();
                     
                    System.out.println("IF PASS");
                    Customer customer = (Customer) session.getAttribute("user");
                    customer=(Customer) DataParser.getuniqeresault(new Customer(), customer.getIdCustomer());
                          Set<Cart> carts = customer.getCarts();
                    for (Cart cart : carts) {
                       if(cart.isState()){
                            Application app = cart.getApplication();
                            System.out.println("  app   "+app.getApplicationName());
                    Serialkeys serialkey= new Serialkeys(app, Datacontroller.EncryptUtils.base64decode(Oparation.EmailValidationCodeGenaration.EmailValidationCode()+""+EmailValidationCodeGenaration.EmailValidationCode()));
                    boolean SaveSerial = Datacontroller.DataParser.Savedata(serialkey);
                           System.out.println("Save Serial key"+SaveSerial);
                    if(SaveSerial){
                        
                        ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Serialkeys());
                       Serialkeys serialkeys =null;
                        for (Object object : Searchdata) {
                           serialkeys= (Serialkeys) object;
                            System.out.println(""+serialkeys.getSerialkey()+" "+serialkeys.getApplication().getApplicationName());
                           if(serialkeys.getState()&(serialkeys.getApplication().getIdApplication()==app.getIdApplication())&(serialkey.getSerialkey()==serialkeys.getSerialkey())){
                            break;
                        }
                        }
                           double developerprice = app.getPrice()/100*80;
                    double incomeprice = app.getPrice()/100*20;
                    Customerhasapplication customerhasapplication = new Customerhasapplication(app, customer, serialkeys, new Date(),developerprice ,incomeprice);
                    
                      Savedata = Datacontroller.DataParser.Savedata(customerhasapplication);
                      cart.setState(false);
                        
                            int executeUpdate = DB.getConnection().createStatement().executeUpdate("DELETE FROM cart WHERE Customer_idCustomer='" + customer.getIdCustomer() + "' AND Application_idApplication='" + app.getIdApplication() + "'");
                           
                    }
                       }
                    }
                    if (Savedata) {
                        customer = (Customer)Datacontroller.DataParser.getuniqeresault(new Customer(), customer.getIdCustomer());
                        session.setAttribute("user", customer);
                    }

                    
                } 

            } catch (Exception e) {
                e.printStackTrace();
            }
        response.sendRedirect("cart.jsp");
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
