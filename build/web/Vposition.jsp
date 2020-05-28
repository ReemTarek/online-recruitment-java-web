<%-- 
    Document   : Vposition
    Created on : Dec 18, 2019, 4:02:01 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.MPosition" %>
<% 
   ArrayList<MPosition> positions = new ArrayList();
   positions = (ArrayList<MPosition>)request.getAttribute("positions");
   out.println("<table border = '2' width='70%' cellpadding='5'>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Add Exam");
   out.println("</td>");
   out.println("<td>");
   out.println("<a href = 'Vadd_position.jsp'>ADD</a>");
   out.println("</td>");
   out.println("</tr>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Position ID");
   out.println("</td>");
   out.println("<td>");
   out.println("Position Name");
   out.println("</td>");
   out.println("<td>");
   out.println("Position Availability");
   out.println("</td>");
   out.println("<td>");
   out.println("# of Candidates Per Position");
   out.println("</td>");
   out.println("<td>");
   out.println("Update Position");
   out.println("</td>");
   out.println("<td>");
   out.println("Delete Position");
   out.println("</td>");
   for(int i=0; i<positions.size(); i++)
   {
        out.println("<tr>");
        out.println("<td>");
        out.println(positions.get(i).id);
        out.println("</td>");
        out.println("<td>");
        out.println(positions.get(i).name);
        out.println("</td>");
        out.println("<td>");
        out.println(positions.get(i).available);
        out.println("</td>");
        out.println("<td>");
        out.println(positions.get(i).count);
        out.println("</td>");
        out.println("<td>");
        out.println("<a href = 'Vupdate_position.jsp'>UPDATE</a>");
        out.println("</td>");
        out.println("<td>");
        out.println("<a href = 'Vdelete_position.jsp'>DELETE</a>");
        out.println("</td>");
        out.println("</tr>");
   }
   out.println("</table>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Positions</title>
    </head>
    <body>
    </body>
</html>
