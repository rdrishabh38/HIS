package com.his.BL;

import com.his.DAO.UserDetailsUpdate;
import com.his.constants.ErrorConstant;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.UserUpdateBean;

public class UserDetailsValidation {

	public static void validate(UserUpdateBean uub)
			throws HISBusinessException, HISApplicationException {
		String firstName = uub.getFirstName();
		String lastName = uub.getLastName();
		String email = uub.getEmail();
		String password = uub.getPassword();
		String phonenumber = uub.getPhonenumber();

		if (firstName.isEmpty() || firstName == null) {
			throw new HISBusinessException(ErrorConstant.EMPTY_FIRST_NAME);
		}
		if (lastName.isEmpty() || lastName == null) {
			throw new HISBusinessException(ErrorConstant.EMPTY_LAST_NAME);
		}
		if (email.isEmpty() || email == null) {
			throw new HISBusinessException(ErrorConstant.EMPTY_EMAIL);
		}
		if (password.isEmpty() || password == null) {
			throw new HISBusinessException(ErrorConstant.EMPTY_PASSWORD);
		}
		if (phonenumber.isEmpty() || phonenumber == null) {
			throw new HISBusinessException(ErrorConstant.EMPTY_PHONENUMBER);
		}

		UserDetailsUpdate.update(uub);
	}
}
