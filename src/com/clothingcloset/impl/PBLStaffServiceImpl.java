package com.clothingcloset.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.clothingcloset.api.PBLStaffService;
import com.clothingcloset.handlers.PBLStaffServiceHandler;
import com.clothingcloset.models.Donation;
import com.clothingcloset.models.Item;
import com.clothingcloset.models.PBLStaff;
import com.clothingcloset.models.Purchases;

@Component
public class PBLStaffServiceImpl implements PBLStaffService {

	PBLStaffServiceHandler pblStaffServiceHandler = new PBLStaffServiceHandler();
	
	@Override
	public String validatePBLStaff(PBLStaff pblStaff) {
		return pblStaffServiceHandler.validateStaffLogin(pblStaff);
		
	}
	
	@Override
	public void insertPBLStaffLoginDetails(PBLStaff pblStaff)  {
		try {
			pblStaffServiceHandler.insertPBLStaffLoginDetails(pblStaff);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PBLStaff> retrieveStaffMembers() {
		return pblStaffServiceHandler.retrieveAllStaffMembers();
		
	}
	
	@Override
	public Boolean removePBLStaff(PBLStaff pblStaff)  {
		Boolean flag=false;
		flag= pblStaffServiceHandler.removePBLStaffMembers(pblStaff);
		return flag;
		
	}

	@Override
	public boolean checkInItem(Donation donation) {
		return pblStaffServiceHandler.checkInItems(donation);
	}

	@Override
	public List<Purchases> displayAllPurchasedItems() {	
		return pblStaffServiceHandler.showAllPurchasedItems();
	}

	@Override
	public List<Item> displayAllItems() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
