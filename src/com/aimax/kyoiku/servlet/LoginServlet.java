package com.aimax.kyoiku.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aimax.kyoiku.bean.LoginBean;
import com.aimax.kyoiku.constant.Const;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// セッション生成
		HttpSession session = request.getSession(true);
		if (session == null) {
			session = request.getSession(true);
		}

		String loginName = (String)session.getAttribute("loginName");

		// リクエスト情報取得
		String inputName = request.getParameter("inputName");
		if (inputName != null && !inputName.equals("")) {
			loginName = inputName;
		} else {
			inputName = "";
		}

		// 画面表示情報設定
		LoginBean bean = new LoginBean();
		bean.setName(inputName);

		// リクエスト設定
		request.setAttribute("bean", bean);

		// セッション設定
		session.setAttribute("loginName", loginName);

	    RequestDispatcher dispatcher = request.getRequestDispatcher(Const.JSP_LOGIN);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
