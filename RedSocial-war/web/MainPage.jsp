<%@page import="Services.PostService"%>
<%@page import="java.util.ArrayList"%>
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
            List<Profileposts> postList = new ArrayList<Profileposts>();
            if (currentSession != null && !currentSession.getProfilepostsList().isEmpty()) {
                postList = currentSession.getProfilepostsList();
            }
        %>
        <title>Red social</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
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
            a.like{
                color: blue;
            }
            a.like.disabled{
                color: lightblue;
            }
            a.dislike{
                color: red;
            }
        </style>
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
        </nav>

        <div class="container col-9" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-4">
                    <h2>About Me</h2>
                    <h5>Name:</h5>
                    <p><%= currentSession.getName()%></p>
                    <h5>Surname:</h5>
                    <p><%= currentSession.getSurname()%></p>
                    <h5>Profile photo:</h5>
                    <%
                        if (currentSession.getProfilePicture() == null) {
                    %>
                    <img src="img/icon.jpg" width="100" height="100">
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
                            <a class="nav-link" href="EditUser.jsp">Edit Profile</a>
                        </li>
                        <li class="nav-item">
                            <%
                                if (currentSession.getMessagesList().isEmpty()) {
                            %>
                            <a class="btn btn-outline-primary" href="UserInboxServlet">
                                Messages
                                <i class="far fa-envelope-open"></i>
                            </a>
                            <%
                            } else {
                            %>
                            <a class="btn btn-primary" href="UserInboxServlet">
                                Messages
                                <i class="far fa-envelope"></i>
                            </a>
                            <%
                                }
                            %>
                        </li>
                    </ul>
                    <hr class="d-sm-none">
                </div>
                <div class="col-sm-8">
                    <form action="SubmitPostServlet">
                        <textarea class="form-control" name="title" id="title" rows="1" placeholder="Title"></textarea>
                        <textarea class="form-control" name="postMessage" id="postMessage" rows="3" placeholder="What are you thinking?"></textarea>
                        <select class="form-control" name="vision" id="vision" style="margin-top: 12px;">
                            <option name="Public">Public</option>
                            <option name="FriendsOnly">Friends only</option>
                        </select>
                        <input type="submit" class="btn btn-primary postButton" value="Post">
                    </form>
                    <br/>
                    <br/>
                    <%
                        if (postList != null && !postList.isEmpty()) {
                            for (Profileposts p : postList) {
                                Post post = p.getPost();
                    %>
                    <hr class="style1">
                    <%
                        if (post.getAuthor().getProfilePicture() == null) {
                    %>
                    <img src="/img/icon.jpg" class="rounded-circle" width="50" height="50">
                    <%
                    } else {
                    %>
                    <img src="<%= post.getAuthor().getProfilePicture()%>" class="rounded-circle" width="50" height="50">
                    <%
                        }
                    %>
                    <%= post.getAuthor().getName()%> <%= post.getAuthor().getSurname()%>
                    <h2><%= post.getTitle()%></h2>
                    <h5><%= post.getDate().toString()%></h5>
                    <p><%= post.getText()%></p>
                    <%
                        List<Users> likes = PostService.getLikeList(post);
                        if (likes.contains(currentSession)) {
                    %>
                    <%= likes.size()%>   
                    <a class="btn like disabled" href="CreatePostLike?isGroupPost=false&postID=<%= post.getId()%>&isMainPage=true" style="width: 0px">
                        <span class="fa fa-thumbs-up"></span>
                    </a>
                    <a class="btn dislike" href="?isGroupPost=false&postID=<%= post.getId()%>&isMainPage=true">
                        <span class="fa fa-thumbs-down" style="width: 0px"></span>
                    </a>
                    <%
                    } else {
                    %>
                    <%= likes.size()%>
                    <a class="btn like" href="CreatePostLike?isGroupPost=false&postID=<%= post.getId()%>&isMainPage=true">
                        <span class="fa fa-thumbs-up"> <%= likes.size()%></span>
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