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
                    <span class="col-md-2 col-xs-2">菜单列表</span>
                    <span class="col-md-2 col-xs-2 right">
                        <button class="btn btn-block btn-md btn-primary"> 新增菜单 </button>
                    </span>
                </div>
                <div class="row form">
                    <div class="col-md-12 col-xs-12">
                        <table id="dataTable" class="table table-striped table-responsive table-hover" style="padding: 0px;">
                            <thead>
                                <th>ID</th>
                                <th>名称</th>
                                <th>显示名</th>
                                <th>父菜单</th>
                                <th>关联页面</th>
                                <th>序号</th>
                                <th>状态</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${empty pages.pageList}">
                                        <tr><td colspan="9">没有符合条件的数据</td><tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${pages.pageList}" var="menu">
                                            <tr>
                                                <td>${menu.id}</td>
                                                <td>${menu.name}</td>
                                                <td>${menu.alias}</td>
                                                <td>${menu.parentId}</td>
                                                <td>${menu.pageId}</td>
                                                <td>${menu.ordinal}</td>
                                                <td>${menu.status}</td>
                                                <td>${menu.updateTime}</td>
                                                <td>
                                                    <button class="btn btn-xs btn-default" data-id="${menu.id}">编辑</button>
                                                    <button class="btn btn-xs btn-inverse changePage" data-id="${menu.id}">页面</button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                    <nav class="col-md-12 col-xs-12">
                        <ul id="pagination"></ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>

    <input type="hidden" id="menuId" name="menuId">

    <!-- changePage modal -->
    <div class="modal fade" id="changePageModal" tabindex="-3" role="dialog" aria-labelledby="changePageModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title" id="changePageModalLabel">选择页面</h4>
          </div>
          <div class="modal-body">
            <div class="panel panel-default areapanel col-md-12" style="float: none;">
				<div class="panel-heading nav">
				  <span class="navbar-brand">选择页面</span>
				  <div class="input-group search-mini">
                      <input type="text" class="form-control" placeholder="按名称查询">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go</button>
                      </span>
                  </div>
				</div>
				<table class="table table-striped table-responsive table-hover">
				<thead>
					<tr>
                        <th>ID</th>
                        <th>名称</th>
					</tr>
				</thead>
                <tbody id="pageSelector">
                </tbody>
                </table>
				<nav class="col-sm-12">
					<ul id="pagePagination"></ul>
				</nav>
            </div>
          </div>
		  <div class="modal-footer">
		  	<div class="form-group">
		  		<div class="col-sm-9 col-sm-offset-2">
		  			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		  			<button type="submit" class="btn btn-primary">确定</button>
		  		</div>
		  	</div>
		  </div>
	    </div>
	  </div>
	</div>
	<!-- changePage modal end -->

    <script src="<%=path%>/staticRes/sceon.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        var initPageSelector = false;
        $(document).ready(function() {
            try {
                if ("${pages.allPage}" > 0) {
                    $("#pagination").bootstrapPaginator({
                        bootstrapMajorVersion: 3,
                        currentPage: <c:out value="${pages.pageNo}"></c:out>,
                        totalPages: <c:out value="${pages.allPage}"></c:out>,
                        numberOfPages: 5,
                        pageUrl: function(type, page, current){
                            return rewriteUrl("pages", page);
                        }
                    });
                };
            } catch (e) {}
            $(".changePage").click(function() {
                $("#menuId").val($(this).attr("data-id"));
                if (!initPageSelector) {
                    $.ajax({
                        url: "<%=path%>/manage/page/listJson",
                        type: "GET",
                        data: "",
                        dataType: "json",
                        success: function(data) {
                            if (data.result == 1) {
                                $("#pageSelector").empty();
                                $("#pagePagination").empty();
                                $.each(data.pages.pageList, function(index, element) {
                                    var html = "<tr><td><input type='radio' name='pageId' value='" + element.id + "' "
                                    html += (">&nbsp;" + element.id + "</td><td>" + element.alias + "</td></tr>");
                                    $("#pageSelector").append(html);
                                });
                                $("#pageSelector table tbody tr").click(function(){
                                    $(this).find("input[type='radio']").prop("checked", true);}
                                );
                                if (data.pages.allPage > 1) {
                                    try {
                                        $("#pagePagination").bootstrapPaginator({
                                            bootstrapMajorVersion: 3,
                                            currentPage: data.currentPage,
                                            totalPages: data.totalPages,
                                            numberOfPages: 5,
                                            onPageClicked: function(e,originalEvent, type, page){
                                                getHardwares(page, selectedHardware);
                                            }
                                        });
                                    } catch (e) {}
                                }
                                $("#changePageModal").modal("show");
                                initPageSelector = true;
                            } else {
                            }
                        }
                    });
                } else {
                    $("#changePageModal").modal("show");
                }
            });
            $("#changePageModal button[type='submit']").click(function() {
                $.ajax({
                    url: "<%=path%>/manage/menu/changePage",
                    type: "POST",
                    data: "id=" + $("#menuId").val() + "&pageId=" + $("input[name='pageId']:checked").val(),
                    dataType: "json",
                    success: function(data) {
                        if (data.result == 1) {
                            window.location.reload();
                        } else {
                        }
                    }
                });
            });
        });
    </script>
</body>
</html>