package com.clothingcloset.impl;

import org.springframework.stereotype.Component;

import com.clothingcloset.api.Login;
import com.clothingcloset.handlers.PBLStaffServiceHandler;
import com.clothingcloset.handlers.UserLoginHandler;
import com.clothingcloset.models.Person;
import com.clothingcloset.models.UserLogin;


@Component
public class LoginImpl implements Login {

	// Declarations
	
	UserLoginHandler userLoginHandler = new UserLoginHandler();
	PBLStaffServiceHandler pblStaffLoginHandler = new PBLStaffServiceHandler();
	

	@Override
	public boolean registerPerson(Person person){
		return userLoginHandler.registerPerson(person);
	}

	@Override
	public boolean validateUser(UserLogin userLogin) {
		boolean isValidUser = userLoginHandler.validateUserLogin(userLogin);
		return isValidUser;
	}

}
