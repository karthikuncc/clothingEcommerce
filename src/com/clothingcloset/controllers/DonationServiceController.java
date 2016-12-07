package com.clothingcloset.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clothingcloset.api.DonationService;
import com.clothingcloset.models.Donation;

/**
 * @author Chaitanya Sri Krishna Lolla.
 *
 */
@Controller
@RequestMapping("/donate")
public class DonationServiceController {
	
	@Autowired
	DonationService donationService;
	
	@RequestMapping(value = "/donation", method = RequestMethod.GET)
	   public ModelAndView donate() {
	      return new ModelAndView("donation_form", "command", new Donation());
	   }
	
	@RequestMapping(value= "/donateItem",method=RequestMethod.POST)
	public String registerPerson(@ModelAttribute("SpringWeb")Donation donation, 
			   ModelMap model){
		donation.setChecked(0);
		String email = LoginController.email;
		System.out.println("email " +email);
		donation.setEmail(email);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = dateFormat.format(date);
		donation.setDateOfDonation(dateStr);
		boolean isItemsDonated= donationService.donateItems(donation);
		
		if(isItemsDonated){
			System.out.println("DOnation is successfully done, will receive receipt shortly");
		}else{
			System.out.println("Donation is not successful please try again later.");
		}
		
		return "result";
		
	}
	
	@RequestMapping(value="/nonCheckedItems", method = RequestMethod.GET)
	public ModelAndView getNonCheckedItems(){
		return new ModelAndView("donation","command",new Donation());
	}
	
	@RequestMapping(value= "/getNonCheckedItems",method=RequestMethod.POST)
	public String getNonCheckedItems(ModelMap model){
		
		List<Donation> donations = donationService.retrieveDonatedItems();
		model.addAttribute("list",donations);		
		return "result";
		
	}
}
