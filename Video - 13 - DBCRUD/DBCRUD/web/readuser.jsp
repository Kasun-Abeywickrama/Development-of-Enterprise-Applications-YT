<%-- 
    Document   : readuser
    Created on : May 28, 2024, 6:44:48 PM
    Author     : HP
--%>

<%@page import="mypackage.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Read User !</h1>
        
        <%
            User user = (User) request.getAttribute("user");
            out.println("First Name : " +user.getfName()+"<br>");
            out.println("Last Name : " +user.getlName()+"<br>");
            out.println("City : " +user.getCity()+"<br>");
        %>
    </body>
</html>
