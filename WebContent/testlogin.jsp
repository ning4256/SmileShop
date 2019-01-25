<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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



    <h2 class="text-center">请登录</h2>
    <div class="row">
        <form class="form-horizontal col-md-offset-4 col-md-4">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">账户</label>
                <div class="col-sm-10">
                    <input type="text" id="login_id" class="form-control"  placeholder="账户">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" id="password" class="form-control"  placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox">记住密码
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="submit" class="btn btn-default login ">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
$("#submit").click(function() {
	$.ajax({
		url : "login",
		type : "post",
		data : {
			login_id : $("#login_id").val(),
			password : $("#password").val()
		},
		dataType : "json",
		success : function(data) {
			if (data == "success") {
				alert("登录成功");
				window.location.href="index.jsp";
				
			} else if (data == "fail") {
				alert("用户名或密码不正确");
				window.location.reload();
			}

		}
	});
});
</script>

</body>
</html>
