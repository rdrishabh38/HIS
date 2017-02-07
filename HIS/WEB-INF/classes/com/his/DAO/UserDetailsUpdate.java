package com.his.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.his.DBUtil.DBConnect;
import com.his.constants.QueryConstant;
import com.his.exceptions.HISApplicationException;
import com.his.model.UserUpdateBean;
import com.mysql.jdbc.PreparedStatement;

public class UserDetailsUpdate {
	private static Connection conn;
	private static PreparedStatement pstmt;

	// private static ResultSet resultSet;

	public static void update(UserUpdateBean uub)
			throws HISApplicationException {
		String updateQuery = QueryConstant.UserUpdateQuery;

		try {
			conn = DBConnect.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(updateQuery);
			pstmt.setString(1, uub.getFirstName());
			pstmt.setString(2, uub.getLastName());
			pstmt.setString(3, uub.getEmail());
			pstmt.setString(4, uub.getPhonenumber());
			pstmt.setString(5, uub.getCustomer_id());
			if (pstmt.executeUpdate() == 0) {
				throw new HISApplicationException("Unable to update content");
			}

			updateQuery = QueryConstant.UserPasswordUpdateQuery;
			pstmt = (PreparedStatement) conn.prepareStatement(updateQuery);
			pstmt.setString(1, uub.getPassword());
			pstmt.setString(2, uub.getCustomer_id());
			if (pstmt.executeUpdate() == 0) {
				throw new HISApplicationException("Unable to update content");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			throw new HISApplicationException("Server error");
		} finally {

			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				throw new HISApplicationException("Error in closing connection");
			}
		}

	}

	private static void closeConnection() throws SQLException {

		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
