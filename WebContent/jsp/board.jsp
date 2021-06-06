<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.aimax.kyoiku.bean.BoadBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<script type="text/javascript">
function boardCheck() {
	var txt = document.getElementById("boardTxt").value;
	if (txt.length <= 0) {
		alert("コメントを入力してください。");
	} else {
		document.myform.submit();
	}
}

function deleteComent(date, sessionId) {

	var result = window.confirm('削除していいですか？');

    if(result) {
		var form = document.createElement('form');
		form.action = "/Board";
		form.method = 'post';
		addPost(form, "date", date);
		addPost(form, "sessionId", sessionId);
		document.body.appendChild(form);
		form.submit();
    	//console.log('OKがクリックされました');
    }
}

function addPost(form, name, value) {
    // エレメントを作成
    var ele = document.createElement('input');
    ele.type = 'hidden';
    ele.name = name;
    ele.value = value;
    // 要素を追加
    form.appendChild(ele);
}
</script>
<title>掲示板</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<table border="1" class="brand" align="center">
		<%ArrayList<BoadBean> list = (ArrayList)request.getAttribute("list");%>
		<%for (BoadBean data : list) { %>
		<tr>
			<td  style="text-align: left">
				投稿者：<%=data.getName() %>
				<br />
				投稿日時：<%=data.getDate() %>
				<br />
				<!-- セッションID -->
				<input type="hidden" value="<%=data.getSessionId() %>"></input>
				<br />
				<%=data.getWrite() %>
				<br />
				<input type="button" onClick="deleteComent('<%=data.getDate() %>', '<%=data.getSessionId() %>')" value="削除"></input>
			</td>
		</tr>
		<%} %>
	</table>
	<br />
	<form name="myform" action="/Board" method="POST">
		<textarea id="boardTxt" name="inputText" rows="5" cols="50"></textarea>
		<br />
		<input type="button" onClick="boardCheck()" value="送信"></input>
	</form>
</body>
</html>