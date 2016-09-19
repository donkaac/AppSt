/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.addressdetails;

import Datacontroller.DataParser;
import Entities.Developinglanguages;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.*;

/**
 *
 * @author Ish
 */
public class loard extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            String type = request.getParameter("type");
            System.out.println(type + " " + state);
            if ("country".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new Country());
                    out.write("<option>Select Country</option>");

                    for (Object resualt : Searchdata) {
                        Country c = (Country) resualt;
                        if (c.isState() == state) {
                            out.write("<option>" + c.getCountryName() + "</option>");
                        }
                    }
                } catch (Exception e) {
                }
            } else if ("Province".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new Province());

                    boolean b = true;
                    for (Object resualt : Searchdata) {

                        Province p = (Province) resualt;

                        if (p.isState() == state) {
                            if ((p.isState()==state)&(p.getCountry().getCountryName().equals(request.getParameter("country")))) {
                                if (b) {
                                    out.write("<option>Select Province</option>");
                                    b = false;
                                }
                                out.write("<option>" + p.getProvinceName() + "</option>");
                            }
                        }
                    }
                } catch (Exception e) {
                }

            } else if ("district".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new Discrict());
   boolean b = true;
                   
                    for (Object resualt : Searchdata) {

                        Discrict d = (Discrict) resualt;

                        if (d.isState() == state) {
                            if ((d.getProvince().getCountry().isState()==state)&(d.getProvince().getCountry().getCountryName().equals(request.getParameter("country")))) {
                                if ((d.isState()==state)&(d.getProvince().getProvinceName().equals(request.getParameter("province")))) {
                                    if(b){ out.write("<option>Select District</option>");
                                    b=false;
                                    }
                                    out.write("<option>" + d.getDiscrictName() + "</option>");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                }

            } else if ("city".equals(type)) {
                System.out.println(type);
                try {
                    ArrayList<Object> Searchdata = DataParser.Searchdata(new City());
   boolean b = true;
                  

                    for (Object resualt : Searchdata) {

                        City d = (City) resualt;

                        if (d.isState() == state) {
                            if ((d.getDiscrict().getProvince().getCountry().isState()==state)&(d.getDiscrict().getProvince().getCountry().getCountryName().equals(request.getParameter("country")))) {
                                if ((d.getDiscrict().getProvince().isState()==state)&(d.getDiscrict().getProvince().getProvinceName().equals(request.getParameter("province")))) {
                                    if ((d.getDiscrict().isState()==state)&(d.getDiscrict().getDiscrictName().equals(request.getParameter("district")))) {
                                        if(b){
                                          out.write("<option>Select City</option>");
                                          b=false;
                                        }
                                        out.write("<option>" + d.getCityName() + "</option>");
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                }

            } else {
                System.out.println("else" + state);
            }

        }
    }

}
