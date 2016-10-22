/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Application;
import Entities.Category;
import Entities.Developer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ish
 */
@WebServlet(name = "saveapp", urlPatterns = {"/saveapp"})
public class saveapp extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 100 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;
    private String fileurl;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        isMultipart = ServletFileUpload.isMultipartContent(request);
        String appname = null;
        String description = null;
        String usermanualurl = null;
        String videourl = null;
        Double price = 0.0;
        String appcatlist = null;

        try {

            PrintWriter out = response.getWriter();

            if (!isMultipart) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>No file uploaded</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("c:\\upload"));

            ServletFileUpload upload = new ServletFileUpload(factory);
            List l = new ArrayList();

            try {
                // Parse the request to get file items.
                List fileItems = upload.parseRequest(request);

                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");

                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        // Write the file

                        if (fileName.lastIndexOf("\\") >= 0) {
                            fileurl = filePath + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("\\"));
                            file = new File(fileurl);
                        } else {
                            fileurl = filePath + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("\\") + 1);
                            file = new File(fileurl);
                        }

                        if (!fileName.isEmpty()) {
                            fi.write(file);
                            l.add(fileurl);
                            out.println("Uploaded Filename: " + fileName + "<br>");
                        }

                    }

                    if (fi.isFormField()) {
                        String inputName = (String) fi.getFieldName();

                        switch (inputName) {
                            case "appname":
                                appname = fi.getString();
                                break;
                            case "description":
                                description = fi.getString();
                                break;
                            case "usermanualurl":
                                usermanualurl = fi.getString();
                                break;
                            case "videourl":
                                videourl = fi.getString();
                                break;
                            case "price":
                                price = Double.parseDouble(fi.getString());
                                break;
                            case "appcategorylist":
                                appcatlist = fi.getString();
                                break;
                            default:
                                break;
                        }

                    }
                }

                if (appname != null & description != null & usermanualurl != null & videourl != null & price > 0.0 & appcatlist != null) {
                    Category category = (Category) Datacontroller.DataParser.getuniqeresault(new Category(), Integer.parseInt(appcatlist));
                    Developer developer = (Developer) request.getSession().getAttribute("developer");
                    int developerid = developer.getIdDeveloper();
                    developer = (Developer) Datacontroller.DataParser.getuniqeresault(new Developer(), developerid);
                    
                    Application app = new Application();
                    app.setApplicationName(appname);
                    app.setPrice(price);
                    app.setDescription(description);
                    app.setUserManualUrl(usermanualurl);
                    app.setVideoUrl(videourl);
                    app.setInterface1((String)l.get(2));
                    app.setInterface2((String)l.get(3));
                    app.setInterface3((String)l.get(4));
                    app.setDeveloper(developer);
                    app.setApplicationLuanchDate(new Date());
                    app.setState(true);
                    app.setCategory(category);
                    app.setAppurl((String)l.get(0));
                    app.setAppImage((String)l.get(1));
                    
                    boolean Savedata = Datacontroller.DataParser.Savedata(app);
                    
                    if (Savedata) {
                        System.out.println("OKKKKKKKKKKKKKKKKKK");
                    }
                    
                      
                }
                /*System.out.println(appname);
                System.out.println(description);
                System.out.println(usermanualurl);
                System.out.println(videourl);
                System.out.println(price);
                System.out.println(appcatlist);*/

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (Object name : l) {
                System.out.println(name);
            }

            out.println("</body>");
            out.println("</html>");

            /*Category category = (Category) Datacontroller.DataParser.getuniqeresault(new Category(), Integer.parseInt(request.getParameter("appcategorylist")));
            Developer developer = (Developer) request.getSession().getAttribute("developer");
            int developerid = developer.getIdDeveloper();
            developer = (Developer) Datacontroller.DataParser.getuniqeresault(new Developer(), developerid);*/
        } catch (Exception ex) {
            System.out.println(ex);
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
