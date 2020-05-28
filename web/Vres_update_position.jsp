<%-- 
    Document   : Vres_update_position
    Created on : Dec 20, 2019, 10:10:16 PM
    Author     : Om-mostafa El-Hariry
--%>
<%
    boolean updatePosition = (Boolean)request.getAttribute("updatePosition");
    if(updatePosition)
        out.println("Position updated successfully");
    else
        out.println("Failed to update position");
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Update Exam</title>
    </head>
    <body>
    </body>
</html>
