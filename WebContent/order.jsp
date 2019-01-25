<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>订单列表</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="table-responsive" id="cart-table">
	<table class="table">
		<caption>订单列表</caption>
		<thead>
			<tr>
				<th>订单编号</th>
				<th></th>
				<th>商品名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>日期</th>
			</tr>
		</thead>
		<tbody id="cart-body">
			
			
		</tbody>
</table>
<script>
function showOrder(){
	$.ajax({
		url:"orderlist",
		type:"post",
		data:{
			operType:"search",

		},
		dataType:"json",
		success:function(data){
			var content="";
			var totalPrice=0.0;
			for(var i=0;i<data.length;i++){
				var po = data[i];
				content+="<tr>"
				+"<td class='cart-pic'>"+po.number+"</td>"
				+"<td class='cart-pic'><img src='"+po.img+"'></td>"
				+"<td class='cart-name'>"+po.name+"</td>"
				+"<td class='cart-price'>"+po.price+"</td>"
				+"<td class='cart-count'>"+po.count+"</td>"
				+"<td class='cart-remove'>"+po.time+"</td>"
				+"</tr>";
				totalPrice+=po.price*po.count;
			}
			content+="<tr>"
				+"<td></td>"
				+"<td></td>"
				+"<td>总价:<span class='totalprice'>"+totalPrice+"</span></td>"
				+"<td></td>"
				+"<td><button class='btn btn-danger'><a href='index.jsp' class='to-index'>返回首页</a></button></td>"
				+"</tr>"
			$("#cart-body").html(content);
			
		}
	});
}
showOrder();
</script>
</body>
</html>