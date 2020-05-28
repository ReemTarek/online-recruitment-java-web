<%-- 
    Document   : Vres_update_exam
    Created on : Dec 20, 2019, 4:29:07 PM
    Author     : Om-mostafa El-Hariry
--%>
<%
    boolean updateExam = (Boolean)request.getAttribute("updateExam");
    if(updateExam)
        out.println("Exam updated successfully");
    else
        out.println("Failed to update exam");
    
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
