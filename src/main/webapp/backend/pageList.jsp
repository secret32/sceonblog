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
                    <span class="col-md-2 col-xs-2">页面列表</span>
                    <span class="col-md-2 col-xs-2 right">
                        <button class="btn btn-block btn-md btn-primary"> 新增页面 </button>
                    </span>
                </div>
                <div class="row form">
                    <div class="col-md-12 col-xs-12">
                        <table id="dataTable" class="table table-striped table-responsive table-hover" style="padding: 0px;">
                            <thead>
                                <th>ID</th>
                                <th>名称</th>
                                <th>状态</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${empty pages.pageList}">
                                        <tr><td colspan="5">没有符合条件的数据</td><tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${pages.pageList}" var="page">
                                            <tr>
                                                <td>${page.id}</td>
                                                <td>${page.alias}</td>
                                                <td>${page.status}</td>
                                                <td>${page.updateTime}</td>
                                                <td>
                                                    <button class="btn btn-xs btn-default" data-id="${page.id}">编辑</button>
                                                    <button class="btn btn-xs btn-warning genHtml" data-id="${page.id}">生成</button>
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

    <script src="//cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
    <script src="<%=path%>/staticRes/sceon.js"></script>
    <script>
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
            $(".genHtml").click(function() {
                $.ajax({
                    url: "<%=path%>/manage/html/generate",
                    type: "POST",
                    data: "pageId=" + $(this).attr("data-id"),
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