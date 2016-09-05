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

    <link href="//cdn.bootcss.com/summernote/0.8.2/summernote.css" rel="stylesheet">

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
                                <label for="title" class="col-md-1 col-xs-1 control-label">标题</label>
                                <div class="col-md-5 col-xs-5">
                                    <input type="text" class="form-control" value="" id="title" name="title" required />
                                </div>
                                <label for="category" class="col-md-1 col-xs-1 control-label">分类</label>
                                <div class="col-md-2 col-xs-2">
                                    <select class="form-control" value="" id="category" name="articleCategory"></select>
                                </div>
                                <div class="col-md-2 col-xs-2">
                                    <input id="addCategoryBtn" type="button" class="btn btn-block btn-md btn-primary" value="新建分类">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="subtitle" class="col-md-1 col-xs-1 control-label">子标题</label>
                                <div class="col-md-5 col-xs-5">
                                    <input type="text" class="form-control" value="" id="subtitle" name="subtitle" />
                                </div>
                                <label for="tags" class="col-md-1 col-xs-1 control-label">标签</label>
                                <div class="col-md-4 col-xs-4">
                                    <input type="text" class="form-control" value="" id="tags" name="tags" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-md-1 col-xs-1 control-label">简介</label>
                                <div class="col-md-10 col-xs-10">
                                    <textarea type="text" class="form-control" value="" id="description" name="description"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-md-1 col-xs-1 control-label">正文</label>
                                <div class="col-md-10 col-xs-10">
                                    <div id="summernote"></div>
                                </div>
                            </div>
                            <!--<a class="login-link" href="#">Lost your password?</a>-->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- add category modal -->
    <div class="modal fade" id="addCategoryModal" tabindex="-3" role="dialog" aria-labelledby="addCategoryModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title" id="addCategoryModalLabel">选择页面</h4>
          </div>
          <div class="modal-body">
            <div class="panel panel-default areapanel col-md-12" style="float: none;">
				<div class="panel-heading nav">
				  <span class="navbar-brand">新建分类</span>
				</div>
				<form id="categoryForm" class="form-horizontal" role="form" method="post">
				    <div class="modal-body" style="max-height: 450px; overflow-y: scroll;">
                      <div class="form-group">
                        <label for="categoryName" class="col-sm-2 control-label">分类名称</label>
                        <div class="col-sm-8">
                            <input id="categoryName" class="form-control" name="categoryName" value="" required>
                        </div>
                      </div>
				    </div>
				</form>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-12 alert alert-danger" role="alert">
            <strong>提示:</strong> 错误信息!
            </div>
          </div>
		  <div class="modal-footer">
		  	<div class="form-group">
		  		<div class="col-sm-9 col-sm-offset-2">
		  			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		  			<button id="saveCategoryBtn" type="button" class="btn btn-primary">确定</button>
		  		</div>
		  	</div>
		  </div>
	    </div>
	  </div>
	</div>
    <!-- add category modal end -->

    <script src="//cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/summernote/0.8.2/summernote.min.js"></script>
    <script src="//cdn.bootcss.com/summernote/0.8.2/lang/summernote-zh-CN.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#summernote').summernote({
                maxHeight: 500,
                height: 250,
                width: "100%"
            });
            //var html = $('#summernote').summernote('code');

            $("#addCategoryBtn").click(function() {
                $("#categoryForm")[0].reset();
                $("#addCategoryModal").modal("show");
            });

            $("#saveCategoryBtn").click(function() {
                $.ajax({
                    url: "<%=path%>/manage/articleCategory/save",
                    type: "POST",
                    data: "name=" + $("#categoryName").val(),
                    dataType: "json",
                    success: function(data) {
                        if (data.result == 1) {
                            $("#category").append("<option value='" + data.entity.id + "' selected>" + data.entity.name + "</option>");
                            $("#addCategoryModal").modal("hide");
                        } else {
                            $("#addCategoryModal .alert").html(data.error);
                        }
                    }
                });
            });

        });
    </script>
</body>
</html>