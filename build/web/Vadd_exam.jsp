<%-- 
    Document   : Vadd_exam
    Created on : Dec 20, 2019, 1:44:42 PM
    Author     : Om-mostafa El-Hariry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Exam</title>
    </head>
    <body>
        <h1> ADD NEW EXAM </h1>
        <form action ="Cadd_exam">
            <label> Enter Exam Type </label>
            <input type ="text" name ="type" id ="type"><br><br>
            <label> Enter Exam Period </label>
            <input type ="double" name ="period" id ="period"><br><br>
            <input type ="submit" value ="ADD">
        </form>
    </body>
</html>
