<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" %>
<header class="site-header">
  <div class="wrapper site-header__wrapper">
    <span>2021/06/25 セキュリティ勉強会</span>
    <span>
      <%=session.getAttribute("loginName") != null ? session.getAttribute("loginName") : "ゲスト"%>
    </span>
    <a href="/Index">トップページ</a>
  </div>
</header>