/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Entities.Application;
import Entities.Cart;
import Entities.Customer;
import Entities.Wishlist;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Ish
 */
public class test extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {
                 String a1="",a2="",a3="",a4="";
                FileItemFactory f1 = new DiskFileItemFactory();
                ServletFileUpload up = new ServletFileUpload(f1);

                List<FileItem> li = up.parseRequest(request);
                String parameter = request.getParameter("image1");
                System.out.println("image 1 "+parameter);
                String Image_Title = null;
                String fn = null;
                String Image_Path = null;
               
                for (FileItem item : li) {
 
                    if (item.isFormField()) {

                        if (item.getFieldName().equals("image_title")) {

                            Image_Title = item.getString();
                            System.out.println("image tittle ++++===="+Image_Title);
                        }
                        if (item.getFieldName().equals("fn")) {

                            fn = item.getString();

                        }
                        if (item.getFieldName().equals("image1")) {

                            System.out.println("this is work ???"+item.getString());
                            a1=item.getString();
                        }

                    } else {
                          
                             Date date = new Date();
                             long time = date.getTime();
                             Image_Path = "appinterface/"+time+item.getName();
                             System.out.println(item.getName());
                             File f = new File(request.getServletContext().getRealPath("/") + Image_Path);
                             
                             item.write(f);
                             
                           
                         
                        if(parameter==item.getName()){
                              System.out.println("Checking Done this is Path ::"+Image_Path);
                        }
                        
     
                    }
 
                }
                
                Application application = new Application();
              
            } catch (Exception e) {

                throw new ServletException(e);

            }

        }
        Customer c=new Customer();
        Set<Wishlist> wishlists = c.getWishlists();
        for (Wishlist wishlist : wishlists) {
        
            
        }
       
    }
 
}