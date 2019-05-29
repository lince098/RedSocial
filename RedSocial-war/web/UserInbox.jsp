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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .right {
                position: relative;
                right: 0px;
                padding-top: 9px;
                padding-bottom: 9px;
            } 
            .navbar-toggler {
                position: relative;
                right: 0px;
                margin-right: 0px;
            }
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
        <title>INBOX</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark form-inline">
            <div class="navbar-header">
                <a class="navbar-brand" href="MainPage.jsp">Main Page</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="nav navbar-nav">
                    <%-- <li class="active"> --%>
                    <li>
                        <a class="nav-link" href="FriendlistPage.jsp">FriendList</a>
                    </li>
                    <li>
                        <a class="nav-link" href="GroupList.jsp">Groups</a>
                    </li>
                </ul>
            </div>  
            <form class="form-inline right input-group" action="SearchSevlet">
                <input type="hidden" name="filter" value="0">
                <input class="form-control" type="text" placeholder="Search.." name="search">
                <button class="btn btn-primary" type="submit">
                    <i class="fa fa-search"></i>
                </button>
            </form>
            <a href="LogOutServlet" class="btn btn-danger">Log Out</a>
        </nav>
        <div class="container col-9" style="margin-top:30px">
            <a href="SearchSevlet?filter=1">Create new message</a><br/><br/>
            <a href="UserOutboxServlet">Check Outbox</a><br/><br/>

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
            </table>
        </div>
    </body>
</html>
