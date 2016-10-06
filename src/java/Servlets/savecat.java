/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Appplatform;
import Entities.Apptype;
import Entities.Category;
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
public class savecat extends HttpServlet {

 
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

            String type = request.getParameter("type");
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            System.out.println(state);
            
            if (type.equals("platform")) {
                String appplatformname = request.getParameter("newplatform");
                ArrayList<Object> HQLQuary = DataParser.HQLQuary("FROM Appplatform WHERE appplatform='" + appplatformname + "'");
                if (HQLQuary.isEmpty()) {
                    System.out.println("is new checkd");
                    Appplatform applat = new Appplatform();
                    applat.setAppplatform(appplatformname);
                    applat.setState(true);
                    DataParser.Savedata(applat);
                } else {
                   
                    out.write("Allredy Exist!");

                }
            } else if (type.equals("apptype")) {
                System.out.println("apptype");
                String apptype = request.getParameter("newapptype");
                String appplatform = request.getParameter("appplatform");
                System.out.println(appplatform+" "+apptype);
                Appplatform c = (Appplatform) DataParser.getuniqeresault(new Appplatform(), Integer.parseInt(appplatform));
                if (!c.equals(null)) {
                    boolean b = true;
                  
                       

                        if ((c.isState()==state)) {
                            System.out.println(c.getAppplatform());
                            Object[] toArray = c.getApptypes().toArray();
                            for (Object object : toArray) {
                                Apptype p = (Apptype) object;
                                if (p.getApptype().equals(apptype)) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                Apptype apptypes = new Apptype();
                                apptypes.setApptype(apptype);
                                apptypes.setState(true);
                                apptypes.setAppplatform(c);
                                DataParser.Savedata(apptypes);
                            } else {
                                out.write("Allredy Exist!");
                            }
                        }
                    

                } else {
                    System.out.println("appplatform null");
                }

            }else if(type.equals("category")) {
                int apptype = Integer.parseInt(request.getParameter("apptype"));
                String appplatform = request.getParameter("appplatform");
                String newcategory = request.getParameter("newcategory");
               Appplatform c = (Appplatform) DataParser.getuniqeresault(new Appplatform(), Integer.parseInt(appplatform));
                if (!c.equals(null)) {
                    boolean b = true;
              

                        if (c.isState()==state) {
                            System.out.println(c.getAppplatform());
                            Object[] provincelist = c.getApptypes().toArray();
                            for (Object object : provincelist) {
                                Apptype p = (Apptype) object;
                                if ((p.getIdApptype()==apptype)&(p.isState()==state)) {
                                    Object[] distrcitlist = p.getCategories().toArray();
                                    for (Object oo : distrcitlist) {
                                        Category d = (Category) oo;
                                        if (d.getCategory().equals(newcategory)) {
                                            b = false;
                                            break;
                                        }
                                    }
                                    if (b) {
                                        Category district = new Category();
                                        district.setCategory(newcategory);
                                        district.setState(true);
                                        district.setApptype(p);
                                        DataParser.Savedata(district);
                                    } else {
                                        out.write("Allredy Exist!");
                                    }
                                }
                            }

                        }
                    

                } else {
                    System.out.println("Type null");
                }

            } else {

            }

        } catch (Exception e) {

        }
    }
 
}
