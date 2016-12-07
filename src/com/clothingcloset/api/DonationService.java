package com.clothingcloset.api;

import java.util.List;

import com.clothingcloset.models.Donation;

public interface DonationService {

	public boolean donateItems(Donation donation);
	
	public List<Donation> retrieveDonatedItems();
}
