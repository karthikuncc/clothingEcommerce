
package com.clothingcloset.controllers;

import java.util.List;

/**
 * @author Chaitanya Sri Krishna Lolla.
 *This class is responsible for handling the Rest calls from Front end.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clothingcloset.api.Login;
import com.clothingcloset.models.PBLStaff;
import com.clothingcloset.models.Person;
import com.clothingcloset.models.UserLogin;
/**
 * @author Chaitanya Sri Krishna Lolla.
 *This class is responsible for handling the Rest Interface of Login for
 *1) Donars and Customers
 *2) Admin
 *3) Staff Members.
 *4) Person Registration Handling
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	static String email = "";
	@Autowired
	Login login;
	
	// Person Registration Handlers.
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	   public ModelAndView person() {
	      return new ModelAndView("person", "command", new Person());
	   }
	
	@RequestMapping(value= "/registration",method=RequestMethod.POST)
	public String registerPerson(@ModelAttribute("SpringWeb")Person person, 
			   ModelMap model){
		
		String decisionPage = "";
		boolean isRegistered= login.registerPerson(person);
		
		if(isRegistered){
			System.out.println("Registration for the person is successful.");
			decisionPage = "successRegistration";
		}else{
			System.out.println("Registration was not successful.");
			decisionPage = "failureRegistration";
		}
		
		return decisionPage;
		
	}
	
	// Login Implementation for User and Staff Members.
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	   public String login() {
		   return "loginPage";
	   }
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	   public ModelAndView userLogin() {
		
	      return new ModelAndView("userLoginPage", "command", new UserLogin());
	   }
	
	@RequestMapping(value="/validateUser",method = RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute("SpringWeb") UserLogin userLogin){
		boolean isValidUser = login.validateUser(userLogin);
		if(isValidUser){
			System.out.println("Valid User");
			email = userLogin.getEmail();
			return new ModelAndView("donate_or_purchase", "command", new UserLogin());
		}else{
			System.out.println("In valid User");
			return new ModelAndView("userLoginPage", "command", new UserLogin());
		}

	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	   public ModelAndView userLogout() {
		
	      return new ModelAndView("userLoginPage", "command", new UserLogin());
	   }
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String userHome(@ModelAttribute("SpringWeb") UserLogin userLogin){
			return "donate_or_purchase";
		
	}
		
}
