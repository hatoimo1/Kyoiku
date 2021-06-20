package com.aimax.kyoiku.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimax.kyoiku.constant.Const;

@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ログインチェック
		loginCheck(request, response);

	    RequestDispatcher dispatcher = request.getRequestDispatcher(Const.JSP_INDEX);
	    dispatcher.forward(request, response);
	}

}
