<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.aimax.kyoiku.bean.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>セッションハイジャック</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<br /><br />
	<%LoginBean bean = (LoginBean)request.getAttribute("bean");%>
	<table border="1" class="brand" align="center">
	<tr>
		<th style="background-color: #bde9ba">Cookieのキー</th>
		<th style="background-color: #bde9ba">値</th>
	</tr>
	<tr>
		<td style="text-align: left"><%=bean.getName() %></td>
		<td style="text-align: left"><%=bean.getText() %></td>
	</tr>
	</table>

</body>
</html>