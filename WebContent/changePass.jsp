<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<title>修改密码页面</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">

		<h2 class="text-center">请修改你的密码</h2>
		<div class="row">
			<form class="form-horizontal col-md-offset-4 col-md-4">

				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" id="password1" class="form-control"
							placeholder="密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">修改密码</label>
					<div class="col-sm-10">
						<input type="password" id="password2" class="form-control"
							placeholder="确认修改密码">
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" id="changePass" class="btn btn-default login ">确认修改</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
	$("#changePass").click(function() {
		$.ajax({
			url : "changePass",
			type : "post",
			data : {
				password1:$("#password1").val(),
				password2:$("#password2").val()
			},
			dataType : "json",
			success : function(data) {
				if (data == "修改成功") {
					alert("修改成功");
					window.location.herf="index.jsp";
				} else {
					alert("修改失败");
					window.location.reload();
				}
			}
		});
	});
	</script>
</body>
</html>