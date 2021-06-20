<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="com.aimax.kyoiku.bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<script type="text/javascript">
function check() {

	var inputName = document.getElementById("inputName");
	var inputName2 = document.getElementById("inputName2");
	if (inputName.value == "") {
		alert("アカウントを入力してください")
	} else if (inputName2.value == "") {
		alert("パスワードを入力してください")
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
	<div class="wrapper site-header__wrapper" style="background-color: #def7ff;">
	  <span>2021/06/25 セキュリティ勉強会</span>
	</div>

	<form name="myform" action="/Login" method="POST">


		<span align="center" style="color: red"><%=bean.getText()%></span>
		<table class="brand" align="center">
			<tr>
				<td>アカウント</td>
				<td><input type="text" id="inputName" name="account" value="<%=bean.getUserId()%>"></input></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text" id="inputName2" name="password" placeholder="password" value="<%=bean.getPassword()%>"></input></td>
			</tr>

		</table>

		<input type="button" value="ログイン" onclick="check()"></input>
	</form>
</body>
</html>