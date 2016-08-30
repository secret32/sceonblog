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
    <div class="container login-screen">
        <div class="row">
            <div class="login-form">
            <form id="loginForm" name="loginForm" action="<%=path%>/manage/login" method="post">
                <c:if test="${error!=null}">
                <div id="loginError" class="form-group text-danger">
                    ${error}
                </div>
                </c:if>
                <div class="form-group">
                    <input type="text" class="form-control login-field" value="" placeholder="Username" id="login-name" name="username" />
                    <label class="login-field-icon fui-user" for="login-name"></label>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control login-field" value="" placeholder="Password" id="login-pass" name="password" />
                    <label class="login-field-icon fui-lock" for="login-pass"></label>
                </div>

                <!--
                <div class="form-group">
                    <input type="text" class="form-control login-field" value="" placeholder="Email Verify Code" id="login-vc" name="verifycode" />
                    <label class="login-field-icon fui-star-2" for="login-vc"></label>
                </div>
                -->

                <button type="submit" class="btn btn-primary btn-lg btn-block">Log in</button>
                <!--<a class="login-link" href="#">Lost your password?</a>-->
            </form>
            </div>
        </div>
    </div>

    <script src="//cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-validator/0.5.2/js/language/en_US.js"></script>
    <script>
        $(document).ready(function() {
            $('#loginForm').bootstrapValidator({
                message: 'Invalid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    username: {
                        validators: {
                            notEmpty: {
                                message: 'Required'
                            },
                            stringLength: {
                                min: 1,
                                max: 20,
                                message: '1 ~ 20 characters'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: 'Required'
                            },
                            stringLength: {
                                min: 1,
                                max: 12,
                                message: '1 ~ 12 characters'
                            }
                        }
                    },
                    verifycode: {
                        validators: {
                            notEmpty: {
                                message: 'Required'
                            },
                            stringLength: {
                                min: 6,
                                max: 6,
                                message: '6 characters'
                            }
                        }
                    }
                }
            }).on('success.form.fv', function(e) {
                return true;
            });;

            $(".login-field").focus(function() {
                $("#loginError").hide();
            });
        });
    </script>
</body>
</html>