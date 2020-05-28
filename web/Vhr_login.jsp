<%-- 
    Document   : Vhr_login
    Created on : Dec 18, 2019, 10:34:26 AM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Login</title>
    </head>
    <body>
         <form  id="formL" action="Chr_login" method="post" >
            <center>
                <table border="2" width="15%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Login Form</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>    
                            <td>Email : </td>
                            <td><input type="email" name="email" id="email" ></td>
                        </tr>
                        <tr>
                            <td>Password : </td>
                            <td><input type="password" name="pwd" id="pwd" ></td>
                        </tr>
                         <tr>
                            
                            <td><input type="submit" name="login"  ></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>
        <div id="targetDiv" style="display: none;"></div>
    </body>
</html>
