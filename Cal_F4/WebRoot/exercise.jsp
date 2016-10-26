<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="com.lgs.bean.Ex"%>
<%@ page import="com.lgs.dao.Dao"%>
<%
	Vector ti = (Vector) session.getAttribute("timu");
	if (ti == null) {
		ti = new Vector();
	}
	String judge = null;
	String username = session.getAttribute("exuname").toString();
	Dao dao = new Dao();
	double startTime = System.currentTimeMillis();
	int count = 0;
	int ECount=0;
%>
<script type="text/javascript">
function timedMsg()
 {
    var t=setTimeout("alert('time out!考试结束');window.navigate('student.jsp')",1201000);
   
 }
</script>
<style>
#mytime {
	text-align: center;
}
</style>
<script>
        function two_char(n) {
            return n >= 10 ? n : "0" + n;
        }
        function time_fun() {
            var sec=0;
            setInterval(function () {
                sec++;
                var date = new Date(0, 0)
                date.setSeconds(sec);
                var h = date.getHours(), m = date.getMinutes(), s = date.getSeconds();
                document.getElementById("mytime").innerText = two_char(h) + ":" + two_char(m) + ":" + two_char(s);
            }, 1000);
        }
    </script>
<html>
<head>
<script type="text/javascript">
 function submit(i)
   {
   var x1 = document.getElementById("head"+i).value;
   var x2= document.getElementById("answer"+i).value;
   var x3=document.getElementById("count").value;
   document.getElementById("count").value=(parseInt(x3)+1);

				if (x1==x2)
				{
				  alert("回答正确");
				  var x = document.getElementById("head"+i).value;
				  document.getElementById("zhengjie"+i).value=x;
				  document.getElementById(i+1+"").value="false";
				  document.getElementById(i+1+"").value="true";
				} 
				else if(x1!=x2)
			    {
				  alert("回答错误");
				  var x = document.getElementById("head"+i).value;
				  document.getElementById("zhengjie"+i).value=x;
				  document.getElementById(i+1+"").value="false";
				  
				}
				
 }
 </script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0" F>
</head>

<body background="img/bg_ex.png"  style="background-repeat:no-repeat; background-position:1080px  200px; background-color:#FFFACD;" onload="time_fun();timedMsg()">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/easyBackground-min.js"></script>
<div>
	<table>
		<td>
			<div align=left><%=username%>您现在进行的是 <font color=blue><%=session.getAttribute("kind").toString()%></font>难度的练习</div>
		</td>
		<td>
			<div style="position:absolute; top: 10px; width: 80px; right:20px;"><a href="student.jsp" align=right>退出考试</a></div>
		</td>
	</table>
</div>
<div align="center">
	<table align="center">
	<td>
		<h1 align="center">已用时间:</h1>
	</td>
	<td>
		<h1 id="mytime">00:00:00</h1>
	</td>
	</table>
</div>
<div align="center">
	<table>
		<tr>
			<td width=170 align=center><strong>题号</strong></td>
			<td width=169 align=center><strong>题目</strong></td>
			<td width=164 align=center><strong>答案</strong></td>
			<td width=52 align=center><strong>确认</strong></td>
			<td width=181 align=center><strong>正解</strong></td>
		</tr>
	</table>
</div>
<div align="center">
	<%
		session.setAttribute("startTime", startTime);
		for (int i = 0; i < ti.size(); i++) { 
			Ex ti01 = (Ex) ti.get(i);
			session.setAttribute("number", i + "");
			session.setAttribute("usernameEr", username);
	%>
	<table>
		<tr>
			<td><input type="text" id="number<%=i%>" value="<%=i + 1%>题"
				disabled="disabled" /></td>
			<td><input type="text" value="<%=ti01.getBody()%>"
				id="question<%=i%>" name="question<%=i%>" disabled="disabled" />
			</td>
			<td><input type="text" id="answer<%=i%>" />
			</td>
			<td><input type="submit" value="提交" id="submit<%=i%>"
				onclick="disabled=true;submit(<%=i%>)" />
			</td>
			<td>
				<input type="hidden" value="<%=ti01.getHead()%>" id="head<%=i%>" name="head<%=i%>" /> 
				<input type="text" id="zhengjie<%=i%>" name="judge" +i disabled="disabled"/>
			</td>		 
			<%
				session.setAttribute("head" + i, ti01.getBody() + "");
				session.setAttribute("question" + i, ti01.getHead() + "");
			%>
		</tr>
		<%
			}
		%>
	</table>
	</div>
	<div style="position:absolute; top: 100px; right:100px;">	
	<form action="JudgeItem" method="get">
		<input type=submit value="提交试卷"  />
		<input type="hidden" value="0" id="1" name="1"/>
		<input type="hidden" value="0" id="2" name="2"/>
		<input type="hidden" value="0" id="3" name="3"/>
		<input type="hidden" value="0" id="4" name="4"/>
		<input type="hidden" value="0" id="5" name="5"/>
		<input type="hidden" value="0" id="6" name="6"/>
		<input type="hidden" value="0" id="7" name="7"/>
		<input type="hidden" value="0" id="8" name="8"/>
		<input type="hidden" value="0" id="9" name="9"/>
		<input type="hidden" value="0" id="10" name="10"/>
		<input type="hidden" value="0" id="11" name="11"/>
		<input type="hidden" value="0" id="12" name="12"/>
		<input type="hidden" value="0" id="13" name="13"/>
		<input type="hidden" value="0" id="14" name="14"/>
		<input type="hidden" value="0" id="15" name="15"/>
		<input type="hidden" value="0" id="16" name="16"/>
		<input type="hidden" value="0" id="17" name="17"/>
		<input type="hidden" value="0" id="18" name="18"/>
		<input type="hidden" value="0" id="19" name="19"/>
		<input type="hidden" value="0" id="20" name="20"/>
		<input type="hidden" value="0" id="count" name="count"/>
	</form>	
	</div>
</body>
</html>
