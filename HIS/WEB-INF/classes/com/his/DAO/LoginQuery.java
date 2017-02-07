package com.his.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.his.DBUtil.DBConnect;
import com.his.constants.ErrorConstant;
import com.his.constants.QueryConstant;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.CustomerLoginBean;
import com.mysql.jdbc.PreparedStatement;

public class LoginQuery {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;

	public static void isVerified(CustomerLoginBean clb)
			throws HISApplicationException, HISBusinessException {
		String id = clb.getId();
		String pass = clb.getPass();
		try {
			conn = DBConnect.getConnection();
			String sql = QueryConstant.loginQuery;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("customer_first_name") + " "
						+ resultSet.getString("customer_last_name");
				clb.setName(name);
				// return true;
			} else
				throw new HISBusinessException(
						ErrorConstant.INVALID_ID_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new HISApplicationException(e);
		} finally {

			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				throw new HISApplicationException();
			}
		}

	}

	public static void adminLoginQuery(String ID, String Password) throws HISBusinessException, HISApplicationException
	{
		try {
			conn = DBConnect.getConnection();
			String sql = QueryConstant.AdminloginQuery;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, Password);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				
			} else
				throw new HISBusinessException(
						ErrorConstant.INVALID_ID_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new HISApplicationException(e);
		} finally {

			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				throw new HISApplicationException();
			}
		}
	}
	
	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
