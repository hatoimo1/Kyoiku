<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.aimax.kyoiku.bean.TableDataBean"%>
<jsp:useBean id="bean" class="com.aimax.kyoiku.bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>SQLインジェクション</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<form name="myform" action="/SqlInject" method="POST">
		<span>アドレス検索</span>
		<input type="text" id="inputText" name="inputText" value=""></input>
		<input type="submit" value="検索"></input>
		<br/><br/>
		<p><%=bean.getText() %></p>
		<br/><br/>
		<table border="1" class="brand" align="center">
			<tr style="background-color: #bde9ba">
				<th style="background-color: #bde9ba">ID</th>
				<th style="backgournd-color: #bde9ba">姓（カナ）</th>
				<th style="backgournd-color: #bde9ba">名（カナ）</th>
				<th style="backgournd-color: #bde9ba">アドレス</th>
			</tr>
			<%ArrayList<TableDataBean> list = (ArrayList)request.getAttribute("list");%>
			<%for (TableDataBean data : list) { %>
			<tr>
				<td><%=data.getUserId() %></td>
				<td><%=data.getKanaSei() %></td>
				<td><%=data.getKanaMei() %></td>
				<td><%=data.getAccountId() %></td>
			</tr>
			<%} %>
		</table>

	</form>
</body>
</html>