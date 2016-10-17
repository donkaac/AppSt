/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.City;
import Entities.Country;
import Entities.Discrict;
import Entities.Province;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class getaddressbyid extends HttpServlet {

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
            System.out.println("Respose deactive address ");
            String text = request.getParameter("text");
            int id = Integer.parseInt(request.getParameter("id"));
            String type = request.getParameter("type");
            if (null != type) {
                switch (type) {
                    case "country":
                         {
                            
                            Country country = (Country) Datacontroller.DataParser.getuniqeresault(new Country(), id);
                            System.out.println(country.getCountryName());
                            country.setCountryName(text);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(country);
                            System.out.println("UPDATE NAME ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    case "province":
                        {
                            
                            Province province = (Province) Datacontroller.DataParser.getuniqeresault(new Province(),id);
                            System.out.println(province.getProvinceName());
                            province.setProvinceName(text);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(province);
                            System.out.println("UPDATE NAME ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    case "district":
                        {
                            
                            Discrict discrict = (Discrict) Datacontroller.DataParser.getuniqeresault(new Discrict(),id);
                            System.out.println(discrict.getDiscrictName());
                            discrict.setDiscrictName(text);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(discrict);
                            System.out.println("UPDATE NAME ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    case "city":
                          {
                            
                            City city = (City) Datacontroller.DataParser.getuniqeresault(new City(),id);
                            System.out.println(city.getCityName());
                            city.setCityName(text);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(city);
                            System.out.println("UPDATE NAME ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    default:
                        out.write("else 1st if");
                        break;
                }
            }

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
