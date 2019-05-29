<%-- 
    Document   : JoinPetitionsList
    Created on : 09-may-2019, 21:50:37
    Author     : PabloGL
--%>

<%@page import="java.util.List"%>
<%@page import="Services.GrupoService"%>
<%@page import="RedSocialEntities.Grupos"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Petitions</title>
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
            List<Users> joinPetitions = GrupoService.getGroupJoinPetitions(group);
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
            <a href="LogOutServlet" class="btn btn-danger">Log Out</a>
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
        <br>
        <h4 align="center">Petitions</h4>
        <br><br><br>

        <table class="table col-4" align="center">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Accept</th>
                    <th scope ="col">Ignore</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 1;
                    int idUser;
                    int groupId = group.getId();
                    String formUser;
                    String acceptUser;
                    String declineUser;
                    for (Users u : joinPetitions) {
                        idUser = u.getId();
                        formUser = "user" + idUser;
                        acceptUser = "accept" + idUser;
                        declineUser = "decline" + idUser;
                %>

            <form id="<%= formUser%>" action="UserPageLoadServlet" >
                <input type="hidden" name="userID" value="<%= idUser%>" >
            </form>

            <form id="<%= acceptUser%>" action="AcceptPetition" >
                <input type="hidden" name="groupId" value="<%= groupId%>" >
                <input type="hidden" name="userId" value="<%= idUser%>" >
            </form>
            <form id="<%= declineUser%>" action="IgnorePetition" >
                <input type="hidden" name="groupId" value="<%= groupId%>" >
                <input type="hidden" name="userId" value="<%= idUser%>" >
            </form>
            <tr>
                <th scope="row"><%= i%></th>

                <td><button type="submit" form="<%= formUser%>" formmethod="post" class="btn btn-link"> <%= u.getName()%> <%= u.getSurname()%></button></td>

                <td>
                    <button  type="submit" form="<%= acceptUser%>" formmethod="post" class="btn btn-link">
                        Accept
                    </button>
                </td>
                <td>
                    <button  type="submit" form="<%= declineUser%>" formmethod="post" class="btn btn-link">
                        Decline
                    </button>
                </td>
                <%
                        i++;
                    }
                %>
                </tbody>
        </table>
    </body>
</html>