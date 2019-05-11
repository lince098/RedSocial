<%-- 
    Document   : FriendlistPage
    Created on : 17-abr-2019, 16:47:18
    Author     : Rafa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Users currentSession = (Users) session.getAttribute("currentSession");
            List<Users> friendsList = new ArrayList<Users>();
            List<Users> friendsPetitionList = new ArrayList<Users>();
            if (currentSession != null) {
                if (!currentSession.getUsersList().isEmpty()) {
                    friendsList = currentSession.getUsersList();
                }
                if (!currentSession.getUsersList2().isEmpty()) {
                    friendsPetitionList = currentSession.getUsersList2();
                }
            }
        %>
        <title>Red social</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                margin-left: 150px;
            } 
            hr.style1{
                border-top: 1px solid #8c8b8b;
            }
            .postButton{
                float:right; 
                margin-top: 12px; 
                padding-left: 40px; 
                padding-right: 40px;
            }
            .customLink{
                color: cornflowerblue;
                text-decoration: none;
            } 
            .customLink:hover{
                color: royalblue;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
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
                        <a class="nav-link active" href="FriendlistPage.jsp">FriendList</a>
                    </li>
                    <li>
                        <a class="nav-link" href="#">Groups</a>
                    </li>
                </ul>
            </div>  
            <form class="form-inline mr-auto right" action="SearchSevlet">
                <input type="hidden" name="filter" value="0">
                <input class="form-control" type="text" placeholder="Search.." name="search">
                <button class="btn btn-primary" type="submit">
                    <i class="fa fa-search"></i>
                </button>
            </form>
        </nav>
        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-8">
                    <%
                        if (!friendsPetitionList.isEmpty()) {
                    %>    
                    <h2>Pending friendship request:</h2>
                    <%
                        for (Users u : friendsPetitionList) {
                            if (u.getProfilePicture().equals(null)) {
                    %>
                    <a class ="customLink" href="UserPageLoadServlet?userID=<%= u.getId() %>">
                        <img src="/img/icon.jpg" class="rounded-circle" width="50" height="50">
                        <%= u.getName()%> <%= u.getSurname()%>
                    </a>
                    <a href="AddFriendServlet?id=<%= u.getId()%>" class="btn btn-primary">
                        <i class="material-icons">
                            add
                        </i>
                        Add friend
                    </a>
                    <a href="RemoveFriendRequest?id=<%= u.getId()%>" class="btn btn-danger">
                        <i class="material-icons">
                            delete
                        </i>
                        Remove
                    </a>
                    <%
                    } else {
                    %>
                    <a class ="customLink" href="UserPageLoadServlet?userID=<%= u.getId() %>">
                        <img src="<%= u.getProfilePicture()%>" class="rounded-circle" width="50" height="50">
                        <%= u.getName()%> <%= u.getSurname()%>
                    </a>
                    <a href="AddFriendServlet?id=<%= u.getId()%>" class="btn btn-primary">
                        <i class="material-icons">
                            add
                        </i>
                        Add friend
                    </a>
                    <a href="RemoveFriendRequest?id=<%= u.getId()%>" class="btn btn-danger">
                        <i class="material-icons">
                            delete
                        </i>
                        Remove
                    </a>
                    <%
                        }
                    %>
                    <hr class="style1">
                    <%
                            }
                        }
                    %>
                    <br>
                    <%
                        if (!friendsList.isEmpty()) {
                    %>    
                    <h2>Friends:</h2>
                    <%
                        for (Users u : friendsList) {
                    %>
                    <hr class="style1">
                    <%
                        if (u.getProfilePicture().equals(null)) {
                    %>
                    <a class ="customLink" href="UserPageLoadServlet?userID=<%= u.getId() %>">
                        <img src="/img/icon.jpg" class="rounded-circle" width="50" height="50">
                        <%= u.getName()%> <%= u.getSurname()%>
                    </a>
                    <a href="RemoveFriendServlet?id=<%= u.getId()%>" class="btn btn-danger">
                        <i class="material-icons">
                            delete
                        </i>
                        Remove
                    </a>
                    <%
                    } else {
                    %>
                    <a class ="customLink" href="UserPageLoadServlet?userID=<%= u.getId() %>">
                        <img src="<%= u.getProfilePicture()%>" class="rounded-circle" width="50" height="50">
                        <%= u.getName()%> <%= u.getSurname()%>
                    </a>
                    <a href="RemoveFriendServlet?id=<%= u.getId()%>" class="btn btn-danger">
                        <i class="material-icons">
                            delete
                        </i>
                        Remove
                    </a>
                    <%
                                }
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
