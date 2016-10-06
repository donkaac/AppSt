/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class loardcat extends HttpServlet {

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

            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            String type = request.getParameter("type");
            System.out.println(type + " " + state);
            if ("Appplatform".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new Appplatform());
                    out.write("<option>Select Appplatform</option>");

                    for (Object resualt : Searchdata) {
                        Appplatform c = (Appplatform) resualt;
                        if (c.isState() == state) {
                            out.write("<option value='"+c.getIdAppplatform()+"'>" + c.getAppplatform() + "</option>");
                            System.out.println(c.getAppplatform());
                        }
                    }
                } catch (Exception e) {
                }
            } else if ("apptype".equals(type)) {
                System.out.println(type);
                try {
                   Appplatform c = (Appplatform) DataParser.getuniqeresault(new Appplatform(), Integer.parseInt(request.getParameter("Appplatform")));

                    boolean b = true;
                    Set<Apptype> apptypes = c.getApptypes();
                    for (Apptype p  : apptypes) {

                         

                        if (p.isState() == state) {
                            if (p.isState() == state ) {
                                if (b) {
                                    out.write("<option>Select App Type</option>");
                                    b = false;
                                }
                                System.out.println(p.getApptype());
                                out.write("<option value='"+p.getIdApptype()+"'>" + p.getApptype() + "</option>");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if ("appcategory".equals(type)) {
                System.out.println(type);
                try {
                 Apptype Searchdata=(Apptype) DataParser.getuniqeresault(new Apptype(),Integer.parseInt(request.getParameter("apptype")));
                    boolean b = true;
                    
                    for (Category d : Searchdata.getCategories()) {
 
                        if (d.isState() == state) {
                            System.out.println(d.getCategory());
                             
                                    if (b) {
                                        out.write("<option>Select app Category</option>");
                                        b = false;
                                    }
                                    out.write("<option value='"+d.getIdcategory()+"'>" + d.getCategory() + "</option>");
                                
                            
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("else" + state);
            }

        }
    }

}
