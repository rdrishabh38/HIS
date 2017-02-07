package com.his.constants;

public class QueryConstant {

	public static final String UserUpdateQuery = "UPDATE customer SET first_name = ?,last_name = ?, email= ? , contact_number = ? where customer_id = ?";
	public static final String UserPasswordUpdateQuery = "Update customer_login_detail set customer_password = ? where customer_id = ?";
	public static final String GET_ALL_POLICIES = "select * from policy where customer_id = ?";
	public static final String GET_POLICY_DETAIL = "select * from policy where policy_id = ?";
	public static final String PolicyUpdateQuery = "Update policy set policy_amount = ?,premium_type = ?,policy_duration = ? where policy_id = ?";
	public static final String AdminloginQuery = "Select * from admin where admin_ID = ? and password = ?";
	public static final String ADMIN_GET_ALL_POLICIES = "Select * from policy where status = 'pending'";
	public static final String ADMIN_GET_SINGLE_POLICIES = "Select * from policy where policy_id=? and status= 'pending'";
	public static final String ADMIN_POLICY_STATUS = "UPDATE policy set status = ? where policy_id = ?";
	public static final String ADMIN_GET_POLICY_STATUS = "Select * from policy where policy_id = ?";
	public static final String CLAIM_GET_SINGLE_POLICIES = "Select * from policy where policy_id=? and status= 'approved'";
	public static final String USER_CLAIM_QUERY = "insert into claim() values();";
	public static String loginQuery = "select * from customer_login_detail where customer_id=? and customer_password=?";

}
