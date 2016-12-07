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
	   public ModelAndView person() {
	      return new ModelAndView("home_categories", "command", new Item());
	   }
	
	@RequestMapping(value= "/displayAllItems",method=RequestMethod.GET)
	public String getItemsPerCategory(@ModelAttribute("SpringWeb")Item item, 
			   ModelMap model){
		
		List<Item> items = itemService.retrieveAllItemsBasedOnCategory(item.getCategoryName());
		
		for(Item i:items){
			System.out.println(i.toString());
		}
		model.addAttribute("item", new Item()); 
		model.addAttribute("lists",items);	
		return "inside_categories";
		
	}
	
	@RequestMapping(value= "/updateQuantity",method=RequestMethod.GET)
	public String updateQuantity(@ModelAttribute("SpringWeb")Item item, 
			   ModelMap model){
		
		itemService.updateQuantity(item.getItemId());
		List<Item> items = itemService.retrieveAllItemsBasedOnCategory(item.getCategoryName());
		
		for(Item i:items){
			System.out.println(i.toString());
		}
		model.addAttribute("item", new Item()); 
		model.addAttribute("lists",items);	
		return "inside_categories";
		
	}
	
}
