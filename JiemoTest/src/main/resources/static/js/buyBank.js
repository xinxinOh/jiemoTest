/**
 * 
 */
var examid;
var cate;
var search;
var tiku=1;//题库=0 是题库页面
function getPaperInfo(paperID) {
	window.location.href = "getPaperInfo?paperID=" + paperID;

}

//JavaScript代码区域

window.onload = function() {
	cate=0;
	search=0;
	initGoods(cate);

	layui.use('element', function() {
		var element = layui.element;

	});
	
	$("body").on("hover", ".NavBar-item", function() {

		$(this).css("background-color", "#BCDDBC");

	});

	$("body").on("mouseout", ".NavBar-item", function() {

		$(this).css("background-color", "#FFFFFF");

	});	
	
	$("body").on("click", ".question-num", function() {

		foreView($(this).parent().parent().parent().parent().children(".one-exam-header").children(".one-exam-goodsid").children("span").text());
       //alert($(this).parent().parent().parent().parent().children(".one-exam-header").children(".one-exam-fromid").children("span").text())
	});	
	
	 

}

function createTime(v) {
	return new Date(parseInt(v)).toLocaleString()
}

function search1(word){
	//alert(word);
	search=1;
	initGoods(word);
	
}

function findtag(tag){
	search=0;
	initGoods(tag);
}

function initGoods(type) {  //search=0时 代表未在搜索，type值为标签  search=1时代表在搜索 type为搜索的关键字
	if(type==0||search==1){
		
	}else{
		$("legend").text(type);
	}
	
	if(search==1){
		$("legend").text(type+" 搜索结果：");
	}
	
    cate=type;
   // alert(type);
	$.ajax({
		type: "GET",
		url: "loadBank?start="+0+"&end="+10+"&type="+cate+"&search="+search,//type 0 初始按热门加载
		dataType: "json",
		success: function(result) {
			$(".bank-info").empty();
			var dataObj = result; //返回的result为json格式的数据
			//var dataObj=JSON.stringify(result);
			//alert(JSON.stringify(dataObj));
			
			$.each(dataObj, function(index, item) {
				var s1 = item.spare3;
				var s2 = item.goodsid;
				var s3 = item.fromid;
				var s4 = item.userid;
				var s5 =createTime(item.createtime);
				var s6 = item.goodsprice;
				var s7 = item.spare1;
				var s9 = item.goodstag;
				var div = '﻿<div class="one-exam" style="width: 300px!important;height: 140px!important;border: 1px solid #CCC;border-top:3px solid #5FB878;display: inline-block;margin: 20px;">' +
					'<div class="one-exam-header">' +
					'<div class="one-exam-title" style="margin-top: 22px;margin-left: 12px;display: inline-block;">' +
					'<span style="font-size: 15px;color: #333;" >'+s1+'</span>' +
					'</div>' +
					'' +
					'<div class="one-exam-goodsid" style="margin-top: 22px;margin-left: 12px;display: none;">' +
					'<span style="font-size: 15px;color: #333;" >'+s2+'</span>' +
					'</div>' +
					'<div class="one-exam-fromid" style="margin-top: 22px;margin-left: 12px;display: none;">' +
					'<span style="font-size: 15px;color: #333;" >'+s3+'</span>' +
					'</div>' +
					'<div class="one-exam-userid" style="margin-top: 22px;margin-left: 12px;display: none;">' +
					'<span style="font-size: 15px;color: #333;" >'+s4+'</span>' +
					'</div>' +
					'' +
					'<div class="one-exam-manage" style="float:right;color:#01AAED;background-color:#FFFFFF;display: inline-block;">' +
		
					'<span class="layui-badge" style="background-color:#5FB878;" >'+s9+'</span>' +
					'</div>' +
					'<div class="one-exam-time" style="width:270px;margin-left:12px;margin-top:20px;margin-bottom: 7px;display: inline-block;">' +
					'<span style="color: #888;">发布于</span>' +
					'<span style="color: #888;" >'+s5+'</span>' +
					'<div class="end-time" style="float:right">' +
					'<span class="end-time-span" style="color: #FF5722;font-size:19px;" >'+s6+'</span>' +
					'<span style="color: #888;">积分</span>' +
					'    </div>' +
					'</div>' +
					'' +
					'' +
					'</div>' +
					'<div class="exam-info" style="padding-top:7px;border-top: 1px solid #DDD;">' +
					'<div class="layui-row">' +
					'<div class="layui-col-md6" align="center">' +
					'<div class="question-num">' +
					'<i class="layui-icon layui-icon-file-b" style="font-size: 18px; color: #5FB878;"></i>' +
					'<span style="font-size: 14px;color: #444;" >预览</span>' +         
					'</div>' +
					'</div>' +
					'<div class="layui-col-md6" align="center">' +
					'<div class="points-sum">' +
					'<i class="layui-icon layui-icon-flag" style="font-size: 18px; color: #5FB878;"></i>' +
					'<span style="font-size: 14px;color: #444;" >'+s7+'</span>' +
					'<span style="font-size: 14px;color: #444;">购买</span>' +
					'' +
					'</div>' +
					'</div>' +
					'' +
					'</div>' +
					'</div>' +
					'</div>';
				$('.bank-info').append(div);

			});
		},
		error: function() {
			alert("loadBankError");
		}
	});
}


