<%-- 
    Document   : Vprepare_exam
    Created on : Dec 23, 2019, 9:55:00 PM
    Author     : Om-mostafa El-Hariry
--%>
<%@page import="Model.MExam"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<MExam> exams = (ArrayList<MExam>) request.getAttribute("exams");
    out.println("<form action = 'Cprepare_exam'>");
    for(int i=0; i<exams.size(); i++)
    {
        out.println("<input type = 'checkbox' name = 'examType' value = '" + exams.get(i).type + "'>" + exams.get(i).type + "<br>");
    }
    out.println("<br><input type = 'submit' value = 'Prepare Exam'>");
    out.println("</form>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
