<%-- 
    Document   : Vadd_question
    Created on : Dec 21, 2019, 12:37:26 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Question</title>
    </head>
    <body>
        <h1> ADD NEW QUESTION </h1>
        <form action ="Cadd_question_answer">
            <label> Enter Exam type: </label>
            <input type ="text" name ="type" id ="type"><br><br>
            <label> Enter Question: </label>
            <input type ="text" name ="question" id ="question"><br><br>
            <table border = '2' width='70%' cellpadding='5'>
            <%
//            for(int i=0; i<8; i++)
//            {
//                out.println("<tr>");
//                    out.println("<td>");
//                        out.println("<label>Enter Answer " + (i+1) + ": </label>");
//                        out.println("<input type = 'text' name = 'answer " + (i+1) +"' id = 'answer'>");
//                        out.println("<label>Enter Correctness </label>");
//                        out.println("<input type = 'text' name = 'correct" + (i+1) +"' id = 'correct'>");
//                    out.println("</td>");
//                out.println("</tr>");
//            }
            %> 
                <tr>
                    <td>
                        <label>Enter Answer 1": </label>
                        <input type = 'text' name = 'answer1' id = 'answer1'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct1' id = 'correct1'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 2": </label>
                        <input type = 'text' name = 'answer2' id = 'answer2'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct2' id = 'correct2'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 3": </label>
                        <input type = 'text' name = 'answer3' id = 'answer3'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct3' id = 'correct3'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 4": </label>
                        <input type = 'text' name = 'answer4' id = 'answer4'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct4' id = 'correct4'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 5": </label>
                        <input type = 'text' name = 'answer5' id = 'answer5'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct5' id = 'correct5'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 6": </label>
                        <input type = 'text' name = 'answer6' id = 'answer6'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct6' id = 'correct6'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 7": </label>
                        <input type = 'text' name = 'answer7' id = 'answer7'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct7' id = 'correct7'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter Answer 8": </label>
                        <input type = 'text' name = 'answer8' id = 'answer8'>
                        <label>Enter Correctness </label>
                        <input type = 'text' name = 'correct8' id = 'correct8'>
                    </td>
                </tr>
            </table>
            <input type ="submit" value ="ADD">
        </form>
    </body>
</html>
