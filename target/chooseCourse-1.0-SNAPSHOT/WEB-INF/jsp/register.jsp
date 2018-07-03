<%--
  Created by IntelliJ IDEA.
  User: debugjoker
  Date: 2018/6/7
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册界面</title>
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
                <h3 class="panel-title text-center ">注册界面</h3>
            </div>
            <div class="panel-body">
                <form action="/user/register" method="post">
                    <div class="form-group">
                        <label for="exampleInputId">账号</label>
                        <input type="text" required pattern="^\d{10}$" class="form-control" id="exampleInputId" name="studentId" placeholder="请输入10位的学号">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName">姓名</label>
                        <input type="text" required pattern="[\u4e00-\u9fa5]+" class="form-control" id="exampleInputName" name="studentName" placeholder="请输入姓名">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputClassName">班级名称</label>
                        <input type="text" required pattern="[\u4e00-\u9fa5]+" class="form-control" id="exampleInputClassName" name="studentClassName" placeholder="请输入班级">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword">密码</label>
                        <input type="password" required pattern="^[a-zA-Z]\w{5,17}$" class="form-control" id="exampleInputPassword" name="studentPassword" placeholder="以字母开头长度在6-18之间，只能包含字符数字和下划线">
                    </div>
                    <button type="submit" class="btn btn-default btn-primary ">注册</button>
                </form>
            </div>
            <div class="panel-footer text-danger text-center"><h2>${sessionScope.warning}</h2></div>
        </div>
    </div>
</div>



<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
