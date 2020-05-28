<%-- 
    Document   : Vexam_taken
    Created on : Dec 23, 2019, 4:11:27 PM
    Author     : Om-mostafa El-Hariry
--%>
<%@page import="Model.Mcandidate"%>
<%@page import="Model.MPosition"%>
<%@page import="Model.McandidatePosition"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Mcandidate> candidate = (ArrayList<Mcandidate>) request.getAttribute("candidate");
    ArrayList<McandidatePosition> candidatePosition = (ArrayList<McandidatePosition>) request.getAttribute("candidatePosition");
    ArrayList<MPosition> positions = (ArrayList<MPosition>) request.getAttribute("positions");
    out.println("<table border = '2' width='50%' cellpadding='5'>");
    out.println("<tr>");
    out.println("<td>");
    out.println("Candidate Email");
    out.println("</td>");
    out.println("<td>");
    out.println("Position Name");
    out.println("</td>");
    out.println("<td>");
    out.println("Candidate CV");
    out.println("</td>");
    out.println("<td>");
    out.println("ADD EXAM");
    out.println("</td>");
    out.println("</tr>");
    for(int i=0; i<candidatePosition.size(); i++)
    {
        out.println("<tr>");
        out.println("<td>");
        out.println(candidate.get(i).email);
        out.println("</td>");
        out.println("<td>");
        out.println(positions.get(i).name);
        out.println("</td>");
        out.println("<td>");
        out.println(candidatePosition.get(i).cv);
        out.println("</td>");
        out.println("<td>");
        out.println("<form action = 'Cres_exam_taken'>");
        out.println("<input type='submit' value = 'Add Exam'>");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>exam taken view</title>
    </head>
    <body>
    </body>
</html>

