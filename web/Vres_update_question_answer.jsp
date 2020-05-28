<%-- 
    Document   : Vres_update_question_answer
    Created on : Dec 21, 2019, 8:48:35 PM
    Author     : Om-mostafa El-Hariry
--%>
<%
    boolean updateQuestion = (Boolean)request.getAttribute("updateQuestion");
    boolean updateAnswer = (Boolean)request.getAttribute("updateAnswer");
    if(updateQuestion && updateAnswer)
        out.println("Question and its answers updated successfully.");
    else
        out.println("Failed to update question and its answers");
    
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result update question and answer</title>
    </head>
    <body>
    </body>
</html>
