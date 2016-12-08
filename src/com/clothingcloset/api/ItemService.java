package com.clothingcloset.api;

import java.util.List;

import com.clothingcloset.models.Item;

public interface ItemService {

	public List<Item> retrieveAllItemsBasedOnCategory(String categoryName);
	
	public void updateQuantity(Integer itemId);
	
}
