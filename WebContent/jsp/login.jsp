<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="com.aimax.kyoiku.bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<script type="text/javascript">
function check() {

	var inputName = document.getElementById("inputName");
	if (inputName.value == "") {
		alert("名前を入力してください")
	} else {
		document.myform.submit();
	}
}
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>ログイン</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<form name="myform" action="/Login" method="POST">
		<span>名前</span>
		<input type="text" id="inputName" name="inputName" value="<%=bean.getName()%>"></input>
		<input type="button" value="ログイン" onclick="check()"></input>
	</form>
</body>
</html>