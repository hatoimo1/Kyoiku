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
import com.aimax.kyoiku.bean.TableDataBean;
import com.aimax.kyoiku.constant.Const;
import com.aimax.kyoiku.util.DBUtil;

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

		// リクエスト情報取得
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		String forward = null;
		if (account == null) {
			// 初回表示
			forward = Const.JSP_LOGIN;
		} else {

			// 入力あり
			TableDataBean bean =  DBUtil.getUserInfoLogin(account, password);
			if (bean != null) {
				// 認証成功
				forward = Const.JSP_INDEX;

				// セッション生成
				HttpSession session = request.getSession(true);
				session.setAttribute("loginName", bean.getKanaSei() + " " + bean.getKanaMei());
			} else {
				// 認証失敗
				forward = Const.JSP_LOGIN;

				// 画面表示情報設定
				LoginBean loginBean = new LoginBean();
				loginBean.setUserId(account);
				loginBean.setPassword(password);
				loginBean.setText("ログイン失敗しました");

				// リクエスト設定
				request.setAttribute("bean", loginBean);
			}
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
