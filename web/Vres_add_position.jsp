<%-- 
    Document   : Vres_add_position
    Created on : Dec 20, 2019, 9:57:52 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean addPosition = (Boolean)request.getAttribute("addPosition");
    if(addPosition)
        out.println("Position added successfully");
    else
        out.println("Failed to add position");
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Add Position</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
