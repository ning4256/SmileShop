<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>首页</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="middle_right">
		<div id="lunbobox">
			<div id="toleft" style="display: block;">&lt;</div>
			<div class="lunbo">
				<a href="####" style="display: none;"><img src="./img/mi1.png"></a>
				<a href="####" style="display: none;"><img src="./img/mi2.png"></a>
				<a href="####" style="display: none;"><img src="./img/mi3.png"></a>
				<a href="####" style="display: none;"><img src="./img/mi4.png"></a>
				<a href="####" style="display: inline-block;"><img
					src="./img/mi5.png"></a>
			</div>
			<div id="toright" style="display: block; opacity: 0.3;">&gt;</div>
			<ul>
				<li
					style="background: rgb(204, 204, 204); border: 1px solid rgb(255, 255, 255);"></li>
				<li
					style="background: rgb(204, 204, 204); border: 1px solid rgb(255, 255, 255);"></li>
				<li
					style="background: rgb(204, 204, 204); border: 1px solid rgb(255, 255, 255);"></li>
				<li
					style="background: rgb(204, 204, 204); border: 1px solid rgb(255, 255, 255);"></li>
				<li
					style="background: rgb(153, 153, 153); border: 1px solid rgb(255, 255, 255);"></li>
			</ul>
			<span></span>
		</div>
	</div>


	<div id="product-list">
		<ul class="single-page">
		</ul>
		<div id="page-toolbar">
			<ul>
				<li id="first" onclick="showProducts(1)">首页</li>
				<li id="top" onclick="prePage()">上一页</li>
				<li id="page-number"><span id="currentpage">0</span>/<span id="totalpage">0</span></li>
				<li id="down" onclick="nextPage()">下一页</li>
				<li id="down" onclick="endPage()">末页</li>
			</ul>
		
		</div>
	</div>
	<script>

		//注销
		function loginOut(){
			$.ajax({
				url : "loginout",
				type : "post",
				data : {
					operType:"loginout"
				},
				dataType : "json",
				success : function(data) {
					alert(data);
					window.location.reload();
				}
			});
			
		}
		

		//register 表单提交
		$("#submit-re").click(function() {
			$.ajax({
				url : "register",
				type : "post",
				data : {
					login_id : $("#re_login_id").val(),
					password : $("#re_password").val(),
					name : $("#re_name").val(),
					sex : $("input[name='sex']:checked").val(),
					age : $("#re_age").val()
				},
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						alert("注册成功");
						$(".register-box").hide();
					} else {
						alert("注册失败");
					}
				}
			});
		});

		//商品展示
		function showProducts(ppage) {
			$.ajax({
				url : "products",
				type : "post",
				data : {
					opertype : "showProducts",
					page : ppage
				},
				dataType : "json",//期待的响应数据
				success : function(data) {
				
					var arr = data.products;
					var content = "";
					for (var i = 0; i < arr.length; i++) {
						var po=arr[i];
						content += "<li>" + "<a href='detail.jsp/?productid="+po.product_id+"'>"
								+ "<img src='"+po.product_pic+"'>"

								+ "<div class='p-info'>"
								+ "<span class='p-name'>"+po.product_name+"</span>"
								+ "<span class='p-desc'>"+po.product_description+"</span>"
								+ "<span class='p-price'><i>￥</i>"+po.product_price+"</span>"
								+ "</div>"

								+ "</a>" 
								+"<span class='addtocart' onclick='addCart(\""+po.product_id+"\",\""+po.product_name+"\",\""+po.product_pic+"\",\""+po.product_price+"\")'>添加到<br>购物车</span>"
								+ "</li>";
								
								

					}
					$("#product-list ul.single-page").html(content);
					$("#currentpage").html(ppage);
					$("#totalpage").html(data.totalPage);
				}

			});
		}
		showProducts(1);
		function prePage(){
			//获取当前页码
			var current = parseInt($("#currentpage").html());
			if(current>1){
				showProducts(current-1);
			}
		}
		function nextPage(){
			//获取当前页码
			var current = parseInt($("#currentpage").html());
			//获取总页码
			var total = parseInt($("#totalpage").html());
			if(current<total){
				showProducts(current+1);
			}
		}
		function endPage(){
			var total = parseInt($("#totalpage").html());
			showProducts(total);
		}
		//计数器
		productNumber = 0;
		function addCart(pid,pname,pimg,pprice){
			var number=0;
			$.ajax({
				url : "cart",
				type : "post",
				data : {
					operType : "update",
					id:pid,
					name:pname,
					img:pimg,
					count:1,
					price:pprice
				},
				dataType : "json",//期待的响应数据
				success : function(data) {
					
					alert(data);
					productNumber++;
					$(".cart-number").text(productNumber);
					
				}
			});
			
		}
		

	</script>


</body>
</html>