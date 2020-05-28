<%-- 
    Document   : Vres_add_question_answer
    Created on : Dec 21, 2019, 3:57:04 PM
    Author     : Om-mostafa El-Hariry
--%>
<%
    boolean addQuestion = (Boolean)request.getAttribute("addQuestion");
    boolean addAnswer = (Boolean)request.getAttribute("addAnswer");
    if(addQuestion && addAnswer)
        out.println("Question and its answers added successfully.");
    else
        out.println("Failed to add question and its answers");
    
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result add question_answer</title>
    </head>
    <body>
    </body>
</html>
