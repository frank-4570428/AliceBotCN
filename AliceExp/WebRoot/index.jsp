<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="org.olaxy.aiml.*"%>
<%@ page language="java" import="bitoflife.chatterbean.AliceBot"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	    AliceBot bot = AliceBotMother.aliceBot;
	    String key = request.getParameter("key");
	    String value = "";
	    if(key == null || key.equals("")){
	    	value = bot.respond("welcome");
	    }else{
	    	value = bot.respond(key);
	    	System.out.println("====" + key);
	    	System.out.println("====" + value);
	    }
	    
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<br />
		<span>&gt;<%=key %></span>
		<br />
		<span>&gt;<%=value %></span>
		<br />
		<form action="index.jsp" method="post">
			<input type="text" name="key" />
			<input type="submit" />
		</form>
	</body>
</html>
