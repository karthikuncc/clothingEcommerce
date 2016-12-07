package com.clothingcloset.controllers;

import java.util.ArrayList;
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
import com.clothingcloset.models.Item;
import com.clothingcloset.models.PBLStaff;


@Controller
@RequestMapping("/admin")

public class PBLStaffServiceController {
	

	   @Autowired
	   PBLStaffService pblService;
	   @Autowired
	   DonationService donationService;
	   
	   @RequestMapping(value = "/add_new_member", method = RequestMethod.GET)
	   public ModelAndView add_new_member() {
	      return new ModelAndView("add_new_member", "command", new PBLStaff());
	   }
	   
	   @RequestMapping(value = "/showstaff", method = RequestMethod.GET)
	   public ModelAndView showstaff(ModelMap model) {
		   List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
			model.addAttribute("staffMembers",staffMembers);
	      return new ModelAndView("admin_login", "command", new PBLStaff());
	   }
	   
	   @RequestMapping(value = "/remove_member", method = RequestMethod.GET)
	   public ModelAndView removeMember(ModelMap model) {
		   List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
			model.addAttribute("staffMembers",staffMembers);
	      return new ModelAndView("remove_member", "command", new PBLStaff());
	   }
	   
	   @RequestMapping(value = "/pblStaffLogin", method = RequestMethod.GET)
		public ModelAndView pblStaffLogin(){
			return new ModelAndView("pblStaffLoginPage","command", new PBLStaff());
		}
	   
	   @RequestMapping(value="/validatePBLStaff",method = RequestMethod.POST)
		public String validatePBLStaffMember(@ModelAttribute("SpringWeb") PBLStaff pblStaff,ModelMap model){
			String staffLoginPage = "";
			String pblPosition = pblService.validatePBLStaff(pblStaff);
			if(pblPosition.equalsIgnoreCase("ADMIN")){
				List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
				model.addAttribute("staffMembers",staffMembers);
				staffLoginPage = "admin_login";
				
			}else{
				System.out.println("Staff Member");
				List<Donation> donations = donationService.retrieveDonatedItems();
				//System.out.println("number of unchecked items "+donations.size());
				model.addAttribute("lists",donations);
				staffLoginPage = "member_login";
			//	return new ModelAndView(staffLoginPage,"command", new Item());
			}
			return staffLoginPage;
			
			
		}
	   
	//Admin Login Handling.
		@RequestMapping(value="/admin_login", method = RequestMethod.GET)
		public String retrieveAllStaffMembers(ModelMap model){
			List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
			model.addAttribute("staffMembers",staffMembers);
			return "add_new_member";
			
		}
		
		 @RequestMapping(value = "/logout", method = RequestMethod.GET)
		   public ModelAndView logout() {
		      return new ModelAndView("loginPage", "command", new PBLStaff());
		   }
		 
		  @RequestMapping(value="/removeStaff",method = RequestMethod.POST)
			public String removeStaff(@ModelAttribute("SpringWeb") PBLStaff pblStaff,ModelMap model){
			  
			  Boolean isdelete = pblService.removePBLStaff(pblStaff);  
			return "remove_member";  
		  }
		 
		  @RequestMapping(value="/addStaff",method = RequestMethod.POST)
			public String addstaff(@ModelAttribute("SpringWeb") PBLStaff pblStaff,ModelMap model){
			pblService.insertPBLStaffLoginDetails(pblStaff); 
			List<PBLStaff> staffMembers = pblService.retrieveStaffMembers();
			model.addAttribute("staffMembers",staffMembers);
			return "admin_login";  
		  }
		  
//		  @RequestMapping(value="/checkIn",method = RequestMethod.POST)
//			public String CheckedInItems(@ModelAttribute("itemform")Item item,ModelMap model){
//			Item itemlists = item; 
//			System.out.println(itemlists.getItemName());
//			
//			  //TODO
//			return "member_login";  
//		  } 
//		  
}
