package com.clothingcloset.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clothingcloset.api.ItemService;
import com.clothingcloset.models.Donation;
import com.clothingcloset.models.Item;

/**
 * @author 
 *
 */
@Controller
@RequestMapping("/itemdisplay")
public class ItemServiceController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	   public ModelAndView items() {
	      return new ModelAndView("home_categories", "command", new Item());
	   }
	
	@RequestMapping(value = "/userItems", method = RequestMethod.GET)
	   public ModelAndView userItems() {
	      return new ModelAndView("home_categories_user", "command", new Item());
	   }
	
	@RequestMapping(value= "/displayAllItems",method=RequestMethod.GET)
	public ModelAndView getItemsPerCategory(@ModelAttribute("SpringWeb")Item item, 
			   ModelMap model){
		
		List<Item> items = itemService.retrieveAllItemsBasedOnCategory(item.getCategoryName());
		
		for(Item i:items){
			System.out.println(i.toString());
		}

		model.addAttribute("lists",items);	
		return new ModelAndView("inside_categories", "command", new Item());
		
	}
	
	@RequestMapping(value= "/displayItemsUser",method=RequestMethod.GET)
	public ModelAndView getItemsPerCategoryForUser(@ModelAttribute("SpringWeb")Item item, 
			   ModelMap model){
		
		List<Item> items = itemService.retrieveAllItemsBasedOnCategory(item.getCategoryName());
		
		for(Item i:items){
			System.out.println(i.toString());
		}

		model.addAttribute("lists",items);	
		return new ModelAndView("inside_categories_customer", "command", new Item());
		
	}
	
	@RequestMapping(value= "/updateQuantity",method=RequestMethod.POST)
	public ModelAndView updateQuantity(@ModelAttribute("SpringWeb")Item item, 
			   ModelMap model){
		
		itemService.updateQuantity(item.getItemId());
		item.setCategoryName(item.getItemName());
		List<Item> items = itemService.retrieveAllItemsBasedOnCategory(item.getCategoryName());
		
		for(Item i:items){
			System.out.println(i.toString());
		}

		model.addAttribute("lists",items);	
		return new ModelAndView("inside_categories_customer", "command", new Item());
		
	}
	
}
