<%-- 
    Document   : Vres_delete_question_answer
    Created on : Dec 21, 2019, 10:13:40 PM
    Author     : Om-mostafa El-Hariry
--%>
<%
    boolean deleteQuestion = (Boolean)request.getAttribute("deleteQuestion");
    boolean deleteAnswer = (Boolean)request.getAttribute("deleteAnswer");
    if(deleteQuestion && deleteAnswer)
        out.println("Question and its answers deleted successfully.");
    else
        out.println("Failed to delete question and its answers");
    
    out.println("<form action = 'Vhr_options.jsp'>");
    out.println("<input type = 'submit' value = 'Back To Menu'>");
    out.println("</form>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result delete question and answer</title>
    </body>
</html>
