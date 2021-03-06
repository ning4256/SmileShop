<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta name="viewport" content="width=device-width">
<link href="css/style.css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/scripts.js" type="text/javascript"></script>
<script type="text/javascript" src="js/xhtx.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

</head>
<style>
#announcement_box {
	background-color: rgba(240, 239, 215, 0.5);
	background-color: #E3DEC0 9;
	padding-left: 15px;
	width: 100%;
	height: 30px;
	border: 1px dashed #C1C0AB;
	border-radius: 2px;
}

#announcement {
	background: url(http://wuzuowei.net/LOGO.PNG) left center no-repeat
		scroll;
	height: 25px;
	line-height: 25px;
	overflow: hidden;
	float: left;
}

#announcement a {
	color: #000;
}

#announcement a:hover {
	color: #94382B;
}

.announcement_remove {
	padding: 1px 10px;
	float: right;
	font-size: 14px;
}

.announcement_remove a {
	height: 18px;
	width: 18px;
	display: block;
	line-height: 16px;
	margin: 4px 0 3px 0;
	margin: 10px 0 3px 0 9;
	text-align: center;
}

.announcement_remove a:hover {
	background-color: #cdc8a0;
	box-shadow: 1px 1px 1px #66614c inset;
	-webkit-box-shadow: 1px 1px 1px #666 inset;
	-moz-box-shadow: 1px 1px 1px #666 inset;
	border-radius: 3px;
}

#announcement_close {
	color: #666;
}

#announcement span {
	color: #666;
}

#announcement ul {
	list-style-type: none
}

#progress {
	position: fixed;
	height: 2px;
	background: #9C0;
	transition: opacity 500ms linear;
	z-index: 1000000;
	top: 0;
}

#progress.done {
	opacity: 0
}

#progress span {
	position: absolute;
	height: 2px;
	-webkit-box-shadow: #2085c5 1px 0 6px 1px;
	-webkit-border-radius: 100%;
	opacity: 1;
	width: 150px;
	rightright: -10px;
	-webkit-animation: pulse 2s ease-out 0s infinite;
}

@
-webkit-keyframes pulse { 30% {
	opacity: .6
}
60%
{
opacity


















:


















0;
}
100%
{
opacity


















:


















.6









 









}
}
</style>
<body>
	<div id="progress">
		<span></span>
	</div>
	<script language="javascript">
		$({
			property : 0
		}).animate({
			property : 100
		}, {
			duration : 3000,
			step : function() {
				var percentage = Math.round(this.property);
				$("#progress").css("width", percentage + "%");
				if (percentage == 100) {
					$("#progress").addClass("done");
				}
			}
		});

		function AutoScroll(obj) {
			$(obj).find("ul:first").animate({
				marginTop : "-25px"
			}, 500, function() {
				$(this).css({
					marginTop : "0px"
				}).find("li:first").appendTo(this);
			});
		}
		//退出账户
		$(document).ready(function() {
			setInterval('AutoScroll("#announcement")', 4000)
		});
		$("#loginOut").click($.ajax({
			url : "/loginOut",
			type : "post",
			data : {},
			dataType : "json",
			success : function(data) {
				alter("成功退出");
			}
		}));
	</script>
	<div class="top">
		<div class="topnav clear">
			<div class="user-entry">
				<a href="index.jsp" class="backHome">首页</a> <span>|</span>
				<c:if test="${empty user}">
					<b> 欢迎光临!请 </b> 
					[<a href="login.jsp" class="login-link">登录</a>] 
					<span>|</span> 
					[<a href="register.jsp" class="register-link">注册</a>]
				  </c:if>
				<c:if test="${!empty user }">
					<b> 欢迎光临 </b>
					<a style="color: red" href="javascript:void(0)">欢迎您,${username}</a>
					<span>|</span> 
					[<a href="changePass.jsp" class="register-link">修改密码</a>]
					<a style="color: black" id="loginOut">[安全退出]</a>
				</c:if>
			</div>
			<ul class="quick-menu">
				<li class="user-center">
					<div class="menu">
						<a href="javascript:void(0)">在线人数:<c:out value="${online}"></c:out></a>
						<span class="hline"></span>
					</div>
				</li>
				<li class="user-center">
					<div class="menu">
						<a href="${pageContext.request.contextPath}/cart.jsp">购物车</a>
					</div>
				</li>

				<li class="user-center">
					<div class="menu">
						<a href="order.jsp">我的订单</a> <span class="hline"></span>
					</div>
				</li>
				<li class="user-center">
					<div class="menu">
						<a href="javascript:void(0)">我的收藏</a> <i class="arrow"></i> <span
							class="hline"></span>
					</div>
					<div class="menu-bd">
						<ul>
							<li><a href="javascript:void(0)">收藏的商品</a></li>
							<li><a href="javascript:void(0)">收藏的店铺</a></li>
						</ul>
					</div>
				</li>
				<li class="user-center">
					<div class="menu">
						<a href="javascript:void(0)">站内消息</a> <span class="hline"></span>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<script>
		//注销
		$("#loginOut").click(function() {
			$.ajax({
				url : "loginOut",
				type : "post",
				data : {
					operType : "loginout"
				},
				dataType : "json",
				success : function(data) {
					alert(data);
					window.location.href = "index.jsp";
				}
			});
		})
	</script>
</body>
</html>
