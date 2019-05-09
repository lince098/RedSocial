<%-- 
    Document   : GroupMemberList
    Created on : 08-may-2019, 19:55:41
    Author     : PabloGL

    Receives 
    group

--%>

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

        <%
            Grupos group = (Grupos) request.getAttribute("group");
        %>
    </head>
    <body>
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
                    for (Users u : GrupoService.getAdmins(group)) {
                %>
                <tr>
                    <th scope="row"><%= i%></th>
                    <td><%= u.getName()%> <%= u.getSurname()%></td>
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

                </tr>
            </thead>
            <tbody>

                <%
                    i = 1;
                    for (Users u : GrupoService.getMembers(group)) {
                %>
                <tr>
                    <th scope="row"><%= i%></th>
                    <td><%= u.getName()%> <%= u.getSurname()%></td>
                </tr>

                <%
                        i++;
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