function continueLoad(){
	var start = parseInt($('.bank-info').children().length);
  	var end=start+3;
   
  	var Surl="loadBank?start="+start+"&end="+end+"&type="+cate+"&search="+search;
 
  	$.ajax({
  		type: "GET",
  		url: Surl,
  		dataType: "json",
  		success: function(result) {
  			
  			 var dataObj = result; //返回的result为json格式的数据
  			 if(dataObj==""){
   				layer.msg('已经到底啦');
   				return;
   			}
  	         con = "";
  			 var ii = layer.load();
   		    //此处用setTimeout演示ajax的回调
   		    setTimeout(function(){
   		      layer.close(ii);
   		    }, 800);
  			 $.each(dataObj, function(index, item){
  				var s1 = item.spare3;
				var s2 = item.goodsid;
				var s3 = item.fromid;
				var s4 = item.userid;
				var s5 =createTime(item.createtime);
				var s6 = item.goodsprice;
				var s7 = item.spare1;
				var s9 = item.goodstag;
				var div = '﻿<div class="one-exam" style="width: 300px!important;height: 140px!important;border: 1px solid #CCC;border-top:3px solid #5FB878;display: inline-block;margin: 20px;">' +
					'<div class="one-exam-header">' +
					'<div class="one-exam-title" style="margin-top: 22px;margin-left: 12px;display: inline-block;">' +
					'<span style="font-size: 15px;color: #333;" >'+s1+'</span>' +
					'</div>' +
					'' +
					'<div class="one-exam-goodsid" style="margin-top: 22px;margin-left: 12px;display: none;">' +
					'<span style="font-size: 15px;color: #333;" >'+s2+'</span>' +
					'</div>' +
					'<div class="one-exam-fromid" style="margin-top: 22px;margin-left: 12px;display: none;">' +
					'<span style="font-size: 15px;color: #333;" >'+s3+'</span>' +
					'</div>' +
					'<div class="one-exam-userid" style="margin-top: 22px;margin-left: 12px;display: none;">' +
					'<span style="font-size: 15px;color: #333;" >'+s4+'</span>' +
					'</div>' +
					'' +
					'<div class="one-exam-manage" style="float:right;color:#01AAED;background-color:#FFFFFF;display: inline-block;">' +
					'<span class="layui-badge" style="background-color:#5FB878;" >'+s9+'</span>' +
					'</div>' +
					'<div class="one-exam-time" style="width:270px;margin-left:12px;margin-top:20px;margin-bottom: 7px;display: inline-block;">' +
					'<span style="color: #888;">发布于</span>' +
					'<span style="color: #888;" >'+s5+'</span>' +
					'<div class="end-time" style="float:right">' +
					'<span class="end-time-span" style="color: #FF5722;font-size:19px;" >'+s6+'</span>' +
					'<span style="color: #888;">积分</span>' +
					'    </div>' +
					'</div>' +
					'' +
					'' +
					'</div>' +
					'<div class="exam-info" style="padding-top:7px;border-top: 1px solid #DDD;">' +
					'<div class="layui-row">' +
					'<div class="layui-col-md6" align="center">' +
					'<div class="question-num">' +
					'<i class="layui-icon layui-icon-file-b" style="font-size: 18px; color: #5FB878;"></i>' +
					'<span style="font-size: 14px;color: #444;">预览</span>' +
					'</div>' +
					'</div>' +
					'<div class="layui-col-md6" align="center">' +
					'<div class="points-sum">' +
					'<i class="layui-icon layui-icon-flag" style="font-size: 18px; color: #5FB878;"></i>' +
					'<span style="font-size: 14px;color: #444;" >'+s7+'</span>' +
					'<span style="font-size: 14px;color: #444;">购买</span>' +
					'' +
					'</div>' +
					'</div>' +
					'' +
					'</div>' +
					'</div>' +
					'</div>';
				$('.bank-info').append(div);
  	            
  	         });
  		},
  		error: function() {
  			alert("流加载 热门商品 error");
  		}
  	});
}


			
function	foreView(goodsid){
			alert("goodsid:"+goodsid);				
			window.location.href="toPreview?goodsid="+goodsid;
};
			


