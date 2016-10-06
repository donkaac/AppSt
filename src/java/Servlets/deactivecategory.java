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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class deactivecategory extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
            
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            String type = request.getParameter("type");
            System.out.println(type + " " + state);
            
            if(type.equals("platform")){
                try {
                     Appplatform uniqeresault = (Appplatform) Datacontroller.DataParser.getuniqeresault(new Appplatform(), Integer.parseInt(request.getParameter("platformid")));
               uniqeresault.setState(state);
                boolean UpdateData = DataParser.UpdateData(uniqeresault);
                out.write(""+UpdateData);
                System.out.println(UpdateData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(type.equals("apptype")){
                try {
                    Apptype uniqeresault = (Apptype) DataParser.getuniqeresault(new Apptype(), Integer.parseInt(request.getParameter("typeid")));
                uniqeresault.setState(state);
                boolean UpdateData = DataParser.UpdateData(uniqeresault);
                out.write(""+UpdateData);
                System.out.println(UpdateData);
                } catch (Exception e) {
                }
            }else if(type.equals("category")){
                try {
                     Category uniqeresault = (Category) DataParser.getuniqeresault(new Category(),Integer.parseInt(request.getParameter("categoryid")));
                uniqeresault.setState(state);
                boolean UpdateData = DataParser.UpdateData(uniqeresault);
                out.write(""+UpdateData);
                    System.out.println(UpdateData);
                } catch (Exception e) {
                }
            }else{
                out.write("ERROR");
            }
            
         }catch(Exception e){
             
         }
    }
 
}
