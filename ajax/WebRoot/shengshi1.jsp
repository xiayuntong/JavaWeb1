<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>My JSP 'shengshi.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery.js"></script>
<script>
	$().ready(function() {

		$("#sheng").change(function() {

			$.ajax({

				url : "city1",
				type : "post",
				dataType : "json",
				data : {
					"sId" : $(this).val()
				},
				success : function(data) {
				
					var ops = "";
					for (var i = 0; i < data.length; i++) {
						

						ops += "<option value="+data[i].id+">" + data[i].name + " </option>"

					}
					$("#shi").html(ops);

				}

			})

		})

	})
</script>

</head>

<body>
	<div style="width:100%;height:300px;border:1px solid red;">
		<div style="width:200px;margin:50px auto;">
			省份<select id="sheng">
				<c:forEach items="${shengs }" var="sheng">
					<option value="${ sheng.id}"
						<c:if test="${sId==sheng.id}">selected="selected"</c:if> />${sheng.name  }</option>

				</c:forEach>
			</select> 城市<select id="shi">
				<c:forEach items="${shis }" var="shi">
					<option value="${ shi.id}">${shi.name  }</option>

				</c:forEach>
			</select>
		</div>

	</div>
</body>
</html>
