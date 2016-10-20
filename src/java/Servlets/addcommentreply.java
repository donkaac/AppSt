/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Comment;
import Entities.Commenthasreply;
import Entities.Developer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
@WebServlet(name = "addcommentreply", urlPatterns = {"/addcommentreply"})
public class addcommentreply extends HttpServlet {
 
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
            if(!(null == request.getParameter("commentid"))||(request.getParameter("text") == null)){
                System.out.println("If True");
                Commenthasreply commenthasreply = new Commenthasreply();
                Comment comment = (Comment) Datacontroller.DataParser.getuniqeresault(new Comment(), Integer.parseInt(request.getParameter("commentid")));
                Developer developer = (Developer) request.getSession().getAttribute("developer");
                developer = (Developer) Datacontroller.DataParser.getuniqeresault(new Developer(), developer.getIdDeveloper());
                commenthasreply.setComment(comment);
                commenthasreply.setState(true);
                commenthasreply.setReplyComment(request.getParameter("text"));
                commenthasreply.setDeveloper(developer);
                boolean Savedata = Datacontroller.DataParser.Savedata(commenthasreply);
                out.write(""+Savedata);
            } else {
            }
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
