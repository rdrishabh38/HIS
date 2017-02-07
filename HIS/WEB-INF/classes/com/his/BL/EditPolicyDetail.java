package com.his.BL;

import com.his.DAO.EditPolicyQuery;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.ViewPolicyBean;

public class EditPolicyDetail {
	
	public static void validate(ViewPolicyBean vpb) throws HISApplicationException, HISBusinessException{
		EditPolicyQuery.update(vpb);
	}

}
