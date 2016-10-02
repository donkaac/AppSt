/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.City;
import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class saveuser extends HttpServlet {

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
        try{
             PrintWriter writer = response.getWriter();
             String fname = request.getParameter("fname");
             String mname = request.getParameter("mname");
             String lname = request.getParameter("lname");
             String email = request.getParameter("email");
             String address = request.getParameter("address");
             String cityid = request.getParameter("city");
             String username = request.getParameter("username");
             String password = request.getParameter("password");
             String rpassword = request.getParameter("rpassword");
             String mobile = request.getParameter("mobile");
             
             if(!(fname.equals("")|fname.equals(null)|mname.equals("")|mname.equals(null)|lname.equals("")|lname.equals(null)|email.equals("")|email.equals(null)|address.equals("")|address.equals(null)|cityid.equals("")|cityid.equals(null)|username.equals("")|username.equals(null)|password.equals("")|password.equals(null)|rpassword.equals("")|rpassword.equals(null)|mobile.equals("")|mobile.equals(null))){
                 if (password.equals(rpassword)) {
                     Object city = Datacontroller.DataParser.getuniqeresault(new City(), Integer.parseInt(cityid));
                     Customer c=new Customer();
                     c.setCustomerFname(fname);
                     c.setCustomerMname(mname);
                     c.setCustomerLname(lname);
                     c.setCustomerRegDateAndTime(new Date());
                     c.setCity((City) city);
                     c.setPassword(password);
                     c.setUsername(username);
                     c.setAddress(address);
                     c.setState(true);
                     boolean Savedata = Datacontroller.DataParser.Savedata(c);
                     writer.write(""+Savedata);
                 }else{
                     writer.write("match password");
                 }
             }else{
                 writer.write("null data");
             }
            
        } catch (Exception e) {
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
