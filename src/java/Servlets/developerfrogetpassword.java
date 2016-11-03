/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
import Entities.Developer;
import Oparation.Mails;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ish
 */
public class developerfrogetpassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();

        String username = "Guest";
        boolean loging = false;
        Customer cc = new Customer();
        if (request.getSession().equals(null)) {

            response.sendRedirect("login.jsp");
        }
        if (!loging) {
            response.sendRedirect("index.jsp");
        }
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String[][] ar = {{"username", email}};
            ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Developer(), ar);
            boolean ifstate = false;
            Developer c = null;
            for (Object object : Searchdata) {
                c = (Developer) object;
                if (c.getUsername().equals(email)) {
                    ifstate = true;
                    break;
                }
            }
            if (ifstate) {
                String cemail[] = {email};
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY,MM,dd");
                String tdate = simpleDateFormat.format(date);
                String base64encode = Datacontroller.EncryptUtils.base64encode(Datacontroller.EncryptUtils.base64encode(Datacontroller.EncryptUtils.base64encode(c.getIdDeveloper() + "♦" + tdate + "♦developer")));
                try {
                    Mails.sendFromGMail(cemail, "Froget Password Request ", "Froget Password Request for Pin : " + base64encode);
                    out.write("ok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Froget Password");
        } catch (Exception e) {
            e.printStackTrace();
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
