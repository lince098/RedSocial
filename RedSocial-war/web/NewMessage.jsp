<%-- 
    Document   : NewMessage
    Created on : 10-may-2019, 17:47:21
    Author     : Alae Akalay
--%>

<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Users u = (Users) request.getAttribute("destino");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new message.</title>
    </head>
    <body>
        <h1>Create new message:</h1>
        <form action="SendMessageServlet">
            <input type="hidden" name="receiverID" value="<%= u.getId() %>"><br>
            To: <br>
            <input type="text" name="destino" value="<%= u.getName() %>" disabled><br>
            Subject: <br>
            <input type ="text" name="tittle" value=""><br>
            Message: <br>
            <input type ="text" name="msg" value=""><br>
            <button> Send </button>
        </form>
    </body>
</html>
