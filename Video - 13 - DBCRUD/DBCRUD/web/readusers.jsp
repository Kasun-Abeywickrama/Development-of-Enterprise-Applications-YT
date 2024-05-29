<%-- 
    Document   : readusers
    Created on : May 28, 2024, 7:14:16 PM
    Author     : HP
--%>

<%@page import="mypackage.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Users!</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>City</th>
            </tr>
            <%

                List<User> users = (List<User>) request.getAttribute("users");

                for (User user : users) {
                    
            %>
            
            <tr>

                <td><%= user.getId() %></td>
                <td><%= user.getfName() %></td>
                <td><%= user.getlName() %></td>
                <td><%= user.getCity() %></td>
            </tr>
            
            <%

            }

            %>
        </table>
    </body>
</html>
