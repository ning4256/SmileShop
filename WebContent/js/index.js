///轮播

$(function(){
	var t;
	var index = 0;
	//自动播放
	t = setInterval(play, 3000)

	function play() {
	    index++;
	    if (index > 4) {
	        index = 0
	    }
	    
	    $("#lunbobox ul li").eq(index).css({
	        "background": "#999",
	        "border": "1px solid #ffffff"
	    }).siblings().css({
	        "background": "#cccccc",
	        "border": ""
	    })

	    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000);
	};

	//点击鼠标 图片切换
	$("#lunbobox ul li").click(function() {

	    $(this).css({
	        "background": "#999",
	        "border": "1px solid #ffffff"
	    }).siblings().css({
	        "background": "#cccccc"
	    })
	    var index = $(this).index(); 

	    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000); 
	});


	$("#toleft").click(function() {
	    index--;
	    if (index <= 0) 
	    {
	        index = 4
	    }

	    $("#lunbobox ul li").eq(index).css({
	        "background": "#999",
	        "border": "1px solid #ffffff"
	    }).siblings().css({
	        "background": "#cccccc"
	    })

	    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000); 
	}); 
	$("#toright").click(function() {
	    index++;
	    if (index > 4) {
	        index = 0
	    }
	    console.log(index);
	    $(this).css({
	        "opacity": "0.5"
	    })
	    $("#lunbobox ul li").eq(index).css({
	        "background": "#999",
	        "border": "1px solid #ffffff"
	    }).siblings().css({
	        "background": "#cccccc"
	    })
	    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）
	});
	$("#toleft,#toright").hover(function() {
	        $(this).css({
	            "color": "black"
	        })
	    },
	    function() {
	        $(this).css({
	            "opacity": "0.3",
	            "color": ""
	        })
	    })


	//鼠标移进  移出
	$("#lunbobox ul li,.lunbo a img,#toright,#toleft ").hover(
	    //鼠标移进
	    function() {
	        $('#toright,#toleft').show()
	        clearInterval(t);

	    },
	    //鼠标移开
	    function() {
	        t = setInterval(play, 3000);
		
	     }
	    )

	//首页的一些事件
})



