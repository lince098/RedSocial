<%-- 
    Document   : GroupPage
    Created on : 29-abr-2019, 10:33:34
    Author     : PabloGL

    The frontend was mostly made by kamila
--%>


<%@page import="RedSocialEntities.Post"%>
<%@page import="Services.PostService"%>
<%@page import="java.util.List"%>
<%@page import="sun.nio.cs.ext.GB18030"%>
<%@page import="Services.GrupoService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="RedSocialEntities.Groupposts"%>
<!--

    Receive
    currentSession
    group
    isAdmin, isMember : boolean
    postToShow    Visibilidad total o sólo los públicos


    Sends to GroupJoinPetition   
    
    groupId

    Sends to PetitionListServlet
    
    group (id)

-->



<%@page import="RedSocialEntities.Users"%>
<%@page import="RedSocialEntities.Grupos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <%
            Users currentSession = (Users) session.getAttribute("currentSession");
            Grupos group = (Grupos) request.getAttribute("group");
            List<Groupposts> postList = (List) request.getAttribute("postList");
            boolean isAdmin = (Boolean) request.getAttribute("isAdmin"), isMember = (Boolean) request.getAttribute("isMember");

            String disablePublish = isMember ? "" : "disabled";

            Integer groupId = group.getId();

            SimpleDateFormat dfPost = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            SimpleDateFormat dfGroupCreationDate = new SimpleDateFormat("dd-MM-yyyy");
            int numberOfPetitions = GrupoService.getGroupJoinPetitions(group).size();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title><%= group.getName()%></title>
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


        <div class="bg-light p-4 rounded">
            <div class="portlet light profile-sidebar-portlet bordered">
                <div class="profile-userpic">
                    <img src="http://rampages.us/univ112boaz14/wp-content/uploads/sites/436/2014/08/group-circle.jpg" class="border "  alt="" width="300px" height="300 px"> 
                </div>
                <div class="profile-username">
                    <h3><%= group.getName()%> </h3>
                </div>

                <div class="profile-userbuttons">


                    <!-- Separo el form del boton para que no se me descuajeringue el front -->

                    <form   id="memberListForm" action="GroupMemberlist" >
                        <input type="hidden" value="<%= group.getId()%>" name="groupId">
                    </form>

                    <form   id="petitionListForm" action="PetitionListServlet" >
                        <input type="hidden" value="<%= group.getId()%>" name="groupId">
                    </form>

                    <form id="cancelForm" action="GroupCancelPetition"  >
                        <input type="hidden" value="<%= group.getId()%>" name="groupId">
                    </form>

                    <form id="joinForm" action="GroupJoinPetition"  >
                        <input type="hidden" value="<%= group.getId()%>" name="groupId">
                    </form>

                    <form id="leaveGroupForm" action="LeaveGroup"  >
                        <input type="hidden" value="<%= group.getId()%>" name="groupId">
                    </form>

                    <form id="editGroupForm" action="PreEditGroup"  >
                        <input type="hidden" value="<%= group.getId()%>" name="groupId">
                    </form>

                    <%
                        // Si el usuario no esta dentro del grupo  y ha mandado petición
                        if (!isMember && GrupoService.getGroupJoinPetitions(group).contains(currentSession)) {
                    %>
                    <button type="submit" form="cancelForm" formmethod="post"
                            class="btn btn-warning btn-sm btn-info">
                        Cancel Petition
                    </button>

                    <%
                        // Si el usuario no esta dentro del grupo -->
                    } else if (!isMember) {
                    %>
                    <button type="submit" form="joinForm" formmethod="post" class="btn btn-success btn-sm btn-info">
                        Join Group
                    </button>

                    <!-- Else -->
                    <%
                    } else {
                    %>
                    <button type="submit" form="leaveGroupForm" formmethod="post" class="btn btn-danger btn-sm btn-danger">Leave Group</button>
                    <!---->

                    <%
                        if (isAdmin) {
                    %>
                    <button type="submit" class="btn btn-primary btn-sm btn-info" form="editGroupForm" formmethod="post" >
                        Edit
                    </button>
                    <button type="submit" form="petitionListForm" formmethod="post" class="btn btn-primary btn-sm btn-info">Join petitions <%= numberOfPetitions%></button>
                    <%
                        }
                    %>

                    <%
                        }
                    %>





                    <button type="submit" form="memberListForm" formmethod="post" class="btn btn-primary btn-sm btn-info">
                        Members
                    </button>



                    <a class="btn btn-primary btn-sm btn-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                        Information
                    </a>
                    <div class="collapse" id="collapseExample">
                        <div class="card card-body">
                            <%= group.getDescription()%><br><br>

                            Fecha de creacion del grupo: <%= dfGroupCreationDate.format(group.getCreationDate())%> <br>

                            Numero de miembros: <%= GrupoService.getMembers(group).size()%>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- Nav tabs -->
        <div class="bg-light p-4 rounded">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Posts:</a></li>
            </ul>
        </div>
        <!--- \\\\\\\Post-->


        <div class="card gedf-card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="true">Make
                            a publication</a>
                    </li>
                    <!--
                    <li class="nav-item">
                        <a class="nav-link" id="images-tab" data-toggle="tab" role="tab" aria-controls="images" aria-selected="false" href="#images">Images</a>
                    </li>
                    -->
                </ul>
            </div>

            <!-- post content -->

            <form method="post" action="NewPost">
                <div class="card-body">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                            <div class="form-group">
                                <label class="sr-only" for="message">post</label>

                                <textarea class="form-control" id="message" rows="3" name="postText" placeholder="What are you thinking?" name="text"></textarea>

                            </div>
                        </div>

                        <!--
                        <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                            <div class="form-group">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="customFile">
                                    <label class="custom-file-label" for="customFile">Upload image</label>
                                </div>
                            </div>
                            <div class="py-4"></div>
                        </div>
                        -->
                        <!-- Publish -->

                    </div>

                    <input type="hidden" name="author" value="<%= currentSession.getId()%>">
                    <input type="hidden" name="receiverGroup" value="<%= group.getId()%>">

                    Visibilidad:<br>
                    Public <input type="radio" value="Public" name="visibilidad">  &nbsp; &nbsp;
                    Only group <input type="radio" value="Group" name="visibilidad">

                    <br><br>
                    <div class="btn-toolbar justify-content-between">
                        <div class="btn-group">
                            <button type="submit" class="btn btn-primary" <%= disablePublish%>>Publish</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <%
            String action;
            String buttonLabel;
            String form;
            Post p;
            String formAuthor;
            int idAuthor;
            for (Groupposts gp : postList) {
                p = gp.getPost();
                idAuthor = p.getAuthor().getId();
                formAuthor = "user" + idAuthor;

        %>

        <form id="<%= formAuthor%>" action="UserPageLoadServlet" >
            <input type="hidden" name="userID" value="<%= idAuthor %>" >
        </form>
        <div class="card-body">


            <div class="text-muted h7 mb-2"> <i class="fa fa-clock-o"><%= dfPost.format(p.getDate())%></i>   
            </div>
            <button type="submit" form="<%= formAuthor%>" formmethod="post" class="btn btn-link card-link" href="#">
                <h5 class="card-title"><%= p.getAuthor().getName()%> <%= p.getAuthor().getSurname()%> </h5>
            </button>
            <p class="card-text">
                <%= p.getText()%>
            </p>

            <%
                form = "formPost" + p.getId();
                List<Users> likes = PostService.getLikeList(p);
                if (likes.contains(currentSession)) {
                    buttonLabel = "Dislike";
                    action = "EliminatePostLike";
                } else {
                    buttonLabel = "Like";
                    action = "CreatePostLike";
                }
            %>

            <form id="<%= form%>" action="<%= action%>">
                <input type="hidden" name="groupId" value="<%= groupId%>" >
                <input type="hidden" name="isGroupPost" value="true">
                <input type="hidden" name="postId" value="<%= p.getId()%>">
            </form>
            <div class="card-footer">
                <button type="submit" form="<%= form%>" formmethod="post"  class="btn btn-link ">
                    <%= buttonLabel%> <span class="badge badge-pill badge-info"><%= likes.size()%></span>
                </button>
                <%
                    if (p.getAuthor().equals(currentSession) || isAdmin) {
                        form = "eliminatePost" + p.getId();
                        action = "EliminatePost";
                %>
                <button type="submit" form="<%= form%>" formmethod="post"  class="btn btn-link ">
                    Eliminate
                </button>
            </div>
            <form id="<%= form%>" action="<%= action%>">
                <input type="hidden" name="groupId" value="<%= groupId%>" >
                <input type="hidden" name="isGroupPost" value="true">
                <input type="hidden" name="postId" value="<%= p.getId()%>">
            </form>
            <%
                }
            %>

        </div>
        <%
            }
        %>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

