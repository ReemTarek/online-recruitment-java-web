<%-- 
    Document   : Vres_search_by_email
    Created on : Dec 18, 2019, 5:00:18 PM
    Author     : Om-mostafa El-Hariry
--%>
<%@page import="Model.Mcandidate" %>
<%
    Mcandidate candidate = (Mcandidate)request.getAttribute("candidateByEmail");
    out.println("<table border = '2' width='15%' cellpadding='5'>");
    out.println("<tr>");
    out.println("<td>");
    out.println("Candidate Username");
    out.println("</td>");
    out.println("<td>");
    out.println("Candidate Email");
    out.println("</td>");
    out.println("<td>");
    out.println("Candidate Telephone");
    out.println("</td>");
    out.println("<tr>");
    out.println("<td>");
    out.println(candidate.username);
    out.println("</td>");
    out.println("<td>");
    out.println(candidate.email);
    out.println("</td>");
    out.println("<td>");
    out.println(candidate.telephone);
    out.println("</td>");
    out.println("</tr>");
    out.println("</table>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Search</title>
    </head>
    <body>
    </body>
</html>
