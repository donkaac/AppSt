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
public class categoryupdatebyid extends HttpServlet {

   
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
             
            String text = request.getParameter("text");
            String type = request.getParameter("type");
            System.out.println(type + " " + text);
            
             switch (type) {
                 case "platform":
                     try {
                         Appplatform uniqeresault = (Appplatform) Datacontroller.DataParser.getuniqeresault(new Appplatform(), Integer.parseInt(request.getParameter("id")));
                         uniqeresault.setAppplatform(text);
                         boolean UpdateData = DataParser.UpdateData(uniqeresault);
                         out.write(""+UpdateData);
                         System.out.println(UpdateData);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }    break;
                 case "type":
                     try {
                         Apptype uniqeresault = (Apptype) DataParser.getuniqeresault(new Apptype(), Integer.parseInt(request.getParameter("id")));
                         uniqeresault.setApptype(text);
                         boolean UpdateData = DataParser.UpdateData(uniqeresault);
                         out.write(""+UpdateData);
                         System.out.println(UpdateData);
                     } catch (Exception e) {
                     }    break;
                 case "category":
                     try {
                         Category uniqeresault = (Category) DataParser.getuniqeresault(new Category(),Integer.parseInt(request.getParameter("id")));
                         uniqeresault.setCategory(text);
                         boolean UpdateData = DataParser.UpdateData(uniqeresault);
                         out.write(""+UpdateData);
                         System.out.println(UpdateData);
                     } catch (Exception e) {
                     }    break;
                 default:
                     out.write("ERROR");
                     break;
             }
            
         }catch(Exception e){
             
         }
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
