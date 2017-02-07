package com.his.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.his.DBUtil.DBConnect;
import com.his.constants.ErrorConstant;
import com.his.constants.QueryConstant;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.ViewPolicyBean;
import com.mysql.jdbc.PreparedStatement;

public class EditPolicyQuery {

	private static Connection conn;
	private static PreparedStatement pstmt;
	
	public static void update(ViewPolicyBean vpb) throws HISApplicationException, HISBusinessException {
		String updateQuery = QueryConstant.PolicyUpdateQuery;
		String query = QueryConstant.GET_POLICY_DETAIL;
		
		try {
			conn = DBConnect.getConnection();
			
			pstmt=(PreparedStatement)conn.prepareStatement(query);
			pstmt.setInt(1,vpb.getPolicy_id());
			
			ResultSet rst=pstmt.executeQuery();
			if(rst.next()){
				if(!rst.getString("status").equalsIgnoreCase("pending"))
					throw new HISBusinessException(ErrorConstant.EDIT_POLICY_ERROR);
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(updateQuery);
			pstmt.setInt(1,vpb.getPolicy_amount());
			pstmt.setString(2, vpb.getPremium_type());
			pstmt.setInt(3, vpb.getPolicy_duration());
			pstmt.setInt(4,vpb.getPolicy_id());
			
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
