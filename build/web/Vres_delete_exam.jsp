<%-- 
    Document   : Vres_delete_exam
    Created on : Dec 20, 2019, 4:29:20 PM
    Author     : Om-mostafa El-Hariry
--%>

<%
    boolean deleteExam = (Boolean)request.getAttribute("deleteExam");
    boolean deleteQuestion = (Boolean)request.getAttribute("deleteQuestion");
    boolean deleteAnswer = (Boolean)request.getAttribute("deleteAnwer");
    if(deleteExam && deleteQuestion && deleteAnswer)
        out.println("Exam deleted successfully");
    else
        out.println("Failed to delete exam");
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Delete Exam</title>
    </head>
    <body>
    </body>
</html>
