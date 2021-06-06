package com.aimax.kyoiku.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aimax.kyoiku.bean.BoadBean;
import com.aimax.kyoiku.bean.TableDataBean;
import com.aimax.kyoiku.dao.DBconnect;

public class DBUtil {

	public static void insertBoard(BoadBean bean) {

		Connection con = null;
		PreparedStatement st = null;
		try {
			con = new DBconnect().getConnection();
			String sql = "INSERT INTO BORAD (RES_NAME, SESSION_ID, RES_WRITE, RES_DATE) "
					+ "VALUES (?, ?, ?, TO_CHAR(SYSTIMESTAMP, 'YYYY/MM/DD HH24:MI:SS'))";
			st = con.prepareStatement(sql);
			st.setString(1, bean.getName());
			st.setString(2, bean.getSessionId());
			st.setString(3, bean.getWrite());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void deleteBoard(BoadBean bean) {

		Connection con = null;
		PreparedStatement st = null;
		try {
			con = new DBconnect().getConnection();
			String sql = "DELETE FROM BORAD WHERE SESSION_ID = ? AND RES_DATE = ?";
			st = con.prepareStatement(sql);
			st.setString(1, bean.getSessionId());
			st.setString(2, bean.getDate());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static List<TableDataBean> getUserInfo(String input) {

		List<TableDataBean> list = new ArrayList<TableDataBean>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = new DBconnect().getConnection();
			String sql;
			if (input == null) {
				return list;
			} else {
				sql = "SELECT * FROM USER_INFO WHERE ACCOUNT_ID LIKE '%" + input + "%' AND DELETE_FLG = 0";
			}
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				TableDataBean bean = new TableDataBean();
				bean.setUserId(String.valueOf(rs.getInt("USER_ID")));
				bean.setKanaMei(rs.getString("NAME_KANA_MEI"));
				bean.setKanaSei(rs.getString("NAME_KANA_SEI"));
				bean.setAccountId(rs.getString("ACCOUNT_ID"));
				list.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return list;
	}

	public static List<BoadBean> getAllBoard() {

		List<BoadBean> list = new ArrayList<BoadBean>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = new DBconnect().getConnection();
			String sql = "SELECT * FROM BORAD ORDER BY RES_DATE";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				BoadBean bean = new BoadBean();
				bean.setName(rs.getString("RES_NAME"));
				bean.setSessionId(rs.getString("SESSION_ID"));
				bean.setWrite(rs.getString("RES_WRITE"));
				bean.setDate(rs.getString("RES_DATE"));
				list.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return list;
	}
}
