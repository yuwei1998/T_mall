<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>
    <!-- Bootstrap -->
    <link href="/ssm/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/ssm/js/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/ssm/js/bootstrap.min.js"></script>
    <style type="text/css">
    	body{
			background:url("/ssm/images/bg.jpg");
			background-position:center;
			background-repeat:no-repeat;
		}
    	.container{
            display:table;
            height:100%;
            padding-top: 200px;
        }

        .row{
            display: table-cell;
            vertical-align: middle;
        }
        .row-centered {
            text-align:center;
        }
        .col-centered {
            display:inline-block;
            float:none;
            text-align:left;
            margin-right:-4px;
        }
    </style>
</head>
<body >
	<div class="container">
            <div class="row row-centered">
                <div class="well col-md-3 col-centered">
                    <div class="row-centered"><h2>用户登录</h2></div>
                    <form action="/ssm/user/login" method="post" role="form">
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1">
                           		<i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                            </span>
                            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名"/>
                        </div>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1">
                            	<i class="glyphicon glyphicon-lock"></i>
                            </span>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                        </div>
                        <br/>
                        <div class="col-md-6">
                        <button type="reset" class="btn btn-default btn-block">重置</button>
                        </div>
                        <div class="col-md-6">
                        <button type="submit" class="btn btn-success btn-block">登录</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>