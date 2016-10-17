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
                    boolean Savedata = DataParser.Savedata(country);
                    out.write(""+Savedata);
                } else {
                   
                    out.write("Allredy Exist!");

                }
            } else if (type.equals("Province")) {
                   if (!(request.getParameter("country")==null)) {
                String provincename = request.getParameter("province");
                int countryid = Integer.parseInt(request.getParameter("country"));
                Country c = (Country) DataParser.getuniqeresault(new Country(),countryid);
             
                    boolean b = true;
                    
                        
                            System.out.println(c.getCountryName());
                            Object[] toArray = c.getProvinces().toArray();
                            for (Object object : toArray) {
                                Province p = (Province) object;
                                if ((p.getProvinceName().equals(provincename))&(p.getCountry().getIdCountry()==countryid)) {
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
                        
                    

                } else {
                    System.out.println("country null");
                }

            } else if (type.equals("District")) {
                  if (!(request.getParameter("province").equals(null))) {
                int provinceid =Integer.parseInt(request.getParameter("province"));
                int countryid = Integer.parseInt(request.getParameter("country"));
                String newdistrictname = request.getParameter("newdistrict");
                Province provi = (Province) DataParser.getuniqeresault(new Province(),provinceid);
              
                      Set<Discrict> discricts = provi.getDiscricts();
                    boolean b = true;
                    for (Discrict d : discricts) {
                                        if ((d.getDiscrictName().equals(newdistrictname))&(d.getProvince().getIdprovince()==provinceid)&(d.getProvince().getCountry().getIdCountry()==countryid)) {
                                            b = false;
                                            System.out.println("save district if fail");
                                        }
                                    }
                 
                                    if (b) {
                                        Discrict district = new Discrict();
                                        district.setDiscrictName(newdistrictname);
                                        district.setState(true);
                                        district.setProvince(provi);
                    boolean Savedata = DataParser.Savedata(district);
                    out.write(""+Savedata);
                                    } else {
                                        out.write("Allredy Exist!");
                                    }
                                
                            

                        
                    

                } else {
                    System.out.println("country null");
                }

            } else if (type.equals("City")) {
                    if (!request.getParameter("district").equals(null)) {
                int provinceid = Integer.parseInt(request.getParameter("province"));
                int countryid = Integer.parseInt(request.getParameter("country"));
                int districtid = Integer.parseInt(request.getParameter("district"));
                String newcityname = request.getParameter("newcity");
               Discrict discrict = (Discrict) DataParser.getuniqeresault(new Discrict(),districtid);
            
                    boolean b = true;
                        Set<City> cities = discrict.getCities();
                                            for (City ct : cities) {
                                                
                                                System.out.println(ct.getCityName());
                                                if ((ct.getCityName().equals(newcityname)&(ct.getDiscrict().getIdDiscrict()==districtid)&(ct.getDiscrict().getProvince().getIdprovince()==provinceid)&(ct.getDiscrict().getProvince().getCountry().getIdCountry()==countryid))) {
                                                    b = false;
                                                }
                                            }
                                             if (b) {
                                            City City = new City();
                                            City.setCityName(newcityname);
                                            City.setState(true);
                                            City.setDiscrict(discrict);
                                            DataParser.Savedata(City);
                                        } else {
                                            out.write("Allredy Exist!");
                                        }    
                                        
                                   
                         

                        
                     

                } else {
                    System.out.println("country null");
                }

            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    }
