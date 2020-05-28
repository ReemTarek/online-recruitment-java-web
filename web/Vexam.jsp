<%-- 
    Document   : Vexam
    Created on : Dec 18, 2019, 4:11:13 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.MExam" %>
<% 
   ArrayList<MExam> exams = new ArrayList();
   exams = (ArrayList<MExam>)request.getAttribute("exams");
   out.println("<table border = '2' width='50%' cellpadding='5'>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Add Exam");
   out.println("</td>");
   out.println("<td>");
   out.println("<a href = 'Vadd_exam.jsp'>ADD</a>");
   out.println("</td>");
   out.println("</tr>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Exam ID");
   out.println("</td>");
   out.println("<td>");
   out.println("Exam Type");
   out.println("</td>");
   out.println("<td>");
   out.println("Exam Period");
   out.println("</td>");
   out.println("<td>");
   out.println("Update Exam");
   out.println("</td>");
   out.println("<td>");
   out.println("Delete Exam");
   out.println("</td>");
   for(int i=0; i<exams.size(); i++)
   {
        out.println("<tr>");
        out.println("<td>");
        out.println(exams.get(i).id);
        out.println("</td>");
        out.println("<td>");
        out.println(exams.get(i).type);
        out.println("</td>");
        out.println("<td>");
        out.println(exams.get(i).period);
        out.println("</td>");
        out.println("<td>");
        out.println("<a href = 'Vupdate_exam.jsp'>UPDATE</a>");
        out.println("</td>");
        out.println("<td>");
        out.println("<a href = 'Vdelete_exam.jsp'>DELETE</a>");
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
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
