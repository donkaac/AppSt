/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.City;
import Entities.Customer;
import Entities.Emailvarified;
import Entities.Gender;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class updatecustomerdata extends HttpServlet {

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
                System.out.println("request revice");
                PrintWriter writer = response.getWriter();
                String fname = request.getParameter("fname");
                String mname = request.getParameter("mname");
                String lname = request.getParameter("lname");

                String address = request.getParameter("address");
                String cityid = request.getParameter("city");
                

     
                String genderid = request.getParameter("gender");
                boolean emailexist = true;
                HttpSession s = request.getSession();
                int cusid = Integer.parseInt(s.getAttribute("userid").toString());
             
                if (!(fname.equals("") | fname.equals(null) | mname.equals("") | mname.equals(null) | lname.equals("") | lname.equals(null) |  address.equals("") | address.equals(null) | cityid.equals("") | cityid.equals(null))) {
                    try {

                        Customer c = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), Integer.parseInt(cityid));
                        City city = (City) Datacontroller.DataParser.getuniqeresault(new City(), Integer.parseInt(cityid));
                        Gender gender = (Gender) Datacontroller.DataParser.getuniqeresault(new Gender(), Integer.parseInt(genderid));

                        c.setCustomerFname(fname);
                        c.setCustomerMname(mname);
                        c.setCustomerLname(lname);
                        c.setCustomerRegDateAndTime(new Date());
                        c.setCity(city);
                        c.setGender(gender);
                        
                        
                        c.setAddress(address);
                        c.setState(true);

              

           

                        boolean Savedata = Datacontroller.DataParser.Savedata(c);
                        System.out.println(Savedata);
                        writer.write("" + Savedata);
                   
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    writer.write("null data");
                }

            } catch (Exception e) {
            }
            response.sendRedirect("profile.jsp");
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
