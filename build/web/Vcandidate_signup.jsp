<%-- 
    Document   : Vcandidate_signup
    Created on : Dec 18, 2019, 10:31:45 AM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <script src="jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="appajax.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="Ccandidate_signup">
            <center>
                <table border="1" width="30%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Register Form</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>    
                            <td>Username : </td>
                            <td><input type="text" name="username" id="username"></td>
                        </tr>
                        <tr>
                            <td>Email : </td>
                            <td><input type="email" name="email"id="email" ></td>
                        </tr>
                        <tr>
                            <td>Password : </td>
                            <td><input type="password" name="pwd"id="pwd" ></td>
                        </tr>
                        <tr>    
                            <td>Phone : </td>
                            <td><input type="text" name="telephone" id="phone"></td>
                        </tr>

                        <tr>
                            <td><center><input type="reset" value="Reset" /></center></td>
                            <td><center><input type="submit" value="Register"></center></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>
        <div id="targetDiv"></div>
        <div style="position: relative">
            <div style="position: fixed ; bottom: 0 ; width:100% ; text-align:center ">
            </div>
        </div>                  
    </body>
</html>