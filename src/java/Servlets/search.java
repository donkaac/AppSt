/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class search extends HttpServlet {

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
        PrintWriter writer = response.getWriter();
        try {
               HttpSession s = request.getSession();
               boolean loging=false;
                        if (s.getAttribute("user") != null) {
                            loging = true;
                        }
            /// loard side panel app by id index page in sigle app 
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            String type = request.getParameter("type");
            if(type.equals("appid")){
            int appid = Integer.parseInt(request.getParameter("appid"));
                Application app = (Application) Datacontroller.DataParser.getuniqeresault(new Application(), appid);
                if(loging){ writer.write(
                "<div class=\"col-sm-3\">\n" +
"            <article class=\"col-item\">\n" +
"        		<div  class=\"photo\">\n" +
"        			<div class=\"options\">\n" +
"        				<button class=\"btn btn-default\" onclick=\"addtowishlist("+app.getIdApplication()+")\"  type=\"submit\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Add to wish list\">\n" +
"        					<i class=\"fa fa-heart\"></i>\n" +
"        				</button>\n" +
"        				<button class=\"btn btn-default\" onclick=\"buyapp("+app.getIdApplication()+")\" type=\"submit\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Buy\">\n" +
"        					<i class=\"fa fa-dollar\"></i>\n" +
"        				</button>\n" +
"        			</div>\n" +
"        			<div class=\"options-cart\">\n" +
"        				<button onclick=\"addtocart("+app.getIdApplication()+")\" class=\"btn btn-default\" title=\"Add to cart\">\n" +
"        					<span class=\"fa fa-shopping-cart\"></span>\n" +
"        				</button>\n" +
"        			</div>\n" +
"        			<a href=\"viewapp.jsp?appid="+app.getIdApplication()+"\"> <img src=\""+app.getAppImage()+"\" class=\"img-responsive\" alt=\"Product Image\" /> </a>\n" +
"        		</div>\n" +
"        		<div class=\"info\">\n" +
"        			<div class=\"row\">\n" +
"        				<div class=\"price-details col-md-6\">\n" +
"        					<p class=\"details\">\n" +
"        					"+app.getDescription()+"\n" +
"        					</p>\n" +
"        					<h1>"+app.getApplicationName()+"</h1>\n" +
"        					<span class=\"price-new\">$"+app.getPrice()+"</span>\n" +
"        				</div>\n" +
"        			</div>\n" +
"        		</div>\n" +
"        	</article>\n" +
"        </div>"
                );}else{
                    writer.write("<div class=\"col-sm-3\">\n" +
"            \n" +
"        		<div  class=\"photo\">\n" +
"        			 \n" +
"        			 \n" +
"        			<a href=\"viewapp.jsp?appid="+app.getIdApplication()+"\"> <img src=\""+app.getAppImage()+"\" class=\"img-responsive\" alt=\"Product Image\" /> </a>\n" +
"        		</div>\n" +
"        		<div class=\"info\">\n" +
"        			<div class=\"row\">\n" +
"        				<div class=\"price-details col-md-6\">\n" +
"        					<p class=\"details\">\n" +
"        					"+app.getDescription()+"\n" +
"        					</p>\n" +
"        					<h1>"+app.getApplicationName()+"</h1>\n" +
"        					<span class=\"price-new\">$"+app.getPrice()+"</span>\n" +
"        				</div>\n" +
"        			</div>\n" +
"        		</div>\n" +
"        	 \n" +
"        </div>");
                }
            
            }else if(type.equals("appname")){
                
            }
        } catch (Exception e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
