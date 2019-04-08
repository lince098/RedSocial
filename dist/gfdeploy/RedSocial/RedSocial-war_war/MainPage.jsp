<%-- 
    Document   : MainPage
    Created on : 01-abr-2019, 10:55:09
    Author     : PabloGL
--%>

<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <%
            Users currentSession = (Users) session.getAttribute("currentSession");
        %>

    </head>
    <body>
        <h1>Hello World! This is the main page</h1>

        <p>Current user logged: <%= currentSession.getName()%> <%= currentSession.getSurname()%></p>
    </body>
</html>
