<%--
  Created by IntelliJ IDEA.
  User: debugjoker
  Date: 2018/5/21
  Time: 21:25
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
    <title>课程列表页面</title>
    <!--站点图标-->
    <link rel="shortcut icon" href="/resources/img/bitbug_favicon.ico" type="image/x-icon">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/list.css">

    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!--头部部分-->
<header id="course_header">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">皖西学院在线选课系统</a>
            </div>

            <div class="nav navbar-nav navbar-right">
                <a class="btn btn-default btn-info" href="/user/register" role="button">免费注册</a>
                <a class="text-muted" href="/user/login" role="button">立即登录</a>
            </div>
        </div>
    </nav>
</header>
<!--头部部分-->

<!--表格部分-->
<section id="course_content">
    <div class="panel panel-default table-responsive ">
        <table class="table table-striped table-bordered table-hover ">
            <thead>
                <tr>
                    <th>课程名称</th>
                    <th>剩余数量</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情页</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sk" items="${list}">
                    <tr>
                        <td>${sk.courseName}</td>
                        <td>${sk.courseNumber}</td>
                        <td>
                            <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.creatTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <a class="btn btn-default" href="/course/${sk.courseId}/detail" role="button" target="_blank">课程详情页</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<!--表格部分-->

<%--<p>session studentId:${sessionScope.studentId}</p>--%>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
