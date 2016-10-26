<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ page import="com.lgs.bean.Ex"%>
<%@ page import="com.lgs.dao.Dao"%>
<%@ page import="javax.swing.JOptionPane"%>
<%
	Vector ti = (Vector) session.getAttribute("timu");
%>
<link rel="stylesheet" href="CSS/style.css"  type='text/css'/>
<html>
<head>
<title>student!</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<style>
	.stage{
		position:absolute;
		top:0;
		left:0;
		width:100%;
		height:100%;
		background-color:#808A87;
		overflow:hidden;

	}
	.sheep{
		width:154px;
		height:117px;
		background-image:url("sheep.png");
		background-position:0 0;
		position:absolute;
		right:0;
		bottom:50px;
		background-repeat:no-repeat;
		cursor:-webkit-grabbing;
	}
</style>
</head>

<body>
<div class="stage" id="stage">
<p align="right">
	<a href="student.jsp" target="top" style="color:#FFFFFF;position:absolute; top: 20px; right:20px;">返回</a>
</p>
<div  class="lg-container">
<%
	String id = (String) session.getAttribute("idCard");
	if (null == id || id.equals("")) {
		out.print("<script language='javascript'>alert('请先登录系统！');window.location = 'login.jsp';</script>");
	}
%>
<%
	//答题结束后
	String judge = session.getAttribute("judgefinish").toString();
	if (judge.equals("session")) {
		session.invalidate();
		//JOptionPane.showMessageDialog(null, "答题结束！");
		out.print("<script>alert('答题结束！');</script>");
	}
%>
<form name="sDegree" method="post" action="SelectExercise">
	<tr><h1><%=request.getSession().getAttribute("usernameView").toString()%>
		选择练习类型</h1>
	</tr>
	<input type="hidden" id="user" value="<%=request.getSession().getAttribute("usernameView").toString()%>">
	<%
		//定义用户名
		String usernameView = request.getSession().getAttribute("usernameView").toString();
		session.setAttribute("usernameGrade", usernameView);
		session.setAttribute("time01", System.currentTimeMillis());
	%>
	<br>
	<tr>
		<select name="select" style="font-family: 'Oleo Script', cursive;font-size: 18px;">
			<option value="simple">简单四则运算</option>
			<option value="hard">混合四则运算</option>
			<option value="properfraction">真分数运算</option>
		</select>
	</tr>
	<tr>
		<button type="submit" style="margin-left:50px;
		font-family: 'Oleo Script', cursive;
		font-size: 18px;
		border:1px solid #000;
		padding:5px 10px;
		border:1px solid rgba(51,51,51,.5);
		-webkit-border-radius:10px;
		-moz-border-radius:10px;

		-webkit-box-shadow: 2px 1px 1px #aaa;
		-moz-box-shadow: 2px 1px 1px #aaa;
		cursor:pointer;">提交</button>
		<input type="hidden" value="<%=usernameView%>" name="username" />
	</tr>
</form>
</div>
</div>
<script>
	var stage=document.getElementById("stage");
	var SHEEP_WIDTH=164,TRAN_SPEED=10,SPRIPT_SPEED=70;
	var screenWidth=window.innerWidth;
	window.onresize = function(){
		screenWidth=window.innerWidth;
	}
			createSheep();
	var create=setInterval(createSheep,1500);
	//创建小羊
	function createSheep(){
		//限制最多9只小羊
		sheeps=stage.childNodes;
		if(sheeps.length>8){
			return false;
		}
		var sheep=new Sheep();
		setMove(sheep);
	}
	//初始化小羊
	function Sheep(){
		this.tran_y=0;
		this.sprit_left=0;
		this.spriptSpeed=SPRIPT_SPEED+20*Math.random();
		this.tranSpeed=TRAN_SPEED+TRAN_SPEED*Math.random();
		this.tran_x=SHEEP_WIDTH+400*Math.random();
		this.sheepDom=document.createElement("div");
		this.sheepDom.className="sheep";
		this.sheepDom.style.transform='translate3d('+SHEEP_WIDTH+'px, 0, 0)';
		stage.appendChild(this.sheepDom);
		this.spritTop=0;
		this.catch=false;
		this.x=0;
		this.y=0;
	}
	//移动的小羊
	function setMove(sheep){
		var sprit=setInterval(spritMove,sheep.spriptSpeed);
		var walkl=setInterval(walkMove,sheep.spriptSpeed);
		//改变背景图片位置
		function spritMove(){
			if(sheep.sprit_left<(SHEEP_WIDTH*7)){
				sheep.sprit_left=sheep.sprit_left+SHEEP_WIDTH;
			}else{
				sheep.sprit_left=0;
			}
			sheep.sheepDom.style.backgroundPosition=-sheep.sprit_left+'px '+sheep.spritTop+'px';
		}
		//小羊移动
		function walkMove(){
			sheep.sheepDom.style.transform='translate3d('+sheep.tran_x+'px, '+sheep.tran_y+'px, 0)';
			if(sheep.tran_x>-(screenWidth+SHEEP_WIDTH+100)){
				sheep.tran_x=sheep.tran_x-sheep.tranSpeed;
			}else{
				clearInterval(walkl);
				clearInterval(sprit);
				stage.removeChild(sheep.sheepDom);
				sheep=null;
			}
		}
		//鼠标按下
		sheep.sheepDom.addEventListener('mousedown',function(ev){
			sheep.spritTop=-128;
			sheep.tranSpeed=0;
			sheep.catch=true;
			var oEvent = event || ev;
			sheep.x=oEvent.pageX;
			sheep.y=oEvent.pageY;
		},false);
		//鼠标移开
		sheep.sheepDom.addEventListener('mouseup',function(){
			if(sheep.catch){
				sheep.spritTop=0;
				sheep.tranSpeed=TRAN_SPEED+TRAN_SPEED*Math.random();
				sheep.catch=false;
				sheep.tran_y=0;
			}
		},false);
		//鼠标离开
		sheep.sheepDom.addEventListener('mouseout',function(ev){
			if(sheep.catch){
				sheep.spritTop=0;
				sheep.tranSpeed=TRAN_SPEED+TRAN_SPEED*Math.random();
				sheep.catch=false;
				sheep.tran_y=0;
			}

		},false);
		//鼠标移动，鼠标移动是有问题的，不应该存在鼠标从小羊身上移开的情况，因为此时小羊应该随着鼠标移动
		sheep.sheepDom.addEventListener('mousemove',function(ev){
			if(sheep.catch){
				var oEvent = event || ev;
				sheep.tran_x=sheep.tran_x-(sheep.x-oEvent.pageX);
				sheep.tran_y=sheep.tran_y-(sheep.y-oEvent.pageY);
				sheep.sheepDom.style.transform='translate3d('+sheep.tran_x+'px, '+sheep.tran_y+'px, 0)';
				sheep.x=oEvent.pageX;
				sheep.y=oEvent.pageY;
			}
		},false);
	}
</script>
</body>
</html>
