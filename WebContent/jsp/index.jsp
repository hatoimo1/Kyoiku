<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>セキュリティ勉強会</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<br/><br/>
	<a href="/Login">ログイン（セッション生成）</a>
	<br/><br/>
	<a href="/Xss">クロスサイトスクリプティング（XSS）</a>
	<br /><br/>
	<a href="/Csrf">クロスサイトリクエストフォージェリ（CSRF）</a>
	<br /><br/>
	<a href="/SessionHijack">セッションハイジャック</a>
	<br /><br/>
	<a href="/SqlInject">SQLインジェクション</a>
	<br/><br/>
	<!--
	<a href="/HttpHeaderInject">HTTPヘッダインジェクション</a>
	<br /><br/>
	 -->
	<a href="/Board">掲示板</a>
</body>
</html>