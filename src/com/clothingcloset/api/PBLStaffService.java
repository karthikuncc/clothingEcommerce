package com.clothingcloset.api;

import java.util.List;

import com.clothingcloset.models.Donation;
import com.clothingcloset.models.PBLStaff;

public interface PBLStaffService {

	
	public void insertPBLStaffLoginDetails(PBLStaff pblStaff);
	
	public List<PBLStaff> retrieveStaffMembers();
	public String validatePBLStaff(PBLStaff pblStaff);
	public Boolean removePBLStaff(PBLStaff pblStaff);
	public boolean checkInItem(Donation donation);
}
