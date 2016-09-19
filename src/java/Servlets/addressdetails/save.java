/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.addressdetails;

import Datacontroller.DataParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ish
 */
public class save extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            String type = request.getParameter("type");
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            System.out.println(state);
            
            if (type.equals("country")) {
                String countryname = request.getParameter("newcountry");
                ArrayList<Object> HQLQuary = DataParser.HQLQuary("FROM Country WHERE countryName='" + countryname + "'");
                if (HQLQuary.isEmpty()) {
                    System.out.println("is new checkd");
                    Country country = new Country();
                    country.setCountryName(countryname);
                    country.setState(true);
                    DataParser.Savedata(country);
                } else {
                   
                    out.write("Allredy Exist!");

                }
            } else if (type.equals("Province")) {
                String provincename = request.getParameter("province");
                String countryname = request.getParameter("country");
                ArrayList<Object> Searchdata = DataParser.Searchdata(new Country());
                if (!Searchdata.isEmpty()) {
                    boolean b = true;
                    for (Object o : Searchdata) {
                        Country c = (Country) o;

                        if ((c.getCountryName().equals(countryname)) & (c.isState())) {
                            System.out.println(c.getCountryName());
                            Object[] toArray = c.getProvinces().toArray();
                            for (Object object : toArray) {
                                Province p = (Province) object;
                                if (p.getProvinceName().equals(provincename)) {
                                    b = false;
                                }
                            }
                            if (b) {
                                Province province = new Province();
                                province.setProvinceName(provincename);
                                province.setState(true);
                                province.setCountry(c);
                                DataParser.Savedata(province);
                            } else {
                                out.write("Allredy Exist!");
                            }
                        }
                    }

                } else {
                    System.out.println("country null");
                }

            } else if (type.equals("District")) {
                String provincename = request.getParameter("province");
                String countryname = request.getParameter("country");
                String newdistrictname = request.getParameter("newdistrict");
                ArrayList<Object> Searchdata = DataParser.Searchdata(new Country());
                if (!Searchdata.isEmpty()) {
                    boolean b = true;
                    for (Object o : Searchdata) {
                        Country c = (Country) o;

                        if ((c.getCountryName().equals(countryname)) & (c.isState())) {
                            System.out.println(c.getCountryName());
                            Object[] provincelist = c.getProvinces().toArray();
                            for (Object object : provincelist) {
                                Province p = (Province) object;
                                if (p.getProvinceName().equals(provincename)) {
                                    Object[] distrcitlist = p.getDiscricts().toArray();
                                    for (Object oo : distrcitlist) {
                                        Discrict d = (Discrict) oo;
                                        if (d.getDiscrictName().equals(newdistrictname)) {
                                            b = false;
                                        }
                                    }
                                    if (b) {
                                        Discrict district = new Discrict();
                                        district.setDiscrictName(newdistrictname);
                                        district.setState(true);
                                        district.setProvince(p);
                                        DataParser.Savedata(district);
                                    } else {
                                        out.write("Allredy Exist!");
                                    }
                                }
                            }

                        }
                    }

                } else {
                    System.out.println("country null");
                }

            } else if (type.equals("City")) {
                String provincename = request.getParameter("province");
                String countryname = request.getParameter("country");
                String districtname = request.getParameter("district");
                String newcityname = request.getParameter("newcity");
                ArrayList<Object> Searchdata = DataParser.Searchdata(new Country());
                if (!Searchdata.isEmpty()) {
                    boolean b = true;
                    for (Object o : Searchdata) {
                        Country c = (Country) o;

                        if ((c.getCountryName().equals(countryname)) & (c.isState()==state)) {
                            System.out.println(c.getCountryName());
                            Object[] provincelist = c.getProvinces().toArray();
                            for (Object object : provincelist) {
                                Province p = (Province) object;
                                if ((p.getProvinceName().equals(provincename))&(p.isState()==state)) {
                                    Object[] distrcitlist = p.getDiscricts().toArray();
                                    for (Object oo : distrcitlist) {
                                        Discrict d = (Discrict) oo;
                                        if ((d.getDiscrictName().equals(districtname))&(d.isState()==state)) {
                                            Object[] citylist = d.getCities().toArray();
                                            for (Object ooo : citylist) {
                                                City ct = (City) ooo;
                                                System.out.println(ct.getCityName());
                                                if (ct.getCityName().equals(newcityname)) {
                                                    b = false;
                                                }
                                            }
                                             if (b) {
                                            City City = new City();
                                            City.setCityName(newcityname);
                                            City.setState(true);
                                            City.setDiscrict(d);
                                            DataParser.Savedata(City);
                                        } else {
                                            out.write("Allredy Exist!");
                                        }    
                                        }
                                       
                                    }

                                }
                            }

                        }
                    }

                } else {
                    System.out.println("country null");
                }

            } else {

            }

        } catch (Exception e) {

        }
    }
}
