package com.clothingcloset.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clothingcloset.api.DonationService;
import com.clothingcloset.api.PBLStaffService;
import com.clothingcloset.models.Donation;

import com.clothingcloset.models.PBLStaff;

@Controller
@RequestMapping("/admin")

public class PBLStaffServiceController {

	@Autowired
	PBLStaffService pblService;
	@Autowired
	DonationService donationService;

	//Adding a New Staff Member.
	@RequestMapping(value = "/add_new_member", method = RequestMethod.GET)
	public ModelAndView add_new_member() {
		return new ModelAndView("add_new_member", "command", new PBLStaff());
	}
	
	@RequestMapping(value = "/addStaff", method = RequestMethod.POST)
	public ModelAndView addstaff(@ModelAttribute("SpringWeb") PBLStaff pblStaff, ModelMap model) {
		pblService.insertPBLStaffLoginDetails(pblStaff);
		List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
		model.addAttribute("staffMembers", staffMembers);
		return new ModelAndView("admin_login", "command", new PBLStaff());
	}

	// Displaying the Staff Member.
	@RequestMapping(value = "/showstaff", method = RequestMethod.GET)
	public ModelAndView showstaff(ModelMap model) {
		List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
		model.addAttribute("staffMembers", staffMembers);
		return new ModelAndView("admin_login", "command", new PBLStaff());
	}

	// Removal of the Staff Member.
	@RequestMapping(value = "/remove_member", method = RequestMethod.GET)
	public ModelAndView removeMember(ModelMap model) {
		List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
		model.addAttribute("staffMembers", staffMembers);
		return new ModelAndView("remove_member", "command", new PBLStaff());
	}
	

	@RequestMapping(value = "/removeStaff", method = RequestMethod.POST)
	public ModelAndView removeStaff(@ModelAttribute("SpringWeb") PBLStaff pblStaff, ModelMap model) {

		Boolean isdelete = pblService.removePBLStaff(pblStaff);
		if(isdelete){
			System.out.println("Staff Members are succesffully removed.");
		}
		List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
		model.addAttribute("staffMembers", staffMembers);
		return new ModelAndView("admin_login", "command", new PBLStaff());
	}


	@RequestMapping(value = "/pblStaffLogin", method = RequestMethod.GET)
	public ModelAndView pblStaffLogin() {
		return new ModelAndView("pblStaffLoginPage", "command", new PBLStaff());
	}

	@RequestMapping(value = "/validatePBLStaff", method = RequestMethod.POST)
	public ModelAndView validatePBLStaffMember(@ModelAttribute("SpringWeb") PBLStaff pblStaff, ModelMap model) {
		String staffLoginPage = "";
		String pblPosition = pblService.validatePBLStaff(pblStaff);
		if (pblPosition.equalsIgnoreCase("ADMIN")) {
			List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
			model.addAttribute("staffMembers", staffMembers);
			staffLoginPage = "admin_login";
			return new ModelAndView(staffLoginPage, "command", new PBLStaff());

		} else {
			System.out.println("Staff Member");
			List<Donation> donations = donationService.retrieveDonatedItems();
			// System.out.println("number of unchecked items
			// "+donations.size());
			model.addAttribute("lists", donations);

			staffLoginPage = "member_login";
			return new ModelAndView(staffLoginPage, "command", new Donation());
		}
		// return staffLoginPage;

	}

	// Admin Login Handling.
	@RequestMapping(value = "/admin_login", method = RequestMethod.GET)
	public String retrieveAllStaffMembers(ModelMap model) {
		List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
		model.addAttribute("staffMembers", staffMembers);
		return "add_new_member";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("loginPage", "command", new PBLStaff());
	}



	// Checkin the Item by a staff member.
	@RequestMapping(value = "/checkIn", method = RequestMethod.POST)
	public ModelAndView checkedInItems(@ModelAttribute("SpringWeb") Donation donation, ModelMap model) {

		boolean isChecked = pblService.checkInItem(donation);
		if (isChecked) {
			System.out.println("Item is inserted and Item is checked");
		} else {
			System.out.println("Check not possible.");
		}

		List<Donation> donations = donationService.retrieveDonatedItems();
		model.addAttribute("lists", donations);
		return new ModelAndView("member_login", "command", new Donation());
	}
	

		  
}
