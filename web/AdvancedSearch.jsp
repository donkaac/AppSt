<%-- 
    Document   : AdvancedSearch
    Created on : Oct 3, 2016, 3:49:02 PM
    Author     : Ish
--%>

<%@page import="Datacontroller.DataParser"%>
<%@page import="Entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            HttpSession s = request.getSession();

            String username = "Guest";
            boolean loging = false;
            Customer c = new Customer();
            if (!request.getSession().equals(null)) {
                try {

                    int cusid = Integer.parseInt(s.getAttribute("userid").toString());
                    c = (Customer) DataParser.getuniqeresault(new Customer(), cusid);
                    username = c.getCustomerFname();
                    loging = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                response.sendRedirect("login.jsp");
            }
            if(!loging){
                 response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
