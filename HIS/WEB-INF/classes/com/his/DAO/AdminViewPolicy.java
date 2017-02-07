package com.his.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.his.DBUtil.DBConnect;
import com.his.constants.QueryConstant;
import com.his.exceptions.HISApplicationException;
import com.his.model.ViewPolicyBean;
import com.mysql.jdbc.PreparedStatement;

public class AdminViewPolicy {

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;

	static public List<ViewPolicyBean> policies()
			throws HISApplicationException {
		List<ViewPolicyBean> pl = new ArrayList<ViewPolicyBean>();
		ViewPolicyBean pb;
		String query = QueryConstant.ADMIN_GET_ALL_POLICIES;

		try {
			conn = DBConnect.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				pb = new ViewPolicyBean();
				pb.setCustomer_id(resultSet.getInt("customer_id"));
				pb.setInsurance_name(resultSet.getString("insurance_name"));
				pb.setPolicy_id(resultSet.getInt("policy_id"));
				pb.setPolicy_amount(resultSet.getInt("policy_amount"));
				pb.setPolicy_duration(resultSet.getInt("policy_duration"));
				pb.setPremium_type(resultSet.getString("premium_type"));
				pb.setPolicy_start_date(resultSet
						.getString("policy_start_date"));
				pb.setDiscount(resultSet.getInt("discount"));
				pb.setPremium_amount(resultSet.getInt("premium_amount"));
				pb.setMaturity_date(resultSet.getString("maturity_date"));
				pb.setStatus(resultSet.getString("status"));

				pl.add(pb);

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

		return pl;

	}
	
	
	public static ViewPolicyBean getSinglePolicy(String id) throws HISApplicationException{
		ViewPolicyBean pb=new ViewPolicyBean();
		
		String query = QueryConstant.ADMIN_GET_SINGLE_POLICIES; 

		try {
			conn = DBConnect.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(id));
			
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				pb = new ViewPolicyBean();
				pb.setCustomer_id(resultSet.getInt("customer_id"));
				pb.setInsurance_name(resultSet.getString("insurance_name"));
				pb.setPolicy_id(resultSet.getInt("policy_id"));
				pb.setPolicy_amount(resultSet.getInt("policy_amount"));
				pb.setPolicy_duration(resultSet.getInt("policy_duration"));
				pb.setPremium_type(resultSet.getString("premium_type"));
				pb.setPolicy_start_date(resultSet
						.getString("policy_start_date"));
				pb.setDiscount(resultSet.getInt("discount"));
				pb.setPremium_amount(resultSet.getInt("premium_amount"));
				pb.setMaturity_date(resultSet.getString("maturity_date"));
				pb.setStatus(resultSet.getString("status"));
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

		return pb;
	}
	
	
	public static void updatePolicyStatus(String pid,String status) throws HISApplicationException{
		String query = QueryConstant.ADMIN_POLICY_STATUS; 

		try {
			conn = DBConnect.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			pstmt.setString(1,status);
			pstmt.setInt(2, Integer.parseInt(pid));
			
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


	public static String getPolicyStatus(String pid) throws HISApplicationException {
		// TODO Auto-generated method stub
		String status=null;
		String query = QueryConstant.ADMIN_GET_POLICY_STATUS; 

		try {
			conn = DBConnect.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(pid));
			
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				status=resultSet.getString("status");
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

		return status;
	}
}
