<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>SceonBlog - My own blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">

    <!-- Loading Bootstrap -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="//cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">

    <link href="//cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/r23/html5.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.js"></script>
    <![endif]-->

    <style>
        body {
            overflow-x: hidden;
            background-color: #95a5a6;
        }
        .pageTitle {
            padding: 20px 0;
        }
        .right {
            float: right;
        }
    </style>
</head>
<body>
    <c:import url="top.jsp" charEncoding="UTF-8"></c:import>
    <div class="container" style="width: 100%;">
        <div class="row">
            <div class="col-md-2 col-xs-2" style="padding-left: 0;">
                <c:import url="left.jsp" charEncoding="UTF-8"></c:import>
            </div>
            <div class="col-md-9 col-xs-9">
                <div class="row pageTitle">
                    <span class="col-md-2 col-xs-2">写文章</span>
                    <span class="col-md-2 col-xs-2 right">
                        <button class="btn btn-block btn-md btn-primary"> 保存 </button>
                    </span>
                </div>
                <div class="row form">
                    <div class="col-md-12 col-xs-12">
                        <form id="articleForm" class="form-horizontal" name="loginForm" action="<%=path%>/manage/article/save" method="post">
                            <c:if test="${error!=null}">
                                <div class="row">
                                    <div id="pageError" class="form-group text-danger col-md-12 col-xs-12">
                                        ${error}
                                    </div>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <label for="title" class="col-md-2 col-xs-2 control-label">标题</label>
                                <div class="col-md-9 col-xs-9">
                                    <input type="text" class="form-control" value="" id="title" name="title" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="subtitle" class="col-md-2 col-xs-2 control-label">子标题</label>
                                <div class="col-md-9 col-xs-9">
                                    <input type="text" class="form-control" value="" id="subtitle" name="subtitle" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="col-md-2 col-xs-2 control-label">分类</label>
                                <div class="col-md-3 col-xs-3">
                                    <input type="text" class="form-control" value="" id="category" name="articleCategory" />
                                </div>
                                <div class="col-md-2 col-xs-2">
                                    <button class="btn btn-block btn-md btn-primary"> 新建分类 </button>
                                </div>
                                <label for="tags" class="col-md-1 col-xs-1 control-label">标签</label>
                                <div class="col-md-3 col-xs-3">
                                    <input type="text" class="form-control" value="" id="tags" name="tags" />
                                </div>
                            </div>
                            <div class=" form-group">
                                <label for="description" class="col-md-2 col-xs-2 control-label">简介</label>
                                <div class="col-md-9 col-xs-9">
                                    <textarea type="text" class="form-control" value="" id="description" name="description"></textarea>
                                </div>
                            </div>

                            <!--<a class="login-link" href="#">Lost your password?</a>-->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="//cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
</body>
</html>