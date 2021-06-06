<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="com.aimax.kyoiku.bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/main.js"></script>
<script type="text/javascript">
function check() {

	var url = document.getElementById("urlTxt").value;
	if (url == "") {
		alert("URLを入力してください")
	} else {

		var form = document.createElement('form');
		form.action = url;

		// POST設定
		var postVal = document.getElementById('postVal').value;
		var list = postVal.split('&');

		if (postVal == "") {
			form.method = 'get';
		} else {
			form.method = 'post';
		}

		for (var i = 0; i < list.length; i++) {
			var val = list[i].split('=');
			addPost(form, val[0], val[1]);
		}

		// リクエスト送信
		document.body.appendChild(form);
		form.submit();
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
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css" />
<title>クロスサイトリクエストフォージェリ（CSRF）</title>
</head>
<body class="brand">
    <!-- Header Start -->
    <jsp:include page="header.jsp" flush="true" />

	<br /><br />
	<table border="0" align="center">
		<tr>
			<td>URL</td>
			<td>
				<input type="text" id="urlTxt" size="80" value="https://111.108.206.210/astro/timeEntry"></input>
			</td>
		</tr>
		<tr>
			<td>POST</td>

			<td><textarea id="postVal" rows="10" cols="80"></textarea></td>
		</tr>
	</table>
	<input type="button" value="サイトへ移動" onclick="check()"></input>

</body>
</html>