<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品详情页</title>
</head>
<body>

<div ng-if="product.name!='小米手机5'">
    <div  ng-include="'view/404.html'"></div>
</div>

<div ng-if="product.name=='小米手机5'" class="product_bd" ng-switch="product.detail.name">
    <!--<h1>{{product.detail.name}}</h1>-->

    <div ng-switch-when="概述">
        <div class="product_description">
            <div class="description_text">
                <h1>小米手机5</h1>
                <h2>十余项黑科技，很轻狠快</h2>
                <p>骁龙820处理器，最大可选 4GB 内存 + 128GB 闪存
                    <br/>4 轴防抖相机，3D陶瓷 / 玻璃机身
                </p>
                <p class="price">1999 <span>元起</span></p>
            </div>
            <img src="resource/img/mi5/h-12.jpg" alt=""/>
        </div>

        <div class="product_description">
            <div class="description_text">
                <h2>14 万分，快得有点狠</h2>
                <p>CPU 性能翻倍的骁龙 820 处理器，提速 87% 的 UFS 闪存，快 40% 的 Adreno 530 图形引擎，
                    <br/>快 100% 的双通道 LPDDR4，Antutu 跑分性能测试高达惊人的 14 万分。
                </p>
                <p class="price">1999 <span>元起</span></p>

                <ul class="side-text side-text-b">
                    <li><span class="side-title webfont">骁龙820</span>
                        <p class="side-cont">旗舰处理器</p>
                    </li>
                    <li class="mid"><span class="side-title webfont">4GB</span>
                        <p class="side-cont">可选最大内存</p>
                    </li>
                    <li><span class="side-title webfont">128GB</span>
                        <p class="side-cont">可选最大闪存</p>
                    </li>
                </ul>
            </div>
            <img src="resource/img/mi5/h-8.jpg" alt=""/>
        </div>

        <div class="product_description">
            <div class="description_text">
                <h1>小米手机5</h1>
                <h2>十余项黑科技，很轻狠快</h2>
                <p>骁龙820处理器，最大可选 4GB 内存 + 128GB 闪存
                    <br/>4 轴防抖相机，3D陶瓷 / 玻璃机身
                </p>
                <p class="price">1999 <span>元起</span></p>
            </div>
            <img src="resource/img/mi5/h-13.jpg" alt=""/>
        </div>
    </div>

    <div ng-switch-when="黑科技">
        <div ng-include="'view/page/template/hei.html'"></div>
    </div>

    <div ng-switch-when="相机">
        <div  ng-include="'view/page/template/camera.html'"></div>
    </div>

    <div ng-switch-when="屏幕">
        <div  ng-include="'view/page/template/screen.html'"></div>
    </div>


</div>
</body>
</html>