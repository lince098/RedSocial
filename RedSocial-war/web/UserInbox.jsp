<%--
    Document   : UserChat
    Created on : 07-may-2019, 20:30:44
    Author     : Alae Akalay
--%>

<%@page import="RedSocialEntities.Messages"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    List<Messages> inbox = (List) request.getAttribute("listaEntrantes");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INBOX</title>
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
        <h2>Inbox:</h2>

        <table>
            <tr>
                <th>Tittle</th>
                <th>Date:</th>
                <th>From:</th>
                <th>Message:</th>
            </tr>
            <%
                for (Messages m : inbox) {
            %>
            <tr>
                <td><%= m.getTitle()%></td>
                <td><%= m.getDate().toString()%></td>
                <td><%= m.getSender().getName()%></td>
                <td><%= m.getText()%></td>
                <td>
                    <form action="ReplyMessageServlet">
                        <input type="hidden" name="messageSender" value="<%= m.getSender().getId()%>">
                        <input type="hidden" name="messageTitle" value="<%= m.getTitle()%>">
                        <button>Reply</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            <a href="UserOutboxServlet">Check Outbox</a>
            <a href="SearchServlet?filter=1">Create new message</a>
        </table>
    </body>
</html>
