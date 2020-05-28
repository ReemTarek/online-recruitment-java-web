<%-- 
    Document   : Vupdate_exam
    Created on : Dec 20, 2019, 3:04:00 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Exam</title>
    </head>
    <body>
        <form action = "Cupdate_exam">
            <label> Enter ID for Exam To Update: </label>
            <input type ="text" name ="id" id ="id"><br><br>
            <label> Enter New Type for Exam: </label>
            <input type ="text" name ="type" id ="type"><br><br>
            <label> Enter New Period for Exam </label>
            <input type ="text" name ="period" id ="period"><br><br>
            <input type  ="submit" value ="UPDATE">
        </form>
    </body>
</html>
