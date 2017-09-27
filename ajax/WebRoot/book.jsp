<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'book.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery.js"></script>
<script>
$().ready(function(){


$("li").hover(function(){

alert("!")

},function(){

})


})




</script>
<style>
li{
margin-top:30px;
border:1px solid red;
width:150px;
height:30px;
}

</style>
</head>

<body>
	<ul>
		<li>图书1</li>
		<li>图书2</li>
		<li>图书3</li>
	</ul>
</body>
</html>
