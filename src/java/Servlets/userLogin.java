/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Datacontroller.*;
import Entities.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Ish
 */
public class userLogin extends HttpServlet {

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
             String email = request.getParameter("username");
            String password = request.getParameter("password");
            
            System.out.println(email+""+password);
            boolean loginstate=false;
            Customer c=null;
            String [][]ar={{"username",email},{"password",password}};
            ArrayList<Object> Searchdata = DataParser.Searchdata(new Customer(),ar);
            for (Object customer : Searchdata) {
                 c=(Customer) customer;
                if((c.getUsername().equals(email))&(c.getPassword().equals(password))&(c.isState()==true)){loginstate=true;}
            }
            if (loginstate) {
                HttpSession s= request.getSession();
                        s.setAttribute("userid",c.getIdCustomer());
                        s.setAttribute("username", c.getUsername());
                       
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
