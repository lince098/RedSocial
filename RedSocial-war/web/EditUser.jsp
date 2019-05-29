<%-- 
    Document   : Edit
    Created on : 29-abr-2019, 9:54:33
    Author     : Alae Akalay
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Edit Profile</title>
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
        <%
            String error = (String) request.getAttribute("error");
            String success = (String) request.getAttribute("success");
            Users u = (Users) session.getAttribute("currentSession");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = format.format(u.getBirthday());

            String profilePicture = "";
            if (u.getProfilePicture() != null) {
                profilePicture = u.getProfilePicture();
            }
        %>
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
            <h1 class="text-primary">Edit Profile</h1>

            <%
                if (error != null) {
            %>
            <p class="text-danger"> <%= error%> </p>
            <%
                }
            %>

            <%
                if (success != null) {
            %>
            <p class="text-success"> <%= success%> </p>
            <%
                }
            %>
            <form method="post" action="EditUserServlet">
                <div class="form-group ">
                    <label for="emailInput">Email adress</label>
                    <input type="email" class="form-control" name="email" id="emailInput" placeholder="Edit email here"
                           value = "<%= u.getEmail()%>">
                </div>

                <div class="form-group ">
                    <label for="passwordInput">Password</label>
                    <input type="password" class="form-control" name="password" id="passwordInput" placeholder="Edit password here"
                           value = "<%= u.getPassword()%>">
                </div>

                <div class="form-group ">
                    <label for="nameInput">Name</label>
                    <input type="text" class="form-control" name="name" id="nameInput" placeholder="Edit name here"
                           value = "<%= u.getName()%>">
                </div>

                <div class="form-group ">
                    <label for="surnameInput">Surname</label>
                    <input type="text" class="form-control" name="surname" id="surnameInput" placeholder="Edit surname here"
                           value = "<%= u.getSurname()%>">
                </div>

                <div class="form-group ">
                    <label for="dateInput">Birthday</label>
                    <input type="date" class="form-control" name="birthday" id="dateInput" placeholder="Edit birthday here"
                           value = "<%= birthday%>">
                </div> 

                <div class="form-group">
                    <label>Profile Picture</label>
                    <input type="text" class="form-control" name="profilePicture" id="profilePicture" placeholder="Edit profile picture here"
                           value = "<%= profilePicture%>">
                </div>

                <button type="submit" class="btn btn-primary float-right">Save</button>
                <br>
            </form>
        </div>
    </body>
</html>
