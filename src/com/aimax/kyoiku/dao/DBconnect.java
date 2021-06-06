package com.aimax.kyoiku.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBconnect {

	public Connection getConnection() {

		// DBの接続先情報を取得（context.xmlの内容）
		try {
			// 初期コンテキスト構築
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/aimax");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}