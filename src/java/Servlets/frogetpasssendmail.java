/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import Entities.Customer;
import Entities.Emailvarified;
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
public class frogetpasssendmail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession();

        
        
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String[][] ar = {{"username", email}};
            ArrayList<Object> Searchdata = Datacontroller.DataParser.Searchdata(new Customer(), ar);
            boolean ifstate = false;
            Customer c = null;
            for (Object object : Searchdata) {
                c = (Customer) object;
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
                String base64encode = Datacontroller.EncryptUtils.base64encode(Datacontroller.EncryptUtils.base64encode(Datacontroller.EncryptUtils.base64encode(c.getIdCustomer() + "♦" + tdate + "♦customer")));
                try {
                    Mails.sendFromGMail(cemail, "Froget Password Request ", "Froget Password Request for Pin : " + base64encode+" Go to this Link::<a href=' http://localhost:8080/AppSt/frogetpasswordchange.jsp'>Click here</a>");
              out.write("ok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Froget Password");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
