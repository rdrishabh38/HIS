package com.his.BL;

import com.his.DAO.LoginQuery;
import com.his.constants.ErrorConstant;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.CustomerLoginBean;

public class LoginValidation {

	private CustomerLoginBean clb;

	public LoginValidation(CustomerLoginBean clb) {
		super();
		this.clb = clb;
	}

	public void valid() throws HISApplicationException, HISBusinessException {

		String id = clb.getId();
		String pass = clb.getPass();

		if (id.isEmpty() || id == null)
			throw new HISBusinessException(ErrorConstant.EMPTY_ID);

		if (pass.isEmpty() || pass == null)
			throw new HISBusinessException(ErrorConstant.EMPTY_PASSWORD);

		// if(!LoginQuery.isVerified(clb))
		

	}
	
	public static void adminLogin(String ID, String Password) throws HISBusinessException
	{
		if (ID.isEmpty() || ID==null)
			throw new HISBusinessException(ErrorConstant.EMPTY_ID);
		
		if(Password.isEmpty() || Password == null)
			throw new HISBusinessException(ErrorConstant.EMPTY_PASSWORD);
		
	}

}
