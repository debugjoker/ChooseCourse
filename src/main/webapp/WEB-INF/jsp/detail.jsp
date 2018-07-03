<%--
  Created by IntelliJ IDEA.
  User: debugjoker
  Date: 2018/5/21
  Time: 21:29
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
    <title>课程详情页</title>
    <!--站点图标-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/bitbug_favicon.ico" type="image/x-icon">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!--结果页面-->
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>${course.courseName}</h1>
        </div>
        <div class="panel-body">
            <h2 class="text-danger">
                <i class="glyphicon glyphicon-time"></i>
                <span class="glyphicon" id="result-box"></span>
            </h2>
        </div>
        <div class="panel-footer">
            <%--<input type="hidden" id="code" value="${sessionScope.studentId.studentId}"/>--%>
        </div>
    </div>
</div>
<!--结果页面-->
<%--session中没有的话弹出层--%>
<div class="loginModal">
    <div class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title text-center">
                        <span class="glyphicon glyphicon-user"></span>登录账户：
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputId"  class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputId" placeholder="请输入账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <span id="message"></span>
                    <button class="btn btn-default btn-success" id="killPhoneBtn" type="submit">
                        <span class="glyphicon glyphicon-user"></span>
                        登录
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>


</body>

<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/javascript/chooseCourse.js" type="text/javascript"></script>

<script>
    // alert("Before");
    $(function () {
        // alert("开始");
        <%--var idValue = ${sessionScope.studentId};--%>

        <%--if (!idValue){--%>
            <%--idValue = null;--%>
        <%--}--%>
        chooseCourse.detail.init({
            // 传参
            <%--userId: '${sessionScope.studentId}'?'${sessionScope.studentId}':'',--%>
            userId: ${sessionScope.studentId},
            courseId: ${course.courseId},
            startTime: ${course.startTime.time},
            endTime: ${course.endTime.time}
        });
        // alert("end");
    })
</script>
</html>
