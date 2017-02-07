package com.his.BL;

import java.util.List;

import com.his.DAO.ViewPolicyQuery;
import com.his.exceptions.HISApplicationException;
import com.his.model.ViewPolicyBean;

public class ViewPolicyDetail {
	static public List<ViewPolicyBean> allPolicies(String customerId)
			throws HISApplicationException {
		return ViewPolicyQuery.policies(customerId);
	}

}
