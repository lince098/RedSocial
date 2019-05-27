<%-- 
    Document   : CreateGroup
    Created on : 10-may-2019, 17:58:14
    Author     : PabloGL
--%>

<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create group</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
        <%
            String error = (String) request.getAttribute("error");
        %>
    </head>
    <body>
        
        
        <!-- Navbar  -->
        
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
                    
                    
        <!-- Navbar  -->            
                    
         
        
        <form id="cancelForm" action="<%= request.getContextPath()%>/MainPage.jsp" method="post">
        </form>

        <div class="container col-7 bg-light p-4 rounded">

            <h1 class="text-primary">Create a group</h1>
            <%
                if (error != null) {
            %>
            <p class="text-danger"> <%= error%> </p>
            <%
                }
            %>

            <form id="createForm" method="post" action="../CreateGroup">
                <div class="form-group ">
                    <label for="nameInput">Name</label>
                    <input type="text" class="form-control" name="name" id="nameInput" placeholder="Enter name here">
                </div>
                <div class="form-group">
                    <label for="descriptionInput">Description</label>
                    <input type="text" class="form-control" name="description" id="descriptionInput" placeholder="Enter description here">
                </div>

                <!-- A VER COMO VA LO DE LAS IMAGENES
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="customFile">
                        <label class="custom-file-label" for="customFile">Upload image</label>
                    </div>
                </div>
                -->
                <br>
            </form>
            <button type="submit" form="cancelForm" formmethod="post" class="btn btn-danger float-left">Cancel</button>
            <button type="submit" form="createForm" formmethod="post" class="btn btn-primary float-right">Create</button>
            <br>

        </div>
    </body>
</html>