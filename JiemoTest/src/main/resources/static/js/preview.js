
window.onload = function() {
	cate=0;
	search=0;

	layui.use('element', function() {
		var element = layui.element;

	});
	
	$("body").on("hover", ".NavBar-item", function() {

		$(this).css("background-color", "#BCDDBC");

	});

	$("body").on("mouseout", ".NavBar-item", function() {

		$(this).css("background-color", "#FFFFFF");

	});	
	$("body").on("click", ".zhifu-button", function() {
          var s1=$(".goodsprice").text();
		  var s2=$(".bankid").text();
		  var s3=$(".goodsid").text();
		$.ajax({
		type: "GET",
		url: "buyBank?goodsprice="+s1+"&bankid="+s2+"&goodsid="+s3,//type 0 初始按热门加载
		dataType: "text",
		success: function(result) {
			layer.msg(result);
			},
		error: function() {
			alert("buyBankError");
		}
	});

	});	
	
	$("body").on("click", ".buy-button", function() {

		  var s1=$(".goodsprice").text();
		  var s2=$(".bankname").text();
		   layer.open({
		 	      type: 1,
		 	      area: ['370px', '180px'],
		 	      shadeClose: true, //点击遮罩关闭
		 	      content:
		'<div class="layui-row">'+
				'<div class="layui-col-md12">'+
				'	&nbsp;'+
				'</div>'+
		'</div>'+
		'<div class="layui-row">'+
			'	<div class="layui-col-md1">'+
				'	&nbsp;'+
				'</div>'+
			'	<div class="layui-col-md10">'+
				'	<span style="font-size: 16px;color:#4E5465">商品名称：'+s2+'</span>'+
				'</div>'+
				'<div class="layui-col-md1">'+
				'	&nbsp;'+
			'	</div>'+
			'</div>'+
			'<div class="layui-row">'+
			'	<div class="layui-col-md1">'+
			'		&nbsp;'+
			'	</div>'+
			'	<div class="layui-col-md10">'+
				'	<span style="font-size: 16px;color:#4E5465">所需积分：'+s1+'</span>'+
				'</div>'+
				'<div class="layui-col-md1">'+
				'	&nbsp;'+
			'	</div>'+
		'	</div>'+

					'<div class="layui-row">'+
						'<div class="layui-col-md4">'+
							
						'	&nbsp;'+
						'</div>'+
						'<div class="layui-col-md7">'+
						'	<div class="zhifu-button" style="text-align: right;">'+
							'	<span class="layui-btn">确认购买</span>'+
							'</div>'+

						'</div>'+
						'<div class="layui-col-md1">'+
							
						'	&nbsp;'+
						'</div>'+
				'	</div>'
		 	    	  
		 	    	  
		  //各种基于事件的操作，下面会有进一步介绍
	 	
 	});
		  
			
	});	
	
	 

}/**
 * 
 */