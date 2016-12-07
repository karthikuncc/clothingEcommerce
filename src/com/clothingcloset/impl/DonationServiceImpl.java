package com.clothingcloset.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.clothingcloset.api.DonationService;
import com.clothingcloset.handlers.DonationHandler;
import com.clothingcloset.models.Donation;

@Component
public class DonationServiceImpl implements DonationService{

	DonationHandler donationHandler = new DonationHandler();
	@Override
	public boolean donateItems(Donation donation) {
		return donationHandler.donateItem(donation);
	}
	
	@Override
	public List<Donation> retrieveDonatedItems() {
		
		return donationHandler.getDonatedItems();
	}

}
