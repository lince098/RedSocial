<%-- 
    Document   : login
    Created on : 30-mar-2019, 11:36:25
    Author     : PabloGL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Login</title>

        <%
            String error = (String) request.getAttribute("loginError");
        %>


    </head>
    <body class="bg-dark">

        <h1 class='row text-secondary justify-content-center'>RedSocial</h1>
        <br><br><br>
        <div class="container col-6 justify-content-center bg-light p-4 rounded"  >

            <h1 class="text-primary"> Login</h1>

            <%
                if (error != null) {
            %>  
            <p class="text-danger row-justify-content-left"><%=error%></p>
            <%
                }
            %>

            <form action="loginServlet" method="post">

                <div class="form-group ">
                    <label for="emailInput">Email adress</label>
                    <input type="email" class="form-control" name="email" id="emailInput" placeholder="Enter email here">
                </div>

                <div class="form-group ">
                    <label for="passwordInput">Password</label>
                    <input type="password" name="password" class="form-control" id="passwordInput" placeholder="Enter password here">
                </div>

                <button type="submit" class="btn btn-primary float-right">Log in</button>
                <br><br>

                <p align='center'><a href="" >¿Forgot your password?</a></p>
                <p align='center'>Do you want to <a href="Register.jsp">register</a>?</p>

            </form>
        </div> 
    </div>
</body>
</html>
