/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Entities.Application;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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
                            
                        }
                        if (item.getFieldName().equals("fn")) {

                            fn = item.getString();

                        }

                    } else {
    String[] split = item.getName().split(".");
                        Image_Path = "appinterface/"+i+""+item.getName();
                        System.out.println(item.getName());
                        File f = new File(request.getServletContext().getRealPath("/") + Image_Path);
                         
                        item.write(f);

                       out.write(Image_Title + "','" + Image_Path+" "+fn);
 
                    }
if(i==4){i=0;}
                }
                
                Application application = new Application();

            } catch (Exception e) {

                throw new ServletException(e);

            }

        }
    }
 
}