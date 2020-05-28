<%-- 
    Document   : Vupdate_position
    Created on : Dec 20, 2019, 10:00:01 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Position</title>
    </head>
    <body>
        <form action = "Cupdate_position">
            <label> Enter ID for Position To Update: </label>
            <input type ="text" name ="id" id ="id"><br><br>
            <label> Enter New Name for Position: </label>
            <input type ="text" name ="name" id ="name"><br><br>
            <label> Enter New availability for position </label>
            <input type ="text" name ="available" id ="available"><br><br>
            <input type  ="submit" value ="UPDATE">
        </form>
</html>
