package com.aimax.kyoiku.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aimax.kyoiku.bean.BoadBean;
import com.aimax.kyoiku.constant.Const;
import com.aimax.kyoiku.util.DBUtil;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ログインチェック
		loginCheck(request, response);

		// パラメータを取得
		String inputText = request.getParameter("inputText");
		String datePrm = request.getParameter("date");
		String sessionPrm = request.getParameter("sessionId");

		if (datePrm != null && sessionPrm != null) {

			// コメント削除
			BoadBean bean = new BoadBean();
			bean.setSessionId(sessionPrm);
			bean.setDate(datePrm);
			DBUtil.deleteBoard(bean);
		} else if (inputText != null) {

			// 改行を変換
			inputText = inputText.replace("\r\n", "<br />");

			// DB登録
			HttpSession session = request.getSession(true);
			String loginName = (String) session.getAttribute("loginName");
			if (loginName == null) {
				loginName = "ゲスト";
			}

			// セッションID取得
			Cookie cookie[] = request.getCookies();
			String sessionId = "";
			if (cookie != null) {
				Cookie c = cookie[0];
				sessionId = c.getValue();
			}

			BoadBean bean = new BoadBean();
			bean.setName(loginName);
			bean.setSessionId(sessionId);
			bean.setWrite(inputText);
			DBUtil.insertBoard(bean);
		}

		// DB取得
		List<BoadBean> list = DBUtil.getAllBoard();

		// リクエスト設定
		request.setAttribute("list", list);

	    RequestDispatcher dispatcher = request.getRequestDispatcher(Const.JSP_BOARD);
	    dispatcher.forward(request, response);
	}

}
