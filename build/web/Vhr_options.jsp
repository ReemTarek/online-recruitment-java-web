<%-- 
    Document   : Vhr_options
    Created on : Dec 18, 2019, 2:56:44 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HR Options</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action = "Chr_options">
        <select name ="option">
            <option value ="edit_position"> Edit Position </option> 
            <option value ="edit_exam"> Edit Exam </option> 
        </select>
            <br>
            <input type="submit" value = "Get Data">
        </form>
        <br><br>
        <form action = "Ccv_approval">
            <input type ="submit" value ="New Candidate Requests">
        </form>
        <br><br>
        <form action = "Cexam_taken">
            <input type ="submit" value ="Show Candidate Without Exam">
        </form>
        <br><br>
        <form action = "Vget_by_exam_type.jsp">
            <input type ="submit" value ="Edit Questions & Answers">
        </form>
        <br><br>
        <form action = "Vsearch_by_candidateName.jsp">
            <input type ="submit" value ="Search By Candidate Name">
        </form>
        <br> <br>
        <form action = "Vsearch_by_email.jsp">
            <input type ="submit" value ="Search By Candidate Email">
        </form>
        <br> <br>
        <form action = "Vsearch_by_examType.jsp">
            <input type ="submit" value ="Search By Exam Type">
        </form>
        <br> <br>
        <form action = "Vsearch_by_examDate.jsp">
            <input type ="submit" value ="Search By Exam Date">
        </form>
    </body>
</html>
