<%--
  Created by IntelliJ IDEA.
  User: debugjoker
  Date: 2018/6/7
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录界面</title>
    <!--站点图标-->
    <link rel="shortcut icon" href="/resources/img/bitbug_favicon.ico" type="image/x-icon">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/login.css">

    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body >
<div class="container" id="header">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-center ">登录界面</h3>
            </div>
            <div class="panel-body">
                <form action="/user/login" method="post">
                    <div class="form-group">
                        <label for="exampleInputId">账号</label>
                        <input type="text" class="form-control" id="exampleInputId" name="studentId"
                              pattern="^\d{10}$" required placeholder="请输入10位学号">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" required class="form-control" name="studentPassWord" id="exampleInputPassword1" placeholder="请输入密码">
                    </div>
                    <button type="submit" class="btn btn-default btn-primary" id="submit">登录</button>
                    <a class="btn btn-default btn-info" href="/user/register" role="button">注册</a>
                    <div class="panel-footer text-danger text-center"><h2>${requestScope.error}</h2></div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
