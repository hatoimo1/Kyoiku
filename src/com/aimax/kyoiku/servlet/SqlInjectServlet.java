package com.aimax.kyoiku.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimax.kyoiku.bean.LoginBean;
import com.aimax.kyoiku.bean.TableDataBean;
import com.aimax.kyoiku.constant.Const;
import com.aimax.kyoiku.util.DBUtil;

/**
 * Servlet implementation class SqlInjectServlet
 */
@WebServlet("/SqlInjectServlet")
public class SqlInjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// リクエスト情報取得
		String inputText = request.getParameter("inputText");
		List<TableDataBean> list = new ArrayList<TableDataBean>();
		LoginBean bean = new LoginBean();
		if (inputText == null) {
			bean.setText("SQLを表示");
		} else {
			// DB取得
			bean.setText("SELECT * FROM USER_INFO WHERE ACCOUNT_ID LIKE '%" + inputText + "%' AND DELETE_FLG = 0");
			list = DBUtil.getUserInfo(inputText);
		}

		// リクエスト設定
		request.setAttribute("bean", bean);
		request.setAttribute("list", list);

	    RequestDispatcher dispatcher = request.getRequestDispatcher(Const.JSP_SQLINJECT);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
