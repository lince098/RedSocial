<%-- 
    Document   : UserOutbox
    Created on : 07-may-2019, 21:50:09
    Author     : Alae Akalay
--%>

<%@page import="RedSocialEntities.Messages"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Messages> outbox = (List) request.getAttribute("listaSalientes");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OUTBOX</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>

    <body>
        <h2>Outbox:</h2>

        <table>
            <tr> 
                <th>Tittle</th>
                <th>Date:</th>
                <th>From:</th>
                <th>Message:</th>
            </tr>
            <%
                for (Messages m : outbox) {
            %>
            <tr>
                <td><%= m.getTitle()%></td>
                <td><%= m.getDate().toString()%></td>
                <td><%= m.getReceiver().getName()%></td>
                <td><%= m.getText()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="UserInboxServlet">Check Inbox</a>
    </body> 
</html>