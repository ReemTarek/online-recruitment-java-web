<%-- 
    Document   : Vres_delete_position
    Created on : Dec 20, 2019, 10:24:14 PM
    Author     : Om-mostafa El-Hariry
--%>
<%
    boolean deletePosition = (Boolean)request.getAttribute("deletePosition");
    if(deletePosition)
        out.println("Position deleted successfully");
    else
        out.println("Failed to delete position");
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Delete Position</title>
    </head>
    <body>
    </body>
</html>
