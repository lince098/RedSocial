<%-- 
    Document   : SearchPage
    Created on : 10-may-2019, 14:02:26
    Author     : Rafa
--%>

<%@page import="RedSocialEntities.Groups"%>
<%@page import="java.util.List"%>
<%@page import="RedSocialEntities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <%
            List<Users> listUsers = (List<Users>) request.getAttribute("listUsers");
            List<Groups> listGroups = (List<Groups>) request.getAttribute("listGroups");
            Integer filter = (Integer) request.getAttribute("filter");
        %>
        <%
            //row with: select filter - searchbox - button to go to SearchServlet
            //Shows people, groups or both row by row that you can click on image or name, and go to their own page
            //If there is no result, then the page shows a no results found text
            switch (filter) {
                case 1:
                    //1 == only people
                    break;
                case 2:
                    //2 == only groups
                    break;
                default:
                    //0 == all
                    
            }
        %>
    </body>
</html>
