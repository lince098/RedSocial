<%-- 
    Document   : SearchPage
    Created on : 10-may-2019, 14:02:26
    Author     : Rafa
--%>

<%@page import="RedSocialEntities.Grupos"%>
<%@page import="java.util.List"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Users currentSession = (Users) session.getAttribute("currentSession");
            List<Users> listUsers = (List<Users>) request.getAttribute("listUsers");
            List<Grupos> listGroups = (List<Grupos>) request.getAttribute("listGroups");
            Integer filter = (Integer) request.getAttribute("filter");
        %>
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
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
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
            <button type="button" class="btn btn-primary" onclick="myFunctionAll()" id="buttonAll">All</button>
            <button type="button" class="btn btn-primary" onclick="myFunctionOnlyPeople()" id="buttonPeople">Only people</button>
            <button type="button" class="btn btn-primary" onclick="myFunctionOnlyGroups()" id="buttonGroup">Only groups</button>
            <%
                if ((listUsers == null || listUsers.isEmpty()) && (listGroups == null || listGroups.isEmpty())) {
            %>
            <h2>Not results found</h2>
            <%
            } else {
            %>
            <div id="peopleTable">
                <%
                    if (listUsers == null || listUsers.isEmpty()) {
                %>
                <h2>Not results found</h2>
                <%
                } else {
                    for (Users u : listUsers) {
                %>
                <hr class="style1">
                <%
                    if (u.equals(currentSession)) {
                        if (u.getProfilePicture() == null) {
                %>
                <a class ="customLink" href="MainPage.jsp">
                    <img src="/img/icon.jpg" class="rounded-circle" width="50" height="50">
                    <%= u.getName()%> <%= u.getSurname()%>
                </a>
                <%
                } else {
                %>
                <a class ="customLink" href="MainPage.jsp">
                    <img src="<%= u.getProfilePicture()%>" class="rounded-circle" width="50" height="50">
                    <%= u.getName()%> <%= u.getSurname()%>
                </a>
                <%
                    }
                } else if (u.getProfilePicture() == null) {
                %>
                <a class ="customLink" href="UserPageLoadServlet?userID=<%= u.getId()%>">
                    <img src="/img/icon.jpg" class="rounded-circle" width="50" height="50">
                    <%= u.getName()%> <%= u.getSurname()%>
                </a>
                <a href="UserDestMessageServlet?id=<%= u.getId()%>" class="btn btn-primary">
                    Send message
                    <i class="far fa-envelope">
                    </i>
                </a>
                <%
                    if (!currentSession.getUsersList().contains(u)) {
                %>
                <a class="btn btn-primary" href="FriendshipPetitionServlet?userID=<%= u.getId()%>">
                    Send friend petition
                    <i class="fas fa-user-plus"></i>
                </a>
                <%
                    }
                } else {
                %>
                <a class ="customLink" href="UserPageLoadServlet?userID=<%= u.getId()%>">
                    <img src="<%= u.getProfilePicture()%>" class="rounded-circle" width="50" height="50">
                    <%= u.getName()%> <%= u.getSurname()%>
                </a>
                <a href="UserDestMessageServlet?id=<%= u.getId()%>" class="btn btn-primary">
                    Send message
                    <i class="far fa-envelope">
                    </i>
                </a>
                <%
                    if (!currentSession.getUsersList().contains(u)) {
                %>
                <a class="btn btn-primary" href="FriendshipPetitionServlet?userID=<%= u.getId()%>">
                    Send friend petition
                    <i class="fas fa-user-plus"></i>
                </a>
                <%
                                }
                            }
                        }
                    }
                %>
            </div>
            <div id="groupTable">
                <%
                    if (listGroups == null || listGroups.isEmpty()) {
                %>
                <h2>Not results found</h2>
                <%
                } else {
                    for (Grupos g : listGroups) {
                %>
                <hr class="style1">
                <%
                    if (g.getImagePath() == null) {
                %>
                <a class ="customLink" href="GroupPageServlet?groupId=<%= g.getId()%>">
                    <img src="/img/groupIcon.jpg" class="rounded-circle" width="50" height="50">
                    <%= g.getName()%>
                </a>
                <%
                } else {
                %>
                <a class ="customLink" href="GroupPageServlet?groupId=<%= g.getId()%>">
                    <img src="<%= g.getImagePath()%>" class="rounded-circle" width="50" height="50">
                    <%= g.getName()%>
                </a>
                <%
                            }
                        }
                    }
                %>
            </div>
            <%
                }
            %>
        </div>


        <script>
            window.onload(initTables())
            function initTables() {
                var peopleTable = document.getElementById("peopleTable");
                var groupTable = document.getElementById("groupTable");
                var bPeople = document.getElementById("buttonPeople");
                var bGroup = document.getElementById("buttonGroup");
                var bA = document.getElementById("buttonAll");
                if (<%= filter%> === 1) {
                    peopleTable.style.display = "block";
                    groupTable.style.display = "none";
                    bPeople.disabled = true;
                    bGroup.disabled = false;
                    bA.disabled = false;
                } else if (<%= filter%> === 2) {
                    peopleTable.style.display = "none";
                    groupTable.style.display = "block";
                    bPeople.disabled = false;
                    bGroup.disabled = true;
                    bA.disabled = false;
                } else {
                    peopleTable.style.display = "block";
                    groupTable.style.display = "block";
                    bPeople.disabled = false;
                    bGroup.disabled = false;
                    bA.disabled = true;
                }
            }

            function myFunctionOnlyPeople() {
                var peopleTable = document.getElementById("peopleTable");
                var groupTable = document.getElementById("groupTable");
                var bPeople = document.getElementById("buttonOnlyPeople");
                var bGroup = document.getElementById("buttonOnlyGroups");
                var bA = document.getElementById("buttonAll");
                peopleTable.style.display = "block";
                groupTable.style.display = "none";
                bPeople.disabled = true;
                bGroup.disabled = false;
                bA.disabled = false;
            }

            function myFunctionOnlyGroups() {
                var peopleTable = document.getElementById("peopleTable");
                var groupTable = document.getElementById("groupTable");
                var bPeople = document.getElementById("buttonOnlyPeople");
                var bGroup = document.getElementById("buttonOnlyGroups");
                var bA = document.getElementById("buttonAll");
                peopleTable.style.display = "none";
                groupTable.style.display = "block";
                bPeople.disabled = false;
                bGroup.disabled = true;
                bA.disabled = false;
            }

            function myFunctionAll() {
                var peopleTable = document.getElementById("peopleTable");
                var groupTable = document.getElementById("groupTable");
                var bPeople = document.getElementById("buttonOnlyPeople");
                var bGroup = document.getElementById("buttonOnlyGroups");
                var bA = document.getElementById("buttonAll");
                peopleTable.style.display = "block";
                groupTable.style.display = "block";
                bPeople.disabled = false;
                bGroup.disabled = false;
                bA.disabled = true;
            }
        </script>
    </body>
</html>
