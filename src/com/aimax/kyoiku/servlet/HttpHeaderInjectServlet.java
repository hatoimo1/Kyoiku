package com.aimax.kyoiku.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimax.kyoiku.constant.Const;

/**
 * Servlet implementation class HttpHeaderInjectServlet
 */
@WebServlet("/HttpHeaderInjectServlet")
public class HttpHeaderInjectServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ログインチェック
		loginCheck(request, response);

		String location = request.getParameter("location");

        if (location != null) {
        	// locationでリダイレクト
            response.sendRedirect(location);
            return;
        }

	    RequestDispatcher dispatcher = request.getRequestDispatcher(Const.JSP_HTTPHEADERINJECT);
	    dispatcher.forward(request, response);
	}

}
