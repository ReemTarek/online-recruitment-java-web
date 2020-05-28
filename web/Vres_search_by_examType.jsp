<%-- 
    Document   : Vres_search_by_examType
    Created on : Dec 18, 2019, 8:54:25 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Mcandidate" %>
<%
    ArrayList<Mcandidate> candidates = (ArrayList<Mcandidate>)request.getAttribute("candidateByExamType");
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
    for(int i=0; i<candidates.size(); i++)
    {
        out.println("<tr>");
        out.println("<td>");
        out.println(candidates.get(i).username);
        out.println("</td>");
        out.println("<td>");
        out.println(candidates.get(i).email);
        out.println("</td>");
        out.println("<td>");
        out.println(candidates.get(i).telephone);
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
        <title>Result Search by Exam Type</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
