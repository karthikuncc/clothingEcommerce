package com.clothingcloset.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.clothingcloset.api.ItemService;
import com.clothingcloset.handlers.ItemServiceHandler;
import com.clothingcloset.models.Item;

@Component
public class ItemServiceImpl implements ItemService{
	
	ItemServiceHandler itemServiceHandler= new ItemServiceHandler();


	@Override
	public List<Item> retrieveAllItemsBasedOnCategory(String categoryName) {
		return itemServiceHandler.retrieveAllItemsBasedOnCategory(categoryName);
	}
	
	@Override
	public void updateQuantity(Integer itemId) {
		 itemServiceHandler.updateQuantity(itemId);
	}

}
