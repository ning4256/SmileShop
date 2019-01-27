<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.ning4256.dao.ProductDAO"%>
<%@ page import="com.ning4256.po.ProductPO"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>商品详情页面</title>



<style type="text/css">
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
	<h1>商品详情 </h1>
	<hr>
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
							<td rowspan="4"><img
								src="<%=item.getProduct_pic()%>" width="200"
								height="200" /></td>
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
					</table>
				</td>

				<%
					}
				%>
				



			</tr>
		</table>
	</center>
	<script>
		console.log(item);
	
	</script>
</body>
</html>