<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>SceonBlog - My own blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">

    <!-- Loading Bootstrap -->
    <link href="${scheme}://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="${scheme}://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">

    <link href="${resAccessPath}/staticRes/sceon.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="${scheme}://cdn.bootcss.com/html5shiv/r23/html5.js"></script>
    <script src="${scheme}://cdn.bootcss.com/respond.js/1.4.2/respond.js"></script>
    <![endif]-->

    <style>
        body {
            overflow-x: hidden;
            background-color: #95a5a6;
        }
        .navbar {
            border-radius: 0;
        }
        footer {
            margin-top: 20px;
            min-height: 100px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-embossed" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
            <span class="sr-only">Toggle navigation</span>
          </button>
          <a class="navbar-brand" href="#">SceonTop</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-01">
          <ul class="nav navbar-nav navbar-left">
            <li><a href="#fakelink">Menu Item<span class="navbar-unread">1</span></a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Messages <b class="caret"></b></a>
              <span class="dropdown-arrow"></span>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>
            <li><a href="#fakelink">About Us</a></li>
           </ul>
           <form class="navbar-form navbar-right" action="#" role="search">
            <div class="form-group">
              <div class="input-group">
                <input class="form-control" id="navbarInput-01" type="search" placeholder="Search">
                <span class="input-group-btn">
                  <button type="submit" class="btn"><span class="fui-search"></span></button>
                </span>
              </div>
            </div>
          </form>
        </div><!-- /.navbar-collapse -->
    </nav><!-- /navbar -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7 col-md-offset-1 col-xs-11">
                <div class="panel panel-default">
                    <div class="panel-heading">Panel heading without title</div>
                    <div class="panel-body">
                        Panel content
                    </div>
                    <div class="panel-footer">
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Panel heading without title</div>
                    <div class="panel-body">
                        Panel content
                    </div>
                    <div class="panel-footer">
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Panel heading without title</div>
                    <div class="panel-body">
                        Panel content
                    </div>
                    <div class="panel-footer">
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Panel heading without title</div>
                    <div class="panel-body">
                        Panel content
                    </div>
                    <div class="panel-footer">
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-11">
                <div class="categories">
                    <div class="categories-title">
                        文章分类
                    </div>
                    <ul>
                        <li>
                            <div class="category-icon fui-location"></div>
                            <div class="category-content">
                                <div class="category-name">
                                    分类一
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="category-icon fui-location"></div>
                            <div class="category-content">
                                <div class="category-name">
                                    分类二
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="category-icon fui-location"></div>
                            <div class="category-content">
                                <div class="category-name">
                                    分类三
                                </div>
                            </div>
                        </li>
                    </ul>
                </div><!-- /.todo -->

                <div class="friendLink">
                    <div class="friendLink-title">
                        友情链接
                    </div>
                    <ul>
                        <li>www.test.com</li>
                        <li>www.test.com</li>
                        <li>www.test.com</li>
                        <li>www.test.com</li>
                        <li>www.test.com</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="container">
            Sceon Top
        </div>
    </footer>
    <script src="${scheme}://cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
    <script src="${scheme}://cdn.bootcss.com/flat-ui/2.3.0/js/flat-ui.min.js"></script>
    <script src="${resAccessPath}/staticRes/application.js"></script>
</body>
</html>