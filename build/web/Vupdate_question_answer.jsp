<%-- 
    Document   : Vupdate_question_answer
    Created on : Dec 21, 2019, 4:32:52 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Question and Answers</title>
    </head>
    <body>
        <form action = "Cupdate_question_answer">
            <label> Enter ID for question To Update: </label>
            <input type ="text" name ="id" id ="id"><br><br>
            <label> Enter New Question: </label>
            <input type ="text" name ="question" id ="question"><br><br>
            <table border = '2' width='70%' cellpadding='5'>
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
            </table><br>
            <input type  ="submit" value ="UPDATE">
        </form>
</html>
