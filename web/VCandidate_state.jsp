<%-- 
    Document   : VCandidate_state
    Created on : Dec 23, 2019, 2:35:46 PM
    Author     : Om-mostafa El-Hariry
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession sessionUser = request.getSession();
    ArrayList<String> postionname = (ArrayList<String>) sessionUser.getAttribute("posname");
    ArrayList<String> canstates = (ArrayList<String>) sessionUser.getAttribute("states");
    //sessionUser.setAttribute("posname", postionname);
    for(int i=0;i<postionname.size();i++)
    {   
        out.println("postion name "+postionname.get(i)+"states "+canstates.get(i));
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
