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
                            out.write("<option>" + c.getAppplatform() + "</option>");
                        }
                    }
                } catch (Exception e) {
                }
            } else if ("apptype".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new Apptype());

                    boolean b = true;
                    for (Object resualt : Searchdata) {

                        Apptype p = (Apptype) resualt;

                        if (p.isState() == state) {
                            if ((p.isState() == state) & (p.getAppplatform().getAppplatform().equals(request.getParameter("Appplatform")))) {
                                if (b) {
                                    out.write("<option>Select Province</option>");
                                    b = false;
                                }
                                out.write("<option>" + p.getApptype() + "</option>");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if ("appcategory".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new Category());
                    boolean b = true;

                    for (Object resualt : Searchdata) {

                        Category d = (Category) resualt;

                        if (d.isState() == state) {
                            if ((d.getApptype().getAppplatform().isState() == state) & (d.getApptype().getAppplatform().getAppplatform().equals(request.getParameter("Appplatform")))) {
                                if ((d.isState() == state) & (d.getApptype().getApptype().equals(request.getParameter("apptype")))) {
                                    if (b) {
                                        out.write("<option>Select app Category</option>");
                                        b = false;
                                    }
                                    out.write("<option>" + d.getCategory() + "</option>");
                                }
                            }
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
