<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<style>
.login {
	color: white;
	height: 38px;
	width: 300px;
	background-color: #2b669a;
}
</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">

		<h2 class="text-center">请注册</h2>
		<div class="row">
			<form class="form-horizontal col-md-offset-4 col-md-4">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">手机号码</label>
					<div class="col-sm-10">
						<input type="text" id="re_login_id" " class="form-control"
							placeholder="手机号码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" id="re_password" class="form-control"
							placeholder="密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="text" id="re_name" class="form-control"
							placeholder="姓名">
					</div>
				</div>
				<div class="form-group">
					性别： <label class="radio-inline"> <input type="radio"
						name="sex" value="男" checked> 男
					</label> <label class="radio-inline"> <input type="radio"
						name="sex" value="女"> 女
					</label>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">年龄</label>
					<div class="col-sm-10">
						<input type="text" id="re_age" class="form-control"
							placeholder="年龄">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" id="submit-re" class="btn btn-default login ">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
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
					window.location.herf="http://localhost:8080/SmileShop/index.jsp";

				} else {
					alert("注册失败");
					window.location.reload();
				}
			}
		});
	});
	</script>

</body>
</html>


</html>