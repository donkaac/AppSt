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
import Entities.Customerhasapplication;
import Entities.Serialkeys;
import Oparation.EmailValidationCodeGenaration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class buyApp extends HttpServlet {

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
            if(request.getParameter("appid")!=null){
                try {
                      boolean Savedata=false;
                if (request.getSession().getAttribute("user") != null) {
                    HttpSession session = request.getSession();
                    int appid = Integer.parseInt(request.getParameter("appid"));
                
                    Customer customer = (Customer) session.getAttribute("user");
                    Application app = (Application) Datacontroller.DataParser.getuniqeresault(new Application(), appid);
                    Serialkeys serialkey= new Serialkeys(app, Datacontroller.EncryptUtils.base64decode(Oparation.EmailValidationCodeGenaration.EmailValidationCode()+""+EmailValidationCodeGenaration.EmailValidationCode()));
                    boolean SaveSerial = Datacontroller.DataParser.Savedata(serialkey);
                    
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
                   customerhasapplication.setIsPayedDeveloper(false);
                      Savedata = Datacontroller.DataParser.Savedata(customerhasapplication);
                    
                    }
                 
                    if (Savedata) {
                        customer = (Customer)Datacontroller.DataParser.getuniqeresault(new Customer(), customer.getIdCustomer());
                        session.setAttribute("user", customer);
                    }

                    out.write("" + Savedata);
                } 

            } catch (Exception e) {
                e.printStackTrace();
            }
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
