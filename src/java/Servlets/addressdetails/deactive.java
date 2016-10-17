/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.addressdetails;

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
public class deactive extends HttpServlet {

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
            System.out.println("Respose deactive address ");
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            String type = request.getParameter("type");
            if (null != type) {
                switch (type) {
                    case "country":
                        if (!(request.getParameter("countryid") == null)) {
                            
                            Country country = (Country) Datacontroller.DataParser.getuniqeresault(new Country(), Integer.parseInt(request.getParameter("countryid")));
                            System.out.println(country.getCountryName());
                            country.setState(state);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(country);
                            System.out.println("UPDATE ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    case "province":
                        if (!(request.getParameter("provinceid") == null)) {
                            
                            Province province = (Province) Datacontroller.DataParser.getuniqeresault(new Province(), Integer.parseInt(request.getParameter("provinceid")));
                            System.out.println(province.getProvinceName());
                            province.setState(state);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(province);
                            System.out.println("UPDATE ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    case "district":
                        if (!(request.getParameter("districtid") == null)) {
                            
                            Discrict discrict = (Discrict) Datacontroller.DataParser.getuniqeresault(new Discrict(), Integer.parseInt(request.getParameter("districtid")));
                            System.out.println(discrict.getDiscrictName());
                            discrict.setState(state);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(discrict);
                            System.out.println("UPDATE ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    case "city":
                        if (!(request.getParameter("cityid") == null)) {
                            
                            City city = (City) Datacontroller.DataParser.getuniqeresault(new City(), Integer.parseInt(request.getParameter("cityid")));
                            System.out.println(city.getCityName());
                            city.setState(state);
                            boolean UpdateData = Datacontroller.DataParser.UpdateData(city);
                            System.out.println("UPDATE ::::::" + UpdateData);
                            out.write("" + UpdateData);
                        }   break;
                    default:
                        out.write("else 1st if");
                        break;
                }
            }

        }

    }

}
