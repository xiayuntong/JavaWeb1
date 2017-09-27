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

<title>My JSP 'hello.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.css">
<style type="text/css">
#mes {
	width: 300px;
	height: 30px;
}
</style>
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#mes").keyup(function() {
			if ($(this).val() == "") {

				$("#tishi").html("");
				$("#tishi").css("border", "none");
			} else {
				$.ajax({
					url : "promot",
					data : {
						"mes" : $(this).val()
					},
					type : "post",
					dataType : "text",
					success : function(data) {
						/* java中有个replaceAll 但是 js中没有 所以借用正则表达式的replace /,/g代表全局，即所有的逗号   */

						$("#tishi").html(data.replace(/,/g, "<br/>"));
						if ($("#tishi").html() != "") {

							$("#tishi").css("border", "2px solid green");
							$("#tishi").css("color", "red");
						} else {
							$("#tishi").css("border", "none");

						}
					},
					error : function(data) {

					}

				})
			}
		})
	})
</script>

</head>

<body>
	<div style="width:400px; margin:100px auto;">
		<div style="width:300px;height:500px;float:left;">
			<input type="text" id="mes" />
			<div id="tishi" style="width:300px;"></div>
		</div>
		<div>
			<input type="button" id="search" value="搜索" style="float:left;">
		</div>
	</div>
</body>
</html>
