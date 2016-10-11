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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class updatecustomerdata extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            try {
                System.out.println("request revice");
                PrintWriter writer = response.getWriter();
                String fname = request.getParameter("fname");
                String mname = request.getParameter("mname");
                String lname = request.getParameter("lname");
                String address = request.getParameter("address");
                String cityid = request.getParameter("citylist");
                System.out.println(fname+mname+lname+address+cityid);
                
                HttpSession s = request.getSession();
                int cusid = Integer.parseInt(s.getAttribute("userid").toString());
                System.out.println("Customer ID :"+cusid+" "+fname);
                if (!(fname == null | mname == null |  lname == null | address.equals("") | address == null | cityid.equals("") | cityid == null)) {
                    try {
                        Customer c = (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), cusid);
                      
                        City city = (City) Datacontroller.DataParser.getuniqeresault(new City(), Integer.parseInt(cityid));
                        System.out.println(city.getCityName());
                       
                        c.setCustomerFname(fname);
                        c.setCustomerMname(mname);
                        c.setCustomerLname(lname);
                        c.setCustomerRegDateAndTime(new Date());
                        c.setCity(city);
                        
                        c.setAddress(address);
                        c.setState(true);
                        boolean Savedata = Datacontroller.DataParser.UpdateData(c);
                        System.out.println(Savedata);
                        writer.write("" + Savedata);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("null data");
                    writer.write("null data");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
