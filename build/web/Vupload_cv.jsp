<%-- 
    Document   : Vupload_cv
    Created on : Dec 22, 2019, 8:39:51 AM
    Author     : Om-mostafa El-Hariry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload CV</title>
    </head>
    <body>
      <h3>Upload CV:</h3>
      <% 
          HttpSession sessionUser = request.getSession();
          String cEmail = (String)sessionUser.getAttribute("email");
          String position = request.getParameter("position");
          sessionUser.setAttribute("position", position);
       %>
      <form action = "Cupload_cv" method = "post" enctype = "multipart/form-data">
         <label> Select a file to upload: </label>
          <input type = "file" name = "file" id = "file" size = "500" />
         <br><br>
         <input type = "submit" value = "Continue.." />
      </form>
       </body>
</html>
