package com.clothingcloset.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clothingcloset.api.PBLStaffService;
import com.clothingcloset.models.Item;
import com.clothingcloset.models.Purchases;

/**
 * @author Chaitanya Sri Krishna Lolla.
 *This class is responsible for handling the Rest Interface of the Purchases being made.
 */
@Controller
@RequestMapping("/purchases")
public class PurchasesController {

	@Autowired
	PBLStaffService pblStaffService;
	
	@RequestMapping(value = "/showpurchases", method = RequestMethod.POST)
	public ModelAndView showPurchases(ModelMap model) {
	
		List<Purchases> purchases = pblStaffService.displayAllPurchasedItems();
		model.addAttribute("purchases", purchases);
		return new ModelAndView("show_purchases", "command", new Purchases());
	}
	
	@RequestMapping(value="/displayAllItems",method = RequestMethod.POST)
	public ModelAndView showAllItems(ModelMap model){
		List<Item> items = pblStaffService.displayAllItems();
		model.addAttribute("items",items);
		return new ModelAndView("show_items","command",new Item());
	}
	
	
	
	
	
}
