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
            overflow: hidden;
            background-color: #1abc9c;
        }
        .login-form .login-field {
            text-indent: 30px;
        }
        .login-form .login-field-icon {
            right: 0px;
            left: 15px;
        }

        @media (min-width: 1024px) {
            .login-screen {
                padding: 13% 30%;
            }
        }
        @media (min-width: 600px) and (max-width: 1024px) {
            .login-screen {
                padding: 13% 25%;
            }
        }
        @media (max-width: 600px) {
            .login-screen {
                padding: 13% 15%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <a href="<%=path%>/manage/html/home">Login Successfully!</a>
        </div>
    </div>

    <script src="//cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-validator/0.5.2/js/language/en_US.js"></script>
    <script>
        $(document).ready(function() {

        });
    </script>
</body>
</html>