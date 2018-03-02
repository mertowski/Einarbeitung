<%-- 
    Document   : gaestebuch
    Created on : Feb 16, 2018, 8:26:12 AM
    Author     : myu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String eintrag = request.getParameter("eintrag");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gästebuch</title>
    </head>
    <body>
        <h1>Gästebuch</h1>
        <p> <%= name%> (<%= email%>) sagt: </p>
        <p><%= eintrag%></p><br>
        <a href="index.html">Zurück</a> <br>
    </body>
</html>
