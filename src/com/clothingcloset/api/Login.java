package com.clothingcloset.api;

import java.util.List;

import com.clothingcloset.models.PBLStaff;
import com.clothingcloset.models.Person;
import com.clothingcloset.models.UserLogin;

/**
 * @author Chaitanya Sri Krishna Lolla.
 * This provides this with Login related stuff of the application.
 */
public interface Login {

	public boolean registerPerson(Person person);

	public boolean validateUser(UserLogin userLogin);



}
