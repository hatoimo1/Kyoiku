<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="com.aimax.kyoiku.bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>クロスサイトスクリプティング（XSS）</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<br/><br/>
	入力内容を確認してください。<br />
	<table border="1" class="brand" align="center">
		<tr><td>
		<%=bean.getText()%>
		</td></tr>
	</table>
</body>
</html>