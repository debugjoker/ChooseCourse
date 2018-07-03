var chooseCourse = {

    //封装ajax的URL
    URL: {
        now: function () {
            return '/course/time/now';
        },
        exposer: function (courseId) {
            return '/course/' + courseId + '/exposer';
        },
        execution: function (courseId, md5) {
            return '/course/' + courseId + '/' + md5 + '/execution';
        }

    },
    // 验证用户有没有登录,就是看session中有没有值
    validateUser: function(userId){
         if (userId && !isNaN(userId) && userId.length == 10){
            return true;
         }else {
             return false;
         }
    },

    //详情页抢课逻辑
    detail:{
        // 详情页初始化
        init: function (params) {
            // 账户验证和登录 后端验证TODO
            var userId = params['userId'];

            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var courseId = params['courseId'];

            console.log(startTime);
            console.log(userId);
            //弹出登录框
            // if (!chooseCourse.validateUser(userId)) {
            //     //如果session中没有值则跳转至登录页面
            //     //或者弹出选择对话框 选择跳转页面
            //     console.log("come in");
            //     window.location.href="/index";
            //     // var loginModal = $("#loginModal");
            //     // loginModal.modal({
            //     //     show:true,
            //     //     backdrop:'static',
            //     //     keyboard:false
            //     // });
            //     // $('#killPhoneBtn').click(function () {
            //     //     var inputId = $("#inputId").val();
            //     //     if (chooseCourse.validateUser(inputId)){
            //     //         $.cookie('userId',inputId,{expires:7,path:'/course'});
            //     //         window.location.reload();
            //     //     }else {
            //     //
            //     //     }
            //     // })
            // }
            //已经登录
            //计时交互
            $.get(chooseCourse.URL.now(), {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];
                    //时间判断 计时交互
                    chooseCourse.countDown(courseId, nowTime, startTime, endTime);
                } else {
                    console.log('result: ' + result);
                    alert('result: ' + result);
                }
            });
        }
    },
    
    handlerChoose: function (courseId, node) {
        //获取秒杀地址,控制显示器,执行秒杀
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">选课开始</button>');

        $.post(chooseCourse.URL.exposer(courseId),{},function (result) {
            //回调函数执行交互流程
            // console.log("进入这里：");
            if (result && result['success']){
                var exposer = result['data'];
                if (exposer['exposed']) {
                    //开启秒杀
                    //获取秒杀地址
                    var md5 = exposer['md5'];
                    var killUrl = chooseCourse.URL.execution(courseId, md5);
                    console.log("killUrl: " + killUrl);
                    //绑定一次点击事件
                    $('#killBtn').one('click', function () {
                        //执行秒杀请求
                        //1.先禁用按钮
                        $(this).addClass('disabled');//,<-$(this)===('#killBtn')->
                        //2.发送秒杀请求执行秒杀
                        $.post(killUrl, {}, function (result) {
                            if (result && result['success']) {
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                //显示秒杀结果
                                node.html('<span class="label label-success">' + stateInfo + '</span>');
                            }
                        });
                    });
                    node.show();
                }else {
                    //未开启秒杀(浏览器计时偏差)
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    seckill.countDown(courseId, now, start, end);
                }
            }else {
                console.log('result: ' + result);
            }
        });
    },
    
    countDown: function (courseId, nowTime, startTime, endTime) {
        console.log(courseId + '_' + nowTime + '_' + startTime + '_' + endTime);
        var seckillBox = $('#result-box');

        //时间判断
        if (nowTime > endTime){
            seckillBox.html('选课结束');
        }else if (nowTime < startTime){
            //未开始，计时
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime,function (event) {
                var format = event.strftime('选课倒计时： %D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown',function () {
                //计时结束回调事件，获取选课地址
                console.log('finish.countdown');
                chooseCourse.handlerChoose(courseId,seckillBox);
            });
        }else {
            //选课开始
            chooseCourse.handlerChoose(courseId,seckillBox);
        }

    }
    
}