<%-- 
    Document   : EditGroup
    Created on : 10-may-2019, 18:29:24
    Author     : PabloGL
--%>

<%@page import="RedSocialEntities.Grupos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Group</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <%
            Grupos group = (Grupos) request.getAttribute("group");
            String error = (String) request.getAttribute("error");

        %>
    </head>
    <body>
        <form id="cancelForm" action="GroupPageServlet" method="post">
            <input type="hidden" name="groupId" value="<%= group.getId()%>">
        </form>

        <div class="container col-7 bg-light p-4 rounded">

            <h1 class="text-primary">Edit group: <%= group.getName()%></h1>
            <%
                if (error != null) {
            %>
            <p class="text-danger"> <%= error%> </p>
            <%
                }
            %>

            <form id="createForm" method="post" action="EditGroupServlet">
                <input type="hidden" name="groupId" value="<%= group.getId()%>">

                <div class="form-group ">
                    <label for="nameInput">Name</label>
                    <input type="text" class="form-control" name="name" id="nameInput" value="<%= group.getName()%>">
                </div>
                <div class="form-group">
                    <label for="descriptionInput">Description</label>
                    <input type="text" class="form-control" name="description" id="descriptionInput" value="<%= group.getDescription()%>">
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
            <button type="submit" form="createForm" formmethod="post" class="btn btn-primary float-right">Edit</button>
            <br>

        </div>
    </body>
</html>
