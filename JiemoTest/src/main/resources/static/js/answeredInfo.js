/**
 * 
 */      
var paperid;
		var questionid;
		var sumscore;
		 var index;
			layui.use('element', function() {
				var element = layui.element;
			});

			$(document).ready(function() {
				checksum();
				layui.use('form', function() {
					var form = layui.form;
					form.render('select');
					form.render('checkbox');
					form.render('radio');
					//各种基于事件的操作，下面会有进一步介绍
				});
				var element = layui.element;
				element.init();

				
               $("body").on("click", ".exam-basic-info", function(){
                	
                	var index = $(".exam-btn-container .exam-basic-info").index(this);
                	if(index ==0){
                	    $('html,body').animate({scrollTop:parseInt($(".exam-intro-controller").offset().top)},300);	
                	}else{
                		$('html,body').animate({scrollTop:parseInt($(".part-question-info").children().eq(index-1).offset().top)},300);	
                	}

                	
                });

				
				$("body").on("click", "#scorebtn", function(){ 
					//onclick=score('+paperid+','+questionid+','+sumscore+',$(".aa").val();
					//alert("hahaha");
					//alert(paperid);
					//alert(questionid);
					//alert(sumscore);
					var a=$(".aa").val();
					//alert(a);	
					var params={'paperid':paperid,'questionid':questionid,'sumscore':sumscore,'score':a};
					var parnt = /^([1-9]\d*(\.\d*[1-9])?)|(0\.\d*[1-9])$/;
					if(parnt.test(a)){
						
					} else {
					layer.msg('请输入正整数');
					return;
					}
					$.ajax({
						async: false,
						url: 'grade',
						type: 'post',
						contentType: 'application/json;charset=utf-8', //请求的字符编码
						dateType: 'json', //返回类型
						data:JSON.stringify(params),
						success: function(e) {
							var a=JSON.parse(e);	    
						    //alert(a.msg);
						    layer.msg(a.msg);
						    if(a.flag){
						    	layer.close(index);
						    	//alert("questionid   "+a.questionid);
						    	//alert("score    "+a.score);
						    	$('#qid'+a.questionid).text("得分"+a.score);
						    	$('#qid'+a.questionid).css("color","darkseagreen");
						    	checksum();
						    }else{
						    	
						    }
							
						},
						error: function() {
							alert("score error");
						}
					});
					
					
				});
					
				$("body").on("click", ".time,.set-points", function() {

					var td = $(this);
					var txt = td.text();
					var input1 = $("<input class='layui-input' style='width: 50px;height: 20px;' type='text' value='" + txt + "'/>");

					td.html(input1);
					input1.click(function() {
						return false;
					});
					//获取焦点 
					input1.trigger("focus");
					//文本框失去焦点后提交内容，重新变为文本 
					input1.blur(function() {
						var newtxt = $(this).val();
						//判断文本有没有修改 
						if(newtxt != txt) {
							td.html(newtxt);
						}
					});
				});
              
				$("body").on("mouseover", ".num-proportity", function() {

					layer.tips('当前部分题目占考试所有题目30%', this, {
						tips: [1, '#5FB878'],
						time: 1000
					});
				});

				$("body").on("mouseover", ".points-proportity", function() {

					layer.tips('当前部分分值占考试总分30%', this, {
						tips: [1, '#FF5722'],
						time: 1000
					});
				});

				$("body").on("mouseover", ".one-question-points", function() {

					layer.tips('·填空题为每一个空的分数，多选题为总分（全部选对才可得分）', this, {
						tips: [1, '#FF5722'],
						time: 2000
					});
				});

			});
			
			
			
             function loadBasicInfo(){//更新总分 + 试卷判卷状态  +  部分得分
				
				paperid=$(".paperid").text();
				var params={'paperid':paperid};
				$.ajax({
					async: false,
					url: 'checkSumPoints',
					type: 'get',
					contentType: 'application/json;charset=utf-8', //请求的字符编码
					data:params,
					success: function(e) {
						   var a=JSON.parse(e);
					    	//alert("questionid   "+a.questionid);
					    	//alert("score    "+a.score);
					    	$("#student-sum-score").text(a.studentsumscore);
					    	$("#exam-sum-score").text(a.papersumscore);
					    	if(a.paperstate){
					    		$("#paper-state").text("已判卷");
					    		$("#paper-state").css("color","#007DDB");
					    	}
					    	else{
					    		$("#paper-state").text("未判卷");
					    		$("#paper-state").css("color","red");
					    	}
					    				
					},
					error: function() {
						alert("checksumerror");
					}
				});
			
				
			}
             
             $(window).scroll(function(){
				    
				    $(".all-btn").offset({top:$(document).scrollTop()+100});
				    
				});
			
			
			function checksum(){//更新总分 和 试卷判卷状态	
				paperid=$(".paperid").text();
				var params={'paperid':paperid};
				$.ajax({
					async: false,
					url: 'checkSumPoints',
					type: 'get',
					contentType: 'application/json;charset=utf-8', //请求的字符编码
					data:params,
					success: function(e) {
						   var a=JSON.parse(e);
						   var list=a.partdetail;
					    	//alert("questionid   "+a.questionid);
					    	//alert("score    "+a.score);
					    	$("#student-sum-score").text(a.studentsumscore);
					    	$("#exam-sum-score").text(a.papersumscore);
					    	if(a.paperstate){
					    		$("#paper-state").text("已判卷");
					    		$("#paper-state").css("color","#007DDB");
					    	}
					    	else{
					    		$("#paper-state").text("未判卷");
					    		$("#paper-state").css("color","red");
					    	}
					    	 $(".part-question-statistic").children("fieldset").children(".statistic-title").children("table").children("tbody").html("");
					    	for(var i=0;i<list.length;i++){
					    		  var content = '<tr>'+
									'<td>'+(i+1)+'</td>'+
									'<td>'+list[i].partname+'</td>'+
									'<td>'+list[i].partStudentScore+'</td>'+
									'<td>'+list[i].partSumScore+'</td>'+
								  '</tr>';
					    		  
					    		  $(".part-question-statistic").children("fieldset").children(".statistic-title").children("table").children("tbody").append(content);
					    	}
				    				
					},
					error: function() {
						alert("checksumerror");
					}
				});
				
			}
			
			function grade(a){
				
				 layui.use('form', function(){
		       var form = layui.form;
		       paperid = a.data('paperid');
			   questionid = a.data('questionid');
			   sumscore=a.data('sumscore');

		   index=layer.open({
		 	      type: 1,
		 	      area: ['320px', '190px'],
		 	      shadeClose: true, //点击遮罩关闭
		 	      content: 		 
		 	    	' <div class="layui-row ">'+
		 	    	'<div class="layui-col-md12">'+
		 	    	'&nbsp'+
		 	    	'</div>'+
		 	    	 '</div>'+	
		 	    	' <div class="layui-row ">'+
					'<div class="layui-col-md10">'+
					
		 	    	'<div class="layui-form-item">'+
			 	    '<label class="layui-form-label">分数</label>'+
			 	    '<div class="layui-input-block">'+
			 	      '<input type="text" name="score" required  lay-verify="required" placeholder="请输入分数" autocomplete="off" class="layui-input aa">'+
			 	     '<input type="text" name="paperid" style="display: none;" class="layui-input a" value="'+paperid+'">'+
			 	    '<input type="text" name="questionid" style="display: none;" class="layui-input b" value="'+questionid+'">'+
			 	   '<input type="text" name="sumscore" style="display: none;" class="layui-input b" value="'+sumscore+'">'+
			 	      '</div>'+
			 	 '</div>'+
			 	 
			 	 '</div>'+
			 	 
				 	'<div class="layui-col-md2">'+
				 	'&nbsp'+
				 	 '</div>'+
				 	 '</div>'+
			 	 
		 	'  <div class="layui-form-item">'+
		 	 '   <div class="layui-input-block">'+
		 	    '  <button class="layui-btn" id="scorebtn"  lay-filter="formDemo">保存</button>'+
		 	    '  <button type="reset" class="layui-btn layui-btn-primary">重置</button>'+
		 	   ' </div>'+
		 	 ' </div>'
	 	
 	});
		  
			
			}); 
						
			}