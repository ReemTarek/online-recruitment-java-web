<%-- 
    Document   : Vselect_position
    Created on : Dec 22, 2019, 9:23:20 AM
    Author     : Om-mostafa El-Hariry
--%>
<%@page import="Model.MPosition"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession sessionUser = request.getSession();
    String cEmail = (String)sessionUser.getAttribute("email");
    ArrayList<MPosition> positions = (ArrayList<MPosition>)request.getAttribute("positions");
    out.println("<form action = 'Vupload_cv.jsp'>");
    out.println("<select name ='position'>");
    for(int i=0; i<positions.size(); i++)
    {
        out.println("<option value = '" + positions.get(i).name + "'>" + positions.get(i).name + "</option>"); 
    }
    out.println("</select>");
    out.println("<br><br>");
    out.println("<input type = 'submit' value = 'Continue..'>");
    out.println("</form>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Position</title>
    </head>
    <body>
    </body>
</html>
