<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.ning4256.dao.ProductDAO"%>
<%@ page import="com.ning4256.po.ProductPO"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>商品详情页面</title>



<style type="text/css">
* {
	margin:0;
	padding:0;
}
div {
	float: left;
	margin: 10px;
}

div dd {
	margin: 0px;
	font-size: 10px;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}
</style>
</head>

<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>商品详情</h1>
	<hr>
	<div>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<!-- 商品详情  -->
				<%
					ProductDAO itemsDao = new ProductDAO();
					ProductPO item = itemsDao.getItemById(Integer.valueOf(request.getParameter("productid")));
					if (item != null) {
				%>


				<td width="70%" valign="top">
					<table>
						<tr>
							<td rowspan="4"><img src="<%=item.getProduct_pic()%>"
								width="200" height="200" /></td>
						</tr>
						<tr>
							<td><B><%=item.getProduct_name()%></B></td>
						</tr>
						<tr>
							<td>描述：<%=item.getProduct_description()%></td>
						</tr>
						<tr>
							<td>价格：<%=item.getProduct_price()%></td>
						</tr>
						<tr>
							<td><a  class='btn btn-primary' onclick='addCart("<%=item.getProduct_id() %>","<%=item.getProduct_name() %>","<%=item.getProduct_pic() %>","<%=item.getProduct_price() %>")'>立即购买</a></td>
						</tr>
					</table>
				</td>

				<%
					}
				%>




			</tr>
		</table>
	</center>
	</div>
	<script>
	function addCart(pid, pname, pimg, pprice) {
		var number = 0;
		
		$.ajax({
			url : "cart",
			type : "post",
			data : {
				operType : "update",
				id : pid,
				name : pname,
				img : pimg,
				count : 1,
				price : pprice
			},
			dataType : "json",//期待的响应数据
			success : function(data) {

				alert("成功加入购物车");
				productNumber++;
				$(".cart-number").text(productNumber);

			}
		});

	}
	</script>
</body>
</html>