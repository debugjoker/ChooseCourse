<%--
  Created by IntelliJ IDEA.
  User: debugjoker
  Date: 2018/6/21
  Time: 16:17
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
    <title>CMS管理查询所有用户信息界面</title>
    <!--站点图标-->
    <link rel="shortcut icon" href="/resources/img/bitbug_favicon.ico" type="image/x-icon">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/cms.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">皖西学院学生选课内容管理系统</a>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="javascript:void(0)">查询所有用户信息（更改 删除）<span class="sr-only">(current)</span></a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal">添加用户信息</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/admin/course/list">查询所有课程信息（更改 删除 详情->某个课程选的具体学生名单）</a></li>
                <li><a href="#" data-toggle="modal" data-target="#CourseModal">添加课程信息</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">用户信息</h1>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>密码</th>
                        <th>班级</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="users" items="${userList}">
                        <tr>
                            <td>${users.studentId}</td>
                            <td>${users.studentName}</td>
                            <td>${users.studentPassword}</td>
                            <td>${users.studentClassName}</td>
                            <td>
                                <div class="td_length">
                                    <a class="btn btn-primary" href="/admin/${users.studentId}/detail" role="button">修改</a>
                                    <form action="/admin/${users.studentId}/delete" method="post" class="pull-right">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input class="btn btn-danger" type="submit" value="删除">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

//添加用户modal层
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加用户信息</h4>
            </div>
            <div class="modal-body">
                <form action="/admin/user/add" method="post">
                    <div class="form-group">
                        <label for="studentId">学号</label>
                        <input type="text" required pattern="^\d{10}$" class="form-control" name="studentId" id="studentId" placeholder="请输入10位的学号">
                    </div>
                    <div class="form-group">
                        <label for="studentName">姓名</label>
                        <input type="text" required pattern="[\u4e00-\u9fa5]+" class="form-control" name="studentName" id="studentName" placeholder="请输入姓名">
                    </div>
                    <div class="form-group">
                        <label for="className">班级</label>
                        <input type="text" required pattern="[\u4e00-\u9fa5]+" class="form-control" name="studentClassName" id="className" placeholder="请输入班级">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" required pattern="^[a-zA-Z]\w{5,17}$" class="form-control" name="studentPassword" id="password" placeholder="密码以字母开头长度在6-18之间，只能包含字符数字和下划线">
                    </div>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </form>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>

//添加课程modal层
<div class="modal fade" id="CourseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="CourseModalLabel">添加课程信息</h4>
            </div>
            <div class="modal-body">
                <form action="/admin/course/add" method="post">
                    <div class="form-group">
                        <label for="CourseName">课程名</label>
                        <input type="text" required class="form-control" name="courseName" id="CourseName">
                    </div>
                    <div class="form-group">
                        <label for="CourseNumber">课程数量</label>
                        <input type="text" required class="form-control" name="courseNumber" id="CourseNumber">
                    </div>
                    <div class="form-group">
                        <label for="CourseStartTime">选课开始时间</label>
                        <input type="datetime-local" required class="form-control" name="startTime" id="CourseStartTime">
                    </div>
                    <div class="form-group">
                        <label for="CourseEndTime">选课结束时间</label>
                        <input type="datetime-local" required class="form-control" name="endTime" id="CourseEndTime">
                    </div>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </form>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
</html>

