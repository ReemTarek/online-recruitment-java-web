<%-- 
    Document   : Vsearch_by_candidateName
    Created on : Dec 18, 2019, 11:39:53 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search By Candidate Name</title>
        <script src="jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="appajax.js" type="text/javascript"></script>
    </head>
    <body>
        <form action = "Csearch_by_candidateName">
            <label> Enter Candidate Username </label>
            <input type ="text" name ="cName" id ="cName">
            <input type ="submit" value ="Search">
        </form>
    </body>
</html>
