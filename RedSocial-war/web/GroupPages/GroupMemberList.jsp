<%-- 
    Document   : GroupMemberList
    Created on : 08-may-2019, 19:55:41
    Author     : PabloGL
    Receives 
    group
--%>

<%@page import="java.util.List"%>
<%@page import="RedSocialEntities.Users"%>
<%@page import="Services.GrupoService"%>
<%@page import="RedSocialEntities.Grupos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member List</title>
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
            Grupos group = (Grupos) request.getAttribute("group");
            List<Users> memberList = GrupoService.getMembers(group);
            List<Users> adminsList = GrupoService.getAdmins(group);
            Users currentSession = (Users) request.getSession().getAttribute("currentSession");
            boolean isAdmin = adminsList.contains(currentSession);
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








        <form id="groupForm" action="GroupPageServlet" method="post" >
            <input type="hidden" value="<%= group.getId()%>" name="groupId">
        </form>

        <h1 align="center"><%= group.getName()%></h1>

        <br><br>
        <p align="center">
            <button type="submit" form="groupForm" formmethod="post" >Back</button>
        </p>



        <h3 align="center">Admins</h3><br><br>

        <table class="table col-4" align="center">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                </tr>
            </thead>
            <tbody>

                <%
                    int i = 1;
                    int idUser;
                    String formUser;
                    for (Users u : adminsList) {
                        idUser = u.getId();
                        formUser = "admin" + idUser;
                %>

            <form id="<%= formUser%>" action="UserPageLoadServlet" >
                <input type="hidden" name="userID" value="<%= idUser%>" >
            </form>



            <tr>
                <th scope="row"><%= i%></th>
                <td>
                    <button type="submit" form="<%= formUser%>" formmethod="post" class="btn btn-link" >
                        <%= u.getName()%> <%= u.getSurname()%>
                    </button>
                </td>
            </tr>
            <%
                    i++;
                }
            %>
        </tbody>
    </table>

    <h4 align="center">Members</h4>

    <table class="table col-4" align="center">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>

                <%
                    if (isAdmin) {
                %>
                <th scope="col">Eliminate</th>
                <th scope ="col">Promote</th>

                <%                        }
                %>

            </tr>
        </thead>
        <tbody>

            <%
                i = 1;
                for (Users u : memberList) {
                    idUser = u.getId();
                    formUser = "user" + idUser;
            %>


        <form id="<%= formUser%>" action="UserPageLoadServlet" >
            <input type="hidden" name="userID" value="<%= idUser%>" >
        </form>


        <tr>
            <th scope="row"><%= i%></th>
            <td>
                <button type="submit" form="<%= formUser%>" formmethod="post" class="btn btn-link" >
                    <%= u.getName()%> <%= u.getSurname()%>
                </button>
            </td>

            <%
                if (isAdmin) {
                    if (!adminsList.contains(u)) {
            %>
            <td><a href="<%= request.getContextPath()%>/EliminateFromGroup?groupId=<%= group.getId()%>&userId=<%= u.getId()%>">
                    Eliminate</a></td>
                    <%
                    } else {
                    %>
            <td>Admin</td>
            <%
                }
            %>

            <%
                if (!adminsList.contains(u)) {
            %>
            <td><a href="<%= request.getContextPath()%>/MakeAdminGroup?groupId=<%= group.getId()%>&userId=<%= u.getId()%>">Make Admin</a></td>
            <%
            } else {
            %>
            <td>Admin</td>
            <%
                    }
                }
            %>

        </tr>

        <%
                i++;
            }
        %>
    </tbody>
</table>

</body>
</html>