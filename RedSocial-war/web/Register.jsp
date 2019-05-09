<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <%
            String error = (String) request.getAttribute("error");
            String success = (String) request.getAttribute("success");
        %>
       <!--
        <style>
            body{
                background-image: URL(Backgrounds/grupo-gente.jpg) 
            }
        </style> -->
    </head>
    <body background-image="Backgrounds/grupo-gente.jpg">
        <div class="container col-7">
            <div class="bg-light p-4 rounded">
                <h1 class="text-primary">Register</h1>

                <%
                    if (error != null) {
                %>
                <p class="text-danger"> <%= error %> </p>
                <%
                    }
                %>
                
                <%
                    if (success != null) {
                %>
                <p class="text-success"> <%= success %> </p>
                <%
                    }
                %>

                <form method="post" action="RegistroServlet">
                    <div class="form-group ">
                        <label for="emailInput">Email adress</label>
                        <input type="email" class="form-control" name="email" id="emailInput" placeholder="Enter email here">
                    </div>

                    <div class="form-group ">
                        <label for="passwordInput">Password</label>
                        <input type="password" class="form-control" name="password" id="passwordInput" placeholder="Enter password here">
                    </div>

                    <div class="form-group ">
                        <label for="nameInput">Name</label>
                        <input type="text" class="form-control" name="name" id="nameInput" placeholder="Enter name here">
                    </div>

                    <div class="form-group ">
                        <label for="surnameInput">Surname</label>
                        <input type="text" class="form-control" name="surname" id="surnameInput" placeholder="Enter surname here">
                    </div>

                    <div class="form-group ">
                        <label for="dateInput">Birthday</label>
                        <input type="date" class="form-control" name="birthday" id="dateInput">
                    </div>
                    <div class="form-group">
                        <label>Sex</label>
                        <br>
                        <label class="radio-inline"><input type="radio" name="sex" value="M" >Male</label>
                        <label class="radio-inline"><input type="radio" name="sex" value="F" >Female</label>
                    </div>

                    <button type="submit" class="btn btn-primary float-right">Register</button>
                    <br>
                </form>
            </div>
        </div>
    </body>
</html>
