/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.addressdetails;

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
                            out.write("<option value='"+c.getIdCountry()+"'>" + c.getCountryName() + "</option>");
                        }
                    }
                } catch (Exception e) {
                }
            } else if ("Province".equals(type)) {
                System.out.println(type);
                try {
                    Country Searchdata = (Country) DataParser.getuniqeresault(new Country(),Integer.parseInt(request.getParameter("country")));

                    boolean b = true;
                    Set<Province> provinces = Searchdata.getProvinces();
                    for (Province p : provinces) {

                      

                        if (p.isState() == state) {
                            if (p.isState()==state) {
                                if (b) {
                                    out.write("<option>Select Province</option>");
                                    b = false;
                                }
                                out.write("<option value='"+p.getIdprovince()+"'>" + p.getProvinceName() + "</option>");
                            }
                        }
                    }
                } catch (Exception e) {
                }

            } else if ("district".equals(type)) {
                System.out.println(type);
                try {
                    Province Searchdata = (Province) DataParser.getuniqeresault(new Province(),Integer.parseInt(request.getParameter("province")));
   boolean b = true;
                    Set<Discrict> discricts = Searchdata.getDiscricts();
                    for (Discrict d : discricts) {

                        if (d.isState() == state) {
                            if ((d.getProvince().getCountry().isState()==state)&(d.getProvince().isState()==state)) {
                                if ((d.isState()==state)) {
                                    if(b){ out.write("<option>Select District</option>");
                                    b=false;
                                    }
                                    out.write("<option value='"+d.getIdDiscrict()+"'>" + d.getDiscrictName() + "</option>");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if ("city".equals(type)) {
                System.out.println(type);
                try {
                   Discrict Searchdata =  (Discrict) DataParser.getuniqeresault(new Discrict(),Integer.parseInt(request.getParameter("district")));
   boolean b = true;
                    Set<City> cities = Searchdata.getCities();

                    for (City d : cities) {

                      
                        System.out.println(d.getCityName());
                        if (d.isState() == state) {
                            if ((d.getDiscrict().getProvince().getCountry().isState()==state)) {
                                if ((d.getDiscrict().getProvince().isState()==state)) {
                                    if ((d.getDiscrict().isState()==state)) {
                                        if(b){
                                          out.write("<option>Select City</option>");
                                          b=false;
                                        }
                                        out.write("<option  value="+d.getIdCity()+">" + d.getCityName() + "</option>");
                                    }
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
