<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<style>
.sidebar {
    width: 190px;
    float: left;
    position: static;
    padding-left: 0;
    padding-right: 0;
}
.sidebar ul {
    text-decoration: none;
}
.sidebar arrowUp {
    display: inline-block;
    border-top: 3px solid #16A085;
    border-left: 3px solid #16A085;
    border-right: 3px solid #16A085;
    border-bottom: none;
}
</style>
<div id="sidebar" class="sidebar responsive" data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
    <ul class="nav nav-list">
        <li class="active open">
            <a href="#" class="dropdown-toggle">
                <span class="menu-text">
                    文章管理
                </span>
                <span class="arrow"></span>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href="<%=path%>/backend/articleEdit.jsp">
                        写文章
                    </a>
                </li>
                <li class="">
                    <a href="#">
                        文章列表
                    </a>
                </li>
                <li class="">
                    <a href="#">
                        文章分类
                    </a>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#">
                <span class="menu-text"> 页面管理 </span>
            </a>
        </li>
        <li class="">
            <a href="#">
                <span class="menu-text"> 菜单管理 </span>
            </a>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>