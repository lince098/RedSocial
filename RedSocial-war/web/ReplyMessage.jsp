<%-- 
    Document   : ReplyMessage
    Created on : 09-may-2019, 18:55:16
    Author     : ak
--%>

<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Users receiver = (Users)request.getAttribute("receiver");
    String title = (String)request.getAttribute("title");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reply message</title>
    </head>
    <body>
        <h2>Reply message</h2>
        <form action="SendMessageServlet">
            <input type="hidden" name="receiverID" value="<%= receiver.getId() %>">
            To: <br>
            <input type="text" name="receiver" value="<%= receiver.getName() %>" disabled><br>
            Subject: <br>
            <input type ="text" name="tittle" value="<%= title %>"><br>
            Message: <br>
            <textarea name="msg" rows="3" value=""></textarea><br>
            <button> Send </button>
        </form>
    </body>
</html>
