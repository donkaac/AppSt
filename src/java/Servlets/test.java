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
                
                String Image_Title = null;
                String fn = null;
                String Image_Path = null;
                int i=0;
                for (FileItem item : li) {
++i;
                    if (item.isFormField()) {

                        if (item.getFieldName().equals("image_title")) {

                            Image_Title = item.getString();
                            System.out.println("image tittle ++++===="+Image_Title);
                        }
                        if (item.getFieldName().equals("fn")) {

                            fn = item.getString();

                        }
                        if (item.getFieldName().equals("image_file1")) {

                            System.out.println("this is work ???"+item.getString());

                        }

                    } else {
                        
                        Image_Path = "appinterface/"+i+""+item.getName();
                        System.out.println(item.getName());
                        File f = new File(request.getServletContext().getRealPath("/") + Image_Path);
                         
                        item.write(f);
    switch (i) {
        case 1:
            a4=Image_Path;
            break;
        case 2:
            a3=Image_Path;
            break;
        case 3:
            a2=Image_Path;
            break;
        case 4:
            a1=Image_Path;
            break;
        default:
            break;
    }
                        System.out.println("");
                       out.write(Image_Title + "','" + Image_Path+" "+fn);
                       
                    }
if(i==4){i=0;}
                }
                
                Application application = new Application();
                System.out.println("Image 1 ="+a1);
                System.out.println("Image 2 ="+a2);
                System.out.println("Image 3 ="+a3);
                System.out.println("Image 4 ="+a4);
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