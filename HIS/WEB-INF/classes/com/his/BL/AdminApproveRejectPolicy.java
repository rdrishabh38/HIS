package com.his.BL;

import com.his.DAO.AdminViewPolicy;
import com.his.constants.ErrorConstant;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.ViewPolicyBean;

public class AdminApproveRejectPolicy {
	
	public static void getPolicyStatus(String pid) throws HISApplicationException, HISBusinessException{
		
		String status=AdminViewPolicy.getPolicyStatus(pid);
		if(!status.equalsIgnoreCase("pending")){
			
			throw new HISBusinessException(ErrorConstant.INVALID_POLICY_APPROVE_REJECT_REQUEST);
		}
	}
	
	
}
