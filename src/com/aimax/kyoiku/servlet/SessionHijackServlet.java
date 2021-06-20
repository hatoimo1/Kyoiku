package com.aimax.kyoiku.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimax.kyoiku.bean.LoginBean;
import com.aimax.kyoiku.constant.Const;

/**
 * Servlet implementation class SessionHijackServlet
 */
@WebServlet("/SessionHijackServlet")
public class SessionHijackServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ログインチェック
		loginCheck(request, response);

		LoginBean bean = new LoginBean();
		Cookie cookie[] = request.getCookies();

		if (cookie != null) {
			Cookie c = cookie[0];
			bean.setName(c.getName());
			bean.setText(c.getValue());
		}

		// リクエスト設定
		request.setAttribute("bean", bean);

		RequestDispatcher dispatcher = request.getRequestDispatcher(Const.JSP_SESSIONHIJACK);
		dispatcher.forward(request, response);
	}

}
