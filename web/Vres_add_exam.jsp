<%-- 
    Document   : Vres_add_exam
    Created on : Dec 20, 2019, 4:28:54 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean addExam = (Boolean)request.getAttribute("addExam");
    if(addExam)
        out.println("Exam added successfully");
    else
        out.println("Failed to add exam");
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Adding Exam</title>
    </head>
    <body>
    </body>
</html>
