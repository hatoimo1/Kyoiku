<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="com.aimax.kyoiku.bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<script type="text/javascript">
function check() {

	var inputName = document.getElementById("inputText");
	if (inputName.value == "") {
		alert("テキストを入力してください")
	} else {
		document.myform.submit();
	}
}
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>クロスサイトスクリプティング（XSS）</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<br/><br/>
	<form name="myform" action="/Xss" method="POST">
		テキストを入力してください。<br />
		<textarea type="text" id="inputText" name="inputText" rows="5" cols="50"><%=bean.getText()%></textarea>
		<br/><br/>
		<input type="button" value="テキスト送信" onclick="check()"></input>
	</form>

</body>
</html>