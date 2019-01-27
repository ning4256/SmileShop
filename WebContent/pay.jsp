<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="product_hd" ng-class="{'product_hd_fixed':isFlag}">
    <div class="container">
        <div class="product_title fl">
            <h1>{{product.name}}</h1>
        </div>
        <div class="product_buy fr">
            <a ui-sref="buyNow({productId:product.productId})" class="btn btn-primary">立即购买</a>
        </div>
        <div class="product_nav fr">
            <ul>
                <li ng-repeat="navItem in product.details">
                    <a ui-sref="home.products.detail({detailType:navItem.name})"
                            ui-sref-active="active">{{navItem.name}}</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- product detail info-->
<div ui-view></div>
</body>
</html>