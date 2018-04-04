<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/3/23
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付宝手机网站支付</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/assets/layui/css/layui.css"  media="all">
</head>
<body>
<ul class="layui-nav">
    <li class="layui-nav-item"><a href="">在线支付</a></li>
    <li class="layui-nav-item"><a href="">订单查询</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">关于</a>
        <dl class="layui-nav-child">
            <dd><a href="">选项一</a></dd>
            <dd><a href="">选项二</a></dd>
            <dd class="layui-this"><a href="">选项三</a></dd>
            <dd><a href="">选项四</a></dd>
        </dl>
    </li>
</ul>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>在线支付</legend>
</fieldset>
<div class="layui-row">
    <div class="layui-col-xs10">
        <form class="layui-form" method="post" action="/alipay/pay">
            <div class="layui-form-item" pane="">
                <input type="hidden" id="WIDout_trade_no" name="WIDout_trade_no" />
                <input type="hidden" id="WIDsubject" name="WIDsubject" value="赞助飞哥" />

                <label class="layui-form-label">支付金额:</label>
                <input type="hidden" id="totalMoney" name="totalMoney"/>
                <div class="layui-input-block">
                    <input type="radio" name="WIDtotal_amount" value="9" title="9元-请飞哥喝杯奶茶" >
                </div>
                <div class="layui-input-block">
                    <input type="radio" name="WIDtotal_amount" value="29" title="29元-请飞哥吃肯德基" checked="">
                </div>
                <div class="layui-input-block">
                    <input type="radio" name="WIDtotal_amount" value="49" title="49元-请飞哥吃顿饭">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">支付人:</label>
                <div class="layui-input-block">
                    <input type="text" name="nickName" lay-verify="required" placeholder="请输入您的大名或者昵称" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">QQ:</label>
                <div class="layui-input-block">
                    <input type="text" name="qq" lay-verify="required|number"  placeholder="请输入您的QQ号" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">留言:</label>
                <div class="layui-input-block">
                    <textarea id="message" name="message" placeholder="请输入留言内容" class="layui-textarea"></textarea>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">支付方式:</label>
                <div class="layui-input-block">
                    <input type="radio" name="way" value="支付宝" title="支付宝" checked="">
                    <input type="radio" name="way" value="微信" title="微信" disabled="">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">支付提交</button>
                </div>
            </div>
        </form>
        </div>
</div>
</body>
<script src="/assets/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });

    layui.use('form', function(){
        GetDateNow();
    });

    function GetDateNow() {
        var vNow = new Date();
        var sNow = "";
        sNow += String(vNow.getFullYear());
        sNow += String(vNow.getMonth() + 1);
        sNow += String(vNow.getDate());
        sNow += String(vNow.getHours());
        sNow += String(vNow.getMinutes());
        sNow += String(vNow.getSeconds());
        sNow += String(vNow.getMilliseconds());
        document.getElementById("WIDout_trade_no").value = sNow;
    }
</script>
</html>
