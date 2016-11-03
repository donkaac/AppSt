/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Customer;
import Entities.Developer;
import Entities.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ish
 */
public class frogotpasschange extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!request.getParameter("token").isEmpty()) {
            String token = request.getParameter("token");
            String tokendencode = Datacontroller.EncryptUtils.base64decode(Datacontroller.EncryptUtils.base64decode(Datacontroller.EncryptUtils.base64decode(token)));
            System.out.println("token decoded =="+tokendencode);
            String[] split = tokendencode.split("♦");
            int id=Integer.parseInt(split[0]);
        
           String date= split[1];
           String type= split[2];
           
            Date odate = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy,MM,dd");
                String tdate = simpleDateFormat.format(odate);
           boolean sendlogin=false;
            System.out.println("Date --"+date+" Da_=-"+tdate);
          if(date.equals(tdate)){
              System.out.println("Type ------ "+type);
               if("staff".equals(type)){
                Staff staff = (Staff) Datacontroller.DataParser.getuniqeresault(new Staff(), id);
                String pass=request.getParameter("pass1");
                staff.setStaffPassword(Datacontroller.EncryptUtils.base64encode(pass));
               sendlogin= Datacontroller.DataParser.UpdateData(staff);
                response.sendRedirect("admin/login.jsp");
           }else if("developer".equals(type)){
            Developer developer =  (Developer) Datacontroller.DataParser.getuniqeresault(new Developer(), id);
            String pass=request.getParameter("pass1");
            developer.setPassword(Datacontroller.EncryptUtils.base64encode(pass));
           sendlogin= Datacontroller.DataParser.UpdateData(developer);
            response.sendRedirect("developer/login.jsp");
           }else if("customer".equals(type)){
              Customer customer= (Customer) Datacontroller.DataParser.getuniqeresault(new Customer(), id);
              String pass=request.getParameter("pass1");
              customer.setPassword(Datacontroller.EncryptUtils.base64encode(pass));
            sendlogin=  Datacontroller.DataParser.UpdateData(customer);
             response.sendRedirect("login.jsp");
           }
               
                  
             
          }else{
             response.getWriter().write("date error"); // pin code exprired
          }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
