<%-- 
    Document   : profile
    Created on : Oct 8, 2016, 7:35:19 AM
    Author     : Ish
--%>

<%@page import="Oparation.SessionCounterListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Staff member Profile Page</h1>
        <%=SessionCounterListener.getTotalActiveSession()
        %>
    </body>
</html>
