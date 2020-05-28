<%-- 
    Document   : Vcv_approval
    Created on : Dec 22, 2019, 9:06:49 PM
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
    HttpSession sessionUser = request.getSession();
    sessionUser.setAttribute("candidatePosition", candidatePosition);
    out.println("jsp : " + positions.get(0).id);
    out.println("jsp : " + candidate.get(0).id);
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
    out.println("Approve & DISAPPROVE CV");
    out.println("</td>");
    out.println("<td>");
    out.println("Click");
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
        out.println("<form action = 'Cres_cv_approval' id = 'approval'>");
        out.println("<select name ='option'>");
        out.println("<option value ='approve'> APPROVE </option>"); 
        out.println("<option value ='disapprove'> DISAPPROVE </option>"); 
        out.println("</select>");
        out.println("</td>");
        out.println("<td>");
        out.println("<input type='submit' value = 'Submit'>");
        out.println("</form>");
        out.println("</div>");
        out.println("</td>");
        out.println("</tr>");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CV Approval</title>
    </head>
    <body>
    </body>
</html>
