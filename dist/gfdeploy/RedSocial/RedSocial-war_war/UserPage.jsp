<%-- 
    Document   : UserPage
    Created on : 2019-04-07, 23:49:56
    Author     : Kamila
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>RedSocial</title>

    </head>
    <body>
        <div class="bg-light p-4 rounded">
            <div class="portlet light profile-sidebar-portlet bordered">
                <div class="profile-userpic">
                    <img src="https://pbs.twimg.com/profile_images/2755433470/331f139a4cf14ed329a893ca189154f8.jpeg" class="img-responsive" alt=""> </div>
                <div class="profile-username">
                    <div class="profile-usertitle-name"> Jike Glynn </div>
                </div>
                <div class="profile-userbuttons">
                    <button type="button" class="btn btn-info  btn-sm">Add To Friends</button>
                    <button type="button" class="btn btn-info  btn-sm">Message</button>
                    <button type="button" class="btn btn-info  btn-sm">Groups</button>
                    <button type="button" class="btn btn-info  btn-sm">Information</button>
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
                    <li class="nav-item">
                        <a class="nav-link" id="images-tab" data-toggle="tab" role="tab" aria-controls="images" aria-selected="false" href="#images">Images</a>
                    </li>
                </ul>
            </div>
            <div class="card-body">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                        <div class="form-group">
                            <label class="sr-only" for="message">post</label>
                            <textarea class="form-control" id="message" rows="3" placeholder="What are you thinking?"></textarea>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                        <div class="form-group">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="customFile">
                                <label class="custom-file-label" for="customFile">Upload image</label>
                            </div>
                        </div>
                        <div class="py-4"></div>
                    </div>
                </div>
                <div class="btn-toolbar justify-content-between">
                    <div class="btn-group">
                        <button type="submit" class="btn btn-primary">share</button>
                    </div>
                    <div class="btn-group">
                        <button id="btnGroupDrop1" type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                            <i class="fa fa-globe"></i>
                        </button>
                    </div>
                    <div class="card-body">
                        <div class="text-muted h7 mb-2"> <i class="fa fa-clock-o"></i>10 min ago</div>
                        <a class="card-link" href="#">
                            <h5 class="card-title">Sadzonki</h5>
                        </a>

                        <p class="card-text">
                            Nie ma, ze jest dobrze, czy jest niedobrze. Lubie sadzic nawet marchew.
                        </p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="card-link"><i class="fa fa-gittip"></i> Like</a>
                        <a href="#" class="card-link"><i class="fa fa-comment"></i> Comment</a>
                        <a href="#" class="card-link"><i class="fa fa-mail-forward"></i> Share</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>