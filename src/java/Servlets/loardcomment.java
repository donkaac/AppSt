/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import Entities.Comment;
import Entities.Commenthasreply;
import Entities.Developer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class loardcomment extends HttpServlet {

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
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            Application uniqeresault = (Application) Datacontroller.DataParser.getuniqeresault(new  Application(),Integer.parseInt(request.getParameter("appid")));
            Set<Comment> comments = uniqeresault.getComments();
            
           out.write("<div class=\"scrollit\" style=\"width: 1000px\">\n" +
"                                <table class=\"table table-hover\">\n" +
"                                    <thead>\n" +
"                                        <tr>\n" +
"                                            <th>ID</th>\n" +
"                                            <th>Comment</th>\n" +
"                                            <th>Date</th>\n" +
"                                            <th>App ID</th>\n" +
"                                            <th>App Name</th>\n" +
"                                            <th>Category</th>\n" +
"                                            <th>Type</th>\n" +
"                                            <th>Platform</th>\n" +
"                                            <th>Customer ID </th>\n" +
"                                            <th>Customer Name</th>\n" +
"                                            <th></th>\n" +
"                                            <th>Replay ID </th>\n" +
"                                            <th>Reply</th>\n" +                           
"                                            <th></th>\n" +
"                                        </tr>\n" +
"                                    </thead>\n" +
"                                    <tbody>");
            for (Comment comment : comments) {
                if(comment.isState()==state){
                out.write("<tr>");
                out.write("<td>"+comment.getIdComment()+"</td>");
                out.write("<td>"+comment.getComment()+"</td>");
                out.write("<td>"+comment.getCommentDateAndTime()+"</td>");
                out.write("<td>"+comment.getApplication().getIdApplication()+"</td>");
                out.write("<td>"+comment.getApplication().getApplicationName()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getIdcategory()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getApptype().getApptype()+"</td>");
                out.write("<td>"+comment.getApplication().getCategory().getApptype().getAppplatform().getAppplatform()+"</td>");
                out.write("<td>"+comment.getCustomer().getIdCustomer()+"</td>");
                out.write("<td>"+comment.getCustomer().getCustomerFname()+" "+comment.getCustomer().getCustomerLname()+"</td>");
                out.write("<td></td>");
                out.write("<td></td>");
                out.write("<td></td>");
                out.write("<td><input onclick=\"removecomment('"+comment.getIdComment()+"')\"  class=\"btn btn-danger\" type=\"button\" value=\"Remove\"></td>");
                
                out.write("</tr>");
                    Set<Commenthasreply> commenthasreplies = comment.getCommenthasreplies();
                    for (Commenthasreply commenthasreply : commenthasreplies) {
                        if(commenthasreply.isState()){
                        out.write("<tr>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td>"+commenthasreply.getIdcommenthasreply()+"</td>");
                        out.write("<td>"+commenthasreply.getReplyComment()+"</td>");
                        out.write("<td><input onclick=\"removecommentreply("+commenthasreply.getIdcommenthasreply()+")\"  class=\"btn btn-danger\" type=\"button\" value=\"Remove\"></td>");
                        out.write("</tr>");
                        }
                    }
                     out.write("<tr>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td></td>");
                        out.write("<td><input class=\"form-control\" id=\""+comment.getIdComment()+"\" type=\"text\"/></td>");
                     
                        out.write("<td colspan=\"2\"><input onclick=\"addcommentreply("+comment.getIdComment()+")\"  class=\"btn default\" type=\"button\" value=\"Save\"/></td>");
                        out.write("</tr>");
                }
            }
           
           out.write("  </tbody>\n" +
"                                </table>\n" +
"                            </div>");
        }catch(Exception e){
            e.printStackTrace();
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
