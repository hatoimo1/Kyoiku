package com.aimax.kyoiku.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimax.kyoiku.bean.LoginBean;
import com.aimax.kyoiku.constant.Const;

/**
 * Servlet implementation class XssServlet
 */
@WebServlet("/XssServlet")
public class XssServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// リクエスト情報取得
		String forward;
		String inputText = request.getParameter("inputText");
		if (inputText != null && !inputText.equals("")) {
			forward = Const.JSP_XSS_CONFIRM;

			// 改行を変換
			inputText = inputText.replace("\r\n", "<br />");

			// 画面表示情報設定
			LoginBean bean = new LoginBean();
			bean.setText(inputText);

			// リクエスト設定
			request.setAttribute("bean", bean);
		} else {
			forward = Const.JSP_XSS;
			inputText = "";
		}

	    RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
