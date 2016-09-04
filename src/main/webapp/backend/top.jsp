<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.navbar {
    border-radius: 0;
    margin-bottom: 0;
}
</style>
<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
        <span class="sr-only">Toggle navigation</span>
      </button>
      <a class="navbar-brand" href="#">SceonTop</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">${username} <b class="caret"></b></a>
          <span class="dropdown-arrow"></span>
          <ul class="dropdown-menu">
            <li><a href="#">个人信息</a></li>
            <li class="divider"></li>
            <li><a href="#">登出</a></li>
          </ul>
        </li>
       </ul>
    </div><!-- /.navbar-collapse -->
</nav><!-- /navbar -->
<script src="//cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>