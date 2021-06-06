<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<script type="text/javascript">
function redirect() {

	var url = document.getElementById("urlTxt").value;
	if (url == "") {
		alert("URLを入力してください")
	} else {

		var target = document.getElementById("linkRedirect")
		target.href = url;
		target.click();
	}
}
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>HTTPヘッダインジェクション</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<br /><br />
	<table border="0" align="center">
		<tr>
			<td>URL</td>
			<td>
				<input type="text" id="urlTxt" size="80" value="http://localhost:8060/HttpHeaderInject?location=SqlInject"></input>
			</td>
		</tr>
	</table>
	<a href="/" id="linkRedirect" style="display: none;"></a>

	<input type="button" value="リダイレクト" onclick="redirect()"></input>
</body>
</html>