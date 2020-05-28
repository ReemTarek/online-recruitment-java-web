<%-- 
    Document   : Vquestion_answer
    Created on : Dec 21, 2019, 11:12:10 AM
    Author     : Om-mostafa El-Hariry
--%>
<%@page import="Model.MAnswer"%>
<%@page import="Model.MQuestion"%>
<%@page import="java.util.ArrayList"%>
<% 
   ArrayList<MQuestion> questions = new ArrayList();
   questions = (ArrayList<MQuestion>)request.getAttribute("questions");
   ArrayList<ArrayList<MAnswer>> answers = new ArrayList();
   answers = (ArrayList<ArrayList<MAnswer>>)request.getAttribute("answers");
   //String type = (String)request.getAttribute("type");
   out.println("Questions Table");
   out.println("<table border = '2' width='70%' cellpadding='5'>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Add Question&Answer");
   out.println("</td>");
   out.println("<td>");
   out.println("<a href = 'Vadd_question_answer.jsp'>Add_Question_Answer</a>");
   out.println("</td>");
   out.println("</tr>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Question ID");
   out.println("</td>");
   out.println("<td>");
   out.println("Exam ID");
   out.println("</td>");
   out.println("<td>");
   out.println("Question");
   out.println("</td>");
   out.println("<td>");
   out.println("Update Question&Answer");
   out.println("</td>");
   out.println("<td>");
   out.println("Delete Question&Answer");
   out.println("</td>");
   for(int i=0; i<questions.size(); i++)
   {
        out.println("<tr>");
        out.println("<td>");
        out.println(questions.get(i).id);
        out.println("</td>");
        out.println("<td>");
        out.println(questions.get(i).examId);
        out.println("</td>");
        out.println("<td>");
        out.println(questions.get(i).text);
        out.println("</td>");
        out.println("<td>");
        out.println("<a href = 'Vupdate_question_answer.jsp'>UPDATE</a>");
        out.println("</td>");
        out.println("<td>");
        out.println("<a href = 'Vdelete_question_answer.jsp'>DELETE</a>");
        out.println("</td>");
        out.println("</tr>");
   }
   out.println("</table>");
   out.print("Answer Table:");
   out.println("<table border = '2' width='70%' cellpadding='5'>");
   out.println("<tr>");
   out.println("<td>");
   out.println("Answer ID");
   out.println("</td>");
   out.println("<td>");
   out.println("Question ID");
   out.println("</td>");
   out.println("<td>");
   out.println("Answer");
   out.println("</td>");
   out.println("<td>");
   out.println("Correctness");
   out.println("</td>");
   out.println("</tr>");
   for(int i=0; i<questions.size(); i++)
   {
        for(int j = 0; j<answers.get(i).size(); j++)
        {
            out.println("<tr>");
            out.println("<td>");
            out.println(answers.get(i).get(j).id);
            out.println("</td>");
            out.println("<td>");
            out.println(answers.get(i).get(j).questionId);
            out.println("</td>");
            out.println("<td>");
            out.println(answers.get(i).get(j).text);
            out.println("</td>");
            out.println("<td>");
            out.println(answers.get(i).get(j).correct);
            out.println("</td>");
            out.println("</tr>");
        }
   }
   out.println("</table>");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions and Answers</title>
    </head>
    <body>
    </body>
</html>
