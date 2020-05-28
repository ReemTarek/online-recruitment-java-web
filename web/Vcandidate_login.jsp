<%-- 
    Document   : Vcandidate_login
    Created on : Dec 18, 2019, 10:28:12 AM
    Author     : Om-mostafa El-Hariry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
        <script src="appajax.js" type="text/javascript"></script>
        <title>Login Form</title>
    </head>
    <body>
        <form  id="formL" onsubmit=" checkform(this);return false" action="Ccandidate_login" method="post" >
            <center>
                <table border="2" width="30%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Login Form</th>
                        </tr>
                    </thead>
                    <tbody>
                          <tr>    
                           <td>UserName : </td>
                           <td><input type="text" name="username" id="username" ></td>
                        </tr>
                        <tr>    
                            <td>Email : </td>
                            <td><input type="email" name="email" id="email" ></td>
                        </tr>
                        <tr>
                            <td>Password : </td>
                            <td><input type="password" name="pwd" id="pwd" ></td>
                        </tr>
                        <tr>  
                            <td><center><a href="Vcandidate_signup.jsp">Register</a></center></td>
                            <td><center><input type="submit" value="login" id="login"></center></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>
        <div id="targetDiv" style="display: none;">
</div>
       <div id="targetDiv" style="display: none;"></div>
    </body>
</html>
