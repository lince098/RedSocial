<%-- 
    Document   : newjsp
    Created on : 10-may-2019, 10:38:04
    Author     : PabloGL
--%>

<%@page import="RedSocialEntities.Grupos"%>
<%@page import="Services.UserService"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Users u = (Users) session.getAttribute("user");
        %>
    </head>
    <body>
        <%= request.getContextPath() %> <%= request.getPathInfo() %> <%= request.getAuthType() %> 
        <%= request.getRequestURI() %> <%= request.getServerName() %> <%= request.getLocalName() %>
        
        <h1>Lista de grupos</h1> <br>
        <ul>
            <%for (Grupos g : UserService.getGrupos(u)) {%>
            <li><%= g.getName() %></li><br>
            <%
                }
            %>
        </ul>
        
        <h1>Lista de grupos administrados</h1><br>
        <ul>
            <%for (Grupos g : UserService.getAdministratedGroups(u)) {%>
            <li><%= g.getName() %></li><br>
            <%
                }
            %>
        </ul>
        
        <h1>Lista de grupos a los que pido unirme</h1><br>
        <ul>
            <%for (Grupos g : UserService.getGroupJoinPetitions(u)) {%><br>
            <li><%= g.getName() %></li>
            <%
                }
            %>
        </ul>
        
    </body>
</html>
