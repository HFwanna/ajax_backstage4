<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="JS/jquery-1.11.0.js"></script>
<script type="text/javascript">
//为搜索绑定聚焦事件
$(function(){
	$("#search").keyup(function(){
		var content = $(this).val();
		var returnStr = "";
		$.ajax({
			type:"POST",
			url:"/ajax_backstage4/AjaxStruts2HibernateAction",
			contentType:"application/x-www-form-urlencoded",
			data:{"content":content},
			dataType:"json",
			success:function(data){
				//请求正确后的操作
				if(data.length>0){
					for(var i=0;i<data.length;i++){
						returnStr += "<div id='div' style='padding:5px;cursor:pointer' onmouseover='overFn(this)' onmouseout='outFn(this)' onclick='clickFn(this)'>"+data[i]+"</div>";//
					} 
					$("#div").html(returnStr);
					$("#div").css("display","block");
				}else{
					$("#div").css("display","none");
				}
			},
			error:function(result){
				//请求失败后的操作
			}
		});	
	});
	$("#search").blur(function(){
		$("#div").css("display","none");
	});
})
//绑定按钮事件
$(function(){
	$("#button").click(function(){
		var sub = $("#search").val();
		$.ajax({
			type:"POST",
			url:"/ajax_backstage4/AjaxStruts2HibernateAction",
			contentType:"application/json",
			data:JSON.stringify({"sub":sub}),
			dataType:"json",
			success:function(result){
				//请求正确后的操作
			},
			error:function(result){
				//请求失败后的操作
			}
		});
	});
})
//对div添加鼠标移入效果
function overFn(obj){
	$(obj).css("background-color","yellow");
}

//对div添加鼠标移出效果
function outFn(obj){
	$(obj).css("background-color","#F0F8FF");
}

//对div内容添加点击效果
function clickFn(obj){
	$("#search").val($(obj).html());
	$("#div").css("display","none");
}


</script>
<body>	
	<input type="text" id="search" /><input type="button" id="button" value="按钮">
	<div id="div" style="width:150px;display:none;background-color: #F0F8FF"></div>
	<s:debug></s:debug>
</body>
</html>