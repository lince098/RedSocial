<%@page import="RedSocialEntities.Post"%>
<%@page import="RedSocialEntities.Profileposts"%>
<%@page import="java.util.List"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Users currentSession = (Users) session.getAttribute("currentSession");
            List<Profileposts> listaPost = currentSession.getProfilepostsList();
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
                width: 270px;
                padding: 10px;
            } 
            .navbar-toggler {
                position: relative;
                right: 0px;
                margin-left: 150px;
            } 
        </style>

    </head>
    <body>

        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Red social</h1>
        </div>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Main Page</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a class="nav-link" href="#">FriendList</a>
                    </li>
                    <li>
                        <a class="nav-link" href="#">Groups</a>
                    </li>
                </ul>
            </div>  
            <div class="right">
                <input type="text" placeholder="Search.." name="search" style="right">
                <button type="submit">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </nav>

        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-4">
                    <h2>About Me</h2>
                    <h5>Name:</h5>
                    <p><%= currentSession.getName()%></p>
                    <h5>Profile photo:</h5>
                    <%
                        if (currentSession.getProfilePicture().equals(null)) {
                    %>
                    <img src="/img/icon.jpg" width="100" height="100">
                    <%
                    } else {
                    %>
                    <img src="<%= currentSession.getProfilePicture()%>" width="100" height="100">
                    <%
                        }
                    %>
                    <h3>Options</h3>
                    <%-- 
                    <a class="nav-link active" href="#"> 
                    <a class="nav-link disabled" href="#">
                    --%>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Create Post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Edit Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">View Messages</a>
                        </li>
                    </ul>
                    <hr class="d-sm-none">
                </div>
                <div class="col-sm-8">
                    <%
                        for (Profileposts p : listaPost) {
                            Post post = p.getPost();
                    %>
                    <%
                        if (post.getAuthor().getProfilePicture().equals(null)) {
                    %>
                    <img src="/img/icon.jpg" class="rounded-circle" width="50" height="50"><%= post.getAuthor().getName() %> <%= post.getAuthor().getSurname() %>
                    <%
                    } else {
                    %>
                    <img src="<%= post.getAuthor().getProfilePicture()%>" class="rounded-circle" width="50" height="50"><%= post.getAuthor().getName() %> <%= post.getAuthor().getSurname() %>
                    <%
                        }
                    %>
                    
                    <h2><%= post.getTitle() %></h2>
                    <h5><%= post.getDate().toString() %></h5>
                    <%-- <img src="<%= post.getPostPhoto() %>" style="height:200px;"> --%>
                    <p><%= post.getText()%></p>

                    <br>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>