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
        
        <%
            Grupos group = (Grupos) request.getAttribute("group");
            List<Users> joinPetitions = GrupoService.getGroupJoinPetitions(group);

        %>

    </head>
    <body>
        <form id="groupForm" action="GroupPageServlet" method="post" >
            <input type="hidden" value="<%= group.getId()%>" name="groupId">
        </form>
        <h1 align="center"><%= group.getName() %></h1>
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
                    for (Users u : joinPetitions) {
                %>
                <tr>
                    <th scope="row"><%= i %></th>
                    <td><%= u.getName() %> <%= u.getSurname() %></td>
                    <td><a href="<%= request.getContextPath() %>/AcceptPetition?groupId=<%= group.getId() %>&userId=<%= u.getId() %>">
                            Accept</a></td>
                    <td><a href="<%= request.getContextPath() %>/IgnorePetition?groupId=<%= group.getId() %>&userId=<%= u.getId() %>">
                            Ignore</a></td>
                </tr>
                <%
                    i++;
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
