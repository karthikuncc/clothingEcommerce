package com.clothingcloset.handlers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clothingcloset.databaseconnections.ConnectionUtil;
import com.clothingcloset.models.Donation;
import com.mysql.jdbc.ResultSet;

public class DonationHandler {

	ConnectionUtil connectionUtil = new ConnectionUtil();
	public boolean donateItem(Donation donation){	

			Connection conn = null;
			boolean isUserRegistered = false;
			Statement stmt = null;

			try {
				conn = connectionUtil.connectToDatabase();

				System.out.println("Creating statement...");
				stmt = conn.createStatement();

				String sql = "INSERT INTO DONATION_TABLE (EMAIL,DATE_OF_DONATION,CHECKED,ITEM_NAME,SIZE,QUANTITY,COLOR,ITEM_CONDITION,DESCRIPTION,GENDER,BRAND) "
						+"VALUES ('"+donation.getEmail()+"','"+donation.getDateOfDonation()+"',"+donation.getChecked()+",'"
						+donation.getItemName()+"','"+donation.getSize()+"',"+donation.getQuantity()+",'"+donation.getColor()+"','"+donation.getItem_Condition()
						+"','"+donation.getDescription()+"','"+donation.getGender()+"','"+donation.getBrand()+"');";
						

				
				System.out.println("SQL Query is : " + sql);
				stmt.executeUpdate(sql);
				
				isUserRegistered = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return isUserRegistered;

		}
	
	public List<Donation> getDonatedItems(){
		Connection conn = null;
		List<Donation> donations = new ArrayList<Donation>();
		Statement stmt = null;

		try {
			conn = connectionUtil.connectToDatabase();

			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM DONATION_TABLE WHERE CHECKED = 0";

			
			System.out.println("SQL Query is : " + sql);
			ResultSet resultSet = (ResultSet) stmt.executeQuery(sql);
			
			while(resultSet.next()){
				Donation donation = new Donation();
				donation.setId(resultSet.getInt("DONATION_ID"));
				donation.setEmail(resultSet.getString("EMAIL"));
				donation.setDateOfDonation(resultSet.getDate("DATE_OF_DONATION").toString());
				donation.setItemName(resultSet.getString("ITEM_NAME"));
				donation.setSize(resultSet.getString("SIZE"));
				donation.setQuantity(resultSet.getInt("QUANTITY"));
				donation.setColor(resultSet.getString("COLOR"));
				donation.setItem_Condition(resultSet.getString("ITEM_CONDITION"));
				donation.setDescription(resultSet.getString("DESCRIPTION"));
				donation.setGender(resultSet.getString("GENDER"));
				donation.setBrand(resultSet.getString("BRAND"));
				
				donations.add(donation);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		
		return donations;
	}

}
