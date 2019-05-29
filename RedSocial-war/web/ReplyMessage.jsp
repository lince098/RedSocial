<%-- 
    Document   : ReplyMessage
    Created on : 09-may-2019, 18:55:16
    Author     : ak
--%>

<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Users receiver = (Users) request.getAttribute("receiver");
    String title = (String) request.getAttribute("title");
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
        </style>
        <title>Reply message</title>
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
            <h2>Reply message</h2>
            <form action="SendMessageServlet">
                <input type="hidden" name="receiverID" value="<%= receiver.getId()%>">
                To: <br>
                <input type="text" name="receiver" value="<%= receiver.getName()%>" disabled><br>
                Subject: <br>
                <input type ="text" name="tittle" value="<%= title%>"><br>
                Message: <br>
                <textarea name="msg" rows="3" value=""></textarea><br>
                <button> Send </button>
            </form>
        </div>
    </body>
</html>
