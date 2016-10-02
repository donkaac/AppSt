/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Datacontroller.EncryptUtils;
import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class coustomerlogin extends HttpServlet {
 
   
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
             String email = request.getParameter("username");
            String password = request.getParameter("password");
               Cookie[] cookies = request.getCookies();
           System.out.println(request.getParameter("remember"));
            
            System.out.println(email+""+password);
            boolean loginstate=false;
            Customer c=null;
            String [][]ar={{"username",email},{"password",password}};
            ArrayList<Object> Searchdata = DataParser.Searchdata(new Customer(),ar);
            for (Object customer : Searchdata) {
                 c=(Customer) customer;
                System.out.println(c.getPassword()+c.getUsername());
             if((c.getUsername().equals(email))&(c.getPassword().equals(Datacontroller.EncryptUtils.base64encode(password)))&(c.isState()==true)){loginstate=true; break;}
            }
            if (loginstate) {
                if(request.getParameter("remember").equals("1")){
                    System.out.println("Set cokies");
                     Cookie usernameCookie = new Cookie("username-cookie", email);
                Cookie passwordCookie = new Cookie("password-cookie", password);
                usernameCookie.setMaxAge(24 * 60 * 60);
                passwordCookie.setMaxAge(24 * 60 * 60);
                usernameCookie.setHttpOnly(true);
                passwordCookie.setHttpOnly(true);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                }else{
              
                    System.out.println("no coikes");
                    try {
                        
                        
                     Cookie usernameCookie = new Cookie("username-cookie", "");
                Cookie passwordCookie = new Cookie("password-cookie", "");
                usernameCookie.setMaxAge(1);
                passwordCookie.setMaxAge(1);
                usernameCookie.setHttpOnly(true);
                passwordCookie.setHttpOnly(true);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            
        
                }
                try {
                    HttpSession s= request.getSession();
                        s.setAttribute("userid",c.getIdCustomer());
                        s.setAttribute("username", c.getUsername());
                        s.setAttribute("usertype", "costomer");
                } catch (Exception e) {
                    System.out.println("exception");
                    e.printStackTrace(); 
                }
                        
                        
                  out.print("ok");
                  System.out.println("ok");
            }else{
                out.print("error");
                System.out.println("error");
            }
        
    }catch(Exception e){
            
            response.getWriter().write(e.getMessage());
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
