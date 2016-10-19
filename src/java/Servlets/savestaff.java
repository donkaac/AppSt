/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datacontroller.DataParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ish
 */
public class savestaff extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            if ((request.getParameter("pass2")) == null ? request.getParameter("pass1") == null : (request.getParameter("pass2")).equals(request.getParameter("pass1"))) {
                Staff staff = new Staff();
                staff.setStaffFname(request.getParameter("fname"));
                staff.setStaffMname(request.getParameter("mname"));
                staff.setStaffLname(request.getParameter("lname"));
                staff.setUsername(request.getParameter("email"));
                staff.setStaffPassword(Datacontroller.EncryptUtils.base64encode(request.getParameter("pass1")));

                int cityid = Integer.parseInt(request.getParameter("city"));
                City city = (City) DataParser.getuniqeresault(new City(), cityid);
                Gender gender = (Gender) DataParser.getuniqeresault(new Gender(), Integer.parseInt(request.getParameter("gender")));
                Roles role = (Roles) DataParser.getuniqeresault(new Roles(), Integer.parseInt(request.getParameter("role")));
                staff.setGender(gender);
                staff.setRoles(role);
                staff.setCity(city);
                staff.setAddress(request.getParameter("address"));
                staff.setStaffRegDateAndTime(new Date());
                staff.setState(true);
                String EmailValidationCode = Oparation.EmailValidationCodeGenaration.EmailValidationCode();
                Emailvarified emailvarified=new Emailvarified(staff.getUsername(),EmailValidationCode);
                String []mail={staff.getUsername()};
                Oparation.Mails.sendFromGMail(mail, "Email Varification Code", EmailValidationCode);
                staff.setEmailvarified(emailvarified);
                boolean email = DataParser.Savedata(emailvarified);
                boolean Savedata = DataParser.Savedata(staff);
           
               
                writer.write("" +(email&Savedata));
            }else{
                writer.write("Match Password");
            }
        } catch (Exception e) {
        }
    }

}
