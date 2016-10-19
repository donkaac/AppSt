/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Developer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.faces.context.ResponseWriter;
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
public class developerlogin extends HttpServlet {
 
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
            String remember = "";
            if (request.getParameter("remember") != null) {
                remember = request.getParameter("remember");
            } else {
                remember = "0";
            }

            System.out.println(email + "" + password);
            boolean loginstate = false;
            Developer c = null;
            String[][] ar = {{"username", email}, {"password", Datacontroller.EncryptUtils.base64encode(password)}};
            ArrayList<Object> Searchdata = DataParser.Searchdata(new Developer(), ar);
            for (Object deObject : Searchdata) {
                c = (Developer) deObject;
                System.out.println(c.getPassword() + c.getUsername());
                if ((c.getUsername().equals(email)) & (c.getPassword().equals(Datacontroller.EncryptUtils.base64encode(password))) & (c.isState() == true)) {
                    loginstate = true;
                    break;
                }
            }
            if(loginstate){
             if (remember.equals("1")) {
                    System.out.println("Set cokies");
                    Cookie usernameCookie = new Cookie("username-cookie", email);
                    Cookie passwordCookie = new Cookie("password-cookie", password);
                    usernameCookie.setMaxAge(24 * 60 * 60);
                    passwordCookie.setMaxAge(24 * 60 * 60);
                    usernameCookie.setHttpOnly(true);
                    passwordCookie.setHttpOnly(true);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                } else if (remember.equals("0")) {
                    Cookie cookie = null;
                    Cookie[] cookiess = request.getCookies();
                    if (cookies != null) {
                        System.out.println("<h2> Found Cookies Name and Value</h2>");
                        for (int i = 0; i < cookiess.length; i++) {
                            cookie = cookies[i];
                            if (cookie.getName().equals("username-cookie") || cookie.getName().equals("password-cookie")) {
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                            } else {
                                System.out.println("NOT Found");
                            }

                        }
                    }
                }
              

            
            try {
                HttpSession s = request.getSession();
                s.setAttribute("developer", c);
//                s.setAttribute("userid", c.getIdDeveloper());
//                s.setAttribute("username", c.getUsername());
                s.setAttribute("usertype", "developer");
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

    }
    catch(Exception e

    
        ){
            
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
